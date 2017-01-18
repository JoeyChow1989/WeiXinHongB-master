package com.hb.qx;

import android.accessibilityservice.AccessibilityServiceInfo;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.WindowManager;
import android.view.accessibility.AccessibilityManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.Toast;
import android.widget.ToggleButton;


import java.util.List;

import cn.swiftpass.spaycx.R;

public class SeniorActivity extends Activity
{
    private LinearLayout SvipAll, SaoLei, NiuNiu, WeiHao, Shouqi, Dabao, DuoBi, JiaSu, Ganrao, PingXi, CloseAD, AutoThanks, Shenmi, StartService, AutoBackChatPage, VoiseRemaid, NoAuto, MyOwnBao;
    private ToggleButton mSVIPall, mSaoLei, mNiuNiu, mWeiHao, mShouqi, mDabao, mDuoBi, mJiaSu, mGanrao, mPingXi, mCloseAD, mAutoThanks, mShenmi;
    private ToggleButton mStartService, mAutoBackChatPage, mVoiseRemaid, mNoAuto, mMyOwnBao;
    private ImageView mBack;
    private Spinner leizhi, niu, weishu;
    private ArrayAdapter arrayAdapter1, arrayAdapter2, arrayAdapter3;

    private FrameLayout mFrameLayout;
    private SharedPreferences sp;
    private SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        setContentView(R.layout.senior_activity);
        init();
        initEvent();
    }

    private void initEvent()
    {
        // TODO Auto-generated method stub
        mBack.setOnClickListener(new OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                // TODO Auto-generated method stub
                SeniorActivity.this.finish();
            }
        });

        mFrameLayout.setOnClickListener(new OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                showMyDialog();
            }
        });

        SvipAll.setOnClickListener(new OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                if (sp.getInt("vip_1", 0) == 0)
                {
                    shareSvip("永久开启SVIP全部功能", "68.8", "1");
                } else
                {
                    if (mSVIPall.isChecked() == true)
                    {
                        Toast.makeText(SeniorActivity.this, "-----不能关闭-----", Toast.LENGTH_SHORT);
                    } else
                    {
                        mSVIPall.setChecked(true);
                        editor.putInt("svipall", 1);
                        mSaoLei.setChecked(true);
                        editor.putInt("saolei", 1);
                        editor.putInt("vip_2", 1);
                        mNiuNiu.setChecked(true);
                        editor.putInt("niuniu", 1);
                        editor.putInt("vip_3", 1);
                        mWeiHao.setChecked(true);
                        editor.putInt("weihao", 1);
                        editor.putInt("vip_4", 1);
                        mShouqi.setChecked(true);
                        editor.putInt("shouqi", 1);
                        editor.putInt("vip_5", 1);
                        mDabao.setChecked(true);
                        editor.putInt("dabao", 1);
                        editor.putInt("vip_6", 1);
                        mDuoBi.setChecked(true);
                        editor.putInt("duobi", 1);
                        editor.putInt("vip_7", 1);
                        mJiaSu.setChecked(true);
                        editor.putInt("jiasu", 1);
                        editor.putInt("vip_8", 1);
                        mGanrao.setChecked(true);
                        editor.putInt("ganrao", 1);
                        editor.putInt("vip_9", 1);
                        mPingXi.setChecked(true);
                        editor.putInt("xiping", 1);
                        editor.putInt("vip_10", 1);
                        mCloseAD.setChecked(true);
                        editor.putInt("closead", 1);
                        editor.putInt("vip_11", 1);
                        mAutoThanks.setChecked(true);
                        editor.putInt("autothanks", 1);
                        editor.putInt("vip_12", 1);
                    }
                    editor.commit();
                }
            }
        });

        SaoLei.setOnClickListener(new OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                if (sp.getInt("vip_2", 0) == 0)
                {
                    shareSvip("扫雷埋雷专区", "56.8", "2");
                } else
                {
                    if (mSaoLei.isChecked() == true)
                    {
                        mSaoLei.setChecked(false);
                        editor.putInt("saolei", 0);
                    } else
                    {
                        mSaoLei.setChecked(true);
                        editor.putInt("saolei", 1);
                    }
                    editor.commit();
                }
            }
        });

        NiuNiu.setOnClickListener(new OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                if (sp.getInt("vip_3", 0) == 0)
                {
                    shareSvip("牛牛抢红包", "46.8", "3");
                } else
                {
                    if (mNiuNiu.isChecked() == true)
                    {
                        mNiuNiu.setChecked(false);
                        editor.putInt("niuniu", 0);
                    } else
                    {
                        mNiuNiu.setChecked(true);
                        editor.putInt("niuniu", 1);
                    }
                    editor.commit();
                }
            }
        });

        WeiHao.setOnClickListener(new OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                if (sp.getInt("vip_4", 0) == 0)
                {
                    shareSvip("提高尾号控制概率", "45.9", "4");
                } else
                {
                    if (mWeiHao.isChecked() == true)
                    {
                        mWeiHao.setChecked(false);
                        editor.putInt("weihao", 0);
                    } else
                    {
                        mWeiHao.setChecked(true);
                        editor.putInt("weihao", 1);
                    }
                    editor.commit();
                }
            }
        });

        Shouqi.setOnClickListener(new OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                if (sp.getInt("vip_5", 0) == 0)
                {
                    shareSvip("提高手气最佳概率", "43.8", "5");
                } else
                {
                    if (mShouqi.isChecked() == true)
                    {
                        mShouqi.setChecked(false);
                        editor.putInt("shouqi", 0);
                    } else
                    {
                        mShouqi.setChecked(true);
                        editor.putInt("shouqi", 1);
                    }
                    editor.commit();
                }
            }
        });

        Dabao.setOnClickListener(new OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                if (sp.getInt("vip_6", 0) == 0)
                {
                    shareSvip("提高抢大包概率", "39.8", "6");
                } else
                {
                    if (mDabao.isChecked() == true)
                    {
                        mDabao.setChecked(false);
                        editor.putInt("dabao", 0);
                    } else
                    {
                        mDabao.setChecked(true);
                        editor.putInt("dabao", 1);
                    }
                    editor.commit();
                }
            }
        });


        DuoBi.setOnClickListener(new OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                if (sp.getInt("vip_7", 0) == 0)
                {
                    shareSvip("最高概率躲避最小包", "38.8", "7");
                } else
                {
                    if (mDuoBi.isChecked() == true)
                    {
                        mDuoBi.setChecked(false);
                        editor.putInt("duobi", 0);
                    } else
                    {
                        mDuoBi.setChecked(true);
                        editor.putInt("duobi", 1);
                    }
                    editor.commit();
                }
            }
        });


        JiaSu.setOnClickListener(new OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                if (sp.getInt("vip_8", 0) == 0)
                {
                    shareSvip("抢红包加速", "33.8", "8");
                } else
                {
                    if (mJiaSu.isChecked() == true)
                    {
                        mJiaSu.setChecked(false);
                        editor.putInt("jiasu", 0);
                    } else
                    {
                        mJiaSu.setChecked(true);
                        editor.putInt("jiasu", 1);
                    }
                    editor.commit();
                }
            }
        });


        Ganrao.setOnClickListener(new OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                if (sp.getInt("vip_9", 0) == 0)
                {
                    shareSvip("智能干扰竞争者", "28.8", "9");
                } else
                {
                    if (mGanrao.isChecked() == true)
                    {
                        mGanrao.setChecked(false);
                        editor.putInt("ganrao", 0);
                    } else
                    {
                        mGanrao.setChecked(true);
                        editor.putInt("ganrao", 1);
                    }
                    editor.commit();
                }
            }
        });

        PingXi.setOnClickListener(new OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                if (sp.getInt("vip_10", 0) == 0)
                {
                    shareSvip("息屏抢红包", "19.9", "10");
                } else
                {
                    if (mPingXi.isChecked() == true)
                    {
                        mPingXi.setChecked(false);
                        editor.putInt("xiping", 0);
                    } else
                    {
                        mPingXi.setChecked(true);
                        editor.putInt("xiping", 1);
                    }
                    editor.commit();
                }
            }
        });


        CloseAD.setOnClickListener(new OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                if (sp.getInt("vip_11", 0) == 0)
                {
                    shareSvip("关闭广告", "18.8", "11");
                } else
                {
                    if (mCloseAD.isChecked() == true)
                    {
                        mCloseAD.setChecked(false);
                        editor.putInt("closead", 0);

                    } else
                    {
                        mCloseAD.setChecked(true);
                        editor.putInt("closead", 1);
                    }
                    editor.commit();
                }
            }
        });

        AutoThanks.setOnClickListener(new OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                if (sp.getInt("vip_12", 0) == 0)
                {
                    shareSvip("抢到红包自动答谢", "16.8", "12");
                } else
                {
                    if (mAutoThanks.isChecked() == true)
                    {
                        mAutoThanks.setChecked(false);
                        editor.putInt("autothanks", 0);
                        editor.putInt("huifu", 0);

                    } else
                    {
                        mAutoThanks.setChecked(true);
                        editor.putInt("closead", 1);
                        editor.putInt("huifu", 1);
                    }
                    editor.commit();
                }
            }
        });

        Shenmi.setOnClickListener(new OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                if (sp.getInt("vip_13", 0) == 0)
                {
                    shareSvip("神秘功能", "168.8", "13");
                } else
                {
                    if (mShenmi.isChecked() == true)
                    {
                        mShenmi.setChecked(false);
                        editor.putInt("shenmi", 0);
                    } else
                    {
                        mShenmi.setChecked(true);
                        editor.putInt("shenmi", 1);
                    }
                    editor.commit();
                }
            }
        });

        StartService.setOnClickListener(new OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                if (mStartService.isChecked())
                {
                    mStartService.setChecked(false);
                    editor.putInt("startservice", 0);
                } else
                {
                    mStartService.setChecked(true);
                    editor.putInt("startservice", 1);
                }
                editor.commit();
            }
        });

        AutoBackChatPage.setOnClickListener(new OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                if (mAutoBackChatPage.isChecked() == true)
                {
                    mAutoBackChatPage.setChecked(false);
                    editor.putInt("chatpage", 0);

                } else
                {
                    mAutoBackChatPage.setChecked(true);
                    editor.putInt("chatpage", 1);
                }
                editor.commit();
            }
        });

        VoiseRemaid.setOnClickListener(new OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                if (mVoiseRemaid.isChecked() == true)
                {
                    mVoiseRemaid.setChecked(false);
                    editor.putInt("voisere", 0);

                } else
                {
                    mVoiseRemaid.setChecked(true);
                    editor.putInt("voisere", 1);
                }
                editor.commit();
            }
        });

        NoAuto.setOnClickListener(new OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                if (mNoAuto.isChecked() == true)
                {
                    mNoAuto.setChecked(false);
                    editor.putInt("buzidong", 0);

                } else
                {
                    mNoAuto.setChecked(true);
                    editor.putInt("buzidong", 1);
                }
                editor.commit();
            }
        });

        MyOwnBao.setOnClickListener(new OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                if (mMyOwnBao.isChecked() == true)
                {
                    mMyOwnBao.setChecked(false);
                    editor.putInt("myown", 0);

                } else
                {
                    mMyOwnBao.setChecked(true);
                    editor.putInt("myown", 1);
                }
                editor.commit();
            }
        });
    }

    private void showMyDialog()
    {
        YqhyDialog2 yyDialog = new YqhyDialog2(SeniorActivity.this);
        try
        {
            yyDialog.showAtLocation(SeniorActivity.this.getWindow()
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
        updateServiceStatus();
        System.out.println("----------onStart()-------------");
    }

    @Override
    protected void onPause()
    {
        super.onPause();
        // 如果本Activity是继承基类BaseActivity的，可注释掉此行。
        com.baidu.mobstat.StatService.onPause(this);
    }

    @Override
    protected void onResume()
    {
        super.onResume();
        // 如果本Activity是继承基类BaseActivity的，可注释掉此行。
        com.baidu.mobstat.StatService.onResume(this);

        leizhi.setSelection(sp.getInt("leizhi", 0), true);
        niu.setSelection(sp.getInt("niu", 0), true);
        weishu.setSelection(sp.getInt("weishu", 0), true);

        if (sp.getInt("vip_1", 0) == 1)
        {
            mSVIPall.setChecked(true);
            editor.putInt("svipall", 1);
            editor.putInt("vip_1", 1);
            mSaoLei.setChecked(true);
            editor.putInt("saolei", 1);
            editor.putInt("vip_2", 1);
            mNiuNiu.setChecked(true);
            editor.putInt("niuniu", 1);
            editor.putInt("vip_3", 1);
            mWeiHao.setChecked(true);
            editor.putInt("weihao", 1);
            editor.putInt("vip_4", 1);
            mShouqi.setChecked(true);
            editor.putInt("shouqi", 1);
            editor.putInt("vip_5", 1);
            mDabao.setChecked(true);
            editor.putInt("dabao", 1);
            editor.putInt("vip_6", 1);
            mDuoBi.setChecked(true);
            editor.putInt("duobi", 1);
            editor.putInt("vip_7", 1);
            mJiaSu.setChecked(true);
            editor.putInt("jiasu", 1);
            editor.putInt("vip_8", 1);
            mGanrao.setChecked(true);
            editor.putInt("ganrao", 1);
            editor.putInt("vip_9", 1);
            mPingXi.setChecked(true);
            editor.putInt("xiping", 1);
            editor.putInt("vip_10", 1);
            mCloseAD.setChecked(true);
            editor.putInt("closead", 1);
            editor.putInt("vip_11", 1);
            mAutoThanks.setChecked(true);
            editor.putInt("autothanks", 1);
            editor.putInt("vip_12", 1);
            mShenmi.setChecked(true);
            editor.putInt("shenmi", 1);
            editor.putInt("vip_13", 1);
        }

        if (sp.getInt("vip_2", 0) == 1)
        {
            mSaoLei.setChecked(true);
            editor.putInt("saolei", 1);
            editor.commit();
        }

        if (sp.getInt("vip_3", 0) == 1)
        {
            mNiuNiu.setChecked(true);
            editor.putInt("niuniu", 1);
            editor.commit();
        }

        if (sp.getInt("vip_4", 0) == 1)
        {
            mWeiHao.setChecked(true);
            editor.putInt("weihao", 1);
            editor.commit();
        }

        if (sp.getInt("vip_5", 0) == 1)
        {
            mShouqi.setChecked(true);
            editor.putInt("shouqi", 1);
            editor.commit();
        }

        if (sp.getInt("vip_6", 0) == 1)
        {
            mDabao.setChecked(true);
            editor.putInt("dabao", 1);
            editor.commit();
        }

        if (sp.getInt("vip_7", 0) == 1)
        {
            mDuoBi.setChecked(true);
            editor.putInt("duobi", 1);
            editor.commit();
        }

        if (sp.getInt("vip_8", 0) == 1)
        {
            mJiaSu.setChecked(true);
            editor.putInt("jiasu", 1);
            editor.commit();
        }

        if (sp.getInt("vip_9", 0) == 1)
        {
            mGanrao.setChecked(true);
            editor.putInt("ganrao", 1);
            editor.commit();
        }

        if (sp.getInt("vip_10", 0) == 1)
        {
            mPingXi.setChecked(true);
            editor.putInt("xiping", 1);
            editor.commit();
        }


        if (sp.getInt("vip_11", 0) == 1)
        {
            mCloseAD.setChecked(true);
            editor.putInt("closead", 1);
            editor.commit();
        }

        if (sp.getInt("vip_12", 0) == 1)
        {
            mAutoThanks.setChecked(true);
            editor.putInt("autothanks", 1);
            editor.commit();
        }

        if (sp.getInt("vip_13", 0) == 1)
        {
            mShenmi.setChecked(true);
            editor.putInt("shenmi", 1);
            editor.commit();
        }
    }

    private void init()
    {
        // TODO Auto-generated method stub
        sp = getSharedPreferences("chatpage", MODE_PRIVATE);
        editor = sp.edit();

        SvipAll = (LinearLayout) findViewById(R.id.id_linear_senior_svipall);
        SaoLei = (LinearLayout) findViewById(R.id.id_linear_senior_saolei);
        NiuNiu = (LinearLayout) findViewById(R.id.id_linear_senior_niuniu);
        WeiHao = (LinearLayout) findViewById(R.id.id_linear_senior_weihao);
        Shouqi = (LinearLayout) findViewById(R.id.id_linear_senior_shouqi);
        Dabao = (LinearLayout) findViewById(R.id.id_linear_senior_dabao);
        DuoBi = (LinearLayout) findViewById(R.id.id_linear_senior_duobi);
        JiaSu = (LinearLayout) findViewById(R.id.id_linear_senior_jiasu);
        Ganrao = (LinearLayout) findViewById(R.id.id_linear_senior_ganrao);
        PingXi = (LinearLayout) findViewById(R.id.id_linear_senior_xiping);
        CloseAD = (LinearLayout) findViewById(R.id.id_linear_senior_guanbi);
        AutoThanks = (LinearLayout) findViewById(R.id.id_linear_senior_daxie);
        Shenmi = (LinearLayout) findViewById(R.id.id_linear_senior_shenmi);
        StartService = (LinearLayout) findViewById(R.id.id_linear_senior_kaiqi);
        AutoBackChatPage = (LinearLayout) findViewById(R.id.id_linear_senior_autobackchat);
        VoiseRemaid = (LinearLayout) findViewById(R.id.id_linear_senior_voise);
        NoAuto = (LinearLayout) findViewById(R.id.id_linear_senior_noauto);
        MyOwnBao = (LinearLayout) findViewById(R.id.id_linear_senior_myown);
        mFrameLayout = (FrameLayout) findViewById(R.id.id_senior_huodongxiangqing);

        mStartService = (ToggleButton) findViewById(R.id.id_toggle_senior_startservice);
        mBack = (ImageView) findViewById(R.id.img_senior_back);
        mSVIPall = (ToggleButton) findViewById(R.id.id_toggle_senior_svipall);
        mSaoLei = (ToggleButton) findViewById(R.id.id_toggle_senior_saolei);
        mNiuNiu = (ToggleButton) findViewById(R.id.id_toggle_senior_niuniu);
        mWeiHao = (ToggleButton) findViewById(R.id.id_toggle_senior_weihao);
        mShouqi = (ToggleButton) findViewById(R.id.id_toggle_senior_shouqi);
        mDabao = (ToggleButton) findViewById(R.id.id_toggle_senior_dabao);
        mDuoBi = (ToggleButton) findViewById(R.id.id_toggle_senior_duobi);
        mJiaSu = (ToggleButton) findViewById(R.id.id_toggle_senior_jiasu);
        mGanrao = (ToggleButton) findViewById(R.id.id_toggle_senior_ganrao);
        mPingXi = (ToggleButton) findViewById(R.id.id_toggle_senior_xiping);
        mCloseAD = (ToggleButton) findViewById(R.id.id_toggle_senior_guanbi);
        mAutoThanks = (ToggleButton) findViewById(R.id.id_toggle_senior_daxie);
        mShenmi = (ToggleButton) findViewById(R.id.id_toggle_senior_shenmi);
        mAutoBackChatPage = (ToggleButton) findViewById(R.id.id_toggle_senior_autobackchat);
        mVoiseRemaid = (ToggleButton) findViewById(R.id.id_toggle_senior_vicerem);
        mNoAuto = (ToggleButton) findViewById(R.id.id_toggle_senior_noautoqiang);
        mMyOwnBao = (ToggleButton) findViewById(R.id.id_toggle_senior_myown);

        leizhi = (Spinner) findViewById(R.id.id_main_spinner1);
        niu = (Spinner) findViewById(R.id.id_main_spinner2);
        weishu = (Spinner) findViewById(R.id.id_main_spinner3);

        editor.putInt("pageback", 1);
        editor.commit();

        if (sp.getInt("svipall", 0) == 1)
        {
            mSVIPall.setChecked(true);
        } else if (sp.getInt("svipall", 0) == 0)
        {
            mSVIPall.setChecked(false);
        }

        if (sp.getInt("saolei", 0) == 1)
        {
            mSaoLei.setChecked(true);
        } else if (sp.getInt("saolei", 0) == 0)
        {
            mSaoLei.setChecked(false);
        }

        if (sp.getInt("niuniu", 0) == 1)
        {
            mNiuNiu.setChecked(true);
        } else if (sp.getInt("niuniu", 0) == 0)
        {
            mNiuNiu.setChecked(false);
        }

        if (sp.getInt("weihao", 0) == 1)
        {
            mWeiHao.setChecked(true);
        } else if (sp.getInt("weihao", 0) == 0)
        {
            mWeiHao.setChecked(false);
        }

        if (sp.getInt("shouqi", 0) == 1)
        {
            mShouqi.setChecked(true);
        } else if (sp.getInt("shouqi", 0) == 0)
        {
            mShouqi.setChecked(false);
        }

        if (sp.getInt("dabao", 0) == 1)
        {
            mDabao.setChecked(true);
        } else if (sp.getInt("dabao", 0) == 0)
        {
            mDabao.setChecked(false);
        }

        if (sp.getInt("duobi", 0) == 1)
        {
            mDuoBi.setChecked(true);
        } else if (sp.getInt("duobi", 0) == 0)
        {
            mDuoBi.setChecked(false);
        }

        if (sp.getInt("jiasu", 0) == 1)
        {
            mJiaSu.setChecked(true);
        } else if (sp.getInt("jiasu", 0) == 0)
        {
            mJiaSu.setChecked(false);
        }

        if (sp.getInt("ganrao", 0) == 1)
        {
            mGanrao.setChecked(true);
        } else if (sp.getInt("ganrao", 0) == 0)
        {
            mGanrao.setChecked(false);
        }

        if (sp.getInt("xiping", 0) == 1)
        {
            mPingXi.setChecked(true);
        } else if (sp.getInt("xiping", 0) == 0)
        {
            mPingXi.setChecked(false);
        }

        if (sp.getInt("closead", 0) == 1)
        {
            mCloseAD.setChecked(true);
        } else if (sp.getInt("closead", 0) == 0)
        {
            mCloseAD.setChecked(false);
        }

        if (sp.getInt("autothanks", 0) == 1)
        {
            mAutoThanks.setChecked(true);
        } else if (sp.getInt("autothanks", 0) == 0)
        {
            mAutoThanks.setChecked(false);
        }

        if (sp.getInt("shenmi", 0) == 1)
        {
            mShenmi.setChecked(true);
        } else if (sp.getInt("shenmi", 0) == 0)
        {
            mShenmi.setChecked(false);
        }

        if (sp.getInt("startservice", 0) == 1)
        {
            mStartService.setChecked(true);
        } else if (sp.getInt("startservice", 1) == 0)
        {
            mStartService.setChecked(false);
        }

        if (sp.getInt("pageback", 0) == 1)
        {
            mAutoBackChatPage.setChecked(true);
        } else if (sp.getInt("pageback", 0) == 0)
        {
            mAutoBackChatPage.setChecked(false);
        }

        if (sp.getInt("voisere", 0) == 1)
        {
            mVoiseRemaid.setChecked(true);
        } else if (sp.getInt("voisere", 0) == 0)
        {
            mVoiseRemaid.setChecked(false);
        }

        if (sp.getInt("myown", 0) == 1)
        {
            mMyOwnBao.setChecked(true);
        } else if (sp.getInt("myown", 0) == 0)
        {
            mMyOwnBao.setChecked(false);
        }

        arrayAdapter1 = ArrayAdapter.createFromResource(this, R.array.leizhi, android.R.layout.simple_spinner_item);
        arrayAdapter2 = ArrayAdapter.createFromResource(this, R.array.niu, android.R.layout.simple_spinner_item);
        arrayAdapter3 = ArrayAdapter.createFromResource(this, R.array.weishu, android.R.layout.simple_spinner_item);
        arrayAdapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        arrayAdapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        arrayAdapter3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        leizhi.setAdapter(arrayAdapter1);
        niu.setAdapter(arrayAdapter2);
        weishu.setAdapter(arrayAdapter3);

        leizhi.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener()
        {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l)
            {
                editor.putInt("leizhi", i);
                editor.commit();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView)
            {

            }
        });

        niu.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener()
        {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l)
            {
                editor.putInt("niu", i);
                editor.commit();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView)
            {

            }
        });

        weishu.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener()
        {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l)
            {
                editor.putInt("weishu", i);
                editor.commit();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView)
            {

            }
        });
    }

    private void shareSvip(String title, String money, String type)
    {
        YqhyDialog1 yyDialog = new YqhyDialog1(SeniorActivity.this, title, money, type);
        try
        {
            yyDialog.showAtLocation(SeniorActivity.this.getWindow()
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

                if (info.getId().equals(getPackageName() + "/com.hb.qx.QQHongbaoService"))
                {
                    serviceEnabled = true;
                }
            }

            if (serviceEnabled)
            {
                getWindow().addFlags(
                        WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);

                mStartService.setChecked(true);
                editor.putInt("startservice", 1);
            } else
            {
                getWindow().clearFlags(
                        WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
                mStartService.setChecked(false);
                editor.putInt("startservice", 0);
            }
        } catch (Exception e)
        {
        }
    }

    @Override
    protected void onRestart()
    {
        super.onRestart();
        System.out.println("----------onRestart()-------------");
    }
}
