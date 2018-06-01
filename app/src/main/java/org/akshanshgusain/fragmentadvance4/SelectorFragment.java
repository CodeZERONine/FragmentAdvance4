package org.akshanshgusain.fragmentadvance4;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.fragment.*;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SelectorFragment extends Fragment implements View.OnClickListener {

    private IMainActivity iMainActivity;
    //variables
    private String temp;

    //Widgets
    private Button BtnFragmentA, BtnFragmentB, BtnFragmentC;
    private EditText mMessage;

    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //getTag() will get tag associated with the fragment at the time of instantiation
        iMainActivity.setToolbarTitle(getTag());

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_selector, container, false);
        mMessage = view.findViewById(R.id.message);
        temp=mMessage.getText().toString();
        Toast.makeText(this.getActivity(), temp, Toast.LENGTH_SHORT).show();
        BtnFragmentA = (Button) view.findViewById(R.id.btn_fragment_a);
        BtnFragmentB = (Button) view.findViewById(R.id.btn_fragment_b);
        BtnFragmentC = (Button) view.findViewById(R.id.btn_fragment_c);
        BtnFragmentA.setOnClickListener(this);
        BtnFragmentB.setOnClickListener(this);
        BtnFragmentC.setOnClickListener(this);


        return view;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        iMainActivity = (IMainActivity) getActivity();
    }

    @Override
    public void onClick(View v) {
        temp=mMessage.getText().toString();
        switch (v.getId()) {
            case R.id.btn_fragment_a: {
                iMainActivity.inflateFragment(getString(R.string.fragment_a),temp);
                break;
            }
            case R.id.btn_fragment_b: {
                iMainActivity.inflateFragment(getString(R.string.fragment_b),temp);
                break;
            }
            case R.id.btn_fragment_c: {
                iMainActivity.inflateFragment(getString(R.string.fragment_c),temp);
                break;
            }
        }
    }
}
