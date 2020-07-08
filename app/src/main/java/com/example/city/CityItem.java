package com.example.city;

public class CityItem {
    private int imageResource;
    private String title;
    private String key_id;
    private String citystatus;

    public CityItem(int imageResource, String title, String key_id, String citystatus){
        this.imageResource = imageResource;
        this.title = title;
        this.key_id = key_id;
        this.citystatus = citystatus;
    }

    public int getImageResource() {
        return imageResource;
    }

    public void setImageResource(int imageResource) {
        this.imageResource = imageResource;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getKey_id() {
        return key_id;
    }

    public void setKey_id(String key_id) {
        this.key_id = key_id;
    }

    public String getCitystatus() {
        return citystatus;
    }

    public void setCitystatus(String citystatus) {
        this.citystatus = citystatus;
    }
}
