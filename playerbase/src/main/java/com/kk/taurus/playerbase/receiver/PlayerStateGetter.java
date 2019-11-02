package com.kk.taurus.playerbase.receiver;

import com.kk.taurus.playerbase.player.IPlayer;

/**
 * Time:2019/11/2
 * Author:RuYIng
 * Description:
 *
 * player state getter for Receivers.
 */
public interface PlayerStateGetter {

    /**
     * get player state code.
     *
     * See also
     * {@link IPlayer#STATE_END}
     * {@link IPlayer#STATE_ERROR}
     * {@link IPlayer#STATE_IDLE}
     * {@link IPlayer#STATE_INITIALIZED}
     * {@link IPlayer#STATE_PREPARED}
     * {@link IPlayer#STATE_STARTED}
     * {@link IPlayer#STATE_PAUSED}
     * {@link IPlayer#STATE_STOPPED}
     * {@link IPlayer#STATE_PLAYBACK_COMPLETE}
     *
     * @return state
     */
    int getState();

    /**
     * get player current play progress.
     * @return int
     */
    int getCurrentPosition();

    /**
     * get video duration
     * @return int
     */
    int getDuration();

    /**
     * get player buffering percentage.
     * @return int
     */
    int getBufferPercentage();

    /**
     * the player is in buffering.
     * @return boolean
     */
    boolean isBuffering();

}
