package br.com.uniritter.app1_2023_1.Repositories;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import br.com.uniritter.app1_2023_1.models.Comments;

public class CommentRepository {
    private Map<Integer, Comments> commentsMap;

    //implementação do design Pattern Songleton
    private static CommentRepository instance = null;


    // altera o construtor para private -> Singleton
    private CommentRepository() {
        this.commentsMap = new HashMap<>();
    }

    //implementação do Singleton
    public static CommentRepository getInstance() {
        if (instance == null) {
            instance = new CommentRepository();
        }
        return instance;
    }


    //inclui um obj User no Repositorio / Map
    public void addComment(Comments comment) {
        //falta lançar uma exceção para tratamento -> throws
        if (comment != null) {
            this.commentsMap.put(comment.getId(), comment);
        }
    }

    // retorna se um obj User está presento no Mapa
    public boolean contains(Comments comment) {
        return this.commentsMap.containsValue(comment);
    }

    /*
        Nome Método:
        Parametros: nome - objetivo
        Retoro: o que deve retornar
        comportamento:
     */
    // retorna se um obj está presente no Mapa por sei id
    public boolean contains(Integer id) {
        return this.commentsMap.containsKey(id);
    }

    // retorna uma Collection com todos os comments
    public Collection<Comments> getComments() {
        return this.commentsMap.values();
    }
}