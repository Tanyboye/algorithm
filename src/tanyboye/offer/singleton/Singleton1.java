package tanyboye.offer.singleton;

/**
 * @author: chengbg
 * @date: 2019/1/4
 * 单线程情况下
 **/
public class Singleton1 {
    private static Singleton1 instence = null;

    private Singleton1() {
    }

    public static Singleton1 getInstence() {
        if (instence == null) {
            instence = new Singleton1();
        }
        return instence;
    }
}
