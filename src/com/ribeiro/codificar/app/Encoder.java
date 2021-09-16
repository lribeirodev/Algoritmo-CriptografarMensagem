package com.ribeiro.codificar.app;

public class Encoder {
	
	private static Encoder instance;
	private String key;
	private String msg;
	
	private Encoder() {}
	
	public static Encoder getInstance() {
		return instance == null ? instance = new Encoder() : instance;
	}	
	
	public void setKey(String key) {
		this.key = key;
	}
	
	public void setMsg(String msg) {
		this.msg = msg;
	}
	
	private String getKey() {
		return key;
	}
	
	private String getMsg() {
		return msg;
	}
	
	public String getEncodeMsg(){
		
		
		
		return null;
	}
	
}
