package V_HotelManagementSystem;

import java.util.Random;

public class RandomStringGenerator {

    public static String generateRandomString(String userID, String hotelID, String roomID, int randomStringLength) {
        String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        StringBuilder randomString = new StringBuilder(userID + "_" + hotelID + "_" + roomID + "_");
        Random random = new Random();

        for (int i = 0; i < randomStringLength; i++) {
            int index = random.nextInt(characters.length());
            randomString.append(characters.charAt(index));
        }

        return randomString.toString();
    }
}
