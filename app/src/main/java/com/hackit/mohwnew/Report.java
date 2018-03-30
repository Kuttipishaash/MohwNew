package com.hackit.mohwnew;

/**
 * Created by praji on 30-Mar-18.
 */

public class Report {

    String title;
    String progName;
    String desc;

    public Report() {

    }

    public Report(String title, String progName, String desc) {
        this.title = title;
        this.progName = progName;
        this.desc = desc;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getProgName() {
        return progName;
    }

    public void setProgName(String progName) {
        this.progName = progName;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
