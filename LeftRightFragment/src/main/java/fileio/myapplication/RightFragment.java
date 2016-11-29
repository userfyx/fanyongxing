package fileio.myapplication;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


public class RightFragment extends Fragment implements View.OnClickListener {

    private FragmentManager fragmentManager;
    private FragmentTransaction fragmentTransaction;
    private Button add;
    private Button replace;
    private Button remove;
    private Button hide;
    private static final String TAG = RightFragment.class.getSimpleName();

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

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_right, container);
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

        //接收值
//        TextView tv_right= (TextView) view.findViewById(R.id.tv_right);
//        String content = getArguments().getString("key");
//        tv_right.setText(content);

        return view;
    }

    @Override
    public void onClick(View view) {
        //Fragment事物
        fragmentTransaction = fragmentManager.beginTransaction();
        switch(view.getId()){
            case R.id.add:
                AddFragment addFragment =new AddFragment();
                fragmentTransaction.add(R.id.fragments_right,addFragment);
                break;
            case R.id.replace:
                ReplaceFragment fragment_replace =new ReplaceFragment();
                fragmentTransaction.replace(R.id.fragments_right,fragment_replace);
                break;
            case R.id.remove:
                AddFragment fragment_add_remove =new AddFragment();
                fragmentTransaction.remove(fragment_add_remove);

                ReplaceFragment fragment_replace_remove =new ReplaceFragment();
                fragmentTransaction.remove(fragment_replace_remove);
                break;
            case R.id.hide:
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
