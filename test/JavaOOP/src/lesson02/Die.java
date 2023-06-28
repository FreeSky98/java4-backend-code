package lesson02;

public class Die {
    static int faceValue;

    public static int roll() {
        return faceValue = (int)(Math.random() * 6) + 1;
    }
    public int getFaceValue() {
        return roll();
    }
}

class DiceGame {
    static Die die1 = new Die();
    static Die die2 = new Die();
    public boolean play() {
        int a = die1.getFaceValue();
        int b = die2.getFaceValue();
        System.out.println("a = " + a);
        System.out.println("b = " + b);

        return a + b == 7;
    }
}

class DieTest {
    public static void main(String[] args) {
        DiceGame diceGame = new DiceGame();
        if (diceGame.play()) {
            System.out.println("恭喜你！你赢了！");
        } else {
            System.out.println("很遗憾！你输了！");
        }
    }
}