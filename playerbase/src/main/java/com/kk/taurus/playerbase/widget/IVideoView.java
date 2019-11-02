package com.kk.taurus.playerbase.widget;

import com.kk.taurus.playerbase.entity.DataSource;
import com.kk.taurus.playerbase.render.AspectRatio;
import com.kk.taurus.playerbase.render.IRender;

/**
 * Time:2019/11/2
 * Author:RuYIng
 * Description:
 */
public interface IVideoView {

    void setDataSource(DataSource dataSource);

    void setRenderType(int renderType);
    void setAspectRatio(AspectRatio aspectRatio);
    boolean switchDecoder(int decoderPlanId);

    void setVolume(float left, float right);
    void setSpeed(float speed);

    IRender getRender();

    boolean isInPlaybackState();
    boolean isPlaying();
    int getCurrentPosition();
    int getDuration();
    int getAudioSessionId();
    int getBufferPercentage();
    int getState();

    void start();
    void start(int msc);
    void pause();
    void resume();
    void seekTo(int msc);
    void stop();
    void stopPlayback();

}
