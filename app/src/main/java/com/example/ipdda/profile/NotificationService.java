package com.example.ipdda.profile;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ServiceInfo;
import android.graphics.Color;
import android.os.Build;
import android.os.Handler;
import android.os.IBinder;
import android.util.Log;

import androidx.core.app.NotificationCompat;

import com.example.ipdda.MainActivity;
import com.example.ipdda.R;

import java.util.Calendar;

public class NotificationService extends Service {
    private static final String TAG = "BackgroundService";
    private Handler handler;
    private Runnable runnable;

    private static final String NOTIFICATION_CHANNEL_ID = "CHANNEL_ID_NOTIFICATION";

    @Override
    public void onCreate() {
        super.onCreate();
        Log.d(TAG, "Background service onCreate");
        handler = new Handler();
        runnable = new Runnable() {
            @Override
            public void run() {
                makeNotification();
                Log.d(TAG, "Background task is running.");
                handler.postDelayed(this, 24 * 60 * 60 * 1000); // 하루마다 작업을 실행 (24시간 * 60분 * 60초 * 1000밀리초)
            }
        };
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
            startForeground(1, createNotification(), ServiceInfo.FOREGROUND_SERVICE_TYPE_NONE); // 알림 ID 1 사용
        }
        handler.post(runnable);
        return START_NOT_STICKY;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        handler.removeCallbacks(runnable);
        stopForeground(true); // Foreground 서비스 중지
        stopSelf(); // 서비스 중지
    }

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    public void makeNotification() {
        // 현재 시간 정보 가져오기
        Calendar calendar = Calendar.getInstance();
        int hour = calendar.get(Calendar.HOUR_OF_DAY);

        String notificationTitle = "";
        String notificationText = "";

        // 시간에 따라 알림 제목과 텍스트 설정
        if (hour ==9) {
            notificationTitle = "아침 알림";
            notificationText = "지금 접속하면 새로운 상품을 볼 수 있습니다.";
        } else if (hour ==15) {
            notificationTitle = "점심 알림";
            notificationText = "지금 접속하면 새로운 상품을 볼 수 있습니다.";
        } else if(hour == 21){
            notificationTitle = "저녁 알림";
            notificationText = "지금 접속하면 새로운 상품을 볼 수 있습니다.";
        }

        NotificationCompat.Builder builder = new NotificationCompat.Builder(getApplicationContext(), NOTIFICATION_CHANNEL_ID);
        builder.setSmallIcon(R.drawable.ippda_logo)
                .setContentTitle(notificationTitle)
                .setContentText(notificationText)
                .setAutoCancel(true).setPriority(NotificationCompat.PRIORITY_DEFAULT);

        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
                .putExtra("data", "Some value to be passed here");

        PendingIntent pendingIntent = PendingIntent.getActivity(getApplicationContext(), 0, intent, PendingIntent.FLAG_MUTABLE);
        builder.setContentIntent(pendingIntent);

        NotificationManager notificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            NotificationChannel notificationChannel = notificationManager.getNotificationChannel(NOTIFICATION_CHANNEL_ID);
            if (notificationChannel == null) {
                int importance = NotificationManager.IMPORTANCE_HIGH;
                notificationChannel = new NotificationChannel(NOTIFICATION_CHANNEL_ID, "Some description", importance);
                notificationChannel.setLightColor(Color.GREEN);
                notificationChannel.enableVibration(true);
                notificationManager.createNotificationChannel(notificationChannel);
            }
        }

        notificationManager.notify(0, builder.build());
    }

    public Notification createNotification() {
        NotificationCompat.Builder builder = new NotificationCompat.Builder(this, NOTIFICATION_CHANNEL_ID);
        builder.setSmallIcon(R.drawable.ic_notifications)
                .setContentTitle("Ippda Service")
                .setContentText("Ippda service is running...")
                .setAutoCancel(true).setPriority(NotificationCompat.PRIORITY_MIN);

        Intent intent = new Intent(this, MainActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
                .putExtra("data", "Some value to be passed here");

        PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, intent, PendingIntent.FLAG_MUTABLE | PendingIntent.FLAG_ONE_SHOT);
        builder.setContentIntent(pendingIntent);

        return builder.build();
    }
}
