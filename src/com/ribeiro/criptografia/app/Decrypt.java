package com.ribeiro.criptografia.app;

public class Decrypt {
	
	private static Decrypt instance;
	private String keyDna;
	private String keyPass;
	private String msgEncrypt;
	
	private String[] letterRaw = "çäëïöüÿãñõâêîôûáéíóúıàèìòù&abcdefghijklmnopqrstuvwxyz1234567890ÇÄËÏÖÜŸÃÑÕÂÊÎÔÛÁÉÍÓÚİÀÈÌÒÙABCDEFGHIJKLMNOPQRSTUVWXYZ,.;!@#$%¨&*~()^´`\"\n\s\t:-_".split("");
	private String[] reverseRaw = new String[letterRaw.length];
	
	private Boolean decode = false;
	
	private Decrypt() {}
	
	public static Decrypt getInstance() {
		return instance == null ? instance = new Decrypt() : instance;
	}
	
	private String getKeyPass() {
		return keyPass;
	}
	
	public void setKeyPass(String keyPass) {
		this.keyPass = keyPass;
	}
	
	private String getKeyDna() {
		return keyDna;
	}

	public void setKeyDna(String keyDna) {
		this.keyDna = keyDna;
	}

	private String getMsg() {
		return msgEncrypt;
	}

	public void setMsg(String msg) {
		this.msgEncrypt = msg;
	}
	
	public String decryptMessage() {
		
		if(!decode) {
			
			decode = true;
			String[] rawMath = getKeyDna().split(" ");
			Integer[] newMath = new Integer[rawMath.length]; 
					
			int passLength = getKeyPass().length();
			
			for(int i = 0 ; i < rawMath.length ; i++) {
				
				int rawIndex = Integer.valueOf(rawMath[i]);
				
				if(rawIndex >= rawMath.length) {
					rawIndex = rawIndex - passLength;
				}
				
				newMath[i] = rawIndex;
				
			}
			
			//System.out.print("HASH:[");
			
			for(int i = 0 ; i < newMath.length ; i++) {
				reverseRaw[i] = letterRaw[newMath[i]];
				//System.out.print(reverseRaw[i]);
			}
			
			//System.out.println("] : "+reverseRaw.length);
			
			//System.out.println("");
			
		}
		
		StringBuilder sb = new StringBuilder();
		for(String m : getMsg().split("")) {
			
			for(int i = 0 ; i < reverseRaw.length ; i++) {
		
				if(m.codePointAt(0) == reverseRaw[i].codePointAt(0)) {
					//System.out.print(letterRaw[i]);
					sb.append(letterRaw[i]);
					break;
				}
			}
		}
		
		return sb.toString();
		
		
	}
	
}
