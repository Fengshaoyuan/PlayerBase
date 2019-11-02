package com.kk.taurus.playerbase.record;

/**
 * Time:2019/11/2
 * Author:RuYIng
 * Description:
 */
public interface PlayValueGetter {

    int getCurrentPosition();

    int getBufferPercentage();

    int getDuration();

    int getState();

}
