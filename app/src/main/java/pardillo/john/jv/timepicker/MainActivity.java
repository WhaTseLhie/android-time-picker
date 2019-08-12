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
    String hr, min;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.timePicked = this.findViewById(R.id.timePicker);
        this.findViewById(R.id.button).setOnClickListener(this);

        this.timePicked.setOnTimeChangedListener(this);

        hr = new SimpleDateFormat("hh", Locale.getDefault()).format(new Date());
        min = new SimpleDateFormat("mm", Locale.getDefault()).format(new Date());
        Toast.makeText(this, hr +":"+ min, Toast.LENGTH_LONG).show();
    }

    @Override
    public void onClick(View v) {
        Toast.makeText(this, hr +":"+ min, Toast.LENGTH_LONG).show();
    }

    @Override
    public void onTimeChanged(TimePicker view, int hourOfDay, int minute) {
        hr = "" + hourOfDay;
        min = "" + minute;
    }
}
