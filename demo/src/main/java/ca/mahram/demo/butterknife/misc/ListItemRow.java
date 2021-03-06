package ca.mahram.demo.butterknife.misc;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import butterknife.ButterKnife;
import butterknife.Bind;

/**
 Created by mahram on 15-03-03.
 */
public class ListItemRow {
    @Bind (android.R.id.text1) public TextView  title;
    @Bind (android.R.id.icon) public  ImageView icon;

    public ListItemRow (final View view) {
        ButterKnife.bind (this, view);
    }
}
