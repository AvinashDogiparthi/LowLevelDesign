package S_TextEditorDesign;

public class TextEditorDemo {
    public static void main(String[] args) {
        TextEditor editor = new TextEditor();

        editor.insert(0, "Hello World");
        editor.insert(1, "This is line 2");
        editor.insert(2, "This is line 3");
        System.out.println("--- Display All ---");
        editor.display();

        editor.copy(0, 1);
        editor.paste(2);

        System.out.println("--- After Paste ---");
        editor.display();

        editor.undo();
        System.out.println("--- After Undo ---");
        editor.display();

        editor.redo();
        System.out.println("--- After Redo ---");
        editor.display();
    }
}
