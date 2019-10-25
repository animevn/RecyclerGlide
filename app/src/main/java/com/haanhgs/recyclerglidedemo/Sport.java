package com.haanhgs.recyclerglidedemo;

import android.content.res.TypedArray;
import java.util.ArrayList;
import java.util.List;

public class Sport {

    private String title;
    private String info;
    private int imageResource;

    private Sport(String title, String info, int imageResource) {
        this.title = title;
        this.info = info;
        this.imageResource = imageResource;
    }

    public static List<Sport> createList(){
        List<Sport> sports = new ArrayList<>();
        String[]titles = App.context().getResources().getStringArray(R.array.sports_titles);
        String[]infos = App.context().getResources().getStringArray(R.array.sports_info);
        TypedArray images = App.context().getResources().obtainTypedArray(R.array.sports_images);
        for (int i = 0; i < titles.length; ++i){
            Sport sport = new Sport(titles[i], infos[i], images.getResourceId(i, 0));
            sports.add(sport);
        }
        images.recycle();
        return sports;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public int getImageResource() {
        return imageResource;
    }

    public void setImageResource(int imageResource) {
        this.imageResource = imageResource;
    }
}
