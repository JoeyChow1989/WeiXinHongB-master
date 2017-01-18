package com.hb.qx;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.PopupWindow;

import cn.swiftpass.spaycx.R;


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
                if ("".equals(editText.getText().toString()))
                {
                    dismiss();
                }
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
