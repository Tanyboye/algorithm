package tanyboye.offer.singleton;

/**
 * @author: chengbg
 * @date: 2019/1/4
 * 静态内部类
 **/
public class Singleton5 {
    private Singleton5() {
    }

    private static class SingletonHolder {
        private static Singleton5 instence = new Singleton5();
    }

    public static Singleton5 getInstance() {
        return SingletonHolder.instence;
    }
}
