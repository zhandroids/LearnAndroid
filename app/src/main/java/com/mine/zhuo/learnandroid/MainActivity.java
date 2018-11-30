package com.mine.zhuo.learnandroid;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    View rootView;
    TextView textView;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rootView = findViewById(R.id.root_view);
        textView = findViewById(R.id.text_view);
        button = findViewById(R.id.button);

        byte[] bb =new byte[]{};


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                textView.scrollBy(10,10);

//                startActivity(new Intent(getApplication(),EventActivity.class));
//                startActivity(new Intent(getApplication(),ScrollerActivity.class));
                startActivity(new Intent(getApplication(),ImageActivity.class));
            }
        });

    }

    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
    }
}
