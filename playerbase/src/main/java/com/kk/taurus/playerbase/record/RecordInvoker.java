package com.kk.taurus.playerbase.record;

import com.kk.taurus.playerbase.entity.DataSource;

/**
 * Time:2019/11/2
 * Author:RuYIng
 * Description:
 */
public class RecordInvoker {

    private OnRecordCallBack mCallBack;

    private RecordCache mRecordCache;

    public RecordInvoker(PlayRecordManager.RecordConfig config){
        this.mCallBack = config.getOnRecordCallBack();
        mRecordCache = new RecordCache(config.getMaxRecordCount());
    }

    public int saveRecord(DataSource dataSource, int record) {
        if(mCallBack!=null){
            return mCallBack.onSaveRecord(dataSource, record);
        }
        return mRecordCache.putRecord(getKey(dataSource), record);
    }

    public int getRecord(DataSource dataSource) {
        if(mCallBack!=null){
            return mCallBack.onGetRecord(dataSource);
        }
        return mRecordCache.getRecord(getKey(dataSource));
    }

    public int resetRecord(DataSource dataSource) {
        if(mCallBack!=null){
            return mCallBack.onResetRecord(dataSource);
        }
        return mRecordCache.putRecord(getKey(dataSource), 0);
    }

    public int removeRecord(DataSource dataSource) {
        if(mCallBack!=null){
            return mCallBack.onRemoveRecord(dataSource);
        }
        return mRecordCache.removeRecord(getKey(dataSource));
    }

    public void clearRecord() {
        if(mCallBack!=null){
            mCallBack.onClearRecord();
            return;
        }
        mRecordCache.clearRecord();
    }

    String getKey(DataSource dataSource){
        return PlayRecordManager.getKey(dataSource);
    }

}
