package sg.edu.rp.c346.id22022452.ndpsongs;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class CustomAdapter extends ArrayAdapter {

    Context parent_context;
    int layout_id;
    ArrayList<Song> songList;

    public CustomAdapter(Context context, int resource, ArrayList<Song> objects)
    {
        super(context,resource,objects);

        parent_context = context;
        layout_id = resource;
        songList = objects;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent)
    {

        LayoutInflater inflater = (LayoutInflater) parent_context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);


        View rowView = inflater.inflate(layout_id,parent,false); // Represent row.xml


        TextView tvTitle = rowView.findViewById(R.id.textViewTitle);
        TextView tvYear = rowView.findViewById(R.id.textViewYear);
        TextView tvStars = rowView.findViewById(R.id.textViewStars);
        TextView tvSinger = rowView.findViewById(R.id.textViewSinger);


        Song currentVersion = songList.get(position);


        tvTitle.setText(currentVersion.getTitle());
        tvYear.setText(currentVersion.getYear());
        tvStars.setText(currentVersion.getStars());
        tvSinger.setText(currentVersion.getSingers());

        return rowView;
    }
}