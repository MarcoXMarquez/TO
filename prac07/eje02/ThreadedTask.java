// ThreadedTask.java
public class ThreadedTask implements Runnable {

    private final String name;

    public ThreadedTask(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        Logger logger = Logger.getInstance();
        for (int i = 0; i < 5; i++) {
            logger.log("Hilo " + name + " — iteración " + i);
            try {
                Thread.sleep(50); // breve espera para intercalar
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }
}
