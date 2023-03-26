package br.com.uniritter.app1_2023_1.Repositories;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import br.com.uniritter.app1_2023_1.models.Posts;

public class PostRepository {
    private Map<Integer, Posts> postsMap;

    //implementação do design Pattern Songleton
    private static PostRepository instance = null;


    // altera o construtor para private -> Singleton
    private PostRepository() {
        this.postsMap = new HashMap<>();
    }

    //implementação do Singleton
    public static PostRepository getInstance() {
        if (instance == null) {
            instance = new PostRepository();
        }
        return instance;
    }


    //inclui um obj User no Repositorio / Map
    public void addPost(Posts post) {
        //falta lançar uma exceção para tratamento -> throws
        if (post != null) {
            this.postsMap.put(post.getId(), post);
        }
    }

    // retorna se um obj User está presento no Mapa
    public boolean contains(Posts post) {
        return this.postsMap.containsValue(post);
    }

    /*
        Nome Método:
        Parametros: nome - objetivo
        Retoro: o que deve retornar
        comportamento:
     */
    // retorna se um obj está presente no Mapa por sei id
    public boolean contains(Integer id) {
        return this.postsMap.containsKey(id);
    }

    // retorna uma Collection com todos os usuários
    public Collection<Posts> getPosts() {
        return this.postsMap.values();
    }
}
