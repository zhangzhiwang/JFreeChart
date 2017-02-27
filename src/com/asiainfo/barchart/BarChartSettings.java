package com.asiainfo.barchart;

import java.awt.Color;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.AxisLocation;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.CategoryLabelPositions;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.labels.ItemLabelAnchor;
import org.jfree.chart.labels.ItemLabelPosition;
import org.jfree.chart.labels.StandardCategoryItemLabelGenerator;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.BarRenderer3D;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.ui.TextAnchor;

/**
 * 
 * 
 * @author zhangzhiwang
 * @date 2017年2月24日 下午4:15:21
 */
public class BarChartSettings {
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

		// 图表美化，要设置图片高级属性先获得 CategoryPlot 和 BarRenderer3D 大部分修改都是在这上面
		// jfreeChart柱状图各属性详细设置参见：http://www.cnblogs.com/zhongshiqiang/p/5868710.html
		CategoryPlot plot = jFreeChart.getCategoryPlot();
		// 设置网格背景颜色
		plot.setBackgroundPaint(Color.white);
		// 设置网格竖线颜色
		plot.setDomainGridlinePaint(Color.yellow);
		// 设置网格横线颜色
		plot.setRangeGridlinePaint(Color.BLUE);

		// 显示每个柱的数值，并修改该数值的字体属性
		BarRenderer3D renderer = new BarRenderer3D();
		renderer.setBaseItemLabelGenerator(new StandardCategoryItemLabelGenerator());
		renderer.setBaseItemLabelsVisible(true);

		renderer.setBasePositiveItemLabelPosition(new ItemLabelPosition(ItemLabelAnchor.OUTSIDE12, TextAnchor.BASELINE_LEFT));
		renderer.setItemLabelAnchorOffset(10D);

		// 设置平行柱的之间距离
		renderer.setItemMargin(0.4);

		// 对X轴做操作
		CategoryAxis domainAxis = plot.getDomainAxis();
		// 对Y轴做操作
		ValueAxis rAxis = plot.getRangeAxis();

		// 横轴上的 Lable 45度倾斜
		domainAxis.setCategoryLabelPositions(CategoryLabelPositions.DOWN_45);
		// 将默认放到左边的数值放到右边
		plot.setRangeAxisLocation(AxisLocation.BOTTOM_OR_RIGHT);

		plot.setRenderer(renderer);

		// 导出图片
		OutputStream os = new FileOutputStream("/Users/zhangzhiwang/Pictures/JFreeChart/柱状图属性设置.png");
		ChartUtilities.writeChartAsPNG(os, jFreeChart, 700, 500);
		System.out.println("图表生成成功！");
	}
}
