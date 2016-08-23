package com.fc.lotro.entity;

import java.io.Serializable;

/**
 * Created by tytyfn on 2016/8/9.
 *
 */
public class GridListItem implements Serializable{
    private String title;
    private int photoId;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getPhotoId() {
        return photoId;
    }

    public void setPhotoId(int photoId) {
        this.photoId = photoId;
    }
}
