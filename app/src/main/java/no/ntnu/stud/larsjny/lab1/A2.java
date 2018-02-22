package no.ntnu.stud.larsjny.lab1;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class A2 extends AppCompatActivity {

    public static final int GET_RESULT = 1;

    private TextView t2;
    private TextView t3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_a2);

        Intent thisIntent = getIntent();            // Get instance of intent that opened this activity

        t2 = (TextView) findViewById(R.id.t2);      // Fint textview 2
        t3 = (TextView) findViewById(R.id.t3);      // Find textview 3

        String dataFromA1 = thisIntent.getStringExtra(A1.EXTRA_MESSAGE);    // Get the data sent from A1

        dataFromA1 = "Hello " + dataFromA1;         // Prepend "Hello"

        t2.setText(dataFromA1);                     // Update the textview
    }


    /**
     * Should be called when the button is tapped.
     * @param view
     */
    public void onButtonClicked(View view){
        Intent intent = new Intent(this, A3.class);
        startActivityForResult(intent, GET_RESULT);
    }

    /**
     * Called when a result has occured from A3
     * @param requestCode
     * @param resultCode
     * @param data
     */
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data){
        if(requestCode == GET_RESULT){

            String newMessage = "From A3: ";

            if(resultCode == RESULT_OK){
                String dataFromA3 = data.getStringExtra("result");
                newMessage += dataFromA3;
                t3.setText(newMessage);
            }

        }
    }
}
