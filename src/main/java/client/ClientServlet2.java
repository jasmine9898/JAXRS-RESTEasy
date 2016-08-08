package client;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.core.Response;

import org.apache.http.client.ClientProtocolException;
import org.jboss.resteasy.client.jaxrs.ResteasyClient;
import org.jboss.resteasy.client.jaxrs.ResteasyClientBuilder;
import org.jboss.resteasy.client.jaxrs.ResteasyWebTarget;
@WebServlet(name="Client2",urlPatterns="/client2")
public class ClientServlet2 extends HttpServlet{
	
	 public void doGet(HttpServletRequest request, HttpServletResponse sresponse)  {
		 try{
//				"http://localhost:8080/JAXRS-RESTEasy/rest/RESTEasyHelloWorld/JavaCodeGeeks?queryParameter=Enjoy%20RESTEasy");			
				ResteasyClient client = new ResteasyClientBuilder().build();
		        ResteasyWebTarget target = client.target("http://localhost:8080/JAXRS-RESTEasy/rest/RESTEasyHelloWorld/JavaCodeGeeks?queryParameter=tingyun%20Enjoy%20RESTEasy");
		        Response response = target.request().get();
		        if(response.getStatus()!=200)  
		        {  
		            throw new RuntimeException("Failed : HTTP error code : "+response.getStatus());  
		        }  
		        String responseString=response.readEntity(String.class);
		        sresponse.getWriter().write(responseString);
		        System.out.println(responseString);
		        response.close(); 
		 }catch(Exception e){
		 e.printStackTrace();}
	 }
	

}
