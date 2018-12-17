package tech.bts.model;

import org.junit.Test;
import tech.bts.service.CounterService;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class CounterTest {

    @Test
    public void defaultValues() {
        CounterService counterService = new CounterService();
        Counter counter = new Counter(counterService.getNextId());

        assertThat(counter.getFormNumber(), is(1));
        assertThat(counter.getValue(), is(0));
    }

    @Test
    public void increment() {
        CounterService counterService = new CounterService();
        Counter counter = new Counter(counterService.getNextId());
        assertThat(counter.getValue(), is(0));
        counter.increment();
        assertThat(counter.getValue(), is(1));
    }

    @Test
    public void add() {
        CounterService counterService = new CounterService();
        Counter counter = new Counter(counterService.getNextId());
        assertThat(counter.getValue(), is(0));
        counter.addValue(5);
        assertThat(counter.getValue(), is(5));
    }



}