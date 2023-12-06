package com.example.pruebav

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class ActividadResultado : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_actividad_resultado)

        var num1 = intent.getIntExtra("num1", 1)
        var num2 = intent.getIntExtra("num2", 1)

        val mensajeResultado = getString(R.string.lblResultado, num1.toString(), num2.toString(), CalcularMCM(num1, num2).toString())

        val textView = findViewById<TextView>(R.id.txVResultado).apply {
            text = mensajeResultado
        }
    }

    fun CalcularMCD(num1: Int, num2: Int): Int {
        var n1 = num1 //No podía reasignar las variables de los parámetros, por lo que declaré nuevas variables con su valor
        var n2 = num2

        while(n2 != 0){
            val aux = n2
            n2 = n1 % n2
            n1 = aux
        }
        var resultado = n1
        return resultado
    }

    fun CalcularMCM(num1: Int, num2:Int): Int{
        return (num1*num2)/CalcularMCD(num1, num2)
    }



}