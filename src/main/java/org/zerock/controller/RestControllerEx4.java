package org.zerock.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.zerock.domain.Rest1;

import lombok.extern.log4j.Log4j;

@RestController
@RequestMapping("/rest4")
@Log4j
public class RestControllerEx4 {
	
	@RequestMapping(path = "/ex1", produces = MediaType.TEXT_PLAIN_VALUE)
	public String method1() {
		log.info("method1");
		
		return "hello world";
	}
	
	@RequestMapping(path = "/ex2", produces = MediaType.APPLICATION_JSON_VALUE)
	public String method2() {
		log.info("method2");
		
		return "{}";
	}
	
	@RequestMapping(path = "/ex3", 
			produces = {MediaType.APPLICATION_XML_VALUE,
						MediaType.APPLICATION_JSON_VALUE
			})
	public Rest1 method3() {
		log.info("method3");
		
		Rest1 r1 = new Rest1();
		r1.setName("yoon");
		r1.setAge(36);
		r1.setVote(true);
		r1.setObj(null);
		
		return r1;
	}
	
	@RequestMapping(path = "/ex4", produces = MediaType.TEXT_PLAIN_VALUE)
	public String method4() {
		log.info("mehtod4");
		
		return "hello world";		
	}
	
	@RequestMapping(path = "/ex5", produces = MediaType.TEXT_PLAIN_VALUE + ";charset=UTF-8")
	public String method5() {
		log.info("mehtod5");
		
		return "최윤관";		
	}
}
