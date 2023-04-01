package com.example.calculadoradenotas

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import com.squareup.picasso.Picasso
import kotlin.math.roundToInt

lateinit var nombre: TextView
    lateinit var cl1: TextView
    lateinit var cl2: TextView
    lateinit var cl3: TextView
    lateinit var sp1: TextView
    lateinit var cal: Button
    lateinit var lim: Button
    lateinit var imgres: ImageView
    lateinit var txtres: TextView

    fun calcular(v:View){
        var imgURL = ""
        val nombre = nombre.text.toString()
        val cl1 = cl1.text.toString().toDouble()
        val cl2 = cl2.text.toString().toDouble()
        val cl3 = cl3.text.toString().toDouble()
        val sp1 = sp1.text.toString().toDouble()

        val nota = (((cl1 * 0.15) + (cl2 * 0.20) + (cl3 * 0.35) + (sp1 * 0.30)) * 100.0).roundToInt() / 100.0
        //Toast.makeText(this, "Hola $nombre, Tu nota es: $nota",Toast.LENGTH_LONG).show()
        if (nota >= 13){
            imgURL = "https://img.freepik.com/vector-premium/simbolo-e-icono-marca-verificacion-verde-concepto-diseno-aprobado-grafico-web-sobre-fondo-blanco_549897-1091.jpg"
        }
        else {
            imgURL = "https://thumbs.dreamstime.com/b/marcas-err%C3%B3neas-de-cruce-rechazadas-no-aprobadas-falsas-elecciones-incorrectas-finalizaci%C3%B3n-la-tarea-votar-s%C3%ADmbolos-marca-198897646.jpg"
        }
        txtres.setText("Tu nota actual es: $nota")
        Picasso.get().load(imgURL).into(imgres)
    }

    fun limpiar(v:View){
        var imgEmpty = ""
        nombre.setText(null)
        cl1.setText(null)
        cl2.setText(null)
        cl3.setText(null)
        txtres.setText("Tu nota es:")
        nombre.requestFocus()
    }

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        nombre = findViewById(R.id.editTextNombre)
        cl1 = findViewById(R.id.editTextCl1)
        cl2 = findViewById(R.id.editTextCl2)
        cl3 = findViewById(R.id.editTextSp1)
        sp1 = findViewById(R.id.editTextSp1)
        cal = findViewById(R.id.buttonCalcular)
        lim = findViewById(R.id.buttonLimpiar)
        imgres = findViewById(R.id.imageViewResultado)
        txtres = findViewById(R.id.textViewResultado)

        cal.setOnClickListener(View.OnClickListener {
            calcular(it)
        })

        lim.setOnClickListener(View.OnClickListener {
            limpiar(it)
        })
    }
}