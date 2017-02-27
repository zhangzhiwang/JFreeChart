package com.asiainfo.barchart;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

/**
 * 三维柱状图
 * 
 * @author zhangzhiwang
 * @date 2017年2月24日 下午3:43:40
 */
public class BarChart3D_2 {
	public static void main(String[] args) throws IOException {
		// 准备数据 柱状图使用CategoryDataset（分类数据集）存储数据
		DefaultCategoryDataset categoryDataset = new DefaultCategoryDataset();
		categoryDataset.addValue(10, "宝马", "安全");// 此例就是用来展示addValue()方法的第三个参数是用来分组用的，相同值为一组
		categoryDataset.addValue(20, "宝马", "驾驶乐趣");// rowKey相同为同一颜色
		categoryDataset.addValue(30, "宝马", "豪华");

		categoryDataset.addValue(25, "奔驰", "安全");
		categoryDataset.addValue(17, "奔驰", "驾驶乐趣");
		categoryDataset.addValue(33, "奔驰", "豪华");

		categoryDataset.addValue(37, "奥迪", "安全");
		categoryDataset.addValue(43, "奥迪", "驾驶乐趣");
		categoryDataset.addValue(13, "奥迪", "豪华");

		// 创建图表
		JFreeChart jFreeChart = ChartFactory.createBarChart3D("BBA各项系数评分", // 图表标题
				"评分项", // 横轴名称
				"分数", // 纵轴名称
				categoryDataset, // 数据集
				PlotOrientation.VERTICAL, // 方向 纵向
				true, // 是否使用图例
				true, // 是否使用工具提示
				true);// 是否使用url连接

		// 导出图片
		OutputStream os = new FileOutputStream("/Users/zhangzhiwang/Pictures/JFreeChart/三维柱状图2.png");
		ChartUtilities.writeChartAsPNG(os, jFreeChart, 700, 500);
		System.out.println("图表生成成功！");
	}
}
