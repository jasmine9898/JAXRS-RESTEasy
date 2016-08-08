package client;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.ws.rs.core.Response;

import org.apache.http.client.ClientProtocolException;
import org.jboss.resteasy.client.jaxrs.ResteasyClient;
import org.jboss.resteasy.client.jaxrs.ResteasyClientBuilder;
import org.jboss.resteasy.client.jaxrs.ResteasyWebTarget;

public class Client {
	public static void main(String[] args) throws Exception {
		URL restServiceURL = new URL("http://localhost:8080/JAXRS-RESTEasy/rest/RESTEasyHelloWorld/JavaCodeGeeks?queryParameter=tingyun%20RESTEasy");
        HttpURLConnection httpConnection = (HttpURLConnection) restServiceURL.openConnection();  
        httpConnection.setRequestMethod("GET");  
        httpConnection.setRequestProperty("Accept", "application/json");  
        if (httpConnection.getResponseCode() != 200) {  
            throw new RuntimeException("HTTP GET Request Failed with Error code : "  
                          + httpConnection.getResponseCode());  
        }  
        BufferedReader responseBuffer = new BufferedReader(new InputStreamReader(  
                (httpConnection.getInputStream())));  
 
         String output;  
         System.out.println("Output from Server:  \n");  
         String jsonStr="";  
         while ((output = responseBuffer.readLine()) != null) {  
               jsonStr = output;  
               System.out.println(jsonStr);  
         }  
         httpConnection.disconnect();  
	}
	
	public static void main0(String[] args) throws Exception {	
		 //	"http://localhost:8080/JAXRS-RESTEasy/rest/RESTEasyHelloWorld/JavaCodeGeeks?queryParameter=Enjoy%20RESTEasy");			
			ResteasyClient client = new ResteasyClientBuilder().build();
	        ResteasyWebTarget target = client.target("http://localhost:8080/JAXRS-RESTEasy/rest/RESTEasyHelloWorld/JavaCodeGeeks?queryParameter=Enjoy%20RESTEasy");
	        Response response = target.request().get();
	        if(response.getStatus()!=200)  
	        {  
	            throw new RuntimeException("Failed : HTTP error code : "+response.getStatus());  
	        }  
	       
	        System.out.println(response.readEntity(String.class));
	        response.close(); 
	}
	
	

}
