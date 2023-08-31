package com.example.ipdda.goodsboard;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ipdda.databinding.ActivityGoodsboardBuyBinding;
import com.example.ipdda.databinding.ItemGoodsboardRecvBinding;

import java.util.ArrayList;

public class GoodsBoardbuyAdapter extends RecyclerView.Adapter<GoodsBoardbuyAdapter.ViewHolder> {

    ItemGoodsboardRecvBinding binding;

    ArrayList<Goods_optionVO> list;
    ActivityGoodsboardBuyBinding dialogBinding;
    GoodsBoardActivity activity;
    ArrayList<GoodsBoardBuyCheckDTO> getBuyCheck;

    boolean same=false;

    int goods_sale_price;
    public GoodsBoardbuyAdapter(GoodsBoardActivity activity , ArrayList<Goods_optionVO> list, ActivityGoodsboardBuyBinding dialogBinding, ArrayList<GoodsBoardBuyCheckDTO> getBuyCheck, int goods_sale_price) {
        this.list = list;
        this.dialogBinding = dialogBinding;
        this.getBuyCheck=getBuyCheck;
        this.goods_sale_price=goods_sale_price;
        this.activity=activity;
    }

    @NonNull
    @Override
    public GoodsBoardbuyAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        binding = ItemGoodsboardRecvBinding.inflate(inflater,parent,false);
        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder h, int i) {
        h.binding.btnOption.setText(list.get(i).getGoods_color());
        h.binding.btnOption.setOnClickListener(v -> {
            dialogBinding.recvColor.setVisibility(View.GONE);
            if (getBuyCheck != null) {
                for (int j = 0; j < getBuyCheck.size(); j++) {
                    if (getBuyCheck.get(j).getCheck_goods_name().equals(list.get(i).getGoods_color() + "/" + GoodsBoardActivity.select_size)) {
                        // 이미 있는 상품인 경우 수량을 1 증가
                        GoodsBoardBuyCheckDTO existingItem = getBuyCheck.get(j);
                        existingItem.setCheck_goods_cnt(existingItem.getCheck_goods_cnt() + 1);
                        same = true;
                        break; // 이미 있는 경우 처리를 마치고 루프를 종료
                    }
                }
            }
            if (!same){
                getBuyCheck.add(new GoodsBoardBuyCheckDTO(list.get(i).getGoods_color()+ "/" +
                        GoodsBoardActivity.select_size,list.get(i).getGoods_size(),list.get(i).getGoods_color(),
                        1,goods_sale_price));
            }


            dialogBinding.recvBuyCheck.setAdapter(new GoodsBuyCheckAdapter(activity , getBuyCheck));
            dialogBinding.recvBuyCheck.setLayoutManager(new LinearLayoutManager(dialogBinding.getRoot().getContext()));
            activity.calcTotalPrice(getBuyCheck);
            dialogBinding.btnSelectSize.setText("사이즈");
            dialogBinding.btnSelectColor.setText("색상");
            notifyDataSetChanged();
        });

    }
    @Override
    public int getItemCount() {
        return list.size();
    }

    public class  ViewHolder extends RecyclerView.ViewHolder {

        ItemGoodsboardRecvBinding binding;

        public ViewHolder(@NonNull ItemGoodsboardRecvBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }


}
