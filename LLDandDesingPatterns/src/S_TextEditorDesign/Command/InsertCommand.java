package S_TextEditorDesign.Command;

import S_TextEditorDesign.TextEditor;
import S_TextEditorDesign.Line;

public class InsertCommand implements Command {
    private final TextEditor editor;
    private final int lineIndex;
    private final String text;
    private Line insertedLine;

    public InsertCommand(TextEditor editor, int lineIndex, String text) {
        this.editor = editor;
        this.lineIndex = lineIndex;
        this.text = text;
    }

    @Override
    public void execute() {
        insertedLine = new Line(text, "Arial", 12, "black");
        editor.getLines().add(lineIndex, insertedLine);
    }

    @Override
    public void undo() {
        editor.getLines().remove(insertedLine);
    }
}
