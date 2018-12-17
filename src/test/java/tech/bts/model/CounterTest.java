package tech.bts.model;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class CounterTest {

    @Test
    public void defaultValues() {
        Counter counter = new Counter();

        assertThat(counter.getFormNumber(), is(1));
        assertThat(counter.getValue(), is(0));
    }

    @Test
    public void increment() {
        Counter counter = new Counter();
        assertThat(counter.getValue(), is(0));
        counter.increment();
        assertThat(counter.getValue(), is(1));
    }

    @Test
    public void add() {
        Counter counter = new Counter();
        assertThat(counter.getValue(), is(0));
        counter.setValue(5);
        assertThat(counter.getValue(), is(5));
    }



}