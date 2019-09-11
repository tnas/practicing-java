package com.tnas.samples.security;

import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.Base64;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

import com.sun.org.apache.xml.internal.security.exceptions.Base64DecodingException;

public class RSACryptosystem {


	public static void main(String[] args) throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException, Base64DecodingException, InvalidKeySpecException, IOException {
	
		String message = "Java Security API";
		
		//KeyPairGenerator kpg = KeyPairGenerator.getInstance("RSA");
		//kpg.initialize(512);
		//KeyPair keyPair = kpg.generateKeyPair();
		//Key pvt = keyPair.getPrivate();
		//Key pub = keyPair.getPublic();

		KeyFactory keyFactory = KeyFactory.getInstance("RSA");
		
		// Private Key
		String pvtStringKey = "my-private-key";
		PKCS8EncodedKeySpec specPvt = new PKCS8EncodedKeySpec(Base64.getEncoder().encode(pvtStringKey.getBytes()));
		PrivateKey pvt = keyFactory.generatePrivate(specPvt);
		
		// Public Key
		String publicStringKey = "my-PUBLIC-key";
		X509EncodedKeySpec specPub = new X509EncodedKeySpec(publicStringKey.getBytes());
		PublicKey pub = keyFactory.generatePublic(specPub);
		
		// Java 8
//		System.out.println("Public key: " + Base64.getEncoder().encodeToString(pub.getEncoded()));
//		System.out.println("Private key: " + Base64.getEncoder().encodeToString(pvt.getEncoded()));
		
//		System.out.println("Public key format: " + pub.getFormat());
//		System.out.println("Private key format: " + pvt.getFormat());
		
		System.out.println("Original message: " + message);
		
		Cipher rsa = Cipher.getInstance("RSA");
		
		rsa.init(Cipher.ENCRYPT_MODE, pvt);
		String encryptedMsg = Base64.getEncoder().encodeToString(rsa.doFinal(message.getBytes("UTF-8")));
		System.out.println("Encrypted message: " + encryptedMsg);
		
		rsa.init(Cipher.DECRYPT_MODE, pub);
		String decryptedMsg = new String(rsa.doFinal(Base64.getDecoder().decode(encryptedMsg)), "UTF-8");
		System.out.println("Encrypted message: " + decryptedMsg);
	}
}
