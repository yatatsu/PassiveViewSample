package com.yatatsu.passiveviewsample.ui.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.yatatsu.passiveviewsample.R;
import com.yatatsu.passiveviewsample.data.model.Repository;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;


public class ReposAdapter extends RecyclerView.Adapter<ReposAdapter.ViewHolder> {

    private final Context context;
    private final View.OnClickListener onClickListener;
    private List<Repository> repos;

    public ReposAdapter(Context context, View.OnClickListener onClickListener) {
        this.context = context;
        this.onClickListener = onClickListener;
        repos = new ArrayList<>();
    }

    public void setRepos(List<Repository> repos) {
        this.repos.clear();
        this.repos.addAll(repos);
        notifyDataSetChanged();
    }

    public Repository getItem(int position) {
        return repos.get(position);
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context)
                .inflate(R.layout.list_item_repository, parent, false);
        view.setOnClickListener(onClickListener);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Repository repo = repos.get(position);
        holder.nameView.setText(repo.fullName);
        holder.descriptionView.setText(repo.description);
        holder.watcherView.setText(String.format("watcher: %d", repo.watchersCount));
        holder.stargazerView.setText(String.format("star: %d", repo.stargazersCount));
    }

    @Override
    public int getItemCount() {
        return repos.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        @Bind(R.id.repo_name)
        TextView nameView;
        @Bind(R.id.repo_description)
        TextView descriptionView;
        @Bind(R.id.repo_watcher)
        TextView watcherView;
        @Bind(R.id.repo_stargazer)
        TextView stargazerView;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
