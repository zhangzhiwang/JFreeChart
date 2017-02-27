package com.asiainfo.barchart;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;

/**
 * 垂直柱状图
 * 
 * @author zhangzhiwang
 * @date 2017年2月24日 下午2:49:15
 */
public class BarChartVertical {
	public static void main(String[] args) throws IOException {
		// 准备数据 柱状图使用CategoryDataset（分类数据集）存储数据
		DefaultCategoryDataset categoryDataset = new DefaultCategoryDataset();
		categoryDataset.addValue(10, "宝马", "1月份");//第三个参数columnKey在分组时用，columnKey相同的为一组；第二个参数rowKey相同为同一颜色
		categoryDataset.addValue(20, "奔驰", "1月份");
		categoryDataset.addValue(30, "奥迪", "1月份");
		categoryDataset.addValue(25, "宝马", "2月份");
		categoryDataset.addValue(17, "奔驰", "2月份");
		categoryDataset.addValue(33, "奥迪", "2月份");
		categoryDataset.addValue(37, "宝马", "3月份");
		categoryDataset.addValue(43, "奔驰", "3月份");
		categoryDataset.addValue(13, "奥迪", "3月份");
		categoryDataset.addValue(-18, "奥迪", "3月份");

		// 创建图表
		JFreeChart jFreeChart = ChartFactory.createBarChart("BBA 1-3月份销量", // 图表标题
				"月份", // 横轴名称
				"销量", // 纵轴名称
				categoryDataset, // 数据集
				PlotOrientation.VERTICAL, // 方向 纵向
				true, // 是否使用图例
				true, // 是否使用工具提示
				true);// 是否使用url连接
		
		//导出图片
		OutputStream os = new FileOutputStream("/Users/zhangzhiwang/Pictures/JFreeChart/垂直柱状图.png");
		ChartUtilities.writeChartAsPNG(os, jFreeChart, 700, 500);
		System.out.println("图表生成成功！");
	}
}
