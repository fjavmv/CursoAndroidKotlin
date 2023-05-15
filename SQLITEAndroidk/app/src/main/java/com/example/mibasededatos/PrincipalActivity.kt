package com.example.mibasededatos

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.mibasededatos.view.AdeudoActivity
import com.example.mibasededatos.view.ClienteActivity
import com.example.mibasededatos.view.ConsultarActivity

class PrincipalActivity : AppCompatActivity() {
    /*private EditText mEditTextTitulo;
    private EditText mEditTextFecha; // campo a enlazar con el DatePicker
    private EditText mEditTextContenido;
    //private Spinner mSpinnerTipoNota;*/
    private lateinit var mButtonRegistrarCliente: Button
    private lateinit var mButtonRegistrarAdeudo: Button
    private lateinit var mButtonConsultar: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_principal)

        mButtonRegistrarCliente = findViewById(R.id.btn_registra_cliente)
        mButtonRegistrarAdeudo = findViewById(R.id.btn_registra_adeudo)
        mButtonConsultar = findViewById(R.id.btn_consultar_adeudos)

        mButtonRegistrarCliente.setOnClickListener(View.OnClickListener {
            val intent = Intent(applicationContext, ClienteActivity::class.java)
            startActivity(intent)
        })
        mButtonRegistrarAdeudo.setOnClickListener(View.OnClickListener {
            val intent = Intent(applicationContext, AdeudoActivity::class.java)
            startActivity(intent)
        })
        mButtonConsultar.setOnClickListener(View.OnClickListener {
            val intent = Intent(applicationContext, ConsultarActivity::class.java)
            startActivity(intent)
        })


        /* mEditTextTitulo = findViewById(R.id.edt_titulo);
        mEditTextFecha = findViewById(R.id.edt_fecha);
        //mSpinnerTipoNota = rootView.findViewById(R.id.tipo_mensaje);
        mEditTextContenido = findViewById(R.id.edt_contenido);
        mButtonGuardar = findViewById(R.id.btn_guardar);
        mButtonCancelar = findViewById(R.id.btn_cancelar);

        mEditTextFecha.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mostrarCalendario();
            }
        });*/
    } /*
    private void mostrarCalendario(){
        DatePickerDialog datePickerDialog = new DatePickerDialog(getApplicationContext(),R.style.DatePickerStyle, this, Calendar.getInstance().get(Calendar.YEAR),
                Calendar.getInstance().get(Calendar.MONTH),
                Calendar.getInstance().get(Calendar.DAY_OF_MONTH));
        datePickerDialog.show();
    }

    @Override
    public void onDateSet(DatePicker datePicker, int year, int month, int dayOfMonth) {
        String date = month + "/" + dayOfMonth + "/" + year;
        mEditTextFecha.setText(date);
    }
    }*/
}