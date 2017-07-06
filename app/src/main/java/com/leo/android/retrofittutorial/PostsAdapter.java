package com.leo.android.retrofittutorial;

import android.os.Build;
import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * Created by leonidtiskevic on 06.07.17.
 */

public class PostsAdapter extends RecyclerView.Adapter<PostsAdapter.ViewHolder> {

    List<PostModel> mPostModels;

    public PostsAdapter(List<PostModel> posts){
        this.mPostModels = posts;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.post_item, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        PostModel post = mPostModels.get(position);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            holder.mPosts.setText(Html.fromHtml(post.getElementPureHtml(), Html.FROM_HTML_MODE_LEGACY));
        } else {
            holder.mPosts.setText(Html.fromHtml(post.getElementPureHtml()));
        }
        holder.mTextView.setText(post.getSite());
    }

    @Override
    public int getItemCount() {
        if (mPostModels == null) {
            return 0;
        }
        return mPostModels.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder{

        private TextView mTextView;
        private TextView mPosts;

        public ViewHolder(View itemView) {
            super(itemView);
            mTextView = (TextView) itemView.findViewById(R.id.postitem_site);
            mPosts = (TextView) itemView.findViewById(R.id.postitem_post);
        }
    }

}
