package com.example.wesleymagak.gymguru;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.util.Patterns;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 */
public class RegisterFragment extends Fragment implements View.OnClickListener {

    View view;
    EditText r_firstname,r_lastname,r_email,r_password,r_password2;
    TextView btn_goto_login;
    Button btn_register;

    public RegisterFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.fragment_register, container, false);

        r_firstname = view.findViewById(R.id.register_firstName);
        r_lastname = view.findViewById(R.id.register_lastName);
        r_email = view.findViewById(R.id.register_email);
        r_password = view.findViewById(R.id.register_password);
        r_password2 = view.findViewById(R.id.register_confirmPassword);

        btn_goto_login = view.findViewById(R.id.btn_goto_login);
        btn_register = view.findViewById(R.id.btn_register);

        btn_goto_login.setOnClickListener(this);
        btn_register.setOnClickListener(this);

        // Inflate the layout for this fragment
        return view;
    }

    @Override
    public void onClick(View view) {

        final FragmentManager loginFragmentManager = getActivity().getSupportFragmentManager();

        if(view == btn_goto_login){
            loginFragmentManager.beginTransaction().replace(R.id.login_content, new LoginFragment()).commit();
        }else if(view == btn_register){
            String f_name=r_firstname.getText().toString().trim();
            String l_name=r_lastname.getText().toString().trim();
            String email=r_email.getText().toString().trim();
            String pwd=r_password.getText().toString().trim();
            String pwd_2=r_password2.getText().toString().trim();
            String regex="^(?=\\\\S+$).{6,15}$";

            if(f_name.equals("") || l_name.equals("") || email.equals("") || pwd.equals("") || pwd_2.equals("")){
                Toast.makeText(getActivity(), "Please fill in all details!!!", Toast.LENGTH_SHORT).show();
            }else {
                if (!pwd.equals(pwd_2)){
                    Toast.makeText(getActivity(), "Passwords do not match!!!", Toast.LENGTH_SHORT).show();
                }  else {
                    if (Patterns.EMAIL_ADDRESS.matcher(email).matches()==false){
                        Toast.makeText(getActivity(), "Email address is not valid!!!", Toast.LENGTH_SHORT).show();
                    }else {
                        if (!pwd.matches(regex)){
                            Toast.makeText(getActivity(), "Invalid password!!! Read the password criteria.", Toast.LENGTH_SHORT).show();
                        }else {
                            Toast.makeText(getActivity(), "Good code!!!", Toast.LENGTH_SHORT).show();
                        }
                    }
                }
            }

        }

    }
}
