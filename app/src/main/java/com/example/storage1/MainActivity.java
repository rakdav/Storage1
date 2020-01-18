package com.example.storage1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class MainActivity extends AppCompatActivity {
    private EditText textWrite;
    private Button buttonWrite;
    private TextView textReader;
    private Button buttonRead;
    private final static String FILE_NAME="content.txt";
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
    private void saveText() {
        FileOutputStream fos=null;
        String t=textWrite.getText().toString();
        try
        {
            fos=new FileOutputStream(FILE_NAME);
            fos.write(t.getBytes());
            Toast.makeText(getApplicationContext(),
                    "Файл успешно сохранен",Toast.LENGTH_SHORT).show();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            if(fos!=null) {
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }


}
