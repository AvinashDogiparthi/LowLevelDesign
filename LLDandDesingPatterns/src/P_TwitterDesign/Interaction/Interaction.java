package P_TwitterDesign.Interaction;

import java.util.ArrayList;
import java.util.List;

public class Interaction implements Commentable,LikeStatus,RetweetStatus{

    private List<String> comments;
    private boolean likeStatus;
    private boolean retweetStatus;

    private Interaction(InteractionBuilder interactionBuilder){
        this.likeStatus = interactionBuilder.likeStatus;
        this.retweetStatus = interactionBuilder.retweetStatus;
        this.comments = interactionBuilder.comments;
    }

    @Override
    public void addComment(String userComment) {
        comments.add(userComment);
    }

    @Override
    public boolean removeComments() {
        comments = new ArrayList<>();
        return hasInteraction();
    }

    @Override
    public boolean removeLikeStatus() {
        likeStatus = false;
        return hasInteraction();
    }

    @Override
    public List<String> getComments() {
        return comments;
    }

    @Override
    public void updateLikeStatus(boolean isLiked) {
        likeStatus = isLiked;
    }

    @Override
    public boolean getLikeStatus() {
        return likeStatus;
    }

    @Override
    public void updateRetweetFlag(boolean isRetweeted) {
        retweetStatus = isRetweeted;
    }

    @Override
    public boolean getRetweetFlagFlag() {
        return retweetStatus;
    }

    @Override
    public boolean unDoRetweet() {
        retweetStatus = false;
        return hasInteraction();
    }

    public boolean hasInteraction() {
        return (!comments.isEmpty()) || likeStatus || retweetStatus;
    }

    public static class InteractionBuilder{
        private List<String> comments = new ArrayList<>();
        private boolean likeStatus;
        private boolean retweetStatus;

        public InteractionBuilder addLike(){
            this.likeStatus = true;
            return this;
        }

        public InteractionBuilder addRetweetStatus(){
            this.retweetStatus = true;
            return this;
        }

        public InteractionBuilder addComment(String comment){
            comments.add(comment);
            return this;
        }

        public Interaction build(){
            return new Interaction(this);
        }
    }
}
