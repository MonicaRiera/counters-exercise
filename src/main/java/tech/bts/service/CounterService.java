package tech.bts.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tech.bts.model.Counter;

@Service
public class CounterService {

    private Counter counter;

    @Autowired
    public CounterService () {
        this.counter = new Counter();
    }

    public void increment() {
        this.counter.setValue(1);
    }

    public Counter getCounter() {
        return this.counter;
    }


}
