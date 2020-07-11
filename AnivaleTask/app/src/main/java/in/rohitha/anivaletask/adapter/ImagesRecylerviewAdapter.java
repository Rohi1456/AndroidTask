package in.rohitha.anivaletask.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import in.rohitha.anivaletask.BR;
import in.rohitha.anivaletask.R;
import in.rohitha.anivaletask.databinding.ImageItemBinding;
import in.rohitha.anivaletask.viewmodels.ImageiewModel;
import in.rohitha.anivaletask.pojo.Hit;

public class ImagesRecylerviewAdapter extends RecyclerView.Adapter<ImagesRecylerviewAdapter.ViewHolder> {

    Context context;
    ArrayList<Hit> hits;
    public ImagesRecylerviewAdapter(Context context,ArrayList<Hit> hits) {
        this.hits= hits;
        this.context = context;
    }

    @Override
    public ImagesRecylerviewAdapter.ViewHolder onCreateViewHolder(ViewGroup parent,
                                                                         int viewType) {
        ImageItemBinding binding = DataBindingUtil.inflate(
                LayoutInflater.from(parent.getContext()),
                R.layout.image_item, parent, false);

        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        /*    public TodayTaskModel(String profileImage, String address, String time, String liters) {
         */
        ImageiewModel dataModel = new ImageiewModel(hits.get(position).getPreviewURL(),context,hits.get(position).getLargeImageURL());
        holder.itemRowBinding.setImageiewModel(dataModel);
        holder.bind(dataModel);
    }


    @Override
    public int getItemCount() {
        return hits.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public ImageItemBinding itemRowBinding;

        public ViewHolder(ImageItemBinding itemRowBinding) {
            super(itemRowBinding.getRoot());
            this.itemRowBinding = itemRowBinding;
        }

        public void bind(Object obj) {
            itemRowBinding.setVariable(BR.ImageiewModel, obj);
            itemRowBinding.executePendingBindings();
        }
    }


}


