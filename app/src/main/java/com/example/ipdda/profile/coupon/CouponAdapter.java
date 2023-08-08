package com.example.ipdda.profile.coupon;

import android.app.Dialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.view.Window;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ipdda.R;
import com.example.ipdda.databinding.ActivityCouponInfoBinding;
import com.example.ipdda.databinding.ItemCouponBinding;

import java.util.ArrayList;

public class CouponAdapter extends RecyclerView.Adapter<CouponAdapter.ViewHolder> {

    ItemCouponBinding binding;
    int a;

    ArrayList<CouponVO> list;
    Dialog write_dialog;

    ActivityCouponInfoBinding dialogBinding;
    public CouponAdapter(ArrayList<CouponVO> list, int a) {
        this.list = list;
        this.a = a;
    }

    @NonNull
    @Override
    public CouponAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        binding = ItemCouponBinding.inflate(inflater,parent,false);
        return new CouponAdapter.ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull CouponAdapter.ViewHolder h, int i) {
        
        binding.couponImg.setImageResource(list.get(i).getCoupon_img());
        binding.couponTitle.setText(list.get(i).getCoupon_title());
        if (a == 1) {
            binding.couponDeadlineDate.setTextColor(Color.WHITE);
            binding.couponDeadlineDate.setText("~"+list.get(i).getDeadline_date());
        }else if (a == 2) {
            binding.couponDeadlineDate.setTextColor(Color.GREEN);
            binding.couponDeadlineDate.setText("~"+list.get(i).getDeadline_date()+"/ 사용 완료");
        }else if (a == 3) {
            binding.couponDeadlineDate.setTextColor(Color.RED);
            binding.couponDeadlineDate.setText("~"+list.get(i).getDeadline_date() +"기간 만료");
        }else if (a == 4) {
            binding.couponDeadlineDate.setTextColor(Color.YELLOW);
            binding.couponDeadlineDate.setText("~"+list.get(i).getDeadline_date()+"/ "+list.get(i).getCoupon_status());
        }

            binding.layout.setOnClickListener(v -> {
                write_dialog=new Dialog(v.getContext());
                write_dialog.requestWindowFeature(Window.FEATURE_NO_TITLE); // 타이틀 제거
                write_dialog.setContentView(R.layout.activity_coupon_info);             // xml 레이아웃 파일과 연결
                write_dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                showDialog(list.get(i));
                
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }



    public class ViewHolder extends RecyclerView.ViewHolder {

        ItemCouponBinding binding;


        public ViewHolder(@NonNull ItemCouponBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }
    public void showDialog(CouponVO coupon){
        write_dialog.show(); // 다이얼로그 띄우기
        dialogBinding = ActivityCouponInfoBinding.inflate(write_dialog.getLayoutInflater());
        write_dialog.setContentView(dialogBinding.getRoot());
        //dialogBinding.imvCouponImg.이미지 가져오는 방법
        dialogBinding.tvCouponTitle.setText(coupon.getCoupon_title());
        dialogBinding.tvCouponText.setText(coupon.getCoupon_context());
        dialogBinding.discountAmount.setText(coupon.getDiscount_amount()+"원 할인");
        dialogBinding.couponStatus.setText(coupon.getCoupon_status());
        if (coupon.getCoupon_status().equals("사용완료"))
            dialogBinding.couponStatus.setTextColor(Color.GREEN);
        else if (coupon.getCoupon_status().equals("기간만료")) {
            dialogBinding.couponStatus.setTextColor(Color.RED);
        }else if (coupon.getCoupon_status().equals("취소")||coupon.getCoupon_status().equals("환불")) {
            dialogBinding.couponStatus.setTextColor(Color.YELLOW);
        }


        dialogBinding.btnCancle1.setOnClickListener(v -> {
            write_dialog.dismiss();
        });
        dialogBinding.btnCancle2.setOnClickListener(v -> {
            write_dialog.dismiss();
        });
        

    }
}
