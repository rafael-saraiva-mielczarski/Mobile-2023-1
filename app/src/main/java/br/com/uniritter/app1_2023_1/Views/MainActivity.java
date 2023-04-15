package br.com.uniritter.app1_2023_1.Views;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import br.com.uniritter.app1_2023_1.R;
import br.com.uniritter.app1_2023_1.Views.Activity2;
import br.com.uniritter.app1_2023_1.Views.Activity4;
import br.com.uniritter.app1_2023_1.Views.Activity5;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btn1_2 = findViewById(R.id.button1_2);
        Button btn_request = findViewById(R.id.btn_requests);
        Button btn_view_request = findViewById(R.id.btn_view_https);
        btn1_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), Activity2.class);
                startActivity(intent);
            }
        });

        btn_request.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), Activity4.class);
                startActivity(intent);
            }
        });

        btn_view_request.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), Activity5.class);
                startActivity(intent);
            }
        });

    }

    @Override
    public void onClick(View view) {
       if (view.getId() == R.id.button1_2)  {

       }
    }
}