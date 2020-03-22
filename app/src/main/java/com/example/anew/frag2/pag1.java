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

public class pag1 extends Fragment
{
    Button b1,b2;
    String email,pword;
    EditText et1,et2;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState)
    {
        View v=inflater.inflate(R.layout.pag1,container,false);
        et1=v.findViewById(R.id.et1);
        et2=v.findViewById(R.id.et2);
        b1=v.findViewById(R.id.b1);
        b2=v.findViewById(R.id.b2);
        SharedPreferences spf = getActivity().getSharedPreferences("myprf", Context.MODE_PRIVATE);
        email = spf.getString("email", "no value");
        pword = spf.getString("pword", "no value");

            Toast.makeText(getActivity(), "email is" + email, Toast.LENGTH_LONG).show();
        b1.setOnClickListener(
                new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                if((et1.getText().toString()).equals(email)&&(et2.getText().toString()).equals(pword))
                {

                    Toast.makeText(getActivity(),"logged in",Toast.LENGTH_LONG).show();
                    FragmentManager fm = getFragmentManager();
                    FragmentTransaction ft = fm.beginTransaction();
                    ft.replace(R.id.fr1, new login());
                    ft.commit();
                }
                else
                {
                    Toast.makeText(getActivity(),"Invalid User",Toast.LENGTH_LONG).show();
                }
            }
        });
        b2.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                FragmentManager fm1=getFragmentManager();
                FragmentTransaction ft1=fm1.beginTransaction();
                ft1.replace(R.id.fr1,new register());
                ft1.commit();
            }
        });
        return v;
    }

}
