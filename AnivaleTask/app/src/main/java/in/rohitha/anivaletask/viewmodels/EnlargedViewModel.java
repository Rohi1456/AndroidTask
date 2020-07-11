package in.rohitha.anivaletask.viewmodels;

import android.content.Context;
import android.widget.ImageView;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;
import androidx.databinding.BindingAdapter;

import com.squareup.picasso.Picasso;

import in.rohitha.anivaletask.R;

public class EnlargedViewModel extends BaseObservable {
    String url;
    Context context ;
    public EnlargedViewModel(String url, Context context)
    {
        this.url = url;
        this.context = context;
    }
    @BindingAdapter({"bind:url"})
    public static void setImageViewResource(ImageView imageView, String url) {
        Picasso.with(imageView.getContext())
                .load(url)
                .placeholder(R.drawable.image_place_holder)
                .error(R.drawable.image_place_holder)
                .into(imageView);
    }

    @Bindable
    public String getUrl() {
        return url;
    }

    @Bindable
    public void setUrl(String url) {
        this.url = url;
    }



}
