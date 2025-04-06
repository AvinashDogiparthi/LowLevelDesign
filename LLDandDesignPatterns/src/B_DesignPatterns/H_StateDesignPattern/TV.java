package B_DesignPatterns.H_StateDesignPattern;


import B_DesignPatterns.H_StateDesignPattern.TVStates.State;
import B_DesignPatterns.H_StateDesignPattern.TVStates.impl.OFFState;

public class TV {
    State state;

    public TV(){
        this.state = new OFFState();
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    public void pressPowerButton(){
        state.pressPowerButton(this);
    }

    public void changeChannel() {
        state.changeChannel();
    }

    public void increaseVolume() {
        state.increaseVolume();
    }
}
