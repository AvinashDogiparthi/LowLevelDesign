package B_DesignPatterns.H_StateDesignPattern.TVStates.impl;

import B_DesignPatterns.H_StateDesignPattern.TV;
import B_DesignPatterns.H_StateDesignPattern.TVStates.State;

public class ONState implements State {
    @Override
    public void pressPowerButton(TV tv) {
        tv.setState(new OFFState());
    }

    @Override
    public void changeChannel() {
        System.out.println("Changing channel ....");
    }

    @Override
    public void increaseVolume() {
        System.out.println("Increasing volume ....");
    }
}
