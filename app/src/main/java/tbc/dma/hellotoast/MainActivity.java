package tbc.dma.hellotoast;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private int mCount=0;
    private TextView mShowCount;
    public static final String EXTRA_MESSAGE ="MESSAGE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mShowCount=(TextView) findViewById(R.id.showCount);
    }

    public void showToast(View view) {
        Intent intent = new Intent(MainActivity.this, SecondActivity.class);
        String message = Integer.toString(mCount);
        intent.putExtra(EXTRA_MESSAGE, message);
        startActivity(intent);
    }

    public void countUp(View view) {
        mCount++;
        if (mShowCount!= null)
            mShowCount.setText(Integer.toString(mCount));
    }
}