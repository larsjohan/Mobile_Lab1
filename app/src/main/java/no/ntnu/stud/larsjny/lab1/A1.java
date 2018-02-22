package no.ntnu.stud.larsjny.lab1;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

public class A1 extends AppCompatActivity implements AdapterView.OnItemSelectedListener{

    public static final String EXTRA_MESSAGE = "no.ntnu.stud.larsjny.lab1.MESSAGE";

    private Spinner dropdown;

    private String logName;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_a1);

        logName = getString(R.string.app_name);

        Log.d(logName, "Loading Activity A1");


        dropdown = findViewById(R.id.l1);

        ArrayAdapter<CharSequence> dropdownItems =                          // Define the Options in the dropdown from string-resource
                ArrayAdapter.createFromResource(
                        this,
                        R.array.dropdownItems,
                        android.R.layout.simple_spinner_item
                );

        dropdownItems.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        dropdown.setAdapter(dropdownItems);

        dropdown.setOnItemSelectedListener(this);





        final SharedPreferences pref = PreferenceManager.getDefaultSharedPreferences(this);

        final int previousChoice  = pref.getInt(getString(R.string.saved_dropdown_choice), -1);    // Get position of chosen item or return -1 if nothing is stored in preferences


        Log.d(logName, "Loading Dropdown-value");
        Log.d(logName, "Loaded choice: " + previousChoice);


        if(previousChoice > -1) {
            dropdown.setSelection(previousChoice);

            Log.d(logName, "Loaded dropdown value: " + dropdown.getSelectedItem());
        }



        findViewById(R.id.b1).setOnClickListener(this::onButtonClicked);

        Log.d(logName, "A1 created");
    }

    /*
     * Defines what should happen if an item in the dropdown has been selected
     * @param parent
     * @param view
     * @param pos
     * @param id
     */
    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int pos, long id){
        final SharedPreferences pref = PreferenceManager.getDefaultSharedPreferences(this);
        final SharedPreferences.Editor editor = pref.edit();
        editor.putInt(getString(R.string.saved_dropdown_choice), pos);
        editor.apply();

        Log.d(logName, "Saved value on pos " + pos + " in Dropdown to preferences");
    }


    /*
     * Defines what should happen if nothing is selected in the dropdown
     * @param parent
     * @param view
     * @param pos
     * @param id
     */
    @Override
    public void onNothingSelected(AdapterView<?> parent) {
        dropdown.setSelection(0);   // Select first element in list as default
    }

    /*
     * Should be called when the button is tapped.
     *
     * @param view
     */
    public void onButtonClicked(View view) {
        Intent intent = new Intent(this, A2.class);   // Load next activity
        EditText input = findViewById(R.id.t1);          // Find textfield
        String txt = input.getText().toString();                    // Get the value
        intent.putExtra(EXTRA_MESSAGE, txt);

        Log.d(logName, "Loading activity A2 with data: " + txt);

        startActivity(intent);
    }
}