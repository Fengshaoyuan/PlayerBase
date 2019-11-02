package com.kk.taurus.playerbase.style;

import android.graphics.Rect;

/**
 * Time:2019/11/2
 * Author:RuYIng
 * Description:
 */
public interface IStyleSetter {

    void setRoundRectShape(float radius);

    void setRoundRectShape(Rect rect, float radius);

    void setOvalRectShape();

    void setOvalRectShape(Rect rect);

    void clearShapeStyle();

    void setElevationShadow(float elevation);

    /**
     * must setting a color when set shadow, not transparent.
     * @param backgroundColor backgroundColor
     * @param elevation elevation
     */
    void setElevationShadow(int backgroundColor, float elevation);

}
