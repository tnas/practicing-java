package com.tnas.samples.security;

import java.io.File;
import java.nio.file.Files;
import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.Base64;

import javax.crypto.Cipher;

public class RSACryptosystem {

	private static final int KEY_LENGTH = 1024;
	private static String MESSAGE = "Java Security API";
	private static final String PVT_KEY_PATH = "resources/RSA/private_key.der";
	private static final String PUB_KEY_PATH = "resources/RSA/public_key.der";

	public void runRSAGeneratedKey() throws Exception {
		
		KeyPairGenerator kpg = KeyPairGenerator.getInstance("RSA");
		kpg.initialize(KEY_LENGTH);
		KeyPair keyPair = kpg.generateKeyPair();
		RSAPrivateKey pvt = (RSAPrivateKey) keyPair.getPrivate();
		RSAPublicKey pub = (RSAPublicKey) keyPair.getPublic();
		
		System.out.println(String.format("Private Key: %s", pvt.getAlgorithm()));
		System.out.println("Modulus:\n" + pvt.getModulus());
		System.out.println("Exponent:\n" + pvt.getPrivateExponent());
		
		System.out.println(String.format("\nPublic Key: %s", pub.getAlgorithm()));
		System.out.println("Modulus:\n" + pub.getModulus());
		System.out.println("Exponent:\n" + pub.getPublicExponent());

		System.out.println("\nOriginal message: " + MESSAGE);
		
		Cipher rsa = Cipher.getInstance("RSA");
		
		rsa.init(Cipher.ENCRYPT_MODE, pvt);
		String encryptedMsg = Base64.getEncoder().encodeToString(rsa.doFinal(MESSAGE.getBytes("UTF-8")));
		System.out.println("Encrypted message: " + encryptedMsg);
		
		rsa.init(Cipher.DECRYPT_MODE, pub);
		String decryptedMsg = new String(rsa.doFinal(Base64.getDecoder().decode(encryptedMsg)), "UTF-8");
		System.out.println("Decrypted message: " + decryptedMsg);
	}
	
	/**
	 *  Keys generated by Openssl
	 *  Keys size: 2048 bits
	 *  
	 *  Download Openssl: https://slproweb.com/products/Win32OpenSSL.html
	 *  
	 *  Key generation: http://codeartisan.blogspot.com/2009/05/public-key-cryptography-in-java.html
	 *  1. Generate a 2048-bit RSA private key:
	 *	$ openssl genrsa -out private_key.pem 2048
	 *
	 * 	2. Convert private Key to PKCS#8 format (so Java can read it):
	 *	$ openssl pkcs8 -topk8 -inform PEM -outform DER -in private_key.pem -out private_key.der -nocrypt
	 *
	 *	3. Output public key portion in DER format (so Java can read it):
	 *	$ openssl rsa -in private_key.pem -pubout -outform DER -out public_key.der
	 */
	public void runRSALoadedKey() throws Exception {
		
		PrivateKey pvt = loadPrivateKey();
		PublicKey pub = loadPublicKey();
		
		Cipher rsa = Cipher.getInstance("RSA");
		
		System.out.println("\nOriginal message: " + MESSAGE);
		
		rsa.init(Cipher.ENCRYPT_MODE, pvt);
		String encryptedMsg = Base64.getEncoder().encodeToString(rsa.doFinal(MESSAGE.getBytes("UTF-8")));
		System.out.println("Encrypted message: " + encryptedMsg);
		
		rsa.init(Cipher.DECRYPT_MODE, pub);
		String decryptedMsg = new String(rsa.doFinal(Base64.getDecoder().decode(encryptedMsg)), "UTF-8");
		System.out.println("Decrypted message: " + decryptedMsg);
	}
	
	private PrivateKey loadPrivateKey() throws Exception {
		byte[] keyBytes = Files.readAllBytes(new File(PVT_KEY_PATH).toPath());
		PKCS8EncodedKeySpec spec = new PKCS8EncodedKeySpec(keyBytes);
		KeyFactory kf = KeyFactory.getInstance("RSA");
		PrivateKey pvt = kf.generatePrivate(spec); 
		System.out.println(String.format("Private Key: %s", pvt.getAlgorithm()));
		return pvt; 
	}
	
	private PublicKey loadPublicKey() throws Exception {
		byte[] keyBytes = Files.readAllBytes(new File(PUB_KEY_PATH).toPath());
		X509EncodedKeySpec spec = new X509EncodedKeySpec(keyBytes);
		KeyFactory kf = KeyFactory.getInstance("RSA");
		PublicKey pub = kf.generatePublic(spec);
		System.out.println(String.format("Public Key: %s", pub.getAlgorithm()));
		return pub;
	}
	
	public static void main(String[] args) throws Exception {
	
		RSACryptosystem rsaCrypto = new RSACryptosystem();
		//rsaCrypto.runRSAGeneratedKey();
		rsaCrypto.runRSALoadedKey();
		
		
//		KeyFactory keyFactory = KeyFactory.getInstance("RSA");
//		
//		// Private Key
//		String pvtStringKey = "my-private-key";
//		PKCS8EncodedKeySpec specPvt = new PKCS8EncodedKeySpec(Base64.getEncoder().encode(pvtStringKey.getBytes()));
//		PrivateKey pvt = keyFactory.generatePrivate(specPvt);
//		
//		// Public Key
//		String publicStringKey = "my-PUBLIC-key";
//		X509EncodedKeySpec specPub = new X509EncodedKeySpec(publicStringKey.getBytes());
//		PublicKey pub = keyFactory.generatePublic(specPub);
		
		// Java 8
//		System.out.println("Public key: " + Base64.getEncoder().encodeToString(pub.getEncoded()));
//		System.out.println("Private key: " + Base64.getEncoder().encodeToString(pvt.getEncoded()));
		
//		System.out.println("Public key format: " + pub.getFormat());
//		System.out.println("Private key format: " + pvt.getFormat());
		
		
	}
}
