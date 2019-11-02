package com.kk.taurus.playerbase.assist;

import android.view.ViewGroup;

import com.kk.taurus.playerbase.entity.DataSource;
import com.kk.taurus.playerbase.event.OnErrorEventListener;
import com.kk.taurus.playerbase.event.OnPlayerEventListener;
import com.kk.taurus.playerbase.provider.IDataProvider;
import com.kk.taurus.playerbase.receiver.IReceiverGroup;
import com.kk.taurus.playerbase.receiver.OnReceiverEventListener;
import com.kk.taurus.playerbase.render.AspectRatio;

/**
 * Time:2019/11/2
 * Author:RuYIng
 * Description:
 */
public interface AssistPlay {

    void setOnPlayerEventListener(OnPlayerEventListener onPlayerEventListener);
    void setOnErrorEventListener(OnErrorEventListener onErrorEventListener);
    void setOnReceiverEventListener(OnReceiverEventListener onReceiverEventListener);

    void setOnProviderListener(IDataProvider.OnProviderListener onProviderListener);
    void setDataProvider(IDataProvider dataProvider);
    boolean switchDecoder(int decoderPlanId);

    void setRenderType(int renderType);
    void setAspectRatio(AspectRatio aspectRatio);

    void setVolume(float left, float right);
    void setSpeed(float speed);

    void setReceiverGroup(IReceiverGroup receiverGroup);

    void attachContainer(ViewGroup userContainer);

    void setDataSource(DataSource dataSource);

    void play();
    void play(boolean updateRender);

    boolean isInPlaybackState();
    boolean isPlaying();
    int getCurrentPosition();
    int getDuration();
    int getAudioSessionId();
    int getBufferPercentage();
    int getState();

    void rePlay(int msc);

    void pause();
    void resume();
    void seekTo(int msc);
    void stop();
    void reset();
    void destroy();

}
