package learn.com.android_support_learn.model;

import android.databinding.BindingAdapter;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.support.annotation.Nullable;
import android.widget.ImageView;

import com.facebook.common.executors.CallerThreadExecutor;
import com.facebook.common.references.CloseableReference;
import com.facebook.datasource.DataSource;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.imagepipeline.datasource.BaseBitmapDataSubscriber;
import com.facebook.imagepipeline.image.CloseableImage;
import com.facebook.imagepipeline.request.ImageRequest;

import java.io.Serializable;

import learn.com.android_support_learn.PApplication;

/**
 * @ClassName: ActivityModel
 * @Description:
 * @Author wk
 * @Date 2015/9/1 0001
 */
public class ActivityModel implements Serializable{
    public String img;
    public String name;
    public Class aClass;

    public String getImg() {
        return img;
    }
    @BindingAdapter({"bind:url"})
    public static void loadImage(final ImageView view, String url) {
        DataSource<CloseableReference<CloseableImage>> dataSource = Fresco.getImagePipeline().fetchDecodedImage(ImageRequest.fromUri(Uri.parse(url)), PApplication.getInstance());
        dataSource.subscribe(new BaseBitmapDataSubscriber() {
                                 @Override
                                 public void onNewResultImpl(@Nullable final Bitmap bitmap) {
                                     view.post(new Runnable() {
                                         public void run() {
                                             view.setImageBitmap(bitmap);
                                         }
                                     });
                                 }
                                 @Override
                                 public void onFailureImpl(DataSource dataSource) {
                                     // No cleanup required here.
                                 }
                             },
                CallerThreadExecutor.getInstance());
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Class getaClass() {
        return aClass;
    }

    public void setaClass(Class aClass) {
        this.aClass = aClass;
    }
}
