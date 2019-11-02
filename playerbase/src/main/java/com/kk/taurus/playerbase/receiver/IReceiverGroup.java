package com.kk.taurus.playerbase.receiver;

import java.util.Comparator;

/**
 * Time:2019/11/2
 * Author:RuYIng
 * Description:
 *
 * Used to manage receivers
 */
public interface IReceiverGroup {

    /**
     * add a onReceiverGroupChangeListener listen Receiver item change.
     * @param onReceiverGroupChangeListener onReceiverGroupChangeListener
     */
    void addOnReceiverGroupChangeListener(OnReceiverGroupChangeListener onReceiverGroupChangeListener);

    /**
     * When you don't need onReceiverGroupChangeListener to remove it
     * @param onReceiverGroupChangeListener onReceiverGroupChangeListener
     */
    void removeOnReceiverGroupChangeListener(OnReceiverGroupChangeListener onReceiverGroupChangeListener);

    /**
     * add a receiver, you need put a unique key for this receiver.
     * @param key key
     * @param receiver receiver
     */
    void addReceiver(String key, IReceiver receiver);

    /**
     * remove a receiver by key.
     * @param key key
     */
    void removeReceiver(String key);

    /**
     * sort group data
     * @param comparator comparator
     */
    void sort(Comparator<IReceiver> comparator);

    /**
     * loop all receivers
     * @param onLoopListener onLoopListener
     */
    void forEach(OnLoopListener onLoopListener);

    /**
     * loop all receivers by a receiver filter.
     * @param filter filter
     * @param onLoopListener onLoopListener
     */
    void forEach(OnReceiverFilter filter, OnLoopListener onLoopListener);

    /**
     * get receiver by key.
     * @param key key
     * @param <T> <T>
     * @return <T>
     */
    <T extends IReceiver> T getReceiver(String key);

    /**
     * get the ReceiverGroup group value.
     * @return GroupValue
     */
    GroupValue getGroupValue();

    /**
     * clean receivers.
     */
    void clearReceivers();

    interface OnReceiverGroupChangeListener{
        void onReceiverAdd(String key, IReceiver receiver);
        void onReceiverRemove(String key, IReceiver receiver);
    }

    interface OnLoopListener{
        void onEach(IReceiver receiver);
    }

    interface OnReceiverFilter{
        boolean filter(IReceiver receiver);
    }

    interface OnGroupValueUpdateListener{
        String[] filterKeys();
        void onValueUpdate(String key, Object value);
    }

}
