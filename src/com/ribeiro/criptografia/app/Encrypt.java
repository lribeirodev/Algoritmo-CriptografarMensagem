package com.ribeiro.criptografia.app;

import java.util.ArrayList;
import java.util.List;

public class Encrypt {
	/**
	 * Classe para geração da mensagem codificada
		@author Lucas Ribeiro
		@Atualizado 2021
	**/
	
	private static Encrypt instance;
	private String keyPass;
	private String msg;
	
	private String[] letterRaw = "çäëïöüÿãñõâêîôûáéíóúıàèìòù&abcdefghijklmnopqrstuvwxyz1234567890ÇÄËÏÖÜŸÃÑÕÂÊÎÔÛÁÉÍÓÚİÀÈÌÒÙABCDEFGHIJKLMNOPQRSTUVWXYZ,.;!@#$%¨&*~()^´`\"\n\s\t:-_".split("");
	private List<String> letterCode = new ArrayList<>();
	private List<Integer> letterMath = new ArrayList<>();
	private Boolean encode = false;
	
	private Encrypt() {}
	
	public static Encrypt getInstance() {		
		return instance == null ? instance = new Encrypt() : instance;
	}
	
	public void setKeyPass(String keyPass) {
		this.keyPass = keyPass;
	}
	
	public void setMsg(String msg) {
		this.msg = msg;
	}
	
	private String getKeyPass() {
		return keyPass;
	}
	
	private String getMsg() {
		return msg;
	}
	
	public String getLetterRaw() {
		StringBuilder sb = new StringBuilder();
		for(String x : letterRaw) {
			sb.append(x);
		}
		
		return sb.toString();
	}
	
	public String getKeyEncrypt() {
		StringBuilder sb = new StringBuilder();
		letterMath.forEach(e->sb.append(e + " "));
		return sb.toString();
	}
	
	public String getHash() {
		StringBuilder sb = new StringBuilder();
		letterCode.forEach(e->sb.append(e));
		return sb.toString();
	}
	
	public String encryptMessage(){
		
		if(!encode) {
			
			while(true) {
				Double code = Math.random() * ((letterRaw.length - 0) + keyPass.length());			
				if(!letterMath.contains(code.intValue())) {if(letterMath.size() < letterRaw.length) {letterMath.add(code.intValue());}else {break;} }		
			}
			
			for(int i = 0 ; i < letterRaw.length ; i++) {
				
				try {
					letterCode.add(letterRaw[letterMath.get(i)]);
				} catch (Exception e) {
					letterCode.add(letterRaw[letterMath.get(i) - getKeyPass().length()]);
				}
				
//				if(letterMath.get(i) > letterRaw.length-1) {
//					letterCode.add(letterRaw[letterMath.get(i) - getKey().length()]);
//				} else {
//					letterCode.add(letterRaw[letterMath.get(i)]);
//				}
				
			}
			
		}
		
		StringBuilder sb = new StringBuilder();
		
		for(String letterFromText : getMsg().split("")) {
			
			for(int i = 0 ; i < letterRaw.length ; i++) {
				if(letterFromText.codePointAt(0) == letterRaw[i].codePointAt(0)) {
					//sb.append(letterCode.get(i) + "["+letterRaw[i]+"]");
					//sb.append("["+letterRaw[i]+"] ");
					sb.append(letterCode.get(i));
				}
			}
		}
		
		return sb.toString();
	}
	
}
