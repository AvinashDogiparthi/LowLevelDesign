package CronParserDesign;

import CronParserDesign.CronParserService;

public class CronParserDemo {

    public static void main(String[] args) {
        CronParserService cronParserService = new CronParserService();
        try {
            cronParserService.parseCronExpression("* * * * *");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        try {
            cronParserService.parseCronExpression("2-5/2 11-14/3 1,2,5,8,9,11-28/2 FEB-DEC MON-FRI");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        try {
            cronParserService.parseCronExpression("2-5/2 11-14/3 1,2,5,8,9,11-28/2 FEB-DEC 1-4");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        try {
            cronParserService.parseCronExpression("1-59/10 11,12,13,15,19,20-23/2 * JAN-JUN/2 MON-SUN/3");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        try {
            cronParserService.parseCronExpression("1-5$/10 11,12,13,15,19,20-23/2 * JAN-JUN/2 MON-SUN/3");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        try {
            cronParserService.parseCronExpression("1 1-59/10 11,12,13,15,19,20-23/2 ? JAN-JUN/2 MON-SUN/3 2025");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
