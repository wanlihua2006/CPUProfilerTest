package com.example.wanlihua.cpuprofilertest;

import android.os.Debug;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import static java.lang.Thread.sleep;

public class MainActivity extends AppCompatActivity {
    private static Button btn;
    private /*static*/ Object inner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Debug.startMethodTracing();
        initView();
        btn = findViewById(R.id.button);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)s {
                createInnerClass();
                finish();
            }
        });


    }

    private void createInnerClass() {
        class InnerClass {
        }
        inner = new InnerClass();
    }

    @Override
    protected void onStop() {
        super.onStop();
        Debug.stopMethodTracing();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        btn = null;
    }

    private void initView() {
//        try {
//            sleep(2000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
    }
}
