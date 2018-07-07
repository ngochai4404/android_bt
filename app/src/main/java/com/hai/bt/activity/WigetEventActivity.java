package com.hai.bt.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.hai.bt.R;
import com.hai.bt.activity.base.BaseActivity;
import com.hai.bt.custom.ToastCustom;

public class WigetEventActivity extends BaseActivity implements View.OnClickListener{
    Button btnHello, btnGoodbye, btnHello2, btnGoodbye2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wiget_event);
        btnHello = findViewById(R.id.btn_hello);
        btnHello2 = findViewById(R.id.btn_hello2);
        btnGoodbye = findViewById(R.id.btn_goodbye);
        btnGoodbye2 = findViewById(R.id.btn_goodbye2);
        //inner class
        btnHello.setOnClickListener(new ToastCustom(this,getString(R.string.hello)));
        btnGoodbye.setOnClickListener(new ToastCustom(this,getString(R.string.goodbye)));
        //approaches
        btnHello2.setOnClickListener(this);
        btnGoodbye2.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btn_hello2:
                Toast.makeText(getBaseContext(),getString(R.string.hello),Toast.LENGTH_SHORT).show();
                break;
            case R.id.btn_goodbye2:
                Toast.makeText(getBaseContext(),getString(R.string.goodbye),Toast.LENGTH_SHORT).show();
                break;
            default:
                break;
        }
    }

    public void sayHello(View v){
        Toast.makeText(getBaseContext(),getString(R.string.hello),Toast.LENGTH_SHORT).show();
    }
    public void sayGoodbye(View v){
        Toast.makeText(getBaseContext(),getString(R.string.goodbye),Toast.LENGTH_SHORT).show();
    }
}
