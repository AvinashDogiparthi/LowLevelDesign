package SOLIDPrinciples.SingleResponsibility.Violation;

public class Report {

    public void generateReport(){
        System.out.println("Generating report ...");
    }

    public void saveFileToDB(){
        System.out.println("Saving file to DB ..");
    }

    public void sendEmail(){
        System.out.println("Sending email ...");
    }
}
