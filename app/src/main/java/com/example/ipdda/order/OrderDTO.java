package com.example.ipdda.order;

public class OrderDTO {
    String store, goods, option, price;
    int goods_img;

    public OrderDTO(String store, String goods, String option, String price, int goods_img) {
        this.store = store;
        this.goods = goods;
        this.option = option;
        this.price = price;
        this.goods_img = goods_img;
    }

    public String getStore() {
        return store;
    }

    public void setStore(String store) {
        this.store = store;
    }

    public String getGoods() {
        return goods;
    }

    public void setGoods(String goods) {
        this.goods = goods;
    }

    public String getOption() {
        return option;
    }

    public void setOption(String option) {
        this.option = option;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public int getGoods_img() {
        return goods_img;
    }

    public void setGoods_img(int goods_img) {
        this.goods_img = goods_img;
    }
}
