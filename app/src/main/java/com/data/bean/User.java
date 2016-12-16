package com.data.bean;

/**
 * Created by pc on 2016/12/14.
 */
public class User
{
    private static final long serialVersionUID = 1L;
    private String from;
    private String name;
    private String num;
    private String time;


    public User(String from, String name, String num, String time)
    {
        this.from = from;
        this.name = name;
        this.num = num;
        this.time = time;
    }

    public User()
    {
    }

    public String getFrom()
    {
        return from;
    }

    public void setFrom(String from)
    {
        this.from = from;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getNum()
    {
        return num;
    }

    public void setNum(String num)
    {
        this.num = num;
    }

    public String getTime()
    {
        return time;
    }

    public void setTime(String time)
    {
        this.time = time;
    }
}
