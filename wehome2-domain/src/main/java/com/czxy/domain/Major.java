package com.czxy.domain;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by Administrator on 2019/2/27 0027.
 */
@Entity
@Table(name="major")
public class Major {

    private  String title;
    private  String content;
    private  String image;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
