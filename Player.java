import javax.swing.text.TabExpander;
import java.util.ArrayList;

public class Player {

    private ArrayList<Card> hand = new ArrayList<>();
    private int roundsWon=0;
    private int roundsWonGoal=0;
    private String trumpGoalOfPlayer=null;


    //maça1 maça2 maça3 maça7 maça12 maça13 kupa13 karo10 kupa1 kupa2 sinek12 sinek1 sinek2


    public int numOfRoundsToBeWon(){

        int numOfDiamond=0;
        int numOfClub=0;
        int numOfSpade=0;
        int numOfHeart=0;
        int sumOfDiamond=0;
        int sumOfClub=0;
        int sumOfSpade=0;
        int sumOfHeart=0;

        String trumpGoal=null;
        int trumpSum=0;
        int threshold=0;
        int threshold2=0;



        for (int i = 0; i < 13; i++) {

            if(hand.get(i).getType().equals("diamond"))
            {
                numOfDiamond++;
                sumOfDiamond+=hand.get(i).getNumber();

            }
            else if(hand.get(i).getType().equals("club"))
            {
                numOfClub++;
                sumOfClub+=hand.get(i).getNumber();
            }
            else if(hand.get(i).getType().equals("spade"))
            {
                numOfSpade++;
                sumOfSpade+=hand.get(i).getNumber();
            }
            else if(hand.get(i).getType().equals("heart"))
            {
                numOfHeart++;
                sumOfHeart+=hand.get(i).getNumber();
            }
        }

        if(numOfDiamond>=numOfClub && numOfDiamond>=numOfHeart && numOfDiamond>=numOfSpade)
        {
            if(numOfDiamond==numOfClub)
            {
                if(sumOfDiamond>=sumOfClub)
                {
                    trumpGoal = "diamond";
                }
                else
                {
                    trumpGoal = "club";
                }
            }
            if(numOfDiamond==numOfHeart)
            {
                if(sumOfDiamond>=sumOfHeart)
                {
                    trumpGoal = "diamond";
                }
                else
                {
                    trumpGoal = "heart";
                }
            }
            if(numOfDiamond==numOfSpade)
            {
                if(sumOfDiamond>=sumOfSpade)
                {
                    trumpGoal = "diamond";
                }
                else
                {
                    trumpGoal = "spade";
                }
            }
            else
            {
                trumpGoal = "diamond";
            }
        }

        if(numOfClub>=numOfDiamond && numOfClub>=numOfHeart && numOfClub>=numOfSpade)
        {
            if(numOfClub==numOfDiamond)
            {
                if(sumOfClub>=sumOfDiamond)
                {
                    trumpGoal = "club";
                }
                else
                {
                    trumpGoal = "diamond";
                }
            }
            if(numOfClub==numOfHeart)
            {
                if(sumOfClub>=sumOfHeart)
                {
                    trumpGoal = "club";
                }
                else
                {
                    trumpGoal = "heart";
                }
            }
            if(numOfClub==numOfSpade)
            {
                if(sumOfClub>=sumOfSpade)
                {
                    trumpGoal = "club";
                }
                else
                {
                    trumpGoal = "spade";
                }
            }
            else
            {
                trumpGoal = "club";
            }
        }

        if(numOfSpade>=numOfDiamond && numOfSpade>=numOfHeart && numOfSpade>=numOfClub)
        {
            if(numOfSpade==numOfDiamond)
            {
                if(sumOfSpade>=sumOfDiamond)
                {
                    trumpGoal = "spade";
                }
                else
                {
                    trumpGoal = "diamond";
                }
            }
            if(numOfSpade==numOfHeart)
            {
                if(sumOfSpade>=sumOfHeart)
                {
                    trumpGoal = "spade";
                }
                else
                {
                    trumpGoal = "heart";
                }
            }
            if(numOfSpade==numOfClub)
            {
                if(sumOfSpade>=sumOfClub)
                {
                    trumpGoal = "spade";
                }
                else
                {
                    trumpGoal = "club";
                }
            }
            else
            {
                trumpGoal = "spade";
            }
        }

        if(numOfHeart>=numOfDiamond && numOfHeart>=numOfSpade && numOfHeart>=numOfClub)
        {
            if(numOfHeart==numOfDiamond)
            {
                if(sumOfHeart>=sumOfDiamond)
                {
                    trumpGoal = "heart";
                }
                else
                {
                    trumpGoal = "diamond";
                }
            }
            if(numOfHeart==numOfSpade)
            {
                if(sumOfSpade>=sumOfHeart)
                {
                    trumpGoal = "heart";
                }
                else
                {
                    trumpGoal = "spade";
                }
            }
            if(numOfHeart==numOfClub)
            {
                if(sumOfHeart>=sumOfClub)
                {
                    trumpGoal = "heart";
                }
                else
                {
                    trumpGoal = "club";
                }
            }
            else
            {
                trumpGoal = "heart";
            }
        }

        trumpGoalOfPlayer=trumpGoal;

        for (int i = 0; i < 13; i++) {

            if (trumpGoal.equals(hand.get(i).getType())) {
                trumpSum += hand.get(i).getNumber();
                threshold++;
            }
            else if(hand.get(i).getNumber()>=10)
            {
                threshold2++;
            }
        }

        int extra=0;

        if(threshold2-2>=0){

            extra=threshold2-2;
        }

        return threshold+extra;

    }

    public void chooseCardToPlay() {

        //oynayan ilk oyuncu ise
        if(Table.getCurrTurn().equals(this))
        {
            Card biggest=hand.get(0);

            for (int i = 1; i < hand.size(); i++)
            {
                if(!hand.get(i).getType().equals(Table.getTrump()) && biggest.getType().equals(Table.getTrump()))
                {
                    biggest=hand.get(i);
                }
                else if (this.equals(Table.getPlayer2()))
                {
                    if (!hand.get(i).getType().equals(Table.getTrump()) && !biggest.getType().equals(Table.getTrump()) && biggest.getNumber() < hand.get(i).getNumber() && (!Table.getTypesPlayer3DontHave().contains(hand.get(i).getType()) || !Table.getTypesPlayer4DontHave().contains(hand.get(i).getType()) || !Table.getTypesUserDontHave().contains(hand.get(i).getType())))
                    {
                        biggest = hand.get(i);
                    }
                }
                else if (this.equals(Table.getPlayer3()))
                {
                    if(!hand.get(i).getType().equals(Table.getTrump()) && !biggest.getType().equals(Table.getTrump()) && biggest.getNumber() < hand.get(i).getNumber() && (!Table.getTypesPlayer2DontHave().contains(hand.get(i).getType()) || !Table.getTypesPlayer4DontHave().contains(hand.get(i).getType()) || !Table.getTypesUserDontHave().contains(hand.get(i).getType())))
                    {
                        biggest = hand.get(i);
                    }
                }
                else if (this.equals(Table.getPlayer4()))
                {
                    if(!hand.get(i).getType().equals(Table.getTrump()) && !biggest.getType().equals(Table.getTrump()) && biggest.getNumber() < hand.get(i).getNumber() && (!Table.getTypesPlayer3DontHave().contains(hand.get(i).getType()) || !Table.getTypesPlayer2DontHave().contains(hand.get(i).getType()) || !Table.getTypesUserDontHave().contains(hand.get(i).getType())))
                    {
                        biggest = hand.get(i);
                    }
                }
            }

            if(biggest.equals(hand.get(0)) && biggest.getType().equals(Table.getTrump()))
            {
                for (int i = 0; i < hand.size(); i++)
                {
                      if(!biggest.getType().equals(Table.getTrump()) && !hand.get(i).getType().equals(Table.getTrump()) && hand.get(i).getNumber()<biggest.getNumber())
                      {
                          biggest=hand.get(i);
                      }
                      else if (biggest.getType().equals(Table.getTrump()) && !hand.get(i).getType().equals(Table.getTrump()))
                      {
                          biggest=hand.get(i);
                      }
                }

                biggest.setPlayedBy(this);
                this.hand.remove(biggest);
                Table.getCardsOnTheTable().add(biggest);
                Table.getCardsOpened().add(biggest);
            }
            else if(biggest.equals(hand.get(0)) && !biggest.getType().equals(Table.getTrump()))
            {
                biggest.setPlayedBy(this);
                this.hand.remove(biggest);
                Table.getCardsOnTheTable().add(biggest);
                Table.getCardsOpened().add(biggest);
            }
            else
            {
                biggest.setPlayedBy(this);
                this.hand.remove(biggest);
                Table.getCardsOnTheTable().add(biggest);
                Table.getCardsOpened().add(biggest);
            }
        }
        //oyuncu ilk başlamıyosa
        else
        {
            Card card=hand.get(0);

            boolean playNormal=false;
            boolean playTrump=false;
            boolean playElse=false;
            boolean last=false;

            if(Table.getCurrTurn().equals(Table.getPlayer4()) && this.equals(Table.getPlayer3()))
            {
                last=true;
            }
            else if(Table.getCurrTurn().equals(Table.getPlayer3()) && this.equals(Table.getPlayer2()))
            {
                last=true;
            }
            else if(Table.getCurrTurn().equals(Table.getPlayer1()) && this.equals(Table.getPlayer4()))
            {
                last=true;
            }

            for (int i = 0; i < hand.size(); i++)
            {
                if(hand.get(i).getType().equals(Table.getCardsOnTheTable().get(0).getType()))
                {
                    playNormal=true;
                    card=hand.get(i);
                    break;
                }
            }

            if(!playNormal)
            {
                for (int i = 0; i < hand.size(); i++)
                {
                    if (hand.get(i).getType().equals(Table.getTrump()))
                    {
                        playTrump = true;
                        break;
                    }
                }
            }

            if(!playTrump && !playNormal)
            {
                playElse=true;
            }

            //oyuncu normal bir kart oynayacaksa
            if(playNormal)
            {
                //oyuncu sonuncu oynayacaksa
                if(last)
                {
                    ArrayList<Card> playable = new ArrayList<>();

                    for (int i = 0; i < hand.size(); i++)
                    {
                        if(hand.get(i).getType().equals(Table.getCardsOnTheTable().get(0).getType()))
                        {
                            playable.add(hand.get(i));
                        }
                    }

                    boolean trumpOnTheTable=false;

                    for (int i = 0; i < Table.getCardsOnTheTable().size(); i++)
                    {
                        if(Table.getCardsOnTheTable().get(i).getType().equals(Table.getTrump()))
                        {
                            trumpOnTheTable=true;
                            break;
                        }
                    }
                    //masada koz kartı varsa
                    if(trumpOnTheTable)
                    {
                        Card smallest=playable.get(0);

                        for (int i = 0; i < playable.size(); i++)
                        {
                            if(playable.get(i).getNumber()<smallest.getNumber())
                            {
                                smallest=playable.get(i);
                            }
                        }

                        smallest.setPlayedBy(this);
                        this.hand.remove(smallest);
                        Table.getCardsOnTheTable().add(smallest);
                        Table.getCardsOpened().add(smallest);

                    }
                    //masada koz kartı yoksa
                    else
                    {
                        ArrayList<Card> temp = new ArrayList<>();

                        Card biggestOnTheTable=Table.getCardsOnTheTable().get(0);

                        for (int i = 0; i < Table.getCardsOnTheTable().size(); i++)
                        {
                            if(Table.getCardsOnTheTable().get(i).getNumber()>biggestOnTheTable.getNumber())
                            {
                                biggestOnTheTable=Table.getCardsOnTheTable().get(i);
                            }
                        }

                        for (int i = 0; i < playable.size(); i++)
                        {
                            if(playable.get(i).getNumber()>biggestOnTheTable.getNumber())
                            {
                                temp.add(playable.get(i));
                            }
                        }

                        if(temp.size()==0)
                        {
                            Card smallest=playable.get(0);

                            for (int i = 0; i < playable.size(); i++)
                            {
                                if(playable.get(i).getNumber()<smallest.getNumber())
                                {
                                    smallest=playable.get(i);
                                }
                            }

                            smallest.setPlayedBy(this);
                            this.hand.remove(smallest);
                            Table.getCardsOnTheTable().add(smallest);
                            Table.getCardsOpened().add(smallest);

                        }
                        else
                        {
                            Card smallest=temp.get(0);

                            for (int i = 0; i < temp.size(); i++)
                            {
                                if(temp.get(i).getNumber()<smallest.getNumber())
                                {
                                    smallest=temp.get(i);
                                }
                            }

                            smallest.setPlayedBy(this);
                            this.hand.remove(smallest);
                            Table.getCardsOnTheTable().add(smallest);
                            Table.getCardsOpened().add(smallest);

                        }

                    }
                }
                //sonuncu değilse
                else
                {
                    ArrayList<Card> playable = new ArrayList<>();

                    for (int i = 0; i < hand.size(); i++)
                    {
                        if(hand.get(i).getType().equals(Table.getCardsOnTheTable().get(0).getType()))
                        {
                            playable.add(hand.get(i));
                        }
                    }

                    Card biggest=playable.get(0);

                    for (int i = 0; i < playable.size(); i++)
                    {
                        if(playable.get(i).getNumber()>biggest.getNumber())
                        {
                            biggest=playable.get(i);
                        }
                    }

                    boolean thereIsBigger = false;
                    int count=0;

                    for (int i = 0; i < Table.getCardsOpened().size(); i++)
                    {
                        if(Table.getCardsOpened().get(i).getType().equals(Table.getCardsOnTheTable().get(0).getType()) && Table.getCardsOpened().get(i).getNumber()>biggest.getNumber())
                        {
                            count++;
                        }
                    }

                    if(count!=13-biggest.getNumber())
                    {
                        thereIsBigger=true;
                    }

                    if(!thereIsBigger)
                    {
                        if(Table.getCurrTurn().equals(Table.getPlayer1()) && this.equals(Table.getPlayer2()) && (Table.getTypesPlayer3DontHave().contains(Table.getTrump()) && Table.getTypesPlayer4DontHave().contains(Table.getTrump())))
                        {
                            biggest.setPlayedBy(this);
                            this.hand.remove(biggest);
                            Table.getCardsOnTheTable().add(biggest);
                            Table.getCardsOpened().add(biggest);
                        }
                        else if(Table.getCurrTurn().equals(Table.getPlayer1()) && this.equals(Table.getPlayer3()) &&  Table.getTypesPlayer4DontHave().contains(Table.getTrump()))
                        {
                            biggest.setPlayedBy(this);
                            this.hand.remove(biggest);
                            Table.getCardsOnTheTable().add(biggest);
                            Table.getCardsOpened().add(biggest);
                        }
                        else if(Table.getCurrTurn().equals(Table.getPlayer2()) && this.equals(Table.getPlayer3()) && (Table.getTypesPlayer4DontHave().contains(Table.getTrump()) && Table.getTypesUserDontHave().contains(Table.getTrump())))
                        {
                            biggest.setPlayedBy(this);
                            this.hand.remove(biggest);
                            Table.getCardsOnTheTable().add(biggest);
                            Table.getCardsOpened().add(biggest);
                        }
                        else if(Table.getCurrTurn().equals(Table.getPlayer2()) && this.equals(Table.getPlayer4()) && Table.getTypesUserDontHave().contains(Table.getTrump()))
                        {
                            biggest.setPlayedBy(this);
                            this.hand.remove(biggest);
                            Table.getCardsOnTheTable().add(biggest);
                            Table.getCardsOpened().add(biggest);
                        }
                        else if(Table.getCurrTurn().equals(Table.getPlayer3()) && this.equals(Table.getPlayer4()) && (Table.getTypesUserDontHave().contains(Table.getTrump()) && Table.getTypesPlayer2DontHave().contains(Table.getTrump())))
                        {
                            biggest.setPlayedBy(this);
                            this.hand.remove(biggest);
                            Table.getCardsOnTheTable().add(biggest);
                            Table.getCardsOpened().add(biggest);
                        }
                        else if(Table.getCurrTurn().equals(Table.getPlayer4()) && this.equals(Table.getPlayer2()) && Table.getTypesPlayer3DontHave().contains(Table.getTrump()))
                        {
                            biggest.setPlayedBy(this);
                            this.hand.remove(biggest);
                            Table.getCardsOnTheTable().add(biggest);
                            Table.getCardsOpened().add(biggest);
                        }
                        else
                        {
                            Card smallest=playable.get(0);

                            for (int i = 0; i < playable.size(); i++)
                            {
                                if(playable.get(i).getNumber()<smallest.getNumber())
                                {
                                    smallest=playable.get(i);
                                }
                            }

                            smallest.setPlayedBy(this);
                            this.hand.remove(smallest);
                            Table.getCardsOnTheTable().add(smallest);
                            Table.getCardsOpened().add(smallest);
                        }
                    }
                    else
                    {
                        Card smallest=playable.get(0);

                        for (int i = 0; i < playable.size(); i++)
                        {
                            if(playable.get(i).getNumber()<smallest.getNumber())
                            {
                                smallest=playable.get(i);
                            }
                        }

                        smallest.setPlayedBy(this);
                        this.hand.remove(smallest);
                        Table.getCardsOnTheTable().add(smallest);
                        Table.getCardsOpened().add(smallest);

                    }

                }
            }
            //koz oynanacaksa
            else if (playTrump)
            {
                ArrayList<Card> playable = new ArrayList<>();

                for (int i = 0; i < hand.size(); i++)
                {
                    if(hand.get(i).getType().equals(Table.getTrump()))
                    {
                        playable.add(hand.get(i));
                    }
                }

                //sonuncu ise
                if(last)
                {
                    boolean trumpOnTheTable=false;
                    int num=0;

                    for (int i = 0; i < Table.getCardsOnTheTable().size(); i++)
                    {
                        if(Table.getCardsOnTheTable().get(i).getType().equals(Table.getTrump()))
                        {
                            trumpOnTheTable=true;
                            if(Table.getCardsOnTheTable().get(i).getNumber()>num)
                            {
                                num=Table.getCardsOnTheTable().get(i).getNumber();
                            }
                        }
                    }

                    //masada trump yoksa
                    if(trumpOnTheTable)
                    {
                        ArrayList<Card> biggerThanNum = new ArrayList<>();

                        for (int i = 0; i < playable.size(); i++)
                        {
                            if(playable.get(i).getNumber()>num)
                            {
                                biggerThanNum.add(playable.get(i));
                            }
                        }

                        if(biggerThanNum.size()>0)
                        {
                            Card smallest = biggerThanNum.get(0);

                            for (int i = 0; i < biggerThanNum.size(); i++)
                            {
                                if (biggerThanNum.get(i).getNumber() < smallest.getNumber())
                                {
                                    smallest = biggerThanNum.get(i);
                                }
                            }

                            smallest.setPlayedBy(this);
                            this.hand.remove(smallest);
                            Table.getCardsOnTheTable().add(smallest);
                            Table.getCardsOpened().add(smallest);
                            if(this.equals(Table.getPlayer2()) && !Table.getTypesPlayer2DontHave().contains(Table.getCardsOnTheTable().get(0).getType()))
                            {
                                Table.getTypesPlayer2DontHave().add(Table.getCardsOnTheTable().get(0).getType());
                            }
                            else if(this.equals(Table.getPlayer3()) && !Table.getTypesPlayer3DontHave().contains(Table.getCardsOnTheTable().get(0).getType()))
                            {
                                Table.getTypesPlayer3DontHave().add(Table.getCardsOnTheTable().get(0).getType());
                            }
                            else if (this.equals(Table.getPlayer4()) && !Table.getTypesPlayer4DontHave().contains(Table.getCardsOnTheTable().get(0).getType()))
                            {
                                Table.getTypesPlayer4DontHave().add(Table.getCardsOnTheTable().get(0).getType());
                            }
                            else if(this.equals(Table.getPlayer1()) && !Table.getTypesUserDontHave().contains(Table.getCardsOnTheTable().get(0).getType()))
                            {
                                Table.getTypesUserDontHave().add(Table.getCardsOnTheTable().get(0).getType());
                            }
                        }
                        else
                        {
                            Card smallest = playable.get(0);

                            for (int i = 0; i < playable.size(); i++)
                            {
                                if(playable.get(i).getNumber()<smallest.getNumber())
                                {
                                    smallest=playable.get(i);
                                }
                            }

                            smallest.setPlayedBy(this);
                            this.hand.remove(smallest);
                            Table.getCardsOnTheTable().add(smallest);
                            Table.getCardsOpened().add(smallest);
                            if(this.equals(Table.getPlayer2()) && !Table.getTypesPlayer2DontHave().contains(Table.getCardsOnTheTable().get(0).getType()))
                            {
                                Table.getTypesPlayer2DontHave().add(Table.getCardsOnTheTable().get(0).getType());
                            }
                            else if(this.equals(Table.getPlayer3()) && !Table.getTypesPlayer3DontHave().contains(Table.getCardsOnTheTable().get(0).getType()))
                            {
                                Table.getTypesPlayer3DontHave().add(Table.getCardsOnTheTable().get(0).getType());
                            }
                            else if (this.equals(Table.getPlayer4()) && !Table.getTypesPlayer4DontHave().contains(Table.getCardsOnTheTable().get(0).getType()))
                            {
                                Table.getTypesPlayer4DontHave().add(Table.getCardsOnTheTable().get(0).getType());
                            }
                            else if(this.equals(Table.getPlayer1()) && !Table.getTypesUserDontHave().contains(Table.getCardsOnTheTable().get(0).getType()))
                            {
                                Table.getTypesUserDontHave().add(Table.getCardsOnTheTable().get(0).getType());
                            }
                        }
                    }
                    //masada koz yoksa
                    else
                    {
                        Card smallest=playable.get(0);

                        for (int i = 0; i < playable.size(); i++)
                        {
                            if(playable.get(i).getNumber()<smallest.getNumber())
                            {
                                smallest=playable.get(i);
                            }
                        }

                        smallest.setPlayedBy(this);
                        this.hand.remove(smallest);
                        Table.getCardsOnTheTable().add(smallest);
                        Table.getCardsOpened().add(smallest);
                        if(this.equals(Table.getPlayer2()) && !Table.getTypesPlayer2DontHave().contains(Table.getCardsOnTheTable().get(0).getType()))
                        {
                            Table.getTypesPlayer2DontHave().add(Table.getCardsOnTheTable().get(0).getType());
                        }
                        else if(this.equals(Table.getPlayer3()) && !Table.getTypesPlayer3DontHave().contains(Table.getCardsOnTheTable().get(0).getType()))
                        {
                            Table.getTypesPlayer3DontHave().add(Table.getCardsOnTheTable().get(0).getType());
                        }
                        else if (this.equals(Table.getPlayer4()) && !Table.getTypesPlayer4DontHave().contains(Table.getCardsOnTheTable().get(0).getType()))
                        {
                            Table.getTypesPlayer4DontHave().add(Table.getCardsOnTheTable().get(0).getType());
                        }
                        else if(this.equals(Table.getPlayer1()) && !Table.getTypesUserDontHave().contains(Table.getCardsOnTheTable().get(0).getType()))
                        {
                            Table.getTypesUserDontHave().add(Table.getCardsOnTheTable().get(0).getType());
                        }

                    }
                }
                //sonuncu değilse
                else
                {
                    int biggest=0;

                    for (int i = 0; i < Table.getCardsOnTheTable().size(); i++)
                    {
                        if(Table.getCardsOnTheTable().get(i).getNumber()>0)
                        {
                            biggest=Table.getCardsOnTheTable().get(i).getNumber();
                        }
                    }

                    ArrayList<Card> temp = new ArrayList<>();

                    for (int i = 0; i < playable.size(); i++)
                    {
                        if(playable.get(i).getNumber()>biggest)
                        {
                            temp.add(playable.get(i));
                        }
                    }

                    if(temp.size()!=0)
                    {
                        Card smallest=temp.get(0);

                        for (int i = 0; i < temp.size(); i++)
                        {
                            if(temp.get(i).getNumber()<smallest.getNumber())
                            {
                                smallest=temp.get(i);
                            }
                        }

                        smallest.setPlayedBy(this);
                        this.hand.remove(smallest);
                        Table.getCardsOnTheTable().add(smallest);
                        Table.getCardsOpened().add(smallest);
                        if(this.equals(Table.getPlayer2()) && !Table.getTypesPlayer2DontHave().contains(Table.getCardsOnTheTable().get(0).getType()))
                        {
                            Table.getTypesPlayer2DontHave().add(Table.getCardsOnTheTable().get(0).getType());
                        }
                        else if(this.equals(Table.getPlayer3()) && !Table.getTypesPlayer3DontHave().contains(Table.getCardsOnTheTable().get(0).getType()))
                        {
                            Table.getTypesPlayer3DontHave().add(Table.getCardsOnTheTable().get(0).getType());
                        }
                        else if (this.equals(Table.getPlayer4()) && !Table.getTypesPlayer4DontHave().contains(Table.getCardsOnTheTable().get(0).getType()))
                        {
                            Table.getTypesPlayer4DontHave().add(Table.getCardsOnTheTable().get(0).getType());
                        }
                        else if(this.equals(Table.getPlayer1()) && !Table.getTypesUserDontHave().contains(Table.getCardsOnTheTable().get(0).getType()))
                        {
                            Table.getTypesUserDontHave().add(Table.getCardsOnTheTable().get(0).getType());
                        }
                    }
                    else
                    {
                        Card smallest=playable.get(0);

                        for (int i = 0; i < playable.size(); i++)
                        {
                            if(playable.get(i).getNumber()<smallest.getNumber())
                            {
                                smallest=playable.get(i);
                            }
                        }

                        smallest.setPlayedBy(this);
                        this.hand.remove(smallest);
                        Table.getCardsOnTheTable().add(smallest);
                        Table.getCardsOpened().add(smallest);
                        if(this.equals(Table.getPlayer2()) && !Table.getTypesPlayer2DontHave().contains(Table.getCardsOnTheTable().get(0).getType()))
                        {
                            Table.getTypesPlayer2DontHave().add(Table.getCardsOnTheTable().get(0).getType());
                        }
                        else if(this.equals(Table.getPlayer3()) && !Table.getTypesPlayer3DontHave().contains(Table.getCardsOnTheTable().get(0).getType()))
                        {
                            Table.getTypesPlayer3DontHave().add(Table.getCardsOnTheTable().get(0).getType());
                        }
                        else if (this.equals(Table.getPlayer4()) && !Table.getTypesPlayer4DontHave().contains(Table.getCardsOnTheTable().get(0).getType()))
                        {
                            Table.getTypesPlayer4DontHave().add(Table.getCardsOnTheTable().get(0).getType());
                        }
                        else if(this.equals(Table.getPlayer1()) && !Table.getTypesUserDontHave().contains(Table.getCardsOnTheTable().get(0).getType()))
                        {
                            Table.getTypesUserDontHave().add(Table.getCardsOnTheTable().get(0).getType());
                        }
                    }

                }
            }
            else if(playElse)
            {
                ArrayList<Card> playable = new ArrayList<>();

                for (int i = 0; i < hand.size(); i++)
                {
                    if(!hand.get(i).getType().equals(Table.getTrump()) && !hand.get(i).getType().equals(Table.getCardsOnTheTable().get(0).getType()))
                    {
                        playable.add(hand.get(i));
                    }
                }

                Card smallest=playable.get(0);

                for (int i = 0; i < playable.size(); i++)
                {
                    if(playable.get(i).getNumber()<smallest.getNumber())
                    {
                        smallest=playable.get(i);
                    }
                }

                smallest.setPlayedBy(this);
                this.hand.remove(smallest);
                Table.getCardsOnTheTable().add(smallest);
                Table.getCardsOpened().add(smallest);
                if(this.equals(Table.getPlayer2()) && !Table.getTypesPlayer2DontHave().contains(Table.getCardsOnTheTable().get(0).getType()))
                {
                    Table.getTypesPlayer2DontHave().add(Table.getCardsOnTheTable().get(0).getType());
                }
                else if(this.equals(Table.getPlayer3()) && !Table.getTypesPlayer3DontHave().contains(Table.getCardsOnTheTable().get(0).getType()))
                {
                    Table.getTypesPlayer3DontHave().add(Table.getCardsOnTheTable().get(0).getType());
                }
                else if (this.equals(Table.getPlayer4()) && !Table.getTypesPlayer4DontHave().contains(Table.getCardsOnTheTable().get(0).getType()))
                {
                    Table.getTypesPlayer4DontHave().add(Table.getCardsOnTheTable().get(0).getType());
                }
                else if(this.equals(Table.getPlayer1()) && !Table.getTypesUserDontHave().contains(Table.getCardsOnTheTable().get(0).getType()))
                {
                    Table.getTypesUserDontHave().add(Table.getCardsOnTheTable().get(0).getType());
                }

                if(this.equals(Table.getPlayer2()) && !Table.getTypesPlayer2DontHave().contains(Table.getTrump()))
                {
                    Table.getTypesPlayer2DontHave().add(Table.getTrump());
                }
                else if(this.equals(Table.getPlayer3()) && !Table.getTypesPlayer3DontHave().contains(Table.getTrump()))
                {
                    Table.getTypesPlayer3DontHave().add(Table.getTrump());
                }
                else if (this.equals(Table.getPlayer4()) && !Table.getTypesPlayer4DontHave().contains(Table.getTrump()))
                {
                    Table.getTypesPlayer4DontHave().add(Table.getTrump());
                }
                else if(this.equals(Table.getPlayer1()) && !Table.getTypesUserDontHave().contains(Table.getTrump()))
                {
                    Table.getTypesUserDontHave().add(Table.getTrump());
                }

            }

        }
    }

    public ArrayList<Card> getHand() {
        return hand;
    }

    public int getRoundsWon() {
        return roundsWon;
    }

    public int getRoundsWonGoal() {
        return roundsWonGoal;
    }

    public String getTrumpGoalOfPlayer() {
        return trumpGoalOfPlayer;
    }

    public void setRoundsWonGoal(int roundsWonGoal) {
        this.roundsWonGoal = roundsWonGoal;
    }

    public void setRoundsWon(int roundsWon) {
        this.roundsWon = roundsWon;
    }
}
