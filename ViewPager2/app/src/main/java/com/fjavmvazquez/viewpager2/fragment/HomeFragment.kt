package com.fjavmvazquez.viewpager2.fragment

import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.fjavmvazquez.viewpager2.R
import com.fjavmvazquez.viewpager2.adapter.AdapterHome
import com.fjavmvazquez.viewpager2.datamodel.DataModelUtil
import com.github.sundeepk.compactcalendarview.CompactCalendarView
import com.github.sundeepk.compactcalendarview.CompactCalendarView.CompactCalendarViewListener
import com.github.sundeepk.compactcalendarview.domain.Event
import java.text.DateFormat
import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale
import java.util.Objects

class HomeFragment : Fragment() {
    private lateinit var compactCalendar: CompactCalendarView
    private val dateFormatMonth = SimpleDateFormat("dd-MM-yyyy", Locale.getDefault())
    private lateinit var recyclerView: RecyclerView
    private lateinit var textView: TextView

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val rootView = inflater.inflate(R.layout.fragment_home, container, false)
        compactCalendar = rootView.findViewById(R.id.calendar)
        recyclerView = rootView.findViewById(R.id.rviewGastos)
        textView = rootView.findViewById(R.id.txtHeader)
        //Adaptador de recyclerView
        recyclerView.layoutManager = LinearLayoutManager(context,
            LinearLayoutManager.VERTICAL,
            false
        )
        val adapterHome = AdapterHome(DataModelUtil.llenarHome())
        recyclerView.adapter = adapterHome
        compactCalendar.setUseThreeLetterAbbreviation(true)

        //Event ev1 = new Event(Color.BLUE, 1674928620000L, "uno");
        //EEE-MMM-dd-yyyy HH:mm:ss
        val ev1 = Event(Color.RED, fechaALong("30-01-2023")!!, "Pagar a coppel")
        compactCalendar.addEvent(ev1)

        //Event ev2 = new Event(Color.RED, 1674842220000L, "dos");
        val ev2 =
            Event(Color.rgb(26, 188, 156), fechaALong("31-01-2023")!!, "Presupuesto del usuario")
        compactCalendar.addEvent(ev2)
        compactCalendar.setListener(object : CompactCalendarViewListener {
            override fun onDayClick(dateClicked: Date) {
                if (dateFormatMonth.format(dateClicked)
                        .compareTo(milliADate(ev1.timeInMillis)) == 0
                ) {
                    Toast.makeText(
                        context,
                        Objects.requireNonNull(ev1.data).toString(),
                        Toast.LENGTH_SHORT
                    ).show()
                } else {
                    Toast.makeText(context, "No contiene eventos", Toast.LENGTH_SHORT).show()
                }
            }

            override fun onMonthScroll(firstDayOfNewMonth: Date) {
                textView.text = dateFormatMonth.format(firstDayOfNewMonth)
            }
        })
        return rootView
    }

    fun milliADate(milli: Long?): String {
        // Estableciendo formato
        val simple: DateFormat = SimpleDateFormat("dd-MM-yyyy", Locale.getDefault())
        // Creando fecha de milliseconds
        // usando constructor de Date
        val date = Date(milli!!)
        return simple.format(date)
    }

    fun fechaALong(fecha: String): Long? {
        val f = SimpleDateFormat("dd-MM-yyyy", Locale.getDefault())
        var timeInMillis: Long? = null
        try {
            val d = f.parse(fecha)!!
            timeInMillis = d.time
        } catch (e: ParseException) {
            e.printStackTrace()
        }
        return timeInMillis
    }
}