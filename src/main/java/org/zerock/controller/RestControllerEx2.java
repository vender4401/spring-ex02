package org.zerock.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.zerock.domain.Rest1;
import org.zerock.domain.Rest2;

import lombok.extern.log4j.Log4j;

@RestController
@RequestMapping("/rest2")
@Log4j
public class RestControllerEx2 {
	
	@RequestMapping("/ex1")
	public String method1() {
		return "hello2";
	}
	
	@RequestMapping("/ex2")
	public Rest1 method2() {
		// 전송, 수신 방법이 http(HyperText Transper Protocol)
		log.info("method2");
		
		Rest1 r = new Rest1();
		r.setName("donald");
		r.setAge(36);
		
		return r;
	}
	
	@RequestMapping("/ex3")
	public String method3() {
		// 전송, 수신 방법이 http(HyperText Transper Protocol)
		log.info("method3");
		
		Rest1 r = new Rest1();
		r.setName("donald");
		r.setAge(36);
		
//		String res = "이름 :" + r.getName() + "나이 :" + r.getAge();
		String res = "{\"name\":\"" + r.getName() + "\" , \"age\":" + r.getAge() + "}";
		
		return res;
	}
	
	@RequestMapping("/ex4")
	public Rest1 method4() {
		// 전송, 수신 방법이 http(HyperText Transper Protocol)
		log.info("method4");
		
		Rest1 r = new Rest1();
		r.setName("donald");
		r.setAge(36);

		return r;
	}
	
	@RequestMapping("/ex5")
	public Rest2 method5() {
		// 전송, 수신 방법이 http(HyperText Transper Protocol)
		log.info("method5");
		
		Rest2 r2 = new Rest2();
		r2.setAddress("seoul");
		
		Rest1 r1 = new Rest1();
		r1.setName("jeju");
		r1.setAge(100);
		r1.setVote(true);
		
		r2.setRest1(r1);
		
		return r2;
	}
	
	@RequestMapping("/ex6")
	public String[] method6() {
		String[] arr = {"java", "json", "xml"};
		return arr;
	}
	
	@RequestMapping("/ex7")
	public List<String> method7() {
		List<String> list = new ArrayList<>();
		list.add("hello");
		list.add("hello2");
		list.add("hello3");
		list.add("hello4");
		
		return list;
	}
	
	
	@RequestMapping("/ex8")
	public Map<String, String> method8() {
		Map<String, String> map = new HashMap<>();
		map.put("hello", "a");
		map.put("hello2", "a");
		map.put("hello3", "a");
		map.put("hello4", "a");
		
		return map;
	}
	
	@RequestMapping("/ex9")
	public List<Rest1> method9(){
		List<Rest1> list = new ArrayList<>();
		
		Rest1 r1 = new Rest1();
		r1.setName("yoonkwan");
		r1.setAge(36);
		r1.setVote(true);
		
		list.add(r1);
		
		Rest1 r2 = new Rest1();
		r2.setName("choi");
		r2.setAge(99);
		r2.setVote(true);
		
		list.add(r2);
		
		return list;
	}
	
	// 특정 status code로 응답 할때
	@RequestMapping("/ex10")
	public ResponseEntity<String> method10() {
		return ResponseEntity.status(200).body("hello");		
	}
	
	@RequestMapping("/ex11")
	public ResponseEntity<String> method11(int num) {
		if (num > 0) {
			return ResponseEntity.status(200).body("spring");
		} else {
			return ResponseEntity.status(404).body("");
		}
	}
	
}
