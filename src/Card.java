public class Card {

    private String type;
    private int number;

    private Player playedBy;

    public Card(String type, int number)
    {
        this.type=type;
        this.number=number;
    }

    public int getNumber() {
        return number;
    }

    public String getType() {
        return type;
    }

    public Player getPlayedBy() {
        return playedBy;
    }

    public void setPlayedBy(Player playedBy) {
        this.playedBy = playedBy;
    }
}
