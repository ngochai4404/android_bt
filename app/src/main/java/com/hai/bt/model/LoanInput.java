package com.hai.bt.model;

import com.google.gson.Gson;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Hai on 04/07/2018.
 */

public class LoanInput {
    @SerializedName("amount")
    @Expose
    private Integer amount;
    @SerializedName("rate")
    @Expose
    private Double rate;
    @SerializedName("months")
    @Expose
    private Integer months;

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public Double getRate() {
        return rate;
    }

    public void setRate(Double rate) {
        this.rate = rate;
    }

    public Integer getMonths() {
        return months;
    }

    public void setMonths(Integer months) {
        this.months = months;
    }

    @Override
    public String toString() {
        return new Gson().toJson(this);
    }
}
