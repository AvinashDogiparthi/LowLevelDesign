package PA_StackOverFlowDesign;

import java.util.HashMap;
import java.util.Map;

public class Answer {

    private int answerId;
    private String content;
    private int likesCount;
    private int dislikesCount;
    private Map<Integer,String> comments;

    public Answer(int answerId, String content) {
        this.answerId = answerId;
        this.content = content;
        this.likesCount = 0;
        this.dislikesCount = 0;
        this.comments = new HashMap<>();
    }

    public int getAnswerId() {
        return answerId;
    }

    public void setAnswerId(int answerId) {
        this.answerId = answerId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getLikesCount() {
        return likesCount;
    }

    public void updateLikesCount(int likesCount) {
        this.likesCount = this.likesCount + likesCount;
    }

    public void like(){
        this.likesCount = this.likesCount + 1;
    }

    public int getDislikesCount() {
        return dislikesCount;
    }

    public void updateDisLikes(int dislikesCount) {
        this.dislikesCount = this.dislikesCount + dislikesCount;
    }

    public void dislike(){
        this.dislikesCount = this.dislikesCount + 1;
    }

    public Map<Integer, String> getComments() {
        return comments;
    }

    public void setComments(Map<Integer, String> comments) {
        this.comments = comments;
    }

    public void addComment(int userID,String comment){
        this.comments.put(userID,comment);
    }
}
