package com.example.im.dialogfragment;

import android.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    FragmentManager manager=getFragmentManager();
    dialogFragment dialog = new dialogFragment();
    Button button;
    String fname="",address="";
    TextView text;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button= (Button) findViewById(R.id.button);
        button.setOnClickListener(this);
        text= (TextView) findViewById(R.id.text);


    }

    @Override
    public void onClick(View view) {

        int id=view.getId();
        switch (id) {
            case R.id.button: {
                dialog.show(manager, "YourDialog");
//                showtext();
                break;
            }
        }

        }

public void showtext(String fname, String address)
{
    text.setText("Father's Name : "+ fname+"\n Address : "+address);
}


}
