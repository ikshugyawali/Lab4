package tbc.dma.twoactivities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private static final String LOG_TAG = MainActivity.class.getSimpleName();

    public static final String EXTRA_MESSAGE = "Hello";

    public static final int TEXT_REQUEST = 1;

    private EditText mMessageEditText;

    private TextView mReplyHeadTextView;
    private TextView mReplyTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mMessageEditText = findViewById(R.id.sendText);

        Intent t=getIntent();
        String message = t.getStringExtra(ReciveActivity.EXTRA_REPLY);

        mReplyHeadTextView = findViewById(R.id.text_header_reply);
        mReplyTextView = findViewById(R.id.text_message_reply);

        mReplyTextView.setText(message);
    }

    public void launchSecondActivity(View view) {
        Log.d(LOG_TAG, "Button Clicked!");
        Intent i =new Intent(MainActivity.this,ReciveActivity.class);
        String message=mMessageEditText.getText().toString();
        i.putExtra(EXTRA_MESSAGE,message);
        startActivityForResult(i, TEXT_REQUEST);
    }


   @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

       if (requestCode == TEXT_REQUEST) {
          if (resultCode == RESULT_OK) {
               String reply = data.getStringExtra(ReciveActivity.EXTRA_REPLY);

             mReplyHeadTextView.setVisibility(View.VISIBLE);

                mReplyTextView.setText(reply);
                mReplyTextView.setVisibility(View.VISIBLE);
            }
        }
    }
}