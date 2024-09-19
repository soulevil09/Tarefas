package br.edu.fatecpg.tarefas.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import br.edu.fatecpg.tarefas.R
import br.edu.fatecpg.tarefas.adapter.TarefaAdapter
import br.edu.fatecpg.tarefas.dao.TarefaDaoImpl

class TarefaActivity : AppCompatActivity() {

    private val dao = TarefaDaoImpl()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tarefa)

        val recyclerView = findViewById<RecyclerView>(R.id.recycler_view_tarefas)
        recyclerView.layoutManager = LinearLayoutManager(this)

        val adapter = TarefaAdapter(dao.obterTarefa()) { position ->
            dao.obterTarefa().removeAt(position)
            recyclerView.adapter?.notifyItemRemoved(position)
        }


        recyclerView.adapter = adapter
    }
}
