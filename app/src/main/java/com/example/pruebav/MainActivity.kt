package com.example.pruebav

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.EditText
import com.google.android.material.snackbar.Snackbar

const val EXTRA_MESSAGE = "com.example.pruebav.MESSAGE"

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //this.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);

    }

    fun navegarSegundaPantalla(view: View){ //objeto en el que se hizo clic para llamar a esta función
        var num1= findViewById<EditText>(R.id.inputN1)
        var num2 = findViewById<EditText>(R.id.inputN2)

        val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager

        if(num1.text.isNullOrBlank() || num2.text.isNullOrBlank()){

            imm.hideSoftInputFromWindow(num1.windowToken, 0) //Para ocultar el teclado al darle al botón y así que se vea el Snackbar
            imm.hideSoftInputFromWindow(num2.windowToken, 0)

            Snackbar.make(view, "¡Debes rellenar ambos campos!", Snackbar.LENGTH_SHORT).show();

        }else{
            //Log.e("A", "ENTRÓ")

            var valorN1 = num1.text.toString().toInt()
            var valorN2 = num2.text.toString().toInt()

            if(valorN1 > 0 && valorN2 > 0){
                var intent = Intent(this, ActividadResultado::class.java).apply {//Contexto, clase (actividad) que va a comenzar
                    putExtra("num1", valorN1) //Se pasan los tipos de datos como extras. Esto lo agrega al intent
                    putExtra("num2", valorN2)
                }
                startActivity(intent)
            }else{

                imm.hideSoftInputFromWindow(num1.windowToken, 0)
                imm.hideSoftInputFromWindow(num2.windowToken, 0)
                //num1.clearFocus()
                //num2.clearFocus()

                Snackbar.make(view, "¡Ninguno de los números puede ser 0!", Snackbar.LENGTH_SHORT).show();
            }
        }
    }
}