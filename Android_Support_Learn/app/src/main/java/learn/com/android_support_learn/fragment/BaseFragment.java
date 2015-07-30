package learn.com.android_support_learn.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;

/**
 * @ClassName: BaseFragment
 * @Description:
 * @Author wk
 * @Date: 2015/7/30 0030
 */
public abstract class BaseFragment extends Fragment {
    protected View rootView;
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if (rootView == null) {
            rootView = inflater.inflate(getLayoutResource(), null);
            init();
        }
        ViewGroup parent = (ViewGroup) rootView.getParent();
        if (parent != null) {
            parent.removeView(rootView);
        }
        return rootView;
    }

    /**
     * 初始化，在加载布局后调用
     */
    protected abstract void init();

    /**
     *
     * @return
     */
    protected abstract int getLayoutResource();


}
