import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
//efdghfjhg
/**
 * Created by Leonard on 2017-04-27.
 */
public class textClient {

    private void connect(){
        try{
            Socket socket = new Socket("share-02.csc.kth.se", 4713);
            BufferedReader in=new BufferedReader
                    (new InputStreamReader(socket.getInputStream()));
            PrintWriter ut=new PrintWriter(socket.getOutputStream());
            ut.println("Charlotta"); ut.flush();
            for (int i = 0; i < 2; i++) {
                ut.println("SAX"); ut.flush();
                System.out.println(in.readLine());
            }
        }catch (IOException error) {
            System.out.println("Fel vid inläsning");
        }

    }

    public static void main(String[] args) {
        textClient tc = new textClient();
        tc.connect();
    }
}
