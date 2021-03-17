package com.example.guessmynumber;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.*;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final int[] wylosowana = new int[1];

        EditText number=(EditText)findViewById(R.id.Liczba);
        Button guess=(Button)findViewById(R.id.button2);
        TextView isIt=(TextView)findViewById(R.id.textView2);
        TextView count=(TextView)findViewById(R.id.textView);

        Random r=new Random();
        wylosowana[0] =r.nextInt(4001)-2000;

        guess.setOnClickListener(new View.OnClickListener() {
            int counter=0;
            @Override
            public void onClick(View v) {
                counter++;
                count.setText(counter+"");
                if(number.getText().length()>0)
                {
                    if((Double.parseDouble(number.getText().toString())<=2000)&&(Double.parseDouble(number.getText().toString())>-2000))
                    {
                        if(Double.parseDouble(number.getText().toString())< wylosowana[0])
                        {
                            isIt.setText("Za mało");
                        }
                        else if(Double.parseDouble(number.getText().toString())> wylosowana[0])
                        {
                            isIt.setText("Za dużo");
                        }
                        else if(Double.parseDouble(number.getText().toString())== wylosowana[0])
                        {
                            isIt.setText("Zgadłeś! :)");
                            wylosowana[0] =r.nextInt(4001)-2000;
                            counter=0;
                        }
                    }
                    else
                    {
                        isIt.setText("Liczba poza zakresem.");
                    }
                }
                else
                {
                    isIt.setText("Podaj liczbę.");
                }
            }
        });
    }
}