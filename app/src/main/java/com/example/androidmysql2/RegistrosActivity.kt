package com.example.androidmysql2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.Toast
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.Response
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley

class RegistrosActivity : AppCompatActivity() {
    private lateinit var etId: EditText
    private lateinit var etNombre: EditText
    private lateinit var etEmail: EditText
    private lateinit var etTelefono: EditText
    private lateinit var etPass: EditText

    private lateinit var id:String

    lateinit var procesoEnCola:RequestQueue

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registros)

        etNombre = findViewById(R.id.et_Nombre)
        etEmail = findViewById(R.id.et_email)
        etTelefono = findViewById(R.id.et_Telefono)
        etPass = findViewById(R.id.et_Pass)

        etId = findViewById(R.id.et_Id)

        id = intent.getStringExtra("id").toString()

        etId.setText(id)

        cargarDatos()


    }

    fun cargarDatos(){
        val url = "http://192.168.1.3/android_mysql2/consulta.php?id=$id"
        procesoEnCola = Volley.newRequestQueue(this)
        val jsonObjectRequest = object : JsonObjectRequest(Request.Method.GET,url,null,
            Response.Listener { Respuesta->
                etNombre?.setText(Respuesta.getString("nombre"))
                etEmail?.setText(Respuesta.getString("email"))
                etTelefono?.setText(Respuesta.getString("telefono"))
                etPass?.setText(Respuesta.getString("pass"))
               Toast.makeText(this,"Datos obtenidos",Toast.LENGTH_LONG).show()
            },Response.ErrorListener { error->
                Toast.makeText(this,"Error: $error",Toast.LENGTH_LONG).show()
            }
            ){}
            procesoEnCola.add(jsonObjectRequest)
    }

    fun eliminar(Vista: View){

    }



}











