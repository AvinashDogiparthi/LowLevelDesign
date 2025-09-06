package PA_StackOverFlowDesign;

import java.security.spec.RSAOtherPrimeInfo;
import java.util.Arrays;
import java.util.Objects;

public class StackOverFlowDemo {

    public static void main(String[] args) {

        StackOverFlow stackOverFlow = StackOverFlow.getInstance();

        stackOverFlow.createUser(11,"Avinash");
        Question question = stackOverFlow.postQuestion(11,"How to go to japan?", Arrays.asList("Japan","Travel","Visa"));

        if(Objects.isNull(question)){
            System.out.println("Something wrong happened, please fix it");
        }
        stackOverFlow.createUser(12,"Vamshi");
        stackOverFlow.postAnswer(11,12, question.getQuestionID(), "why are you planning to go to japan bro?");
    }
}
