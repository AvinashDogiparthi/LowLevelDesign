package PA_StackOverFlowDesign;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Question {

    private int questionID;
    private String content;
    private int likesCount;
    private int dislikesCount;
    private Map<Integer,String> comments;
    private Map<Integer,Answer> answerMap;
    private List<String> tags;

    public Question(int questionID, String content, List<String> tags) {
        this.questionID = questionID;
        this.content = content;
        this.likesCount = 0;
        this.dislikesCount = 0;
        this.comments = new HashMap<>();
        this.answerMap = new HashMap<>();
        this.tags = tags;
    }

    public int getQuestionID() {
        return questionID;
    }

    public void setQuestionID(int questionID) {
        this.questionID = questionID;
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

    public void updateDisLikesCount(int dislikesCount) {
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

    public Map<Integer, Answer> getAnswerMap() {
        return answerMap;
    }

    public void updateAnswer(int answerId, Answer answer) {
        this.answerMap.put(answerId,answer);
    }

    public List<String> getTags() {
        return tags;
    }

    public void setTags(List<String> tags) {
        this.tags = tags;
    }

    public void updateTags(String tag){
        this.tags.add(tag);
    }
}
