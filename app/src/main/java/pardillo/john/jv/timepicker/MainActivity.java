package pardillo.john.jv.timepicker;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TimePicker;
import android.widget.Toast;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, TimePicker.OnTimeChangedListener {

    private TimePicker timePicked;
    private String hr, min;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.timePicked = this.findViewById(R.id.timePicker);
        this.findViewById(R.id.button).setOnClickListener(this);
        this.timePicked.setOnTimeChangedListener(this);
        this.timePicked.setIs24HourView(true);

        hr = new SimpleDateFormat("hh", Locale.getDefault()).format(new Date());
        min = new SimpleDateFormat("mm", Locale.getDefault()).format(new Date());
    }

    @Override
    public void onClick(View v) {
        String time = toRegularTime(Integer.parseInt(hr), Integer.parseInt(min));
        Toast.makeText(this, "Time: " +time, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onTimeChanged(TimePicker view, int hourOfDay, int minute) {
        hr = "" + hourOfDay;
        min = "" + minute;
    }

    private String toRegularTime(int hour, int min) {
        String format;
        if(hour == 0) {
            hour += 12;
            format = "AM";
        } else if(hour == 12) {
            format = "PM";
        } else if(hour > 12) {
            hour -= 12;
            format = "PM";
        } else {
            format = "AM";
        }

        return ((hour<10)?"0"+hour:""+hour) +":"+ ((min<10)?"0"+min:""+min) +" "+ format;
    }
}