package messageQueueDemo;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server implements Runnable {
    public final static int PORT = 6666;
    private final Socket socket;

    public Server(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try(
                BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                PrintWriter out = new PrintWriter(socket.getOutputStream());
        ){
            while (true){
                //System.out.println("请输入操作类型:\nconsume:消费一条消息\nsend:带输入内容,往消息队列添加一条消息");
                String in_str = in.readLine();
                if (in_str == null){
                    continue;
                }
                if(in_str.equals("consume")){
                    String message = Handler.consume();
                    if(message != null){
                        out.println(message);
                        out.flush();
                    }
                }
                else if(in_str.startsWith("send:")){
                    Handler.produce(in_str);
                }
                else {
                    System.out.println("原始消息"+in_str+"没有遵循协议");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) throws Exception{
        ServerSocket socket = new ServerSocket(PORT);
        while (true){
            Server server = new Server(socket.accept());
            new Thread(server).start();
        }
    }
}
