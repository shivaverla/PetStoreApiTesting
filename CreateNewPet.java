import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.util.ArrayList;

import netscape.javascript.JSObject;
public class CreateNewPet {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
	try {
		URL url = new URL("https://petstore.swagger.io/v2/pet");
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		conn.setDoOutput(true);
		conn.setRequestMethod("POST");
		conn.setRequestProperty("Content-Type", "application/json");
		
		String input = "{ \"id\": 7865, \"category\": { \"id\": 895, \"name\": \"pets\" }, \"name\": \"lucy\", \"photoUrls\": [ \"test\" ], \"tags\": [ { \"id\": 4343, \"name\": \"pet name\" } ], \"status\": \"available\"}";
		
		OutputStream os = conn.getOutputStream();
		os.write(input.getBytes());
		os.flush();
		
		

		if (conn.getResponseCode() != 200) {
            throw new RuntimeException("Failed : HTTP Error code : "
                    + conn.getResponseCode()+conn.getDate());
            
            
        }else {
        	System.out.println();
        }
        InputStreamReader in = new InputStreamReader(conn.getInputStream());
        BufferedReader br = new BufferedReader(in);
        String output;
        ArrayList<String> resp = new ArrayList<String>();
        while ((output = br.readLine()) != null) {
        	 resp.add(output);
            System.out.println(output);
            System.out.println("Pet is Sucessfully Created");
            
            
           
        }
        
        
        conn.disconnect();

    }catch(Exception e) {
        System.out.println("Exception in NetClientGet:- " + e);
    }

	}
}



