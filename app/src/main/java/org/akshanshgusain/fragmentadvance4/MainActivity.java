package org.akshanshgusain.fragmentadvance4;

import android.media.AudioFocusRequest;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements IMainActivity {
    private TextView textview;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textview=(TextView)findViewById(R.id.toolbar_title);

        init();
    }

    private void init() {
        SelectorFragment fragment=new SelectorFragment();
        doFragmentTransaction(fragment,getString(R.string.fragment_selector),false,"");
    }

    private void doFragmentTransaction(Fragment fragment, String tag, boolean addToBackStack, String s) {
        FragmentTransaction transaction=getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.main_container,fragment,tag);

        if(!s.equals(" ")){
            Bundle bundle=new Bundle();
            bundle.putString(getString(R.string.intent_message),s);
            Toast.makeText(this, s, Toast.LENGTH_SHORT).show();
            fragment.setArguments(bundle);
        }

        if(addToBackStack){
            transaction.addToBackStack(tag);
        }
        transaction.commit();
    }

    @Override
    public void setToolbarTitle(String fragmentTag) {
        textview.setText(fragmentTag);
    }

    @Override
    public void inflateFragment(String fragmentTag, String message) {
        if(fragmentTag.equals(getString(R.string.fragment_a))){
            AFragment fragment=new AFragment();
            doFragmentTransaction(fragment,fragmentTag,true,message);
        }
        else   if(fragmentTag.equals(getString(R.string.fragment_b))){
            BFragment fragment=new BFragment();
            doFragmentTransaction(fragment,fragmentTag,true,message);
        }
        else   if(fragmentTag.equals(getString(R.string.fragment_c))){
          CFragment fragment=new CFragment();
            doFragmentTransaction(fragment,fragmentTag,true,message);
      }
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        textview.setText(getString(R.string.fragment_selector));
    }
}
