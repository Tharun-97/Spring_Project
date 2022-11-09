package com.project.controller;

import java.io.FileInputStream;
import java.util.InputMismatchException;
import java.util.Map;
import java.util.Properties;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.project.service.Calculator;


@RestController
@RequestMapping("/api/")
public class TestController {
	
	
	@Value("${file.path}")
	String path;
	

	@Autowired
	Calculator cal;

	@GetMapping(value = "testAPI")
	
	public ResponseEntity<?> testAPI(@RequestParam Map<String, String> request) throws Exception {
			request.put("Controller", "1");
		
		try {
			String operation = request.get("operation");
			int v1 = Integer.parseInt(request.get("a"));
			int v2 = Integer.parseInt(request.get("b"));
			int result = 0;
			if ("add".equals(operation)) {
				result = cal.add(v1, v2);
			} else if ("sub".equals(operation)) {
				result = cal.sub(v1, v2);
			} else if ("mul".equals(operation)) {
				result = cal.mul(v1, v2);
			} else if ("div".equals(operation)) {
				result = cal.divide(v1, v2);
			} else {
				throw new InputMismatchException("Invalid Operation");
			}
			request.put("Result", result + "");
			request.put("Status", "Success");

		} catch (Exception e) {
			request.put("Status", "Failure");
			request.put("ERROR", e.getMessage());
		}

		return new ResponseEntity(request, HttpStatus.OK);

	}

	@GetMapping(value = "testAPI1")
	public ResponseEntity<?> testAPI1(@RequestParam Map<String, String> request) throws Exception {
		request.put("Controller", "2");
		
		Properties p=null;
		try {
			FileInputStream f = new FileInputStream("E:\\demo.properties");
			p = new Properties();
			p.load(f);

		} catch (Exception e) {
			System.out.println(e);
			request.put("Status", "Failure");
			request.put("ERROR", e.getMessage());
		}

		return new ResponseEntity(p, HttpStatus.OK);

	}
	
		
	
	
	@GetMapping(value = "testAPI2")
	public ResponseEntity<?> testAPI2(@RequestParam Map<String, String> request) throws Exception {
		request.put("Controller", "3");
		
		Properties p=null;
		try {
			FileInputStream f = new FileInputStream(path);
			p = new Properties();
			p.load(f);
			System.out.println(p);

		} catch (Exception e) {
			System.out.println(e);
			request.put("Status", "Failure");
			request.put("ERROR", e.getMessage());
		}

		return new ResponseEntity(p, HttpStatus.OK);

	}
}
