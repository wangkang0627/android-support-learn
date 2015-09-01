package learn.com.android_support_learn;

/**
 * Created by Administrator on 2015/9/1 0001.
 */
public class test {
    private static test ourInstance = new test();

    public static test getInstance() {
        return ourInstance;
    }

    private test() {
    }
}
