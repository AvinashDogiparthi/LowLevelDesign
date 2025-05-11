package P_TwitterDesign;

import P_TwitterDesign.Interaction.Interaction;

import java.time.Instant;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class Tweet {

    private int tweetId;
    private Date tweetPostedDate;
    private Map<Integer, Interaction> interactionsMap;
    private int likesCount;
    private int commentsCount;
    private int retweetsCount;
    private String tweetContent;

    public Tweet(int tweetId, String tweetContent){
        this.interactionsMap = new HashMap<>();
        this.likesCount = 0;
        this.retweetsCount = 0;
        this.commentsCount = 0;
        this.tweetId = tweetId;
        this.tweetContent = tweetContent;
    }


    public void likeTweet(User user){
        if(!interactionsMap.containsKey(user.getUserId())){
            System.out.println("Tweet::likeTweet - user doesn't have any interaction before, so creating a new one");
            this.likesCount = likesCount + 1;
            Interaction interaction = new Interaction.InteractionBuilder()
                    .addLike()
                    .build();
            this.interactionsMap.put(user.getUserId(),interaction);
            user.getUserInteractions().put(this.tweetId,interaction);
        } else {
            System.out.println("Tweet::likeTweet - user have an interaction before, so updating a new one");
            Interaction interaction = interactionsMap.get(user.getUserId());
            this.likesCount = likesCount + 1;
            interaction.updateLikeStatus(true);
            user.getUserInteractions().put(this.tweetId, interaction);
        }
    }

    public void doReTweet(User user){
        if(!interactionsMap.containsKey(user.getUserId())){
            System.out.println("Tweet::doReTweet - user doesn't have any interaction before, so creating a new one");
            this.retweetsCount = retweetsCount + 1;
            Interaction interaction = new Interaction.InteractionBuilder()
                    .addRetweetStatus()
                    .build();
            this.interactionsMap.put(user.getUserId(),interaction);
            user.getUserInteractions().put(this.tweetId,interaction);
        } else {
            System.out.println("Tweet::doReTweet - user have an interaction before, so updating a new one");
            Interaction interaction = interactionsMap.get(user.getUserId());
            interaction.updateRetweetFlag(true);
            user.getUserInteractions().put(this.tweetId,interaction);
            this.retweetsCount = retweetsCount + 1;
        }
    }

    public void doComment(User user, String comment){
        if(!interactionsMap.containsKey(user.getUserId())){
            System.out.println("Tweet::doComment - user doesn't have any interaction before, so creating a new one");
            this.commentsCount = commentsCount + 1;
            Interaction interaction = new Interaction.InteractionBuilder()
                    .addComment(comment)
                    .build();
            this.interactionsMap.put(user.getUserId(),interaction);
            user.getUserInteractions().put(this.tweetId,interaction);
        } else {
            System.out.println("Tweet::doComment - user have an interaction before, so updating a new one");
            Interaction interaction = interactionsMap.get(user.getUserId());
            interaction.addComment(comment);
            this.commentsCount = commentsCount + 1;
            user.getUserInteractions().put(this.tweetId,interaction);
        }
    }

    public void unlikeTweet(User user){
        if(interactionsMap.containsKey(user.getUserId())){
            System.out.println("Tweet::unlikeTweet - removing like from the tweet as per user suggestion");
            Interaction interaction = interactionsMap.get(user.getUserId());
            boolean hasInteraction = interaction.removeLikeStatus();
            this.likesCount = likesCount - 1;
            if(!hasInteraction){
                System.out.println("Tweet::unlikeTweet - user doesn't have any interaction with this post, so removing it");
                interactionsMap.remove(user.getUserId());
                user.getUserInteractions().remove(this.tweetId);
            }
        } else {
            System.out.println("User did not like this tweet");
        }
    }

    public void unDoReTweet(User user){
        if(interactionsMap.containsKey(user.getUserId())){
            System.out.println("Tweet::unReTweet - removing like from the tweet as per user suggestion");
            Interaction interaction = interactionsMap.get(user.getUserId());
            boolean hasInteraction = interaction.unDoRetweet();
            this.retweetsCount = retweetsCount - 1;
            if(!hasInteraction){
                System.out.println("Tweet::unReTweet - user doesn't have any interaction with this post, so removing it");
                interactionsMap.remove(user.getUserId());
                user.getUserInteractions().remove(this.tweetId);
            }
        } else {
            System.out.println("User didn't do a retweet on this tweet");
        }
    }

    public void removeAllComments(User user){
        if(interactionsMap.containsKey(user.getUserId())){
            System.out.println("Tweet::removeAllComments - removing all comments from the tweet as per user suggestion");
            Interaction interaction = interactionsMap.get(user.getUserId());
            int removableCommentsCount = interaction.getComments().size();
            boolean hasInteraction = interaction.removeComments();
            this.commentsCount = commentsCount - removableCommentsCount;
            if(!hasInteraction){
                System.out.println("Tweet::removeAllComments - user doesn't have any interaction with this post, so removing it");
                interactionsMap.remove(user.getUserId());
                user.getUserInteractions().remove(this.tweetId);
            }
        } else {
            System.out.println("User didn't comment on this tweet");
        }
    }


    public int getTweetId() {
        return tweetId;
    }

    public void setTweetId(int tweetId) {
        this.tweetId = tweetId;
    }

    public Date getTweetPostedDate() {
        return tweetPostedDate;
    }

    public void setTweetPostedDate(Date tweetPostedDate) {
        this.tweetPostedDate = tweetPostedDate;
    }

    public Map<Integer, Interaction> getInteractionsMap() {
        return interactionsMap;
    }

    public void setInteractionsMap(Map<Integer, Interaction> interactionsMap) {
        this.interactionsMap = interactionsMap;
    }

    public int getLikesCount() {
        return likesCount;
    }

    public void setLikesCount(int likesCount) {
        this.likesCount = likesCount;
    }

    public int getCommentsCount() {
        return commentsCount;
    }

    public void setCommentsCount(int commentsCount) {
        this.commentsCount = commentsCount;
    }

    public int getRetweetsCount() {
        return retweetsCount;
    }

    public void setRetweetsCount(int retweetsCount) {
        this.retweetsCount = retweetsCount;
    }

    public String getTweetContent() {
        return tweetContent;
    }

    public void setTweetContent(String tweetContent) {
        this.tweetContent = tweetContent;
    }
}
