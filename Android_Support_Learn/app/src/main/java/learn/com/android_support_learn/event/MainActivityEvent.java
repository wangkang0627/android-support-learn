package learn.com.android_support_learn.event;

/**
 * @ClassName: MainActivityEvent
 * @Description: MainActivityEvent的事件
 * @Author wk
 * @Date: 2015/7/31 0031
 */
public class MainActivityEvent extends BaseEvent {
    public static final int SlidingPane = 1;//侧边栏打开关闭
    public MainActivityEvent(int code) {
        super(code);
    }

    public MainActivityEvent(int code, Object object) {
        super(code, object);
    }
}
