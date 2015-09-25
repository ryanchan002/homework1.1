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
                        TextView errorTextView = (TextView)findViewById(R.id.errorText);
                        EditText theTextField = (EditText) findViewById(R.id.mainTextField);
                        TextView theTextView = (TextView) findViewById(R.id.mainTextView);

                        //this checks the stack to make sure that there are no more than 3 items to be pushed to the stack
                        if (numList.size() < 3)
                        {
                            //check to see if the number is 0-9
                            if (theTextField.length() == 1)
                            {
                                //if it is, add it to the stack, print the stack, reset the textfield text and print the number pushed to the stack
                                numList.add(theTextField.getText());
                                theTextView.setText(String.format("%s", numList.toString() ));
                                errorTextView.setText(String.format("%s pushed to the stack", theTextField.getText().toString()));

                                theTextField.setText("");
                            }
                            else
                            {
                                //number is not 0-9
                                errorTextView.setText("The number must be between 0-9");
                            }
                        }
                        else
                        {
                            errorTextView.setText("Stack is full");

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
                        //make sure that we are not trying to pop an empty stack
                        if (numList.size() > 0 )
                        {
                            //remove the last item in the stack
                            TextView theTextView = (TextView) findViewById(R.id.mainTextView);
                            String poppedNumber = numList.get( numList.size()-1 ).toString() ;

                            TextView errorTextView = (TextView)findViewById(R.id.errorText);

                            errorTextView.setText(String.format("%s popped from the stack",poppedNumber  ));

                            numList.remove(numList.size() - 1);

                            //rest the textview text
                            theTextView.setText(String.format("%s", numList.toString()));



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
                        //exit when the quit button is pressed
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
