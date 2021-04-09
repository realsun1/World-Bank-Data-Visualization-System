/**
* This class creates the graphs
* @author  Navjeeven Mann Singh, Omer Noor, Sundin Nguyen, Rhea Gupta
* @version 1.0
* @since   2021-04-07
*/

package Handlers;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.util.Collections;
import java.util.Map;
import java.util.Set;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JViewport;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.DateAxis;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.block.BlockBorder;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.chart.renderer.xy.XYItemRenderer;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.chart.title.TextTitle;
import org.jfree.chart.util.TableOrder;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.time.TimeSeries;
import org.jfree.data.time.TimeSeriesCollection;
import org.jfree.data.time.Year;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

import Analysis.Analysis;

public class graphHandler {
	
	/**
	 * these are instance variables creating the different graphs 
	 */
    DefaultCategoryDataset barSet = new DefaultCategoryDataset();
    DefaultCategoryDataset barSet2 = new DefaultCategoryDataset();
    DefaultCategoryDataset pieSet = new DefaultCategoryDataset();
    TimeSeriesCollection scatterSet = new TimeSeriesCollection();
    TimeSeriesCollection scatterSet2 = new TimeSeriesCollection();
    XYSeriesCollection lineSet = new XYSeriesCollection();

    /**
     * this method creates the report
     * @param west This is the first parameter of the method
     * @param analysis This is the second parameter of the method, the analysis object contains the property of each analysis
     */
    public void createReport(JPanel west, Analysis analysis) {
        JTextArea report = new JTextArea();
        report.setEditable(false);
        report.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));
        report.setBackground(Color.white);
        StringBuilder reportMessage;

        int first=9999;
        int last=-1;
        reportMessage = new StringBuilder(analysis.getTitle() + "\n" + "==============================\n");
        for (Map<Integer, Double> entry : analysis.getResults()) {
        	
        	if (Collections.min(entry.keySet()) < first) {
        		first = Collections.min(entry.keySet());
        	}
        	
        	if (Collections.max(entry.keySet()) > last) {
        		last = Collections.max(entry.keySet());
        	}

        }
        
        
        for (int i = first; i <= last; i++) {
            reportMessage.append("Year: "+i+"\n");
            Double message1 = analysis.getResults().get(0).get(i) != null ? analysis.getResults().get(0).get(i) : 0.0;
            reportMessage.append("\t"+analysis.getLegend()[0] + "=>"+message1+"\n");
            if (analysis.getResults().size()>=2){
                Double message2 = analysis.getResults().get(1).get(i) != null ? analysis.getResults().get(1).get(i) : 0.0;
                reportMessage.append("\t"+analysis.getLegend()[1] + "=>"+message2+"\n");
            }
            if (analysis.getResults().size()==3){
                Double message3 = analysis.getResults().get(2).get(i) != null ? analysis.getResults().get(2).get(i) : 0.0;
                reportMessage.append("\t"+analysis.getLegend()[2] + "=>"+message3+"\n");
            }
        }

        

        report.setText(reportMessage.toString());
        JScrollPane outputScrollPane = new JScrollPane(report);
        outputScrollPane.setPreferredSize(new Dimension(400, 300));

        int verticalPolicy = JScrollPane.VERTICAL_SCROLLBAR_ALWAYS;
        outputScrollPane.setVerticalScrollBarPolicy(verticalPolicy);
        west.add(outputScrollPane);
    }

    /**
     * this method creates a scatter plot
     * @param west This is the first parameter of the method
     * @param analysis This is the second parameter of the method, the analysis object contains the property of each analysis
     */
   public void createScatter(JPanel west, Analysis analysis) {
    	scatterSet.removeAllSeries();
    	scatterSet2.removeAllSeries();
        TimeSeries series1=new TimeSeries("1");
        TimeSeries series2=new TimeSeries("1");
        TimeSeries series3=new TimeSeries("1");
        while (true) {
            series1.setKey(analysis.getLegend()[0]);
            for (Map.Entry<Integer, Double> entry : analysis.getResults().get(0).entrySet()) {
                series1.add(new Year(entry.getKey()), entry.getValue());
            }
            if (analysis.getResults().size() == 1) break;
            series2.setKey(analysis.getLegend()[1]);
            for (Map.Entry<Integer, Double> entry : analysis.getResults().get(1).entrySet()) {
                series2.add(new Year(entry.getKey()), entry.getValue());
            }
            if (analysis.getResults().size() == 2) break;
            series3.setKey(analysis.getLegend()[2]);
            for (Map.Entry<Integer, Double> entry : analysis.getResults().get(2).entrySet()) {
                series3.add(new Year(entry.getKey()), entry.getValue());
            }
            scatterSet2.addSeries(series3);
            
            break;
        }

        scatterSet.addSeries(series1);
        scatterSet.addSeries(series2);

        XYPlot plot = new XYPlot();
        XYItemRenderer itemrenderer1 = new XYLineAndShapeRenderer(false, true);
        XYItemRenderer itemrenderer2 = new XYLineAndShapeRenderer(false, true);

        plot.setDataset(0, scatterSet);
        plot.setRenderer(0, itemrenderer1);
        DateAxis domainAxis = new DateAxis("Year");
        plot.setDomainAxis(domainAxis);
        plot.setRangeAxis(new NumberAxis(""));

        plot.setDataset(1, scatterSet2);
        plot.setRenderer(1, itemrenderer2);
        plot.setRangeAxis(1, new NumberAxis(analysis.getLabels()[0]));

        plot.mapDatasetToRangeAxis(0, 0);// 1st dataset to 1st y-axis
        if (analysis.getResults().size()==3){
            plot.mapDatasetToRangeAxis(1, 1); // 2nd dataset to 2nd y-axis
        }

        JFreeChart scatterChart = new JFreeChart(analysis.getTitle(),
                new Font("Serif", Font.BOLD, 18), plot, true);

        ChartPanel chartPanel = new ChartPanel(scatterChart);
        chartPanel.setPreferredSize(new Dimension(400, 300));
        chartPanel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));
        chartPanel.setBackground(Color.white);
        west.add(chartPanel);
    }

   /**
    * this method creates a pie chart
    * @param west This is the first parameter of the method
    * @param analysis This is the second parameter of the method, the analysis object contains the property of each analysis
    */
   public void createPie(JPanel west, Analysis analysis) {

       pieSet.clear();
        					
   
       pieSet.addValue(analysis.getResults().get(0).get(0), analysis.getLegend()[0], analysis.getLabels()[0]);
       pieSet.addValue(analysis.getResults().get(0).get(1), analysis.getLegend()[0], analysis.getLabels()[1]);




        JFreeChart pieChart = ChartFactory.createMultiplePieChart(analysis.getTitle(), pieSet,
                TableOrder.BY_ROW, true, true, false);
       
        ChartPanel chartPanel = new ChartPanel(pieChart);
        chartPanel.setPreferredSize(new Dimension(400, 300));
        chartPanel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));
        chartPanel.setBackground(Color.white);
        west.add(chartPanel);
    }

   /**
    * this method creates a bar graph
    * @param west This is the first parameter of the method, west is the panel the graph is on
    * @param analysis This is the second parameter of the method, the analysis object contains the property of each analysis
    */
   public void createBar(JPanel west, Analysis analysis) {

    	barSet.clear();
    	barSet2.clear();

        while (true) {
            for (Map.Entry<Integer, Double> entry : analysis.getResults().get(0).entrySet()) {
            	barSet.setValue(entry.getValue(), analysis.getLegend()[0], entry.getKey());
            }
            if (analysis.getResults().size() == 1) break;
            for (Map.Entry<Integer, Double> entry : analysis.getResults().get(1).entrySet()) {
            	barSet.setValue(entry.getValue(), analysis.getLegend()[1], entry.getKey());
            }
            if (analysis.getResults().size() == 2) break;
            for (Map.Entry<Integer, Double> entry : analysis.getResults().get(2).entrySet()) {
            	barSet2.setValue(entry.getValue(), analysis.getLegend()[2], entry.getKey());
            }
            break;
        }


        CategoryPlot plot = new CategoryPlot();
        BarRenderer barrenderer1 = new BarRenderer();
        BarRenderer barrenderer2 = new BarRenderer();

        plot.setDataset(0, barSet);
        plot.setRenderer(0, barrenderer1);
        CategoryAxis domainAxis = new CategoryAxis(analysis.getLabels()[0]);
        plot.setDomainAxis(domainAxis);
        plot.setRangeAxis(new NumberAxis(""));

        if (analysis.getResults().size() == 3) {
            plot.setDataset(1, barSet2);
            plot.setRenderer(1, barrenderer2);
        }

        plot.setRangeAxis(1, new NumberAxis(analysis.getLabels()[1]));

        plot.mapDatasetToRangeAxis(0, 0);// 1st dataset to 1st y-axis
        if (analysis.getResults().size() == 3) {
            plot.mapDatasetToRangeAxis(1, 1); // 2nd dataset to 2nd y-axis
        }


        JFreeChart barChart = new JFreeChart(analysis.getTitle(),
                new Font("Serif", Font.BOLD, 18), plot, true);


        ChartPanel chartPanel = new ChartPanel(barChart);
        chartPanel.setPreferredSize(new Dimension(400, 300));
        chartPanel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));
        chartPanel.setBackground(Color.white);
        west.add(chartPanel);
    }
   /**
    * this method creates a line graph
    * @param west This is the first parameter of the method, west is the panel the graph is on
    * @param analysis This is the second parameter of the method, the analysis object contains the property of each analysis
    */
   public void createLine(JPanel west, Analysis analysis) {
        XYSeries series1=new XYSeries("1");
        XYSeries series2=new XYSeries("2");
        XYSeries series3=new XYSeries("3");
        lineSet.removeAllSeries();
        while (true) {
            series1.setKey(analysis.getLegend()[0]);
            for (Map.Entry<Integer, Double> entry : analysis.getResults().get(0).entrySet()) {
                series1.add(entry.getKey(), entry.getValue());
            }
            if (analysis.getResults().size() == 1) break;
            series2.setKey(analysis.getLegend()[1]);
            for (Map.Entry<Integer, Double> entry : analysis.getResults().get(1).entrySet()) {
                series2.add(entry.getKey(), entry.getValue());
            }
            if (analysis.getResults().size() == 2) break;
            series3.setKey(analysis.getLegend()[2]);
            for (Map.Entry<Integer, Double> entry : analysis.getResults().get(2).entrySet()) {
                series3.add(entry.getKey(), entry.getValue());
            }
            break;
        }

        lineSet.addSeries(series1);
        if (analysis.getResults().size()>=2){
        	lineSet.addSeries(series2);
        }
        if (analysis.getResults().size()==3){
        	lineSet.addSeries(series3);
        }


        JFreeChart chart = ChartFactory.createXYLineChart(analysis.getTitle(), "Year", analysis.getLabels()[0], lineSet,
                PlotOrientation.VERTICAL, true, true, false);

        XYPlot plot = chart.getXYPlot();

        XYLineAndShapeRenderer renderer = new XYLineAndShapeRenderer();
        renderer.setSeriesPaint(0, Color.RED);
        renderer.setSeriesStroke(0, new BasicStroke(2.0f));

        plot.setRenderer(renderer);
        plot.setBackgroundPaint(Color.white);

        plot.setRangeGridlinesVisible(true);
        plot.setRangeGridlinePaint(Color.BLACK);

        plot.setDomainGridlinesVisible(true);
        plot.setDomainGridlinePaint(Color.BLACK);

        chart.getLegend().setFrame(BlockBorder.NONE);

        chart.setTitle(
                new TextTitle(analysis.getTitle(), new Font("Serif", Font.BOLD, 18)));

        ChartPanel chartPanel = new ChartPanel(chart);
        chartPanel.setPreferredSize(new Dimension(400, 300));
        chartPanel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));
        chartPanel.setBackground(Color.white);
        west.add(chartPanel);

    }
   
   /**
    * this method updates the report
    * @param west This is the second parameter of the method, west is the panel the graph is on
    * @param analysis This is the first parameter of the method, the analysis object contains the property of each analysis
    */
    void updateReport(Analysis analysis, JPanel west) {
        JScrollPane textPane = null;
        StringBuilder reportMessage;

        int first=9999;
        int last=-1;
        reportMessage = new StringBuilder(analysis.getTitle() + "\n" + "==============================\n");
        for (Map.Entry<Integer, Double> entry : analysis.getResults().get(0).entrySet()) {
            first=Math.min(first,entry.getKey());
            last=Math.max(first,entry.getKey());
        }
        for (int i = first; i < last; i++) {
            reportMessage.append("Year: "+i+"\n");
            reportMessage.append("\t"+analysis.getLegend()[0] + "=>"+analysis.getResults().get(0).get(i)+"\n");
            if (analysis.getResults().size()>=2){
                reportMessage.append("\t"+analysis.getLegend()[1] + "=>"+analysis.getResults().get(1).get(i)+"\n");
            }
            if (analysis.getResults().size()==3){
                reportMessage.append("\t"+analysis.getLegend()[2] + "=>"+analysis.getResults().get(2).get(i)+"\n");
            }
        }

        

        for(Component component: west.getComponents()) {

        	if (component instanceof JScrollPane) {
        		textPane = (JScrollPane) component;
        		
        	}
        	
        }
       JViewport previousReport = (JViewport) textPane.getComponents()[0];
       JTextArea previousText = (JTextArea) previousReport.getComponents()[0];
       previousText.setText(reportMessage.toString());

    }
    
    /**
     * this method updates a bar graph
     * @param analysis The analysis object contains the property of each analysis
     */
    void updateBar(Analysis analysis) { 
    	barSet.clear();
    	barSet2.clear();
        while (true) {
            for (Map.Entry<Integer, Double> entry : analysis.getResults().get(0).entrySet()) {
                barSet.setValue(entry.getValue(), analysis.getLegend()[0], entry.getKey());
            }
            if (analysis.getResults().size() == 1) break;
            for (Map.Entry<Integer, Double> entry : analysis.getResults().get(1).entrySet()) {
            	barSet.setValue(entry.getValue(), analysis.getLegend()[1], entry.getKey());
            }
            if (analysis.getResults().size() == 2) break;
            for (Map.Entry<Integer, Double> entry : analysis.getResults().get(2).entrySet()) {
            	barSet2.setValue(entry.getValue(), analysis.getLegend()[2], entry.getKey());
            }
            break;
        }

        
        
        

    }
    
    /**
     * this method updates a line graph
     * @param analysis The analysis object contains the property of each analysis
     */
	void updateLine(Analysis analysis) { 
        XYSeries series1=new XYSeries("1");
        XYSeries series2=new XYSeries("2");
        XYSeries series3=new XYSeries("3");
        lineSet.removeAllSeries();
        while (true) {
            series1.setKey(analysis.getLegend()[0]);
            for (Map.Entry<Integer, Double> entry : analysis.getResults().get(0).entrySet()) {
                series1.add(entry.getKey(), entry.getValue());
            }
            if (analysis.getResults().size() == 1) break;
            series2.setKey(analysis.getLegend()[1]);
            for (Map.Entry<Integer, Double> entry : analysis.getResults().get(1).entrySet()) {
                series2.add(entry.getKey(), entry.getValue());
            }
            if (analysis.getResults().size() == 2) break;
            series3.setKey(analysis.getLegend()[2]);
            for (Map.Entry<Integer, Double> entry : analysis.getResults().get(2).entrySet()) {
                series3.add(entry.getKey(), entry.getValue());
            }
            break;
        }

        lineSet.addSeries(series1);
        if (analysis.getResults().size()>=2){
        	lineSet.addSeries(series2);
        }
        if (analysis.getResults().size()==3){
        	lineSet.addSeries(series3);
        }
	}
	
	/**
     * this method updates a scatter plot
     * @param analysis The analysis object contains the property of each analysis
     */
	void updateScatter(Analysis analysis) { 
		scatterSet2.removeAllSeries();
		scatterSet.removeAllSeries();
		
        TimeSeries series1=new TimeSeries("1");
        TimeSeries series2=new TimeSeries("1");
        TimeSeries series3=new TimeSeries("1");
        while (true) {
            series1.setKey(analysis.getLegend()[0]);
            for (Map.Entry<Integer, Double> entry : analysis.getResults().get(0).entrySet()) {
                series1.add(new Year(entry.getKey()), entry.getValue());
            }
            if (analysis.getResults().size() == 1) break;
            series2.setKey(analysis.getLegend()[1]);
            for (Map.Entry<Integer, Double> entry : analysis.getResults().get(1).entrySet()) {
                series2.add(new Year(entry.getKey()), entry.getValue());
            }
            if (analysis.getResults().size() == 2) break;
            series3.setKey(analysis.getLegend()[2]);
            for (Map.Entry<Integer, Double> entry : analysis.getResults().get(2).entrySet()) {
                series3.add(new Year(entry.getKey()), entry.getValue());
            }
            scatterSet2.addSeries(series3);
            
            break;
        }

        scatterSet.addSeries(series1);
        scatterSet.addSeries(series2);
	}
	
	/**
     * this method updates a pie chart
     * @param analysis The analysis object contains the property of each analysis
     */
	void updatePie(Analysis analysis) {
		pieSet.clear();

		pieSet.setValue(analysis.getResults().get(0).get(0), analysis.getLegend()[0], analysis.getLabels()[0]);
		pieSet.setValue(analysis.getResults().get(0).get(1), analysis.getLegend()[0], analysis.getLabels()[1]);
		
	}
	

    
    
    
    
    
    
    
    public void updateCharts(JPanel west, Analysis toUpdate, Set<String> viewerList) { 
    	
    for(String viewer: viewerList) {
    	  if (viewer.equals("Line Chart")) {
    		    updateLine(toUpdate);
    		    
          }
          if (viewer.equals("Bar Chart")) {
        	  updateBar(toUpdate);
          }
          if (viewer.equals("Pie Chart")) {
        	    updatePie(toUpdate);
          }
          if (viewer.equals("Scatter Chart")) {
        	    updateScatter(toUpdate);
          }
          if (viewer.equals("Report")) {
        	  updateReport(toUpdate,west);
          }
    	
    	
    }


}
    
}
