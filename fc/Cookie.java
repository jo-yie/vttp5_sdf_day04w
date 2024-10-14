package fc;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Cookie { 
    private String fileName;
    private File cookieFile;
    private List<String> cookieList = new ArrayList<String>();

    public Cookie(String fileName) throws IOException {
        this.fileName = fileName;
        this.cookieFile = new File(fileName); 

        // initialise buffered reader 
        FileReader fr = new FileReader(cookieFile);
        BufferedReader br = new BufferedReader(fr); 

        String line; 

        // add cookies from file to list 
        while ((line = br.readLine()) != null) {
            cookieList.add(line);
        }

    }

    public String getRandomCookie() throws IOException {
        // get random int 
        Random rand = new Random(); 

        // get random cookie from list
        int index =  rand.nextInt(cookieList.size());
        String cookie = cookieList.get(index);

        // return cookie
        return cookie;

    }

}
