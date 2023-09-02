package com.example.ipdda.order;

public class Order_ingVO {
    private int order_no, member_no, goods_no, goods_option_no, order_cnt,order_price;
    private String order_date, order_size, order_address, order_type, order_request, order_status, order_color,order_goods_name;


    public String getOrder_goods_name() {
        return order_goods_name;
    }
    public void setOrder_goods_name(String order_goods_name) {
        this.order_goods_name = order_goods_name;
    }
    public int getOrder_price() {
        return order_price;
    }
    public void setOrder_price(int order_price) {
        this.order_price = order_price;
    }
    public int getOrder_no() {
        return order_no;
    }
    public void setOrder_no(int order_no) {
        this.order_no = order_no;
    }
    public int getMember_no() {
        return member_no;
    }
    public void setMember_no(int member_no) {
        this.member_no = member_no;
    }
    public int getGoods_no() {
        return goods_no;
    }
    public void setGoods_no(int goods_no) {
        this.goods_no = goods_no;
    }
    public int getGoods_option_no() {
        return goods_option_no;
    }
    public void setGoods_option_no(int goods_option_no) {
        this.goods_option_no = goods_option_no;
    }
    public int getOrder_cnt() {
        return order_cnt;
    }
    public void setOrder_cnt(int order_cnt) {
        this.order_cnt = order_cnt;
    }
    public String getOrder_date() {
        return order_date;
    }
    public void setOrder_date(String order_date) {
        this.order_date = order_date;
    }
    public String getOrder_size() {
        return order_size;
    }
    public void setOrder_size(String order_size) {
        this.order_size = order_size;
    }
    public String getOrder_address() {
        return order_address;
    }
    public void setOrder_address(String order_address) {
        this.order_address = order_address;
    }
    public String getOrder_type() {
        return order_type;
    }
    public void setOrder_type(String order_type) {
        this.order_type = order_type;
    }
    public String getOrder_request() {
        return order_request;
    }
    public void setOrder_request(String order_request) {
        this.order_request = order_request;
    }
    public String getOrder_status() {
        return order_status;
    }
    public void setOrder_status(String order_status) {
        this.order_status = order_status;
    }
    public String getOrder_color() {
        return order_color;
    }
    public void setOrder_color(String order_color) {
        this.order_color = order_color;
    }


}