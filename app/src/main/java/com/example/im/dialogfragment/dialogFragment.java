package com.example.im.dialogfragment;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

import static android.R.attr.value;
import static android.R.id.input;
import static com.example.im.dialogfragment.R.attr.showText;
import static com.example.im.dialogfragment.R.layout.dialogfragment;

/**
 * Created by Im on 14-11-2017.
 */

public class dialogFragment extends DialogFragment implements View.OnClickListener ,android.text.TextWatcher{
    Button ok, cancel;
    EditText fName, address;
    private String fnames;
    private String useraddress;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.dialogfragment, container, false);
        ok = (Button) rootView.findViewById(R.id.ok);
        cancel = (Button) rootView.findViewById(R.id.cancel);
        fName = (EditText) rootView.findViewById(R.id.fName);
        address = (EditText) rootView.findViewById(R.id.address);
        ok.setOnClickListener(this);
        cancel.setOnClickListener(this);
        fName.addTextChangedListener(this);
        address.addTextChangedListener(this);
        getDialog().setTitle("Enter Some More Info.");
        getDialog().setCancelable(false);
        return rootView;
    }

    @Override
    public void onClick(View view) {


        int id = view.getId();
        switch (id) {
            case R.id.ok: {

                fnames=fName.getText().toString();

                useraddress=address.getText().toString();
//                validate(fnames);
//                validate(useraddress);

//               MainActivity.showtext(fatherName,userAdress);
                Toast.makeText(getActivity(), "Ok button is Clicked", Toast.LENGTH_SHORT).show();
                MainActivity callingActivity = (MainActivity) getActivity();
                callingActivity.showtext(fName.getText().toString(), address.getText().toString());
//                setfname(fName.getText().toString());
//                setaddress(address.getText().toString());
                dismiss();

                break;
            }
            case R.id.cancel: {
                Toast.makeText(getActivity(), "Cancel button is Pressed", Toast.LENGTH_SHORT).show();
                dismiss();
                break;
            }
        }

    }

    @Override
    public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

    }

    @Override
    public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

    }

    @Override
    public void afterTextChanged(Editable s) {
        fnames=fName.getText().toString();
        useraddress=address.getText().toString();
if(fnames.isEmpty()) {
    fName.setError("Please enter Name");
    ok.setEnabled(false);
}
else
    if(useraddress.isEmpty())
    {
        address.setError("Please enter Address");
        ok.setEnabled(false);
    }
    else
        ok.setEnabled(true);
// validation code goes here
    }
//    void validate(String s){
//        if(s.isEmpty())
//        {
//            fName.setError("Can't be empty");
//        }
//
//    }
//    public void setfname(String fname)
//    {
//        this.fnames=fname;
//
//    }
//    public String getfname()
//    {
//        return this.fnames;
//    }
//    public void setaddress(String useraddress)
//    {
//        this.useraddress=useraddress;
//
//    }
//    public String getaddress()
//    {
//        return this.useraddress;
//    }
//    @Override
//    public Dialog onCreateDialog(Bundle savedInstanceState) {
//
//        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
//        builder.setTitle("Open Gallery");
//        builder.setView();
//        builder.setMessage("Select photos from Gallery");
//        builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
//            @Override
//            public void onClick(DialogInterface dialog, int which) {
//                Intent intent = new Intent(Intent.ACTION_OPEN_DOCUMENT);
//                intent.putExtra(Intent.EXTRA_ALLOW_MULTIPLE, true);
//                intent.setAction(Intent.ACTION_GET_CONTENT);
//                intent.setType("image/*");
//                startActivity(intent);
//            }
//        });
//
//        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
//            @Override
//            public void onClick(DialogInterface dialog, int which) {
//                dismiss();
//            }
//        });
//
//        return builder.create();
//    }
//
//}
}