package com.bindlearn.model;

import java.io.Serializable;
import java.util.Date;

/**
 * @ClassName: UserModel
 * @Description:
 * @Author wk
 * @Date 2015/9/8 0008
 */
public class UserModel implements Serializable {
    public String name;
    public String card_num;
    public Date date;

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCard_num() {
        return card_num;
    }

    public void setCard_num(String card_num) {
        this.card_num = card_num;
    }
}
