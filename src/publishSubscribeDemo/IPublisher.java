package publishSubscribeDemo;
//发布者订阅者模式
public interface IPublisher<M> {
    public void publish(SubscribePublish subscribePublish, M message, boolean isInstantMsg);
}
