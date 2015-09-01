# android-support-learn
----------------------
###这个项目主要是介绍一些相关support包的作用，尽量能够采用官方提供的包进行开发，少写很多不必要的代码


##布局
####LinearLayoutCompat
LinearLayoutCompat 主要作用就是兼容divider，LinearLayout的divider 属性设置是Android API 11 之后加进去的，Android API 11之前的设备要使用这个divider需要LinearLayoutCompat。
下面是具体使用方法

```xml
<android.support.v7.widget.LinearLayoutCompat xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    android:id="@+id/linear_compat"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:orientation="vertical"
    app:divider="@drawable/divider_shape"
    app:dividerPadding="2dp"
    app:showDividers="middle|end">
    <!--middle 在每一项中间添加分割线
    end 在整体的最后一项添加分割线
    beginning 在整体的最上方添加分割线
    none 无-->
    
</android.support.v7.widget.LinearLayoutCompat>

```