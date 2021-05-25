public class PairOfDice {

    public int die1;
    public int die2;

    public PairOfDice() {
        roll();
    }

    public PairOfDice(int val1, int val2) {
        die1 = val1;
        die2 = val2;
    }

    public void roll() {
        die1 = (int)(Math.random()*6) + 1;
        die2 = (int)(Math.random()*6) + 1;
    }

    public String toString() {
        if (die1 == die2)
            return "double " + die1;
        else
            return die1 + " and " + die2;
    }

}
