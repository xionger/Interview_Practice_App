package com.xiongxh.interviewpractice.data.bean;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Ignore;
import android.arch.persistence.room.PrimaryKey;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import com.xiongxh.interviewpractice.data.local.InterviewsDbContract;

import org.parceler.Parcel;

import java.util.List;

@Entity(tableName = InterviewsDbContract.INTERVIEWS_TABLE_NAME)
@org.parceler.Parcel(Parcel.Serialization.BEAN)
public class Interview {
    @PrimaryKey
    @SerializedName("id")
    @Expose
    private Integer id;

    @SerializedName("category")
    @Expose
    private String category;

    @SerializedName("questions")
    @Expose
    @Ignore
    private List<Question> questions = null;

    public Integer getId(){
        return this.id;
    }

    public void setId(Integer id){
        this.id = id;
    }

    public String getCategory() {
        return this.category;
    }

    public void setCategory(String category){
        this.category = category;
    }

    public List<Question> getQuestions(){
        return questions;
    }

    public void setQuestions(List<Question> questions){
        this.questions = questions;
    }
}
