package com.example.mvpcalculadora.views

import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.mvpcalculadora.R
import com.example.mvpcalculadora.presenter.OperationPresenterImpl
import com.francisco.android.calculadoramvp.interfaces.OperationPresenter
import com.francisco.android.calculadoramvp.interfaces.OperationView
import kotlin.NumberFormatException

class OperationActivityView : AppCompatActivity(), OperationView {

    private lateinit var edtNumber1 : EditText
    private lateinit var edtNumber2 : EditText
    private lateinit var txtResult : TextView
    private lateinit var presenter : OperationPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_operation)

        //creamos una referencia con los elementos de la vista
        edtNumber1 = findViewById(R.id.txtNumber1)
        edtNumber2 = findViewById(R.id.txtNumber2)
        txtResult = findViewById(R.id.txtResult)
        presenter = OperationPresenterImpl(this)
    }

    //metodo para solicitar que se realice la suma
    fun doAdd(view: View) {
        view.setOnClickListener {
            try {
                val num1 : Int = edtNumber1.text.toString().toInt()
                val num2 : Int = edtNumber2.text.toString().toInt()
                presenter.add(num1,num2)
            }catch (e : NumberFormatException){
                invalidOperation()
            }
        }
    }

    //metodo resta
    fun doSubtract(view: View) {
        view.setOnClickListener {
            try {
                val num1 : Int = edtNumber1.text.toString().toInt()
                val num2 : Int = edtNumber2.text.toString().toInt()
                presenter.subtrac(num1,num2)
            }catch ( e:NumberFormatException){
                invalidOperation()
            }
        }
    }

    //Metodo multiplicar
    fun doMultiply(view: View) {
        view.setOnClickListener{
            try{
                val num1 : Int = edtNumber1.text.toString().toInt()
                val num2 : Int = edtNumber2.text.toString().toInt()
                presenter.multiply(num1,num2)
            }catch (e : NumberFormatException){
                invalidOperation()
            }
        }
    }

    //Metodo para dividir
    fun doDivide(view: View) {
        view.setOnClickListener{
            try {
                val num1 : Int = edtNumber1.text.toString().toInt()
                val num2 : Int =  edtNumber2.text.toString().toInt()
                presenter.divide(num1,num2)
            }catch (e : NumberFormatException){
                invalidOperation()
            }
        }
    }

    override fun showResult(result: String) {
        txtResult.text = result
    }
    override fun invalidOperation() {
        Toast.makeText(this,"Operación invalida",Toast.LENGTH_SHORT).show()
    }
}