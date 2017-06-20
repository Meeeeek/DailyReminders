package michaelkim.dailyreminders;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class homeScreen extends AppCompatActivity {

    // Global ArrayList.
    ArrayList<Reminder> reminderArrayList = new ArrayList<>();
    reminderAdapter reminderAdapter;

    // Widget Declaration.
    Button dailyButton, weeklyButton, monthlyButton;
    ListView reminderList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_screen);

        // Widget Instantiation.
        reminderList = (ListView) findViewById(R.id.reminderList);
        dailyButton = (Button) findViewById(R.id.dailyButton);
        weeklyButton = (Button) findViewById(R.id.weeklyButton);
        monthlyButton = (Button) findViewById(R.id.monthlyButton);

        // ListView instantiation.
        reminderAdapter = new reminderAdapter();
        reminderList.setAdapter(reminderAdapter);
    }

    // When any of the three buttons are pressed, move to the 'addReminder' screen.
    public void addReminderD(View v){
        Intent intent = new Intent(this, addReminder.class);
        String daily = "daily";
        intent.putExtra("key", daily);
        startActivityForResult(intent, 1);
    }

    public void addReminderW(View v){
        Intent intent = new Intent(this, addReminder.class);
        String weekly = "weekly";
        intent.putExtra("key", weekly);
        startActivityForResult(intent, 2);
    }

    public void addReminderM(View v){
        Intent intent = new Intent(this, addReminder.class);
        String monthly = "monthly";
        intent.putExtra("key", monthly);
        startActivityForResult(intent, 3);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == 1){
            if (resultCode == Activity.RESULT_OK){
                String name = data.getStringExtra("name");
                String td = data.getStringExtra("TD");
                String recurring = data.getStringExtra("recurring");
                String advanced = data.getStringExtra("advanced");

                reminderArrayList.add(new Reminder(name, td, recurring, advanced));
                Log.e("hi", name + " " + td + " " + recurring + " " + advanced);
                reminderAdapter.notifyDataSetChanged();
            }
        }
        if (requestCode == 2){
            if (resultCode == Activity.RESULT_OK){
                String name = data.getStringExtra("name");
                String td = data.getStringExtra("TD");
                String recurring = data.getStringExtra("recurring");
                String advanced = data.getStringExtra("advanced");

                reminderArrayList.add(new Reminder(name, td, recurring, advanced));
                Log.e("hi", name + " " + td + " " + recurring + " " + advanced);
                reminderAdapter.notifyDataSetChanged();
            }
        }
        if (requestCode == 3){
            if (resultCode == Activity.RESULT_OK){
                String name = data.getStringExtra("name");
                String td = data.getStringExtra("TD");
                String recurring = data.getStringExtra("recurring");
                String advanced = data.getStringExtra("advanced");

                reminderArrayList.add(new Reminder(name, td, recurring, advanced));
                Log.e("hi", name + " " + td + " " + recurring + " " + advanced);
                reminderAdapter.notifyDataSetChanged();
            }
        }
    }

    private class reminderAdapter extends BaseAdapter {

        @Override
        public int getCount() {
            return reminderArrayList.size();
        }

        @Override
        public Object getItem(int i) {
            return null;
        }

        @Override
        public long getItemId(int i) {
            return 0;
        }

        @Override
        public View getView(final int i, View view, ViewGroup viewGroup) {
            view = getLayoutInflater().inflate(R.layout.reminder_listview, null);

            CheckBox reminderNameLV = (CheckBox) view.findViewById(R.id.reminderNameLV);
            TextView TDLV = (TextView) view.findViewById(R.id.TDLV);
            TextView recurringLV = (TextView) view.findViewById(R.id.recurringLV);
            TextView advancedLV = (TextView) view.findViewById(R.id.advancedLV);
            Button deleteReminderLV = (Button) view.findViewById(R.id.deleteReminderLV);

            reminderNameLV.setText(reminderArrayList.get(i).name);
            TDLV.setText(reminderArrayList.get(i).TD);
            recurringLV.setText(reminderArrayList.get(i).constantNoti);
            advancedLV.setText(reminderArrayList.get(i).repeatNoti);

            return view;
        }
    }
}
