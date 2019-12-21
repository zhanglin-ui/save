package com.example.readput;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final EditText editText_xm = findViewById(R.id.edittext_xingming);
        final EditText editText_xh = findViewById(R.id.edittext_xuehao);
        findViewById(R.id.button_insert).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String xm = editText_xm.getText().toString();
                String xh = editText_xh.getText().toString();
                String temp = xm+"-"+xh;
                FileOutputStream out = null;
                BufferedWriter writer = null;
                try{
                    out = openFileOutput("data", Context.MODE_PRIVATE);
                    writer = new BufferedWriter(new OutputStreamWriter(out));
                    writer.write(temp);
                    System.out.println(temp);
                }catch (Exception e){
                    e.printStackTrace();
                }finally {
                    try{
                        writer.close();
                        out.close();
                    }catch (Exception e){
                        e.printStackTrace();
                    }
                }
            }
        });
        findViewById(R.id.button_quert).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,SecondActivity.class);
                startActivity(intent);
            }
        });
    }
}
