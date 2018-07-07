package com.hai.bt.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.hai.bt.R;
import com.hai.bt.config.UrlConfig;
import com.hai.bt.http.HttpService;
import com.hai.bt.model.LoanCaculator;
import com.hai.bt.model.LoanInput;
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class LoanCaculatorActivity extends AppCompatActivity {
    TextView tvResult;
    EditText etAmount;
    EditText etRate1, etRate2;
    EditText etMonth;
    LoanInput mInput1,mInput2 ;
    LoanCaculator mResult1,mResult2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loan_caculator);
        tvResult = findViewById(R.id.tv_result);
        etAmount = findViewById(R.id.et_amount);
        etMonth = findViewById(R.id.et_month);
        etRate1 = findViewById(R.id.et_rate1);
        etRate2 = findViewById(R.id.et_rate2);
    }
    public void caculator(View v){
        getResult(1);
        getResult(2);
    }
    public void getResult(int index){
        String rs ;
        if (index == 1) {
            mInput1 = new LoanInput();
            mInput1.setAmount(Integer.parseInt(etAmount.getText().toString()));
            mInput1.setMonths(Integer.parseInt(etMonth.getText().toString()));
            mInput1.setRate(Double.parseDouble(etRate1.getText().toString()));
            rs = mInput1.toString();
        } else {
            mInput2 = new LoanInput();
            mInput2.setAmount(Integer.parseInt(etAmount.getText().toString()));
            mInput2.setMonths(Integer.parseInt(etMonth.getText().toString()));
            mInput2.setRate(Double.parseDouble(etRate2.getText().toString()));
            rs = mInput2.toString();
        }
        HttpService requestInterface = new Retrofit.Builder()
            .baseUrl(UrlConfig.URL_LOAN_CACULATOR)
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
            .build().create(HttpService.class);
        requestInterface.getCaculator(rs)
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io())
            .subscribe(response -> {
                if ( index == 1 ) {
                    mResult1 = response;
                } else {
                    mResult2 = response;
                }
                compareResult();
            }, error -> {
                Toast.makeText(getBaseContext(),"error",Toast.LENGTH_SHORT).show();
            });
    }
    public void compareResult(){
        if ( mResult1!= null && mResult2 != null ) {
            if ( mResult1.getTotalPayments() > mResult2.getTotalPayments() ){
                Toast.makeText(getBaseContext(),"Result: "+mResult2.getTotalPayments(),Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(getBaseContext(),"Result: "+mResult1.getTotalPayments(),Toast.LENGTH_SHORT).show();
            }
            tvResult.setText("Input 1: "+mResult1.getTotalPayments()+"\nInput2: "+mResult2.getTotalPayments());
            mResult1 = null;
            mResult2 = null;
        } else {
            //do nothing
        }
    }
}
