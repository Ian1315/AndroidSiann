package com.example.gestion_pointage_journalier.sqllite;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Pointage {
    private int id;
    private int matricule;
    private String date;

    public Pointage() {
    }

    public Pointage(int matricule) {
        this.matricule = matricule;

        SimpleDateFormat sdfDate = new SimpleDateFormat("yyyy-MM-dd");
        Date now = new Date();
        String strDate = sdfDate.format(now);

        this.date = strDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getMatricule() {
        return matricule;
    }

    public void setMatricule(int matricule) {
        this.matricule = matricule;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }


    @Override
    public String toString() {
        return "Pointage{" +
                "id=" + id +
                ", matricule='" + matricule + '\'' +
                ", date='" + date + '\'' +
                '}';
    }
}
