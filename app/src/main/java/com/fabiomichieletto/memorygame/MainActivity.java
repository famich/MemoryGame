package com.fabiomichieletto.memorygame;

import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayout;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collections;

public class MainActivity extends AppCompatActivity {

    private static final int NUM_TESSERE = 24;
    private ArrayList<Tessera> tessere = new ArrayList<>();
    private Tessera tesseraPrimoClick = null;  //null se non eseguito primo click
    private Tessera tesseraSecondoClick = null;  //null se non eseguito secondo click

    GridLayout gridLayout;  //riferimono alla griglia del layout

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        gridLayout = findViewById(R.id.grid);

        creaTessere();

        reset(null);
    }

    private void creaTessere() {
        /* TODO Caricare 12 immagini diverse in modo da avere 24 coppie distinte */
        tessere.add(new Tessera(false, R.drawable.donut_circle, "donut"));
        tessere.add(new Tessera(false, R.drawable.donut_circle, "donut"));
        tessere.add(new Tessera(false, R.drawable.donut_circle, "donut"));
        tessere.add(new Tessera(false, R.drawable.donut_circle, "donut"));
        tessere.add(new Tessera(false, R.drawable.donut_circle, "donut"));
        tessere.add(new Tessera(false, R.drawable.donut_circle, "donut"));
        tessere.add(new Tessera(false, R.drawable.donut_circle, "donut"));
        tessere.add(new Tessera(false, R.drawable.donut_circle, "donut"));

        tessere.add(new Tessera(false, R.drawable.froyo_circle, "froyo"));
        tessere.add(new Tessera(false, R.drawable.froyo_circle, "froyo"));
        tessere.add(new Tessera(false, R.drawable.froyo_circle, "froyo"));
        tessere.add(new Tessera(false, R.drawable.froyo_circle, "froyo"));
        tessere.add(new Tessera(false, R.drawable.froyo_circle, "froyo"));
        tessere.add(new Tessera(false, R.drawable.froyo_circle, "froyo"));
        tessere.add(new Tessera(false, R.drawable.froyo_circle, "froyo"));
        tessere.add(new Tessera(false, R.drawable.froyo_circle, "froyo"));

        tessere.add(new Tessera(false, R.drawable.icecream_circle, "ice_cream"));
        tessere.add(new Tessera(false, R.drawable.icecream_circle, "ice_cream"));
        tessere.add(new Tessera(false, R.drawable.icecream_circle, "ice_cream"));
        tessere.add(new Tessera(false, R.drawable.icecream_circle, "ice_cream"));
        tessere.add(new Tessera(false, R.drawable.icecream_circle, "ice_cream"));
        tessere.add(new Tessera(false, R.drawable.icecream_circle, "ice_cream"));
        tessere.add(new Tessera(false, R.drawable.icecream_circle, "ice_cream"));
        tessere.add(new Tessera(false, R.drawable.icecream_circle, "ice_cream"));

    }

    /**
     * Data una ImageView reperisce la tessera associata ad essa
     */
    public Tessera getTesseraAssociata(ImageView iv) {
        for (Tessera t : tessere) {
            tessere.indexOf(t);
            if (t.getIv() == iv) {
                return t;
            }
        }
        return null; //non passa mai per questa istruzione
    }

    /**
     * Reset della partita (ascoltatore del pulsante RESET)
     * @param view il pulsante RESET
     */
    public void reset(View view) {
        tesseraPrimoClick = null;
        tesseraSecondoClick = null;

        Collections.shuffle(tessere);   //mescolo le tessere

        gridLayout.removeAllViews();    //rimuovo tutte le ImageView dalla griglia

        //creo le nuove ImageView
        for (Tessera t : tessere) {
            t.setVisibile(false);   //inizialmente non viene visualizzata l'immagine

            ImageView iv = new ImageView(this);

            //imposto i parametri dell'ImageView
            GridLayout.LayoutParams param = new GridLayout.LayoutParams();
            param.width = 130;
            param.height = 130;
            param.rightMargin = 5;
            param.topMargin = 5;
            iv.setLayoutParams(param);

            iv.setImageResource(R.drawable.question_mark);  //associo l'immagine di tessera nascosta

            //associo l'id dell'ImageView alla tessera
            t.setIv(iv);

            //associo l'ascoltatore all'ImageView
            iv.setOnClickListener(new TesseraListener());

            //aggiungo l'ImageView al layout
            gridLayout.addView(iv);

        }

        //imposto le visualizzazioni
        setVisualizzazione();
    }

    /**
     * Imposta l'immagine da visualizzare di ogni tessera
     */
    public void setVisualizzazione() {
        for (Tessera t : tessere) {
            if (t.isVisibile()) {
                t.getIv().setImageResource(t.getResImg());
            } else {
                t.getIv().setImageResource(R.drawable.question_mark);
            }
        }
    }



    /**
     * Visualizza come messaggio di tipo Toast la stringa associata alla risorsa passata
     * @param msgRes
     */
    public void displayToast(int msgRes){
        Toast toast = (Toast) Toast.makeText(this, msgRes, Toast.LENGTH_LONG);
        toast.show();
    }

    /**
     * Ascoltatore di ogni ImageView inserita nella griglia.
     * Questo metodo verrà richiamato ogni volta che si clicka su una tessera
     */
    public class TesseraListener implements View.OnClickListener {

        @Override
        public void onClick(View v) {
            //reperisco la tessera associata all'ImageView clickata
            Tessera tc = getTesseraAssociata((ImageView) v);

            /* TODO inserire il codice per gestire il gioco

                Suggerimento: la variabile locale tc di tipo Tessera è la tessera che è
                stata cliccata.
                Utilizzare e modificare opportunamente gli attributi TesseraPrimoClick e
                TesseraSecondoClick per valorizzare l'attributo "visibile" della tessera tc.




            */



            setVisualizzazione();

            /* TODO messaggio di vittoria se finito (Toast)
                Suggerimento: potrebbe aiutare un metodo che restituisce il numero di tessere
                visibili
             */


        }
    }

    /* TODO inserire pulsante RESET che permette di ricominciare la aprtita */

    /* TODO (facoltativo) inserire una casella di testo che visualizza il numero di tentativi fatti
        (ogni tentativo è rappresentato da una coppia di click su una tessera nascosta)
     */

}




