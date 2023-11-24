package ru.egartech.service;


import lombok.extern.log4j.Log4j2;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Log4j2
@Service
@EnableAsync
public class ScheduledTaskService {

/**
 * Аннотация @Scheduled позволяет выполнять задачи с фиксированной задержкой.
 * Время задержки отсчитывается с момента завершения выполнения предыдущей задачи,
 * при этом по умолчанию все задачи выполняются в одном потоке.
 * Каждая последующая задача не выполнится до тех пор, пока предыдущая задача не завершит своё выполнение
 * */

// fixedDelay - время задержки  в миллисекундах
    @Scheduled(fixedDelay = 1000)
    public void scheduleFixedDelayTask() throws InterruptedException {
        log.info("scheduleFixedDelayTask: begin");
        Thread.sleep(2000);
        log.info("scheduleFixedDelayTask: end");
    }

// initialDelay задержка перед первым выполнением метода
/*    @Scheduled(fixedDelay = 1000, initialDelay = 10000)
    public void scheduleFixedRateWithInitialDelayTask() throws InterruptedException {
        log.info("scheduleFixedRateWithInitialDelayTask: begin");
        Thread.sleep(3000);
        log.info("scheduleFixedRateWithInitialDelayTask: end");
    }*/


    /**
     * задачи запускаются ровно через определённый промежуток времени
     * и не ожидают завершения друг друга, при условии что планировщик задач их не запускает в одном потоке
     * */
    //fixedRate - время, через которое будет запущена новая задача
    //значение в fixedRate больше чем значение в Thread.sleep, то есть работа метода укладывается в заданный интервал
/*    @Scheduled(fixedRate = 3000)
    public void scheduleFixedRateTask() throws InterruptedException {
        log.info("scheduleFixedRateTask: begin");
        Thread.sleep(1000);
        log.info("scheduleFixedRateTask: end");
    }*/

    // fixedRate=1000 и Thread.sleep(3000)
    @Async
    @Scheduled(fixedRate = 1000)
    public void scheduleFixedRateTask() throws InterruptedException {
        log.info("scheduleFixedRateTask: begin");
        Thread.sleep(3000);
        log.info("scheduleFixedRateTask: end");
    }
}
