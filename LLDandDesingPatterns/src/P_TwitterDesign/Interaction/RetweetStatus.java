package P_TwitterDesign.Interaction;

public interface RetweetStatus {
    void updateRetweetFlag(boolean isRetweeted);
    boolean unDoRetweet();
    boolean getRetweetFlagFlag();
}
