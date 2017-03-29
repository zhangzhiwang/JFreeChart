package com.asiainfo.linechart;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

/**
 * 折线图美化（按周统计）
 * 
 * @author zhangzhiwang
 * @date 2017年2月27日 下午4:08:01
 */
public class LineChartSettings3 {
	public static void main(String[] args) throws IOException {
		// 准备数据
		DefaultCategoryDataset dataset = new DefaultCategoryDataset();
		dataset.addValue(15, "", "周日");
		dataset.addValue(30, "", "周一");
		dataset.addValue(17, "", "周二");
		dataset.addValue(22, "", "周三");
		dataset.addValue(35, "", "周四");
		dataset.addValue(28, "", "周五");
		dataset.addValue(30, "", "周六");

		// 创建图表
		JFreeChart jFreeChart = ChartFactory.createLineChart("宝马本周销量", "星期", "销量", dataset, PlotOrientation.VERTICAL, false, false, false);

		// 导出图片
		OutputStream os = new FileOutputStream("/Users/zhangzhiwang/Pictures/JFreeChart/折线图美化(按周).png");
		ChartUtilities.writeChartAsPNG(os, jFreeChart, 700, 500);
		System.out.println("图表生成成功！");
	}
}
