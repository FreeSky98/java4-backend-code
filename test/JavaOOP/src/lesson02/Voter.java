package lesson02;

public class Voter {
    static int count;

    public void vote() {
        System.out.println("已投一票，当前票数：" + ++count);
    }

    public final static int MAX_COUNT = 100;

    public Voter() {
        if (count == MAX_COUNT) {
            System.exit(0);
        }
    }
}
class VoterTest {
    public static void main(String[] args) {
        Voter voter = new Voter();
        for (int i = 0; i < Voter.MAX_COUNT; i++) {
            voter.vote();
        }
    }
}
