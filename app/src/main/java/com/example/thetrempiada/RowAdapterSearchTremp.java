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

public class RowAdapterSearchTremp extends BaseAdapter {

    Context context;
    ArrayList<MyTrempObj> data;
    SimpleCallback<Integer> map,join;
    Button callB ;
    SimpleCallback<Integer> phoneCallback;
    private static LayoutInflater inflater = null;

    public RowAdapterSearchTremp(Context context, ArrayList<MyTrempObj> data, SimpleCallback<Integer> delete,SimpleCallback<Integer> map, SimpleCallback<Integer> phoneCallback) {
        // TODO Auto-generated constructor stub
        this.context = context;
        this.data = data;
        inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        this.join = delete;
        this.map =map;
        this.phoneCallback = phoneCallback;
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

    public void setJoin(SimpleCallback<Integer> delete) {
        this.join = delete;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // TODO Auto-generated method stub
        View vi = convertView;
        if (vi == null)
            vi = inflater.inflate(R.layout.row_search, null);
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
        deleteB.setOnClickListener(x->join.callback(position,null));

        Button callButton = (Button) vi.findViewById(R.id.callB);
        callButton.setOnClickListener(x->phoneCallback.callback(position,null));



        return vi;
    }
}