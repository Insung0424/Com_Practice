package com.nex.hello;

import java.text.DateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import org.json.simple.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.nex.service.TestService;
import com.nex.testDTO.TestData;

import lombok.extern.slf4j.Slf4j;

/**
 * Handles requests for the application home page.
 */

@Slf4j
@Controller
public class HomeController {
	
	@Autowired
	private TestService testservice;
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		String formattedDate = dateFormat.format(date);
		model.addAttribute("serverTime", formattedDate );
		
		log.info("=========== DB connect start ===========");
		long start = System.currentTimeMillis();
		
		List<TestData> total = testservice.getAll();
		for(TestData i : total) {
			log.info("TestData N_id : "+ String.valueOf(i.getId()));
			log.info("TestData N_word : "+ i.getWord());
		}
		
		int randomN = (int)(Math.random()*total.size())+1;
		TestData randomData = testservice.getOne(randomN);
		model.addAttribute("randomData", randomData);
		
		Long end = System.currentTimeMillis();
		long time = end - start;
		log.info("=========== DB connect end ===========");
		log.info("Time : " + time/1e3 + "s");
		
		return "home";
	}
	
	@GetMapping("/getOne")
	@ResponseBody
	public TestData getone() {
		
		List<TestData> total = testservice.getAll();
		int randomN = (int)(Math.random()*total.size())+1;
		TestData randomData = testservice.getOne(randomN);
		
		return randomData;
	}
	
	@PostMapping("/input")
	@ResponseBody
	public String inputData(@RequestBody TestData testData) {
		log.info("insert");
		int t1 = testservice.insertData(testData.getWord());
		boolean bt1 = t1>0 ? true : false;
		String result = bt1 ? "success" : "fail";
		log.info("입력결과: " + result);
		log.info("end");
		return result;
	}
	
}
