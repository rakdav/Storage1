package com.example.storage1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private EditText textWrite;
    private Button buttonWrite;
    private TextView textReader;
    private Button buttonRead;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textWrite=findViewById(R.id.save_text);
        buttonWrite=findViewById(R.id.saveButton);
        textReader=findViewById(R.id.text);
        buttonRead=findViewById(R.id.buttonRead);
        buttonWrite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        buttonRead.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }


}
