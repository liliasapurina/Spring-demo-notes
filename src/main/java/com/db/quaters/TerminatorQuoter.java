package com.db.quaters;

import lombok.Setter;
import java.util.List;

public class TerminatorQuoter implements Quoter {
    @Setter
    private List<String> messages;

    public void sayQuote() {
        messages.forEach(x -> System.out.println("Terminator: \"" + x + "\""));
    }
}
