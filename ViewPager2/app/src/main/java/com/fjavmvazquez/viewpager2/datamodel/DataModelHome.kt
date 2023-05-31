package com.fjavmvazquez.viewpager2.datamodel

data class DataModelHome(var titulo: String, var monto: Int) {

    override fun toString(): String {
        return "DataModelHOme{" +
                "titulo='" + titulo + '\'' +
                ", monto=" + monto +
                '}'
    }
}