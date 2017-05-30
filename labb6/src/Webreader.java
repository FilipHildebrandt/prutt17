import javax.swing.*;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.*;
import java.util.Scanner;



/**
 * Created by user on 2017-05-19.
 */
public class Webreader extends JEditorPane {


    Webreader(){
        setContentType("text/html");
    }

    @Override
    public void setEditable(boolean b) {
        super.setEditable(b);
    }

    public void showPage(String content){

        setText(content);

    }


}
