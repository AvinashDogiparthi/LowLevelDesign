package S_TextEditorDesign.Command;

import S_TextEditorDesign.TextEditor;

import java.util.ArrayList;
import java.util.List;
import S_TextEditorDesign.Line;

public class DeleteCommand implements Command {
    private final TextEditor editor;
    private final int from, to;
    private final List<Line> deletedLines = new ArrayList<>();

    public DeleteCommand(TextEditor editor, int from, int to) {
        this.editor = editor;
        this.from = from;
        this.to = to;
    }

    @Override
    public void execute() {
        for (int i = to; i >= from; i--) {
            deletedLines.add(0, editor.getLines().remove(i));
        }
    }

    @Override
    public void undo() {
        for (int i = 0; i < deletedLines.size(); i++) {
            editor.getLines().add(from + i, deletedLines.get(i));
        }
    }
}