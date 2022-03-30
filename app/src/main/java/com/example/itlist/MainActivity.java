package com.example.itlist;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = (Button) findViewById(R.id.createList);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openListHomepgActivity();
            }
        });

    }
    public void openListHomepgActivity(){
        Intent intent = new Intent(this, ListHomepg.class);
        startActivity(intent);
    }
}