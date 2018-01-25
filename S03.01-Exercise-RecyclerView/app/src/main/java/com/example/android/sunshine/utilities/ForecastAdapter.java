package com.example.android.sunshine.utilities;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.android.sunshine.R;

import org.w3c.dom.Text;

/**
 * Created by Ben on 1/24/2018.
 */

public class ForecastAdapter extends RecyclerView.Adapter<ForecastAdapter.ForecastAdapterViewHolder>{
    
    String[] mWeatherData;

    
    public ForecastAdapter(){
        
    }
    
    @Override
    public ForecastAdapter.ForecastAdapterViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        Context context = viewGroup.getContext();
        int layoutIdForListItem = R.layout.forecast_list_item;
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View view = layoutInflater.inflate(layoutIdForListItem, viewGroup, false);

        ForecastAdapterViewHolder viewHolder = new ForecastAdapterViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ForecastAdapter.ForecastAdapterViewHolder holder, int position) {
        String weatherForDisplay = mWeatherData[position];
        holder.mWeatherTextView.setText(weatherForDisplay);
    }

    @Override
    public int getItemCount() {
        return mWeatherData == null ? 0 : mWeatherData.length;
    }

    public void setmWeatherData(String[] weatherData) {
        mWeatherData = weatherData;
        notifyDataSetChanged();

    }
    
    class ForecastAdapterViewHolder extends RecyclerView.ViewHolder{
        
       public final TextView mWeatherTextView;
        
        public ForecastAdapterViewHolder(View view){
            super(view);
            mWeatherTextView = (TextView) view.findViewById(R.id.tv_weather_data);

        }


    }


}
