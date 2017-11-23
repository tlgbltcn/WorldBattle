import java.io.*;
import java.lang.*;
import java.util.*;


public class CreateFile {

    private Formatter x;

    public void openFile(){

        try {
            x = new Formatter("results.txt");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void addRecors(String str){

        x.format(str);
    }

    public void closeFile(){
        x.close();
    }


}
