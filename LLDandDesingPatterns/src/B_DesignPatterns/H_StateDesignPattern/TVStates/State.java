package B_DesignPatterns.H_StateDesignPattern.TVStates;

import B_DesignPatterns.H_StateDesignPattern.TV;

public interface State {
    void pressPowerButton(TV tv);
    void changeChannel();
    void increaseVolume();
}
