package com.example.belirumah.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.view.menu.MenuView;
import androidx.recyclerview.widget.RecyclerView;
import com.example.belirumah.R;
import com.example.belirumah.model.User;

import java.util.List;

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.MyViewHolder>{
    private Context context;
    private List<User> list;
    private Dialog dialog;

    public interface Dialog {
        void onClick(int pos);
    }

    public void setDialog(Dialog dialog) {
        this.dialog = dialog;
    }

    public UserAdapter(Context context, List<User> list) {
        this.context = context;
        this.list = list;
    }
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType){
        View intemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_user, parent, false); return new  MyViewHolder(intemView);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.name.setText(list.get(position).getName());
        holder.email.setText(list.get(position).getEmail());
        holder.nomerhp.setText(list.get(position).getNomerHp());
        holder.alamat.setText(list.get(position).getAlamat());
        holder.kode.setText(list.get(position).getKode());

    }

    @Override
    public int getItemCount(){
        return list.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder{
        TextView name, email, nomerhp, alamat, kode;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.name);
            email = itemView.findViewById(R.id.email);
            nomerhp = itemView.findViewById(R.id.nomerhp);
            alamat = itemView.findViewById(R.id.alamat);
            kode = itemView.findViewById(R.id.kode);

            itemView.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View view){
                    if (dialog!=null){
                        dialog.onClick(getLayoutPosition());
                    }
                }
            });
        }
    }
}


