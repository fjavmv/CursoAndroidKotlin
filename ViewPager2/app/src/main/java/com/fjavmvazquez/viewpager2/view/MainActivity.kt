package com.fjavmvazquez.viewpager2.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import androidx.viewpager2.widget.ViewPager2
import com.fjavmvazquez.viewpager2.R
import com.fjavmvazquez.viewpager2.adapter.AdapterFragment
import com.fjavmvazquez.viewpager2.fragment.HomeFragment
import com.fjavmvazquez.viewpager2.fragment.NotasFragment
import com.fjavmvazquez.viewpager2.fragment.NotasRecientesFragment
import com.fjavmvazquez.viewpager2.fragment.NuevaNotaFragment
import com.fjavmvazquez.viewpager2.util.ZoomOutPageTransformer
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import com.google.android.material.tabs.TabLayoutMediator.TabConfigurationStrategy


class MainActivity : FragmentActivity() {
    //Control pager, permite manejar la animación y permite deslizar de manera horizontal
    //Para pazar a la siguiente ventana
    private lateinit var mViewPager2: ViewPager2

    //Page adapter, este provee las paginas que se mostraran en el control pager
    private lateinit var mPageAdapter: FragmentStateAdapter
    private lateinit var mTabLayout: TabLayout
    private val ICON = R.drawable.ic_action_name


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        mViewPager2 = findViewById(R.id.pager)
        mTabLayout = findViewById(R.id.tab_layout)
        //Creamos las intancias de pager y el adaptador
        mPageAdapter = AdapterFragment(supportFragmentManager, lifecycle, loadFragment())
        mViewPager2.adapter = mPageAdapter
        val tabLayoutMediator = TabLayoutMediator(mTabLayout, mViewPager2, TabConfigurationStrategy { tab, position ->
                when (position) {
                    0 -> tab.text = "Inicio"
                    1 -> tab.text = "Notas recientes"
                    2 -> tab.setIcon(ICON)
                    3 -> tab.text = "Notas pasadas"
                    else -> {}
                }
            })
        tabLayoutMediator.attach()
        mViewPager2.setPageTransformer(ZoomOutPageTransformer())
    }

    /*override fun onBackPressed() {

       /*if (mViewPager2.currentItem == 0) {
            super.onBackPressed()
            } else {
            mViewPager2.currentItem = mViewPager2.currentItem - 1
        }*/
    }*/

    private fun loadFragment(): ArrayList<Fragment> {
        val mListAdapter = ArrayList<Fragment>()
        mListAdapter.add(HomeFragment())
        mListAdapter.add(NotasRecientesFragment())
        mListAdapter.add(NuevaNotaFragment())
        mListAdapter.add(NotasFragment())
        return mListAdapter
    }
}

