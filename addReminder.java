package michaelkim.dailyreminders;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.TimePicker;

public class addReminder extends AppCompatActivity {

    // Widget declarations.
    TextView selectedTime;
    TextView reminderTD;
    EditText reminderNameField;
    Button reminderTDButton;
    Button createReminderButton;

    CheckBox reminderRecur;
    TextView every;
    Spinner timeSpinner;
    TextView hourText;
    TextView dayText;

    CheckBox advancedSettings;
    TextView repeatEvery;
    Spinner repeatSpinner;
    TextView dayText2;
    TextView weekText2;
    TextView monthText2;

    // String for the button pressed from the homescreen.
    String buttonPressed;

    // String for selected time/day/date.
    String TDSelected;

    // Values for the time/picker dialog.
    DatePicker datePicker;
    TimePicker timePicker;

    // Custom day picker declarations.
    ImageView sunCircle, monCircle, tuesCircle, wedCircle, thursCircle, friCircle, satCircle;
    TextView sun, mon, tues, wed, thurs, fri, sat;
    boolean sunT = false, monT = false, tuesT = false, wedT = false, thursT = false, friT = false, satT = false;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_reminder);

        // Grab the value for what button was pressed from the home screen.
        Intent intent = getIntent();
        buttonPressed = intent.getStringExtra("key");

        // Day and Hour spinner arrays.
        String[] array = {"-", "1", "2", "3"};
        String[] daysArr = {"-", "1", "2", "3", "4", "5", "6"};
        String[] monthsArr = {"-", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11"};

        // Widget instantiation.
        selectedTime = (TextView) findViewById(R.id.selectedTime);
        reminderTD = (TextView) findViewById(R.id.reminderTD);
        reminderTDButton = (Button) findViewById(R.id.reminderTDButton);
        createReminderButton = (Button) findViewById(R.id.createReminderButton);
        reminderNameField = (EditText) findViewById(R.id.reminderNameField);

        reminderRecur = (CheckBox) findViewById(R.id.reminderRecur);
        every = (TextView) findViewById(R.id.every);
        timeSpinner = (Spinner) findViewById(R.id.timeSpinner);
        hourText = (TextView) findViewById(R.id.hoursText);
        dayText = (TextView) findViewById(R.id.daysText);

        ArrayAdapter<String> spinnerAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, array);
        timeSpinner.setAdapter(spinnerAdapter);

        advancedSettings = (CheckBox) findViewById(R.id.advancedSettings);
        repeatEvery = (TextView) findViewById(R.id.repeatEvery);
        repeatSpinner = (Spinner) findViewById(R.id.repeatSpinner);
        dayText2 = (TextView) findViewById(R.id.daysText2);
        weekText2 = (TextView) findViewById(R.id.weeksText2);
        monthText2 = (TextView) findViewById(R.id.monthsText2);

        // Get the value from the button pressed from the home screen.
        // Adjust widget values accordingly.
        if (buttonPressed.equals("daily")){
            reminderTD.setText("Time :");
            reminderTDButton.setText("Pick a Time");

            ArrayAdapter<String> daysAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, daysArr);
            repeatSpinner.setAdapter(daysAdapter);
        }
        else if (buttonPressed.equals("weekly")){
            reminderTD.setText("Day :");
            reminderTDButton.setText("Pick a Day");

            ArrayAdapter<String> weeksAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, array);
            repeatSpinner.setAdapter(weeksAdapter);
        }
        else if (buttonPressed.equals("monthly")){
            reminderTD.setText("Date :");
            reminderTDButton.setText("Pick a Date");

            ArrayAdapter<String> monthsAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, monthsArr);
            repeatSpinner.setAdapter(monthsAdapter);
        }

        // If the 'reminderRecur' checkbox is checked, show the corresponding widgets.
        // Else, hide them.
        reminderRecur.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (buttonPressed.equals("daily")) {
                    if (every.getVisibility() == View.INVISIBLE && reminderRecur.isChecked()) {
                        every.setVisibility(View.VISIBLE);
                        timeSpinner.setVisibility(View.VISIBLE);
                        hourText.setVisibility(View.VISIBLE);
                    }
                    if (every.getVisibility() == View.VISIBLE && !reminderRecur.isChecked()) {
                        every.setVisibility(View.INVISIBLE);
                        timeSpinner.setVisibility(View.INVISIBLE);
                        hourText.setVisibility(View.INVISIBLE);
                    }
                }
                else if (buttonPressed.equals("weekly")){
                    if (every.getVisibility() == View.INVISIBLE && reminderRecur.isChecked()) {
                        every.setVisibility(View.VISIBLE);
                        timeSpinner.setVisibility(View.VISIBLE);
                        dayText.setVisibility(View.VISIBLE);
                    }
                    if (every.getVisibility() == View.VISIBLE && !reminderRecur.isChecked()) {
                        every.setVisibility(View.INVISIBLE);
                        timeSpinner.setVisibility(View.INVISIBLE);
                        dayText.setVisibility(View.INVISIBLE);
                    }
                }
                else if (buttonPressed.equals("monthly")){
                    if (every.getVisibility() == View.INVISIBLE && reminderRecur.isChecked()) {
                        every.setVisibility(View.VISIBLE);
                        timeSpinner.setVisibility(View.VISIBLE);
                        dayText.setVisibility(View.VISIBLE);
                    }
                    if (every.getVisibility() == View.VISIBLE && !reminderRecur.isChecked()) {
                        every.setVisibility(View.INVISIBLE);
                        timeSpinner.setVisibility(View.INVISIBLE);
                        dayText.setVisibility(View.INVISIBLE);
                    }
                }
            }
        });

        // If the 'advancedSettings' checkbox is checked, show the corresponding widgets.
        // Else, hide them.
        advancedSettings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (buttonPressed.equals("daily")) {
                    if (repeatEvery.getVisibility() == View.INVISIBLE && advancedSettings.isChecked()) {
                        repeatEvery.setVisibility(View.VISIBLE);
                        repeatSpinner.setVisibility(View.VISIBLE);
                        dayText2.setVisibility(View.VISIBLE);
                    }
                    if (repeatEvery.getVisibility() == View.VISIBLE && !advancedSettings.isChecked()) {
                        repeatEvery.setVisibility(View.INVISIBLE);
                        repeatSpinner.setVisibility(View.INVISIBLE);
                        dayText2.setVisibility(View.INVISIBLE);
                    }
                }
                else if (buttonPressed.equals("weekly")){
                    if (repeatEvery.getVisibility() == View.INVISIBLE && advancedSettings.isChecked()) {
                        repeatEvery.setVisibility(View.VISIBLE);
                        repeatSpinner.setVisibility(View.VISIBLE);
                        weekText2.setVisibility(View.VISIBLE);
                    }
                    if (repeatEvery.getVisibility() == View.VISIBLE && !advancedSettings.isChecked()) {
                        repeatEvery.setVisibility(View.INVISIBLE);
                        repeatSpinner.setVisibility(View.INVISIBLE);
                        weekText2.setVisibility(View.INVISIBLE);
                    }
                }
                else if (buttonPressed.equals("monthly")){
                    if (repeatEvery.getVisibility() == View.INVISIBLE && advancedSettings.isChecked()) {
                        repeatEvery.setVisibility(View.VISIBLE);
                        repeatSpinner.setVisibility(View.VISIBLE);
                        monthText2.setVisibility(View.VISIBLE);
                    }
                    if (repeatEvery.getVisibility() == View.VISIBLE && !advancedSettings.isChecked()) {
                        repeatEvery.setVisibility(View.INVISIBLE);
                        repeatSpinner.setVisibility(View.INVISIBLE);
                        monthText2.setVisibility(View.INVISIBLE);
                    }
                }
            }
        });

        createReminderButton.setOnClickListener(new View.OnClickListener() {
            @Override
            // Return all inputted values.
            public void onClick(View view) {
                Intent returnIntent = new Intent();

                String reminderName = "", recurring = "", advanced = "";

                // Enter all the retrieved strings.
                reminderName = reminderNameField.getText().toString();
                // String TDSelected.
                if (!timeSpinner.getSelectedItem().toString().equals("-")){
                    if (buttonPressed.equals("daily")) {
                        recurring = timeSpinner.getSelectedItem().toString() + " hours";
                    }
                    else{
                        recurring = timeSpinner.getSelectedItem().toString() + " days";
                    }
                }
                else{
                    recurring = "X";
                }
                if (!repeatSpinner.getSelectedItem().toString().equals("-")){
                    if (buttonPressed.equals("daily")){
                        advanced = repeatSpinner.getSelectedItem().toString() + " days";
                    }
                    else if (buttonPressed.equals("weekly")){
                        advanced = repeatSpinner.getSelectedItem().toString() + " weeks";
                    }
                    else if (buttonPressed.equals("monthly")){
                        advanced = repeatSpinner.getSelectedItem().toString() + " months";
                    }
                }
                else{
                    advanced = "X";
                }

                returnIntent.putExtra("name", reminderName);
                returnIntent.putExtra("TD", TDSelected);
                returnIntent.putExtra("recurring", recurring);
                returnIntent.putExtra("advanced", advanced);

                setResult(Activity.RESULT_OK,returnIntent);
                finish();
            }
        });

    }

    public void TDPicker(View v){
        // Build initial dialog for the 'Time/Date' picker button.
        AlertDialog.Builder addDialog = new AlertDialog.Builder(this);
        LayoutInflater inflater = this.getLayoutInflater();
        View dialogView = inflater.inflate(R.layout.time_date_picker, null);

        // Widget instantiation.
        timePicker = (TimePicker) dialogView.findViewById(R.id.timePicker);
        datePicker = (DatePicker) dialogView.findViewById(R.id.datePicker);

        // Fill in the details for the 'Time/Date' picker button.
        if (buttonPressed.equals("daily")) {
            addDialog.setTitle("PICK A TIME");
            datePicker.setVisibility(View.INVISIBLE);
        }
        else if (buttonPressed.equals("weekly")){
            addDialog.setTitle("PICK A DAY");
            dialogView = inflater.inflate(R.layout.day_of_week_picker, null);

            // Widget instantiations.
            sunCircle = (ImageView) dialogView.findViewById(R.id.sundayCircle);
            monCircle = (ImageView) dialogView.findViewById(R.id.mondayCircle);
            tuesCircle = (ImageView) dialogView.findViewById(R.id.tuesdayCircle);
            wedCircle = (ImageView) dialogView.findViewById(R.id.wednesdayCircle);
            thursCircle = (ImageView) dialogView.findViewById(R.id.thursdayCircle);
            friCircle = (ImageView) dialogView.findViewById(R.id.fridayCircle);
            satCircle = (ImageView) dialogView.findViewById(R.id.saturdayCircle);

            sun = (TextView) dialogView.findViewById(R.id.sunday);
            mon = (TextView) dialogView.findViewById(R.id.monday);
            tues = (TextView) dialogView.findViewById(R.id.tuesday);
            wed = (TextView) dialogView.findViewById(R.id.wednesday);
            thurs = (TextView) dialogView.findViewById(R.id.thursday);
            fri = (TextView) dialogView.findViewById(R.id.friday);
            sat = (TextView) dialogView.findViewById(R.id.saturday);

            sunCircle.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    setAllCircleColors();
                    sunCircle.setColorFilter(Color.parseColor("#FF96F5F1"));
                    sunT = true;
                }
            });
            monCircle.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    setAllCircleColors();
                    monCircle.setColorFilter(Color.parseColor("#FF96F5F1"));
                    monT = true;
                }
            });
            tuesCircle.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    setAllCircleColors();
                    tuesCircle.setColorFilter(Color.parseColor("#FF96F5F1"));
                    tuesT = true;
                }
            });
            wedCircle.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    setAllCircleColors();
                    wedCircle.setColorFilter(Color.parseColor("#FF96F5F1"));
                    wedT = true;
                }
            });
            thursCircle.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    setAllCircleColors();
                    thursCircle.setColorFilter(Color.parseColor("#FF96F5F1"));
                    thursT = true;
                }
            });
            friCircle.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    setAllCircleColors();
                    friCircle.setColorFilter(Color.parseColor("#FF96F5F1"));
                    friT = true;
                }
            });
            satCircle.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    setAllCircleColors();
                    satCircle.setColorFilter(Color.parseColor("#FF96F5F1"));
                    satT = true;
                }
            });
        }
        else if (buttonPressed.equals("monthly")){
            addDialog.setTitle("PICK A DATE");
            timePicker.setVisibility(View.INVISIBLE);
        }
        addDialog.setView(dialogView)
                .setPositiveButton("Add", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int whichButton) {
                        // If the 'buttonPressed' value is daily, adjust the time accordingly.
                        if (buttonPressed.equals("daily")){
                            String hour = "", minute = "", ampm = "";
                            int hourValue = timePicker.getHour();
                            int minValue = timePicker.getMinute();
                            if (hourValue > 12){
                                ampm = "PM";
                                hourValue = hourValue - 12;
                                hour = Integer.toString(hourValue);
                            }
                            else if (hourValue == 0){
                                ampm = "AM";
                                hourValue = 12;
                                hour = Integer.toString(hourValue);
                            }
                            else{
                                ampm = "AM";
                                hour = Integer.toString(hourValue);
                            }
                            if (minValue < 10){
                                minute = "0" + Integer.toString(minValue);
                            }
                            else{
                                minute = Integer.toString(minValue);
                            }
                            selectedTime.setText(hour + ":" + minute + " " + ampm);
                            TDSelected = hour + ":" + minute + " " + ampm;
                        }
                        else if (buttonPressed.equals("weekly")){
                            if (sunT){
                                selectedTime.setText("Sunday");
                                TDSelected = "Sunday";
                            }
                            else if (monT){
                                selectedTime.setText("Monday");
                                TDSelected = "Monday";
                            }
                            else if (tuesT){
                                selectedTime.setText("Tuesday");
                                TDSelected = "Tuesday";
                            }
                            else if (wedT){
                                selectedTime.setText("Wednesday");
                                TDSelected = "Wednesday";
                            }
                            else if (thursT){
                                selectedTime.setText("Thursday");
                                TDSelected = "Thursday";
                            }
                            else if (friT){
                                selectedTime.setText("Friday");
                                TDSelected = "Friday";
                            }
                            else if (satT){
                                selectedTime.setText("Saturday");
                                TDSelected = "Saturday";
                            }
                        }
                        else if (buttonPressed.equals("monthly")){
                            String month = "", day = "", year = "";
                            switch(datePicker.getMonth()){
                                case 0: month = "January";
                                    break;
                                case 1: month = "February";
                                    break;
                                case 2: month = "March";
                                    break;
                                case 3: month = "April";
                                    break;
                                case 4: month = "May";
                                    break;
                                case 5: month = "June";
                                    break;
                                case 6: month = "July";
                                    break;
                                case 7: month = "August";
                                    break;
                                case 8: month = "September";
                                    break;
                                case 9: month = "October";
                                    break;
                                case 10: month = "November";
                                    break;
                                case 11: month = "December";
                                    break;
                            }
                            day = Integer.toString(datePicker.getDayOfMonth());
                            year = Integer.toString(datePicker.getYear());
                            selectedTime.setText(month + " " + day + ", " + year);
                            TDSelected = month + " " + day + ", " + year;
                        }
                    }
                })
                .setNegativeButton("Cancel", null).show();
    }

    private void setAllCircleColors(){
        sunCircle.setColorFilter(Color.parseColor("#199fff"));
        sunT = false;
        monCircle.setColorFilter(Color.parseColor("#199fff"));
        monT = false;
        tuesCircle.setColorFilter(Color.parseColor("#199fff"));
        tuesT = false;
        wedCircle.setColorFilter(Color.parseColor("#199fff"));
        wedT = false;
        thursCircle.setColorFilter(Color.parseColor("#199fff"));
        thursT = false;
        friCircle.setColorFilter(Color.parseColor("#199fff"));
        friT = false;
        satCircle.setColorFilter(Color.parseColor("#199fff"));
        satT = false;
    }
}
