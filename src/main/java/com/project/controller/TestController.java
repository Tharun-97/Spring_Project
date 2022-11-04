package com.project.controller;

import java.util.ArrayList;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
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

	@Autowired
	Calculator cal;
	
	@GetMapping(value = "testAPI")
	public ResponseEntity<?> testAPI(@RequestParam String operation, @RequestParam long a, @RequestParam long b)
			throws Exception {
		ArrayList<String> choice = new ArrayList<>(Arrays.asList("add", "sub", "mul", "divide"));
		int index = 0;
		if (choice.contains(operation) == true) {
			index = choice.indexOf(operation);
		} else if (choice.contains(operation) == false) {
			index = 4;
		}
		ArrayList<String> al = new ArrayList<>();
		al.add(cal.add(a, b));
		al.add(cal.sub(a, b));
		al.add(cal.mul(a, b));
		al.add(cal.divide(a, b));
		return new ResponseEntity(al.get(index), HttpStatus.OK);
				
				
	}
}
