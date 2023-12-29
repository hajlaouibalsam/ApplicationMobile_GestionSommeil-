package com.example.gestiondusommeil.Controller;

import android.view.View;

import com.example.gestiondusommeil.Model.SleepModel;
import com.example.gestiondusommeil.View.HourSleep;

public class HourSleepController {
    private static HourSleepController instance;
    private SleepModel sleepModel;

    private HourSleepController() {}

    public static HourSleepController getInstance() {
        if (instance == null)
            instance = new HourSleepController();
        return instance;
    }

    public void createSleepModel(int tempsDormis, int tempsReveil) {
        sleepModel = new SleepModel(tempsDormis, tempsReveil);
    }

    public String getReponse() {

            return sleepModel.getReponse();
    }

    public String getNumHours(){
        return sleepModel.getHeuresDormies();

    }
}