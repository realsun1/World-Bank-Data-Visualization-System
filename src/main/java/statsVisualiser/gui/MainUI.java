package statsVisualiser.gui;

import Analysis.Analysis;
import Handlers.analysisFacade;

import java.awt.BasicStroke;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.Vector;

import javax.swing.*;


public class MainUI extends JFrame {
        /**
         *
         */
        private static final long serialVersionUID = 1L;

        private static MainUI instance;
        private String analysisType;
        private Analysis currentAnalysis;

        private Set<String> viewers = new HashSet<String>();

        private MainUI() {

            // Set window title
            super("Country Statistics");

            // Set top bar
            JLabel chooseCountryLabel = new JLabel("Choose a country: ");
            Vector<String> countriesNames = new Vector<String>();
            countriesNames.add("Botswana");
            countriesNames.add("Cambodia");
            countriesNames.add("Canada");
            countriesNames.add("Cyprus");
            countriesNames.add("United States Minor Outlying Islands");
            countriesNames.sort(null);
            JComboBox<String> countriesList = new JComboBox<String>(countriesNames);

            JLabel from = new JLabel("From");
            JLabel to = new JLabel("To");
            Vector<String> years = new Vector<String>();
            for (int i = 2021; i >= 2000; i--) {
                years.add("" + i);
            }


            JComboBox<String> fromList = new JComboBox<String>(years);
            JComboBox<String> toList = new JComboBox<String>(years);

            JPanel north = new JPanel();
            north.add(chooseCountryLabel);
            north.add(countriesList);
            north.add(from);
            north.add(fromList);
            north.add(to);
            north.add(toList);

            // Set bottom bar
            JButton recalculate = new JButton("Recalculate");

            JLabel viewsLabel = new JLabel("Available Views: ");

            Vector<String> viewsNames = new Vector<String>();
            viewsNames.add("Pie Chart");
            viewsNames.add("Line Chart");
            viewsNames.add("Bar Chart");
            viewsNames.add("Scatter Chart");
            viewsNames.add("Report");
            JComboBox<String> viewsList = new JComboBox<String>(viewsNames);
            JButton addView = new JButton("+");
            JButton removeView = new JButton("-");

            JLabel methodLabel = new JLabel("        Choose analysis method: ");

            Vector<String> methodsNames = new Vector<String>();
            methodsNames.add("CO2 Emissions vs Energy Use vs Air Pollution");
            methodsNames.add("Air pollution vs Forest Area");
            methodsNames.add("Ratio of CO2 Emissions and GDP Per Capita");
            methodsNames.add("Average Forest Area");
            methodsNames.add("Average of Government expenditure on education, total (% of GDP)");
            methodsNames.add("Ratio of Hospital beds and Current health expenditure");
            methodsNames.add("Current health expenditure per capita vs Mortality rate, infant");
            methodsNames.add("Ratio of Government expenditure on education vs Current health expenditure");
            JComboBox<String> methodsList = new JComboBox<String>(methodsNames);

            String[] codes = {"EEP","PVF","GEG","GFA","EAV","BVE","EVM","EVH"};


            JPanel south = new JPanel();
            south.add(viewsLabel);
            south.add(viewsList);
            south.add(addView);
            south.add(removeView);

            south.add(methodLabel);
            south.add(methodsList);
            south.add(recalculate);

            JPanel east = new JPanel();

            // Set charts region
            JPanel west = new JPanel();
            west.setLayout(new GridLayout(2, 0));
            createCharts(west,null,null);

            getContentPane().add(north, BorderLayout.NORTH);
            getContentPane().add(east, BorderLayout.EAST);
            getContentPane().add(south, BorderLayout.SOUTH);
            getContentPane().add(west, BorderLayout.WEST);

            //Add a view
            addView.addActionListener(e -> {
                if (!viewers.contains(viewsList.getSelectedItem().toString())){
                    viewers.add(viewsList.getSelectedItem().toString());
                    createCharts(west,currentAnalysis,analysisType);
                    instance.invalidate();
                    instance.validate();
                    instance.repaint();
                }
                else{
                    JOptionPane.showMessageDialog(getInstance(), "Viewer is already being shown!");
                }
            });
            //Remove a view

            removeView.addActionListener(e -> {
                if (viewers.contains(viewsList.getSelectedItem().toString())){
                    viewers.remove(viewsList.getSelectedItem().toString());
                    createCharts(west,currentAnalysis,analysisType);
                    instance.invalidate();
                    instance.validate();
                    instance.repaint();
                }
                else{
                    JOptionPane.showMessageDialog(getInstance(), "No such viewer to remove!");
                }
            });

            //Recalculate
            recalculate.addActionListener(e -> {
                west.removeAll();
                int currentMethod = methodsList.getSelectedIndex();
                analysisType = codes[currentMethod];
                Handlers.analysisFacade analysisInstance = new analysisFacade();
                String country=countriesList.getSelectedItem().toString();
                String yearRange=String.format("%s:%s",fromList.getSelectedItem().toString(),toList.getSelectedItem().toString());
                currentAnalysis = analysisInstance.analysisTest(country, yearRange, analysisType);
                createCharts(west,currentAnalysis,analysisType);
                instance.invalidate();
                instance.validate();
                instance.repaint();
            });


        }

        public static MainUI getInstance() {
            if (instance == null)
                instance = new statsVisualiser.gui.MainUI();

            return instance;
        }

        public static void main(String[] args) {

            JFrame frame = statsVisualiser.gui.MainUI.getInstance();
            frame.setSize(1100, 800);
            frame.setVisible(true);
        }

        private void createCharts(JPanel west,Analysis analysis, String analysisType) {
            west.removeAll();
            graphHandler graphInstance = new graphHandler();
            System.out.println(viewers);
            for (String viewer: viewers) {
                if (viewer.equals("Line Chart")) graphInstance.createLine(west,analysis);
                if (viewer.equals("Bar Chart")) graphInstance.createBar(west,analysis);
                if (viewer.equals("Pie Chart")) graphInstance.createPie(west,analysis);
                if (viewer.equals("Scatter Chart")) graphInstance.createScatter(west,analysis);
                if (viewer.equals("Report")) graphInstance.createReport(west,analysis);
            }



        }







    }

