package publishSubscribeDemo;
import java.util.Date;

public class SubPubTest {
    public static void main(String[] args) {
        SubscribePublish<String> subscribePublish = new SubscribePublish<String>("订阅器");
        IPublisher<String> publisher1 = new PublisherImpOne<String>("发布者1");
        ISubcriber<String> subcriber1 = new SubcriberImpOne<String>("订阅者1");
        ISubcriber<String> subcriber2 = new SubcriberImpOne<String>("订阅者2");
        subcriber1.subcribe(subscribePublish);
        subcriber2.subcribe(subscribePublish);
        publisher1.publish(subscribePublish, "发布者1发布了消息1"+new Date(), true);
        publisher1.publish(subscribePublish, "发布者1发布了消息2:"+new Date(), true);
        publisher1.publish(subscribePublish, "发布者1发布了消息3:"+new Date(), false);
    }

}
