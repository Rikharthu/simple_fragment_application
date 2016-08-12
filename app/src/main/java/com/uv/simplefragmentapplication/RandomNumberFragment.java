package com.uv.simplefragmentapplication;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

public class RandomNumberFragment extends Fragment {

    public interface onRandomButtonClickListener{
        void onButtonClick();
    }

    private onRandomButtonClickListener mListener;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.random_number_fragment,container,false);

        mListener= (onRandomButtonClickListener) getActivity();

        final TextView textView = (TextView) view.findViewById(R.id.randomNumberLabel);

        Button button = (Button) view.findViewById(R.id.randomNumberButton);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mListener.onButtonClick();
                Random rnd = new Random();
                textView.setText((rnd.nextInt(100)+1)+"");
            }
        });
        return view;
    }
}
