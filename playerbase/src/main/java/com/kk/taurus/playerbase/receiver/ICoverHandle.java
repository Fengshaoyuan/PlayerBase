package com.kk.taurus.playerbase.receiver;

import android.os.Bundle;

/**
 * Time:2019/11/2
 * Author:RuYIng
 * Description:
 */
public interface ICoverHandle {

    void requestPause(Bundle bundle);
    void requestResume(Bundle bundle);
    void requestSeek(Bundle bundle);
    void requestStop(Bundle bundle);
    void requestReset(Bundle bundle);
    void requestRetry(Bundle bundle);
    void requestReplay(Bundle bundle);
    void requestPlayDataSource(Bundle bundle);

    void requestNotifyTimer();
    void requestStopTimer();

}
