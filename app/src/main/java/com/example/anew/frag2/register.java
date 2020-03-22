package com.example.anew.frag2;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class register extends Fragment
{
    EditText etr1,etr2,etr3,etr4;
    Button br1;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState)
    {
        View v=inflater.inflate(R.layout.register,container,false);
        etr1=v.findViewById(R.id.etr1);
        etr2=v.findViewById(R.id.etr2);
        etr3=v.findViewById(R.id.etr3);
        etr4=v.findViewById(R.id.etr4);
        br1=v.findViewById(R.id.br1);


        br1.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                SharedPreferences spf=getActivity().getSharedPreferences("myprf", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor= spf.edit();
                editor.putString("email",etr1.getText().toString());
                editor.putString("pword",etr2.getText().toString());
                editor.putString("mno",etr3.getText().toString());
                editor.putString("dob",etr4.getText().toString());
                editor.commit();
                Toast.makeText(getActivity(),"Registered succesfully",Toast.LENGTH_LONG).show();
                FragmentManager fm=getFragmentManager();
                FragmentTransaction ft=fm.beginTransaction();
                ft.replace(R.id.fr1,new pag1());
                ft.commit();
            }
        });
        return v;
    }

}
