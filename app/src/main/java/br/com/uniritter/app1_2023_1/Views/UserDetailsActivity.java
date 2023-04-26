package br.com.uniritter.app1_2023_1.Views;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import br.com.uniritter.app1_2023_1.R;

public class UserDetailsActivity extends AppCompatActivity {

    TextView name, username, email, id, address;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_details);

        name = findViewById(R.id.user_name);
        username = findViewById(R.id.user_username);
        email = findViewById(R.id.user_email);
        id = findViewById(R.id.user_id);
        address = findViewById(R.id.user_address);
    }
}