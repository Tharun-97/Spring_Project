package com.project.service;

import java.util.ArrayList;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

@Service
public class Calculator implements Operations {
	
	int c;
	
	@Override
	public int add(int a, int b) {
		c= a+b;
		return c;
	}

	@Override
	public int sub(int a, int b) {
		c= a-b;
		return c;
	}

	@Override
	public int mul(int a, int b) {
		
		c= a*b;
		return c;
	}

	@Override
	public int divide(int a, int b) {
		
		c= a/b;
		return c;
	}

	

}
