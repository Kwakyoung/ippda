package com.example.ipdda.common;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.example.ipdda.R;

import java.util.HashMap;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PayConn {

    private String type;
    private final String TAG ="PayConn";
    private HashMap<String , Object> parammap = new HashMap<>();
    private Context context;
    private String authorization;

    private ProgressDialog dialog;
    private CommonConn.KsbCallBack callBack;

    public PayConn(Context context, String authorization, String type) {
        this.context = context;
        this.authorization = authorization;
        this.type = type;
    }

    public void addParamMap(String key , Object value){
        if(key == null){
            Log.e(TAG, "파라메터 key값이 null이 들어와서 추가 안했음." );
        } else if (value == null) {
            Log.e(TAG, "파라메터 value값이 null이 들어와서 추가 안했음.<-?경우에 따라서 커스텀해야함." );
        }else {
            parammap.put(key,value);
        }
    }

    private void onPreExcute(){
        if(context != null && dialog == null){
            dialog = new ProgressDialog(context);
            dialog.setProgress(ProgressDialog.STYLE_SPINNER);
            dialog.setTitle("Common");
            dialog.setMessage("로딩중입니다.");
            dialog.setCancelable(false);
            dialog.show();
        }
    }

    public void onExcute(CommonConn.KsbCallBack callBack){
        onPreExcute();
        this.callBack = callBack;
        RetrofitInterface api = new RetrofitClient().getKakao().create(RetrofitInterface.class);
        api.KakaoMethod(authorization , type , parammap).enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {
                Log.d(TAG, "onResponse . onResponse: " + response.body());
                onPostExcute(true , response.body());
            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {
                Log.d(TAG, "onFailure . onFailure: " + t.getMessage());
                Toast.makeText(context, "서버와의 연결에 실패했습니다.(개발자의 문의해라)", Toast.LENGTH_SHORT).show();
                onPostExcute(false , null);
            }
        });
    }

    private void onPostExcute(boolean isResult , String data){
        if(dialog != null){
            dialog.dismiss();
        }
        callBack.onResult(isResult, data);
    }

    public interface KsbCallBack{
        public void onResult(boolean isResult , String data);

    }


}
