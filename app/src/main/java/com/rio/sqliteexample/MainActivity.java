package com.rio.sqliteexample;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    RecyclerView rvMain;
    Button btnMain;
    ArrayList<Team> listTeam;
    ListTeamAdapter listTeamAdapter;
    TeamHelper teamHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rvMain = findViewById(R.id.rv_main);
        btnMain = findViewById(R.id.btn_main);
        listTeam = new ArrayList<>();
        teamHelper = new TeamHelper(this);

        btnMain.setOnClickListener(this);

        listTeamAdapter = new ListTeamAdapter(this);
        listTeamAdapter.setListTeam(listTeam);
        rvMain.setLayoutManager(new LinearLayoutManager(this));
        rvMain.setAdapter(listTeamAdapter);

//        loadDataBase();
    }

    private void loadDataBase(){
        listTeam.clear();
        teamHelper.open();
        listTeam.addAll(teamHelper.getAllData());
        teamHelper.close();
    }

    @Override
    protected void onResume() {
        super.onResume();
        loadDataBase();
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_main:
                Intent intent = new Intent(MainActivity.this, AddActivity.class);
                startActivity(intent);
                break;
        }
    }
}
