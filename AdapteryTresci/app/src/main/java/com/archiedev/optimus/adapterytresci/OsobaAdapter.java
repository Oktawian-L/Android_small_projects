package com.archiedev.optimus.adapterytresci;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class OsobaAdapter extends BaseAdapter {
    ArrayList<Osoba> actorList;
    LayoutInflater vi;
    Context context;

    public OsobaAdapter(Context context, ArrayList<Osoba> objects) {
        this.context = context;
        this.vi = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        this.actorList = objects;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final ViewHolder holder;
        if (convertView == null) {
            holder = new ViewHolder();
            convertView = vi.inflate(R.layout.list_row, null);

            holder.tvName = (TextView) convertView.findViewById(R.id.row_tv1);
            holder.tvDescription = (TextView) convertView.findViewById(R.id.row_tv2);
            holder.ivGender = (ImageView) convertView.findViewById(R.id.row_iv1);

            convertView.setTag(holder);
        }
        else
            holder = (ViewHolder) convertView.getTag();

        holder.tvName.setText(actorList.get(position).getName());
        holder.tvDescription.setText("Wiek: " + (actorList.get(position).getWiek()));
        if (actorList.get(position).getPlec()=='M')
            holder.ivGender.setImageResource(R.drawable.male);
        else
            holder.ivGender.setImageResource(R.drawable.female);

        return convertView;
    }

    static class ViewHolder {
        public TextView tvName;
        public TextView tvDescription;
        public ImageView ivGender;

    }

    @Override
    public int getCount() {
        // TODO Auto-generated method stub
        return actorList.size();
    }


    @Override
    public Object getItem(int position) {
        // TODO Auto-generated method stub
        return actorList.get(position);
    }


    @Override
    public long getItemId(int position) {
        // TODO Auto-generated method stub
        return position;
    }

}