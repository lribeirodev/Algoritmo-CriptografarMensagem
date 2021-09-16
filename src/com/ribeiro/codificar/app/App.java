package com.ribeiro.codificar.app;

import java.util.ArrayList;
import java.util.List;

public class App {
	
	public static void main(String[] args) throws InterruptedException {
		String[] letterRaw = "a,b,c,d,e,f,g,h,i,j,k,l,m,n,o,p,q,r,s,t,u,v,w,x,y,z,á,é,õ,í".split(",");
		String[] letterCode = new String[letterRaw.length];
		List<Integer> letterMath = new ArrayList<>();
		
		String key = "lucas";
		String text = "Olá meu nome é lucas";
		
		while(true) {
			Double code = Math.random() * ((letterRaw.length - 0)+key.length());			
			if(!letterMath.contains(code.intValue())) {if(letterMath.size() < letterRaw.length) {letterMath.add(code.intValue());}else {break;} }		
		}
		
		//System.out.println("Tamanho Code: " + letterMath.size());
		System.out.print("CODE HASH: ");
		letterMath.forEach(e->{System.out.print(e + ";");});
		
		System.out.println(" ");
		
		for(int i = 0 ; i < letterRaw.length ; i++) {
			try {
				letterCode[i] = letterRaw[letterMath.get(i)];
			} catch (Exception e) {
				letterCode[i] = letterRaw[letterMath.get(i) - key.length()];
			}
		}
		
		System.out.print("NEW INDEX: ");
		for(String c : letterCode) {
			System.out.print(c.toUpperCase() + " ");
		}
		
		System.out.print("\nTEXT ENCODE: ");
		
	}
	
}
