package com.project.service;

import java.util.ArrayList;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

@Service
public class Calculator implements Operations {
	
	long c;
	
	@Override
	public String add(long a, long b) {
		c= a+b;
		return "ADDITION: "+c;
	}

	@Override
	public String sub(long a, long b) {
		c= a-b;
		return "SUBTACTION: "+c;
	}

	@Override
	public String mul(long a, long b) {
		
		c= a*b;
		return "MULTIPLCATION: "+c;
	}

	@Override
	public String divide(long a, long b) {
		
		c= a/b;
		return "DIVISION: "+c;
	}

	

}
