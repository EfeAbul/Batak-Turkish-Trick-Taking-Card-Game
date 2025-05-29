import java.util.ArrayList;
import java.util.Scanner;

public class User {

    private ArrayList<Card> hand = new ArrayList<>();
    private int roundsWon=0;
    private int roundsWonGoal=0;

    private boolean trumpHolder=false;


    public int numOfRoundsToBeWon(){

        System.out.print("Your deck: ");
        for (int i = 0; i < 13; i++)
        {
            System.out.print(hand.get(i).getType() + hand.get(i).getNumber() +" ");
        }
        System.out.println();
        System.out.print("Enter how many rounds you aim to get: ");
        Scanner keyboard = new Scanner(System.in);
        roundsWonGoal=keyboard.nextInt();
        System.out.println();
        return roundsWonGoal;

    }

    public void chooseCardToPlay() {

        Card card=null;

        Scanner keyboard = new Scanner(System.in);
        System.out.print("Choose the type of card you will play: ");
        String type = keyboard.nextLine();
        System.out.print("Choose the number of card you will play: ");
        int num = keyboard.nextInt();


        for (int i = 0; i < hand.size(); i++) {

            if (hand.get(i).getType().equals(type) && hand.get(i).getNumber()==num)
            {
                card = hand.get(i);
            }
        }

        card.setPlayedBy(Table.getPlayer1());
        this.hand.remove(card);
        Table.getCardsOnTheTable().add(card);
        Table.getCardsOpened().add(card);

    }

    public ArrayList<Card> getHand() {
        return hand;
    }

    public int getRoundsWon() {
        return roundsWon;
    }

    public void setRoundsWon(int roundsWon) {
        this.roundsWon = roundsWon;
    }

    public int getRoundsWonGoal() {
        return roundsWonGoal;
    }

    public void setRoundsWonGoal(int roundsWonGoal) {
        this.roundsWonGoal = roundsWonGoal;
    }
}
