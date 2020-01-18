package com.haanhgs.recyclerglidedemo.model;

import android.content.Context;
import android.content.res.TypedArray;
import com.haanhgs.recyclerglidedemo.R;
import java.util.ArrayList;
import java.util.List;

public class Repo {

    public static List<Sport> getList(Context context){
        List<Sport> sports = new ArrayList<>();
        String[]titles = context.getResources().getStringArray(R.array.sports_titles);
        String[]infos = context.getResources().getStringArray(R.array.sports_info);
        TypedArray imgStrings = context.getResources().obtainTypedArray(R.array.sports_images);
        for (int i = 0; i < imgStrings.length(); i++){
            Sport sport = new Sport(titles[i], infos[i], imgStrings.getResourceId(i, 0));
            sports.add(sport);
        }
        imgStrings.recycle();
        return sports;
    }
}
