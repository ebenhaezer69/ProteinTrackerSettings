package com.example.proteintracker;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Mahasiswa1Fragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Mahasiswa1Fragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    SendMessage sms;

    public Mahasiswa1Fragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Mahasiswa1Fragment.
     */
    // TODO: Rename and change types and number of parameters
    public static Mahasiswa1Fragment newInstance(String param1, String param2) {
        Mahasiswa1Fragment fragment = new Mahasiswa1Fragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);


        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_mahasiswa1, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        TextView txtNama = getView().findViewById(R.id.textView5);
        txtNama.setText(mParam1 + ","+ mParam2);

        Button btnPassData = (Button) view.findViewById(R.id.btnSimpan);
        btnPassData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sms.SendData("Nice");
            }
        });
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        try{
            sms = (Mahasiswa1Fragment.SendMessage) getActivity();
        } catch (ClassCastException e){
            throw new ClassCastException("Error in retrieving data. Please try agaim");
        }
    }

    interface SendMessage{
        void SendData (String Message);
    }
}