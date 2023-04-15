package br.com.uniritter.app1_2023_1.Views;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import br.com.uniritter.app1_2023_1.R;
import br.com.uniritter.app1_2023_1.Repositories.CommentRepository;
import br.com.uniritter.app1_2023_1.Repositories.PostRepository;
import br.com.uniritter.app1_2023_1.Repositories.ToDoRepository;
import br.com.uniritter.app1_2023_1.Repositories.UserRepository;
import br.com.uniritter.app1_2023_1.Services.CommentService;
import br.com.uniritter.app1_2023_1.Services.PostsService;
import br.com.uniritter.app1_2023_1.Services.ToDoService;
import br.com.uniritter.app1_2023_1.Services.UserService;
import br.com.uniritter.app1_2023_1.models.User;

public class Activity4 extends AppCompatActivity  {
    private EditText edit;
    private List<User> users = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_4);


        Button btn2_1 = findViewById(R.id.button2_1);
        btn2_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
            }
        });
        edit = findViewById(R.id.edName);
        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET,
                "https://jsonplaceholder.typicode.com/users/2", null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        User user = null;
                        try {
                            user = new User(
                                    response.getInt("id"),
                                    response.getString("name"),
                                    response.getString("username"),
                                    response.getString("email"));
                            edit.setText(user.getName());
                        } catch (JSONException e) {
                            System.out.println("erro no Json. Fogo no parquinho "+e.getMessage());
                        }
                        System.out.println("Chegou");
                    }
                },error->{
            Toast.makeText(this, "Ocorreu uma falha na requisição "+error.getMessage(), Toast.LENGTH_LONG).show();
        });
        RequestQueue queue = Volley.newRequestQueue(this);
        queue.add(request);
        System.out.println("depois do add");
        System.out.println("ainda depois do add");

        Button btn = findViewById(R.id.btn_buscaNomes);
        btn.setOnClickListener(view->{
            getAllUsers();
        });

        Button btn_posts = findViewById(R.id.btn_buscaPosts);
        btn_posts.setOnClickListener(view -> {
            getAllPosts();
        });

        Button btn_comments = findViewById(R.id.btn_buscaComments);
        btn_comments.setOnClickListener(view -> {
            getAllComments();
        });

        Button btn_todos = findViewById(R.id.btn_buscaToDos);
        btn_todos.setOnClickListener(view -> {
            getAllTodos();
        });
    }
    private void getAllUsers() {
        System.out.println("antes->"+UserRepository.getInstance().getUsers());

        UserService.getAllUsers(this, ()->System.out.println("depois->"+ UserRepository.getInstance().getUsers()));
    }

    private void getAllPosts() {
        System.out.println("antes->"+ PostRepository.getInstance().getPosts());

        PostsService.getAllPosts(this, ()->System.out.println("depois->"+ PostRepository.getInstance().getPosts()));
    }

    private void getAllComments() {
        System.out.println("antes->"+ CommentRepository.getInstance().getComments());

        CommentService.getAllComments(this, ()->System.out.println("depois->"+ CommentRepository.getInstance().getComments()));
    }
    private void getAllTodos() {
        System.out.println("antes->"+ ToDoRepository.getInstance().getTodos());

        ToDoService.getAllTodos(this, ()->System.out.println("depois->"+ ToDoRepository.getInstance().getTodos()));
    }
}