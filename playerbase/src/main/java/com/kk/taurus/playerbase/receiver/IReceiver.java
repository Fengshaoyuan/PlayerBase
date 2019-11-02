package com.kk.taurus.playerbase.receiver;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/**
 * Time:2019/11/2
 * Author:RuYIng
 * Description:
 */
public interface IReceiver {

    /**
     * bind host group.
     * @param receiverGroup receiverGroup
     */
    void bindGroup(@NonNull IReceiverGroup receiverGroup);

    /**
     * on receiver added to ReceiverGroup.
     */
    void onReceiverBind();

    /**
     * all player event dispatch by this method.
     * @param eventCode eventCode
     * @param bundle bundle
     */
    void onPlayerEvent(int eventCode, Bundle bundle);

    /**
     * error event.
     * @param eventCode eventCode
     * @param bundle bundle
     */
    void onErrorEvent(int eventCode, Bundle bundle);

    /**
     * bind a state getter.
     * @param stateGetter stateGetter
     */
    void bindStateGetter(StateGetter stateGetter);

    /**
     * bind the bridge of receivers communication
     * @param onReceiverEventListener onReceiverEventListener
     */
    void bindReceiverEventListener(OnReceiverEventListener onReceiverEventListener);

    /**
     * receivers event.
     * @param eventCode eventCode
     * @param bundle bundle
     */
    void onReceiverEvent(int eventCode, Bundle bundle);

    /**
     * you can call this method dispatch private event.
     *
     * @param eventCode eventCode
     * @param bundle bundle
     *
     * @return Bundle Return value after the receiver's response, nullable.
     */
    @Nullable
    Bundle onPrivateEvent(int eventCode, Bundle bundle);

    /**
     * producer event call back this method
     * @param eventCode eventCode
     * @param bundle bundle
     */
    void onProducerEvent(int eventCode, Bundle bundle);

    /**
     * producer data call back this method
     * @param key key
     * @param data data
     */
    void onProducerData(String key, Object data);

    /**
     * on receiver destroy.
     * when receiver removed, this method will be callback.
     */
    void onReceiverUnBind();

    /**
     * get the receiver key, when add receiver the key set it.
     * @return String
     */
    String getKey();

}
