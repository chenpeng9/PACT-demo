package com.peng.model;


public class Book {
    private String kind;
    private String id;
    private String selfLink;
    private Volume volumeInfo = new Volume();

    public String getKind() {
        return kind;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSelfLink() {
        return selfLink;
    }

    public void setSelfLink(String selfLink) {
        this.selfLink = selfLink;
    }

    public Volume getVolumeInfo() {
        return volumeInfo;
    }

    public void setVolumeInfo(Volume volumeInfo) {
        this.volumeInfo = volumeInfo;
    }

}
