package fc;

import java.io.*;
import java.io.IOException;
import java.net.*;
import java.util.*;

public class Server {
    
    public static void main(String[] args) throws IOException {
        
        // set default port number
        int portNumber = 12345;

        // check for user input port number
        if (args.length > 0) {
            portNumber = Integer.parseInt(args[0]);
        }

        // print port number
        System.out.printf(">>> Listening on port number %d\n", portNumber);

        // create server
        ServerSocket server = new ServerSocket(portNumber);

        // while loop 
        while (true) {

            // RETURN RANDOM COOKIE

            // create new file
            File cookieFile = new File("cookie_file.txt"); 

            // initialise buffered reader
            BufferedReader br = new BufferedReader(new FileReader(cookieFile));
            
            // new list for cookie file contents
            List<String> cookieList = new ArrayList<String>();

            String line; 

            while((line = br.readLine()) != null) { 
                cookieList.add(line); 
            }

            br.close();
            
            // get random int
            Random rand = new Random();
            int index = rand.nextInt(cookieList.size());

            String returnCookie = cookieList.get(index);

            // return random cookie
            System.out.printf(">>> Random Cookie: %s\n", returnCookie);

            // print waiting for connection 
            System.out.println(">>> Waiting for connection"); 

            // initialise socket
            // accept incoming connection
            Socket conn = server.accept(); 
        }

    }

}
