package com.rio.sqliteexample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AddActivity extends AppCompatActivity implements View.OnClickListener {
    EditText editTextId;
    EditText editTextName;
    Button btnAddToFavorite;
    Team team;
    TeamHelper teamHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);

        editTextId = findViewById(R.id.et_team_id);
        editTextName = findViewById(R.id.et_team_name);
        btnAddToFavorite = findViewById(R.id.btn_add_to_favorite);
        teamHelper = new TeamHelper(this);

        btnAddToFavorite.setOnClickListener(this);
    }



    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_add_to_favorite:
                String id = editTextId.getText().toString();
                String name = editTextName.getText().toString();

                team = new Team(Integer.valueOf(id), name);
                teamHelper.open();
                long result = teamHelper.insert(team);
                if (result > 0){
//                    team.setId(movie.getId());
                    Toast.makeText(this, "Succes", Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(this, "UnSucces", Toast.LENGTH_LONG).show();
                }
                teamHelper.close();
                finish();
                break;
        }
    }
}
