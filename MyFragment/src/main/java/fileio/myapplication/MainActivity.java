package fileio.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.btn_static).setOnClickListener(this);

        findViewById(R.id.btn_dongtai).setOnClickListener(this);
    }

    @Override

    public void onClick(View v) {

        switch (v.getId()){

            case R.id.btn_static:

                //跳转到第二个活动，使第二活动完成静态加载fragment

                startActivity(new Intent(MainActivity.this,Main2Activity.class));

                break;

            case R.id.btn_dongtai:

                //声明我们自定义的fragment

                MFragment2 fragment2=new MFragment2();

                //动态添加到布局中，注意replace中的第一个参数为activity_main中的id

                getSupportFragmentManager().beginTransaction().replace(R.id.container,fragment2).commit();

                break;

        }

    }


}
