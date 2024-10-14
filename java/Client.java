package java;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.*;
import java.net.Socket;

public class Client {

    public static void main(String[] args) throws IOException {

        // set default host
        String hostName = "localhost"; 

        // set default port number 
        int portNumber = 12345;

        // check user input
        if (args.length > 0) {
            String delims = "[:]";
            String[] userInput = args[0].split(delims); 

            hostName = userInput[0];
            portNumber = Integer.parseInt(userInput[1]);
        }

        // create a socket to connect to server
        Socket sock = new Socket(hostName, portNumber);

        // print to confirm connection to server 
        System.out.printf(">>> Client connected to server\n");
        System.out.printf(">>> Host name: %s, Port number: %d\n", hostName, portNumber);
        
        while (true) {
        
            // get output stream 
            OutputStream os = sock.getOutputStream(); 
            Writer writer = new OutputStreamWriter(os);
            BufferedWriter bw = new BufferedWriter(writer);

            // get input stream 
            InputStream is = sock.getInputStream();
            Reader reader = new InputStreamReader(is);
            BufferedReader br = new BufferedReader(reader);

            // SEND get-cookie request

            // get user input 
            Console cons = System.console(); 
            String msg = cons.readLine(">>> User input: ");

            // write message to server 
            bw.write(msg + "\n");

            // force it into the network 
            bw.flush(); 

            // CLOSE connect 

            if (msg.equals("close")) {
                break;
            }

            // RECEIVE cookie-text 

            // get server output 
            String serverMsg = br.readLine(); 

            if (serverMsg.startsWith("cookie-text")) {
                // remove "cookie-text"
                String cookieText = serverMsg.substring(12);

                // print cookie from server 
                System.out.println(cookieText);
            }


        }

        // close connection 
        System.out.println(">>> Connection closed");
        sock.close(); 


    }



}
