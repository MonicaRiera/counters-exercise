package tech.bts.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tech.bts.model.Counter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class CounterService {

    private Map<Long, Counter> counterMap;
    private long nextId;

    @Autowired
    public CounterService () {
        this.counterMap = new HashMap<>();
        this.nextId = 0;
    }

    public void increment(long id, int value) {
        Counter counter = counterMap.get(id);
        counter.setValue(value);
    }

    public List<Counter> getCounters() {
        return new ArrayList<>(counterMap.values());
    }

    public void addCounter() {
        Counter counter = new Counter();
        counter.setId(nextId);
        nextId++;
        this.counterMap.put(counter.getId(), counter);
    }


}
