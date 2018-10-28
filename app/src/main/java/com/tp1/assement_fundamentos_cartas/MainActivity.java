package com.tp1.assement_fundamentos_cartas;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    ImageView imageView;
    ImageView imageView2;
    ImageView imageView3;
    ImageView setImage;
    Button button;
    Button button2;
    int cartaEscolhida = 0;
    Random random = new Random();
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imageView = findViewById(R.id.carta1);
        imageView2 = findViewById(R.id.carta2);
        imageView3 = findViewById(R.id.carta3);
        button = findViewById(R.id.botao_confirmar);
        button2 = findViewById(R.id.botao_tentar_novamente);
        textView = findViewById(R.id.textView);

    }

    public void confirmarEscolha(View view) {
        int numero = random.nextInt(3);
        if (cartaEscolhida == 0) {
            Toast.makeText(this, "Escolha uma carta...", Toast.LENGTH_LONG).show();
            return;
        } else if (numero == 2) {
            setImagesResourcesWin();
        } else {
            setImagesResourcesLoss();
        }
        setVisibility();
    }

    public void tentarNovamente(View view) {
        returnImageResources();
        cartaEscolhida = 0;
    }

    public void cartaEscohida(View view) {
        cartaEscolhida = view.getId();
        if (cartaEscolhida == R.id.carta1) {
            Toast.makeText(this, "Carta 1 escolhida.", Toast.LENGTH_LONG).show();
        } else if (cartaEscolhida == R.id.carta2){
            Toast.makeText(this, "Carta 2 escolhida.", Toast.LENGTH_LONG).show();
        } else {
            Toast.makeText(this, "Carta 3 escolhida.", Toast.LENGTH_LONG).show();
        }

    }

    public void setImagesResourcesWin() {
        if (cartaEscolhida == R.id.carta1) {
            imageView.setImageResource(R.drawable.as_de_espadas);
        } else if (cartaEscolhida == R.id.carta2){
            imageView2.setImageResource(R.drawable.as_de_espadas);
        } else {
            imageView3.setImageResource(R.drawable.as_de_espadas);
        }
        textView.setText("Você venceu!!!!!");
    }

    public void setImagesResourcesLoss() {
        if (cartaEscolhida == R.id.carta1) {
            imageView.setImageResource(R.drawable.coringa);
        } else if (cartaEscolhida == R.id.carta2){
            imageView2.setImageResource(R.drawable.coringa);
        } else {
            imageView3.setImageResource(R.drawable.coringa);
        }
        textView.setText("Você perdeu :(");
    }

    public void returnImageResources(){
        imageView.setImageResource(R.drawable.verso_carta);
        imageView2.setImageResource(R.drawable.verso_carta);
        imageView3.setImageResource(R.drawable.verso_carta);

        imageView.setClickable(true);
        imageView2.setClickable(true);
        imageView3.setClickable(true);

        button.setVisibility(View.VISIBLE);
        button2.setVisibility(View.INVISIBLE);

        textView.setText(R.string.escolha_uma_carta);
    }

    public void setVisibility() {
        imageView.setClickable(false);
        imageView2.setClickable(false);
        imageView3.setClickable(false);
        button.setVisibility(View.INVISIBLE);
        button2.setVisibility(View.VISIBLE);

    }
}
