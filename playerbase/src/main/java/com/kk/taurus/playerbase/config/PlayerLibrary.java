package com.kk.taurus.playerbase.config;

import android.content.Context;

/**
 * Time:2019/11/2
 * Author:RuYIng
 * Description:
 */
public class PlayerLibrary {

    public static void init(Context context){
        AppContextAttach.attach(context);
    }

}
