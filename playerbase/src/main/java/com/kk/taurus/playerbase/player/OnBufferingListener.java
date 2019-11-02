package com.kk.taurus.playerbase.player;

import android.os.Bundle;

/**
 * Time:2019/11/2
 * Author:RuYIng
 * Description:
 *
 * Created by Taurus on 2018/6/14.
 */
public interface OnBufferingListener {

    void onBufferingUpdate(int bufferPercentage, Bundle extra);

}
