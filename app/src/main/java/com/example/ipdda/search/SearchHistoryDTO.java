package com.example.ipdda.search;

public class SearchHistoryDTO {
    private String txt;

    public SearchHistoryDTO(String txt) {
        this.txt = txt;
    }

    public String getTxt() {
        return txt;
    }

    public void setTxt(String txt) {
        this.txt = txt;
    }
}
