package com.example.mobileapp14;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private ImageView imageStatus;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnCheck = findViewById(R.id.btn_check);
        imageStatus = findViewById(R.id.image_status);

        btnCheck.setOnClickListener(v -> {

            if (isConnectedToInternet()) {
                imageStatus.setImageResource(R.drawable.wifi);
                imageStatus.setVisibility(View.VISIBLE);
                Toast.makeText(MainActivity.this,
                        "Есть подключение к интернету", Toast.LENGTH_SHORT).show();
            } else {
                imageStatus.setImageResource(R.drawable.nowifi);
                imageStatus.setVisibility(View.VISIBLE);
                Toast.makeText(MainActivity.this,
                        "Подключение к интернету отсутствует", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private boolean isConnectedToInternet() {
        ConnectivityManager cm = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        if (cm != null) {
            NetworkInfo activeNetwork = cm.getActiveNetworkInfo();
            return activeNetwork != null;
        }
        return false;
    }
}
