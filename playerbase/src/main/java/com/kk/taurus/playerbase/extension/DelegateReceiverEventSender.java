package com.kk.taurus.playerbase.extension;

import android.os.Bundle;

import com.kk.taurus.playerbase.receiver.IReceiverGroup;

/**
 * Time:2019/11/2
 * Author:RuYIng
 * Description:
 */
public interface DelegateReceiverEventSender {

    void sendEvent(int eventCode, Bundle bundle, IReceiverGroup.OnReceiverFilter receiverFilter);

    void sendObject(String key, Object value, IReceiverGroup.OnReceiverFilter receiverFilter);

}
