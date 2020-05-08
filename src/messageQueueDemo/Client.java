package messageQueueDemo;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;

public class Client {
    //生产消息
    public static void produce(String message) throws Exception{
        Socket socket = new Socket(InetAddress.getLocalHost(),Server.PORT);
        try(PrintWriter out = new PrintWriter(socket.getOutputStream())){
            out.println(message);
            out.flush();
        }
    }
    public static String consume() throws Exception{
        Socket socket = new Socket(InetAddress.getLocalHost(),Server.PORT);
        try(
                BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                PrintWriter out = new PrintWriter(socket.getOutputStream());
                ){
            out.println("consume");
            out.flush();
            String message = in.readLine();
            return message;
        }
    }
}
