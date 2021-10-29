package com.session;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

import javax.script.Invocable;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
public class P21 {

	public static void main(String[] args) throws FileNotFoundException, ScriptException, IOException, NoSuchMethodException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		ScriptEngine engine = new ScriptEngineManager().getEngineByName("nashorn");
		engine.eval(new FileReader("res/calci.js"));
		
		// take two number input from user
		System.out.println("Enter any two numbers");
		int num1 = Integer.parseInt(br.readLine());
		int num2 = Integer.parseInt(br.readLine());
		
		Invocable invoke = (Invocable) engine;
		invoke.invokeFunction("add", num1, num2);
		invoke.invokeFunction("sub", num1, num2);
		invoke.invokeFunction("multi", num1, num2);
		
		if(num2 == 0) invoke.invokeFunction("div", num1, 1); // a default procedure
		else invoke.invokeFunction("div", num1, num2);
		
	}

}
