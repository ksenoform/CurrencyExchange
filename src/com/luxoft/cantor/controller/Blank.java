package com.luxoft.cantor.controller;

public class Blank {
    private String enteredAmount;

    public String getAmount() {
        return enteredAmount;
    }

    public void setAmount(String amount) {
        this.enteredAmount = amount;
    }

    @Override
    public String toString() {
        return "Blank [amount=" + enteredAmount + "]";
    }
}
