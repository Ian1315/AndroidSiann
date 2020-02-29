package com.example.gestion_pointage_journalier;

import androidx.appcompat.app.AppCompatActivity;
import android.app.FragmentTransaction;

import android.app.FragmentManager;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import java.util.HashMap;

public class MainActivity extends AppCompatActivity implements Item.OnFragmentInteractionListener{

    LinearLayout listPointage;

    EditText inputNouveau;

    Button btAjouter;

    RelativeLayout formPointage;

    FragmentManager fragmentManager = getFragmentManager();

    //Liste de personne pourpointage

    static final HashMap<Integer, String> listEmp = new HashMap<>();

    static {
        listEmp.put(12345,"Lahad NGOM");
        listEmp.put(1234567,"Ian GBAGUIDI");
        listEmp.put(123456,"PAPE Ibrahima");
        listEmp.put(12345678,"Charles NDIAYE");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        inputNouveau = (EditText) findViewById(R.id.matricule);
        btAjouter = (Button) findViewById(R.id.btn_ajouter);
        listPointage = (LinearLayout) findViewById(R.id.liste_pointage);
        formPointage = (RelativeLayout) findViewById(R.id.pointage);

        //Ecouteur sur le boutton add
        btAjouter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //click sur le bouton

                String nouveauPointage = inputNouveau.getText().toString();

                if(listEmp.get(new Integer(nouveauPointage)) != null) {

                    FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                    Item newFragment = Item.newInstance(listEmp.get(new Integer(nouveauPointage)));
                    fragmentTransaction.add(R.id.liste_pointage, newFragment);
                    fragmentTransaction.commit();
                }

                inputNouveau.setText("");

            }
        });

        //btn checklist
        ImageButton voirListe = (ImageButton) findViewById(R.id.btn_liste_employe);
        voirListe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listEmploye();
            }
        });
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }
    private void listEmploye(){
        Intent intent = new Intent(this, ListeEmployeActivity.class);
        startActivity(intent);
    }
}
