package com.example.demo.controller;

import com.example.demo.entity.Hello;
import com.example.demo.service.HelloService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class TestController {

    private final HelloService helloService;

    @GetMapping("/{data}")
    @ResponseBody
    public String dynamicHello(@PathVariable String data){

        List<Hello> helloList = helloService.findTextAll();

        int helloCnt = helloList.size();

        if(helloCnt == 0){
            helloService.save(Hello.builder().word(data).build());
        }

        helloService.save(Hello.builder().word(data).build());
        // 중복등록이 되지말아야할 이유가 없나?

        Long id = (long) (Math.random() * helloCnt + 1);
        return helloService.findId(id).get().getWord();

    }

}
