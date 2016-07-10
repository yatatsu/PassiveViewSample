package com.yatatsu.passiveviewsample.ui.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import butterknife.bindView
import com.yatatsu.passiveviewsample.R
import com.yatatsu.passiveviewsample.data.model.Repository
import java.util.ArrayList


class ReposAdapter(private val context: Context,
    private val onClickListener: View.OnClickListener) : RecyclerView.Adapter<ReposViewHolder>() {
  private val repos: MutableList<Repository>

  init {
    repos = ArrayList<Repository>()
  }

  fun setRepos(repos: List<Repository>) {
    this.repos.clear()
    this.repos.addAll(repos)
    notifyDataSetChanged()
  }

  fun getItem(position: Int): Repository {
    return repos[position]
  }

  override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ReposViewHolder {
    val view = LayoutInflater.from(context).inflate(R.layout.list_item_repository, parent, false)
    view.setOnClickListener(onClickListener)
    return ReposViewHolder(view)
  }

  override fun onBindViewHolder(holder: ReposViewHolder, position: Int) {
    val repo = repos[position]
    holder.nameView.text = repo.fullName
    holder.descriptionView.text = repo.description
    holder.watcherView.text = String.format("watcher: %d", repo.watchersCount)
    holder.stargazerView.text = String.format("star: %d", repo.stargazersCount)
  }

  override fun getItemCount(): Int {
    return repos.size
  }
}

class ReposViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
  val nameView: TextView by bindView(R.id.repo_name)
  val descriptionView: TextView by bindView(R.id.repo_description)
  val watcherView: TextView by bindView(R.id.repo_watcher)
  val stargazerView: TextView by bindView(R.id.repo_stargazer)
}
