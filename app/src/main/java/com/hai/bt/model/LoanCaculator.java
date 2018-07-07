package com.hai.bt.model;

import com.google.gson.Gson;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Hai on 04/07/2018.
 */

public class LoanCaculator {
    @SerializedName("loanPeriodInMonths")
    @Expose
    private Integer loanPeriodInMonths;
    @SerializedName("loanAmount")
    @Expose
    private Integer loanAmount;
    @SerializedName("formattedAnnualInterestRateInPercent")
    @Expose
    private String formattedAnnualInterestRateInPercent;
    @SerializedName("totalPayments")
    @Expose
    private Double totalPayments;
    @SerializedName("currencySymbol")
    @Expose
    private String currencySymbol;
    @SerializedName("annualInterestRateInPercent")
    @Expose
    private Double annualInterestRateInPercent;
    @SerializedName("formattedLoanAmount")
    @Expose
    private String formattedLoanAmount;
    @SerializedName("monthlyPayment")
    @Expose
    private Double monthlyPayment;
    @SerializedName("formattedMonthlyPayment")
    @Expose
    private String formattedMonthlyPayment;
    @SerializedName("formattedLoanPeriodInMonths")
    @Expose
    private String formattedLoanPeriodInMonths;
    @SerializedName("formattedTotalPayments")
    @Expose
    private String formattedTotalPayments;

    public Integer getLoanPeriodInMonths() {
        return loanPeriodInMonths;
    }

    public void setLoanPeriodInMonths(Integer loanPeriodInMonths) {
        this.loanPeriodInMonths = loanPeriodInMonths;
    }

    public Integer getLoanAmount() {
        return loanAmount;
    }

    public void setLoanAmount(Integer loanAmount) {
        this.loanAmount = loanAmount;
    }

    public String getFormattedAnnualInterestRateInPercent() {
        return formattedAnnualInterestRateInPercent;
    }

    public void setFormattedAnnualInterestRateInPercent(String formattedAnnualInterestRateInPercent) {
        this.formattedAnnualInterestRateInPercent = formattedAnnualInterestRateInPercent;
    }

    public Double getTotalPayments() {
        return totalPayments;
    }

    public void setTotalPayments(Double totalPayments) {
        this.totalPayments = totalPayments;
    }

    public String getCurrencySymbol() {
        return currencySymbol;
    }

    public void setCurrencySymbol(String currencySymbol) {
        this.currencySymbol = currencySymbol;
    }

    public Double getAnnualInterestRateInPercent() {
        return annualInterestRateInPercent;
    }

    public void setAnnualInterestRateInPercent(Double annualInterestRateInPercent) {
        this.annualInterestRateInPercent = annualInterestRateInPercent;
    }

    public String getFormattedLoanAmount() {
        return formattedLoanAmount;
    }

    public void setFormattedLoanAmount(String formattedLoanAmount) {
        this.formattedLoanAmount = formattedLoanAmount;
    }

    public Double getMonthlyPayment() {
        return monthlyPayment;
    }

    public void setMonthlyPayment(Double monthlyPayment) {
        this.monthlyPayment = monthlyPayment;
    }

    public String getFormattedMonthlyPayment() {
        return formattedMonthlyPayment;
    }

    public void setFormattedMonthlyPayment(String formattedMonthlyPayment) {
        this.formattedMonthlyPayment = formattedMonthlyPayment;
    }

    public String getFormattedLoanPeriodInMonths() {
        return formattedLoanPeriodInMonths;
    }

    public void setFormattedLoanPeriodInMonths(String formattedLoanPeriodInMonths) {
        this.formattedLoanPeriodInMonths = formattedLoanPeriodInMonths;
    }

    public String getFormattedTotalPayments() {
        return formattedTotalPayments;
    }

    public void setFormattedTotalPayments(String formattedTotalPayments) {
        this.formattedTotalPayments = formattedTotalPayments;
    }

    @Override
    public String toString() {
        return new Gson().toJson(this);
    }
}
