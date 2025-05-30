package S_TextEditorDesign;

import java.util.HashMap;
import java.util.Map;

class CharacterFlyweightFactory {
    private static final Map<String, CharacterFlyweight> flyweights = new HashMap<>();

    public static CharacterFlyweight get(char c, String font, int size, String color) {
        String key = c + font + size + color;
        flyweights.putIfAbsent(key, new CharacterFlyweight(c, font, size, color));
        return flyweights.get(key);
    }
}

