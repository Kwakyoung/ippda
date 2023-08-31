package com.example.ipdda.search;

public class SearchHotDTO {
    private String keyword;
    private int rank;

    public SearchHotDTO(String keyword, int rank) {
        this.keyword = keyword;
        this.rank = rank;
    }

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }
}
