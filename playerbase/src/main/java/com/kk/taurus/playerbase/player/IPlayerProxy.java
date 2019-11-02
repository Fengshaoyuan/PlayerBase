package com.kk.taurus.playerbase.player;

import android.os.Bundle;

import com.kk.taurus.playerbase.entity.DataSource;

/**
 * Time:2019/11/2
 * Author:RuYIng
 * Description:
 */
public interface IPlayerProxy {

    void onDataSourceReady(DataSource dataSource);

    void onIntentStop();

    void onIntentReset();

    void onIntentDestroy();

    void onPlayerEvent(int eventCode, Bundle bundle);

    void onErrorEvent(int eventCode, Bundle bundle);

    int getRecord(DataSource dataSource);

}
