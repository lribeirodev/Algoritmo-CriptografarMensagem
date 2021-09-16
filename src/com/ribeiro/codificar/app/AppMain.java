package com.ribeiro.codificar.app;

public class AppMain {
	
	public static void main(String[] args) {
		
		Encoder ec = Encoder.getInstance();
		ec.setKey("lucas nunes ribeiro");
		
		String msg = "esta mensagem foi criptografada mané";
		ec.setMsg(msg);
		System.out.println("RAW: " + msg.toUpperCase() + "\nENCODED: " + ec.getEncodeMsg() + "\nHASH:     " + ec.getHash() +"\nORIGINAL: " + ec.getLetterRaw());
		
		System.out.println("KEY DNA: ");
		String[] key = ec.getKeyEncode().replaceAll("$", " ").split(" ");
		int i = 0;
		for(String s : key) {
			
			if(i<10) {
				
				if(i<9) {
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
