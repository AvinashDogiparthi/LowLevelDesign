package B_DesignPatterns.J_AdapterDesignPattern.Adaptor;

import B_DesignPatterns.J_AdapterDesignPattern.Adaptee.WeightMachine;

public class WeightMachineAdapterImpl implements WeightMachineAdaptor{
    WeightMachine weightMachine;

    public WeightMachineAdapterImpl(WeightMachine weightMachine){
        this.weightMachine = weightMachine;
    }

    @Override
    public double getWeightInKg(){
        double weightInPound = weightMachine.getWeightInPound();

        double weightInKg = weightInPound * .45;
        return weightInKg;
    }
}
