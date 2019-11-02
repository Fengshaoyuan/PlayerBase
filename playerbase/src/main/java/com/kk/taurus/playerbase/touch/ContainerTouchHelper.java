package com.kk.taurus.playerbase.touch;

import android.content.Context;
import android.view.GestureDetector;
import android.view.MotionEvent;

import com.kk.taurus.playerbase.touch.BaseGestureCallbackHandler;

/**
 * Time:2019/11/2
 * Author:RuYIng
 * Description:
 */
public class ContainerTouchHelper{

    private GestureDetector mGestureDetector;
    private BaseGestureCallbackHandler mGestureCallback;

    public ContainerTouchHelper(Context context, BaseGestureCallbackHandler gestureCallback){
        this.mGestureCallback = gestureCallback;
        mGestureDetector = new GestureDetector(context,gestureCallback);
    }

    public boolean onTouch(MotionEvent event){
        if (event.getAction() == MotionEvent.ACTION_UP) {
            onEndGesture(event);
        }
        return mGestureDetector.onTouchEvent(event);
    }

    public void setGestureEnable(boolean enable) {
        this.mGestureCallback.setGestureEnable(enable);
    }

    public void setGestureScrollEnable(boolean enable) {
        this.mGestureCallback.setGestureScrollEnable(enable);
    }

    public void onEndGesture(MotionEvent event) {
        mGestureCallback.onEndGesture(event);
    }
}
