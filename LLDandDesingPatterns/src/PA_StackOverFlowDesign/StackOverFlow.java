package PA_StackOverFlowDesign;

import L_WareHouseManagementDesign.WareHouse;

import java.util.*;

public class StackOverFlow {

    private UserManagementService userManagementService;
    private Map<String, List<Question>> tagsVsQuestion;
    private Map<Integer,Question> mapOfQuestions;
    private static StackOverFlow instance = null;

    private StackOverFlow() {
        this.userManagementService = new UserManagementService();
        this.tagsVsQuestion = new HashMap<>();
        this.mapOfQuestions = new HashMap<>();
    }

    public static StackOverFlow getInstance(){
        if(instance == null){
            instance = new StackOverFlow();
        }

        return instance;
    }

    public void createUser(int userId, String userName){
        userManagementService.addUser(userId,userName);
    }

    public Question postQuestion(int userId,String questionInfo,List<String> tags){

        User user = userManagementService.getUser(userId);
        Question question = null;

        if(Objects.isNull(user)){
            System.out.println("StackOverFlow::postQuestion--no such user found");
        } else {

            tags = new ArrayList<>(tags);
            tags.add(Integer.toString(userId));
            question = new Question(this.mapOfQuestions.size(),questionInfo, tags);
            this.mapOfQuestions.put(question.getQuestionID(), question);
            userManagementService.addQuestion(userId, question.getQuestionID(), question);

            for(String tag : tags){

                if(this.tagsVsQuestion.containsKey(tag)){
                    List<Question> questionList = tagsVsQuestion.get(tag);
                    questionList.add(question);
                } else {
                    List<Question> questionList = new ArrayList<>();
                    questionList.add(question);
                    this.tagsVsQuestion.put(tag,questionList);
                }
            }

            System.out.println("StackOverFlow::postQuestion--successfully posted question");
        }

        return question;
    }

    public void postAnswer(int authorUserId, int userId,int questionId, String answerContent){

        User author = userManagementService.getUser(authorUserId);
        User user = userManagementService.getUser(userId);

        if(Objects.isNull(user)){
            System.out.println("StackOverFlow::postAnswer--no such user exist");
        } else {
            Answer answer = new Answer(user.getPostedAnswers().size(),answerContent);

            author.mapPostedAnswerToQuestion(authorUserId,user.getUserId(),answer,questionId);
            user.updatePostedAnswers(authorUserId,answer.getAnswerId(),answer,questionId);
            System.out.println("StackOverFlow::postAnswer--successfully posted answer");
        }
    }
}
