package tbc.dma.lab4codingchallenge;

import static android.provider.AlarmClock.EXTRA_MESSAGE;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    public static final String EXTRA_MESSAGE = "Text";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void launchTextActivity(View view) {
        Button btn = (Button) (view);
        String text = btn.getText().toString();
        Intent i = new Intent(MainActivity.this, ScrollingActivity.class);
        String message = "";
        if (text == getString(R.string.text_one)) {
            message = getString(R.string.text_one);
        } else if (text == getString(R.string.text_two))
            message = getString(R.string.text_two);
        else if (text == getString(R.string.text_three))
            message = getString(R.string.text_three);
        i.putExtra(EXTRA_MESSAGE, message);
        startActivity(i);
    }
}