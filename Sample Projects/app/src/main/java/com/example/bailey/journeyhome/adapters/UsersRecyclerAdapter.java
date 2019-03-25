package com.example.bailey.journeyhome.adapters;

import android.content.Context;
import android.content.Intent;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.AppCompatTextView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.example.bailey.journeyhome.R;
import com.example.bailey.journeyhome.activities.ToDo_ViewTasks;
import com.example.bailey.journeyhome.model.Home;
import java.util.List;

public class UsersRecyclerAdapter extends RecyclerView.Adapter<UsersRecyclerAdapter.HomeViewHolder> {
    private RecyclerView recyclerViewUsers;
    private List<Home> listUsers;
    private Context ctx;



    public UsersRecyclerAdapter(List<Home> listUsers, Context ctx) {
        this.listUsers = listUsers;
        this.ctx = ctx;
    }

    @Override
    public HomeViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // inflating recycler item view
        final View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_user_recycler, parent, false);
        recyclerViewUsers = itemView.findViewById(R.id.recyclerViewUsers);
        return new HomeViewHolder(itemView,ctx);
    }

    @Override
    public void onBindViewHolder(HomeViewHolder holder, int position) {

        holder.textViewType.setText(listUsers.get(position).getAddress());
        holder.textViewEmail.setText(listUsers.get(position).getBuyersEmail());
        holder.textViewPassword.setText(listUsers.get(position).getRealtorsEmail());
    }

    @Override
    public int getItemCount() {
        Log.v(UsersRecyclerAdapter.class.getSimpleName(),""+listUsers.size());
        return listUsers.size();
    }


    /**
     * ViewHolder class
     */
    public class HomeViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        public AppCompatTextView textViewType;
        public AppCompatTextView textViewEmail;
        public AppCompatTextView textViewPassword;
        private Context ctx;

        public HomeViewHolder(View view, Context ctx) {
            super(view);
            this.ctx = ctx;
            view.setOnClickListener(this);
            textViewType = (AppCompatTextView) view.findViewById(R.id.textViewAddress);
            textViewEmail = (AppCompatTextView) view.findViewById(R.id.textViewEmail);
            textViewPassword = (AppCompatTextView) view.findViewById(R.id.textViewPassword);

        }

        @Override
        public void onClick(View v) {
            int position = getAdapterPosition();
            String address = listUsers.get(position).getAddress();
            String buyer = listUsers.get(position).getBuyersEmail();
            String realtor = listUsers.get(position).getRealtorsEmail();
            int home_id = listUsers.get(position).getHome_id();

            Intent intent = new Intent(ctx, ToDo_ViewTasks.class);
            intent.putExtra("address", address);
            intent.putExtra("buyer", buyer);
            intent.putExtra("realtor", realtor);
            intent.putExtra("home_id", home_id);
            intent.putExtra("position", position);
            this.ctx.startActivity(intent);
        }
    }


}
