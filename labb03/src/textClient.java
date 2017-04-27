/**
 * Created by Leonard on 2017-04-27.
 */
public class textClient {

    private void connect(){
        try {
            Socket socket=new Socket("gru-ld03.csc.kth.se",4713);
            BufferedReader in=new BufferedReader
                    (new InputStreamReader(socket.getInputStream()));
            PrintWriter ut=new PrintWriter(socket.getOutputStream());
            ut.println("Charlotta"); ut.flush();
            System.out.println(in.readLine());
        }
    }
}
