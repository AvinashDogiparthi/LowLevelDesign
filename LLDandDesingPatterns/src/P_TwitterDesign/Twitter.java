package P_TwitterDesign;

import P_TwitterDesign.Interaction.Interaction;

import java.util.*;

public class Twitter {

    private Map<Integer,User> userMap;
    private Map<Integer, Tweet> tweetMap;

    TreeMap<Integer,TreeMap<Integer,Tweet>> mostInteractedTweets;

    public static Twitter instance = null;

    private Twitter() {
        this.userMap = new HashMap<>();
        this.tweetMap = new LinkedHashMap<>();
        // Initializing a max heap based on tweetLikes
        this.mostInteractedTweets = new TreeMap<>();
    }

    public static synchronized Twitter getInstance(){
        if(instance == null){
            instance = new Twitter();
        }

        return instance;
    }

    public List<Tweet> generateFeed(User user){
        if(user.getFeedGenerationStrategy() == FeedGenerationStrategy.LATEST_TWEETS){
            return getLastTenRecentPost();
        } else {
            return getPopularTweets();
        }
    }

    private List<Tweet> getLastTenRecentPost() {
        List<Tweet> lastTenRecentPosts = new ArrayList<>();
        List<Integer> tweetIds = new ArrayList<>(tweetMap.keySet());
        int start = Math.max(0, tweetIds.size() - 10);

        for (int i = start; i < tweetIds.size(); i++) {
            int tweetId = tweetIds.get(i);
            lastTenRecentPosts.add(tweetMap.get(tweetId));
        }

        return lastTenRecentPosts;
    }

    private List<Tweet> getPopularTweets() {
        List<Tweet> popularTweets = new ArrayList<>();

        for (Map.Entry<Integer, TreeMap<Integer, Tweet>> entry : mostInteractedTweets.descendingMap().entrySet()) {
            popularTweets.addAll(entry.getValue().values());
        }

        return popularTweets;
    }

    public void followUser(int userId, int userIdToFollow){
        User user = this.userMap.get(userId);
        User userToFollow = this.userMap.get(userIdToFollow);
        user.addStartFollowingUser(userToFollow);
        userToFollow.addFollower(user);
    }

    public void unFollowUser(int userId, int userIdToUnFollow){
        User user = this.userMap.get(userId);
        User userToUnFollow = this.userMap.get(userIdToUnFollow);
        user.stopFollowingUser(userToUnFollow);
        userToUnFollow.removeFollower(user);
    }

    public void addUser(User user){
        this.userMap.put(user.getUserId(), user);
    }

    public void doTweet(Tweet tweet, User user){
        System.out.println("User "+user.getUserName()+" is tweeting "+tweet.getTweetId());
        this.tweetMap.put(tweet.getTweetId(), tweet);
        user.addTweet(tweet);
    }

    public void likeTweet(User user,Tweet tweet){
        deletePreviousInteractionEntry(tweet);
        tweet.likeTweet(user);
        updatePopularTweetsMap(tweet);
    }

    public void doRetweet(User user, Tweet tweet){
        deletePreviousInteractionEntry(tweet);
        tweet.doReTweet(user);
        updatePopularTweetsMap(tweet);
    }

    public void addComment(User user, Tweet tweet,String comment){
        deletePreviousInteractionEntry(tweet);
        tweet.doComment(user,comment);
        updatePopularTweetsMap(tweet);
    }

    private void deletePreviousInteractionEntry(Tweet tweet) {
        int preInteractionCount =calculateInteractionCount(tweet);
        if(mostInteractedTweets.containsKey(preInteractionCount)){
            TreeMap<Integer,Tweet> existingMap = mostInteractedTweets.get(preInteractionCount);
            existingMap.remove(tweet.getTweetId());
            mostInteractedTweets.put(preInteractionCount,existingMap);
        }
    }

    private void updatePopularTweetsMap(Tweet tweet) {
        int interactionCount = calculateInteractionCount(tweet);
        if(mostInteractedTweets.containsKey(interactionCount)){
            TreeMap<Integer,Tweet> existingMap = mostInteractedTweets.get(interactionCount);
            existingMap.put(tweet.getTweetId(), tweet);
            //updating the map basically
            mostInteractedTweets.put(interactionCount,existingMap);
        } else {
            TreeMap<Integer,Tweet> newMap = new TreeMap<>();
            newMap.put(tweet.getTweetId(), tweet);
            mostInteractedTweets.put(interactionCount,newMap);
        }
    }

    public void undoLikeTweet(User user, Tweet tweet){
        deletePreviousInteractionEntry(tweet);
        tweet.unlikeTweet(user);
        updatePopularTweetsMap(tweet);
    }

    public void undoReTweet(User user, Tweet tweet){
        deletePreviousInteractionEntry(tweet);
        tweet.unDoReTweet(user);
        updatePopularTweetsMap(tweet);
    }

    public void removeAllComments(User user,Tweet tweet){
        deletePreviousInteractionEntry(tweet);
        tweet.removeAllComments(user);
        updatePopularTweetsMap(tweet);
    }

    public int calculateInteractionCount(Tweet tweet) {
        int totalInteractions = 0;

        for (Interaction interaction : tweet.getInteractionsMap().values()) {
            totalInteractions += interaction.getLikeStatus() ? 1 : 0;
            totalInteractions += interaction.getRetweetFlagFlag() ? 1 : 0;
            totalInteractions += interaction.getComments().size();
        }

        return totalInteractions;
    }
}
