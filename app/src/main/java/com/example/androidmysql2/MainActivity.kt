package com.example.androidmysql2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.Toast
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley

class MainActivity : AppCompatActivity() {
    var etId: EditText?=null
    var etNombre: EditText?=null
    var etEmail: EditText?=null
    var etTelefono: EditText?=null
    var etPass: EditText?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        etId = findViewById(R.id.et_Nombre)
        etEmail = findViewById(R.id.et_email)
        etTelefono = findViewById(R.id.et_Telefono)
        etPass = findViewById(R.id.et_Pass)
    }

    fun Guardar(Vista:View){
        val url = "http://192.168.1.3/android_mysql2/insertar.php"
        val procesoEnCola = Volley.newRequestQueue(this)
        var resultadoPost = object: StringRequest(Request.Method.POST,url,
               Response.Listener<String> { respuesta ->
                Toast.makeText(this,"Usuario insertado exitosamente", Toast.LENGTH_LONG).show()
            }, Response.ErrorListener { error->
                Toast.makeText(this,"Error $error",Toast.LENGTH_LONG).show()
            }){

            override fun getParams(): MutableMap<String, String> {
                    val parametro = HashMap<String,String>()
                    parametro.put("nombre", etNombre?.text.toString())
                    parametro.put("email",etEmail?.text.toString())
                    parametro.put("telefono",etTelefono?.text.toString())
                    parametro.put("pass", etPass?.text.toString())

                    return parametro

                }

            }
            etNombre?.setText("")
            etEmail?.setText("")
            etTelefono?.setText("")
            etPass?.setText("")
            procesoEnCola.add(resultadoPost)



        }


}