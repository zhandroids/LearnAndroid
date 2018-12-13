package com.mine.zhuo.learnandroid;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Arrays;

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

        byte[] bb = new byte[]{};


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                textView.scrollBy(10,10);

//                startActivity(new Intent(getApplication(),EventActivity.class));
//                startActivity(new Intent(getApplication(),ScrollerActivity.class));
//                startActivity(new Intent(getApplication(), ImageActivity.class));
                startActivity(new Intent(getApplication(), LoaderActivity.class));
//                int arrays[] = {48, 80, 79, 79,82, 148, 155};
//                test(arrays);

            }
        });

    }

    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
    }

    public static int MAX_DIFF = 5;

    public void test(int arrays[]) {
        int maxLength = 0;

        for (int i = 0; i < arrays.length - 1; i++) {
            if (Math.abs(arrays[i] - arrays[i + 1]) <= MAX_DIFF) {
                maxLength++;
            } else {
                Log.e("asker","长度"+maxLength);
                test(Arrays.copyOfRange(arrays,i+1,arrays.length-1));

                return;
            }

        }

    }


}
