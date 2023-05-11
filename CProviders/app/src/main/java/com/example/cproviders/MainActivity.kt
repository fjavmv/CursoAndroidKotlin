package com.example.cproviders

import android.Manifest
import android.content.pm.PackageManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.CallLog
import android.text.format.DateFormat
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.core.app.ActivityCompat

class MainActivity : AppCompatActivity() {
    private lateinit var activity: AppCompatActivity
    private lateinit var tvLlamadas: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        activity = this
        tvLlamadas = findViewById(R.id.tvLog)

    }

    fun mostrarLlamadas(view: View) {
        view.setOnClickListener { if (checarStatusPermiso()) {
            consultarContentProviderLlamadas()
        } else {
            solicitarPermiso()
        } }
    }

    //gestión de permisos
    fun solicitarPermiso() {
        //READ CALL LOG
        //WRITE CALL LOG
        val solicitarPermisoRCL = ActivityCompat.shouldShowRequestPermissionRationale(activity, Manifest.permission.READ_CALL_LOG)
        val solicitarPermisoWCL = ActivityCompat.shouldShowRequestPermissionRationale(activity, Manifest.permission.WRITE_CALL_LOG)
        if (solicitarPermisoRCL && solicitarPermisoWCL) {
            Toast.makeText(this@MainActivity, "Permisos otorgados", Toast.LENGTH_SHORT).show()
        } else {
            ActivityCompat.requestPermissions(activity, arrayOf(Manifest.permission.READ_CALL_LOG, Manifest.permission.WRITE_CALL_LOG), CODIGO_SOLICITUD_PERMISO)
        }
    }

    fun checarStatusPermiso(): Boolean {
        val permisoRCL = ActivityCompat.checkSelfPermission(this@MainActivity, Manifest.permission.READ_CALL_LOG) == PackageManager.PERMISSION_GRANTED
        val permisoWCL = ActivityCompat.checkSelfPermission(this@MainActivity, Manifest.permission.WRITE_CALL_LOG) == PackageManager.PERMISSION_GRANTED
        return permisoRCL && permisoWCL
    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<String>, grantResults: IntArray) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        when (requestCode) {
            CODIGO_SOLICITUD_PERMISO -> if (checarStatusPermiso()) {
                Toast.makeText(this@MainActivity, "Permisos Activos", Toast.LENGTH_SHORT).show()
                consultarContentProviderLlamadas()
            } else {
                Toast.makeText(this@MainActivity, "No se activo el permiso", Toast.LENGTH_SHORT).show()
            }
        }
    }

    // gestionar las consultas al content provider de llamadas
   private fun consultarContentProviderLlamadas() {
        tvLlamadas.text = " "
        val direccionUriLlamadas = CallLog.Calls.CONTENT_URI
        //NOMBRE, NÚMERO, FECHA, TIPO, DURACIÓN
        val campos = arrayOf(
            CallLog.Calls.CACHED_NAME,
            CallLog.Calls.NUMBER,
            CallLog.Calls.DATE,
            CallLog.Calls.TYPE,
            CallLog.Calls.DURATION)

        val contentResolver = contentResolver
        val registros = contentResolver.query(direccionUriLlamadas, campos, null, null, CallLog.Calls.DATE + " DESC")
        if (registros != null) {
            while (registros.moveToNext()) {
                val nombre = registros.getString(registros.getColumnIndexOrThrow(campos[0]))
                val numero = registros.getString(registros.getColumnIndexOrThrow(campos[1]))
                val fecha = registros.getLong(registros.getColumnIndexOrThrow(campos[2]))
                val tipo = registros.getInt(registros.getColumnIndexOrThrow(campos[3]))
                val duracion = registros.getString(registros.getColumnIndexOrThrow(campos[4]))
                val tipoLlamada: String = when (tipo) {
                    CallLog.Calls.INCOMING_TYPE -> resources.getString(R.string.entrada)
                    CallLog.Calls.MISSED_TYPE -> resources.getString(R.string.perdida)
                    CallLog.Calls.OUTGOING_TYPE -> resources.getString(R.string.salida)
                    else -> resources.getString(R.string.desconocido)
                }
                val detalle = """${resources.getString(R.string.etiqueta_nombre)} $nombre  ${resources.getString(R.string.etiqueta_numero)} $numero ${resources.getString(R.string.etiqueta_fecha)} ${DateFormat.format("dd/mm/yy k:mm", fecha)}    ${resources.getString(R.string.etiqueta_tipo)} $tipoLlamada ${resources.getString(R.string.etiqueta_duracion)} ${duracion}s."""
                tvLlamadas.append(detalle)
            }
        }
        registros?.close()
    }

    companion object {
        private const val CODIGO_SOLICITUD_PERMISO = 1
    }
}