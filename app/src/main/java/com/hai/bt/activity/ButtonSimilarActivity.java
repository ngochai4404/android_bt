package com.hai.bt.activity;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.ToggleButton;

import com.hai.bt.R;
import com.hai.bt.activity.base.BaseActivity;

public class ButtonSimilarActivity extends BaseActivity implements RadioGroup.OnCheckedChangeListener, CompoundButton.OnCheckedChangeListener{
    TextView tvColor;
    RadioGroup rgroupColor,rgroupColor2;
    ToggleButton tbtnRed, tbtnBlue, tbtnYellow;
    int mIdRbtnSelect = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_button_similar);
        tvColor = findViewById(R.id.tv_color);
        rgroupColor = findViewById(R.id.rgroup_color);
        rgroupColor2 = findViewById(R.id.rgroup_color2);
        tbtnRed = findViewById(R.id.tbtn_red);
        tbtnBlue = findViewById(R.id.tbtn_blue);
        tbtnYellow = findViewById(R.id.tbtn_yellow);

        tbtnRed.setOnCheckedChangeListener(this);
        tbtnBlue.setOnCheckedChangeListener(this);
        tbtnYellow.setOnCheckedChangeListener(this);
        rgroupColor.setOnCheckedChangeListener(this);
        rgroupColor2.setOnCheckedChangeListener(this);

    }
    public void setRed(View v){
        tvColor.setTextColor(Color.RED);
    }
    public void setBlue(View v){
        tvColor.setTextColor(Color.BLUE);
    }
    public void setColor(View v){
        switch (mIdRbtnSelect){
            case R.id.rbtn_red2:
                tvColor.setTextColor(Color.RED);
                break;
            case R.id.rbtn_blue2:
                tvColor.setTextColor(Color.BLUE);
                break;
            case R.id.rbtn_yellow2:
                tvColor.setTextColor(Color.YELLOW);
                break;
            default:
                break;
        }
    }
    @Override
    public void onCheckedChanged(RadioGroup radioGroup, int i) {
        switch (radioGroup.getCheckedRadioButtonId()){
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
        mIdRbtnSelect = radioGroup.getCheckedRadioButtonId();
    }

    @Override
    public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
        if (!tbtnRed.isChecked() && !tbtnBlue.isChecked() && !tbtnYellow.isChecked()) {
            tvColor.setTextColor(Color.BLACK);
            return;
        }
        else if ( b == true ){
            switch (compoundButton.getId()){
                case R.id.tbtn_red:
                    tvColor.setTextColor(Color.RED);
                    break;
                case R.id.tbtn_blue:
                    tvColor.setTextColor(Color.BLUE);
                    break;
                case R.id.tbtn_yellow:
                    tvColor.setTextColor(Color.YELLOW);
                    break;
                default:
                    break;
            }
        }

    }
}
