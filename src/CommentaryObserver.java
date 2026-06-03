// Concrete Observer - prints live match commentary
public class CommentaryObserver implements MatchObserver {
    @Override
    public void update(String event) {
        System.out.println("📢 " + event);
    }
}
