package com.residency.myresidency.WatchMan;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.residency.myresidency.R;

import java.util.ArrayList;

import static com.residency.myresidency.R.drawable.click_box;

public class DaynemicAdapter extends RecyclerView.Adapter<DaynemicAdapter.DAYNEMIC> {

    ArrayList<DaynemicItem> daynemicItems;
    Context mcontext;
    int selectedPosition = -1;

    public DaynemicAdapter(ArrayList<DaynemicItem> daynemicItems, Context mcontext) {
        this.daynemicItems = daynemicItems;
        this.mcontext = mcontext;
    }

    @NonNull
    @Override
    public DAYNEMIC onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mcontext).inflate(R.layout.watchman_item, parent, false);
        return new DAYNEMIC(view);


    }

    @Override
    public void onBindViewHolder(@NonNull DAYNEMIC holder, final int position) {

        holder.id.setText(daynemicItems.get(position).getId());
        holder.name.setText(daynemicItems.get(position).getName());

        if (selectedPosition == position) {

            holder.name.setBackgroundResource(R.drawable.a);

        } else {
            holder.name.setBackgroundResource(R.drawable.b);


        }


        holder.name.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selectedPosition = position;
                Toast.makeText(mcontext, "" + daynemicItems.get(position).getName(), Toast.LENGTH_SHORT).show();
                notifyDataSetChanged();

            }
        });
    }


//        Intent intent = new Intent(mcontext, MainActivity.class);
//        intent.putExtra("_id",""+daynemicItems.size());
//        intent.putExtra("_name",""+daynemicItems.get(position).getName());

//        intent.putExtra("_id",""+holder.id.getText());
//        intent.putExtra("_name",""+holder.name.getText());
//        mcontext.startActivity(intent);


    @Override
    public int getItemCount() {
        return daynemicItems.size();
    }

    public class DAYNEMIC extends RecyclerView.ViewHolder {

        TextView id;
        Button name;

        public DAYNEMIC(@NonNull View itemView) {
            super(itemView);

            id = itemView.findViewById(R.id.id);
            name = itemView.findViewById(R.id.name);


        }
    }
}
