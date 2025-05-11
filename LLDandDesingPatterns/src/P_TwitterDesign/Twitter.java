package P_TwitterDesign;

import P_TwitterDesign.Interaction.Interaction;

import java.util.*;

public class Twitter {

    private Map<Integer,User> userMap;
    private Map<Integer, Tweet> tweetMap;

    // K --> TweetId, V --> TweetLikes
    PriorityQueue<Map.Entry<Integer,Integer>> priorityQueue;

    public static Twitter instance = null;

    private Twitter() {
        this.userMap = new HashMap<>();
        this.tweetMap = new LinkedHashMap<>();
        // Initializing a max heap based on tweetLikes
        this.priorityQueue = new PriorityQueue<>((a,b) -> b.getValue() - a.getValue());
    }

    public static synchronized Twitter getInstance(){
        if(instance == null){
            instance = new Twitter();
        }

        return instance;
    }

    public List<Tweet> getLastTenRecentPost() {
        List<Tweet> lastTenRecentPosts = new ArrayList<>();
        List<Integer> tweetIds = new ArrayList<>(tweetMap.keySet());
        int start = Math.max(0, tweetIds.size() - 10);

        for (int i = start; i < tweetIds.size(); i++) {
            int tweetId = tweetIds.get(i);
            lastTenRecentPosts.add(tweetMap.get(tweetId));
        }

        return lastTenRecentPosts;
    }

    public List<Tweet> getPopularTweets() {
        List<Map.Entry<Integer, Tweet>> tweetEntries = new ArrayList<>(tweetMap.entrySet());

        tweetEntries.sort((a, b) -> {
            int interactionsA = a.getValue().getLikesCount() + a.getValue().getRetweetsCount() + a.getValue().getCommentsCount();
            int interactionsB = b.getValue().getLikesCount() + b.getValue().getRetweetsCount() + b.getValue().getCommentsCount();
            return Integer.compare(interactionsB, interactionsA);
        });

        List<Tweet> popularTweets = new ArrayList<>();
        for (Map.Entry<Integer, Tweet> entry : tweetEntries) {
            popularTweets.add(entry.getValue());
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
        user.getTweetsMap().put(tweet.getTweetId(),tweet);
    }

    public void likeTweet(User user,Tweet tweet){
        tweet.likeTweet(user);
    }

    public void doRetweet(User user, Tweet tweet){
        tweet.doReTweet(user);
    }

    public void addComment(User user, Tweet tweet,String comment){
        tweet.doComment(user,comment);
    }

    public void undoLikeTweet(User user, Tweet tweet){
        tweet.unlikeTweet(user);
    }

    public void undoReTweet(User user, Tweet tweet){
        tweet.unDoReTweet(user);
    }

    public void removeAllComments(User user,Tweet tweet){
        tweet.removeAllComments(user);
    }
}
