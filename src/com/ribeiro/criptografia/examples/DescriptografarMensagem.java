package com.ribeiro.criptografia.examples;

import com.ribeiro.criptografia.app.Decrypt;

public class DescriptografarMensagem {

	public static void main(String[] args) {
		String keypass = "chaveMestra";
		String keyDna = "50 128 9 3 19 11 122 83 90 121 131 6 136 66 68 71 74 140 16 22 62 59 96 78 115 49 8 37 54 44 112 110 0 45 5 52 84 14 47 75 35 60 57 105 25 29 120 100 117 13 41 36 39 4 73 32 145 72 28 1 86 104 119 95 81 143 51 141 18 116 146 107 43 48 133 82 113 33 67 102 91 77 31 132 21 148 65 24 61 126 97 101 109 40 2 58 106 103 46 99 114 76 7 92 69 30 20 42 94 93 88 137 98 123 135 63 139 108 87 64 127 70 26 27 89 142 129 85 124 79 10 138 130 53 149 147 118 17 15 ";
		String encryptMsg = "uLrkc";
		
		Decrypt dc = Decrypt.getInstance();
		dc.setKeyPass(keypass);
		dc.setKeyDna(keyDna);
		dc.setMsg(encryptMsg);
		
		String decryptMsg = dc.decryptMessage();
		System.out.println("Mensagem Descriptografada: " + decryptMsg);
	}

}
