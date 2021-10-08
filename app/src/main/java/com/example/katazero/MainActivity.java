package com.example.katazero;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Arrays;

public class MainActivity extends AppCompatActivity {
    int i=0;
    int initialstate[]={2,2,2,2,2,2,2,2,2};
    int winposition[][]={ {0,1,2},{3,4,5},{6,7,8},{0,3,6},{1,4,7},{2,5,8},{0,4,8},{2,4,6}};
    int j=0;

       public void tapme(View view) {
        ImageView counter = (ImageView) view;
        Log.i("tag","counter.getTag().toString()");
        int tapcounter=Integer.parseInt(counter.getTag().toString());
        if(initialstate[tapcounter]==2&&j==0){
        initialstate[tapcounter]=i;

        if (i == 0) {
            counter.setImageResource(R.drawable.cross);
            counter.animate().alpha(1).setDuration(300);
            i = 1;
        } else {
            counter.setImageResource(R.drawable.zero);
            counter.animate().alpha(1).setDuration(300);
            i = 0;
        }
        for(int [] win:winposition){
            if(initialstate[win[0]]==initialstate[win[1]]&&initialstate[win[1]]==initialstate[win[2]]&&initialstate[win[0]]!=2){
            if(i==1){
                TextView textView2=(TextView) findViewById(R.id.textView2) ;
                Button button=(Button)findViewById(R.id.button);
                button.setVisibility(View.VISIBLE);
                textView2.setText("Cross win this game!!");
                textView2.setVisibility(View.VISIBLE);
                j=1;
                Toast.makeText(this, "Cross win this game", Toast.LENGTH_SHORT).show();

            }
            else{
                TextView textView2=(TextView) findViewById(R.id.textView2) ;
                Button button=(Button)findViewById(R.id.button);
                textView2.setText("Zero win this game!!");
                textView2.setVisibility(View.VISIBLE);
                button.setVisibility(View.VISIBLE);
                Toast.makeText(this, "Zero win this game", Toast.LENGTH_SHORT).show();

            j=1;
            }
        }}}
        else {
            if (i!=2) Toast.makeText(this, "Double tap error!!", Toast.LENGTH_SHORT).show();
             if(j==1) Toast.makeText(this, "Someone already won!!", Toast.LENGTH_SHORT).show();
        }}
    public void  Playagain(View view){
        Button button=(Button)findViewById(R.id.button);
        TextView textView2=(TextView) findViewById(R.id.textView2);
        button.setVisibility(View.INVISIBLE);
        textView2.setVisibility(View.INVISIBLE);

        GridLayout gridLayout = (GridLayout) findViewById(R.id.gridLayout);
        for(int w=0;w<gridLayout.getChildCount();w++){

            ImageView count = (ImageView)gridLayout.getChildAt(w);
            count.setImageDrawable(null);
        }

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}