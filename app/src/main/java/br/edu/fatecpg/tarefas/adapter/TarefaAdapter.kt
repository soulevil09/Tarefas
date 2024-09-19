package br.edu.fatecpg.tarefas.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import br.edu.fatecpg.tarefas.R
import br.edu.fatecpg.tarefas.model.Tarefa

class TarefaAdapter(private val tarefas: List<Tarefa>, private val onConcluirClick: (Int) -> Unit) :
    RecyclerView.Adapter<TarefaAdapter.ViewHolder>() {

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val txvNome: TextView = itemView.findViewById(R.id.txv_nome)
        val txvDescricao: TextView = itemView.findViewById(R.id.txv_descricao)
        val btnConcluir: Button = itemView.findViewById(R.id.btn_concluir)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_tarefa, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val tarefa = tarefas[position]
        holder.txvNome.text = tarefa.nome
        holder.txvDescricao.text = tarefa.descricao
        holder.btnConcluir.setOnClickListener {
            onConcluirClick(position)
        }
    }

    override fun getItemCount(): Int {
        return tarefas.size
    }
}
