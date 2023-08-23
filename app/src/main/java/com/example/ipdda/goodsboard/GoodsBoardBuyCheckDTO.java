package com.example.ipdda.goodsboard;

public class GoodsBoardBuyCheckDTO {
     private String check_goods_name,check_goods_size,check_goods_color;
     private int check_goods_cnt, check_goods_price;

    public String getCheck_goods_name() {
        return check_goods_name;
    }

    public void setCheck_goods_name(String check_goods_name) {
        this.check_goods_name = check_goods_name;
    }

    public String getCheck_goods_size() {
        return check_goods_size;
    }

    public void setCheck_goods_size(String check_goods_size) {
        this.check_goods_size = check_goods_size;
    }

    public String getCheck_goods_color() {
        return check_goods_color;
    }

    public void setCheck_goods_color(String check_goods_color) {
        this.check_goods_color = check_goods_color;
    }

    public int getCheck_goods_cnt() {
        return check_goods_cnt;
    }

    public void setCheck_goods_cnt(int check_goods_cnt) {
        this.check_goods_cnt = check_goods_cnt;
    }

    public int getCheck_goods_price() {
        return check_goods_price;
    }

    public void setCheck_goods_price(int check_goods_price) {
        this.check_goods_price = check_goods_price;
    }

    public GoodsBoardBuyCheckDTO(String check_goods_name, String check_goods_size, String check_goods_color, int check_goods_cnt, int check_goods_price) {
        this.check_goods_name = check_goods_name;
        this.check_goods_size = check_goods_size;
        this.check_goods_color = check_goods_color;
        this.check_goods_cnt = check_goods_cnt;
        this.check_goods_price = check_goods_price;
    }
}

