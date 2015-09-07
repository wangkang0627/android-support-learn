# android-support-learn
----------------------
###这个项目主要是介绍一些相关support包的作用，尽量能够采用官方提供的包进行开发，少写很多不必要的代码


##布局
####LinearLayoutCompat
LinearLayoutCompat 主要作用就是兼容divider，LinearLayout的divider 属性设置是Android API 11 之后加进去的，Android API 11之前的设备要使用这个divider需要LinearLayoutCompat。
下面是具体使用方法

```xml
<android.support.v7.widget.LinearLayoutCompat 
    xmlns:android="http://schemas.android.com/apk/res/android"
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

##Widget
###1.RecyclerView 瀑布流的用法
现在的RecyclerView是直接支持瀑布流的用法的，可以完全采用原生包里面的类，通过简单的配置来实现瀑布流。StaggeredGridLayoutManager，并且支持水平的瀑布流。具体使用方式如下：

```java
//指定布局管理器
recyclerview.setLayoutManager(new StaggeredGridLayoutManager(3,StaggeredGridLayoutManager.HORIZONTAL));
 builder.show();
		
//在RecyclerView的bindview中随机的设置高度，来形成高度视觉差即可
int height = (int) ((position % 3 + 1) * 30 + mContext.getResources().getDimension(R.dimen.stage_height));
ViewGroup.MarginLayoutParams params = (ViewGroup.MarginLayoutParams) holder.iv_image.getLayoutParams();
params.height = height;
holder.iv_image.setLayoutParams(params);
```

如下效果图效果图：

![Renderings](http://7xjwjf.com1.z0.glb.clouddn.com/gif/android/144144339861y2zd6v_tuhaokuai_com_0x0.png)  

------

###2.AlertDialog
提供了Material Design的dialog
```java
 android.support.v7.app.AlertDialog.Builder builder = new android.support.v7.app.AlertDialog.Builder(DialogCompatActivity.this);
 builder.setTitle("Dialog");
 builder.setMessage("测试");
 builder.setPositiveButton(android.R.string.yes, null);
 builder.setNegativeButton(android.R.string.no, null);
 builder.show();
```
效果图：![Renderings](http://7xjwjf.com1.z0.glb.clouddn.com/gif/android/sscreenshot_2015-09-02-12-28-26.png)  

------

###3.AppCompatButton AppCompatTextView
A Button which supports compatible features on older version of the platform, including:

+ Supports textAllCaps style attribute which works back to Eclair MR1.
+ Allows dynamic tint of it background via the background tint methods in ViewCompat.
+ Allows setting of the background tint using backgroundTint and backgroundTintMode.
+ This will automatically be used when you use Button in your layouts. You should only need to manually use this class when writing custom views.

AppCompatTextView 增加属性textAllCaps（支持文本全部大写 ）,AppCompatButton 支持textAllCaps 并且提供了额外的两个属性。两个属性的意思是提供了api21上支持的setBackgroundTintList，Tint的意思就是着色，可以试着看看效果图，采用一张白色的星星可以实现点击后的效果，大大的减少了点击效果的资源，很多按钮都可以使用这个button来实现，setBackgroundTintMode这个属性就是着色的模式，具体可以看看这篇文章
 [链接](http://blog.csdn.net/t12x3456/article/details/10432935)

一下是各种model的中文解释

1.PorterDuff.Mode.CLEAR  
  所绘制不会提交到画布上。

2.PorterDuff.Mode.SRC
   显示上层绘制图片

3.PorterDuff.Mode.DST
  显示下层绘制图片

4.PorterDuff.Mode.SRC_OVER
  正常绘制显示，上下层绘制叠盖。

5.PorterDuff.Mode.DST_OVER
  上下层都显示。下层居上显示。

6.PorterDuff.Mode.SRC_IN
   取两层绘制交集。显示上层。

7.PorterDuff.Mode.DST_IN
  取两层绘制交集。显示下层。

8.PorterDuff.Mode.SRC_OUT
 取上层绘制非交集部分。

9.PorterDuff.Mode.DST_OUT
 取下层绘制非交集部分。

10.PorterDuff.Mode.SRC_ATOP
 取下层非交集部分与上层交集部分

11.PorterDuff.Mode.DST_ATOP
 取上层非交集部分与下层交集部分

12.PorterDuff.Mode.XOR
  异或：去除两图层交集部分

13.PorterDuff.Mode.DARKEN
  取两图层全部区域，交集部分颜色加深

14.PorterDuff.Mode.LIGHTEN
  取两图层全部，点亮交集部分颜色

15.PorterDuff.Mode.MULTIPLY
  取两图层交集部分叠加后颜色

16.PorterDuff.Mode.SCREEN
  取两图层全部区域，交集部分变为透明色


```java
  this.btncompat = (AppCompatButton) findViewById(R.id.btn_compat);
        this.btncompat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ColorStateList lists = getResources().getColorStateList(android.R.color.holo_red_light);
                ViewCompat.setBackgroundTintList(btncompat, lists);
                ViewCompat.setBackgroundTintMode(btncompat, PorterDuff.Mode.SRC_IN);
            }
        });
```

点击前：

![Renderings](http://7xjwjf.com1.z0.glb.clouddn.com/gif/android/qq20150902133050.png)  

点击后：

![Renderings](http://7xjwjf.com1.z0.glb.clouddn.com/gif/android/qq20150902132909.png)  