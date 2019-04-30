package com.rio.sqliteexample;

import org.json.JSONException;
import org.json.JSONObject;

public class Team {
    private int idTeam;
    private String nameTeam;
    private String logoTeam;

    public Team(JSONObject object){
        try {
            int idTeam = object.getInt("idTeam");
            String nameTeam = object.getString("strTeam");
            String logoteam = object.getString("strTeamBadge");

            this.idTeam = idTeam;
            this.nameTeam = nameTeam;
            this.logoTeam = logoteam;

        } catch (JSONException e) {
            e.printStackTrace();
        }
    }


    public Team() {
    }

    public Team(int idTeam, String nameTeam) {
        this.idTeam = idTeam;
        this.nameTeam = nameTeam;
    }

    public int getIdTeam() {
        return idTeam;
    }

    public void setIdTeam(int idTeam) {
        this.idTeam = idTeam;
    }

    public String getNameTeam() {
        return nameTeam;
    }

    public void setNameTeam(String nameTeam) {
        this.nameTeam = nameTeam;
    }

    public String getLogoTeam() {
        return logoTeam;
    }

    public void setLogoTeam(String logoTeam) {
        this.logoTeam = logoTeam;
    }
}
