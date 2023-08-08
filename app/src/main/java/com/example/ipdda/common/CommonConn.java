package com.example.ipdda.common;

import android.app.ProgressDialog;
import android.content.Context;
import android.util.Log;

import java.util.HashMap;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CommonConn {
    // Retrofit을 매번 새로 인스턴스화해서 사용하는것은 매우 귀찮음.
    // 재사용이 가능한 구조를 하나 만들고 재사용하면 편함.
    private final String TAG = "CommonConn";
    private HashMap<String , Object> paramMap; // 파라메터 전송용 ID, PW 에 값 받아오기위한 ??
    private Context context;  // 화면위에 토스트, ProgressDialog를 보여주기 위한 용도
    private String mapping ;  // list.cu , login , member 등의 맵핑을 받아오기 위한 것.
    private ProgressDialog dialog; // 모양이 다양하게 커스텀이 가능하니 나중에 바꾸면 된다.

    private KygCallBack callBack; // 옵저버 2번째! (값 받아오기)

    public CommonConn(Context context, String mapping) {
        this.context = context;
        this.mapping = mapping;
        this.paramMap = new HashMap<>();   // hashmap은 초기화만  new로 이전 파라메터를 비워주는
        Log.d("콜백", "onCreate: " );
    }

    public void addParamMap(String key, Object value) {
        if (key == null) {
            Log.e(TAG, "파라메터 key 값이 null이 들어와서 추가 안했음.");
        } else if (value == null) {
            Log.e(TAG, "파라메터 key 값이 null이 들어와서 추가 안했음. <- ? 경우에 따라서 커스텀해야함.");
        } else {
            paramMap.put(key, value);
        }
    }



        // enque ( 전송 실행 전 해야할 코드를 넣어줄 메소드 구현, (ProgressDialog 보이게 처리)
        private void onPreExcute(){
            if(context != null && dialog ==null){
                dialog = new ProgressDialog(context);
                dialog.setProgress(ProgressDialog.STYLE_SPINNER);
                dialog.setTitle("Common");
                dialog.setMessage("로딩중입니다..");
                dialog.setCancelable(false);
                dialog.show();
            }
        }


        // enque가 실제로 되어야 하는 부분. ( 파라메터등을 이용해서 실제로 Spring에 전송한다. )
        public void onExcute(KygCallBack callBack){ // < 옵저버 3번
            this.callBack=callBack;
            onPreExcute();
            Log.d(TAG, "onExcute: "+ this.callBack);
            RetrofitInterface api = new RetrofitClient().getRetrofit().create(RetrofitInterface.class);
            // GET방식인지 POST방식인지를 받아와서 처리도 가능하다.    (현재는 어려우니까 POST로 고정시켜놓기)
            api.PostMethod(mapping , paramMap).enqueue(new Callback<String>() {
                @Override
                public void onResponse(Call<String> call, Response<String> response) {

                    onPostExcute(true,response.body());
                }

                @Override
                public void onFailure(Call<String> call, Throwable t) {
                    Log.d(TAG, "서버와의 연결에 실패 "+t.getMessage());
                    onPostExcute(false, t.getMessage());
                }
            });
        }

        private void onPostExcute(boolean isResult, String data){
            if(dialog != null){
                dialog.dismiss();
            }
            callBack.onResult(isResult, data);
        }



        public interface KygCallBack{
            public void onResult(boolean isResult, String data);

        }

}
