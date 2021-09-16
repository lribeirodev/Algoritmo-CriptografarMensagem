package com.ribeiro.codificar.app;

public class AppMain {
	
	public static void main(String[] args) {
		
		Encoder ec = Encoder.getInstance();
		ec.setKey("boladao");
		
		String msg = "ola";
		ec.setMsg(msg);
		System.out.println("RAW: " + msg.toUpperCase() + "\nENCODED: " + ec.getEncodeMsg() + "\nHASH: " + ec.getHash() + "\nKEY: " + ec.getKeyEncode());
	}
	
}
