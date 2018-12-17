package tech.bts.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import tech.bts.util.HandlebarsUtil;
import tech.bts.model.Counter;
import tech.bts.service.CounterService;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(path = "/counters")
public class CounterController {

    private CounterService counterService;

    @Autowired
    public CounterController(CounterService counterService) {
        this.counterService = counterService;
    }

    @RequestMapping(method = RequestMethod.GET)
    public String getCounters() throws Exception{
        List<Counter> counters = this.counterService.getCounters();
        Map<String, Object> counterMap = new HashMap<>();
        counterMap.put("counter", counters);
        return HandlebarsUtil.getTemplate("counter", counterMap);
    }

    @RequestMapping(method = RequestMethod.POST, path = "/increment/{id}")
    public void increment(HttpServletResponse response, @PathVariable long id, int value) throws IOException {
        this.counterService.increment(id, value);
        response.sendRedirect("/counters");
    }

    @RequestMapping(method = RequestMethod.GET, path = "/add")
    public void addCounter(HttpServletResponse response) throws IOException{
        this.counterService.addCounter();
        response.sendRedirect("/counters");
    }


}
