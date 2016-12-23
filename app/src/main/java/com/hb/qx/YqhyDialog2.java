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
import android.widget.EditText;
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

public class YqhyDialog2 extends PopupWindow
{
    private Activity mActivity;
    private EditText editText;
    private Button button;
    private ImageView cancel;


    public YqhyDialog2(Activity activity)
    {
        mActivity = activity;
        initView();
    }

    public void initView()
    {
        View rootView = LayoutInflater.from(mActivity).inflate(R.layout.dialog_share2, null);
        editText = (EditText) rootView.findViewById(R.id.id_add_edittext);
        button = (Button) rootView.findViewById(R.id.id_tijiao_phone);
        cancel = (ImageView) rootView.findViewById(R.id.id_dialog_cancel2);

        button.setOnClickListener(new OnClickListener()
        {
            @Override
            public void onClick(View view)
            {

            }
        });

        cancel.setOnClickListener(new OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                dismiss();
            }
        });

        setContentView(rootView);
        setWidth(LayoutParams.MATCH_PARENT);
        setHeight(LayoutParams.MATCH_PARENT);
        setFocusable(true);
        setTouchable(true);
        setOutsideTouchable(false);
    }

    @Override
    public void dismiss()
    {
        super.dismiss();
    }
}
