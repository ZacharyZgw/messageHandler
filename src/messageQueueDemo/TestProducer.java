package messageQueueDemo;

public class TestProducer {
    public static void main(String[] args) throws Exception{
        Client p1 = new Client();
        p1.produce("send:p1生产了一条消息"+p1.hashCode());
        Client p2 = new Client();
        p2.produce("send:p2生产了一条消息"+p2.hashCode());
    }
}
