package com.example.test2.controller;

import com.example.test2.entity.Hello;
import com.example.test2.service.HelloService;
import com.fasterxml.jackson.databind.util.JSONPObject;
import lombok.RequiredArgsConstructor;
import org.json.simple.JSONObject;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import java.util.Date;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class TestController {

    private final HelloService helloService;

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
