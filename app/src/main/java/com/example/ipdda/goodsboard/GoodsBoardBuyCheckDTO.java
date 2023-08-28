package com.example.ipdda.goodsboard;

import android.os.Parcel;
import android.os.Parcelable;

public class GoodsBoardBuyCheckDTO implements Parcelable {
     private String check_goods_name,check_goods_size,check_goods_color;
     private int check_goods_cnt, check_goods_price;

    protected GoodsBoardBuyCheckDTO(Parcel in) {
        check_goods_name = in.readString();
        check_goods_size = in.readString();
        check_goods_color = in.readString();
        check_goods_cnt = in.readInt();
        check_goods_price = in.readInt();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(check_goods_name);
        dest.writeString(check_goods_size);
        dest.writeString(check_goods_color);
        dest.writeInt(check_goods_cnt);
        dest.writeInt(check_goods_price);
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
    }
}

