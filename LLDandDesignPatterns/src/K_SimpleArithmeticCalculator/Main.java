package K_SimpleArithmeticCalculator;

public class Main {
    public static void main(String[] args) {
        ArithmeticExpression three = new Number(3);
        ArithmeticExpression one = new Number(1);
        ArithmeticExpression seven = new Number(7);


        ArithmeticExpression addExpression = new Expression(one,seven, Operation.ADD);
        ArithmeticExpression parentExpression = new Expression(three,addExpression, Operation.MULTIPLY);

        System.out.println(parentExpression.evaluate());
    }
}
