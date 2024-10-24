package com.example.prctica06_menoverflowysharepreferences

import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class ProductosActivity : AppCompatActivity() {
    private lateinit var ltvProductos: ListView
    private var productoSel: String = "Vampiros"

    private var info = ""

    private var disfraz: Disfraz = Disfraz()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_productos)

        disfraz = intent.getParcelableExtra<Disfraz>("disfraz") ?: Disfraz()

        ltvProductos = findViewById(R.id.ltvProductos)

        val prods = resources.getStringArray(R.array.lstProductos)
        val adpProds = ArrayAdapter(this,R.layout.spinner_color_selected,prods)
        ltvProductos.adapter = adpProds
        ltvProductos.setOnItemClickListener { parent,view,position,id->
            productoSel = parent.getItemAtPosition(position).toString()
            parent.getItemAtPosition(position)
            when(position){
                0 -> info = "Un disfraz oscuro con detalles en terciopelo, sombrero puntiagudo y accesorios como una escoba y maquillaje dramático."
                1 -> info = "Inspirado en la moda de la época victoriana con capa, chaleco elegante y colmillos de vampiro."
                2 -> info = "Un traje ajustado con estampado de huesos que brillan en la oscuridad."
                3 -> info = "Disfraz con alas grandes, cuernos y un tridente, con detalles rojos y negros."
                4 -> info = "Sencillo pero efectivo, con una sábana blanca estilizada y efectos de \"flotación.\""
                5 -> info = "Ropa rasgada, maquillaje de heridas y accesorios como cadenas o armas falsas."
                6 -> info = "Con piel falsa, garras y una máscara de lobo feroz."
                7 -> info = "Inspirado en el Día de Muertos, con vestido colorido y maquillaje de calavera."
                8 -> info = "Con peluca de colores, ropa de circo deteriorada y maquillaje aterrador."
                9 -> info = "Con detalles de telarañas, vestido negro y accesorios como guantes largos y máscara de ojos."
            }
            Toast.makeText(this,"Producto: ${productoSel} || ${info} ",Toast.LENGTH_LONG).show() }
    }
    fun regresar (view: View?){
        when(view?.id){
            R.id.btnRegresar -> finish()
        }
    }
}