package com.asiainfo.linechart;

import java.awt.Font;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

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
import org.jfree.data.time.Day;
import org.jfree.data.time.Hour;
import org.jfree.data.time.TimeSeries;
import org.jfree.data.time.TimeSeriesCollection;
import org.jfree.ui.TextAnchor;

/**
 * 折线图美化（按日统计）
 * 
 * @author zhangzhiwang
 * @date 2017年2月27日 下午4:26:17
 */
public class LineChartSettings4 {
	public static void main(String[] args) throws IOException, ParseException {
		// 准备数据
		TimeSeries timeSeries = new TimeSeries("", Hour.class);
		Map<Date, Double> map = new HashMap<Date, Double>();
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
		timeSeries.add(new Hour(simpleDateFormat.parse("20170101001111")), 1);
		timeSeries.add(new Hour(simpleDateFormat.parse("20170101011111")), 1);
		timeSeries.add(new Hour(simpleDateFormat.parse("20170101021111")), 1);
		timeSeries.add(new Hour(simpleDateFormat.parse("20170101031111")), 1);
		timeSeries.add(new Hour(simpleDateFormat.parse("20170101041111")), 1);
		timeSeries.add(new Hour(simpleDateFormat.parse("20170101051111")), 1);
		timeSeries.add(new Hour(simpleDateFormat.parse("20170101061111")), 1);
		timeSeries.add(new Hour(simpleDateFormat.parse("20170101071111")), 1);
		timeSeries.add(new Hour(simpleDateFormat.parse("20170101081111")), 1);
		timeSeries.add(new Hour(simpleDateFormat.parse("20170101091111")), 1);
		timeSeries.add(new Hour(simpleDateFormat.parse("20170101101111")), 1);
		timeSeries.add(new Hour(simpleDateFormat.parse("20170101111111")), 1);
		timeSeries.add(new Hour(simpleDateFormat.parse("20170101121111")), 1);
		timeSeries.add(new Hour(simpleDateFormat.parse("20170101131111")), 1);
		timeSeries.add(new Hour(simpleDateFormat.parse("20170101141111")), 1);
		timeSeries.add(new Hour(simpleDateFormat.parse("20170101151111")), 1);
		timeSeries.add(new Hour(simpleDateFormat.parse("20170101161111")), 1);
		timeSeries.add(new Hour(simpleDateFormat.parse("20170101171111")), 1);
		timeSeries.add(new Hour(simpleDateFormat.parse("20170101181111")), 1);
		timeSeries.add(new Hour(simpleDateFormat.parse("20170101191111")), 1);
		timeSeries.add(new Hour(simpleDateFormat.parse("20170101201111")), 1);
		timeSeries.add(new Hour(simpleDateFormat.parse("20170101211111")), 1);
		timeSeries.add(new Hour(simpleDateFormat.parse("20170101221111")), 1);
		timeSeries.add(new Hour(simpleDateFormat.parse("20170101231111")), 1);

		TimeSeriesCollection timeSeriesCollection = new TimeSeriesCollection();
		timeSeriesCollection.addSeries(timeSeries);

		// 创建图表
		JFreeChart jFreeChart = ChartFactory.createTimeSeriesChart("", // title 图表标题
				"小时", // categoryAxisLabel 横轴坐标名称
				"销量", // valueAxisLabel 纵轴坐标名称
				timeSeriesCollection, // dataset 数据集
				false, // legend 是否显示图例
				true, // tooltips 是否显示工具提示
				true);// urls 是否显示url

		// 设置主标题（美化图表标题）
		jFreeChart.setTitle(new TextTitle("宝马2017.1.1每小时销量", new Font("黑体", Font.BOLD, 20)));
		// 设置子标题
		// TextTitle subtitle = new TextTitle("2017年", new Font("宋体", Font.ITALIC, 12));
		// jFreeChart.addSubtitle(subtitle);
		// jFreeChart.setAntiAlias(true);

		// 设置时间轴的范围。
		XYPlot plot = (XYPlot) jFreeChart.getPlot();
		DateAxis dateaxis = (DateAxis) plot.getDomainAxis();
		dateaxis.setDateFormatOverride(new java.text.SimpleDateFormat("HH:mm"));// 格式化x轴数据显示格式,java.text.SimpleDateFormat的用法参考：http://cncoke.iteye.com/blog/1397669
		dateaxis.setTickUnit(new DateTickUnit(DateTickUnit.HOUR, 1));// x轴数据增量

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
		OutputStream os = new FileOutputStream("/Users/zhangzhiwang/Pictures/JFreeChart/折线图美化(按日).png");
		ChartUtilities.writeChartAsPNG(os, jFreeChart, 900, 500);
		System.out.println("图表生成成功！");
	}

	private static TimeSeries get(Map<Date, Double> map) {
		TimeSeries timeSeries = new TimeSeries("", Hour.class);
		for (Date date : map.keySet()) {
			timeSeries.add(new Hour(date), map.get(date));
		}
		return timeSeries;
	}
}
