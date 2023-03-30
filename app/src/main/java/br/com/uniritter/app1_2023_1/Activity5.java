package br.com.uniritter.app1_2023_1;

import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import br.com.uniritter.app1_2023_1.Adapters.UserAdapter;
import br.com.uniritter.app1_2023_1.Repositories.UserRepository;
import br.com.uniritter.app1_2023_1.Services.UserService;
import br.com.uniritter.app1_2023_1.models.User;

public class Activity5 extends AppCompatActivity {
    private List<User> users = new ArrayList<>();
    private RecyclerView rv;
    LinearLayoutManager llm;
    LinearLayoutManager llmh;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_5);
        llm = new LinearLayoutManager(this);
        llmh = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);

        rv = findViewById(R.id.usersRV);

        findViewById(R.id.button3).setOnClickListener((v) -> {
            if (rv.getLayoutManager() == llm) {
                rv.setLayoutManager(llmh);
            } else {
                rv.setLayoutManager(llm);
            }
        });


        Button btn_busca = findViewById(R.id.btn_TodosUsers);
        btn_busca.setOnClickListener(view -> {
            getAllUsers();
        });
    }

    private void getAllUsers() {
        System.out.println("antes->" + UserRepository.getInstance().getUsers());

        UserService.getAllUsers(this, () -> {

            UserAdapter adapter = new UserAdapter(new ArrayList(UserRepository.getInstance().getUsers()));
            rv.setLayoutManager(llmh);
            rv.setAdapter(adapter);
        });
    }
}