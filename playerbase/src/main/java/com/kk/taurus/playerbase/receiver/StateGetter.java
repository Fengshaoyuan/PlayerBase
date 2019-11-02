package com.kk.taurus.playerbase.receiver;

/**
 * Time:2019/11/2
 * Author:RuYIng
 * Description:
 *
 * the state getter for receivers, because receivers dynamic attach,
 * maybe you need get some state on attach.
 */
public interface StateGetter {

    PlayerStateGetter getPlayerStateGetter();

}
