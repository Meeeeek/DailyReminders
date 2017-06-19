package michaelkim.dailyreminders;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class addReminder extends AppCompatActivity {

    TextView reminderTD;
    Button reminderTDButton;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_reminder);

        // Grab the value for what button was pressed from the home screen.
        Intent intent = getIntent();
        String buttonPressed = intent.getStringExtra("key");

        // Widget instantiation.
        reminderTD = (TextView) findViewById(R.id.reminderTD);
        reminderTDButton = (Button) findViewById(R.id.reminderTDButton);
        if (buttonPressed.equals("Daily")){
            reminderTD.setText("Time :");
            reminderTDButton.setText("Pick a Time");
        }

        // Build initial dialog for the 'Time/Date' picker button.
        AlertDialog.Builder addDialog = new AlertDialog.Builder(this);
        LayoutInflater inflater = this.getLayoutInflater();
        final View dialogView = inflater.inflate(R.layout.time_date_picker, null);

        // Fill in the details for the 'Time/Date' picker button.
        addDialog.setTitle("Pick a Time/Date");
        addDialog.setView(dialogView)
                .setPositiveButton("Add", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int whichButton) {

                    }
                })
                .setNegativeButton("Cancel", null).show();
    }
}
