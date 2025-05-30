package B_DesignPatterns.N_FlyweightDesignPattern;

public class FlyweightDesignPatterDemo {

    public static void main(String[] args) {
        UserImageFactory userImageFactory = UserImageFactory.getInstance();
        UserImage userImage1 = userImageFactory.getUserImageFromFactory("CommonUserInfo","addressUnknown","baseURL");
        userImage1.setUserName("Avinash");

        UserImage userImage2 = userImageFactory.getUserImageFromFactory("CommonUserInfo","why to type here anyways it will pick address from above one only","will get dont worry");
        userImage2.setUserName("Ajith");
    }
}
