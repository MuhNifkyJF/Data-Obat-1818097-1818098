package com.example.obatind;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

public class CustomListAdapter extends BaseAdapter {
    private Activity activity;
    private LayoutInflater inflater;
    private List<Obat> obatItems;

    public CustomListAdapter(Activity activity, List<Obat> obatItems) {
        this.activity = activity;
        this.obatItems = obatItems;
    }
    @Override
    public int getCount() {
        return obatItems.size();
    }

    @Override
    public Object getItem(int location) {
        return  obatItems.get(location);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (inflater == null)
            inflater = (LayoutInflater) activity
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        if (convertView == null)
            convertView = inflater.inflate(R.layout.custom_list, null);
        TextView nama = (TextView) convertView.findViewById(R.id.text_nama);
        TextView jenis = (TextView) convertView.findViewById(R.id.text_jenis);
        TextView guna = (TextView) convertView.findViewById(R.id.text_guna);
        Obat obat = obatItems.get(position);
        nama.setText(obat.getmNama());
        jenis.setText(obat.getmJenis());
        guna.setText(obat.getmGuna());
        return convertView;
    }
}
