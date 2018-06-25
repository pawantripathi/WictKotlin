package wict.wictphiladelphia.org.wict.models;

import android.content.Context;
import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class Schedule {

    public static Schedule[] load(Context context) throws IOException {

        Gson gson = new Gson();
        try {
            InputStream scheduleStream = context.getAssets().open("schedule.json");
            return gson.fromJson(new InputStreamReader(scheduleStream, "utf-8"), Schedule[].class);
        } catch (IOException e) {
            Log.w("BiodataNew", "Unable to read json", e);
            throw e;
        }

    }

    @SerializedName("Time")
    private String time;
    @SerializedName("Title")
    private String title;
    @SerializedName("Subtitle")
    private String subTitle;
    @SerializedName("Location")
    private String location;
    @SerializedName("Speakers")
    private String speakers;

    @SerializedName("Label")
    private String label;


    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSubTitle() {
        return subTitle;
    }

    public void setSubTitle(String subTitle) {
        this.subTitle = subTitle;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getSpeakers() {
        return speakers;
    }

    public void setSpeakers(String speakers) {
        this.speakers = speakers;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }


}
