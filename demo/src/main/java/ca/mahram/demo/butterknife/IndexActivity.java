package ca.mahram.demo.butterknife;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.StringRes;
import android.support.v7.app.ActionBarActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListView;

import ca.mahram.demo.butterknife.activity.ActivityInjectionActivity;
import ca.mahram.demo.butterknife.activity.FragmentInjectionActivity;
import ca.mahram.demo.butterknife.activity.ViewListInjectionActivity;
import ca.mahram.demo.butterknife.misc.ListItemRow;

public class IndexActivity
  extends ActionBarActivity
  implements AdapterView.OnItemClickListener {

    private ListView list;
    private DemoAdapter adapter;

    private enum DemoActivity {
        ACTIVITY_INJECTION (R.string.activity_injection, ActivityInjectionActivity.class),
        FRAGMENT_INJECTION (R.string.fragment_injection, FragmentInjectionActivity.class),
        VIEWLIST_INJECTION (R.string.view_list_injection, ViewListInjectionActivity.class);

        @StringRes final int                       title;
        final            Class<? extends Activity> activity;

        DemoActivity (final int titleRes, final Class<? extends Activity> activityClass) {
            title = titleRes;
            activity = activityClass;
        }
    }

    @Override
    protected void onCreate (Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        list = new ListView (this);

        setContentView (list);

        adapter = new DemoAdapter ();
        list.setAdapter (adapter);
        list.setOnItemClickListener (this);
    }

    @Override public void onItemClick (final AdapterView<?> parent,
                                       final View view,
                                       final int position,
                                       final long id) {
        startActivity (new Intent (this, adapter.getItem (position).activity));
    }

    private class DemoAdapter
      extends BaseAdapter {
        private final DemoActivity[] activities = DemoActivity.values ();
        private final LayoutInflater inflater   = LayoutInflater.from (IndexActivity.this);

        @Override public int getCount () {
            return activities.length;
        }

        @Override public DemoActivity getItem (final int position) {
            return activities[position];
        }

        @Override public long getItemId (final int position) {
            return position;
        }

        private View newView (final ViewGroup parent) {
            final View v = inflater.inflate (R.layout.item_list, parent, false);
            v.setTag (new ListItemRow (v));
            return v;
        }

        @Override public View getView (final int position, final View convertView, final ViewGroup parent) {
            final View v = null == convertView ? newView (parent) : convertView;
            final DemoActivity activity = getItem (position);

            final ListItemRow row = (ListItemRow) v.getTag ();

            row.title.setText (activity.title);
            row.icon.setVisibility (View.GONE);

            return v;
        }
    }
}
