package com.ribeiro.codificar.qrcode;

import java.nio.file.Path;
import java.util.HashMap;
import java.util.Map;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;

public class QrCode {
	
	/**
	 * CLASSE QR CODE IMPLEMENTADA PARA GENERAÇÃO DA MENSAGEM CRIPTOGRAFADA
	 */
	
	private static QrCode instance;
	
	private Map<EncodeHintType, ErrorCorrectionLevel> hashMap = new HashMap<>();
	private int h = 250;
	private int w = 250;
	private String charset = "UTF-8";
	
	private QrCode() {}
	
	public static QrCode getInstance() {
		
		if(instance == null) {
			instance = new QrCode();
			
			instance.hashMap.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.L);
			
		}
		
		return instance;
	}
	
	public void gerar(String data, String path) {
		try {
			
			BitMatrix matrix = new MultiFormatWriter()
					.encode(new String(data.getBytes(charset),charset), BarcodeFormat.QR_CODE, w, h,hashMap);
			MatrixToImageWriter.writeToPath(matrix, path.substring(path.lastIndexOf(".")+1), Path.of(path));
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
