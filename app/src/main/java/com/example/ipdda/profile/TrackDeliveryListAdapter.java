package com.example.ipdda.profile;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ipdda.common.CommonConn;
import com.example.ipdda.common.CommonVar;
import com.example.ipdda.databinding.ItemSubRecvBinding;
import com.example.ipdda.home.GoodsVO;
import com.example.ipdda.order.Order_ingVO;
import com.example.ipdda.profile.coupon.CouponVO;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class TrackDeliveryListAdapter  extends RecyclerView.Adapter<TrackDeliveryListAdapter.ViewHolder>{
    ItemSubRecvBinding binding;
    ArrayList<Order_ingVO> list;
    Context context;
    String saveDate;
    public TrackDeliveryListAdapter(ArrayList<Order_ingVO> list, Context context) {
        this.list = list;
        this.context = context;
    }


    @NonNull
    @Override
    public TrackDeliveryListAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from((parent.getContext()));
        binding= ItemSubRecvBinding.inflate(inflater,parent,false);
        return new TrackDeliveryListAdapter.ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull TrackDeliveryListAdapter.ViewHolder h, int i) {
        String[] dateParts =list.get(i).getOrder_date().split(" ")[0].split("-");
        String formattedDate = null;
        if (dateParts.length >= 3) {
            String year = dateParts[0];
            String month = dateParts[1];
            String day = dateParts[2];
            formattedDate = year + "-" + month + "-" + day;
        }
        
        h.binding.btnStar.setVisibility(View.GONE);
        h.binding.btnHart.setVisibility(View.GONE);
        h.binding.insertDate.setText(formattedDate);
        if(i==0){
            saveDate=formattedDate;
            h.binding.insertDate.setVisibility(View.VISIBLE);
        }else{
            if(saveDate.equals(formattedDate)){
                h.binding.insertDate.setVisibility(View.GONE);
            }else{
                saveDate=formattedDate;
                h.binding.insertDate.setVisibility(View.VISIBLE);
            }
        }
        CommonConn conn1 = new CommonConn(context, "goods/goodsboard");
        conn1.addParamMap("goods_no" , list.get(i).getGoods_no());
        conn1.onExcute((isResult1, data1) -> {
            ArrayList<GoodsVO> a = new Gson().fromJson(data1 , new TypeToken<ArrayList<GoodsVO>>(){}.getType());
            Picasso.get()
                    .load(a.get(0).getGoods_main_image())
                    .into(h.binding.imgGoodsList);
            h.binding.goodsName.setText(a.get(0).getGoods_name());
            h.binding.goodsCnt.setVisibility(View.GONE);
            h.binding.choiceNum.setText("수량 "+list.get(i).getOrder_cnt()+"개 | "+list.get(i).getOrder_size());
            h.binding.goodsPrice.setText((a.get(0).getGoods_sale_price()*list.get(i).getOrder_cnt())+"원");
        });

    }


    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        ItemSubRecvBinding binding;

        public ViewHolder(@NonNull ItemSubRecvBinding binding) {
            super(binding.getRoot());
            this.binding=binding;
        }
    }
}
