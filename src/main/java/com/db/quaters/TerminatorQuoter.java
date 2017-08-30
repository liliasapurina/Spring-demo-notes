package com.db.quaters;

import lombok.Setter;
import java.util.List;

public class TerminatorQuoter implements Quoter {
    @Setter
    private List<String> messages;
    @InjectRandomInt(min = 5, max = 10)
    int age;

    public void sayQuote() {
        messages.forEach(x -> System.out.println("Terminator: \"" + x + "\"; " + "age = " + age));
    }
}
