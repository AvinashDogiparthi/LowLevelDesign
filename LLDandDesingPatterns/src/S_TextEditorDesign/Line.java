package S_TextEditorDesign;

import java.util.ArrayList;
import java.util.List;

public class Line {
    private final List<CharacterFlyweight> characters;

    public Line(String content, String font, int size, String color) {
        characters = new ArrayList<>();
        for (char c : content.toCharArray()) {
            characters.add(CharacterFlyweightFactory.get(c, font, size, color));
        }
    }

    public void display() {
        characters.forEach(CharacterFlyweight::display);
        System.out.println();
    }
}

