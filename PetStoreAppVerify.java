import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.lang.reflect.Array;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
public class PetStoreAppVerify {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		try {
			URL url = new URL("https://petstore.swagger.io/v2/pet/7865");
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setDoOutput(true);
			conn.setRequestMethod("GET");
			conn.setRequestProperty("Content-Type", "application/json");
			
			String input = "{ \"id\":7865,\"category\":{\"id\": 895,\"name\":\"pets\" }, \"name\": \"lucy\", \"photoUrls\": [ \"test\" ], \"tags\": [ { \"id\": 4343, \"name\": \"pet name\" } ], \"status\": \"available\"}";
			String input2[] = {"{\"id\":7865,\"category\":{\"id\":895,\"name\":\"pets\"},\"name\":\"lucy\",\"photoUrls\":[\"test\"],\"tags\":[{\"id\":4343,\"name\":\"pet name\"}],\"status\":\"available\"}"};
					 
					
			
	
			

			if (conn.getResponseCode() != 200) {
	            throw new RuntimeException("Failed : HTTP Error code : "
	                    + conn.getResponseCode()+conn.getDate());
	            
	          }
			
	        InputStreamReader in = new InputStreamReader(conn.getInputStream());
	        BufferedReader br = new BufferedReader(in);
	        String output;
	        ArrayList<String> resp = new ArrayList<String>();
	        Object Array1 = "{\"id\":7865,\"category\":{\"id\":895,\"name\":\"pets\"},\"name\":\"lucy\",\"photoUrls\":[\"test\"],\"tags\":[{\"id\":4343,\"name\":\"pet name\"}],\"status\":\"available\"}";
	        Object Array2 = null;
	        
	        while ((output = br.readLine()) != null) {
	        	resp.add(output);
	        	System.out.println(output);
	        	// Array1=resp.toArray();
	             Array2=resp.toArray();
	           
	             System.out.println(Array1.toString());	
	        }
	        
	        
			if(Array1.equals(Array2)) {
				System.out.println("Verified Data is InCorrect");
				
	        }else {
	        	
	        	System.out.println("Verified Data is Correct");
	        	
	        }
	        
	        conn.disconnect();

	    }catch(Exception e) {
	        System.out.println("Exception in NetClientGet:- " + e);
	    }

		}
}



