package br.com.uniritter.app1_2023_1.Services;

import android.content.Context;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;


import br.com.uniritter.app1_2023_1.Repositories.CommentRepository;
import br.com.uniritter.app1_2023_1.models.Comments;

public class CommentService {
    //cria objeto Comments apartir de um JSON
    public static Comments commentFromJson(JSONObject json) {
        Comments comment = null;
        try {
            comment = new Comments(
                    json.getInt("postId"),
                    json.getInt("id"),
                    json.getString("name"),
                    json.getString("email"),
                    json.getString("body"));
        } catch (JSONException e) {
            System.out.println("erro no Json. Fogo no parquinho "+e.getMessage());
        }
        return comment;
    }

    //buscar todos os comments no servidor REST
    public static void getAllComments(Context contexto, ServiceDone callback) {

        JsonArrayRequest request = new JsonArrayRequest(Request.Method.GET,
                "https://jsonplaceholder.typicode.com/comments", null,
                response -> {
                    System.out.println("recebi o retorno!");
                    for (int i = 0; i < response.length(); i++) {
                        try {
                            JSONObject json = response.getJSONObject(i);
                            CommentRepository.getInstance().addComment( commentFromJson(json) );
                        } catch (JSONException e) {
                            System.out.println("erro no Json. Fogo no parquinho "+e.getMessage());
                        }
                    }
                    if (callback != null) {
                        callback.onServiceDone();
                    }
                },
                error->{
                    Toast.makeText(contexto, "Ocorreu uma falha na requisição "+error.getMessage(), Toast.LENGTH_LONG).show();
                });
        RequestQueue queue = Volley.newRequestQueue(contexto);
        System.out.println("antes de ir para a queue");
        queue.add(request);
        System.out.println("depois de ir para a queue");
    }
}