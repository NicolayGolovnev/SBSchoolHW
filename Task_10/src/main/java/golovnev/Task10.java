package golovnev;

/**
 * Класс, в котором присутствуют вспомогательные методы для получения 3 состояний потока:
 * {@link Thread.State#WAITING}, {@link Thread.State#TIMED_WAITING}, {@link Thread.State#BLOCKED}
 */
public class Task10{
    /**
     * Объект {@code blocker}, который нужен для получения состояния {@link Thread.State#BLOCKED}
     */
    private final static Object blocker = new Object();

    /**
     * Метод, с помощью которого мы сможем получить состояние {@link Thread.State#WAITING}
     */
    public synchronized void waitingState() {
        try {
            wait();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * Метод, с помощью которого мы сможем получить состояние {@link Thread.State#TIMED_WAITING}
     */
    public synchronized void timedWaitingState() {
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * Метод, с помощью которого мы сможем получить состояние {@link Thread.State#BLOCKED}
     */
    public void blockedState() {
        synchronized (blocker) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
