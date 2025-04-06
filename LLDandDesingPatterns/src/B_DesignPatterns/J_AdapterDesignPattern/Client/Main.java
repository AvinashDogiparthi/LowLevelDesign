package B_DesignPatterns.J_AdapterDesignPattern.Client;

import B_DesignPatterns.J_AdapterDesignPattern.Adaptee.WeighMachineForBabies;
import B_DesignPatterns.J_AdapterDesignPattern.Adaptor.WeightMachineAdapterImpl;
import B_DesignPatterns.J_AdapterDesignPattern.Adaptor.WeightMachineAdaptor;

public class Main {

    public static void main(String args[]){

        WeightMachineAdaptor weightMachineAdapter = new WeightMachineAdapterImpl(new WeighMachineForBabies());
        System.out.println(weightMachineAdapter.getWeightInKg());
    }
}

