package com.example.gestiondusommeil.View;

import androidx.appcompat.app.AppCompatActivity;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


import com.example.gestiondusommeil.R;

public class ResultActivity extends AppCompatActivity {
    private TextView textViewResultHours;
    private TextView textViewNumHours;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        textViewResultHours = findViewById(R.id.textViewResultHours);
        textViewNumHours=findViewById(R.id.textViewNumHours);

        Intent intent = getIntent();
        if (intent != null) {
            String reponse = intent.getStringExtra("reponse1");
            String heuresDormies = intent.getStringExtra("reponse2");

            if (reponse != null) {
                textViewResultHours.setText(reponse);
            }

            if (heuresDormies != null) {
                textViewNumHours.setText(heuresDormies);
            }
        }


        Button retourButton = findViewById(R.id.retour);
        retourButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
