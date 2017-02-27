package com.asiainfo.piechart;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.DefaultPieDataset;

/**
 * 基本饼状图
 * 
 * @author zhangzhiwang
 * @date 2017年2月24日 下午4:51:28
 */
public class PieChart {
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

		// 图表导出
		OutputStream os = new FileOutputStream("/Users/zhangzhiwang/Pictures/JFreeChart/基本饼图.png");
		ChartUtilities.writeChartAsPNG(os, jFreeChart, 700, 500);
		System.out.println("图表生成成功！");
	}
}
