package com.hai.bt.http;

import com.hai.bt.model.LoanCaculator;

import io.reactivex.Observable;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Query;

/**
 * Created by Hai on 04/07/2018.
 */

public interface HttpService {
    @Headers("Content-Type: application/json")
    @GET("NetworkingSupport/loan-calculator")
    Observable<LoanCaculator> getCaculator();
    @GET("NetworkingSupport/loan-calculator")
    Observable<LoanCaculator> getCaculator(@Query("loanInputs") String loanInputs);
}
