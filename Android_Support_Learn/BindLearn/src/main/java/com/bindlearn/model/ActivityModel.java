package com.bindlearn.model;





import java.io.Serializable;


/**
 * @ClassName: ActivityModel
 * @Description:
 * @Author wk
 * @Date 2015/9/1 0001
 */
public class ActivityModel implements Serializable {

    public String img;
    public String name;

    public Class aClass;

    public String getImg() {
        return img;
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
