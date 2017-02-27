package com.asiainfo.piechart;

import java.awt.Font;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.text.NumberFormat;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.labels.StandardPieSectionLabelGenerator;
import org.jfree.chart.plot.PiePlot;
import org.jfree.chart.title.TextTitle;
import org.jfree.data.general.DefaultPieDataset;

/**
 * 饼图美化
 * 
 * @author zhangzhiwang
 * @date 2017年2月24日 下午5:27:24
 */
public class PieChartSettings {
	public static void main(String[] args) throws IOException {
		// 准备数据 饼状图使用DefaultPieDataset存储数据
		DefaultPieDataset defaultPieDataset = new DefaultPieDataset();
		defaultPieDataset.setValue("奥迪", 100);// 名称 数值
		defaultPieDataset.setValue("奔驰", 200);
		defaultPieDataset.setValue("宝马", 300);

		// 创建图表
		JFreeChart jFreeChart = ChartFactory.createPieChart("BBA销量", // 图表标题
				defaultPieDataset, // 数据集
				true, // 是否显示图例
				true, // 是否显示工具提示
				true);// 是否显示URL

		// 图表美化，饼图详细属性设置参见：http://www.cnblogs.com/zhongshiqiang/p/5818957.html
		jFreeChart.addSubtitle(new TextTitle("2016年度"));// 副标题

		PiePlot pieplot = (PiePlot) jFreeChart.getPlot();
		pieplot.setLabelFont(new Font("黑体", 0, 11));//标签字体，即defaultPieDataset.setValue()方法的第一个参数值的字体
		pieplot.setCircular(false);// 设置饼图是圆的（true），还是椭圆的（false）；默认为true
		pieplot.setIgnoreZeroValues(true); //忽略值为0的数据 
		pieplot.setIgnoreNullValues(true); //忽略null值
		StandardPieSectionLabelGenerator standarPieIG = new StandardPieSectionLabelGenerator("{0}:({1}.{2})", NumberFormat.getNumberInstance(), NumberFormat.getPercentInstance());//各部分显示数据
		pieplot.setLabelGenerator(standarPieIG);

		// 图表导出
		OutputStream os = new FileOutputStream("/Users/zhangzhiwang/Pictures/JFreeChart/饼图美化.png");
		ChartUtilities.writeChartAsPNG(os, jFreeChart, 700, 500);
		System.out.println("图表生成成功！");
	}
}
