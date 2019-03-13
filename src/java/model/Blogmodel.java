/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Blob;

/**
 *
 * @author hp
 */
public class Blogmodel {
    
    private String diaryname;
    private String blogname;
    private int diary_id;
    private int version_id;
    private int state_id;
    private Blob written_obj;
    private String image;

    public String getDiaryname() {
        return diaryname;
    }

    public void setDiaryname(String diaryname) {
        this.diaryname = diaryname;
    }

    public String getBlogname() {
        return blogname;
    }

    public void setBlogname(String blogname) {
        this.blogname = blogname;
    }

    public int getDiary_id() {
        return diary_id;
    }

    public void setDiary_id(int diary_id) {
        this.diary_id = diary_id;
    }

    public int getVersion_id() {
        return version_id;
    }

    public void setVersion_id(int version_id) {
        this.version_id = version_id;
    }

    public int getState_id() {
        return state_id;
    }

    public void setState_id(int state_id) {
        this.state_id = state_id;
    }

    public Blob getWritten_obj() {
        return written_obj;
    }

    public void setWritten_obj(Blob written_obj) {
        this.written_obj = written_obj;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
    
    
}
