package com.kk.taurus.playerbase.event;

import android.os.Bundle;
import android.view.MotionEvent;

import com.kk.taurus.playerbase.log.DebugLog;
import com.kk.taurus.playerbase.player.OnTimerUpdateListener;
import com.kk.taurus.playerbase.receiver.IReceiver;
import com.kk.taurus.playerbase.receiver.IReceiverGroup;
import com.kk.taurus.playerbase.touch.OnTouchGestureListener;

/**
 * Time:2019/11/2
 * Author:RuYIng
 * Description:
 *
 * The event dispatcher of the framework is used to
 * distribute playback events, error events and receiver events.
 *
 */

public final class EventDispatcher implements IEventDispatcher{

    private IReceiverGroup mReceiverGroup;

    public EventDispatcher(IReceiverGroup receiverGroup){
        this.mReceiverGroup = receiverGroup;
    }

    /**
     * dispatch play event
     * @param eventCode eventCode
     * @param bundle bundle
     */
    @Override
    public void dispatchPlayEvent(final int eventCode, final Bundle bundle){
        DebugLog.onPlayEventLog(eventCode, bundle);
        if (eventCode == OnPlayerEventListener.PLAYER_EVENT_ON_TIMER_UPDATE) {
            mReceiverGroup.forEach(new IReceiverGroup.OnLoopListener() {
                @Override
                public void onEach(IReceiver receiver) {
                    if (receiver instanceof OnTimerUpdateListener && bundle != null)
                        ((OnTimerUpdateListener) receiver).onTimerUpdate(
                                bundle.getInt(EventKey.INT_ARG1),
                                bundle.getInt(EventKey.INT_ARG2),
                                bundle.getInt(EventKey.INT_ARG3));
                    receiver.onPlayerEvent(eventCode, bundle);
                }
            });
        } else {
            mReceiverGroup.forEach(new IReceiverGroup.OnLoopListener() {
                @Override
                public void onEach(IReceiver receiver) {
                    receiver.onPlayerEvent(eventCode, bundle);
                }
            });
        }
        recycleBundle(bundle);
    }

    /**
     * dispatch error event
     * @param eventCode eventCode
     * @param bundle bundle
     */
    @Override
    public void dispatchErrorEvent(final int eventCode, final Bundle bundle){
        DebugLog.onErrorEventLog(eventCode, bundle);
        mReceiverGroup.forEach(new IReceiverGroup.OnLoopListener() {
            @Override
            public void onEach(IReceiver receiver) {
                receiver.onErrorEvent(eventCode, bundle);
            }
        });
        recycleBundle(bundle);
    }

    @Override
    public void dispatchReceiverEvent(final int eventCode, final Bundle bundle){
        dispatchReceiverEvent(eventCode, bundle, null);
    }

    /**
     * dispatch receivers event
     * @param eventCode eventCode
     * @param bundle bundle
     * @param onReceiverFilter onReceiverFilter
     */
    @Override
    public void dispatchReceiverEvent(final int eventCode, final Bundle bundle, IReceiverGroup.OnReceiverFilter onReceiverFilter) {
        mReceiverGroup.forEach(onReceiverFilter, new IReceiverGroup.OnLoopListener() {
            @Override
            public void onEach(IReceiver receiver) {
                receiver.onReceiverEvent(eventCode, bundle);
            }
        });
        recycleBundle(bundle);
    }

    /**
     * dispatch producer event
     * @param eventCode eventCode
     * @param bundle bundle
     * @param onReceiverFilter onReceiverFilter
     */
    @Override
    public void dispatchProducerEvent(final int eventCode, final Bundle bundle, IReceiverGroup.OnReceiverFilter onReceiverFilter) {
        mReceiverGroup.forEach(onReceiverFilter, new IReceiverGroup.OnLoopListener() {
            @Override
            public void onEach(IReceiver receiver) {
                receiver.onProducerEvent(eventCode, bundle);
            }
        });
        recycleBundle(bundle);
    }

    /**
     * dispatch producer data
     * @param key key
     * @param data data
     * @param onReceiverFilter onReceiverFilter
     */
    @Override
    public void dispatchProducerData(final String key, final Object data, IReceiverGroup.OnReceiverFilter onReceiverFilter) {
        mReceiverGroup.forEach(onReceiverFilter, new IReceiverGroup.OnLoopListener() {
            @Override
            public void onEach(IReceiver receiver) {
                receiver.onProducerData(key, data);
            }
        });
    }

    //-----------------------------------dispatch gesture touch event-----------------------------------

    @Override
    public void dispatchTouchEventOnSingleTabUp(final MotionEvent event) {
        filterImplOnTouchEventListener(new IReceiverGroup.OnLoopListener() {
            @Override
            public void onEach(IReceiver receiver) {
                ((OnTouchGestureListener)receiver).onSingleTapUp(event);
            }
        });
    }

    @Override
    public void dispatchTouchEventOnDoubleTabUp(final MotionEvent event) {
        filterImplOnTouchEventListener(new IReceiverGroup.OnLoopListener() {
            @Override
            public void onEach(IReceiver receiver) {
                ((OnTouchGestureListener)receiver).onDoubleTap(event);
            }
        });
    }

    @Override
    public void dispatchTouchEventOnDown(final MotionEvent event) {
        filterImplOnTouchEventListener(new IReceiverGroup.OnLoopListener() {
            @Override
            public void onEach(IReceiver receiver) {
                ((OnTouchGestureListener)receiver).onDown(event);
            }
        });
    }

    @Override
    public void dispatchTouchEventOnScroll(final MotionEvent e1, final MotionEvent e2,
                                           final float distanceX, final float distanceY) {
        filterImplOnTouchEventListener(new IReceiverGroup.OnLoopListener() {
            @Override
            public void onEach(IReceiver receiver) {
                ((OnTouchGestureListener)receiver).onScroll(e1, e2, distanceX, distanceY);
            }
        });
    }

    @Override
    public void dispatchTouchEventOnEndGesture() {
        filterImplOnTouchEventListener(new IReceiverGroup.OnLoopListener() {
            @Override
            public void onEach(IReceiver receiver) {
                ((OnTouchGestureListener)receiver).onEndGesture();
            }
        });
    }

    private void filterImplOnTouchEventListener(final IReceiverGroup.OnLoopListener onLoopListener){
        mReceiverGroup.forEach(new IReceiverGroup.OnReceiverFilter() {
            @Override
            public boolean filter(IReceiver receiver) {
                return receiver instanceof OnTouchGestureListener;
            }
        }, new IReceiverGroup.OnLoopListener() {
            @Override
            public void onEach(IReceiver receiver) {
                onLoopListener.onEach(receiver);
            }
        });
    }

    private void recycleBundle(Bundle bundle){
        if(bundle!=null)
            bundle.clear();
    }

}
