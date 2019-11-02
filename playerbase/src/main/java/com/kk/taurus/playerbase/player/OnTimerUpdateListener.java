package com.kk.taurus.playerbase.player;

import com.kk.taurus.playerbase.AVPlayer;

/**
 * Time:2019/11/2
 * Author:RuYIng
 * Description:
 *
 * in AVPlayer default open timer proxy, you can use update callback to refresh UI.
 * if you close timer proxy{@link AVPlayer#setUseTimerProxy(boolean)},
 * you will not receive this timer update callback.
 * if timer open , the call back called per second.
 * in some scene, you can close it to improve battery performance.
 *
 */
public interface OnTimerUpdateListener {
    void onTimerUpdate(int curr, int duration, int bufferPercentage);
}
