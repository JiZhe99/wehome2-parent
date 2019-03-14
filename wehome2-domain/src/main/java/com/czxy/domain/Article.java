package com.czxy.domain;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by Administrator on 2019/2/28 0028.
 */
@Entity
@Table(name = "article")
public class Article {
    private  String atitle;
    private  String atext;

    public String getAtitle() {
        return atitle;
    }

    public void setAtitle(String atitle) {
        this.atitle = atitle;
    }

    public String getAtext() {
        return atext;
    }

    public void setAtext(String atext) {
        this.atext = atext;
    }
}
