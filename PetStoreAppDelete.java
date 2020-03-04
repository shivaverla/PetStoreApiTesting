import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.util.ArrayList;
public class PetStoreAppDelete {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
	try {
		URL url = new URL("https://petstore.swagger.io/v2/pet/7865");
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		conn.setDoOutput(true);
		conn.setRequestMethod("DELETE");
		conn.setRequestProperty("Content-Type", "application/json");
		
		
	
		
		

		if (conn.getResponseCode() != 200) {
			
            throw new RuntimeException("Failed : HTTP Error code : "
                    + conn.getResponseCode() +"  Pet id not found");
            
        }else{
        	
        	
        	System.out.println("pet deleted");
        	System.out.println(conn.getResponseCode());
        }
		
		
		
		
   
       

           
       


        
        conn.disconnect();

    }catch(Exception e) {
        System.out.println("Exception in NetClientGet:- " + e);
    }

	}
}



