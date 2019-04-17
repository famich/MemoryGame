package com.fabiomichieletto.memorygame;

import android.widget.ImageView;

public class Tessera {
    private boolean visibile;
    private Integer resImg;     //risorsa immagine associata alla tessere
    private ImageView iv;      //riferimento all'oggetto ImageView che visualizza la tessera

    public Tessera(boolean visibile, Integer resImg, String name) {
        this.visibile = visibile;
        this.resImg = resImg;
    }

    public boolean isVisibile() {
        return visibile;
    }

    public Integer getResImg() {
        return resImg;
    }

    public void setVisibile(boolean visibile) {
        this.visibile = visibile;
    }

    public ImageView getIv() {
        return iv;
    }

    public void setIv(ImageView iv) {
        this.iv = iv;
    }


}
