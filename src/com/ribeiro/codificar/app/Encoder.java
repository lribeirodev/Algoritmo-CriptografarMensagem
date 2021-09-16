package com.ribeiro.codificar.app;

import java.util.ArrayList;
import java.util.List;

public class Encoder {
	
	private static Encoder instance;
	private String key;
	private String msg;
	
	private String[] letterRaw = (" ,ç,ä,ë,ï,ö,ü,ÿ,ã,ñ,õ,â,ê,î,ô,û,á,é,í,ó,ú,ý,à,è,ì,ò,ù,&,a,b"
			+ ",c,d,e,f,g,h,i,j,k,l,m,n,o,p,q,r,s,t,u,v,w,x,y,z,1,2,3,4,5,6,7,8,9,0, "+("ç,ä,ë,ï,ö,ü,ÿ,ã,ñ,õ,â,ê,î,ô,û,á,é,í,ó,ú,ý,à,è,ì,ò,ù,&,a,b,c,d,e,f,g,h,i,j,k,l,m,n,o,p,q,r,s,t,u,v,w,x,y,z,".toUpperCase())).split(",");
	private List<String> letterCode = new ArrayList<>();
	private List<Integer> letterMath = new ArrayList<>();
	private Boolean encode = false;
	
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
	
	public String getLetterRaw() {
		StringBuilder sb = new StringBuilder();
		for(String x : letterRaw) {
			sb.append(x);
		}
		
		return sb.toString();
	}
	
	public String getKeyEncode() {
		StringBuilder sb = new StringBuilder();
		letterMath.forEach(e->sb.append(e + " "));
		return sb.toString();
	}
	
	public String getHash() {
		StringBuilder sb = new StringBuilder();
		letterCode.forEach(e->sb.append(e));
		return sb.toString();
	}
	
	public String getEncodeMsg(){
		
		if(!encode) {
			
			while(true) {
				Double code = Math.random() * ((letterRaw.length - 0)+key.length());			
				if(!letterMath.contains(code.intValue())) {if(letterMath.size() < letterRaw.length) {letterMath.add(code.intValue());}else {break;} }		
			}
			
			for(int i = 0 ; i < letterRaw.length ; i++) {
				try {
					letterCode.add(letterRaw[letterMath.get(i)]);
				} catch (Exception e) {
					letterCode.add(letterRaw[letterMath.get(i) - getKey().length()]);
				}
			}
			
		}
		
		StringBuilder sb = new StringBuilder();
		
		for(String letterFromText : getMsg().split("")) {
			for(int i = 0 ; i < letterRaw.length ; i++) {
				if(letterFromText.contentEquals(letterRaw[i])) {
					//sb.append(letterCode.get(i) + "["+letterRaw[i]+"]");
					sb.append(letterCode.get(i));
				}
			}
		}
		
		return sb.toString();
	}
	
}
