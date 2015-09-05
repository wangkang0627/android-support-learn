package learn.com.android_support_learn.model;

import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.databinding.ObservableArrayList;
import android.databinding.ObservableList;

import java.io.Serializable;

import learn.com.android_support_learn.BR;

/**
 * @ClassName: ImageModel
 * @Description:
 * @Author wk
 * @Date 2015/9/4 0004
 */
public class ImageModel extends BaseModel implements Serializable {
    public int id;
    public String img;
    public boolean prize = false;//是否点赞


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Bindable
    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
        notifyPropertyChanged(BR.img);
    }

    @Bindable
    public boolean isPrize() {
        return prize;
    }

    public void setPrize(boolean prize) {
        this.prize = prize;
        notifyPropertyChanged(BR.prize);
    }
}
