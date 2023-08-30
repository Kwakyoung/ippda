package com.example.ipdda.goodsboard;

import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;

public class GoodsBoardBuyCheckDTO implements Parcelable, Serializable {
     private String check_goods_name,check_goods_size,check_goods_color ;
     //추가함:23.08.29 수봉 -------------
     private int member_no, goods_no;
     private String order_status;
     //----------------------------------

     private int check_goods_cnt, check_goods_price;

    protected GoodsBoardBuyCheckDTO(Parcel in) {
        check_goods_name = in.readString();
        check_goods_size = in.readString();
        check_goods_color = in.readString();
        check_goods_cnt = in.readInt();
        check_goods_price = in.readInt();

        member_no = in.readInt();
        goods_no = in.readInt();
        order_status = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(check_goods_name);
        dest.writeString(check_goods_size);
        dest.writeString(check_goods_color);
        dest.writeInt(check_goods_cnt);
        dest.writeInt(check_goods_price);

        dest.writeInt(member_no);
        dest.writeInt(goods_no);
        dest.writeString(order_status);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<GoodsBoardBuyCheckDTO> CREATOR = new Creator<GoodsBoardBuyCheckDTO>() {
        @Override
        public GoodsBoardBuyCheckDTO createFromParcel(Parcel in) {
            return new GoodsBoardBuyCheckDTO(in);
        }

        @Override
        public GoodsBoardBuyCheckDTO[] newArray(int size) {
            return new GoodsBoardBuyCheckDTO[size];
        }
    };

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
        this.member_no = member_no;
        this.goods_no = goods_no;
        this.order_status = order_status;
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

    public String getOrder_status() {
        return order_status;
    }

    public void setOrder_status(String order_status) {
        this.order_status = order_status;
    }
}

