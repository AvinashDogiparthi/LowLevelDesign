package P_TwitterDesign.Interaction;

public interface LikeStatus {
    void updateLikeStatus(boolean isLiked);
    boolean removeLikeStatus();
    boolean getLikeStatus();
}
