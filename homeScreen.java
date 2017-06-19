package michaelkim.dailyreminders;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

public class homeScreen extends AppCompatActivity {

    // Widget Declaration.
    Button dailyButton, monthlyButton, yearlyButton;
    ListView reminderList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_screen);

        // Widget Instantiation.
        reminderList = (ListView) findViewById(R.id.reminderList);
        dailyButton = (Button) findViewById(R.id.dailyButton);
        monthlyButton = (Button) findViewById(R.id.monthlyButton);
        yearlyButton = (Button) findViewById(R.id.yearlyButton);
    }

    // When any of the three buttons are pressed, move to the 'addReminder' screen.
    public void addReminderD(View v){
        Intent intent = new Intent(this, addReminder.class);
        String daily = "daily";
        intent.putExtra("key", daily);
        startActivityForResult(intent, 1);
    }

    public void addReminderM(View v){
        Intent intent = new Intent(this, addReminder.class);
        startActivityForResult(intent, 2);
    }

    public void addReminderY(View v){
        Intent intent = new Intent(this, addReminder.class);
        startActivityForResult(intent, 3);
    }

}
