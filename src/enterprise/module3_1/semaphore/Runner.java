package enterprise.module3_1.semaphore;

public class Runner {
    private static SemaphoreImpl semaphore;

    public static void main(String[] args) throws Exception {
        Runner runner = new Runner();
        runner.testAcquire();

    }
    private void testAcquire() throws Exception {

        int threads = 3;
        semaphore = new SemaphoreImpl(1);

        for (int i = 0; i < threads; i++) {
            new Thread(new WorkerForAcquire()).start();
        }

        while (WorkerForAcquire.counter < threads) {
            Thread.sleep(500);
        }
    }

    private static class WorkerForAcquire implements Runnable {
        private static int counter = 0;

        @Override
        public void run() {
            try {
                semaphore.acquire();
                Thread.sleep(500);
                semaphore.release();
                counter++;
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }

}
