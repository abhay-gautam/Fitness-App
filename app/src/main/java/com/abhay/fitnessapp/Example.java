package com.abhay.fitnessapp;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Example {

    @SerializedName("records")
    @Expose
    private List<Record> records = null;

    public List<Record> getRecords() {
        return records;
    }

    public void setRecords(List<Record> records) {
        this.records = records;
    }

    public class Record {

        @SerializedName("id")
        @Expose
        private String id;
        @SerializedName("imagesurl")
        @Expose
        private String imagesurl;
        @SerializedName("title")
        @Expose
        private String title;
        @SerializedName("duration")
        @Expose
        private String duration;
        @SerializedName("description")
        @Expose
        private String description;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getImagesurl() {
            return imagesurl;
        }

        public void setImagesurl(String imagesurl) {
            this.imagesurl = imagesurl;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getDuration() {
            return duration;
        }

        public void setDuration(String duration) {
            this.duration = duration;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }


    }
}
