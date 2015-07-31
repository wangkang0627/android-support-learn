package learn.com.android_support_learn.event;

import java.io.Serializable;

/**
 * @ClassName: BaseEvent
 * @Description: 本地base事件
 * @Author wk
 * @Date: 2015/7/31 0031
 */
public class BaseEvent{
    public int code;
    public Object data;

    public BaseEvent(int code) {
        this(code,null);
    }

    public BaseEvent(int code, Object object) {
        this.code = code;
        this.data = object;
    }
}
