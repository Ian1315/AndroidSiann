package com.example.gestion_pointage_journalier.sqllite;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.Date;

public class PointagesBDD {
    private static final int VERSION_BDD = 1;
    private static final String NOM_BDD = "pointage.db";
    private static final String TABLE_POINTAGES = "table_pointages";
    private static final String COL_ID = "ID";
    private static final int NUM_COL_ID = 0;
    private static final String COL_MATRICULE = "Matricule";
    private static final int NUM_COL_MATRICULE = 0;
    private static final String COL_DATE = "Date";
    private static final String NUM_COL_NOTE = "01-01-2020";

    private SQLiteDatabase bdd;
    private MaBaseSQLite maBaseSQLite;

    public PointagesBDD(Context context) {
        //On crée la BDD et sa table
        maBaseSQLite = new MaBaseSQLite(context, NOM_BDD, null, VERSION_BDD);
    }

    public void open(){
        //on ouvre la BDD en écriture
        bdd = maBaseSQLite.getWritableDatabase();
    }

    public void close(){
        //on ferme l'accès à la BDD
        bdd.close();
    }

    public SQLiteDatabase getBDD(){
        return bdd;
    }

    public long insertPointage(Pointage pointage){
        //Création d'un ContentValues (fonctionne comme une HashMap)
        ContentValues values = new ContentValues();
        values.put(COL_MATRICULE, pointage.getMatricule());
        values.put(COL_DATE, pointage.getDate());

        //on insère l'objet dans la BDD via le ContentValues
        return bdd.insert(TABLE_POINTAGES, null, values);
    }

    public int updatePointage(int id, Pointage pointage){
        //La mise à jour d'un livre dans la BDD fonctionne plus ou moins comme une i
        //il faut simplement préciser quel livre on doit mettre à jour grâce à l'ID
        ContentValues values = new ContentValues();
        values.put(COL_MATRICULE, pointage.getMatricule());

        return bdd.update(TABLE_POINTAGES, values, COL_ID + " = " +id, null);
    }

    public int removePointageWithID(int id){
        //Suppression d'un livre de la BDD grâce à l'ID
        return bdd.delete(TABLE_POINTAGES, COL_ID + " = " +id, null);
    }

    public String listPointage(){
        Cursor cursor = bdd.rawQuery("SELECT * FROM "+TABLE_POINTAGES, null);
        while(cursor.moveToNext()){

            System.out.println(cursor.getInt(0));
            System.out.println(cursor.getInt(1));
            System.out.println(cursor.getString(2));
        }
        cursor.close();
        return "";
    }

}
