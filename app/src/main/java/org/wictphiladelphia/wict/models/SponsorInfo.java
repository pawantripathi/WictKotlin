package org.wictphiladelphia.wict.models;

import android.content.Context;
import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;

import org.wictphiladelphia.wict.R;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;


public class SponsorInfo {


    private static HashMap<String, Integer> resMapping= new HashMap();

    static{
        resMapping.put("arris_logo.png", R.drawable.arris_logo);
        resMapping.put("cisco_logo.png", R.drawable.cisco_logo);
        resMapping.put("comcastbusiness_logo.png", R.drawable.comcastbusiness_logo);
        resMapping.put("freewheel_spotlight_logo.png", R.drawable.freewheel_spotlight_logo);
        resMapping.put("signature_logo.png", R.drawable.signature_logo);
        resMapping.put("scte_isbe_logo.png", R.drawable.scte_isbe_logo);
        resMapping.put("ernstyoung_logo.png", R.drawable.ernstyoung_logo);
        resMapping.put("qurate_networks_logo.png", R.drawable.qurate_networks_logo);
        resMapping.put("amdocs_logo.png", R.drawable.amdocs_logo);
        resMapping.put("eplus_logo.png", R.drawable.eplus_logo);
        resMapping.put("espn_logo.png", R.drawable.espn_logo);
        resMapping.put("hbo_logo.png", R.drawable.hbo_logo);
        resMapping.put("optia_logo.png", R.drawable.optia_logo);
        resMapping.put("pureintegration_logo.png", R.drawable.pureintegration_logo);
        resMapping.put("pwc_logo.png", R.drawable.pwc_logo);
        resMapping.put("comcast_univ_logo.png", R.drawable.comcast_univ_logo);
        resMapping.put("ae_networks_logo.png", R.drawable.ae_networks_logo);
        resMapping.put("juniper_networks_logo.png", R.drawable.juniper_networks_logo);
        resMapping.put("partners_consulting_logo.png", R.drawable.partners_consulting_logo);
        resMapping.put("pluralsight_logo.png", R.drawable.pluralsight_logo);
        resMapping.put("vsoft_logo.png", R.drawable.vsoft_logo);

    }

    public static SponsorInfo[] load(Context context) throws IOException {

        Gson gson = new Gson();
        try {
            InputStream sponsorStream = context.getAssets().open("sponsors.json");
            return gson.fromJson(new InputStreamReader(sponsorStream, "utf-8"), SponsorInfo[].class);

        } catch (IOException e) {
            Log.w("SponsorInfoNew", "Unable to read json", e);
            throw e;
        }

    }


    @SerializedName("Title")
    private String title;

    @SerializedName("Category")
    private int category;

    @SerializedName("Sponsors")
    private String[] sponsorList;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getCategory() {
        return category;
    }

    public void setCategory(int category) {
        this.category = category;
    }

    public String[] getSponsorList() {
        return sponsorList;
    }

    public void setSponsorList(String[] sponsorList) {
        this.sponsorList = sponsorList;
    }

    public int getSponsorIcon(String name){
        return resMapping.get(name);
    }
    public ArrayList<Integer> getSponsorIcons(){
        ArrayList<Integer> imageRes = new ArrayList<>();
        for (String sponsorName: sponsorList){
            imageRes.add(resMapping.get(sponsorName));

        }
        return imageRes;
    }
}
