package org.wictphiladelphia.wict.models;

import android.content.Context;
import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;

import org.wictphiladelphia.wict.R;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Serializable;
import java.util.HashMap;


public class Biodata implements Serializable{

    private static HashMap<String, Integer> resMapping= new HashMap();

    static{
        resMapping.put("amulder.png", R.drawable.amulder);
        resMapping.put("agrannas.png", R.drawable.agrannas);
        resMapping.put("ateal.png", R.drawable.ateal);
        resMapping.put("aravisankar.png", R.drawable.aravisankar);
        resMapping.put("bkissinger.png", R.drawable.bkissinger);
        resMapping.put("ckocks.png", R.drawable.ckocks);
        resMapping.put("cpower.png", R.drawable.cpower);
        resMapping.put("ckey.png", R.drawable.ckey);
        resMapping.put("dfrigeri.png", R.drawable.dfrigeri);
        resMapping.put("hvora.png", R.drawable.hvora);
        resMapping.put("jheck.png", R.drawable.jheck);
        resMapping.put("jcloer.png", R.drawable.jcloer);
        resMapping.put("jdees.png", R.drawable.jdees);
        resMapping.put("jmoffat.png", R.drawable.jmoffat);
        resMapping.put("koh.png", R.drawable.koh);
        resMapping.put("kholmes.png", R.drawable.kholmes);
        resMapping.put("lloving.png", R.drawable.lloving);
        resMapping.put("lszkrybalo.png", R.drawable.lszkrybalo);
        resMapping.put("mbrennan.png", R.drawable.mbrennan);
        resMapping.put("msabraw.png", R.drawable.msabraw);
        resMapping.put("mmalone.png", R.drawable.mmalone);
        resMapping.put("mcorsini.png", R.drawable.mcorsini);
        resMapping.put("mstevens.png", R.drawable.mstevens);
        resMapping.put("nbergman.png", R.drawable.nbergman);
        resMapping.put("ptripathi.png", R.drawable.ptripathi);
        resMapping.put("rvargiya.png", R.drawable.rvargiya);
        resMapping.put("smuralidharan.png", R.drawable.smuralidharan);
        resMapping.put("jkeen.png", R.drawable.jkeen);
        resMapping.put("mray.png", R.drawable.mray);
        resMapping.put("smoon.png", R.drawable.smoon);


    }

    public static Biodata[] load(Context context) throws IOException{

        Gson gson = new Gson();
        try {
            InputStream bioStream = context.getAssets().open("bios.json");
            return gson.fromJson(new InputStreamReader(bioStream, "utf-8"), Biodata[].class);
        } catch (IOException e) {
            Log.w("BiodataNew", "Unable to read json", e);
            throw e;
        }

    }



    @SerializedName("Name")
    private String name;

    @SerializedName("Bio")
    private String summary;

    @SerializedName("Image")
    private String imageRes;

    @SerializedName("Designation")
    private String designation;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public int getImageRes() {
        return resMapping.get(imageRes);
    }

    public void setImageRes(String imageRes) {
        this.imageRes = imageRes;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

}
