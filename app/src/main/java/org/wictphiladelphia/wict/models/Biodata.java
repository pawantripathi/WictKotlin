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
        resMapping.put("aehlenberger.png", R.drawable.aehlenberger);
        resMapping.put("ahochstuhl.png", R.drawable.ahochstuhl);
        resMapping.put("beckman.png", R.drawable.beckman);
        resMapping.put("bkerl.png", R.drawable.bkerl);
        resMapping.put("cbean.png", R.drawable.cbean);
        resMapping.put("cgoldstein.png", R.drawable.cgoldstein);
        resMapping.put("cpetonic.png", R.drawable.cpetonic);
        resMapping.put("dcohn.png", R.drawable.dcohn);
        resMapping.put("ddhamani.png", R.drawable.ddhamani);
        resMapping.put("dross.png", R.drawable.dross);
        resMapping.put("fvu.png", R.drawable.fvu);
        resMapping.put("fwan.png", R.drawable.fwan);
        resMapping.put("gbrevarts.png", R.drawable.gbrevarts);
        resMapping.put("hkhimani.png", R.drawable.hkhimani);
        resMapping.put("hvora.png", R.drawable.hvora);
        resMapping.put("ibaggili.png", R.drawable.ibaggili);
        resMapping.put("jabruzzese.png", R.drawable.jabruzzese);
        resMapping.put("jkurtz.png", R.drawable.jkurtz);
        resMapping.put("jmarpet.png", R.drawable.jmarpet);
        resMapping.put("jpoirier.png", R.drawable.jpoirier);
        resMapping.put("jsmith.png", R.drawable.jsmith);
        resMapping.put("jwiseman.png", R.drawable.jwiseman);
        resMapping.put("kpfeifer.png", R.drawable.kpfeifer);
        resMapping.put("ptripathi.png", R.drawable.ptripathi);
        resMapping.put("lrainey.png", R.drawable.lrainey);
        resMapping.put("mcorsini.png", R.drawable.mcorsini);
        resMapping.put("mfrancisco.png", R.drawable.mfrancisco);
        resMapping.put("mhenderson.png", R.drawable.mhenderson);
        resMapping.put("mriesen.png", R.drawable.mriesen);
        resMapping.put("msaltares.png", R.drawable.msaltares);
        resMapping.put("mtinney.png", R.drawable.mtinney);
        resMapping.put("nleal.png", R.drawable.nleal);
        resMapping.put("pbojja.png", R.drawable.pbojja);
        resMapping.put("rmoorthy.png", R.drawable.rmoorthy);
        resMapping.put("rrakoski.png", R.drawable.rrakoski);
        resMapping.put("salla.png", R.drawable.salla);
        resMapping.put("swenzel.png", R.drawable.swenzel);
        resMapping.put("ttalase.png", R.drawable.ttalese);
        resMapping.put("wbehm.png", R.drawable.wbehm);




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
