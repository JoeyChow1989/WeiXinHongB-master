package com.hb.qx;

import android.accessibilityservice.AccessibilityServiceInfo;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.ActivityManager;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.provider.Settings;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.WindowManager;
import android.view.accessibility.AccessibilityManager;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.baidu.mobads.InterstitialAd;
import com.baidu.mobads.InterstitialAdListener;
import com.data.bean.User;

import java.util.ArrayList;
import java.util.List;

@SuppressLint("NewApi")
public class MainActivity extends Activity
{
    private InterstitialAd interAd;
    private GifMovieView gifImage;
    private RelativeLayout yes_layout;
    private LinearLayout no_layout;
    private OpenDialog container;
    private TextView start_but;
    private TextView count, money;
    private HbApplication mApplication;
    private long mExitTime;

    private Button mSVIP_all, mShare, mHelp, mJiLu;

    static String qianshu;
    public static int YANSHI = 0;

    int hb_count = 0;
    double all_moneny = 0;

    private SharedPreferences sp;
    private SharedPreferences.Editor editor;

    List<User> userList;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_ui);
        sp = getSharedPreferences("chatpage", MODE_PRIVATE);
        userList = new ArrayList<>();

        editor = sp.edit();
        editor.putInt("vip", 0);
        // editor.putInt("share1", 1);

        editor.commit();
        gifImage = (GifMovieView) findViewById(R.id.gif_iamge);
        gifImage.setMovieResource(R.drawable.qiang_progress);
        gifImage.setVisibility(View.VISIBLE);


        mSVIP_all = (Button) findViewById(R.id.id_main_vip);
        mSVIP_all.setOnClickListener(new OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                Intent intent = new Intent(MainActivity.this, SeniorActivity.class);
                startActivity(intent);
            }
        });
        mShare = (Button) findViewById(R.id.id_main_share);
        mShare.setOnClickListener(new OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                share();
            }
        });

        mHelp = (Button) findViewById(R.id.id_main_help);
        mHelp.setOnClickListener(new OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                Intent intent = new Intent(MainActivity.this, HelpSettingActivity.class);
                startActivity(intent);
            }
        });

        mJiLu = (Button) findViewById(R.id.id_main_jilu);
        mJiLu.setOnClickListener(new OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                Intent intent = new Intent(MainActivity.this, JiLuActivity.class);
                startActivity(intent);
            }
        });

        count = (TextView) findViewById(R.id.id_main_count);
        money = (TextView) findViewById(R.id.id_main_allmoney);

        // 服务未启动
        no_layout = (LinearLayout) findViewById(R.id.no_commit);
        start_but = (TextView) findViewById(R.id.start_but);
        start_but.setOnClickListener(new OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                onButtonClicked();
            }
        });
        // 服务启动
        yes_layout = (RelativeLayout) findViewById(R.id.yes_commit);
        mApplication = HbApplication.getInstance();
        //handleMIUIStatusBar();
        updateServiceStatus();

        hb_count = HbApplication.getInstance().getUserDB().getUser().size() / 2;
        for (int i = 0; i < HbApplication.getInstance().getUserDB().getUser().size(); i++)
        {
            all_moneny += Double.parseDouble(HbApplication.getInstance().getUserDB().getUser().get(i).getNum().replace("元", "")) / 2;
        }

        count.setText(String.valueOf(hb_count));
        money.setText(String.valueOf(all_moneny));

        if (!isServierRuning())
        {
            // 开启锁
            Intent lockservice = new Intent(this, LockService.class);
            startService(lockservice);
        }
        baidu_ad();
    }

    private void share()
    {
        YqhyDialog yyDialog = new YqhyDialog(this, 0);
        try
        {
            yyDialog.showAtLocation(this.getWindow()
                    .getDecorView(), Gravity.CENTER, 0, 0);
        } catch (Exception e)
        {
            if (yyDialog != null)
            {
                if (yyDialog.isShowing())
                {
                    yyDialog.dismiss();
                }
            }
        }
    }

    @Override
    protected void onStart()
    {
        super.onStart();
        System.out.println("yanshi---------------Main" + YANSHI);
    }

    public void baidu_ad()
    {
        String show_ad_type = mApplication.sp.getString("show_ad_type", "");
        if (show_ad_type.equals("yes"))
        {
            String adPlaceId = "2402145"; // 重要：请填上您的广告位ID，代码位错误会导致无法请求到广告
            interAd = new InterstitialAd(this, adPlaceId);
            interAd.setListener(new InterstitialAdListener()
            {
                @Override
                public void onAdClick(InterstitialAd arg0)
                {
                    Log.i("InterstitialAd", "onAdClick");
                }

                @Override
                public void onAdDismissed()
                {
                    Log.i("InterstitialAd", "onAdDismissed");
                }

                @Override
                public void onAdFailed(String arg0)
                {
                    Log.i("InterstitialAd", "onAdFailed");
                }

                @Override
                public void onAdPresent()
                {
                    Log.i("InterstitialAd", "onAdPresent");
                }

                @Override
                public void onAdReady()
                {
                    Log.i("InterstitialAd", "onAdReady");
                    interAd.showAd(MainActivity.this);
                }

            });

            interAd.loadAd();
            mApplication.editor.putString("show_ad_type", "no");
            mApplication.editor.commit();
        }
    }

    public void setShowProgressbar()
    {
        // 显示进度条
        no_layout.setVisibility(View.GONE);
        yes_layout.setVisibility(View.VISIBLE);

    }

    public void setHideProgressbar()
    {
        // 隐藏进度条
        yes_layout.setVisibility(View.GONE);
        no_layout.setVisibility(View.VISIBLE);

    }


    public void showOpen()
    {
        if (container == null)
        {
            container = new OpenDialog(MainActivity.this);
        }
        if (container != null)
        {
            if (!container.isshow())
            {
                container.show();
            }
        }
    }

    @Override
    protected void onPause()
    {
        super.onPause();
        // 如果本Activity是继承基类BaseActivity的，可注释掉此行。
        com.baidu.mobstat.StatService.onPause(this);
    }

//    public boolean onKeyDown(int keyCode, KeyEvent event)
//    {
//        if (keyCode == KeyEvent.KEYCODE_BACK)
//        {
//            if ((System.currentTimeMillis() - mExitTime) > 2000)
//            {
//                Toast.makeText(this, "再按一次返回桌面", Toast.LENGTH_SHORT).show();
//                mExitTime = System.currentTimeMillis();
//                // interAd.showAd(this);
//            } else
//            {
//                // interAd.destroy();
//                finish();
//            }
//            return true;
//        }
//        return super.onKeyDown(keyCode, event);
//    }

    @Override
    protected void onResume()
    {
        super.onResume();
        // 如果本Activity是继承基类BaseActivity的，可注释掉此行。
        com.baidu.mobstat.StatService.onResume(this);
        updateServiceStatus();
    }

    @Override
    protected void onDestroy()
    {
        getWindow().clearFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
        super.onDestroy();
    }

    @SuppressLint("NewApi")
    private void updateServiceStatus()
    {
        try
        {
            boolean serviceEnabled = false;
            AccessibilityManager accessibilityManager = (AccessibilityManager) getSystemService(Context.ACCESSIBILITY_SERVICE);
            List<AccessibilityServiceInfo> accessibilityServices = accessibilityManager
                    .getEnabledAccessibilityServiceList(AccessibilityServiceInfo.FEEDBACK_GENERIC);
            for (AccessibilityServiceInfo info : accessibilityServices)
            {
                System.out.println("-----serviceEnabled---------:" + info.getId());

                if (info.getId().equals(getPackageName() + "/.QQHongbaoService"))
                {
                    serviceEnabled = true;
                }
            }

            if (serviceEnabled)
            {
                setShowProgressbar();
                // Prevent screen from dimming
                getWindow().addFlags(
                        WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
            } else
            {
                setHideProgressbar();
                showOpen();
                getWindow().clearFlags(
                        WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
            }
        } catch (Exception e)
        {
        }
    }

    public void onButtonClicked()
    {
        Intent mAccessibleIntent = new Intent(Settings.ACTION_ACCESSIBILITY_SETTINGS);
        startActivity(mAccessibleIntent);
    }

    // 判断服务是否运行
    public boolean isServierRuning()
    {
        boolean isRunning = false;
        ActivityManager activityManager = (ActivityManager) getSystemService(Context.ACTIVITY_SERVICE);
        List<ActivityManager.RunningServiceInfo> serviceList = activityManager
                .getRunningServices(Integer.MAX_VALUE);
        if (serviceList == null || serviceList.size() == 0)
        {
            return false;
        }
        for (int i = 0; i < serviceList.size(); i++)
        {
            if (serviceList.get(i).service.getClassName().equals(
                    LockService.class.getName()))
            {
                isRunning = true;
                break;
            }
        }
        return isRunning;
    }
}
