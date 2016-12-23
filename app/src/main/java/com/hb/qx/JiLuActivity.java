package com.hb.qx;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.data.bean.User;

import java.util.ArrayList;
import java.util.List;

public class JiLuActivity extends AppCompatActivity
{

    private List<User> userList;
    private List<User> realuserList;
    private ListView mListView;
    private JiLuAdapter mJiLuAdapter;
    private ImageView img_back;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jilu);
        mListView = (ListView) findViewById(R.id.id_jilu_listview);
        img_back = (ImageView) findViewById(R.id.jilu_senior_back);

        img_back.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                JiLuActivity.this.finish();
            }
        });

        userList = new ArrayList<>();
        realuserList = new ArrayList<>();
    }

    @Override
    protected void onStart()
    {
        super.onStart();
        userList = HbApplication.getInstance().getUserDB().getUser();

        for (int i = 0; i < userList.size(); i++)
        {
            if (i % 2 == 0)
            {
                realuserList.add(userList.get(i));
            }
        }

        mJiLuAdapter = new JiLuAdapter(this);
        mListView.setAdapter(mJiLuAdapter);
    }

    class JiLuAdapter extends BaseAdapter
    {

        private Context context;

        public JiLuAdapter(Context context)
        {
            this.context = context;
        }

        @Override
        public int getCount()
        {
            return realuserList.size();
        }

        @Override
        public Object getItem(int i)
        {
            return realuserList.get(i);
        }

        @Override
        public long getItemId(int i)
        {
            return i;
        }

        @Override
        public View getView(int position, View cview, ViewGroup viewGroup)
        {
            ViewHolder viewHolder = null;
            if (cview == null)
            {
                viewHolder = new ViewHolder();

                cview = LayoutInflater.from(context).inflate(R.layout.item_jilu, viewGroup, false);
                viewHolder.from = (TextView) cview.findViewById(R.id.item_jilu_from);
                viewHolder.name = (TextView) cview.findViewById(R.id.item_jilu_name);
                viewHolder.num = (TextView) cview.findViewById(R.id.item_jilu_num);
                viewHolder.time = (TextView) cview.findViewById(R.id.item_jilu_time);

                cview.setTag(viewHolder);
            }else {
                viewHolder = (ViewHolder) cview.getTag();
            }

            viewHolder.from.setText(realuserList.get(position).getFrom());
            viewHolder.name.setText(realuserList.get(position).getName());
            viewHolder.num.setText(realuserList.get(position).getNum());

            return cview;
        }

        class ViewHolder
        {
            TextView from;
            TextView name;
            TextView num;
            TextView time;
        }
    }
}
