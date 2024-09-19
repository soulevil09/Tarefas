package br.edu.fatecpg.tarefas.view

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import br.edu.fatecpg.tarefas.R
import br.edu.fatecpg.tarefas.dao.TarefaDaoImpl
import br.edu.fatecpg.tarefas.model.Tarefa
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity() {
    val dao = TarefaDaoImpl()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val edtNome = findViewById<EditText>(R.id.edt_nome)
        val edtDescricao = findViewById<EditText>(R.id.edt_descricao)
        val btnSalvar = findViewById<Button>(R.id.btn_salvar)
        val fabTarefa = findViewById<FloatingActionButton>(R.id.fab_tarefa)
        btnSalvar.setOnClickListener {
            val nome = edtNome.text.toString()
            val descricao = edtDescricao.text.toString()
            val tarefa = Tarefa(nome, descricao)
            dao.adicionarTarefa(tarefa)
            Toast.makeText(this, "tarefa Cadastrada", Toast.LENGTH_SHORT).show()
            edtNome.text.clear()
            edtDescricao.text.clear()
        }
        fabTarefa.setOnClickListener{
            val intent = Intent(this, TarefaActivity::class.java)
            startActivity(intent)
        }

    }
}