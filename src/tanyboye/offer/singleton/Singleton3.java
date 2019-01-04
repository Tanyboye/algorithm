package tanyboye.offer.singleton;

/**
 * @author: chengbg
 * @date: 2019/1/4
 * 双重检查锁
 **/
public class Singleton3 {
    //volatile防止重排序
    private static volatile Singleton3 instence = null;

    private Singleton3() {
    }

    public static Singleton3 getInstence() {
        if (instence == null) {
            synchronized (Singleton3.class) {
                if (instence == null) {
                    instence = new Singleton3();
                }
            }
        }
        return instence;
    }
}
