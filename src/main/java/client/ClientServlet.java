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

@WebServlet(name = "Client", urlPatterns = "/client.do")
public class ClientServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) {
		try {
			URL restServiceURL = new URL(
					"http://localhost:8080/JAXRS-RESTEasy/rest/RESTEasyHelloWorld/JavaCodeGeeks?queryParameter=tingyun%20RESTEasy");
			HttpURLConnection httpConnection = (HttpURLConnection) restServiceURL
					.openConnection();
			httpConnection.setRequestMethod("GET");
			httpConnection.setRequestProperty("Accept", "application/json");
			if (httpConnection.getResponseCode() != 200) {
				throw new RuntimeException(
						"HTTP GET Request Failed with Error code : "
								+ httpConnection.getResponseCode());
			}
			BufferedReader responseBuffer = new BufferedReader(
					new InputStreamReader((httpConnection.getInputStream())));

			String output;
			System.out.println("Output from Server:  \n");
			String jsonStr = "";
			while ((output = responseBuffer.readLine()) != null) {
				jsonStr = output;
				System.out.println(jsonStr);
				response.getWriter().write("rest response : "+jsonStr);
			}
			httpConnection.disconnect();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
