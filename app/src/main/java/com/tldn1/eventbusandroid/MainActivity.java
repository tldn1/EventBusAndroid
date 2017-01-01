package com.tldn1.eventbusandroid;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import org.greenrobot.eventbus.EventBus;

public class MainActivity extends AppCompatActivity {
    EventBus eventBus = EventBus.getDefault();

    EditText message;
    Button btnSubmit,btnGoTo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        message = (EditText)findViewById(R.id.editText);
        btnSubmit = (Button)findViewById(R.id.button);
        btnGoTo = (Button)findViewById(R.id.button2);


        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String sMessage = message.getText().toString();
                if(sMessage.isEmpty()){
                    Toast.makeText(MainActivity.this, "Please enter some vaule into field!", Toast.LENGTH_SHORT).show();
                }else{
                    eventBus.postSticky(new CustomMessage(sMessage));
                }
            }
        });

        btnGoTo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this,AnotherActivity.class);
                startActivity(i);
            }
        });


    }
}
