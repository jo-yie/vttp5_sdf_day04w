package java;

import java.Cookie;
import java.io.*;
import java.net.*;
import java.util.*;

public class Server {
    
    public static void main(String[] args) throws IOException {
        
        // set default port number
        int portNumber = 12345;

        // set default cookie file 
        String userCookie = "cookie_file.txt";

        // check for user input port number + cookie file 
        if (args.length > 0) {
            portNumber = Integer.parseInt(args[0]);
            userCookie = args[1];
        }

        // create new cookie file 
        Cookie cookieFile = new Cookie(userCookie);

        // print port number
        System.out.printf(">>> Listening on port number %d\n", portNumber);

        // create server
        ServerSocket server = new ServerSocket(portNumber);

        // print waiting for connection 
        System.out.println(">>> Waiting for connection"); 

        // initialise socket
        // accept incoming connection
        Socket conn = server.accept(); 

        // while loop 
        while (true) {

            // get input stream 
            InputStream is = conn.getInputStream(); 
            Reader reader = new InputStreamReader(is);
            BufferedReader br = new BufferedReader(reader);

            // get output stream 
            OutputStream os = conn.getOutputStream();
            Writer writer = new OutputStreamWriter(os);
            BufferedWriter bw = new BufferedWriter(writer);

            // getting message from client 
            String msg = br.readLine(); 

            String randomCookie = "";

            // if user input == "get-cookie"
            // return random cookie 
            if (msg.equals("get-cookie")) {
                randomCookie = "cookie-text " + cookieFile.getRandomCookie();
                System.out.println(randomCookie);

                // send random cookie to client 
                bw.write(randomCookie + "\n");
                bw.flush();
            } 

            // if user input == "close"
            // server close connection 
            else if (msg.equals("close")) {
                break;
            }

        }

         // close connection 
         System.out.println(">>> Connection closed");
         conn.close();

    }

}
