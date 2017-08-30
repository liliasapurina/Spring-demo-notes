package com.db.quaters;


import com.db.quaters.Quoter;

public class ShakeSpearQuoter implements Quoter {
    private String message;

    public void sayQuote() {
        System.out.println("ShakeSpear: \"" + message + "\"");
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
