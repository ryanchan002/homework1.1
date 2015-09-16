package com.ryanchan.myfirstapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.InputType;
import android.view.Menu;
import android.view.MenuItem;
import android.content.Intent;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Button;

public class MyActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my);

        Button theButton = (Button)findViewById(R.id.pushButton);

        EditText input = (EditText)findViewById(R.id.mainTextField);
        input.setInputType(InputType.TYPE_CLASS_NUMBER);
        input.setText("");

        TextView textView = (TextView)findViewById(R.id.mainTextView);
        textView.setText("");

        theButton.setOnClickListener(
                new Button.OnClickListener()
                {
                    public void onClick(View v)
                    {
                        EditText theTextField = (EditText)findViewById(R.id.mainTextField);

                        TextView theTextView = (TextView)findViewById(R.id.mainTextView);
                        theTextView.setText(String.format("%s %s", theTextView.getText(), theTextField.getText()) );

                        theTextField.setText("");
                    }
                }

        );


        Button quitButton = (Button)findViewById(R.id.quitButton);
        quitButton.setOnClickListener(
                new Button.OnClickListener()
                {

                    public void onClick(View v)
                    {
                        System.exit(0);

                    }

                }


        );


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_my, menu);
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
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


    /** Called when the user clicks the Send button */
    public void sendMessage(View view) {
        // Do something in response to button



    }


}
