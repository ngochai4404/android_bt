package com.hai.bt.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.hai.bt.R;
import com.hai.bt.activity.base.BaseActivity;

import java.util.ArrayList;
import java.util.List;

public class RotationActivity extends BaseActivity {
    final String TEXT= "TEXT";
    LinearLayout llRoot;
    EditText etText;
    ArrayList<String> arr;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rotation);
        arr = new ArrayList<>();
        llRoot = findViewById(R.id.ll_array);
        etText = findViewById(R.id.et_text);

    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        arr = savedInstanceState.getStringArrayList(TEXT);
        restoreText(arr);
    }

    public void addText(View v){
        TextView mTextView = new TextView(this);
        mTextView.setText(etText.getText());
        arr.add(etText.getText()+"");
        llRoot.addView(mTextView);
    }
    public void restoreText(List<String> t){
        for (String s: t) {
            TextView mTextView = new TextView(this);
            mTextView.setText(s);
            llRoot.addView(mTextView);
        }
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        outState.putStringArrayList(TEXT,arr);
        super.onSaveInstanceState(outState);
    }
}
