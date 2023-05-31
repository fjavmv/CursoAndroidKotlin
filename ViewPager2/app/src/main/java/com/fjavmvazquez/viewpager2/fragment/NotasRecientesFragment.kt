package com.fjavmvazquez.viewpager2.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.fjavmvazquez.viewpager2.R
import com.fjavmvazquez.viewpager2.adapter.AdapterNotasRecientes
import com.fjavmvazquez.viewpager2.datamodel.DataModelUtil

class NotasRecientesFragment : Fragment() {
    private lateinit var mRecyclerView: RecyclerView
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val rootView = inflater.inflate(R.layout.fragment_recientes, container, false)
        mRecyclerView = rootView.findViewById(R.id.recyclerDatos)
        mRecyclerView.setLayoutManager(
            LinearLayoutManager(
                context,
                LinearLayoutManager.VERTICAL,
                false
            )
        )
        val adapterNotasRecientes = AdapterNotasRecientes(DataModelUtil.llenarRecientes())
        mRecyclerView.setAdapter(adapterNotasRecientes)
        return rootView
    }
}