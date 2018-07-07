package com.hai.bt.activity;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.hai.bt.R;
import com.hai.bt.activity.base.BaseActivity;

public class LinearLayoutActivity extends BaseActivity implements RadioGroup.OnCheckedChangeListener {
    RadioGroup rgroupColor;
    TextView tvColor;
    int mColor = -1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_linear_layout);
        rgroupColor = findViewById(R.id.rgroup_color);
        tvColor = findViewById(R.id.tv_color);
        rgroupColor.setOnCheckedChangeListener(this);

    }
    public void setColor(View v){
        switch (mColor){
            case R.id.rbtn_red:
                tvColor.setTextColor(Color.RED);
                break;
            case R.id.rbtn_blue:
                tvColor.setTextColor(Color.BLUE);
                break;
            case R.id.rbtn_yellow:
                tvColor.setTextColor(Color.YELLOW);
                break;
            default:
                break;
        }
    }

    public void cancel(View v){
        tvColor.setTextColor(Color.TRANSPARENT);
    }
    @Override
    public void onCheckedChanged(RadioGroup radioGroup, int i) {
        mColor = radioGroup.getCheckedRadioButtonId();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        rgroupColor.setOnCheckedChangeListener(null);
    }
}
