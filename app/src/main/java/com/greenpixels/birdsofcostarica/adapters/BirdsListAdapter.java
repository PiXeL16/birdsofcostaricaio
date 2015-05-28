package com.greenpixels.birdsofcostarica.adapters;

import android.content.Context;
import android.widget.TextView;

import com.greenpixels.birdsofcostarica.R;
import com.greenpixels.birdsofcostarica.models.Bird;
import com.hannesdorfmann.annotatedadapter.annotation.Field;
import com.hannesdorfmann.annotatedadapter.annotation.ViewType;
import com.hannesdorfmann.annotatedadapter.support.recyclerview.SupportAnnotatedAdapter;

import java.util.List;

import javax.inject.Inject;

/**
 * Bird list Adapter
 *
 * @author PiXeL16
 * @date 5/26/15
 */
public class BirdsListAdapter extends SupportAnnotatedAdapter implements BirdsListAdapterBinder {


    @ViewType(
            layout = R.layout.list_bird_item,
            fields = {
                    @Field(
                            id = R.id.name,
                            name = "name",
                            type = TextView.class)
            }) public final int VIEWTYPE_BIRD = 0;


    private List<Bird> _birds;

    @Inject public BirdsListAdapter(Context context)
    {
        super(context);
    }

    public List<Bird> getBirds() {
        return _birds;
    }

    public void setBirds(List<Bird> birds) {
        _birds = birds;
    }

    @Override
    public int getItemCount() {
        return _birds == null ? 0 : _birds.size();
    }

    @Override
    public void bindViewHolder(BirdsListAdapterHolders.VIEWTYPE_BIRDViewHolder vh, int position) {
        Bird bird =  _birds.get(position);

        vh.name.setText(bird.getEnglishName());

    }


}
