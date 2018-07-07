package com.hai.bt.activity;

import android.annotation.SuppressLint;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.hai.bt.R;
import com.hai.bt.activity.base.BaseActivity;

import org.apache.http.client.HttpClient;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.DefaultHttpClient;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class NetworkActivity extends BaseActivity {
    EditText etUrl;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_network);
        etUrl = findViewById(R.id.et_url);
    }
    public void countLine(View v){
        @SuppressLint("StaticFieldLeak")
        AsyncTask<Void,Void,Integer> task = new AsyncTask<Void, Void, Integer>() {
            @Override
            protected Integer doInBackground(Void... voids) {
                HttpURLConnection urlConnection = null;
                try {
                    URL url = new URL(etUrl.getText()+"");
                    urlConnection = (HttpURLConnection)url.openConnection();
                    BufferedReader in = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
                    String line ;
                    int count = 0;
                    while ((line = in.readLine()) != null) {
                        count ++ ;
                    }
                    return count;
                } catch (MalformedURLException e) {
                    Log.e("Bad URL: ",etUrl.getText().toString());
                } catch (IOException e) {
                    Log.e("Error connect : ",etUrl.getText().toString());
                }
                return -1;
            }

            @Override
            protected void onPostExecute(Integer integer) {
                super.onPostExecute(integer);
                Toast.makeText(getBaseContext(),"Count line: "+integer,Toast.LENGTH_SHORT).show();

            }
        };
        task.execute();
    }
    public void countCharacter(View v){
        @SuppressLint("StaticFieldLeak")
        AsyncTask<Void,Void,Integer> task = new AsyncTask<Void, Void, Integer>() {
            @Override
            protected Integer doInBackground(Void... voids) {
                HttpClient client = new DefaultHttpClient();
                HttpGet httpGet = new HttpGet(etUrl.getText().toString());
                ResponseHandler<String> handler = new BasicResponseHandler();
                try {
                    return(client.execute(httpGet, handler).length());
                } catch (IOException e) {
                    e.printStackTrace();
                    return -1;
                }

            }

            @Override
            protected void onPostExecute(Integer integer) {
                super.onPostExecute(integer);
                Toast.makeText(getBaseContext(),"Count character: "+integer,Toast.LENGTH_SHORT).show();

            }
        };
        task.execute();
    }
}
