import java.util.ArrayList;
import java.util.Scanner;

public class Table {

    private static ArrayList<Card> cardsOpened = new ArrayList<>();
    private static ArrayList<Card> cardsOnTheTable = new ArrayList<>();
    private static ArrayList<String> typesPlayer2DontHave = new ArrayList<>();
    private static ArrayList<String> typesPlayer3DontHave = new ArrayList<>();
    private static ArrayList<String> typesPlayer4DontHave = new ArrayList<>();
    private static ArrayList<String> typesUserDontHave = new ArrayList<>();
    private static Player currTurn;
    private static String trump;
    private static ArrayList<Card> deck = new ArrayList<>();


    private static User user = new User();

    private static Player player1 = new Player();
    private static Player player2 = new Player();
    private static Player player3 = new Player();
    private static Player player4 = new Player();
    private static Player trumpChooser;

    public void run(){

        createDeck();
        dealCards();
        setTrump();

        boolean gameOver=false;

        currTurn=trumpChooser;

        System.out.println("Trump: " + getTrump());

        while(!gameOver)
        {

            System.out.println();
            System.out.println("************");
            System.out.println();

            Card winnerCard=null;

            System.out.print("Your hand: ");
            for (int i = 0; i < user.getHand().size(); i++)
            {
                System.out.print(user.getHand().get(i).getType() + user.getHand().get(i).getNumber() + " ");
            }
            System.out.println();

            if(currTurn.equals(player2))
            {
                player2.chooseCardToPlay();
                System.out.println("Player2 played: " + cardsOnTheTable.get(cardsOnTheTable.size()-1).getType() +cardsOnTheTable.get(cardsOnTheTable.size()-1).getNumber());
                player3.chooseCardToPlay();
                System.out.println("Player3 played: " + cardsOnTheTable.get(cardsOnTheTable.size()-1).getType() +cardsOnTheTable.get(cardsOnTheTable.size()-1).getNumber());
                player4.chooseCardToPlay();
                System.out.println("Player4 played: " + cardsOnTheTable.get(cardsOnTheTable.size()-1).getType() +cardsOnTheTable.get(cardsOnTheTable.size()-1).getNumber());
                user.chooseCardToPlay();
                System.out.println("User played: " + cardsOnTheTable.get(cardsOnTheTable.size()-1).getType() +cardsOnTheTable.get(cardsOnTheTable.size()-1).getNumber());

                winnerCard=cardsOnTheTable.get(0);

            }
            else if (currTurn.equals(player3))
            {
                player3.chooseCardToPlay();
                System.out.println("Player3 played: " + cardsOnTheTable.get(cardsOnTheTable.size()-1).getType() +cardsOnTheTable.get(cardsOnTheTable.size()-1).getNumber());
                player4.chooseCardToPlay();
                System.out.println("Player4 played: " + cardsOnTheTable.get(cardsOnTheTable.size()-1).getType() +cardsOnTheTable.get(cardsOnTheTable.size()-1).getNumber());
                user.chooseCardToPlay();
                System.out.println("User played: " + cardsOnTheTable.get(cardsOnTheTable.size()-1).getType() +cardsOnTheTable.get(cardsOnTheTable.size()-1).getNumber());
                player2.chooseCardToPlay();
                System.out.println("Player2 played: " + cardsOnTheTable.get(cardsOnTheTable.size()-1).getType() +cardsOnTheTable.get(cardsOnTheTable.size()-1).getNumber());

                winnerCard=cardsOnTheTable.get(0);
            }
            else if (currTurn.equals(player4))
            {
                player4.chooseCardToPlay();
                System.out.println("Player4 played: " + cardsOnTheTable.get(cardsOnTheTable.size()-1).getType() +cardsOnTheTable.get(cardsOnTheTable.size()-1).getNumber());
                user.chooseCardToPlay();
                System.out.println("User played: " + cardsOnTheTable.get(cardsOnTheTable.size()-1).getType() +cardsOnTheTable.get(cardsOnTheTable.size()-1).getNumber());
                player2.chooseCardToPlay();
                System.out.println("Player2 played: " + cardsOnTheTable.get(cardsOnTheTable.size()-1).getType() +cardsOnTheTable.get(cardsOnTheTable.size()-1).getNumber());
                player3.chooseCardToPlay();
                System.out.println("Player3 played: " + cardsOnTheTable.get(cardsOnTheTable.size()-1).getType() +cardsOnTheTable.get(cardsOnTheTable.size()-1).getNumber());

                winnerCard=cardsOnTheTable.get(0);
            }
            else if(currTurn.equals(player1))
            {
                user.chooseCardToPlay();
                System.out.println("User played: " + cardsOnTheTable.get(cardsOnTheTable.size()-1).getType() +cardsOnTheTable.get(cardsOnTheTable.size()-1).getNumber());
                player2.chooseCardToPlay();
                System.out.println("Player2 played: " + cardsOnTheTable.get(cardsOnTheTable.size()-1).getType() +cardsOnTheTable.get(cardsOnTheTable.size()-1).getNumber());
                player3.chooseCardToPlay();
                System.out.println("Player3 played: " + cardsOnTheTable.get(cardsOnTheTable.size()-1).getType() +cardsOnTheTable.get(cardsOnTheTable.size()-1).getNumber());
                player4.chooseCardToPlay();
                System.out.println("Player4 played: " + cardsOnTheTable.get(cardsOnTheTable.size()-1).getType() +cardsOnTheTable.get(cardsOnTheTable.size()-1).getNumber());

                winnerCard=cardsOnTheTable.get(0);
            }

            for (int i = 1; i <= 3; i++) {

                if(winnerCard.getType().equals(trump))
                {
                    if(cardsOnTheTable.get(i).getType().equals(trump) && winnerCard.getNumber()<cardsOnTheTable.get(i).getNumber())
                    {
                        winnerCard=cardsOnTheTable.get(i);
                    }
                }
                else
                {
                    if(cardsOnTheTable.get(i).getType().equals(trump))
                    {
                        winnerCard=cardsOnTheTable.get(i);
                    }
                    else if (cardsOnTheTable.get(i).getNumber()>winnerCard.getNumber())
                    {
                        winnerCard=cardsOnTheTable.get(i);
                    }
                }
            }

            currTurn=winnerCard.getPlayedBy();
            winnerCard.getPlayedBy().setRoundsWon(winnerCard.getPlayedBy().getRoundsWon()+1);
            if(winnerCard.getPlayedBy().equals(player1))
            {
                user.setRoundsWon(user.getRoundsWon()+1);
            }
            cardsOnTheTable = new ArrayList<>();

            if(player2.getHand().size()==0)
            {
                gameOver=true;
            }
        }

        if(player2.equals(trumpChooser) && player2.getRoundsWon()>= player2.getRoundsWonGoal())
        {
            System.out.println("User point: " + user.getRoundsWon());
            System.out.println("Player2 point: " + player2.getRoundsWon());
            System.out.println("Player3 point: " + player3.getRoundsWon());
            System.out.println("Player4 point: " + player4.getRoundsWon());
        }
        else if(player2.equals(trumpChooser) && player2.getRoundsWon()< player2.getRoundsWonGoal())
        {
            System.out.println("User point: " + user.getRoundsWon());
            System.out.println("Player2 point: -" + player2.getRoundsWon());
            System.out.println("Player3 point: " + player3.getRoundsWon());
            System.out.println("Player4 point: " + player4.getRoundsWon());
        }
        else if (player3.equals(trumpChooser) && player3.getRoundsWon()>= player3.getRoundsWonGoal())
        {
            System.out.println("User point: " + user.getRoundsWon());
            System.out.println("Player2 point: " + player2.getRoundsWon());
            System.out.println("Player3 point: " + player3.getRoundsWon());
            System.out.println("Player4 point: " + player4.getRoundsWon());
        }
        else if(player3.equals(trumpChooser) && player3.getRoundsWon()< player3.getRoundsWonGoal())
        {
            System.out.println("User point: " + user.getRoundsWon());
            System.out.println("Player2 point: " + player2.getRoundsWon());
            System.out.println("Player3 point: -" + player3.getRoundsWon());
            System.out.println("Player4 point: " + player4.getRoundsWon());
        }
        else if(player4.equals(trumpChooser) && player4.getRoundsWon()>= player4.getRoundsWonGoal())
        {
            System.out.println("User point: " + user.getRoundsWon());
            System.out.println("Player2 point: " + player2.getRoundsWon());
            System.out.println("Player3 point: " + player3.getRoundsWon());
            System.out.println("Player4 point: " + player4.getRoundsWon());
        }
        else if (player4.equals(trumpChooser) && player4.getRoundsWon()< player4.getRoundsWonGoal())
        {
            System.out.println("User point: " + user.getRoundsWon());
            System.out.println("Player2 point: " + player2.getRoundsWon());
            System.out.println("Player3 point: " + player3.getRoundsWon());
            System.out.println("Player4 point: -" + player4.getRoundsWon());
        }
        else if (trumpChooser.equals(player1) && user.getRoundsWon()>=user.getRoundsWonGoal())
        {
            System.out.println("User point: " + user.getRoundsWon());
            System.out.println("Player2 point: " + player2.getRoundsWon());
            System.out.println("Player3 point: " + player3.getRoundsWon());
            System.out.println("Player4 point: " + player4.getRoundsWon());
        }
        else if (trumpChooser.equals(player1) && user.getRoundsWon()<user.getRoundsWonGoal())
        {
            System.out.println("User point: -" + user.getRoundsWon());
            System.out.println("Player2 point: " + player2.getRoundsWon());
            System.out.println("Player3 point: " + player3.getRoundsWon());
            System.out.println("Player4 point: " + player4.getRoundsWon());
        }

    }

    public void createDeck(){

        ArrayList<Card> tempDeck = new ArrayList<>();

        tempDeck.add(new Card("heart", 13));
        tempDeck.add(new Card("heart", 12));
        tempDeck.add(new Card("heart", 11));
        tempDeck.add(new Card("heart", 10));
        tempDeck.add(new Card("heart", 9));
        tempDeck.add(new Card("heart", 8));
        tempDeck.add(new Card("heart", 7));
        tempDeck.add(new Card("heart", 6));
        tempDeck.add(new Card("heart", 5));
        tempDeck.add(new Card("heart", 4));
        tempDeck.add(new Card("heart", 3));
        tempDeck.add(new Card("heart", 2));
        tempDeck.add(new Card("heart", 1));

        tempDeck.add(new Card("diamond", 13));
        tempDeck.add(new Card("diamond", 12));
        tempDeck.add(new Card("diamond", 11));
        tempDeck.add(new Card("diamond", 10));
        tempDeck.add(new Card("diamond", 9));
        tempDeck.add(new Card("diamond", 8));
        tempDeck.add(new Card("diamond", 7));
        tempDeck.add(new Card("diamond", 6));
        tempDeck.add(new Card("diamond", 5));
        tempDeck.add(new Card("diamond", 4));
        tempDeck.add(new Card("diamond", 3));
        tempDeck.add(new Card("diamond", 2));
        tempDeck.add(new Card("diamond", 1));

        tempDeck.add(new Card("club", 13));
        tempDeck.add(new Card("club", 12));
        tempDeck.add(new Card("club", 11));
        tempDeck.add(new Card("club", 10));
        tempDeck.add(new Card("club", 9));
        tempDeck.add(new Card("club", 8));
        tempDeck.add(new Card("club", 7));
        tempDeck.add(new Card("club", 6));
        tempDeck.add(new Card("club", 5));
        tempDeck.add(new Card("club", 4));
        tempDeck.add(new Card("club", 3));
        tempDeck.add(new Card("club", 2));
        tempDeck.add(new Card("club", 1));

        tempDeck.add(new Card("spade", 13));
        tempDeck.add(new Card("spade", 12));
        tempDeck.add(new Card("spade", 11));
        tempDeck.add(new Card("spade", 10));
        tempDeck.add(new Card("spade", 9));
        tempDeck.add(new Card("spade", 8));
        tempDeck.add(new Card("spade", 7));
        tempDeck.add(new Card("spade", 6));
        tempDeck.add(new Card("spade", 5));
        tempDeck.add(new Card("spade", 4));
        tempDeck.add(new Card("spade", 3));
        tempDeck.add(new Card("spade", 2));
        tempDeck.add(new Card("spade", 1));

        for (int i = 52; i > 0; i--) {

            int randomNumber = (int)((tempDeck.size()-1)*Math.random());
            deck.add(tempDeck.get(randomNumber));
            tempDeck.remove(randomNumber);

        }

    }

    public void dealCards(){

        for (int i = 51; i >= 0; i--) {

            int randomnumber = (int)((deck.size()-1)*Math.random());
            if (i<=12)
            {
                user.getHand().add(deck.get(randomnumber));
                deck.remove(randomnumber);
            }
            else if(i<=25)
            {
                player2.getHand().add(deck.get(randomnumber));
                deck.remove(randomnumber);
            }
            else if(i<=38)
            {
                player3.getHand().add(deck.get(randomnumber));
                deck.remove(randomnumber);
            }
            else if(i<=51)
            {
                player4.getHand().add(deck.get(randomnumber));
                deck.remove(randomnumber);
            }
        }
    }

    public void setTrump(){

        int currentGoal;

        int usersGoal;
        int player2Goal;
        int player3Goal;
        int player4Goal;
        int max1;
        int max2;
        int maxFin;

        usersGoal = user.numOfRoundsToBeWon();
        currentGoal=usersGoal;
        player2Goal = player2.numOfRoundsToBeWon();
        if(player2Goal>currentGoal)
        {
            player2.setRoundsWonGoal(currentGoal+1);
        }
        player3Goal = player3.numOfRoundsToBeWon();
        if(player3Goal>currentGoal)
        {
            player3.setRoundsWonGoal(currentGoal+1);
        }
        player4Goal = player4.numOfRoundsToBeWon();
        if(player4Goal>currentGoal)
        {
            player4.setRoundsWonGoal(currentGoal+1);
        }

        max1=Math.max(usersGoal,player2Goal);
        max2=Math.max(player3Goal,player4Goal);
        maxFin=Math.max(max1,max2);

        if(maxFin==player4Goal)
        {
            trumpChooser=player4;
        }
        else if(maxFin==player3Goal)
        {
            trumpChooser=player3;
        }
        else if(maxFin==player2Goal)
        {
            trumpChooser=player4;
        }
        else if (maxFin==usersGoal)
        {
            trumpChooser=player1;
        }

        if(trumpChooser==null)
        {
            Scanner keyboard = new Scanner(System.in);
            System.out.print("Choose the trump: ");
            trump = keyboard.nextLine();
            System.out.println();
        }
        else
        {
            trump = trumpChooser.getTrumpGoalOfPlayer();
        }
    }



    public void printHands() {

        System.out.println(" ");
        System.out.println("-------------");

        System.out.print("User ");
        for (int i = 0; i < user.getHand().size(); i++) {
            System.out.print(user.getHand().get(i).getType() + user.getHand().get(i).getNumber() + " ");
        }
        System.out.println();
        System.out.print("Player2 ");
        for (int i = 0; i < player2.getHand().size(); i++) {
            System.out.print(player2.getHand().get(i).getType() + player2.getHand().get(i).getNumber() + " ");
        }
        System.out.println();
        System.out.print("Player3 ");
        for (int i = 0; i < player3.getHand().size(); i++) {
            System.out.print(player3.getHand().get(i).getType() + player3.getHand().get(i).getNumber() + " ");
        }
        System.out.println();
        System.out.print("Player4 ");
        for (int i = 0; i < player4.getHand().size(); i++) {
            System.out.print(player4.getHand().get(i).getType() + player4.getHand().get(i).getNumber() + " ");
        }
        System.out.println();
        System.out.println("-------------");
        System.out.println(" ");


    }

    public static ArrayList<Card> getCardsOpened() {
        return cardsOpened;
    }

    public static void setCardsOpened(ArrayList<Card> cardsOpened) {
        Table.cardsOpened = cardsOpened;
    }

    public static void setCardsOnTheTable(ArrayList<Card> cardsOnTheTable) {
        Table.cardsOnTheTable = cardsOnTheTable;
    }

    public static ArrayList<Card> getCardsOnTheTable() {
        return cardsOnTheTable;
    }

    public static Player getCurrTurn() {
        return currTurn;
    }

    public static void setCurrTurn(Player currTurn) {
        Table.currTurn = currTurn;
    }

    public static Player getPlayer2() {
        return player2;
    }

    public static Player getPlayer3() {
        return player3;
    }

    public static Player getPlayer4() {
        return player4;
    }

    public static User getUser() {
        return user;
    }

    public static ArrayList<String> getTypesPlayer2DontHave() {
        return typesPlayer2DontHave;
    }

    public static void setTypesPlayer2DontHave(ArrayList<String> typesPlayer2DontHave) {
        Table.typesPlayer2DontHave = typesPlayer2DontHave;
    }

    public static ArrayList<String> getTypesPlayer3DontHave() {
        return typesPlayer3DontHave;
    }

    public static void setTypesPlayer3DontHave(ArrayList<String> typesPlayer3DontHave) {
        Table.typesPlayer3DontHave = typesPlayer3DontHave;
    }

    public static ArrayList<String> getTypesPlayer4DontHave() {
        return typesPlayer4DontHave;
    }

    public static void setTypesPlayer4DontHave(ArrayList<String> typesPlayer4DontHave) {
        Table.typesPlayer4DontHave = typesPlayer4DontHave;
    }

    public static ArrayList<String> getTypesUserDontHave() {
        return typesUserDontHave;
    }

    public static void setTypesUserDontHave(ArrayList<String> typesUserDontHave) {
        Table.typesUserDontHave = typesUserDontHave;
    }

    public static String getTrump() {
        return trump;
    }

    public static void setTrump(String trump) {
        Table.trump = trump;
    }

    public static Player getPlayer1() {
        return player1;
    }

    public static void setPlayer1(Player player1) {
        Table.player1 = player1;
    }
}
