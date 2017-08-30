package com.db.quoters;

import lombok.Setter;

import java.util.List;

/**
 * Created by Evegeny on 30/08/2017.
 */

@DeprecatedClass(T1000.class)
public class TerminatorQuoter implements Quoter {

    @Setter
    private List<String> messages;

    @Override
    public void sayQuote() {
        messages.forEach(System.out::println);
    }


    public void killAll(){
        System.out.println("your are terminated....");
    }
}
