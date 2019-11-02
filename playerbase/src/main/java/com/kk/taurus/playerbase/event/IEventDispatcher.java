package com.kk.taurus.playerbase.event;

import android.os.Bundle;
import android.view.MotionEvent;

import com.kk.taurus.playerbase.receiver.IReceiverGroup;

/**
 * Time:2019/11/2
 * Author:RuYIng
 * Description:
 */
public interface IEventDispatcher {
    void dispatchPlayEvent(int eventCode, Bundle bundle);
    void dispatchErrorEvent(int eventCode, Bundle bundle);
    void dispatchReceiverEvent(int eventCode, Bundle bundle);
    void dispatchReceiverEvent(int eventCode, Bundle bundle, IReceiverGroup.OnReceiverFilter onReceiverFilter);
    void dispatchProducerEvent(int eventCode, Bundle bundle, IReceiverGroup.OnReceiverFilter onReceiverFilter);
    void dispatchProducerData(String key, Object data, IReceiverGroup.OnReceiverFilter onReceiverFilter);


    void dispatchTouchEventOnSingleTabUp(MotionEvent event);
    void dispatchTouchEventOnDoubleTabUp(MotionEvent event);
    void dispatchTouchEventOnDown(MotionEvent event);
    void dispatchTouchEventOnScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY);
    void dispatchTouchEventOnEndGesture();
}
