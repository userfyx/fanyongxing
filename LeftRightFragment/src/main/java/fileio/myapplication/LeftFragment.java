package fileio.myapplication;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;


public class LeftFragment extends Fragment implements View.OnClickListener {

    private Button add;
    private Button replace;
    private Button remove;
    private Button hide;
    private FragmentManager fragmentManager;
    private FragmentTransaction fragmentTransaction;
    private static final String TAG = LeftFragment.class.getSimpleName();

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        Log.i(TAG, "onAttach");
    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.i(TAG, "onCreate");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_left, container, false);
        //FragmentManager管理者
        fragmentManager = getFragmentManager();

        add = (Button) view.findViewById(R.id.add);
        add.setOnClickListener(this);
        replace = (Button) view.findViewById(R.id.replace);
        replace.setOnClickListener(this);
        remove = (Button) view.findViewById(R.id.remove);
        remove.setOnClickListener(this);
        hide = (Button) view.findViewById(R.id.hide);
        hide.setOnClickListener(this);

        Log.i(TAG, "onCreateView");

        //传值
        EditText input= (EditText)view.findViewById(R.id.input_left);
        String content=input.getText().toString();
        Bundle bundle=new Bundle();
        bundle.putString("content",content);
        LeftFragment leftFragment =new LeftFragment();
        leftFragment.setArguments(bundle);

        return view;
    }


    @Override
    public void onClick(View view) {
        //Fragment事物
        fragmentTransaction = fragmentManager.beginTransaction();
        switch(view.getId()){
            case R.id.add:
                //添加
                AddFragment addFragment =new AddFragment();
                fragmentTransaction.add(R.id.fragments_left,addFragment);
                break;
            case R.id.replace:
                //替换
                ReplaceFragment fragment_replace =new ReplaceFragment();
                fragmentTransaction.replace(R.id.fragments_left,fragment_replace);
                break;
            case R.id.remove:
                //移除
                AddFragment fragment_add_remove =new AddFragment();
                fragmentTransaction.remove(fragment_add_remove);

                ReplaceFragment fragment_replace_remove =new ReplaceFragment();
                fragmentTransaction.remove(fragment_replace_remove);
                break;
            case R.id.hide:
                //隐藏
                AddFragment fragment_add_hide =new AddFragment();
                fragmentTransaction.hide(fragment_add_hide);

                ReplaceFragment fragment_replace_hide =new ReplaceFragment();
                fragmentTransaction.hide(fragment_replace_hide);
                break;
        }
        //提交
        fragmentTransaction.commit();
    }
    @Override
    public void onDestroy() {
        Log.i(TAG, "onDestroy");
        super.onDestroy();
    }

    @Override
    public void onDetach() {
        Log.i(TAG, "onDetach");
        super.onDetach();
    }

    @Override
    public void onDestroyView() {
        Log.i(TAG, "onDestroyView");
        super.onDestroyView();
    }

    @Override
    public void onStart() {
        Log.i(TAG, "onStart");
        super.onStart();
    }

    @Override
    public void onStop() {
        Log.i(TAG, "onStop");
        super.onStop();
    }

    @Override
    public void onResume() {
        Log.i(TAG, "onResume");
        super.onResume();
    }

    @Override
    public void onPause() {
        Log.i(TAG, "onPause");
        super.onPause();
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        Log.i(TAG, "onActivityCreated");
        super.onActivityCreated(savedInstanceState);
    }
}
