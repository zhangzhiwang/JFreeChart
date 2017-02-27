package com.asiainfo.linechart;

import java.awt.Font;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.DateAxis;
import org.jfree.chart.axis.DateTickUnit;
import org.jfree.chart.labels.ItemLabelAnchor;
import org.jfree.chart.labels.ItemLabelPosition;
import org.jfree.chart.labels.StandardXYItemLabelGenerator;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYItemRenderer;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.chart.title.TextTitle;
import org.jfree.data.time.Month;
import org.jfree.data.time.TimeSeries;
import org.jfree.data.time.TimeSeriesCollection;
import org.jfree.ui.TextAnchor;

/**
 * 多折线图
 * 
 * @author zhangzhiwang
 * @date 2017年2月27日 下午2:33:19
 */
public class MultiLineChart {
	public static void main(String[] args) throws IOException {
		// 准备数据
		TimeSeries timeSeries = new TimeSeries("宝马", Month.class);//第一个参数会显示在图例里
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

		TimeSeries timeSeries2 = new TimeSeries("奔驰", Month.class);
		timeSeries2.add(new Month(1, 2016), 150);
		timeSeries2.add(new Month(2, 2016), 50);
		timeSeries2.add(new Month(3, 2016), 350);
		timeSeries2.add(new Month(4, 2016), 175);
		timeSeries2.add(new Month(5, 2016), 400);
		timeSeries2.add(new Month(6, 2016), 500);
		timeSeries2.add(new Month(7, 2016), 300);
		timeSeries2.add(new Month(8, 2016), 530);
		timeSeries2.add(new Month(9, 2016), 710);
		timeSeries2.add(new Month(10, 2016), 800);
		timeSeries2.add(new Month(11, 2016), 850);
		timeSeries2.add(new Month(12, 2016), 730);

		TimeSeriesCollection timeSeriesCollection = new TimeSeriesCollection();
		timeSeriesCollection.addSeries(timeSeries);
		timeSeriesCollection.addSeries(timeSeries2);

		// 创建图表
		JFreeChart jFreeChart = ChartFactory.createTimeSeriesChart("", // title 图表标题 在下方设置
				"月份", // categoryAxisLabel 横轴坐标名称
				"销量", // valueAxisLabel 纵轴坐标名称
				timeSeriesCollection, // dataset 数据集
				true, // legend 是否显示图例
				true, // tooltips 是否显示工具提示
				true);// urls 是否显示url

		// 设置主标题（美化图表标题）
		jFreeChart.setTitle(new TextTitle("宝马、奔驰销量对比", new Font("黑体", Font.BOLD, 20)));
		// 设置子标题
		TextTitle subtitle = new TextTitle("2016年度", new Font("宋体", Font.ITALIC, 12));
		jFreeChart.addSubtitle(subtitle);
		jFreeChart.setAntiAlias(true);

		// 设置时间轴的范围。
		XYPlot plot = (XYPlot) jFreeChart.getPlot();
		DateAxis dateaxis = (DateAxis) plot.getDomainAxis();
		dateaxis.setDateFormatOverride(new java.text.SimpleDateFormat("M月"));// 格式化x轴数据显示格式
		dateaxis.setTickUnit(new DateTickUnit(DateTickUnit.MONTH, 1));// x轴数据增量

		// 设置曲线是否显示数据点
		XYLineAndShapeRenderer xylinerenderer = (XYLineAndShapeRenderer) plot.getRenderer();
		xylinerenderer.setBaseShapesVisible(true);

		// 设置曲线显示各数据点的值
		XYItemRenderer xyitem = plot.getRenderer();
		xyitem.setBaseItemLabelsVisible(true);
		xyitem.setBasePositiveItemLabelPosition(new ItemLabelPosition(ItemLabelAnchor.OUTSIDE12, TextAnchor.BASELINE_CENTER));
		xyitem.setBaseItemLabelGenerator(new StandardXYItemLabelGenerator());
		xyitem.setBaseItemLabelFont(new Font("Dialog", 1, 12));
		plot.setRenderer(xyitem);

		// 导出图片
		OutputStream os = new FileOutputStream("/Users/zhangzhiwang/Pictures/JFreeChart/多折线图.png");
		ChartUtilities.writeChartAsPNG(os, jFreeChart, 700, 500);
		System.out.println("图表生成成功！");
	}
}
