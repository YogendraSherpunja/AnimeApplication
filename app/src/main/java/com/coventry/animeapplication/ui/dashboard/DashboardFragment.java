package com.coventry.animeapplication.ui.dashboard;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.coventry.animeapplication.R;
import com.coventry.animeapplication.ui.model.AnimeCharacters;

import java.util.ArrayList;
import java.util.List;

public class DashboardFragment extends Fragment {

    private DashboardViewModel dashboardViewModel;



    Button btnSave;
    EditText name,age,address;
    RadioGroup Gender;
    RadioButton Male,Female,Others;
    String uname,uage,uaddress,ugender;
    public static List<AnimeCharacters> characters=new ArrayList<>();

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle btnSavedInstanceState) {
        dashboardViewModel =
                ViewModelProviders.of(this).get(DashboardViewModel.class);
        View root = inflater.inflate(R.layout.fragment_dashboard, container, false);

        btnSave=root.findViewById(R.id.btn_btnSave);
        name=root.findViewById(R.id.et_name);
        age=root.findViewById(R.id.et_age);
        address=root.findViewById(R.id.et_address);
        Gender=root.findViewById(R.id.rg_gender);
        Male=root.findViewById(R.id.rb_male);
        Female=root.findViewById(R.id.rb_female);
        Others=root.findViewById(R.id.rb_others);


        dashboardViewModel.getText().observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {

                Gender.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(RadioGroup radioGroup, int i) {
                        if(i==R.id.rb_male){
                            ugender="Male";

                        }
                        if(i==R.id.rb_female){
                            ugender="Female";

                        }
                        if(i==R.id.rb_others){
                            ugender="Others";

                        }
                    }
                });

                btnSave.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        uname=name.getText().toString();
                        uage=age.getText().toString();
                        uaddress=address.getText().toString();
                        if (validate()) {
                            characters.add(new AnimeCharacters(uage, uname, uaddress, ugender));
                            Toast.makeText(getContext(), "btnSaved successfully", Toast.LENGTH_SHORT).show();

                            name.setText(null);
                            age.setText(null);
                            address.setText(null);

                        }
                    }
                });



            }
        });
        return root;
    }
    public boolean validate(){
        if (TextUtils.isEmpty(uname)){
            name.setError("please enter your Full name");
            name.requestFocus();
            return false;
        }

        if (TextUtils.isEmpty(uage)){
            age.setError("please enter your age");
            age.requestFocus();
            return false;
        }
        if (TextUtils.isEmpty(uaddress)){
            address.setError("please enter your address");
            address.requestFocus();
            return false;
        }

        if (TextUtils.isEmpty(ugender)){
            Toast.makeText(getContext(), "please select your gender ", Toast.LENGTH_SHORT).show();
            return false;
        }


        return true;
    }

    }
