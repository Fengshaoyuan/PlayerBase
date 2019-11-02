package com.kk.taurus.playerbase.touch;

import android.view.MotionEvent;

/**
 * Time:2019/11/2
 * Author:RuYIng
 * Description:
 */
public interface OnTouchGestureListener {
    /**
     * on gesture single tap up
     * @param event event
     */
    void onSingleTapUp(MotionEvent event);

    /**
     * on gesture double tap
     * @param event event
     */
    void onDoubleTap(MotionEvent event);

    void onDown(MotionEvent event);

    /**
     * on scroll
     * @param e1 e1
     * @param e2 e2
     * @param distanceX distanceX
     * @param distanceY distanceY
     */
    void onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY);

    void onEndGesture();
}
