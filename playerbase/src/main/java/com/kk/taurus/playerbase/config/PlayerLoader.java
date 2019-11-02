package com.kk.taurus.playerbase.config;

import com.kk.taurus.playerbase.player.BaseInternalPlayer;

import java.lang.reflect.Constructor;

/**
 * Time:2019/11/2
 * Author:RuYIng
 * Description:
 *
 * The decoder instance loader is loaded
 * according to the decoding scheme you set.
 *
 */

public class PlayerLoader {

    public static BaseInternalPlayer loadInternalPlayer(int decoderPlanId){
        BaseInternalPlayer internalPlayer = null;
        try {
            Object decoderInstance = getDecoderInstance(decoderPlanId);
            if(decoderInstance instanceof BaseInternalPlayer){
                internalPlayer = (BaseInternalPlayer) decoderInstance;
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return internalPlayer;
    }

    public static Object getDecoderInstance(int planId){
        Object instance = null;
        try{
            Class clz = getSDKClass(PlayerConfig.getPlan(planId).getClassPath());
            if(clz!=null){
                Constructor constructor = getConstructor(clz);
                if(constructor!=null){
                    instance = constructor.newInstance();
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return instance;
    }

    private static Constructor getConstructor(Class clz){
        Constructor result = null;
        try{
            result = clz.getConstructor();
        }catch (Exception e){
            e.printStackTrace();
        }
        return result;
    }

    private static Class getSDKClass(String classPath){
        Class result = null;
        try {
            result = Class.forName(classPath);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return result;
    }

}
