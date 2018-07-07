package com.hai.bt.activity;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.hai.bt.R;
import com.hai.bt.activity.base.BaseActivity;

public class TableLayoutActivity extends BaseActivity {
    TextView tvColor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_table_layout);
        tvColor = findViewById(R.id.tv_color);

    }
    public void setBgRed(View v){
        tvColor.setBackgroundColor(getResources().getColor(R.color.colorRed));
    }
    public void setBgBlue(View v){
        tvColor.setBackgroundColor(getResources().getColor(R.color.colorBlue));
    }
    public void setBgYellow(View v){
        tvColor.setBackgroundColor(getResources().getColor(R.color.colorYellow));
    }
    public void cancel(View v){
        tvColor.setBackgroundColor(Color.BLACK);
    }
}
