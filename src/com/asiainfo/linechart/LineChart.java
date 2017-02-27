package com.asiainfo.linechart;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.time.Month;
import org.jfree.data.time.TimeSeries;
import org.jfree.data.time.TimeSeriesCollection;

/**
 * 基本线形图
 * 
 * @author zhangzhiwang
 * @date 2017年2月27日 上午11:01:42
 */
public class LineChart {
	public static void main(String[] args) throws IOException {
		// 准备数据
		TimeSeries timeSeries = new TimeSeries("宝马销量ABC", Month.class);
		timeSeries.add(new Month(1, 2016), 100);
		timeSeries.add(new Month(2, 2016), 200);
		timeSeries.add(new Month(3, 2016), 300);
		timeSeries.add(new Month(4, 2016), 400);
		timeSeries.add(new Month(5, 2016), 500);
		timeSeries.add(new Month(6, 2016), 600);
		timeSeries.add(new Month(7, 2016), 200);
		timeSeries.add(new Month(8, 2016), 500);
		timeSeries.add(new Month(9, 2016), 700);
		timeSeries.add(new Month(10, 2016), 900);
		timeSeries.add(new Month(11, 2016), 900);
		timeSeries.add(new Month(12, 2016), 700);

		TimeSeriesCollection timeSeriesCollection = new TimeSeriesCollection();
		timeSeriesCollection.addSeries(timeSeries);

		// 创建图表
		JFreeChart jFreeChart = ChartFactory.createTimeSeriesChart("宝马销量", // title 图表标题
				"月份", // categoryAxisLabel 横轴坐标名称
				"销量", // valueAxisLabel 纵轴坐标名称
				timeSeriesCollection, // dataset 数据集
				true, // legend 是否显示图例
				true, // tooltips 是否显示工具提示
				true);// urls 是否显示url

		// 导出图片
		OutputStream os = new FileOutputStream("/Users/zhangzhiwang/Pictures/JFreeChart/基本折线图.png");
		ChartUtilities.writeChartAsPNG(os, jFreeChart, 700, 500);
		System.out.println("图表生成成功！");
	}
}
