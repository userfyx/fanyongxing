package com.fyx;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    //implements LeftFragment.CallBackLeftFragment
    private TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        tv = (TextView) findViewById(R.id.tv);

//        FragmentManager manager = getFragmentManager();
//        FragmentTransaction beginTransaction = manager.beginTransaction();
//        beginTransaction.add(R.id., new LeftFragment());
//        beginTransaction.commit();
    }
//    @Override
//    public void dataHand(String s) {
//        if (!TextUtils.isEmpty(s)) {
//            tv.setText(s);
//        }
//    }
}
