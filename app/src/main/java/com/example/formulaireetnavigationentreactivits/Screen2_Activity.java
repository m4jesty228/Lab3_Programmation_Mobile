package com.example.formulaireetnavigationentreactivits;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class Screen2_Activity extends AppCompatActivity {

    private TextView recap;
    private Button btnRetour;

    // Déclaration des variables pour le partage
    private String nom, email, phone, adresse, ville;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_screen2);
        recap     = findViewById(R.id.recap);
        btnRetour = findViewById(R.id.btnRetour);

        // Récupérer les données
        Intent intent = getIntent();
        nom     = intent.getStringExtra("nom");
        email   = intent.getStringExtra("email");
        phone   = intent.getStringExtra("phone");
        adresse = intent.getStringExtra("adresse");
        ville   = intent.getStringExtra("ville");

        // Afficher le récapitulatif
        String resume = "Nom : " + safe(nom) +
                "\nEmail : " + safe(email) +
                "\nPhone : " + safe(phone) +
                "\nAdresse : " + safe(adresse) +
                "\nVille : " + safe(ville);
        recap.setText(resume);

        // Bouton Retour
        btnRetour.setOnClickListener(v -> finish());

        // Bouton Partager
        Button btnPartager = findViewById(R.id.btnPartager);
        btnPartager.setOnClickListener(v -> {
            String contenu = "Nom : " + safe(nom) +
                    "\nEmail : " + safe(email) +
                    "\nPhone : " + safe(phone) +
                    "\nAdresse : " + safe(adresse) +
                    "\nVille : " + safe(ville);

            Intent partage = new Intent(Intent.ACTION_SEND);
            partage.setType("text/plain");
            partage.putExtra(Intent.EXTRA_SUBJECT, "Récapitulatif");
            partage.putExtra(Intent.EXTRA_TEXT, contenu);
            startActivity(Intent.createChooser(partage, "Partager via"));
        });
    }

    private String safe(String s) {
        return (s == null || s.trim().isEmpty()) ? "—" : s.trim();
    }
}