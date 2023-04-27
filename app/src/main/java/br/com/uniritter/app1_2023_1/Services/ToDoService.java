package br.com.uniritter.app1_2023_1.Services;

import android.content.Context;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import br.com.uniritter.app1_2023_1.Repositories.ToDoRepository;
import br.com.uniritter.app1_2023_1.models.Todo;

public class ToDoService {
    //cria objeto todos apartir de um JSON
    public static Todo todoFromJson(JSONObject json) {
        Todo todo = null;
        try {
            todo = new Todo(
                    json.getInt("userId"),
                    json.getInt("id"),
                    json.getString("title"),
                    json.getString("completed"));

        } catch (JSONException e) {
            System.out.println("erro no Json. Fogo no parquinho "+e.getMessage());
        }
        return todo;
    }

    //buscar todos os todos no servidor REST
    public static void getAllTodos(Context contexto, ServiceDone callback) {

        JsonArrayRequest request = new JsonArrayRequest(Request.Method.GET,
                "https://jsonplaceholder.typicode.com/todos", null,
                response -> {
                    System.out.println("recebi o retorno!");
                    for (int i = 0; i < response.length(); i++) {
                        try {
                            JSONObject json = response.getJSONObject(i);
                            ToDoRepository.getInstance().addTodo( todoFromJson(json) );
                        } catch (JSONException e) {
                            System.out.println("erro no Json. Fogo no parquinho "+e.getMessage());
                        }
                    }
                    if (callback != null) {
                        callback.onServiceDone();
                    }
                },
                error-> Toast.makeText(contexto, "Ocorreu uma falha na requisição "+error.getMessage(), Toast.LENGTH_LONG).show());
        RequestQueue queue = Volley.newRequestQueue(contexto);
        System.out.println("antes de ir para a queue");
        queue.add(request);
        System.out.println("depois de ir para a queue");
    }

}