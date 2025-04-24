package com.example.task52citube;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    EditText etUsername, etPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etUsername = findViewById(R.id.etUsername);
        etPassword = findViewById(R.id.etPassword);

        findViewById(R.id.btnLogin).setOnClickListener(v -> {
            // Mock login
            String user = etUsername.getText().toString().trim();
            if (!user.isEmpty()) {
                Intent i = new Intent(this, HomeActivity.class);
                i.putExtra("username", user);
                startActivity(i);
            } else {
                Toast.makeText(this, "Enter valid username", Toast.LENGTH_SHORT).show();
            }
        });

        findViewById(R.id.btnSignup).setOnClickListener(v -> {
            startActivity(new Intent(this, SignUpActivity.class));
        });
    }
}
