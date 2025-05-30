package S_TextEditorDesign;

import java.util.Objects;

class CharacterFlyweight {
    private final char character;
    private final String font;
    private final int size;
    private final String color;

    public CharacterFlyweight(char character, String font, int size, String color) {
        this.character = character;
        this.font = font;
        this.size = size;
        this.color = color;
    }

    public void display() {
        System.out.print(character);
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof CharacterFlyweight)) return false;
        CharacterFlyweight other = (CharacterFlyweight) obj;
        return character == other.character && font.equals(other.font) &&
                size == other.size && color.equals(other.color);
    }

    @Override
    public int hashCode() {
        return Objects.hash(character, font, size, color);
    }

    public char getCharacter() {
        return character;
    }

    public String getFont() {
        return font;
    }

    public int getSize() {
        return size;
    }

    public String getColor() {
        return color;
    }
}

