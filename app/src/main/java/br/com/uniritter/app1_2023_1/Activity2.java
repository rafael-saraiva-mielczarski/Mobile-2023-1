package br.com.uniritter.app1_2023_1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Activity2 extends AppCompatActivity {

    Button loginBtn;
    EditText inputName, inputPassword;
    String name, password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);
        inputName = findViewById(R.id.TextPersonName);
        inputPassword = findViewById(R.id.TextPassword);
        name = inputName.getText().toString();
        password = inputPassword.getText().toString();
        loginBtn = findViewById(R.id.loginBtn);
        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {onHandleAuth();}
        });
    }
    public void onHandleAuth() {
        Intent intent;
        if(name.equals("admin") && password.equals("123456")){
            intent = new Intent(this, Activity3.class);
        }else {
            intent = new Intent(this, MainActivity.class);
        }
        startActivity(intent);
    }
}
