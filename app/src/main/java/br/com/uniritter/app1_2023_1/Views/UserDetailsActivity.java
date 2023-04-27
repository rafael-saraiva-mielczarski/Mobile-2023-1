package br.com.uniritter.app1_2023_1.Views;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import br.com.uniritter.app1_2023_1.R;

public class UserDetailsActivity extends AppCompatActivity {

    TextView nameTv, usernameTv, emailTv, idTv, addressTv;
    String name, username, email, address;
    Integer id;
    Button btnBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_details);
        btnBack = findViewById(R.id.btn_back);
        btnBack.setOnClickListener(v -> {
            Intent intent = new Intent(getApplicationContext(), Activity5.class);
            startActivity(intent);
        });


        nameTv = findViewById(R.id.user_name);
        usernameTv = findViewById(R.id.user_username);
        emailTv = findViewById(R.id.user_email);
        idTv = findViewById(R.id.user_id);
        addressTv = findViewById(R.id.user_address);

        Intent intent = getIntent();
        name = intent.getExtras().getString("Name");
        username = intent.getExtras().getString("Username");
        email = intent.getExtras().getString("Email");
        id = intent.getExtras().getInt("Id");
        address = intent.getExtras().getString("Address");

        nameTv.setText(name);
        usernameTv.setText(username);
        emailTv.setText(email);
        idTv.setText(id.toString());
        addressTv.setText(address);
    }
}