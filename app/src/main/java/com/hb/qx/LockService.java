package com.hb.qx;

import android.annotation.SuppressLint;
import android.app.Notification;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.IBinder;
import android.support.v4.app.NotificationCompat;

import cn.swiftpass.spaycx.R;

public class LockService extends Service {
	private static int b = 0;
	ScreenReceiver receiver = null;

	@Override
	public IBinder onBind(Intent arg0) {
		return null;
	}
	
	@Override
	public void onCreate() {
		init();
		super.onCreate();
	}
	
	public void onDestroy(){
		setStopForeground();
		if (this.receiver != null) {
			unregisterReceiver(this.receiver);
		}
		super.onDestroy();
	}

	public void init() {
		IntentFilter localIntentFilter = new IntentFilter("android.intent.action.SCREEN_ON");
		localIntentFilter.addAction("android.intent.action.SCREEN_OFF");
		localIntentFilter.setPriority(999);
		localIntentFilter.addAction("android.net.wifi.WIFI_STATE_CHANGED");
		localIntentFilter.addAction("android.net.wifi.STATE_CHANGE");
		this.receiver = new ScreenReceiver();
		registerReceiver(this.receiver, localIntentFilter);
	}

	public int onStartCommand(Intent paramIntent, int paramInt1, int paramInt2) {
		startService();
		return 1;
	}

	@SuppressLint("NewApi")
	public void setStopForeground() {
		stopForeground(true);
	}

	@SuppressLint("NewApi")
	public void startService() {
		HbApplication localMainApplication = HbApplication.getInstance();
		if (localMainApplication == null)
			return;
		Intent localIntent = new Intent(getApplicationContext(), SplashActivity.class);
		localIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
		PendingIntent localPendingIntent = PendingIntent.getActivity(this, 0, localIntent, 0);
		Notification notification = new Notification();
		notification.icon = R.mipmap.icon;
		notification.setLatestEventInfo(localMainApplication, getResources().getString(R.string.app_name), getResources().getString(R.string.service_start), localPendingIntent);
		notification.flags = (0x62 | notification.flags);
		NotificationCompat.Builder localBuilder = new NotificationCompat.Builder(localMainApplication);
		localBuilder.setSmallIcon(R.mipmap.icon).setContentTitle(getResources().getString(R.string.app_name)).setContentText(getResources().getString(R.string.service_start)).setWhen(0L);
		startForeground(1, notification);
	}
}
