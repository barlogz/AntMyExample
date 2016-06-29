package enterprise.module3_2.square.sum;

public class Runner {
    private int[] testValues = new int[]{2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12};

    public static void main(String[] args) throws Exception {
        Runner runner = new Runner();
        runner.testGetSquareSum();
    }

    public void testGetSquareSum() throws Exception {

        PhaserImpl phaser = new PhaserImpl();
        long result = phaser.getSquareSum(testValues, 4);
        long expected = 649;

        System.out.println("expected :" + expected);
        System.out.println("result:   " + result);

    }
}
