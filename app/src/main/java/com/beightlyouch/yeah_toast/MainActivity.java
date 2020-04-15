package com.beightlyouch.yeah_toast;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        /*---追加---*/

        // AlarmReceiverを呼び出すインテントを作成
        Intent i = new Intent(getApplicationContext(), AlarmReceiver.class);
        // ブロードキャストを投げるPendingIntentの作成
        PendingIntent sender = PendingIntent.getBroadcast(MainActivity.this, 0, i, 0);

        Calendar calendar = Calendar.getInstance(); // Calendar取得
        calendar.setTimeInMillis(System.currentTimeMillis()); // 現在時刻を取得
        calendar.add(Calendar.SECOND, 2); // 現時刻より2秒後を設定

        // AlramManager取得
        AlarmManager am = (AlarmManager)getSystemService(ALARM_SERVICE);
        // AlramManagerにPendingIntentを登録
        am.set(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(), sender);
    }
}
