package yuva_dondapati.demos.android.daggerretrofit.Model;

import android.content.Context;
import android.media.Image;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.jakewharton.rxbinding2.support.v7.widget.RxRecyclerViewAdapter;

import java.util.ArrayList;
import java.util.List;

import yuva_dondapati.demos.android.daggerretrofit.R;

public class PhotoAdapter extends RecyclerView.Adapter<PhotoAdapter.Holder> {

    List<Photos> mdata;
    Context context;
    public PhotoAdapter(Context context) {
        mdata = new ArrayList<>();
        this.context = context;
    }

    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View itemView = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.post_layout, viewGroup, false);
        return new Holder(itemView);
    }


    @Override
    public void onBindViewHolder(@NonNull Holder holder, int position) {
        Photos photosData = mdata.get(position);
        Log.d("Yuvaaa", "photosData.getTitle()" + photosData.getTitle());
        holder.title.setText(photosData.getTitle());
        holder.albumid.setText(Integer.toString(photosData.getAlbumId()));
        holder.id.setText(Integer.toString(photosData.getId()));
        String imageUrl = photosData.getThumbnailUrl().toString();
        Glide.with(context)
                .load(imageUrl)
                .apply(new RequestOptions().override(100, 100))
                .into(holder.thumbnaiUrl);
    }

    @Override
    public int getItemCount() {
        Log.d("Yuvaaa", "getItemCount()" + mdata.size());
        return mdata.size();
    }

    public void setPhotosData(List<Photos> photosList) {
        Log.d("Yuvaaa", "setPhotosData()" + photosList.size());
        mdata = photosList;
        notifyDataSetChanged();
    }

    public class Holder extends RecyclerView.ViewHolder {
        TextView albumid, id, title;
        ImageView thumbnaiUrl;

        public Holder(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.photosTitle);
            albumid = itemView.findViewById(R.id.photosAlbumid);
            id = itemView.findViewById(R.id.photosid);
            thumbnaiUrl = itemView.findViewById(R.id.imageview1);
        }
    }
}
