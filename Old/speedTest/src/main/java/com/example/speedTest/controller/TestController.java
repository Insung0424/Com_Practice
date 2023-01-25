package com.example.speedTest.controller;

import com.example.speedTest.entity.Hello;
import com.example.speedTest.service.HelloService;
import lombok.RequiredArgsConstructor;
import org.json.simple.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Controller
@RequiredArgsConstructor
public class TestController {

    private final HelloService helloService;

    @GetMapping("/")
    @ResponseBody
    public String che() {
        Long start = System.currentTimeMillis();
        List<Hello> total = helloService.findTextAll();

        long r = (long) (Math.random()*total.size()+1);
        Optional<Hello> h = helloService.findId(r);

        Long end = System.currentTimeMillis();
        Long time = end-start;

        return time/1e3 + "s";
    }

    @GetMapping("/get/data")
    @ResponseBody
    public String dynamicHello(){

        List<Hello> helloList = helloService.findTextAll();

        int helloCnt = helloList.size();

//        if(helloCnt == 0){
//            helloService.save(Hello.builder().word(data).build());
//        }
//        등록 구현 주석 처리
//        helloService.save(Hello.builder().word(data).build());
//        // 중복등록이 되지말아야할 이유가 없나?

        Long id = (long) (Math.random() * helloCnt + 1);

        String content = helloService.findId(id).get().getWord();
        return content;

    }

    @GetMapping("/api/hello")
    @ResponseBody
    public JSONObject hello(){
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("content","hello 현재 시간은 "+ new Date() + " 입니다.");
        return jsonObject;
    }

}
