package com.snhu.sslserver;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class SslServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(SslServerApplication.class, args);
	}

}
@RestController
class ServerController
{ 
	@RequestMapping("/hash")
    public String myHash()
	{
		try 
		{
			MessageDigest digest = MessageDigest.getInstance("SHA-256"); 
			// create a MessageDigest class and initialize with SHA-256 cipher
			String data = "Hello World! My name is Vy Huynh";
			
			byte[]hashed = digest.digest(data.getBytes()); //hash the data
			
			String hashedHex = bytesToHex(hashed); //take the hashed data and convert it into hex string
			
			return "<p>data : " + data + "<br> Name of Cipher ALgorithm: SHA-256" + "<br> CheckSum Value: " + hashedHex;
		}
		catch (NoSuchAlgorithmException e) 
		{
            e.printStackTrace();
			
		}
		return "";
    	
    }
	private String bytesToHex(byte[] bytes) //function to hash data to hex
	{
		StringBuilder conversion = new StringBuilder();
		for(byte i:bytes) 
		{
			conversion.append(String.format("%02X", i));
		}
		return conversion.toString();
	}
}