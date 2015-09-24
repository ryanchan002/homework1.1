package com.ryanchan.myfirstapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.InputType;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Button;
import java.util.ArrayList;

public class MyActivity extends AppCompatActivity {

    private ArrayList<Editable> numList;

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

        numList = new ArrayList<>();

        theButton.setOnClickListener(
                new Button.OnClickListener()
                {
                    public void onClick(View v)
                    {
                        TextView errorButton = (TextView)findViewById(R.id.errorText);
                        EditText theTextField = (EditText) findViewById(R.id.mainTextField);
                        TextView theTextView = (TextView) findViewById(R.id.mainTextView);

                        if (numList.size() < 3)
                        {
                            if (theTextField.length() == 1)
                            {
                                numList.add(theTextField.getText());
                                theTextView.setText(String.format("%s", numList.toString() ));
                                theTextField.setText("");
                                errorButton.setText("%s pushed to the stack");
                            }
                            else
                            {
                                errorButton.setText("The number must be between 0-9");
                            }
                        }
                        else
                        {
                            errorButton.setText("Stack is full");

                        }
                    }
                }

        );


        Button popButton = (Button)findViewById(R.id.popButton);
        popButton.setOnClickListener(
                new Button.OnClickListener()
                {

                    public void onClick(View v)
                    {
                        if (numList.size() > 0 )
                        {
                            TextView theTextView = (TextView) findViewById(R.id.mainTextView);
                            numList.remove(numList.size() - 1);

                            theTextView.setText(String.format("%s", numList.toString()));

                            TextView errorButton = (TextView)findViewById(R.id.errorText);
                            errorButton.setText("");


                        }
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
