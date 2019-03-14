package com.czxy.domain;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by Administrator on 2019/3/6 0006.
 */
@Entity
@Table(name = "comment")
public class Comment {

    private  Integer cid;
    private  String cname;
    private  String cimage;
    private  String ctext;
    private  String cdate;

    public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public String getCimage() {
        return cimage;
    }

    public void setCimage(String cimage) {
        this.cimage = cimage;
    }

    public String getCtext() {
        return ctext;
    }

    public void setCtext(String ctext) {
        this.ctext = ctext;
    }

    public String getCdate() {
        return cdate;
    }

    public void setCdate(String cdate) {
        this.cdate = cdate;
    }
}
