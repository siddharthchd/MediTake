package com.example.dcube.swamptest;

/**
 * Created by siddh on 21-01-2018.
 */

public class Medicine {
    int id;
    int dots;
    String name;
    String Desc;
    int days;

    public Medicine(){

    }
    public Medicine(int id, int dots, String name, String Desc, int days) {
        this.id = id;
        this.dots = dots;
        this.name = name;
        this.Desc = Desc;
        this.days = days;
    }

    public int getID()
    {
        return this.id;
    }
    public void setID(int id)
    {
        this.id = id;
    }

    public String getName()
    {
        return this.name;
    }
    public void setName(String name)
        {
            this.name = name;
        }
    public int getDots()
    {
        return this.dots;
    }
    public void setDots(int dots)
    {
        this.dots = dots;
    }

    public String getDesc()
    {
        return this.Desc;
    }
    public void setDesc(String desc)
    {
        this.Desc = desc;
    }

    public int getDays()
    {
        return this.days;
    }
    public void setDays(int desc)
    {
        this.days = desc;
    }

}
