package com.example.kalon.overchargeindicator;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.BatteryManager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {
    private TextView chargeText;


   private BroadcastReceiver br = new BroadcastReceiver() {

        @Override
        public void onReceive(Context context, Intent intent) {
           int level=intent.getIntExtra(BatteryManager.EXTRA_LEVEL,0);
            chargeText.setText(String.valueOf(level) + "%");


            IntentFilter ifilter = new IntentFilter(Intent.ACTION_BATTERY_CHANGED);
            Intent batteryStatus = context.registerReceiver(null, ifilter);
            int status = batteryStatus.getIntExtra(BatteryManager.EXTRA_STATUS, -1);
          //  boolean isCharging = status == BatteryManager.BATTERY_STATUS_CHARGING ||
                   // status == BatteryManager.BATTERY_STATUS_FULL;
        }
    };




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);




       chargeText=(TextView)this.findViewById(R.id.textview);
        this.registerReceiver(this.br, new IntentFilter(Intent.ACTION_BATTERY_CHANGED));





        Calendar cal=Calendar.getInstance();

        int year=Calendar.getInstance().get(Calendar.YEAR);
        int month=Calendar.getInstance().get(Calendar.MONTH);
        int day_of_month=Calendar.getInstance().get(Calendar.DAY_OF_MONTH);
        int hr=Calendar.getInstance().get(Calendar.HOUR_OF_DAY);
        int min=Calendar.getInstance().get(Calendar.MINUTE);
        cal.set(Calendar.MONTH,month);
        cal.set(Calendar.YEAR,year);
        cal.set(Calendar.DAY_OF_MONTH,day_of_month);
        cal.set(Calendar.HOUR_OF_DAY,20);
        cal.set(Calendar.MINUTE,27);

        Intent intent = new Intent(this, Aclass.class);
        PendingIntent pendingIntent = PendingIntent.getBroadcast(this.getApplicationContext(),
                1253, intent, PendingIntent.FLAG_UPDATE_CURRENT|  Intent.FILL_IN_DATA);



        AlarmManager alarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);
        //String value = chargeText.getText().toString();


        //int desiredValue = Integer.parseInt(value);

        // alarmManager.set(AlarmManager.RTC_WAKEUP, cal.getTimeInMillis(), pendingIntent);

            alarmManager.setRepeating(AlarmManager.RTC_WAKEUP, cal.getTimeInMillis(), AlarmManager.INTERVAL_DAY, pendingIntent);

        Toast.makeText(this, "Alarm is set", Toast.LENGTH_SHORT).show();















        //Intent intent = new Intent(this, Mote.class);
        //PendingIntent pendingIntent = PendingIntent.getBroadcast(this.getApplicationContext(), 1253, intent, PendingIntent.FLAG_UPDATE_CURRENT|  Intent.FILL_IN_DATA);

  //      AlarmManager alarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);

//        alarmManager.set(AlarmManager.RTC_WAKEUP, cal.getTimeInMillis(),pendingIntent );
       // Toast.makeText(this, "Alarm worked.", Toast.LENGTH_LONG).show();




        //IntentFilter ifilter = new IntentFilter(Intent.ACTION_BATTERY_CHANGED);
        //Intent batteryStatus = context.registerReceiver(null, ifilter);

        //int status = batteryStatus.getIntExtra(BatteryManager.EXTRA_STATUS, -1);
      //  isCharging = status == BatteryManager.BATTERY_STATUS_CHARGING ||
               // status == BatteryManager.BATTERY_STATUS_FULL;

    }
}


