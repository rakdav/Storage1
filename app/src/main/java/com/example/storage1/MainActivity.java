package com.example.storage1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.FileInputStream;
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
                saveText();
            }
        });
        buttonRead.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    readText();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
    }
    private void saveText() {
        FileOutputStream fos=null;
        String t=textWrite.getText().toString();
        try
        {
            fos=openFileOutput(FILE_NAME,MODE_PRIVATE);
            fos.write(t.getBytes());
            Toast.makeText(getApplicationContext(),
                    "Файл успешно сохранен",Toast.LENGTH_SHORT).show();
        } catch (FileNotFoundException e) {
            Toast.makeText(getApplicationContext(),e.getMessage(),Toast.LENGTH_SHORT).show();
        } catch (IOException e) {
            Toast.makeText(getApplicationContext(),e.getMessage(),Toast.LENGTH_SHORT).show();
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

    private void readText() throws IOException {
        FileInputStream fin=null;
        fin=openFileInput(FILE_NAME);
        byte[] bytes=new byte[fin.available()];
        fin.read(bytes);
        String t=new String(bytes);
        textReader.setText(t);
        if(fin!=null) fin.close();
    }


}
