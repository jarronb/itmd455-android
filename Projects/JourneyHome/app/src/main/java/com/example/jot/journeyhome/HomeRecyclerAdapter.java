package com.example.jot.journeyhome;

import android.support.v7.widget.AppCompatTextView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;



public class HomeRecyclerAdapter extends RecyclerView.Adapter<HomeRecyclerAdapter.HomeViewHolder> {
    private List<Home> listHome;

    public HomeRecyclerAdapter(List<Home> listHome) {
        this.listHome = listHome;
    }
    @Override
    public HomeViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // inflating recycler item view
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_home_recycler, parent, false);
        return new HomeViewHolder(itemView);
    }
    @Override
    public void onBindViewHolder(HomeViewHolder holder, int position) {
        holder.textViewAddress.setText(listHome.get(position).getAddress());
        holder.textViewBuyersEmail.setText(listHome.get(position).getBuyersEmail());
        holder.textViewRealtorsEmail.setText(listHome.get(position).getRealtorsEmail());
    }
    @Override
    public int getItemCount() {
        Log.v(HomeRecyclerAdapter.class.getSimpleName(),""+listHome.size());
        return listHome.size();
    }
    /**
     * ViewHolder class
     */
    public class HomeViewHolder extends RecyclerView.ViewHolder {
        public AppCompatTextView textViewAddress;
        public AppCompatTextView textViewBuyersEmail;
        public AppCompatTextView textViewRealtorsEmail;
        public HomeViewHolder(View view) {
            super(view);
            textViewAddress = (AppCompatTextView) view.findViewById(R.id.textViewAddress);
            textViewBuyersEmail = (AppCompatTextView) view.findViewById(R.id.textViewBuyersEmail);
            textViewRealtorsEmail = (AppCompatTextView) view.findViewById(R.id.textViewRealtorsEmail);
        }
    }
}
