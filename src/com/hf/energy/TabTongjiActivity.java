package com.hf.energy;

import java.util.Calendar;
import java.util.Random;

import org.achartengine.ChartFactory;
import org.achartengine.GraphicalView;
import org.achartengine.chart.BarChart.Type;
import org.achartengine.model.CategorySeries;
import org.achartengine.model.XYMultipleSeriesDataset;
import org.achartengine.model.XYSeries;
import org.achartengine.renderer.XYMultipleSeriesRenderer;
import org.achartengine.renderer.XYSeriesRenderer;

import com.hf.energy.widget.utils.PopupWindowHelper;

import android.app.Activity;
import android.graphics.Color;
import android.graphics.Paint.Align;
import android.os.Bundle;

import android.view.Gravity;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.PopupWindow;

public class TabTongjiActivity extends Activity implements OnClickListener{
	private static String[] cats = new String[]{"上海","北京","广州","河南","河北","青岛"};
	private PopupWindow queryPopup;
	private GraphicalView chartView;
	private ViewGroup chartViewContainer;
	 @Override  
	 public void onCreate(Bundle savedInstanceState) {  
	      super.onCreate(savedInstanceState);  
	      setContentView(R.layout.act_tongji);
	      
	      XYMultipleSeriesRenderer renderer = getRenderer();
	      chartView =  ChartFactory.getBarChartView(this, getDataset(), renderer,Type.DEFAULT);
	      chartViewContainer = (ViewGroup) findViewById(R.id.chartView);
	     
	      chartViewContainer.addView(chartView, new LayoutParams(LayoutParams.FILL_PARENT, LayoutParams.FILL_PARENT));
	      chartView.setBackgroundColor(0xffc8e9fc);
	      for (int i=0;i<cats.length;i++) {
				renderer.addTextLabel(i, cats[i]);
	      }
	      initPopup();
	      findViewById(R.id.btnQuery).setOnClickListener(this);
	      findViewById(R.id.btnBack).setOnClickListener(this);
	 }
	
	 private void initPopup() {
		queryPopup = PopupWindowHelper.getPopupWindow(this, R.layout.popup_tongji_query, false);
		queryPopup.getContentView().findViewById(R.id.btnQuery).setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				queryPopup.dismiss();
			}
		});
	}

	private static XYMultipleSeriesDataset getDataset(){
		 XYMultipleSeriesDataset dataset = new XYMultipleSeriesDataset();
		 CategorySeries series = new CategorySeries("");  
		 XYSeries series2 = new XYSeries("");
		 Random random = new Random(Calendar.getInstance().getTimeInMillis());
		 for (int i = 0; i < cats.length; i++) {
			String cat = cats[i];
			series.add(cat, (i+1)*10);
			series2.add(i, (i+1)*10);
			
		}
		
		dataset.addSeries(series2);
		
		return dataset;
	 }
	 
	 private  XYMultipleSeriesRenderer getRenderer(){
		 int textSize = 32;
		 int screenWidth = getWindowManager().getDefaultDisplay().getWidth();
		 if(screenWidth<=480){
			 textSize = 24;
		 }
		 XYMultipleSeriesRenderer renderer = new XYMultipleSeriesRenderer();  
	        renderer.setAxisTitleTextSize(textSize);  
	        renderer.setApplyBackgroundColor(true);
	        renderer.setChartTitleTextSize(textSize);  
	        renderer.setLabelsTextSize(textSize);  
	        
	        renderer.setExternalZoomEnabled(false);
	      
	        
	        XYSeriesRenderer r = new XYSeriesRenderer();  
	        r.setColor(0xff1b88c1);  
	        renderer.addSeriesRenderer(r);  
	        
	       
	        renderer.setApplyBackgroundColor(false);
	        renderer.setYAxisMin(1);
	        renderer.setYAxisMax(70);
	        renderer.setAntialiasing(true);
	        renderer.setLabelsColor(0xff0482d2);
	        renderer.setAxesColor(0xff0482d2);
	        renderer.setMarginsColor(0xffc8e9fc);
	        renderer.setGridColor(0xff4ab5f9);
	        renderer.setXLabelsColor(0xff0482d2);
	        renderer.setYLabelsColor(0, 0xff0482d2);
	        renderer.setBackgroundColor(0xffc8e9fc);  
	        renderer.setChartTitle("");  
	        renderer.setXTitle("");  
	        renderer.setYTitle("");  
	        
	        renderer.setInScroll(true);
	      
	        renderer.setXAxisMin(-1);  
	        renderer.setXAxisMax(cats.length*1.1);  
	        renderer.setShowLegend(false);  
	        renderer.setShowLabels(true);
	       
	        
	        renderer.setShowGridX(true);  
	        renderer.setShowGridY(false);
	       
	        renderer.setXLabels(-1);  
	        renderer.setDisplayChartValues(false);  
	        renderer.setBarSpacing(0.4);  
	       
	        return renderer;  
	 }

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.btnQuery:
			queryPopup.showAtLocation(getWindow().getDecorView(), Gravity.CENTER, 0, 0);
			break;
		case R.id.btnBack:
			finish();
			break;

		default:
			break;
		}
	}
}
