package com.wtechweb.fragmentsv2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements ListFrag.ItemSelected {

    TextView tvDescription;
    String[] descriptions;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvDescription = findViewById(R.id.tvDescription);

        descriptions = getResources().getStringArray(R.array.descriptions);

        tvDescription.setText(descriptions[0]);

        // your phone is in landscape mode
        if(findViewById(R.id.layout_portrait) == null)
        {
            FragmentManager manager = this.getSupportFragmentManager();
            manager.beginTransaction()
                    .show(manager.findFragmentById(R.id.detail_frag))
                    .show(manager.findFragmentById(R.id.list_frag))
                    .commit();

        }

        // your phone is in portrait mode
        if(findViewById(R.id.layout_land) == null)
        {
            FragmentManager manager = this.getSupportFragmentManager();
            manager.beginTransaction()
                    .hide(manager.findFragmentById(R.id.detail_frag))
                    .show(manager.findFragmentById(R.id.list_frag))
                    .commit();
        }

    }

    @Override
    public void onItemSelected(int index) {
        tvDescription.setText(descriptions[index]);

        if(findViewById(R.id.layout_portrait) != null)
        {
            FragmentManager manager = this.getSupportFragmentManager();
            manager.beginTransaction()
                    .show(manager.findFragmentById(R.id.detail_frag))
                    .hide(manager.findFragmentById(R.id.list_frag))
                    .addToBackStack(null)
                    .commit();
        }
    }
}
