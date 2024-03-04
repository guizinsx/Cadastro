package com.example.cadastro

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.cadastro.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var amb: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        amb = ActivityMainBinding.inflate(layoutInflater)
        setContentView(amb.root)

        with(amb){
            salvarBt.setOnClickListener{
                val sexoSelecionado = if (amb.masculinoRb.isChecked) "Masculino" else "Feminino"
                val emailChecked = amb.emailCb.isChecked
                var nome = amb.nomeEt.text.toString()
                var fone = amb.foneEt.text.toString()
                var email = amb.emailEt.text.toString()
                var sexo = sexoSelecionado
                var cidade = amb.cidadeEt.text.toString()
                var uf = amb.ufSp.selectedItem.toString()
                val formulario = Formulario(
                    nome, fone, email,emailChecked, sexo, cidade , uf
                )
                println(formulario)
                "Formulario: ${formulario}, ".also {
                    Toast.makeText(
                        this@MainActivity,
                        it,
                        Toast.LENGTH_SHORT
                    ).show()

                }

                limparBt.setOnClickListener {
                    nomeEt.text.clear()
                    foneEt.text.clear()
                    emailEt.text.clear()
                    cidadeEt.text.clear()
                    emailCb.isChecked = false
                    masculinoRb.isChecked = false
                    femininoRb.isChecked = false
                    ufSp.setSelection(0)
                }
            }
        }
    }
}