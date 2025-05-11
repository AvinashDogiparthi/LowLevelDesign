package P_TwitterDesign;

import P_TwitterDesign.Interaction.Interaction;

import java.util.HashMap;
import java.util.Map;

public class User {

    private int userId;
    private String userName;
    private Map<Integer,Tweet> tweetsMap;
    private Map<Integer, Interaction> userInteractions;
    private Map<Integer, User> userFollowingList;
    private Map<Integer, User> userFollowersList;
    private FeedGenerationStrategy feedGenerationStrategy;

    public User(int userId, String userName){
        this.userId = userId;
        this.userName = userName;
        this.tweetsMap = new HashMap<>();
        this.userInteractions = new HashMap<>();
        this.userFollowersList = new HashMap<>();
        this.userFollowingList = new HashMap<>();
        // by default feed generation logic will be Popular Tweets, is user want to change it explicitly he have to update
        this.feedGenerationStrategy = FeedGenerationStrategy.POPULAR_TWEETS;
    }



    public void addFollower(User user){
        this.getUserFollowersList().put(user.getUserId(),user);
    }

    public void removeFollower(User user){
        this.getUserFollowersList().remove(user.getUserId());
    }

    public void addStartFollowingUser(User user){
        this.getUserFollowingList().put(user.getUserId(), user);
    }

    public void stopFollowingUser(User user){
        this.getUserFollowingList().remove(user.getUserId());
    }

    public void addTweet(Tweet tweet){
        this.tweetsMap.put(tweet.getTweetId(),tweet);
    }

    public void deleteTweet(int tweetId){
        this.tweetsMap.remove(tweetId);
    }

    public FeedGenerationStrategy getFeedGenerationStrategy() {
        return feedGenerationStrategy;
    }

    public void setFeedGenerationStrategy(FeedGenerationStrategy feedGenerationStrategy) {
        this.feedGenerationStrategy = feedGenerationStrategy;
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

    public Map<Integer, Tweet> getTweetsMap() {
        return tweetsMap;
    }

    public void setTweetsMap(Map<Integer, Tweet> tweetsMap) {
        this.tweetsMap = tweetsMap;
    }

    public Map<Integer, Interaction> getUserInteractions() {
        return userInteractions;
    }

    public void setUserInteractions(Map<Integer, Interaction> userInteractions) {
        this.userInteractions = userInteractions;
    }

    public Map<Integer, User> getUserFollowingList() {
        return userFollowingList;
    }

    public void setUserFollowingList(Map<Integer, User> userFollowingList) {
        this.userFollowingList = userFollowingList;
    }

    public Map<Integer, User> getUserFollowersList() {
        return userFollowersList;
    }

    public void setUserFollowersList(Map<Integer, User> userFollowersList) {
        this.userFollowersList = userFollowersList;
    }
}
