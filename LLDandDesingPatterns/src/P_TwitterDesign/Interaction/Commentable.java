package P_TwitterDesign.Interaction;

import java.util.List;

public interface Commentable {
    void addComment(String comment);
    boolean removeComments();
    List<String> getComments();
}
