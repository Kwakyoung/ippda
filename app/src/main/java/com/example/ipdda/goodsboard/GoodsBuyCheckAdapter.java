    package com.example.ipdda.goodsboard;

    import android.content.Context;
    import android.content.DialogInterface;
    import android.content.Intent;
    import android.graphics.Color;
    import android.view.LayoutInflater;
    import android.view.View;
    import android.view.ViewGroup;

    import androidx.annotation.NonNull;
    import androidx.appcompat.app.AlertDialog;
    import androidx.appcompat.app.AppCompatActivity;
    import androidx.recyclerview.widget.LinearLayoutManager;
    import androidx.recyclerview.widget.RecyclerView;

    import com.example.ipdda.common.CommonVar;
    import com.example.ipdda.databinding.ActivityGoodsboardBuyBinding;
    import com.example.ipdda.databinding.ItemGoodsBoardBuyCheckBinding;
    import com.example.ipdda.databinding.ItemGoodsboardRecvBinding;
    import com.example.ipdda.databinding.ItemSettingRecvBinding;
    import com.example.ipdda.login.LoginActivity;
    import com.example.ipdda.profile.SettingActivity;
    import com.example.ipdda.profile.SettingAdapter;
    import com.example.ipdda.profile.SettingDTO;

    import java.util.ArrayList;

    public class GoodsBuyCheckAdapter extends RecyclerView.Adapter<GoodsBuyCheckAdapter.ViewHolder> {

        ItemGoodsBoardBuyCheckBinding binding;

        ArrayList<GoodsBoardBuyCheckDTO> list;
        GoodsBoardActivity activity ;
        public GoodsBuyCheckAdapter(  GoodsBoardActivity activity ,    ArrayList<GoodsBoardBuyCheckDTO> list) {
            this.list = list;
            this.activity=activity;
        }

        @NonNull
        @Override
        public GoodsBuyCheckAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

            LayoutInflater inflater = LayoutInflater.from(parent.getContext());
            binding = ItemGoodsBoardBuyCheckBinding.inflate(inflater,parent,false);
            return new ViewHolder(binding);
        }

        @Override
        public void onBindViewHolder(@NonNull GoodsBuyCheckAdapter.ViewHolder h, int i) {
            h.binding.tvCheckGoods.setText(list.get(i).getCheck_goods_color() + "/" + list.get(i).getCheck_goods_size());
            h.binding.tvCheckCnt.setText(list.get(i).getCheck_goods_cnt() + "");
            h.binding.tvCheckPrice.setText("" + list.get(i).getCheck_goods_price() * list.get(i).getCheck_goods_cnt());
            h.binding.imgDelete.setOnClickListener(v -> {
                if (list.size() >= i) {
                    list.get(i).setCheck_goods_cnt(list.get(i).getCheck_goods_cnt() - 1);
                    if (list.get(i).getCheck_goods_cnt() == 0) {
                        list.remove(i);

                    }
                    notifyDataSetChanged();
                }
                activity.calcTotalPrice(list);
            });
            h.binding.imgAdd.setOnClickListener(v -> {
                if (list.size() > i) {
                    list.get(i).setCheck_goods_cnt(list.get(i).getCheck_goods_cnt() + 1);
                    notifyDataSetChanged();
                }
                activity.calcTotalPrice(list);
            });
            h.binding.imgCheckCancle.setOnClickListener(v -> {
                if (list.size() > i) {
                    list.remove(i);
                    notifyDataSetChanged();
                    activity.calcTotalPrice(list);
                }
            });
        }


        @Override
        public int getItemCount() {
            return list.size();
        }



        public class ViewHolder extends RecyclerView.ViewHolder {

            ItemGoodsBoardBuyCheckBinding binding;


            public ViewHolder(@NonNull ItemGoodsBoardBuyCheckBinding binding) {
                super(binding.getRoot());
                this.binding = binding;
            }
        }

    }

