package wict.wictphiladelphia.org.wict.models;

import android.content.Context;
import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;

import wict.wictphiladelphia.org.wict.R;

public class SponsorInfo {


    private static HashMap<String, Integer> resMapping= new HashMap();

    static{
        resMapping.put("arris.png", R.drawable.arris);
        resMapping.put("cisco.png", R.drawable.cisco);
        resMapping.put("kaitz.png", R.drawable.kaitz);
        resMapping.put("namic.png", R.mipmap.ic_launcher);
        resMapping.put("comcastbusiness.png", R.drawable.comcastbusiness);
        resMapping.put("tpx.png", R.drawable.tpx);

        resMapping.put("pwc.png", R.drawable.pwc);
        resMapping.put("qvc.png", R.drawable.qvc);
        resMapping.put("scte.png", R.drawable.scte);
        resMapping.put("signature.png", R.drawable.signature);

        resMapping.put("ae.png", R.drawable.ae);
        resMapping.put("amdocs.png", R.drawable.amdocs);
        resMapping.put("eplus.png", R.drawable.eplus);
        resMapping.put("espn.png", R.drawable.espn);
        resMapping.put("hbo.png", R.drawable.hbo);
        resMapping.put("juniper.png", R.drawable.juniper);
        resMapping.put("optia.png", R.drawable.optia);
        resMapping.put("pureintegration.png", R.drawable.pureintegration);
        resMapping.put("partners.png", R.drawable.partners);
        resMapping.put("stafftech.png", R.drawable.stafftech);



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
