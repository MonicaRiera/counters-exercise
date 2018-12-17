package tech.bts.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import tech.bts.util.HandlebarsUtil;
import tech.bts.model.Counter;
import tech.bts.service.CounterService;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping(path = "/counter")
public class CounterController {

    private CounterService counterService;

    @Autowired
    public CounterController(CounterService counterService) {
        this.counterService = counterService;
    }

    @RequestMapping(method = RequestMethod.GET)
    public String getCounter() throws Exception{
        Counter counter = this.counterService.getCounter();
        Map<String, Object> counterMap = new HashMap<>();
        counterMap.put("counter", counter);
        return HandlebarsUtil.getTemplate("counter", counterMap);
    }

    @RequestMapping(method = RequestMethod.GET, path = "/increment")
    public void increment(HttpServletResponse response) throws IOException {
        this.counterService.increment();
        response.sendRedirect("/counter");
    }


}
