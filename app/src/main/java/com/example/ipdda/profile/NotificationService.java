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
                handler.postDelayed(this, 5000); // 5초마다 작업을 실행
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
        NotificationCompat.Builder builder = new NotificationCompat.Builder(getApplicationContext(), NOTIFICATION_CHANNEL_ID);
            builder.setSmallIcon(R.drawable.ippda_logo)
                .setContentTitle("알림 타이틀")
                .setContentText("알림 텍스트")
                .setAutoCancel(true).setPriority(NotificationCompat.PRIORITY_DEFAULT);
        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
                .putExtra("data", "Somevalue to be passed here");

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
