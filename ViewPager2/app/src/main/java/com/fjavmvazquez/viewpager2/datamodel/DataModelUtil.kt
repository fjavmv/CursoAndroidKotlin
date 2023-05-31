package com.fjavmvazquez.viewpager2.datamodel

import com.fjavmvazquez.viewpager2.R

object DataModelUtil {
    private lateinit var sMDataModelNotasArrayList: ArrayList<DataModelNotas>
    private lateinit var listaHome: ArrayList<DataModelHome>
    fun llenar(): ArrayList<DataModelNotas> {
        sMDataModelNotasArrayList = ArrayList()
        sMDataModelNotasArrayList.add(
            DataModelNotas(
                R.drawable.cumple,
                "Mi cumpleaños",
                "Notas de como estuvo tu cumpleaños etc.....",
                "11/12/2020"
            )
        )
        sMDataModelNotasArrayList.add(
            DataModelNotas(
                R.drawable.viaje, "Mi Viaje", "A un mes de mi viaje por x lugar ................",
                "10/10/2022"
            )
        )
        sMDataModelNotasArrayList.add(
            DataModelNotas(
                R.drawable.recuerdos,
                "Buenos recuerdos",
                "Hace unos días encontre unas fotografias que traen buenos recuerdos.......",
                "10/12/2011"
            )
        )
        sMDataModelNotasArrayList.add(
            DataModelNotas(
                R.drawable.juegos,
                "Mi jeugo favorito",
                "Disfruto de jugar este juego desde que estaba en secundaria.............................",
                "27/11/2022"
            )
        )
        return sMDataModelNotasArrayList
    }

    fun llenarRecientes(): ArrayList<DataModelNotas> {
        sMDataModelNotasArrayList = ArrayList()
        sMDataModelNotasArrayList.add(DataModelNotas("Hola", "11/12/2020"))
        sMDataModelNotasArrayList.add(DataModelNotas("Saludos", "10/10/2022"))
        sMDataModelNotasArrayList.add(DataModelNotas("Prueba", "10/12/2011"))
        sMDataModelNotasArrayList.add(DataModelNotas("Mi jeugo favorito", "27/11/2022"))
        sMDataModelNotasArrayList.add(DataModelNotas("Mi cumpleaños", "11/12/2020"))
        sMDataModelNotasArrayList.add(DataModelNotas("Mi Viaje", "10/10/2022"))
        return sMDataModelNotasArrayList
    }

    fun llenarHome(): ArrayList<DataModelHome> {
        listaHome = ArrayList()
        listaHome.add(DataModelHome("Despensa del mes 1", 1000))
        listaHome.add(DataModelHome("Despensa del mes 2", 100))
        listaHome.add(DataModelHome("Despensa del mes 3", 1100))
        listaHome.add(DataModelHome("Despensa del mes 4", 1200))
        listaHome.add(DataModelHome("Despensa del mes 5", 1400))
        listaHome.add(DataModelHome("Despensa del mes 6", 1500))
        listaHome.add(DataModelHome("Despensa del mes 7", 1600))
        listaHome.add(DataModelHome("Despensa del mes 8", 1700))
        listaHome.add(DataModelHome("Despensa del mes 9", 1900))
        return listaHome
    }
}