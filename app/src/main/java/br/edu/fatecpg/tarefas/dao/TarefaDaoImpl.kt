package br.edu.fatecpg.tarefas.dao

import br.edu.fatecpg.tarefas.model.Tarefa

class TarefaDaoImpl:TarefaDao {
    companion object{
        private val tarefas = mutableListOf<Tarefa>()
    }
    override fun adicionarTarefa(tarefa: Tarefa) {
        tarefas.add(tarefa)
    }
    override fun obterTarefa(): MutableList<Tarefa>{
        return tarefas
    }
}