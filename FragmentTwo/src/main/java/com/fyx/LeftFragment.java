package com.fyx;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;


public class LeftFragment extends Fragment {
    private EditText et;
    private Button bt;
    //CallBackLeftFragment callBackLeftFragment;
//    @Override
//    public void onAttach(Activity activity) {
//        super.onAttach(activity);
//        callBackLeftFragment = (CallBackLeftFragment) activity;
//    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view=  inflater.inflate(R.layout.fragment_left, container, false);
        bt = (Button) view.findViewById(R.id.send);
        et = (EditText) view.findViewById(R.id.input);
        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s= et.getText().toString();
                //callBackLeftFragment.dataHand(s);
                LeftFragment blankFragment = new LeftFragment();
                Bundle bundle = new Bundle();
                bundle.putString("one", s);
                blankFragment.setArguments(bundle);
                getFragmentManager().beginTransaction().replace(R.id.container, blankFragment).addToBackStack(null).commit();

            }
        });
        return view;
    }

//    public interface CallBackLeftFragment {
//        public  void    dataHand(String s);
//    }
    //    public  void  onclick(View view) {
    //       String s= et.getText().toString();
    //        callBackFragmentA.dataHand(s);
    //    }
}
