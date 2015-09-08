# android-support-learn
----------------------
###这个项目主要是介绍一些相关support包的作用，尽量能够采用官方提供的包进行开发，少写很多不必要的代码。下面所介绍的功能都能够在Android_Support_Learn中的app那个项目里面


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
###1.1RecyclerView 瀑布流的用法
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


###1.2RecyclerView 滑动删除，长按排序

现在的RecyclerView支持一些新特性，比如滑动删除和长按排序。RecyclerView通过与ItemTouchHelper的结合来实现这个功能，通过简单的初始化：

```java

public BaseDragRecycleAdapter(Context context, RecyclerView recyclerView) {
    super(context);
    TAG = getClass().getName();
    this.mRecyclerView = recyclerView;
    mCallback = createCallback();
    mItemTouchHelper = new ItemTouchHelper(mCallback);
    //绑定recyclerview
    mItemTouchHelper.attachToRecyclerView(mRecyclerView);
}


//滑动支持
protected int getMovementFlags(RecyclerView recyclerView,
                               RecyclerView.ViewHolder viewHolder) {
	//滑动支持向左和向右 0表示不支持的方向 mSwipLeftEnabled 是成员变量里面可以动态设置
    int swipeFlag = (mSwipLeftEnabled ? ItemTouchHelper.LEFT : 0) | (mSwipRightEnabled ? ItemTouchHelper.RIGHT : 0);
    //上下拖拽的支持 
    int dragFlag = (mDragUpEnabled ? ItemTouchHelper.UP : 0) |
            (mDragDownEnabled ? ItemTouchHelper.DOWN : 0);
    return mCallback.makeMovementFlags(dragFlag
            , swipeFlag);
}

/**
 * 上下移动的时候调用
 *
 * @param from 点击的position
 * @param to   放入的position
 */
protected boolean move(int from, int to) {
    T prev = mDatas.remove(from);
    mDatas.add(to > from ? to - 1 : to, prev);
    notifyItemMoved(from, to);
    return true;
}
//侧滑后进行删除
public void delete(int position) {
    mDatas.remove(position);
    notifyItemRemoved(position);
}

/**
 * @param viewHolder
 * @param direction  方向
 */
protected void onSwiped(RecyclerView.ViewHolder viewHolder, int direction) {
    if (direction == ItemTouchHelper.RIGHT) {
        Log.d(TAG, "onSwiped:RIGHT");
    } else if (direction == ItemTouchHelper.LEFT) {
        Log.d(TAG, "onSwiped:LEFT");
    }
    delete(viewHolder.getAdapterPosition());//删除
}

protected boolean onChildDraw(Canvas c, RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, float dX, float dY, int actionState, boolean isCurrentlyActive) {
    return false;
}

protected boolean onChildDrawOver(Canvas c, RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, float dX, float dY, int actionState, boolean isCurrentlyActive) {
    return false;
}

public ItemTouchHelper.Callback createCallback() {
    return new ItemTouchHelper.Callback() {
        //获取滑动的几种方案
        @Override
        public int getMovementFlags(RecyclerView recyclerView,
                                    RecyclerView.ViewHolder viewHolder) {
            return BaseDragRecycleAdapter.this.getMovementFlags(recyclerView, viewHolder);
        }

		
        @Override
        public boolean onMove(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder,
                              RecyclerView.ViewHolder target) {
            return BaseDragRecycleAdapter.this.move(viewHolder.getAdapterPosition(), target.getAdapterPosition());
        }

        @Override
        public void onSwiped(RecyclerView.ViewHolder viewHolder, int direction) {
            BaseDragRecycleAdapter.this.onSwiped(viewHolder, direction);
        }

        @Override
        public void onSelectedChanged(RecyclerView.ViewHolder viewHolder, int actionState) {
            //  super.onSelectedChanged(viewHolder, actionState);
            BaseDragRecycleAdapter.this.onSelectedChanged(viewHolder, actionState);
        }

        @Override
        public void onChildDraw(Canvas c, RecyclerView recyclerView,
                                RecyclerView.ViewHolder viewHolder,
                                float dX, float dY, int actionState, boolean isCurrentlyActive) {

            if (BaseDragRecycleAdapter.this.onChildDraw(c, recyclerView, viewHolder,
                    dX, dY, actionState, isCurrentlyActive)) {
                return;
            }
            super.onChildDraw(c, recyclerView, viewHolder, dX, dY, actionState,
                    isCurrentlyActive);
        }


        /**
         *  Most of the time, you only need to override onChildDraw but due to limitations of platform prior
         *  to Honeycomb, you may need to implement onChildDrawOver as well.
         * @param c
         * @param recyclerView
         * @param viewHolder
         * @param dX
         * @param dY
         * @param actionState
         * @param isCurrentlyActive
         */
        @Override
        public void onChildDrawOver(Canvas c, RecyclerView recyclerView,
                                    RecyclerView.ViewHolder viewHolder, float dX, float dY, int actionState,
                                    boolean isCurrentlyActive) {
            if (BaseDragRecycleAdapter.this.onChildDrawOver(c, recyclerView, viewHolder,
                    dX, dY, actionState, isCurrentlyActive)) {
                return;
            }
            super.onChildDrawOver(c, recyclerView, viewHolder, dX, dY, actionState,
                    isCurrentlyActive);
        }
        //是否支持长按拖拽
        @Override
        public boolean isLongPressDragEnabled() {
            return longPressDragEnabled;
        }
		//是否支持滑动删除
        @Override
        public boolean isItemViewSwipeEnabled() {
            return itemViewSwipeEnabled;
        }

        @Override
        public void clearView(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder) {
            super.clearView(recyclerView, viewHolder);
            //ItemTouchHelperActivity.this.clearView(viewHolder);
        }
    };
}

```

如下效果图效果图：

![Renderings](http://7xjwjf.com1.z0.glb.clouddn.com/gif/android/1441633004vwbtswj4_tuhaokuai_com_0x0.gif)  





###1.3RecyclerView item动画
RecyclerView支持更新单个的item，这样处理起来性能就会比整体更新高很多，只不过这个性能差别并不是明显，几乎可以忽略。但是提供的几个方法能够提供很好的交互效果，当对单个数据进行插入，移动，修改的时候能够自动提供动画，这个动画可以通过继承RecyclerView的RecyclerView.ItemAnimator 进行重写，当然他也有自己的默认动画。默认不设置就是默认动画
```java

  adapter.notifyItemInserted(2);
  adapter.notifyItemRemoved(position);
  adapter.notifyItemChanged(position);

```

效果图：![Renderings](http://7xjwjf.com1.z0.glb.clouddn.com/gif/android/1441682339hfx2hhg7_tuhaokuai_com_0x0.gif)  

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

AppCompatTextView 增加属性textAllCaps（支持文本全部大写 ）,AppCompatButton 支持textAllCaps 并且提供了额外的两个属性。两个属性的意思是提供了api21上支持的setBackgroundTintList，Tint的意思就是着色，可以试着看看效果图，采用一张白色的星星可以实现点击后的效果，大大的减少了点击效果的资源，很多按钮都可以使用这个button来实现，setBackgroundTintMode这个属性就是着色的模式，简单的来说他可以使一个张白色的图标变成一张红色的图标，从而减少了资源的使用。具体可以看看这篇文章
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