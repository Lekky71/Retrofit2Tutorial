
package com.hashcode.booker.models;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Pdf implements Parcelable
{

    @SerializedName("isAvailable")
    @Expose
    private Boolean isAvailable;
    @SerializedName("acsTokenLink")
    @Expose
    private String acsTokenLink;
    @SerializedName("downloadLink")
    @Expose
    private String downloadLink;
    public final static Creator<Pdf> CREATOR = new Creator<Pdf>() {


        @SuppressWarnings({
            "unchecked"
        })
        public Pdf createFromParcel(Parcel in) {
            return new Pdf(in);
        }

        public Pdf[] newArray(int size) {
            return (new Pdf[size]);
        }

    }
    ;

    protected Pdf(Parcel in) {
        this.isAvailable = ((Boolean) in.readValue((Boolean.class.getClassLoader())));
        this.acsTokenLink = ((String) in.readValue((String.class.getClassLoader())));
        this.downloadLink = ((String) in.readValue((String.class.getClassLoader())));
    }

    /**
     * No args constructor for use in serialization
     * 
     */
    public Pdf() {
    }

    /**
     * 
     * @param downloadLink
     * @param acsTokenLink
     * @param isAvailable
     */
    public Pdf(Boolean isAvailable, String acsTokenLink, String downloadLink) {
        super();
        this.isAvailable = isAvailable;
        this.acsTokenLink = acsTokenLink;
        this.downloadLink = downloadLink;
    }

    public Boolean getIsAvailable() {
        return isAvailable;
    }

    public void setIsAvailable(Boolean isAvailable) {
        this.isAvailable = isAvailable;
    }

    public String getAcsTokenLink() {
        return acsTokenLink;
    }

    public void setAcsTokenLink(String acsTokenLink) {
        this.acsTokenLink = acsTokenLink;
    }

    public String getDownloadLink() {
        return downloadLink;
    }

    public void setDownloadLink(String downloadLink) {
        this.downloadLink = downloadLink;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(isAvailable);
        dest.writeValue(acsTokenLink);
        dest.writeValue(downloadLink);
    }

    public int describeContents() {
        return  0;
    }

}
