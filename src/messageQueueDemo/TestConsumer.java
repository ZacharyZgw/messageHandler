package messageQueueDemo;

public class TestConsumer {
    public static void main(String[] args)throws Exception{
        Client c1 = new Client();
        String message = c1.consume();
        System.out.println("c1获取的消息为:"+message);
    }
}
