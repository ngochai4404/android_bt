package com.hai.bt.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.hai.bt.R;
import com.hai.bt.activity.base.BaseActivity;

public class LayoutActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_layout);
    }
    public void openLinearLayout(View v){
        startActivity(new Intent(this,LinearLayoutActivity.class));
    }
    public void openTableLayout(View v){
        startActivity(new Intent(this, TableLayoutActivity.class));
    }
    public void openRelativeLayout(View v){
        startActivity(new Intent(this, RelativeActivity.class));
    }
}
