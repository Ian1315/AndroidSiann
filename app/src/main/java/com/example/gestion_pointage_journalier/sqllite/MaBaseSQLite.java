package com.example.gestion_pointage_journalier.sqllite;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class MaBaseSQLite extends SQLiteOpenHelper {
    private static final String TABLE_POINTAGES = "table_pointages";
    private static final String COL_ID = "ID";
    private static final String COL_MATRICULE = "MATRICULE";
    private static final String COL_DATE = "DATE";

    private static final String CREATE_BDD = "CREATE TABLE " + TABLE_POINTAGES + " ("
            + COL_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + COL_MATRICULE + " TEXT NOT NULL," + COL_DATE + " TEXT);";

    public MaBaseSQLite(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        //on crée la table à partir de la requête écrite dans la variable CREATE_BDD
        sqLiteDatabase.execSQL(CREATE_BDD);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        //On peut faire ce qu'on veut ici moi j'ai décidé de supprimer la table et d
        //comme ça lorsque je change la version les id repartent de 0
        sqLiteDatabase.execSQL("DROP TABLE " + TABLE_POINTAGES + ";");
        onCreate(sqLiteDatabase);
    }
}
