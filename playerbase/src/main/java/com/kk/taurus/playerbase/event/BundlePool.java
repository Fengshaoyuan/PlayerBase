package com.kk.taurus.playerbase.event;

import android.os.Bundle;

import com.kk.taurus.playerbase.log.PLog;

import java.util.ArrayList;
import java.util.List;

/**
 * Time:2019/11/2
 * Author:RuYIng
 * Description:
 *
 * In order to improve memory performance,
 * the bundle entities passed in the framework
 * come from the bundle buffer pool.
 *
 */

public class BundlePool {

    private static final int POOL_SIZE = 3;

    private static List<Bundle> mPool;

    static {
        mPool = new ArrayList<>();
        for(int i=0;i<POOL_SIZE;i++)
            mPool.add(new Bundle());
    }

    public synchronized static Bundle obtain(){
        for(int i=0;i<POOL_SIZE;i++){
            if(mPool.get(i).isEmpty()){
                return mPool.get(i);
            }
        }
        PLog.w("BundlePool","<create new bundle object>");
        return new Bundle();
    }

}
