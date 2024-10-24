package com.example.prctica06_menoverflowysharepreferences

import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class NosotrosActivity : AppCompatActivity() {

    private var disfraz: Disfraz = Disfraz()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_nosotros)

        disfraz = intent.getParcelableExtra<Disfraz>("disfraz") ?: Disfraz()
    }

    fun regresar (view: View?){
        when(view?.id){
            R.id.btnRegresar -> finish()
        }
    }
}