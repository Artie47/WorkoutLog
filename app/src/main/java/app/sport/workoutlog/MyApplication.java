package app.sport.workoutlog;

import android.app.Application;

class MyAppApplication extends Application {

    private String ID_USER;

    public String getID_USER() {
        return ID_USER;
    }

    public void setID_USER(String str) {
        ID_USER = str;
    }
}