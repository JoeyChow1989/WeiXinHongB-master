package com.hb.qx;

import android.app.Activity;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;

import com.umeng.socialize.bean.SHARE_MEDIA;
import com.umeng.socialize.bean.SocializeEntity;
import com.umeng.socialize.controller.UMServiceFactory;
import com.umeng.socialize.controller.UMSocialService;
import com.umeng.socialize.controller.listener.SocializeListeners.SnsPostListener;
import com.umeng.socialize.media.QQShareContent;
import com.umeng.socialize.media.QZoneShareContent;
import com.umeng.socialize.media.UMImage;
import com.umeng.socialize.sso.QZoneSsoHandler;
import com.umeng.socialize.sso.UMQQSsoHandler;
import com.umeng.socialize.weixin.controller.UMWXHandler;
import com.umeng.socialize.weixin.media.CircleShareContent;
import com.umeng.socialize.weixin.media.WeiXinShareContent;

public class YqhyDialog1 extends PopupWindow implements OnClickListener
{
    private Activity mActivity;
    private LinearLayout linearLayout;
    private Button button;
    private CheckBox zhifubao, weixin;


    public YqhyDialog1(Activity activity)
    {
        mActivity = activity;
        initView();
    }

    public void initView()
    {
        View rootView = LayoutInflater.from(mActivity).inflate(R.layout.dialog_share1, null);
        linearLayout = (LinearLayout) rootView.findViewById(R.id.context_view1);
        button = (Button) rootView.findViewById(R.id.id_querenzhifu);
        zhifubao = (CheckBox) rootView.findViewById(R.id.id_checkbox_zhifubao);
        weixin = (CheckBox) rootView.findViewById(R.id.id_checkbox_weixin);

        zhifubao.setChecked(true);

        if (zhifubao.isChecked())
        {
            weixin.setChecked(false);
        } else
        {
            zhifubao.setChecked(false);
        }

        setContentView(rootView);
        setWidth(LayoutParams.MATCH_PARENT);
        setHeight(LayoutParams.MATCH_PARENT);
        setFocusable(true);
        setTouchable(true);
        setOutsideTouchable(true);
    }

    @Override
    public void dismiss()
    {
        super.dismiss();
    }

    @Override
    public void onClick(View v)
    {
        int id = v.getId();
        switch (id)
        {
            case R.id.id_querenzhifu:
                Toast.makeText(mActivity, "-------------确定-------------", Toast.LENGTH_SHORT);
                return;
        }
    }
}
