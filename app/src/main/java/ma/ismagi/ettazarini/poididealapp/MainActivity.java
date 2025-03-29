package ma.ismagi.ettazarini.poididealapp;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private EditText etTaille;
    private RadioButton rbHomme, rbFemme;
    private Button btnCalculer;
    private TextView tvResult, tvFormule;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etTaille = findViewById(R.id.et_taille);
        tvFormule = findViewById(R.id.tv_formule);
        tvResult = findViewById(R.id.tv_resultat);
        rbFemme = findViewById(R.id.rb_femme);
        rbHomme = findViewById(R.id.rb_homme);
        btnCalculer = findViewById(R.id.btn_calculer);
        btnCalculer.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        float poids;
        int taille = Integer.parseInt(etTaille.getText().toString());
        if (rbHomme.isChecked()) {
            if (tvFormule.getText().toString().equals("Formule Broca"))
                poids = taille - 100;
            else
                poids = taille - 100 - ((taille - 150) / 4);
        } else {
            if (tvFormule.getText().toString().equals("Formule Broca"))
                poids = taille - 104;
            else
                poids = taille - 100 - ((taille - 150) / 2.5f);
        }
        tvResult.setText("Votre poids idéal est " + String.format("%.2f", poids));
    }
}