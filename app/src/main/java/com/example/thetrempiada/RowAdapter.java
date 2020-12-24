package com.example.thetrempiada;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;

import com.example.thetrempiada.driverActivities.MyTrempObj;

import java.util.ArrayList;

public class RowAdapter extends BaseAdapter {

    Context context;
    ArrayList<MyTrempObj> data;
    SimpleCallback<Integer> map,delete, call;
    private static LayoutInflater inflater = null;

    public RowAdapter(Context context, ArrayList<MyTrempObj> data, SimpleCallback<Integer> delete,SimpleCallback<Integer> map, SimpleCallback<Integer> call) {
        // TODO Auto-generated constructor stub
        this.context = context;
        this.data = data;
        inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        this.delete = delete;
        this.map =map;
        this.call = call;
    }

    @Override
    public int getCount() {
        // TODO Auto-generated method stub
        return data.size();
    }

    @Override
    public MyTrempObj getItem(int position) {
        // TODO Auto-generated method stub
        return data.get(position);
    }

    @Override
    public long getItemId(int position) {
        // TODO Auto-generated method stub
        return position;
    }

    public void setDelete(SimpleCallback<Integer> delete) {
        this.delete = delete;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // TODO Auto-generated method stub
        View vi = convertView;
        if (vi == null)
            vi = inflater.inflate(R.layout.row, null);
        TextView dateT = (TextView) vi.findViewById(R.id.dateT);
        dateT.setText(data.get(position).getDateTime().toString());
        TextView driverNameT = (TextView) vi.findViewById(R.id.driverNameT);
        driverNameT.setText("Driver: "+data.get(position).getDriver_fname()+" "+ data.get(position).getDriver_lname());
        TextView seatsT = (TextView) vi.findViewById(R.id.seatsT);
        seatsT.setText("Seats: "+data.get(position).getNumOfPeople());
        TextView freeSeatsT = (TextView) vi.findViewById(R.id.freeSeatsT);
        freeSeatsT.setText("Free Seats: "+data.get(position).getFreePlaces());
        TextView vehicleT = (TextView) vi.findViewById(R.id.vehicleT);
        vehicleT.setText("Vehicle: "+data.get(position).getVehicle());
        Button mapB = (Button) vi.findViewById(R.id.editB);
        mapB.setOnClickListener(x->map.callback(position,null));
        Button deleteB = (Button) vi.findViewById(R.id.deleteB);
        deleteB.setOnClickListener(x->{
            delete.callback(position,null);
            this.notifyDataSetChanged();
        });

        Button callButton = (Button) vi.findViewById(R.id.callB);
        callButton.setOnClickListener(x->call.callback(position,null));


        return vi;
    }
}