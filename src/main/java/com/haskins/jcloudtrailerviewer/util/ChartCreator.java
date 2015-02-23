package com.haskins.jcloudtrailerviewer.util;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.util.List;
import java.util.Map.Entry;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PiePlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.title.TextTitle;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.ui.HorizontalAlignment;

/**
 *
 * @author mark.haskins
 */
public class ChartCreator {
    
    public static ChartPanel createPieChart(List<Entry<String,Integer>> events, int width, int height) {
        
        DefaultPieDataset dataset = new DefaultPieDataset();
        
        int count = 5;
        if (events.size() < 5) {
            count = events.size();
        }
        
        for (int i=0; i<count; i++) {
            Entry<String,Integer> obj = events.get(i);
            dataset.setValue(obj.getKey(), obj.getValue());
        }
        
        JFreeChart chart = ChartFactory.createPieChart(
            "",
            dataset,
            false,
            true,
            false
        );
        
        PiePlot plot = (PiePlot) chart.getPlot();
        plot.setBackgroundPaint(null);
        plot.setInteriorGap(0.04);
        plot.setOutlineVisible(false);

        // use gradients and white borders for the section colours
        plot.setBaseSectionOutlinePaint(Color.WHITE);
        plot.setSectionOutlinesVisible(true);
        plot.setBaseSectionOutlineStroke(new BasicStroke(2.0f));

        TextTitle t = chart.getTitle();
        t.setHorizontalAlignment(HorizontalAlignment.LEFT);
        t.setFont(new Font("Arial", Font.BOLD, 16));
        
        ChartPanel sourcePanel = new ChartPanel(chart);
        sourcePanel.setPreferredSize(new Dimension(width, height));
        
        return sourcePanel;
    }
    
    public static ChartPanel createLineChart(List<Entry<String,Integer>> events, int width, int height) {
        
        JFreeChart chart = ChartFactory.createLineChart(
            "",
            "",
            "",
            null,
            PlotOrientation.VERTICAL,
            true,
            true,
            false
        );
                
        ChartPanel chartPanel = new ChartPanel(chart);
        chartPanel.setPreferredSize(new Dimension(width, height));
               
        return chartPanel;
    }
    
    public static ChartPanel createBarChart(
            List<Entry<String,Integer>> events, 
            int width, int height, 
            String xLabel, String yLabel,
            PlotOrientation orientation) {
        
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        
        int count = 5;
        if (events.size() < 5) {
            count = events.size();
        }
        
        for (int i=0; i<count; i++) {
            Entry<String,Integer> obj = events.get(i);
            dataset.addValue(obj.getValue().intValue(), obj.getKey(), "");
        }
        
        JFreeChart chart = ChartFactory.createBarChart(
            "", 
            xLabel, 
            yLabel, 
            dataset,
            orientation, 
            false, 
            true, 
            false
        );
        
        ChartPanel chartPanel = new ChartPanel(chart);
        chartPanel.setPreferredSize(new Dimension(width, height));
                        
        return chartPanel;
    }
}
