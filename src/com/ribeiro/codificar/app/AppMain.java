package com.ribeiro.codificar.app;

import com.ribeiro.codificar.qrcode.QrCode;

public class AppMain {
	
	public static void main(String[] args) {
		
		Encoder ec = Encoder.getInstance();
		String keyPass = "JesusChave";
		ec.setKey(keyPass);
		
		String msg = "Olá meu nome é Lucas Ribeiro";
		ec.setMsg(msg);
		
		toString(ec,msg,keyPass);
		
	}
	
	private static void toString(Encoder ec, String msg, String keyPass){
		System.out.println("RAW: " + msg + "\nENCODED: [" + ec.getEncodeMsg() + "]\nHASH:     [" + ec.getHash() + "] : " + ec.getHash().length()+"\nORIGINAL: [" + ec.getLetterRaw() + "] : " + ec.getLetterRaw().length());
		
		System.out.println("KEY DNA: ");
		String[] key = ec.getKeyEncode().split(" ");
		int i = 0;
		int limit = 20;
		for(String s : key) {
			
//			if(i<limit) {
//				
//				if(i<limit-1) {
//					System.out.print(s + " ");
//				}else {
//					System.out.print(s);
//				}
//				
//				i++;
//			}else {
//				System.out.println("");
//				i=0;
//			}	
			
			System.out.print(s + " ");
			
		}
		
		try {
			QrCode.getInstance().gerar(ec.getEncodeMsg(), "C:\\Users\\0102051672\\Downloads\\criptografado.png");
			System.out.println("\nQR CODE GENERATED\n");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		if(true) {
			Decoder dc = Decoder.getInstance();
			
			dc.setKeyPass(keyPass);
			dc.setKeyDna(ec.getKeyEncode());
			dc.setMsg(ec.getEncodeMsg());
			
			dc.decodeMessage();
		}
	}
	
}
