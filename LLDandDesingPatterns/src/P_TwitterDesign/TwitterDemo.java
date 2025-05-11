package P_TwitterDesign;

import java.util.List;

public class TwitterDemo {

    public static void main(String[] args) {
        Twitter twitter = Twitter.getInstance();

        User user1 = new User(12,"Avinash");
        User user2 = new User(13,"Snehith");
        User user3 = new User(14,"Jayanth");
        User user4 = new User(16,"Charan");
        User user5 = new User(15,"Ajith");
        User user6 = new User(17,"Arjun");
        User user7 = new User(18,"Vijay");
        User user8 = new User(19,"Mahesh");
        User user9 = new User(20,"Pawan");

        twitter.addUser(user1);
        twitter.addUser(user2);
        twitter.addUser(user3);
        twitter.addUser(user4);
        twitter.addUser(user5);
        twitter.addUser(user6);
        twitter.addUser(user7);
        twitter.addUser(user8);
        twitter.addUser(user9);


        twitter.followUser(12,14);
        twitter.followUser(14,12);
        twitter.followUser(12,15);
        twitter.followUser(15,12);
        twitter.followUser(12,18);
        twitter.followUser(12,19);
        twitter.followUser(12,20);
        twitter.followUser(12,17);
        twitter.followUser(12,16);
        twitter.followUser(16,12);
        twitter.followUser(18,17);
        twitter.followUser(17,20);



        Tweet tweet1 = new Tweet(1,"123");
        Tweet tweet2 = new Tweet(2,"124");
        Tweet tweet3 = new Tweet(3,"125");
        Tweet tweet4 = new Tweet(4,"126");
        Tweet tweet5 = new Tweet(5,"127");
        Tweet tweet6 = new Tweet(6,"128");
        Tweet tweet7 = new Tweet(7,"129");
        Tweet tweet8 = new Tweet(8,"130");
        Tweet tweet9 = new Tweet(9,"131");
        Tweet tweet10 = new Tweet(10,"132");

        twitter.doTweet(tweet1,user1);
        twitter.doTweet(tweet2,user2);
        twitter.doTweet(tweet3,user3);
        twitter.doTweet(tweet4,user4);
        twitter.doTweet(tweet5,user5);
        twitter.doTweet(tweet6,user6);
        twitter.doTweet(tweet7,user7);
        twitter.doTweet(tweet8,user8);
        twitter.doTweet(tweet9,user9);
        twitter.doTweet(tweet10,user9);

        twitter.likeTweet(user1,tweet2);
        twitter.likeTweet(user2,tweet2);
        twitter.likeTweet(user3,tweet3);

        twitter.doRetweet(user1,tweet2);
        twitter.doRetweet(user3,tweet8);
        twitter.doRetweet(user7,tweet10);

        twitter.addComment(user1,tweet2,"I like this tweet a lot");
        twitter.addComment(user1,tweet2,"This is my second tweet");
        twitter.addComment(user1,tweet2,"I am really liking this tweet");
        twitter.addComment(user3,tweet8,"Hello this is my comment");
        twitter.addComment(user4,tweet10,"aa seal ni puttinchinde vadu");
        twitter.addComment(user5,tweet10,"pagilinda");
        twitter.addComment(user6,tweet9,"babu lake babu");

        System.out.println("---------------------------Most popular tweet Feed Generator---------------------------");
        List<Tweet> recentTweetFeedGenerator = twitter.generateFeed(user1);
        for(Tweet tweet : recentTweetFeedGenerator){
            System.out.println(tweet);
        }

        System.out.println("---------------------------Recent Tweets Feed Generator---------------------------");
        user1.setFeedGenerationStrategy(FeedGenerationStrategy.LATEST_TWEETS);
        List<Tweet> mostPopularTweetFeedGenerator = twitter.generateFeed(user1);
        for(Tweet tweet : mostPopularTweetFeedGenerator){
            System.out.println(tweet);
        }

        twitter.removeAllComments(user5,tweet10);
        twitter.removeAllComments(user6,tweet9);

        twitter.undoLikeTweet(user3,tweet3);
        twitter.undoLikeTweet(user2,tweet2);
        twitter.undoLikeTweet(user1,tweet2);

        twitter.undoReTweet(user7,tweet10);
    }
}
