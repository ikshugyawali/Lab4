package tbc.dma.lab4codingchallenge;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class ScrollingActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scrolling);
        Intent intent = getIntent();
        TextView textView = findViewById(R.id.text_passage);
        String message = intent.getStringExtra((MainActivity.EXTRA_MESSAGE));
        textView.setText(message);
    }
}