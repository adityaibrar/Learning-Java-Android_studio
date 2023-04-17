package com.example.pertemuan1.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.pertemuan1.R;
import com.example.pertemuan1.model.Person;

import java.util.ArrayList;

public class BiodataAdapter extends BaseAdapter {
    private ArrayList<Person> listPerson;
    private Context context;

    public BiodataAdapter(Context context, ArrayList<Person> listPerson) {
        this.listPerson = listPerson;
        this.context = context;
    }

    @Override
    public int getCount() {
        return listPerson.size();
    }

    @Override
    public Person getItem(int position) {
        return listPerson.get(position);
    }

    @Override
    public long getItemId(int position) {
        return getItem(position).getId();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.list_item_person, parent, false);
        }

        Person currentPerson = getItem(position);

        TextView namaTextView = convertView.findViewById(R.id.tv_nama11);
        TextView alamatTextView = convertView.findViewById(R.id.tv_alamat11);
        TextView teleponTextView = convertView.findViewById(R.id.tv_telepon11);

        namaTextView.setText(currentPerson.getNama());
        alamatTextView.setText(currentPerson.getAlamat());
        teleponTextView.setText(currentPerson.getTelepon());

        return convertView;
    }

    public void updateData(ArrayList<Person> newList) {
        listPerson.clear();
        listPerson.addAll(newList);
        notifyDataSetChanged();
    }
}
