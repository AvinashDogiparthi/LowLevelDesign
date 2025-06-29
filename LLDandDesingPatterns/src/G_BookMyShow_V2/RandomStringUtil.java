package G_BookMyShow_V2;

import java.util.Random;

public class RandomStringUtil {

    public static String generateRandomStringWithUserId(String userId, int randomStringLength) {
        String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        StringBuilder randomString = new StringBuilder(userId + "_");
        Random random = new Random();

        for (int i = 0; i < randomStringLength; i++) {
            int index = random.nextInt(characters.length());
            randomString.append(characters.charAt(index));
        }

        return randomString.toString();
    }
}
