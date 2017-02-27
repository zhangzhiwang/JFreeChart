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
import org.jfree.chart.plot.PiePlot3D;
import org.jfree.chart.title.TextTitle;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.util.Rotation;

/**
 * 3D饼图美化
 * 
 * @author zhangzhiwang
 * @date 2017年2月24日 下午5:20:55
 */
public class PieChart3DSettings {
	public static void main(String[] args) throws IOException {
		// 准备数据 饼状图使用DefaultPieDataset存储数据
		DefaultPieDataset defaultPieDataset = new DefaultPieDataset();
		defaultPieDataset.setValue("奥迪", 100);// 名称 数值
		defaultPieDataset.setValue("奔驰", 200);
		defaultPieDataset.setValue("宝马", 300);

		// 创建图表
		JFreeChart jFreeChart = ChartFactory.createPieChart3D("BBA销量", // 图表标题
				defaultPieDataset, // 数据集
				true, // 是否显示图例
				true, // 是否显示工具提示
				true);// 是否显示URL

		// 3D饼图美化
		PiePlot3D pieplot3d = (PiePlot3D) jFreeChart.getPlot();

		// 设置开始角度
		pieplot3d.setStartAngle(120D);
		// 设置方向为”顺时针方向“
		pieplot3d.setDirection(Rotation.CLOCKWISE);
		// 设置透明度，0.5F为半透明，1为不透明，0为全透明
		pieplot3d.setForegroundAlpha(0.7F);

		// 图表导出
		OutputStream os = new FileOutputStream("/Users/zhangzhiwang/Pictures/JFreeChart/3D饼图美化.png");
		ChartUtilities.writeChartAsPNG(os, jFreeChart, 700, 500);
		System.out.println("图表生成成功！");
	}
}
