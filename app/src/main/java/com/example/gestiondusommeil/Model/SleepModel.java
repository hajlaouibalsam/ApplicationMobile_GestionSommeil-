package com.example.gestiondusommeil.Model;

public class SleepModel {
    private int tempsDormis;
    private int tempsReveil;
    private String heuresDormies;
    private String reponse;

    public SleepModel(int tempsDormis, int tempsReveil) {
        this.tempsDormis = tempsDormis;
        this.tempsReveil = tempsReveil;
        calculer();
        calculerHeuresDormies();
    }

    private void calculerHeuresDormies() {
        int difference = tempsReveil - tempsDormis;
        if (difference < 0) {
            difference += 24; // Supposant un cycle de journée de 24 heures
        }
        heuresDormies = String.valueOf(difference);

    }

    private void calculer() {
        heuresDormies = String.valueOf(tempsReveil - tempsDormis);

        if (Integer.parseInt(heuresDormies) < 7) {
            reponse = "sommeil insuffisant";
        } else if (Integer.parseInt(heuresDormies) >= 7 && Integer.parseInt(heuresDormies )<= 8) {
            reponse = "bon sommeil";
        } else {
            reponse = "sommeil excessif";
        }
    }

    public String getHeuresDormies() {
        return heuresDormies;
    }

    public String getReponse() {
        return reponse;
    }
}
