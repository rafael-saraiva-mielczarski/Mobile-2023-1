package br.com.uniritter.app1_2023_1.Views;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import br.com.uniritter.app1_2023_1.R;

public class Activity2 extends AppCompatActivity {

    Button loginBtn;
    EditText editName, editPassword;
    String name, password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);
        loginBtn = findViewById(R.id.loginBtn);
        loginBtn.setOnClickListener(v -> onHandleAuth());
    }
    public void onHandleAuth() {
        editName = findViewById(R.id.TextPersonName);
        editPassword = findViewById(R.id.editTextPassword);
        name = editName.getText().toString();
        password = editPassword.getText().toString();
        Intent intent;
        if(name.equals("admin") && password.equals("123456")){
            intent = new Intent(this, Activity3.class);
        }else {
            intent = new Intent(this, MainActivity.class);
        }
        startActivity(intent);
    }
}
