package B_DesignPatterns.H_StateDesignPattern.TVStates.impl;

import B_DesignPatterns.H_StateDesignPattern.TV;
import B_DesignPatterns.H_StateDesignPattern.TVStates.State;

public class OFFState implements State {

    @Override
    public void pressPowerButton(TV tv) {
        tv.setState(new ONState());
    }

    @Override
    public void changeChannel() {
        System.out.println("------------------------ERROR ------------------------------");
        System.out.println("Please turn on Tv to change channel");
    }

    @Override
    public void increaseVolume() {
        System.out.println("------------------------ERROR ------------------------------");
        System.out.println("Please turn on Tv to increase volume");
    }
}
