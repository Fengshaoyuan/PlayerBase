package com.kk.taurus.playerbase.record;

import com.kk.taurus.playerbase.entity.DataSource;

/**
 * Time:2019/11/2
 * Author:RuYIng
 * Description:
 *
 * if you want to custom save record, you can set it.
 */
public interface OnRecordCallBack {

    int onSaveRecord(DataSource dataSource, int record);

    int onGetRecord(DataSource dataSource);

    int onResetRecord(DataSource dataSource);

    int onRemoveRecord(DataSource dataSource);

    void onClearRecord();

}
