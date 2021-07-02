package golovnev;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Класс, который содержит тесты по каждому из состояний потока
 */
class Task10Test {

    /**
     * Тест для проверки состояния потока {@link Thread.State#NEW}.
     * Имеет такое состояние до запуска потока.
     */
    @Test
    void testNewState() {
        Thread thread = new Thread();
        assertEquals(Thread.State.NEW, thread.getState());
    }

    /**
     * Тест для проверки состояния потока {@link Thread.State#RUNNABLE}.
     * Имеет такое состояние после запуска потока с помощью {@link Thread#start()}
     */
    @Test
    void testRunnableState() {
        Thread thread = new Thread();
        thread.start();
        assertEquals(Thread.State.RUNNABLE, thread.getState());
    }

    /**
     * Тест для проверки состояния потока {@link Thread.State#TERMINATED}.
     * Имеет такое состояние после запуска потока и полного завершения. Возможно добиться методом {@link Thread#join()}.
     * @throws InterruptedException выкидывается методом {@link Thread#join()}, если прерывается выполнения метода
     */
    @Test
    void testTerminatedState() throws InterruptedException {
        Thread thread = new Thread();
        thread.start();
        thread.join();
        assertEquals(Thread.State.TERMINATED, thread.getState());
    }

    /**
     * Тест для проверки состояния потока {@link Thread.State#WAITING}.
     * Имеет такое состояние после запуска потока и его приостановкой во время выполнения
     * с помощью метода {@link Thread#wait()}.
     * @throws InterruptedException выкидывается методом {@link Thread#sleep(long)}, если прерывается выполнения метода
     */
    @Test
    void testWaitingState() throws InterruptedException {
        Thread thread = new Thread(new Task10()::waitingState);
        thread.start();
        Thread.sleep(1);

        assertEquals(Thread.State.WAITING, thread.getState());
    }

    /**
     * Тест для проверки состояния потока {@link Thread.State#TIMED_WAITING}.
     * Имеет такое состояние после запуска потока и его приостановкой во время выполнения. Возможно добиться методом {@link Thread#sleep(long)}.
     * @throws InterruptedException выкидывается методом {@link Thread#sleep(long)}, если прерывается выполнения метода
     */
    @Test
    void testTimedWaitingState() throws InterruptedException {
        Thread thread = new Thread(new Task10()::timedWaitingState);
        thread.start();
        Thread.sleep(1);

        assertEquals(Thread.State.TIMED_WAITING, thread.getState());
    }

    /**
     * Тест для проверки состояния потока {@link Thread.State#BLOCKED}.
     * Имеет такое состояние после запуска потока и блокируется, если занят мьютекс статического объекта в классе.
     * @throws InterruptedException выкидывается методом {@link Thread#sleep(long)}, если прерывается выполнения метода
     */
    @Test
    void testBlockedState() throws InterruptedException {
        Thread thread = new Thread(new Task10()::blockedState);
        Thread thread2 = new Thread(new Task10()::blockedState);
        thread.start();
        thread2.start();
        Thread.sleep(1);
        assertEquals(Thread.State.BLOCKED, thread2.getState());
    }
}