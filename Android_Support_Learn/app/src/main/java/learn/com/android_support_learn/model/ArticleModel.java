package learn.com.android_support_learn.model;

/**
 * @ClassName: ArticleModel
 * @Description:
 * @Author wk
 * @Date 2015/9/8 0008
 */
public class ArticleModel extends BaseModel {
    public String desc;//描述
    public String content;//内容

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
