package com.example.task52citube;

import android.os.Bundle;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class SignUpActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        findViewById(R.id.btnCreateAccount).setOnClickListener(v -> {
            Toast.makeText(this, "Account Created!", Toast.LENGTH_SHORT).show();
            finish();
        });
    }
}
