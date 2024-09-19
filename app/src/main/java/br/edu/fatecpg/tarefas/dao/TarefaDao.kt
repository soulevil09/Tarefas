package br.edu.fatecpg.tarefas.dao

import br.edu.fatecpg.tarefas.model.Tarefa

interface TarefaDao {
    fun adicionarTarefa(tarefa: Tarefa)
    fun obterTarefa():MutableList<Tarefa>
}