package com.example.gestiondusommeil.View;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TimePicker;
import android.widget.Toast;

import com.example.gestiondusommeil.Controller.HourSleepController;
import com.example.gestiondusommeil.Model.SleepModel;
import com.example.gestiondusommeil.R;

public class HourSleep extends AppCompatActivity {
    private Button btnCalculer;
    private TimePicker timePicker1;
    private TimePicker timePicker2;
    private final int REQUEST_CODE = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hour_sleep);

        btnCalculer = findViewById(R.id.buttonCalculate);
        timePicker1 = findViewById(R.id.timePickerWakeUpTime1);
        timePicker2 = findViewById(R.id.timePickerWakeUpTime2);



        btnCalculer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int heureDormir = timePicker1.getHour();
                int heureReveil = timePicker2.getHour();

                boolean verifHeureDormir = false, verifHeureReveil = false;

                if (heureDormir != 0)
                    verifHeureDormir = true;
                else
                    Toast.makeText(HourSleep.this, "Veuillez saisir l'heure de dormir !",
                            Toast.LENGTH_SHORT).show();

                if (heureReveil != 0)
                    verifHeureReveil = true;
                else
                    Toast.makeText(HourSleep.this, "Veuillez saisir l'heure de réveil !",
                            Toast.LENGTH_SHORT).show();

                if (verifHeureDormir && verifHeureReveil) {
                HourSleepController.getInstance().createSleepModel(heureDormir, heureReveil);

                Intent intent = new Intent(HourSleep.this, ResultActivity.class);
                intent.putExtra("reponse1", HourSleepController.getInstance().getReponse());
                intent.putExtra("reponse2",HourSleepController.getInstance().getNumHours());
                startActivityForResult(intent, REQUEST_CODE);
                }
            }
        });
    }

}