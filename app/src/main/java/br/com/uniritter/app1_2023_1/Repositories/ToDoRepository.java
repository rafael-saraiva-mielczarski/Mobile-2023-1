package br.com.uniritter.app1_2023_1.Repositories;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import br.com.uniritter.app1_2023_1.models.Todo;

public class ToDoRepository {
    private Map<Integer, Todo> todosMap;

    //implementação do design Pattern Songleton
    private static ToDoRepository instance = null;


    // altera o construtor para private -> Singleton
    private ToDoRepository() {
        this.todosMap = new HashMap<>();
    }

    //implementação do Singleton
    public static ToDoRepository getInstance() {
        if (instance == null) {
            instance = new ToDoRepository();
        }
        return instance;
    }


    //inclui um obj User no Repositorio / Map
        public void addTodo(Todo todo) {
        //falta lançar uma exceção para tratamento -> throws
        if (todo != null) {
            this.todosMap.put(todo.getId(), todo);
        }
    }

    // retorna se um obj User está presento no Mapa
    public boolean contains(Todo todo) {
        return this.todosMap.containsValue(todo);
    }

    /*
        Nome Método:
        Parametros: nome - objetivo
        Retoro: o que deve retornar
        comportamento:
     */
    // retorna se um obj está presente no Mapa por sei id
    public boolean contains(Integer id) {
        return this.todosMap.containsKey(id);
    }

    // retorna uma Collection com todos os usuários
    public Collection<Todo> getTodos() {
        return this.todosMap.values();
    }
}
