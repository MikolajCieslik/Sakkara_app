package com.example.sakkara;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

/**
 * A simple {@link Fragment} subclass.
 * create an instance of this fragment.
 */
public class menu_fragment extends Fragment {

    Button powrotGora;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        //return inflater.inflate(R.layout.fragment_menu, container, false);
        View view= inflater.inflate(R.layout.fragment_menu, container, false);

        powrotGora = (Button) view.findViewById(R.id.gora);
        powrotGora.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.Fragment_container,
                        new menu_fragment()).commit();
            }
        });
        return view;    }
}
