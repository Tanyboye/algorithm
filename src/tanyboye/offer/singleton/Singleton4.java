package tanyboye.offer.singleton;

/**
 * @author: chengbg
 * @date: 2019/1/4
 * 饿汉式
 **/
public class Singleton4 {
    private static Singleton4 instence = new Singleton4();

    private Singleton4() {
    }

    public static Singleton4 getInstence() {
        return instence;
    }
}
