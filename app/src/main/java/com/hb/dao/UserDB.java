package com.hb.dao;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.data.bean.User;

import java.util.LinkedList;
import java.util.List;

public class UserDB
{
    private UserDBHelper helper;

    public UserDB(Context context)
    {
        helper = new UserDBHelper(context);
    }

    public User selectInfo(String userId)
    {
        User u = new User();
        SQLiteDatabase db = helper.getReadableDatabase();
        Cursor c = db.rawQuery("select * from user where userId=?",
                new String[]{userId + ""});
        if (c.moveToFirst())
        {
            u.setFrom(c.getString(c.getColumnIndex("_from")));
            u.setName(c.getString(c.getColumnIndex("name")));
            u.setNum(c.getString(c.getColumnIndex("num")));
            u.setTime(c.getString(c.getColumnIndex("time")));
        } else
        {
            return null;
        }
        return u;
    }

    public void addUser(List<User> list)
    {
        SQLiteDatabase db = helper.getWritableDatabase();
        for (User u : list)
        {
            db.execSQL(
                    "insert into user (_from,name,num,time) values(?,?,?,?)",
                    new Object[]{u.getFrom(), u.getName(), u.getNum(), u.getTime()});
        }
        db.close();
    }

    public void addUser(User u)
    {
        SQLiteDatabase db = helper.getWritableDatabase();
        db.execSQL(
                "insert into user (_from,name,num,time) values(?,?,?,?)",
                new Object[]{u.getFrom(), u.getName(), u.getNum(), u.getTime()});
        db.close();
    }

    public void updateUser(List<User> list)
    {
        if (list.size() > 0)
        {
            delete();
            addUser(list);
        }
    }

    public List<User> getUser()
    {
        SQLiteDatabase db = helper.getWritableDatabase();
        List<User> list = new LinkedList<User>();
        Cursor c = db.rawQuery("select * from user", null);
        while (c.moveToNext())
        {
            User u = new User();
            u.setFrom(c.getString(c.getColumnIndex("_from")));
            u.setName(c.getString(c.getColumnIndex("name")));
            u.setNum(c.getString(c.getColumnIndex("num")));
            u.setTime(c.getString(c.getColumnIndex("time")));
            list.add(u);
        }
        c.close();
        db.close();
        return list;
    }

    public void delete()
    {
        SQLiteDatabase db = helper.getWritableDatabase();
        db.execSQL("delete from user");
        db.close();
    }
}
