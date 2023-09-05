package com.example.ipdda.like;

import android.content.Context;
import android.content.Intent;
import android.media.Image;
import android.renderscript.ScriptGroup;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ipdda.R;
import com.example.ipdda.common.CommonConn;
import com.example.ipdda.common.CommonVar;
import com.example.ipdda.databinding.FragmentLikeBinding;
import com.example.ipdda.databinding.ItemLikeGridBinding;
import com.example.ipdda.goodsboard.GoodsBoardActivity;
import com.example.ipdda.home.GoodsVO;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicReference;

public class LikeAdapter extends BaseAdapter {


    LayoutInflater inflater;
    ArrayList<GoodsVO> list ;
    Context context;
    FragmentLikeBinding binding;

    public LikeAdapter(LayoutInflater inflater, ArrayList<GoodsVO> list, Context context, FragmentLikeBinding binding) {
        this.inflater = inflater;
        this.list = list;
        this.context=context;
        this.binding=binding;
    }



    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View v, ViewGroup parent) {
        v = inflater.inflate(R.layout.item_like_grid, parent , false);
        ImageView imgv_img, imgv_like;
        TextView tv_shop, tv_price;

        imgv_img = v.findViewById(R.id.imgv_img);
        Picasso.get()
                .load(list.get(position).getGoods_main_image())
                .into(imgv_img);

        imgv_like = v.findViewById(R.id.imgv_like);

        tv_shop = v.findViewById(R.id.tv_shop);
        tv_shop.setText(list.get(position).getStore_name());

        tv_price = v.findViewById(R.id.tv_price);
        tv_price.setText(list.get(position).getGoods_price()+"");
        imgv_img.setOnClickListener(v1 -> {
            Intent intent = new Intent(context, GoodsBoardActivity.class);
            intent.putExtra("goods_no",  list.get(position).getGoods_no());

            context.startActivity(intent);
        });

        View finalV = v;
        imgv_like.setOnClickListener(v1 -> {

                CommonConn conn2 = new CommonConn(parent.getContext(), "goods_like/delete");
                conn2.addParamMap("goods_no", list.get(position).getGoods_no());
                conn2.addParamMap("member_no", CommonVar.loginInfo.getMember_no());
                conn2.onExcute((isResult, data) -> {
                    if (isResult) {
                        // 아이템을 삭제하고 어댑터에게 알림
                        list.remove(position);
                        binding.tvLikeCount.setText(list.size()+"");
                        notifyDataSetChanged(); // 어댑터에게 데이터셋이 변경되었음을 알려줌
                    } else {
                        // 삭제 실패 시 사용자에게 알림
                        Toast.makeText(context, "삭제 실패", Toast.LENGTH_SHORT).show();
                    }
                });

        });
        return v;
    }

}
