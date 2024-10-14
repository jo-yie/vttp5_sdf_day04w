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

    public Cookie(String fileName) {
        this.fileName = fileName;
        this.cookieFile = new File(fileName); 

    }

    public void openCookie() {

    }

    public void closeCookie(String fileName) {


    }

    public String getRandomCookie() throws IOException {

        // initialise buffered reader 
        FileReader fr = new FileReader(cookieFile);
        BufferedReader br = new BufferedReader(fr); 

        // new list for cookie file contents 
        List<String> cookieList = new ArrayList<String>(); 

        String line; 

        while ((line = br.readLine()) != null) {
            cookieList.add(line);
        }

        // get random int 
        Random rand = new Random(); 

        // get random cookie from list
        int index =  rand.nextInt(cookieList.size());
        String cookie = cookieList.get(index);

        // return cookie
        return cookie;

    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public File getCookieFile() {
        return cookieFile;
    }

    public void setCookieFile(File cookieFile) {
        this.cookieFile = cookieFile;
    }

}
