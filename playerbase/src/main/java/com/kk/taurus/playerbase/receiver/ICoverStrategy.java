package com.kk.taurus.playerbase.receiver;

import android.view.ViewGroup;

/**
 * Time:2019/11/2
 * Author:RuYIng
 * Description:
 */
public interface ICoverStrategy {

    void addCover(BaseCover cover);
    void removeCover(BaseCover cover);
    void removeAllCovers();
    boolean isContainsCover(BaseCover cover);
    int getCoverCount();
    ViewGroup getContainerView();

}
