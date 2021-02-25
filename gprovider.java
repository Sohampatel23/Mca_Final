package com.example.savings_target;

public class gprovider {

    String gname;
    String gamount;

    public String getGname() {
        return gname;
    }

    public void setGname(String gname) {
        this.gname = gname;
    }

    public String getGamount() {
        return gamount;
    }

    public void setGamount(String gamount) {
        this.gamount = gamount;
    }

    public gprovider( String gname,String gamount)
    {

        this.gname=gname;
        this.gamount=gamount;

    }
}
