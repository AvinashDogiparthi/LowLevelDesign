package B_DesignPatterns.J_AdapterDesignPattern.Adaptee;

public class WeighMachineForBabies implements WeightMachine{
    @Override
    public double getWeightInPound() {
        return 28;
    }
}
