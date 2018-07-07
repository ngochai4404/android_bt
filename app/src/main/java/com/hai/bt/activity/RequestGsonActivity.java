package com.hai.bt.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.hai.bt.R;
import com.hai.bt.activity.base.BaseActivity;
import com.hai.bt.config.UrlConfig;
import com.hai.bt.http.HttpService;
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RequestGsonActivity extends BaseActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_request_gson);

    }
    public void requestGetParam(View v){
        HttpService requestInterface = new Retrofit.Builder()
            .baseUrl(UrlConfig.URL_LOAN_CACULATOR)
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
            .build().create(HttpService.class);
        requestInterface.getCaculator("{amount: 200000, rate: 6.5, months: 180}")
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io())
            .subscribe(response -> {
                Toast.makeText(getBaseContext(),response.toString(),Toast.LENGTH_SHORT).show();
            }, error -> {
                Toast.makeText(getBaseContext(),"error",Toast.LENGTH_SHORT).show();
            });
    }
    public void requestGet(View v){
        HttpService requestInterface = new Retrofit.Builder()
            .baseUrl(UrlConfig.URL_LOAN_CACULATOR)
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
            .build().create(HttpService.class);
        requestInterface.getCaculator()
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io())
            .subscribe(response -> {
                Toast.makeText(getBaseContext(),"MonthlyPayment: "+response.getMonthlyPayment(),Toast.LENGTH_SHORT).show();
            }, error -> {
                Toast.makeText(getBaseContext(),"error",Toast.LENGTH_SHORT).show();
            });
    }
    public void caculator(View v){
        startActivity(new Intent(this,LoanCaculatorActivity.class));
    }
}
