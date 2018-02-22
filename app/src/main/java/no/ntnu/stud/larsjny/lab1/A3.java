package no.ntnu.stud.larsjny.lab1;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class A3 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_a3);
    }


    /**
     * Should be called when the button is tapped.
     * @param view
     */
    public void onButtonClicked(View view){
        Intent intent = new Intent();
        String returnValue = ((EditText) findViewById(R.id.t4)).getText().toString();
        intent.putExtra("result", returnValue);
        setResult(Activity.RESULT_OK, intent);
        finish();
    }
}
