package com.coventry.animeapplication.ui.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.coventry.animeapplication.R;
import com.coventry.animeapplication.ui.model.AnimeCharacters;

import java.util.List;

public class AnimeAdapter extends RecyclerView.Adapter<AnimeAdapter.myHolder> {


    List<AnimeCharacters> charactersList;

    public AnimeAdapter(List<AnimeCharacters> characters) {
        this.charactersList = characters;
    }

    @NonNull
    @Override
    public myHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.characters_detail,parent,false);

        //inflater means kunchayi layout/design use garnai
        myHolder myHolder=new myHolder(view);

        return myHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull myHolder holder, final int position) {
        final AnimeCharacters character=charactersList.get(position);
        holder.name.setText(character.getName());
        holder.age.setText(character.getAge());
        holder.address.setText(character.getAddress());
        holder.gender.setText(character.getGender());
        String gen= character.getGender();
        if (gen.equals("Male")){
            holder.image.setImageResource(R.drawable.male_logo);
        }
        else if (gen.equals("Female")){
            holder.image.setImageResource(R.drawable.female_logo);
        }
        else {
            holder.image.setImageResource(R.drawable.other_logo);

        }
        holder.delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                charactersList.remove(character);
                notifyItemRemoved(position);
            }
        });

    }

    @Override
    public int getItemCount() {

        return charactersList.size();
    }

    public class myHolder extends RecyclerView.ViewHolder {

        TextView name,age,address,gender;
        ImageView image;
        Button delete;

        public myHolder(@NonNull View itemView) {

            super(itemView);
            name=itemView.findViewById(R.id.text_name);
            age=itemView.findViewById(R.id.text_age);
            address=itemView.findViewById(R.id.text_address);
            gender=itemView.findViewById(R.id.text_gender);
            image=itemView.findViewById(R.id.imageView);
            delete=itemView.findViewById(R.id.btn_delete);



        }

    }
}
