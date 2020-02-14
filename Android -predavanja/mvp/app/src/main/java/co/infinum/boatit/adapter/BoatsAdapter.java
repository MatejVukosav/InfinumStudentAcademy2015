package co.infinum.boatit.adapter;

import com.bumptech.glide.Glide;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import co.infinum.boatit.R;
import co.infinum.boatit.models.Boat;

/**
 * Created by kjurkovic on 20/07/15.
 */
public class BoatsAdapter extends ArrayAdapter<Boat> {

    public BoatsAdapter(Context context, int resource, List<Boat> objects) {
        super(context, resource, objects);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.list_item_boats, parent, false);
            holder = new ViewHolder(convertView);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        Boat boat = getItem(position);
        holder.itemTitle.setText(boat.getBoatName());
        holder.itemSubtitle.setText(getContext().getString(R.string.comments_num, boat.getCommentsSize()));
        if (!TextUtils.isEmpty(boat.getBoatImage())) {
            Glide.with(getContext()).load(boat.getBoatImage()).centerCrop().placeholder(R.drawable.ic_logo).into(holder.itemImage);
        }
        return convertView;
    }

    static class ViewHolder {

        @Bind(R.id.item_image)
        ImageView itemImage;

        @Bind(R.id.item_title)
        TextView itemTitle;

        @Bind(R.id.item_subtitle)
        TextView itemSubtitle;

        ViewHolder(View view) {
            ButterKnife.bind(this, view);
            view.setTag(this);
        }
    }
}
