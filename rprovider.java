package com.example.savings_target;

public class rprovider {

    String samount;
    String snotes;
    String date;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getsamount() {
        return samount;
    }

    public void setsamount(String samount) {
        this.samount = samount;
    }

    public String getsnotes() {
        return snotes;
    }

    public void setsnotes(String snotes) {
        this.snotes = snotes;
    }

    public rprovider(String samount, String snotes, String date)
    {

        this.samount = samount;
        this.snotes = snotes;
        this.date = date;

    }
}
