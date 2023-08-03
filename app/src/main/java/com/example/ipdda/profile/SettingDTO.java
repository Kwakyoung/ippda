package com.example.ipdda.profile;

public class SettingDTO {
    private String tv_text;
    private boolean tv_text_toggle;

    public String getTv_text() {
        return tv_text;
    }

    public void setTv_text(String tv_text) {
        this.tv_text = tv_text;
    }

    public boolean isTv_text_toggle() {
        return tv_text_toggle;
    }

    public void setTv_text_toggle(boolean tv_text_toggle) {
        this.tv_text_toggle = tv_text_toggle;
    }

    public SettingDTO(String tv_text, boolean tv_text_toggle) {
        this.tv_text = tv_text;
        this.tv_text_toggle = tv_text_toggle;
    }
}
