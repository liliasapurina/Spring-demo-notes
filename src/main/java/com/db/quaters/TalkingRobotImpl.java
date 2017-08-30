package com.db.quaters;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
public class TalkingRobotImpl implements TalkingRobot {
    private List<Quoter> quoterList;

    @Override
    public void talk() {
        for (Quoter quoter : quoterList) {
            quoter.sayQuote();
        }
    }
}
