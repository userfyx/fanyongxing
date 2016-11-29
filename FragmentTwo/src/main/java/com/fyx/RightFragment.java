package com.fyx;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class RightFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_right, container, false);
        TextView tv= (TextView) view.findViewById(R.id.tv);

        Bundle bundle = getArguments();

        String string = bundle.getString("one");
       tv.setText(string);


        return view;
    }


}
