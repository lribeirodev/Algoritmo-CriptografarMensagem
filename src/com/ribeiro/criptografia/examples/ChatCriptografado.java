package com.ribeiro.criptografia.examples;

import java.util.Scanner;

import com.ribeiro.criptografia.app.Decrypt;
import com.ribeiro.criptografia.app.Encrypt;

public class ChatCriptografado {

	public static void main(String[] args) {		
		
		System.out.println("Sistema Simples de Mensagem Criptografada");
		
		Encrypt ec = Encrypt.getInstance();
		Decrypt dc = Decrypt.getInstance();
		Scanner s = new Scanner(System.in);
		
		String keyPass = "chaveMestra";
		
		ec.setMsg("backend");
		
		ec.setKeyPass(keyPass);
		dc.setKeyPass(keyPass);
		
		ec.encryptMessage();
		dc.setKeyDna(ec.getKeyEncrypt());
		
		System.out.println("KEY PASS: " + keyPass +"\nKEY DNA:" + ec.getKeyEncrypt() + "\n\nInsira sua Mensagem");
		
		String x = null;
		System.out.print("Mensagem: ");
		while(!(x = s.nextLine()).equals("sair")) {
			ec.setMsg(x);
			String encryptMsg = ec.encryptMessage();
			dc.setMsg(encryptMsg);
			
			System.out.println("Criptografada: " + encryptMsg);
			System.out.println("Descriptografada:" + dc.decryptMessage());
			System.out.println("Contém erros: " + (x.contentEquals(dc.decryptMessage()) == true ? "NÃO" : "SIM")  + "\n");
			System.out.print("Mensagem: ");
		}
		
		s.close();
		
	}

}
