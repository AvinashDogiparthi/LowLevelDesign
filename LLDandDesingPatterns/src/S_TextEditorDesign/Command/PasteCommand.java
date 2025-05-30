package S_TextEditorDesign.Command;

import S_TextEditorDesign.TextEditor;
import S_TextEditorDesign.Line;

import java.util.ArrayList;
import java.util.List;

public class PasteCommand implements Command {
    private final TextEditor editor;
    private final int atIndex;
    private final List<Line> clipboardCopy = new ArrayList<>();

    public PasteCommand(TextEditor editor, int atIndex, List<Line> clipboard) {
        this.editor = editor;
        this.atIndex = atIndex;
        for (Line l : clipboard) clipboardCopy.add(l); // Shallow copy
    }

    @Override
    public void execute() {
        editor.getLines().addAll(atIndex, clipboardCopy);
    }

    @Override
    public void undo() {
        for (int i = 0; i < clipboardCopy.size(); i++) {
            editor.getLines().remove(atIndex);
        }
    }
}
