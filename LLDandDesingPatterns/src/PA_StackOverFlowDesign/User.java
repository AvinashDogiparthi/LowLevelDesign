package PA_StackOverFlowDesign;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class User {

    private int userId;
    private String userName;
    private int interactionCount;
    private Map<Integer,Question> postedQuestions;
    private Map<Integer,Answer> postedAnswers;

    public User(int userId, String userName) {
        this.userId = userId;
        this.userName = userName;
        this.interactionCount = 0;
        this.postedQuestions = new HashMap<>();
        this.postedAnswers = new HashMap<>();
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getInteractionCount() {
        return interactionCount;
    }

    public void updateInteractionCount(int interactionCount) {
        this.interactionCount = this.interactionCount + interactionCount;
    }

    public Map<Integer, Question> getPostedQuestions() {
        return postedQuestions;
    }

    public Question getPostedQuestion(int questionId){
        return this.postedQuestions.get(questionId);
    }

    public void updatePostedQuestion(int questionId, Question question) {
        this.postedQuestions.put(questionId,question);
    }

    public Map<Integer, Answer> getPostedAnswers() {
        return postedAnswers;
    }

    public Answer getPostedAnswer(int answerId){
        return this.postedAnswers.get(answerId);
    }

    public void updatePostedAnswers(int userId, int answerId,Answer answer,int questionID) {
        this.postedAnswers.put(answerId,answer);
    }

    public void mapPostedAnswerToQuestion(int userID,int postedBy, Answer answer,int questionId){

        Question question = this.postedQuestions.get(questionId);
        question.updateAnswer(postedBy,answer);
    }
}
