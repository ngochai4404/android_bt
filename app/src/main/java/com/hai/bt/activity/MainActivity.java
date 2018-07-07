package com.hai.bt.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.hai.bt.R;
import com.hai.bt.activity.base.BaseActivity;

public class MainActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void openLayout(View v){
        startActivity(new Intent(this,LayoutActivity.class));
    }
    public void openWigetEvent(View v){
        startActivity(new Intent(this,WigetEventActivity.class));
    }
    public void openButtonSimial(View v){
        startActivity(new Intent(this,ButtonSimilarActivity.class));
    }
    public void openLocalization(View v){
        startActivity(new Intent(this,LocalizationActivity.class));
    }
    public void openRotation(View v){
        startActivity(new Intent(this,RotationActivity.class));
    }
    public void openNetwork(View v){
        startActivity(new Intent(this,NetworkActivity.class));
    }
    public void openRequest(View v){
        startActivity(new Intent(this,RequestGsonActivity.class));
    }
    public void openCustom(View v){
        startActivity(new Intent(this,CustomActivity.class));
    }
}
