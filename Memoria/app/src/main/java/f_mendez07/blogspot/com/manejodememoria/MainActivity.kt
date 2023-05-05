package f_mendez07.blogspot.com.manejodememoria

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import java.io.FileOutputStream

class MainActivity : AppCompatActivity() {
    private  lateinit var editText1: EditText
    private lateinit var editText2: EditText
    private lateinit var button1: Button
    private lateinit var button2: Button
    private lateinit var button3: Button
    private lateinit var textView: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        button1 = findViewById(R.id.btn1)
        button2 = findViewById(R.id.btn2)
        button3 = findViewById(R.id.btn3)

        button1.setOnClickListener{ generarArchivo() }
        button2.setOnClickListener{ preferencias() }
        button3.setOnClickListener{ mostrarPreferencia()}
    }

    private fun generarArchivo() {
        try {
            editText1 = findViewById(R.id.edt1)
            val nombre = editText1.text.toString()
            val fileOutputStream: FileOutputStream = openFileOutput("MiArchivo.txt", MODE_PRIVATE)
            fileOutputStream.write(nombre.toByteArray())
            fileOutputStream.close()
            Toast.makeText(this@MainActivity, "Archivo creado", Toast.LENGTH_SHORT).show()
            editText1.setText("")
        } catch (e: Exception) {
            e.printStackTrace()
            Toast.makeText(this@MainActivity, "Hubo un error en la escritura", Toast.LENGTH_SHORT)
                .show()
        }
    }

    private fun preferencias() {
        editText2 = findViewById(R.id.edt2)
        editText1 = findViewById(R.id.edt1)
        val nombre = editText1.text.toString()
        val correo = editText2.text.toString()
        val mipreferencia = getSharedPreferences("MisDatos", MODE_PRIVATE)
        val editor = mipreferencia.edit()
        editor.putString("nombre", nombre)
        editor.putString("correo", correo)
        editor.apply()
    }

    private fun mostrarPreferencia() {
        textView = findViewById(R.id.tvMostrar)
        val mipreferencia = getSharedPreferences("MisDatos", MODE_PRIVATE)
        val nombre = mipreferencia.getString("nombre", "No existe esa variable")
        val correo = mipreferencia.getString("correo", "No existe esa variable")
        val preferencia = "Nombre: $nombre\nCorreo: $correo"
        textView.text = preferencia
    }
}