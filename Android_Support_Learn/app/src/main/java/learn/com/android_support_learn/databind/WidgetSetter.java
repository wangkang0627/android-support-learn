package learn.com.android_support_learn.databind;

import android.content.res.ColorStateList;
import android.databinding.BindingAdapter;
import android.support.annotation.ColorInt;
import android.support.annotation.ColorRes;
import android.support.v4.view.ViewCompat;
import android.support.v7.widget.AppCompatButton;

/**
 * @ClassName: WidgetSetter
 * @Description:
 * @Author wk
 * @Date 2015/9/5 0005
 */
public class WidgetSetter {
    @BindingAdapter("backgroundTint")
    public static void setBackgroundTint(AppCompatButton appCompatButton,@ColorInt int res){
        ColorStateList lists = ColorStateList.valueOf(res);
        ViewCompat.setBackgroundTintList(appCompatButton, lists);
    }
}
