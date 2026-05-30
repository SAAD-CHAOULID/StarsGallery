package com.example.starsgallery.adapter;

import android.app.AlertDialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.starsgallery.R;
import com.example.starsgallery.beans.Star;
import com.example.starsgallery.service.StarService;

import java.util.ArrayList;
import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class StarAdapter extends RecyclerView.Adapter<StarAdapter.StarViewHolder> implements Filterable {

    private List<Star> completeStarList;
    private List<Star> filteredStarList;
    private Context context;
    private StarFilter starFilter;

    public StarAdapter(Context context, List<Star> starList) {
        this.context = context;
        this.completeStarList = starList;
        this.filteredStarList = new ArrayList<>(starList);
        this.starFilter = new StarFilter();
    }

    @NonNull
    @Override
    public StarViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(context).inflate(R.layout.star_item, parent, false);
        final StarViewHolder holder = new StarViewHolder(itemView);

        holder.itemView.setOnClickListener(v -> {
            Star star = filteredStarList.get(holder.getAdapterPosition());
            View popupView = LayoutInflater.from(context).inflate(R.layout.star_edit_item, null, false);

            TextView textId = popupView.findViewById(R.id.edit_id_star);
            CircleImageView imagePopup = popupView.findViewById(R.id.edit_image_star);
            RatingBar ratingBarPopup = popupView.findViewById(R.id.edit_rating_bar);

            textId.setText(String.valueOf(star.getId()));
            Glide.with(context).load(star.getThumbnail()).into(imagePopup);
            ratingBarPopup.setRating(star.getRating());

            new AlertDialog.Builder(context)
                    .setTitle("⭐ Change Rating")
                    .setMessage("Current rating: " + star.getRating() + " / 5")
                    .setView(popupView)
                    .setPositiveButton("Save", (dialog, which) -> {
                        float newRating = ratingBarPopup.getRating();
                        int starId = Integer.parseInt(textId.getText().toString());
                        Star targetStar = StarService.getInstance().findById(starId);
                        if (targetStar != null) {
                            targetStar.setRating(newRating);
                            StarService.getInstance().update(targetStar);
                            for (Star s : filteredStarList) {
                                if (s.getId() == starId) {
                                    s.setRating(newRating);
                                    break;
                                }
                            }
                            notifyItemChanged(holder.getAdapterPosition());
                        }
                    })
                    .setNegativeButton("Cancel", null)
                    .show();
        });
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull StarViewHolder holder, int position) {
        Star star = filteredStarList.get(position);
        holder.nameView.setText(star.getName());
        holder.ratingView.setRating(star.getRating());
        Glide.with(context).load(star.getThumbnail()).into(holder.imageView);
    }

    @Override
    public int getItemCount() {
        return filteredStarList.size();
    }

    @Override
    public Filter getFilter() {
        return starFilter;
    }

    static class StarViewHolder extends RecyclerView.ViewHolder {
        CircleImageView imageView;
        TextView nameView;
        RatingBar ratingView;

        public StarViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.imgStar);
            nameView = itemView.findViewById(R.id.tvName);
            ratingView = itemView.findViewById(R.id.rating);
        }
    }

    private class StarFilter extends Filter {
        @Override
        protected FilterResults performFiltering(CharSequence constraint) {
            FilterResults results = new FilterResults();
            List<Star> suggestionList = new ArrayList<>();
            if (constraint == null || constraint.length() == 0) {
                suggestionList.addAll(completeStarList);
            } else {
                String filterPattern = constraint.toString().toLowerCase().trim();
                for (Star star : completeStarList) {
                    if (star.getName().toLowerCase().contains(filterPattern)) {
                        suggestionList.add(star);
                    }
                }
            }
            results.values = suggestionList;
            results.count = suggestionList.size();
            return results;
        }

        @Override
        protected void publishResults(CharSequence constraint, FilterResults results) {
            filteredStarList = (List<Star>) results.values;
            notifyDataSetChanged();
        }
    }
}