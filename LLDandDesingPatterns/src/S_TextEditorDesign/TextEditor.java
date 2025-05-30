package S_TextEditorDesign;

import S_TextEditorDesign.Command.Command;
import S_TextEditorDesign.Command.DeleteCommand;
import S_TextEditorDesign.Command.InsertCommand;
import S_TextEditorDesign.Command.PasteCommand;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class TextEditor {
    private final List<Line> lines = new ArrayList<>();
    private final Stack<Command> undoStack = new Stack<>();
    private final Stack<Command> redoStack = new Stack<>();
    private List<Line> clipboard = new ArrayList<>();

    public List<Line> getLines() {
        return lines;
    }

    public void display() {
        for (Line line : lines) line.display();
    }

    public void display(int n, int m) {
        for (int i = n; i <= m && i < lines.size(); i++) lines.get(i).display();
    }

    public void insert(int n, String text) {
        Command cmd = new InsertCommand(this, n, text);
        cmd.execute();
        undoStack.push(cmd);
        redoStack.clear();
    }

    public void delete(int n) {
        delete(n, n);
    }

    public void delete(int n, int m) {
        Command cmd = new DeleteCommand(this, n, m);
        cmd.execute();
        undoStack.push(cmd);
        redoStack.clear();
    }

    public void copy(int n, int m) {
        clipboard = new ArrayList<>();
        for (int i = n; i <= m && i < lines.size(); i++) clipboard.add(lines.get(i));
    }

    public void paste(int n) {
        Command cmd = new PasteCommand(this, n, clipboard);
        cmd.execute();
        undoStack.push(cmd);
        redoStack.clear();
    }

    public void undo() {
        if (!undoStack.isEmpty()) {
            Command cmd = undoStack.pop();
            cmd.undo();
            redoStack.push(cmd);
        }
    }

    public void redo() {
        if (!redoStack.isEmpty()) {
            Command cmd = redoStack.pop();
            cmd.execute();
            undoStack.push(cmd);
        }
    }
}

