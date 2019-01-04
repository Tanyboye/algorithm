package tanyboye.offer.singleton;

/**
 * @author: chengbg
 * @date: 2019/1/4
 * 懒汉式
 **/
public class Singleton2 {
    private static Singleton2 instence = null;

    private Singleton2() {
    }

    public static synchronized Singleton2 getInstence() {
        if (instence == null) {
            instence = new Singleton2();
        }
        return instence;
    }
}
