package com.mavericks.challenge;

import android.app.DialogFragment;
import android.content.res.Resources;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ListView listView;
    private FloatingActionButton floatBtn;
    private static ArrayList<String> arrayList;
    private static ArrayAdapter<String> arrayAdapter;
    private String[] values;
    private int count;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = (ListView) findViewById(R.id.mainList);


        try {
            if (savedInstanceState != null) {
                values = savedInstanceState.getStringArray("myKey");
            }
            else {
                values = getResources().getStringArray(R.array.names);
            }

            arrayList = new ArrayList<>();
            for (int i=0; i<values.length; i++) {
                arrayList.add(values[i]);
            }
            arrayAdapter = new ArrayAdapter<String>(this,
                    android.R.layout.simple_list_item_1, android.R.id.text1, arrayList);
            listView.setAdapter(arrayAdapter);
        } catch (Resources.NotFoundException e) {
            e.printStackTrace();
        }


        floatBtn = (FloatingActionButton) findViewById(R.id.fab);
        floatBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                callDialogFragment();
            }
        });
    }

    public void callDialogFragment() {
        try {
            DialogFrag dialog = new DialogFrag();
            dialog.show(this.getFragmentManager(), "MyDialogFragment");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        try {
            count = arrayAdapter.getCount();
            values = new String[count];
            for (int i=0; i<count; i++){
                values[i] = arrayAdapter.getItem(i);
            }
            outState.putStringArray("myKey", values);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static class DialogFrag extends DialogFragment {

        private EditText firstName, lastName;
        private Button doneBtn;

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.dialog_fragment, container,
                    false);
            getDialog().setTitle(R.string.add_txt);
            firstName = (EditText) rootView.findViewById(R.id.firstName);
            lastName = (EditText) rootView.findViewById(R.id.lastName);
            doneBtn = (Button) rootView.findViewById(R.id.doneBtn);


            doneBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    addName();
                }
            });
            return rootView;
        }

        public void addName() {
            try {
                String firstName = this.firstName.getText().toString();
                String lastName = this.lastName.getText().toString();
                if (firstName != null && firstName != "" && lastName !=null && lastName != "") {
                    firstName = firstName.substring(0, 1).toUpperCase() + firstName.substring(1);
                    lastName = lastName.substring(0, 1).toUpperCase() + lastName.substring(1);
                    String result = lastName.concat(", ").concat(firstName);
                    arrayList.add(result);
                    arrayAdapter.notifyDataSetChanged();
                    getDialog().dismiss();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
