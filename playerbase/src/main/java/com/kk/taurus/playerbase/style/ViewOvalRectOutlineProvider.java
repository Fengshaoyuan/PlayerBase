package com.kk.taurus.playerbase.style;

import android.annotation.TargetApi;
import android.graphics.Outline;
import android.graphics.Rect;
import android.os.Build;
import android.view.View;
import android.view.ViewOutlineProvider;

import com.kk.taurus.playerbase.utils.RectUtils;

/**
 * Time:2019/11/2
 * Author:RuYIng
 * Description:
 */
@TargetApi(Build.VERSION_CODES.LOLLIPOP)
public class ViewOvalRectOutlineProvider extends ViewOutlineProvider {

    private Rect mRect;

    public ViewOvalRectOutlineProvider(Rect rect){
        this.mRect = rect;
    }

    @Override
    public void getOutline(final View view, final Outline outline) {
        Rect selfRect;
        if(mRect!=null){
            selfRect = mRect;
        }else{
            Rect rect = new Rect();
            view.getGlobalVisibleRect(rect);
            selfRect = RectUtils.getOvalRect(rect);
        }
        outline.setOval(selfRect);
    }

}
