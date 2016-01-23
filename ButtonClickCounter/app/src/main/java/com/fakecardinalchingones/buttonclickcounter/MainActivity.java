package com.fakecardinalchingones.buttonclickcounter;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    //create a button
    private Button ourButton;
    private TextView ourMessage;
    private int numTimesClicked = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //add the views to the activity
       ourButton = (Button) findViewById(R.id.mybutt);
        ourMessage = (TextView) findViewById(R.id.textView);


        View.OnClickListener ourOnClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numTimesClicked = numTimesClicked + 1;
                String total = Integer.toString(numTimesClicked);
                String result = "The button got clicked " + total + " time";
                if(numTimesClicked==1){
                    ourMessage.setText(result);
                }else{
                    ourMessage.setText(result + "s");
                }
            }
        };

        //link button to onclicklistener
            ourButton.setOnClickListener(ourOnClickListener);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {

//this is used to display a text message when the three little dots (settings) are touched.

            Toast toastMessage = Toast.makeText(this,"Text value is now " + ourMessage.getText(),Toast.LENGTH_LONG);
            toastMessage.show();//this calls the message
            numTimesClicked = 0;
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
