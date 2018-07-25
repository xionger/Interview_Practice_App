package com.xiongxh.interviewpractice.data.bean;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.arch.persistence.room.PrimaryKey;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.xiongxh.interviewpractice.data.local.InterviewsDbContract;

import org.parceler.Parcel;

@Entity(tableName = InterviewsDbContract.QUESTIONS_TABLE_NAME,
        foreignKeys = @ForeignKey(entity = Interview.class,
                parentColumns = "id",
                childColumns = "interviewId",
                onDelete = ForeignKey.CASCADE))

@Parcel(Parcel.Serialization.BEAN)
public class Question {
    private int interviewId;

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    private int _id;

    @SerializedName("id")
    @Expose
    private Integer idx;

    @SerializedName("description")
    @Expose
    private String description;

    @SerializedName("shortDescription")
    @Expose
    private String shortDescription;

    @SerializedName("hint")
    @Expose
    private String hint;

    @SerializedName("reference")
    @Expose
    private String reference;

    public int getId(){ return this._id; }

    public void setId(int id) { this._id = id; }

    public int getInterviewId() { return this.interviewId; }

    public void setInterviewId(int interviewId) { this.interviewId = interviewId; }

    public Integer getIdx(){ return this.idx; }

    public void setIdx (Integer idx){ this.idx = idx; }

    public String getDescription(){ return this.description; }

    public void setDescription(String description){ this.description = description; }

    public String getShortDescription(){ return this.shortDescription; }

    public void setShortDescription(String shortdescription){ this.shortDescription = shortdescription; }

    public String getHint(){ return this.hint; }

    public void setHint(String hint){ this.hint = hint; }

    public String getReference(){ return this.reference; }

    public void setReference(String reference){ this.reference = reference; }
}
