package com.util;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.http.Header;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.fluent.Request;
import org.apache.http.util.EntityUtils;

public class GETClient {
	int port;
	String path;
	Map<String, String> headers = new HashMap();
	
	GETClient() {
		System.out.println("Default port " + port);
	}

	public GETClient(int port,Map<String, String> headers){
		this.port = port;
		this.path=path;
		System.out.println("Custom port " + port);
		System.out.println("Custom path " + path);
		}
	
	public static void main(String[] args) {
		String response=new GETClient().getResponse();
		
	}
	
	
	public String getResponse(){
		String url = String.format("http://localhost:%d/company/49", port);
		System.out.println("using the URL=" + url);
		try {
			HttpResponse r = Request.Get(url).addHeader((Header) headers).execute().returnResponse();
			//HttpResponse r = Request.Get(url).execute().returnResponse();
			String json = EntityUtils.toString(r.getEntity());
			System.out.println("Json=" + json);
			

		} catch (ClientProtocolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return url;

	}
}