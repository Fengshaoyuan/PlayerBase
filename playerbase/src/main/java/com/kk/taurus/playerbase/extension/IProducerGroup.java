package com.kk.taurus.playerbase.extension;

/**
 * Time:2019/11/2
 * Author:RuYIng
 * Description:
 *
 * To manage multiple event producers
 *
 */
public interface IProducerGroup {

    void addEventProducer(BaseEventProducer eventProducer);

    boolean removeEventProducer(BaseEventProducer eventProducer);

    void destroy();

}
