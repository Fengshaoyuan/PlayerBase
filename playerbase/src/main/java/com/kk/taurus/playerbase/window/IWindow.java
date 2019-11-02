package com.kk.taurus.playerbase.window;

import android.animation.Animator;
import android.content.Context;
import android.view.View;
import android.view.WindowManager;

/**
 * Time:2019/11/2
 * Author:RuYIng
 * Description:
 *
 * Used for window playback. Automatically add and remove on WindowManager.
 * The default window type is TYPE_TOAST{@link WindowManager.LayoutParams#TYPE_TOAST}.
 * If you need to customize your window parameter, you can make relevant settings
 * through FloatWindowParams {@link FloatWindowParams} in Constructor.
 *
 * see also
 * {@link WindowVideoView#WindowVideoView(Context, FloatWindowParams)}
 * {@link FloatWindow#FloatWindow(Context, View, FloatWindowParams)}
 *
 * The window drag event is handled by default.If you do not need to,
 * you can set drag disable{@link IWindow#setDragEnable(boolean)}.
 *
 * When you don't need it, be sure to close it.
 *
 */
public interface IWindow {

    int MIN_MOVE_DISTANCE = 20;
    int DURATION_ANIMATION = 200;

    /**
     * set window listener to listen window state, show or close.
     * @param onWindowListener onWindowListener
     */
    void setOnWindowListener(OnWindowListener onWindowListener);

    /**
     * update window layout location.
     * @param x x
     * @param y y
     */
    void updateWindowViewLayout(int x, int y);

    /**
     * setting window drag enable. default true.
     * @param dragEnable dragEnable
     */
    void setDragEnable(boolean dragEnable);

    /**
     * show window, default animation show.
     * if you want no animation, you can config it by FloatWindowParams.
     * @return boolean
     */
    boolean show();

    /**
     * show window and play your setting animators.
     * @param items items
     * @return boolean
     */
    boolean show(Animator... items);

    /**
     * close window, default animation on window close, you window style setting will be clear.
     */
    void close();

    /**
     * close window and play your setting animators.
     * @param items items
     */
    void close(Animator... items);

    /**
     * whether or not window show.
     * @return boolean
     */
    boolean isWindowShow();

    interface OnWindowListener{
        void onShow();
        void onClose();
    }

}
