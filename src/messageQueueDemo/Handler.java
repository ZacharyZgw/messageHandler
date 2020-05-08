package messageQueueDemo;

import java.util.concurrent.ArrayBlockingQueue;

public class Handler {
    private final static int MAX_LEN = 3;
    //使用一个阻塞队列来存放消息
    private static ArrayBlockingQueue<String> messageQueue = new ArrayBlockingQueue<String>(MAX_LEN);
    //生产消息
    public static void produce(String message){
        //往队列里面放入消息，成功返回True,否则False
        if(messageQueue.offer(message)){
            System.out.println("成功投递消息:"+message+"当前消息队列长度为:"+messageQueue.size());
        }
        else{
            System.out.println("消息队列长度已满，无法投递消息");
        }
    }
    public static String consume(){
        String message = messageQueue.poll();
        if(message != null){
            System.out.println("成功取出消息:"+message+"当前消息队列长度为:"+messageQueue.size());
            return message;
        }
        else {
            System.out.println("消息队列为空");
            return null;
        }
    }
}
