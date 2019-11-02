package com.kk.taurus.avplayer.bean;

import java.util.ArrayList;
import java.util.List;

public class SettingItem {
    public static final int CODE_ASPECT_16_9 = 300;
    public static final int CODE_ASPECT_4_3 = 301;
    public static final int CODE_ASPECT_FILL = 302;
    public static final int CODE_ASPECT_MATCH = 303;
    public static final int CODE_ASPECT_FIT = 304;
    public static final int CODE_ASPECT_ORIGIN = 305;

    public static final int CODE_PLAYER_MEDIA_PLAYER = 400;
    public static final int CODE_PLAYER_IJK_PLAYER = 401;
    public static final int CODE_PLAYER_EXO_PLAYER = 402;

    public static final int CODE_SPEED_0_5 = 500;
    public static final int CODE_SPEED_1 = 502;
    public static final int CODE_SPEED_2 = 501;

    public static final int CODE_VOLUME_SILENT = 600;
    public static final int CODE_VOLUME_RESET = 601;

    private String itemText;
    private int code;

    public SettingItem(String itemText, int code) {
        this.itemText = itemText;
        this.code = code;
    }

    public String getItemText() {
        return itemText;
    }

    public void setItemText(String itemText) {
        this.itemText = itemText;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public static List<SettingItem> initSettingList(){
        List<SettingItem> items = new ArrayList<>();
        items.add(new SettingItem("画面16:9",CODE_ASPECT_16_9));
        items.add(new SettingItem("画面4:3",CODE_ASPECT_4_3));
        items.add(new SettingItem("画面FILL",CODE_ASPECT_FILL));
        items.add(new SettingItem("画面MATCH",CODE_ASPECT_MATCH));
        items.add(new SettingItem("画面FIT",CODE_ASPECT_FIT));
        items.add(new SettingItem("画面ORIGIN",CODE_ASPECT_ORIGIN));

        items.add(new SettingItem("使用MediaPlayer",CODE_PLAYER_MEDIA_PLAYER));
        items.add(new SettingItem("使用IjkPlayer",CODE_PLAYER_IJK_PLAYER));
        items.add(new SettingItem("使用ExoPlayer",CODE_PLAYER_EXO_PLAYER));

        items.add(new SettingItem("0.5倍速播放",CODE_SPEED_0_5));
        items.add(new SettingItem("2倍速播放",CODE_SPEED_2));
        items.add(new SettingItem("1倍速播放",CODE_SPEED_1));

        items.add(new SettingItem("静音",CODE_VOLUME_SILENT));
        items.add(new SettingItem("恢复声音",CODE_VOLUME_RESET));

        return items;
    }

}
