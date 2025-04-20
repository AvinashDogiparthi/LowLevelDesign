package B_DesignPatterns.N_FlyweightDesignPattern;


import N_ZeptoStoreDesign.User;

import java.util.HashMap;
import java.util.Map;

public class UserImageFactory {
    public Map<String, UserImage> userImageCache;
    public static UserImageFactory instance = null;

    public static UserImageFactory getInstance(){
        if(instance == null){
            instance = new UserImageFactory();
            return instance;
        }
        return instance;
    }
    private UserImageFactory(){
        userImageCache = new HashMap<>();
    }

    public UserImage getUserImageFromFactory(String key, String userAddress, String userImageURL){
        if(userImageCache.containsKey(key)){
            return userImageCache.get(key);
        }
        userImageCache.put(key,new UserImage(userAddress, userImageURL));
        return userImageCache.get(key);
    }
}
