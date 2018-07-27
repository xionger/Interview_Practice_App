package com.xiongxh.interviewpractice.Interviews;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.xiongxh.interviewpractice.R;
import com.xiongxh.interviewpractice.data.bean.Interview;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class InterviewsAdapter extends RecyclerView.Adapter<InterviewsAdapter.ViewHolder>{

    private List<Interview> mInterviews = new ArrayList<>();

    private OnInterviewClickListener mInterviewClickListener;

    public interface OnInterviewClickListener{
        void onClick(Interview interview);
    }

    public InterviewsAdapter(OnInterviewClickListener interviewClickListener) {
        this.mInterviewClickListener = interviewClickListener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_list_interview, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Interview interview = mInterviews.get(position);
        holder.bindInterview(interview);
        holder.itemView.setOnClickListener(view -> mInterviewClickListener.onClick(interview));
    }

    @Override
    public int getItemCount() {
        return mInterviews.size();
    }
    public void refreshInterviews(List<Interview> interviews){
        setInterviews(interviews);
        notifyDataSetChanged();
    }

    private void setInterviews(@NonNull List<Interview> interviews){
        this.mInterviews = interviews;
    }

    class ViewHolder extends RecyclerView.ViewHolder{
        private Interview mInterview;
        private int mInterviewId;

        @BindView(R.id.tv_category_interview)
        TextView mInterviewCategory;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        public void bindInterview(final Interview interview) {
            this.mInterview = interview;
            this.mInterviewId = interview.getId();

            mInterviewCategory.setText(mInterview.getCategory());
        }
    }
}
