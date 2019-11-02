package com.kk.taurus.playerbase.extension;

/**
 * Time:2019/11/2
 * Author:RuYIng
 * Description:
 */
public abstract class BaseEventProducer implements EventProducer {

    private ReceiverEventSender mReceiverEventSender;

    void attachSender(ReceiverEventSender receiverEventSender){
        this.mReceiverEventSender = receiverEventSender;
    }

    @Override
    public ReceiverEventSender getSender() {
        return mReceiverEventSender;
    }

}
