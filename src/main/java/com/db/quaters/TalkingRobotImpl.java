package com.db.quaters;

import lombok.Getter;
import lombok.Setter;

import javax.annotation.PostConstruct;
import java.util.List;

@Setter
public class TalkingRobotImpl implements TalkingRobot {
    private List<Quoter> quoterList;

    @Override
    // Современная альтернатива init-method="talk" в xml файле
    // Но если при этом есть xml-файл, то в нём обязательно нужно добавить bean CommonAnnotationBeanPostProcessor
    // Или: namespace annotation добавить
    @PostConstruct
    public void talk() {
        for (Quoter quoter : quoterList) {
            quoter.sayQuote();
        }
    }
}
