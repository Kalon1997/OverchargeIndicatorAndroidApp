# OverchargeIndicatorAndroidApp
This is an android api 23 app in which I've use BroadcastReceiver to get the current battery status. 
I've also used AlarmManager and Calendar to get the system time and to set repeative alarm.
The alarm plays the default system ringtone only if the charge is above 97%.
The alarm is set in RFC_WAKEUP mode, so the alarm will ring even if the phoe is in sleep mode.
