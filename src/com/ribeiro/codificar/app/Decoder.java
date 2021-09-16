package com.ribeiro.codificar.app;

public class Decoder {
	
	private static Decoder instance;
	private String keyDna;
	private String keyPass;
	private String msg;
	
	private String[] letterRaw = ("ç,ä,ë,ï,ö,ü,ÿ,ã,ñ,õ,â,ê,î,ô,û,á,é,í,ó,ú,ý,à,è,ì,ò,ù,&,a,b"
			+ ",c,d,e,f,g,h,i,j,k,l,m,n,o,p,q,r,s,t,u,v,w,x,y,z,1,2,3,4,5,6,7,8,9,0,"+("ç,ä,ë,ï,ö,ü,ÿ,ã,ñ,õ,â,ê,î,ô,û,á,é,í,ó,ú,ý,à,è,ì,ò,ù,a,b,c,d,e,f,g,h,i,j,k,l,m,n,o,p,q,r,s,t,u,v,w,x,y,z".toUpperCase())).split(",");
	private String[] reverseRaw = new String[letterRaw.length];
	private Boolean decode = false;
	
	private Decoder() {}
	
	public static Decoder getInstance() {
		return instance == null ? instance = new Decoder() : instance;
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
		
		keyDna = keyDna.replaceAll("\n", " ");
		keyDna = keyDna.replaceAll("\r", "");
		//System.out.println(keyDna);
		
		this.keyDna = keyDna;
	}

	private String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}
	
	public void decodeMessage() {
		
		if(!decode) {
			
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
			System.out.print("[");
			for(int i = 0 ; i < newMath.length ; i++) {
				reverseRaw[i] = letterRaw[newMath[i]];
				System.out.print(reverseRaw[i]);
			}
			System.out.println("] : "+reverseRaw.length);
			
			System.out.println("");
			
			for(String m : getMsg().split("")) {
				
				for(int i = 0 ; i < reverseRaw.length ; i++) {
			
					if(m.equals(reverseRaw[i])) {
						//System.out.print("[ "+m + ":" +reverseRaw[i]+" ]"+letterRaw[i].replace("ñ", " "));
						System.out.print(letterRaw[i].replace("ñ", " "));
						break;
					}
					
				}
			
			}
			
		}
		
		
	}
	
}
