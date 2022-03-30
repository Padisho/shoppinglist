package com.example.itlist;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class ListActivity extends AppCompatActivity {

    private EditText editText;
    private Button btnAdd;
    private ArrayList<String> items;
    private ArrayAdapter<String>itemsAdapter;
    private ListView listview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        listview = findViewById(R.id.ListViewLayout);
        editText=findViewById(R.id.txtList);
        btnAdd=findViewById(R.id.AddList);

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addItems();

            }
        });
        items = new ArrayList<>(); //store the items in an array
        itemsAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, items);
        listview.setAdapter(itemsAdapter);
        deleteAdditems();

    }

    private void deleteAdditems(){  //after writing the name of the item it must be deleted from the textbox and show in the list
        listview.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                Context context = getApplicationContext();
                Toast.makeText(context, "Item added",Toast.LENGTH_LONG).show(); // notify when an item has been added to the list

                items. remove(position);
                itemsAdapter.notifyDataSetChanged();
                return true;
            }
        });

    }

    private void addItems(){ //add items in a list
        EditText input = findViewById(R.id.txtList);
        String itemText = input.getText().toString();


        if(!(itemText.equals(""))){
            itemsAdapter.add(itemText);
            input.setText("");

        }
        else {
            Toast.makeText(getApplicationContext(), "Enter item name", Toast.LENGTH_LONG).show();
        }

    }

}