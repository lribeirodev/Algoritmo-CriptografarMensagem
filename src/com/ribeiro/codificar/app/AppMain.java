package com.ribeiro.codificar.app;

public class AppMain {
	
	public static void main(String[] args) {
		
		Encoder ec = Encoder.getInstance();
		ec.setKey("Programador");
		
		String msg = "Olá meu nome é Lucas Ribeiro sou programador Java";
		ec.setMsg(msg);
		
		toString(ec,msg);
		
	}
	
	private static void toString(Encoder ec, String msg){
		System.out.println("RAW: " + msg + "\nENCODED: [" + ec.getEncodeMsg() + "]\nHASH:     " + ec.getHash() + ": " + ec.getHash().length()+"\nORIGINAL: " + ec.getLetterRaw() + ": " + ec.getLetterRaw().length());
		
		System.out.println("KEY DNA: ");
		String[] key = ec.getKeyEncode().split(" ");
		int i = 0;
		int limit = 20;
		for(String s : key) {
			
			if(i<limit) {
				
				if(i<limit-1) {
					System.out.print(s + " ");
				}else {
					System.out.print(s);
				}
				
				i++;
			}else {
				System.out.println("");
				i=0;
			}			
		}
		
	}
	
}
