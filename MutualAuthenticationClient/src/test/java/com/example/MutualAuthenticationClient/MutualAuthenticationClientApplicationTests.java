package com.example.MutualAuthenticationClient;

import org.junit.Test;


import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Bean;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MutualAuthenticationClientApplicationTests {

	static
	{
		System.setProperty("javax.net.debug", "all");
		System.setProperty("jdk.tls.client.protocols", "TLSv1.2");
		System.setProperty("https.protocols", "TLSv1.2");
		System.setProperty("javax.net.ssl.trustStore", "config/MyClient.jks");
		System.setProperty("javax.net.ssl.trustStorePassword", "password");
		System.setProperty("javax.net.ssl.keyStore",  "config/MyClient.jks");
		System.setProperty("javax.net.ssl.keyStorePassword", "password");

		javax.net.ssl.HttpsURLConnection.setDefaultHostnameVerifier(
				new javax.net.ssl.HostnameVerifier() {

					public boolean verify(String hostname,
										  javax.net.ssl.SSLSession sslSession) {
						if (hostname.equals("localhost")) {
							return true;
						}
						return false;
					}
				});
	}

	private RestTemplate template;


	@Test

	public void getSSLConnection() {
		RestTemplate template = new RestTemplate();
		ResponseEntity<String> response = template.getForEntity("https://localhost:9080/hello",
				String.class);
		System.out.println(response.getBody());
	}


	@Test

	public void getNonSSLConnection(){
		RestTemplate template = new RestTemplate();
		try{
			ResponseEntity<String> response = template.getForEntity("http://localhost:9080/hello",
					String.class);
			System.out.println(response.getBody());
		}catch (Exception ex){
			ex.printStackTrace();
			System.out.println("Exception :: "+ex.getMessage());
		}


	}


}
