package B_DesignPatterns.C_FactoryDesignPattern;

import B_DesignPatterns.C_FactoryDesignPattern.Payment.*;
import Utils.SystemDesignConstants;

import Exception.DesignException;
import Exception.DesignErrorEnum;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner userInput = new Scanner(System.in);
        System.out.println("Select Payment Strategy : ");
        String userSelectedPayment = userInput.nextLine();
        PaymentProcessor paymentProcessor = new PaymentProcessor();

//        withoutFactoryDesignPattern(userSelectedPayment, paymentProcessor);
        Payment paymentStrategy = getPaymentStrategy(userSelectedPayment);
        paymentProcessor.processPayment(paymentStrategy);
    }

    private static Payment getPaymentStrategy(String userSelectedPayment){
        return switch (userSelectedPayment) {
            case SystemDesignConstants.HDFC_CREDIT_CARD -> new HDFCCreditCard();
            case SystemDesignConstants.HSBC_CREDIT_CARD -> new HSBCCreditCard();
            case SystemDesignConstants.AMEX_CREDIT_CARD -> new AMEXCreditCard();
            case SystemDesignConstants.PHONE_PAY_PAYMENT -> new PhonePayPayment();
            case SystemDesignConstants.PAY_PAL_PAYMENT -> new PayPalPayment();
            default ->
                    throw new DesignException(DesignErrorEnum.UNKNOWN_PAYMENT_METHOD, "User selected payment method is not available");
        };
    }

    private static void withoutFactoryDesignPattern(String userSelectedPayment, PaymentProcessor paymentProcessor) {
        if(userSelectedPayment.equals(SystemDesignConstants.HDFC_CREDIT_CARD)){
            Payment payment = new HDFCCreditCard();
            paymentProcessor.processPayment(payment);
        } else if (userSelectedPayment.equals(SystemDesignConstants.HSBC_CREDIT_CARD)){
            Payment payment = new HSBCCreditCard();
            paymentProcessor.processPayment(payment);
        } else if (userSelectedPayment.equals(SystemDesignConstants.AMEX_CREDIT_CARD)){
            Payment payment = new AMEXCreditCard();
            paymentProcessor.processPayment(payment);
        } else if (userSelectedPayment.equals(SystemDesignConstants.PAY_PAL_PAYMENT)){
            Payment payment = new PayPalPayment();
            paymentProcessor.processPayment(payment);
        } else if (userSelectedPayment.equals(SystemDesignConstants.PHONE_PAY_PAYMENT)){
            Payment payment = new PhonePayPayment();
            paymentProcessor.processPayment(payment);
        } else {
            throw new DesignException(DesignErrorEnum.UNKNOWN_PAYMENT_METHOD,"User selected payment method is not available");
        }
    }
}
