package com.example.ipdda.profile;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.ipdda.R;

public class SubGridAdapter extends BaseAdapter {

    private LayoutInflater inflater;

    public SubGridAdapter(LayoutInflater inflater) {
        this.inflater = inflater;
    }

    @Override
    public int getCount() {
        return 10; // GridView에 보여줄 아이템 개수 (예시로 10개 지정)
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
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;

        if (convertView == null) {
            convertView = inflater.inflate(R.layout.item_sub_grid, parent, false);

            // 레이아웃의 뷰들을 ViewHolder에 연결
            viewHolder = new ViewHolder();
            viewHolder.insertDate = convertView.findViewById(R.id.insertDate);
            viewHolder.imgGoodsList = convertView.findViewById(R.id.imgGoodsList);
            viewHolder.storeName = convertView.findViewById(R.id.storeName);
            viewHolder.goodsName = convertView.findViewById(R.id.goodsName);
            viewHolder.goodsPrice = convertView.findViewById(R.id.goodsPrice);
            viewHolder.choiceNum = convertView.findViewById(R.id.choiceNum);
            viewHolder.goodsCnt = convertView.findViewById(R.id.goodsCnt);

            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        // 각 아이템의 정보를 설정 (여기서는 임의의 예시 데이터 사용)
        viewHolder.insertDate.setText("2000-03-30");
        viewHolder.storeName.setText("가맹점이름");
        viewHolder.goodsName.setText("입다 맨투맨");
        viewHolder.goodsPrice.setText("50,000원");
        viewHolder.choiceNum.setText("수량 1개 | M");
        viewHolder.goodsCnt.setText("2개 남음");

        // 이미지 등의 정보도 설정 가능

        return convertView;
    }

    // ViewHolder 클래스
    private static class ViewHolder {
        TextView insertDate;
        ImageView imgGoodsList;
        TextView storeName;
        TextView goodsName;
        TextView goodsPrice;
        TextView choiceNum;
        TextView goodsCnt;
    }
}
