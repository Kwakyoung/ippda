package com.example.ipdda.pay;

import androidx.activity.result.ActivityResultLauncher;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import com.example.ipdda.R;
import com.example.ipdda.databinding.ActivityTossPayBinding;
import com.example.ipdda.goodsboard.GoodsBoardActivity;
import com.tosspayments.paymentsdk.PaymentWidget;
import com.tosspayments.paymentsdk.TossPayments;
import com.tosspayments.paymentsdk.model.Constants;
import com.tosspayments.paymentsdk.model.PaymentCallback;
import com.tosspayments.paymentsdk.model.PaymentWidgetOptions;
import com.tosspayments.paymentsdk.model.TossPaymentResult;
import com.tosspayments.paymentsdk.model.paymentinfo.TossPaymentInfo;
import com.tosspayments.paymentsdk.model.paymentinfo.TossPaymentMethod;
import com.tosspayments.paymentsdk.view.PaymentMethod;

import org.json.JSONObject;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.StandardCharsets;
import java.util.Optional;

import kotlin.Unit;

public class TossPayActivity<K extends TossPaymentInfo> extends AppCompatActivity {


    ActivityTossPayBinding binding;



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityTossPayBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        PaymentWidget paymentWidget = new PaymentWidget(this, "test_ck_D5GePWvyJnrK0W0k6q8gLzN97Eoq", "7CP_K-knksQZ966GZAfhm" , null);

        Intent intent = getIntent();
        int price = intent.getIntExtra("price", 0);

        paymentWidget.renderPaymentMethods(
                binding.paymentMethodWidget,
                new PaymentMethod.Rendering.Amount(price, PaymentMethod.Rendering.Currency.KRW , "KR")
        );

        paymentWidget.renderAgreement(binding.agreementWidget);

        binding.requestPaymentCta.setOnClickListener(v -> {
            try {
                paymentWidget.requestPayment(
                        new PaymentMethod.PaymentInfo("wBWO9RJXO0UYqJMV4er8J", "orderName"),
                        new PaymentCallback() {
                            @Override
                            public void onPaymentSuccess(TossPaymentResult.Success success) {
                                Log.i("success", success.getPaymentKey());
                                Log.i("success", success.getOrderId());
                                Log.i("success", String.valueOf(success.getAmount()));
                            }

                            @Override
                            public void onPaymentFailed(TossPaymentResult.Fail fail) {
                                Log.e("fail", fail.getErrorMessage());
                            }
                        }

                        );
            } catch (IllegalAccessException e) {
                throw new RuntimeException(e);
            }


        });



    }



}