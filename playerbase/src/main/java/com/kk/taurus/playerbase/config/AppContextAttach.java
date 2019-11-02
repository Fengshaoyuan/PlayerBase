package com.kk.taurus.playerbase.config;

import android.content.Context;
import android.util.Log;

/**
 * Time:2019/11/2
 * Author:RuYIng
 * Description:
 */
public class AppContextAttach {

    private static Context mAppContext;

    static void attach(Context context){
        mAppContext = context.getApplicationContext();
    }

    public static Context getApplicationContext(){
        if(mAppContext==null){
            Log.e("AppContextAttach", "app context not init !!!");
            throw new RuntimeException("if you need context for using decoder, you must call PlayerLibrary.init(context).");
        }
        return mAppContext;
    }

}
