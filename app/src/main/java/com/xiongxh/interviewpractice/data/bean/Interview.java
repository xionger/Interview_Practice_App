package com.xiongxh.interviewpractice.data.bean;

import android.arch.persistence.room.Entity;
import android.os.Parcel;

@Entity(tableName = InterviewsDbContract.INTERVIEWS_TABLE_NAME)
@Parcel(Parcel.Serialization.BEAN)
public class Interview {
}
