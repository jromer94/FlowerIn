package com.jromer.flowerin.app;



import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


/**
 * A simple {@link android.support.v4.app.Fragment} subclass.
 *
 */
public class ConfirmOrdrFragment extends Fragment {


    public ConfirmOrdrFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        Typeface type = Typeface.createFromAsset(getActivity().getAssets(), "fonts/champagne_limousines.ttf");

        View view = inflater.inflate(R.layout.fragment_confirm_ordr, container, false);
        TextView textView =(TextView)view.findViewById(R.id.confirmation);
        textView.setTypeface(type);
        return view;
    }


}
