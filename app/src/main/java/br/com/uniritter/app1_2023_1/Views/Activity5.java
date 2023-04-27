package br.com.uniritter.app1_2023_1.Views;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import br.com.uniritter.app1_2023_1.Presenters.UserPresenter;
import br.com.uniritter.app1_2023_1.Presenters.UserPresenterContract;
import br.com.uniritter.app1_2023_1.Presenters.UserPresenterLocal;
import br.com.uniritter.app1_2023_1.R;

public class Activity5 extends AppCompatActivity implements UserPresenterContract.View {

    private RecyclerView rv;
    LinearLayoutManager llm;
    LinearLayoutManager llmh;
    Button buttonBack;
    private UserPresenterContract.Presenter presenter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_5);
        presenter = new UserPresenterLocal(this);
        llm = new LinearLayoutManager(this);
        llmh = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);

        rv = findViewById(R.id.usersRV);
        rv.setLayoutManager(llm);

        buttonBack = findViewById(R.id.back);
        buttonBack.setOnClickListener(v -> {
            Intent intent = new Intent(getApplicationContext(), MainActivity.class);
            startActivity(intent);
        });

        findViewById(R.id.btn_busca_users).setOnClickListener((v) -> {
            if (presenter instanceof UserPresenter) {
                presenter = new UserPresenterLocal(this);

            } else {
                presenter = new UserPresenter(this);

            }
            presenter.getAllUsers();
        });
    }

    @Override
    public void setUsersAdapter(RecyclerView.Adapter adapter) {

        rv.setAdapter(adapter);
    }

    @Override
    public Context getContexto() {
        return this.getApplicationContext();
    }


}