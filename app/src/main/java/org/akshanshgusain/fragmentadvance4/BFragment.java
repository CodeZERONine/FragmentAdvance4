package org.akshanshgusain.fragmentadvance4;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

public class BFragment extends Fragment{
    //Wigets
    private TextView mDissplayMessage;
    //Variables
    private IMainActivity iMainActivity;
    private String mIncommingMessage="klll";
    @Override


    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        iMainActivity.setToolbarTitle(getTag());
        Bundle bundle=this.getArguments();
        if(bundle!=null){
            Toast.makeText(this.getActivity(), "bundle !=null " , Toast.LENGTH_SHORT).show();
            mIncommingMessage=bundle.getString(getString(R.string.intent_message));
            Toast.makeText(this.getActivity(), mIncommingMessage, Toast.LENGTH_SHORT).show();
        }
    }

    @Nullable

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_b,container,false);
        mDissplayMessage=view.findViewById(R.id.incoming_message);
        setIncomingMessage();
        return view;
    }
    public void setIncomingMessage(){

         if(mIncommingMessage!=null){
             Toast.makeText(this.getActivity(), mIncommingMessage, Toast.LENGTH_SHORT).show();
              mDissplayMessage.setText(mIncommingMessage);
         }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        iMainActivity=(IMainActivity)getActivity();
    }
}
