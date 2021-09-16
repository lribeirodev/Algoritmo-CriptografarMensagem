package com.ribeiro.codificar.app;

public class Decrypt {
	
	private static Decrypt instance;
	private String keyDna;
	private String keyPass;
	private String msg;
	
	private String[] letterRaw = " ,ç,ä,ë,ï,ö,ü,ÿ,ã,ñ,õ,â,ê,î,ô,û,á,é,í,ó,ú,ý,à,è,ì,ò,ù,&,a,b,c,d,e,f,g,h,i,j,k,l,m,n,o,p,q,r,s,t,u,v,w,x,y,z,1,2,3,4,5,6,7,8,9,0,Ç,Ä,Ë,Ï,Ö,Ü,Ÿ,Ã,Ñ,Õ,Â,Ê,Î,Ô,Û,Á,É,Í,Ó,Ú,Ý,À,È,Ì,Ò,Ù,A,B,C,D,E,F,G,H,I,J,K,L,M,N,O,P,Q,R,S,T,U,V,W,X,Y,Z".split(",");
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
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}
	
	public String decryptMessage() {
		
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
