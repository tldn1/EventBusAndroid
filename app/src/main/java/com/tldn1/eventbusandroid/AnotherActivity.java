package com.tldn1.eventbusandroid;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

public class AnotherActivity extends AppCompatActivity {
    EventBus eventBus = EventBus.getDefault();
    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_another);

        textView = (TextView)findViewById(R.id.textView);


    }


    @Subscribe(sticky = true,threadMode = ThreadMode.MAIN)
    public void onEvent(CustomMessage customMessage){
        textView.setText("Message is "+customMessage.message);
    }

    @Override
    protected void onStart() {
        super.onStart();
        eventBus.register(this);
    }

    @Override
    protected void onStop() {
        super.onStop();
        eventBus.unregister(this);
    }
}
