/**
* This class creates charts, graphs and creates the buttons and implements resultObserver class
* @author  Navjeeven Mann Singh, Omer Noor, Sundin Nguyen, Rhea Gupta
* @version 1.0
* @since   2021-04-07
*/

package mainGUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import Analysis.Analysis;
import Handlers.analysisFacade;
import Handlers.dataHandler;
import Handlers.graphHandler;
import Handlers.validChecker;
import dataModels.countryObj;
import dataModels.resultModel;
import dataModels.resultObserver;


public class MainUI extends JFrame implements resultObserver {
	
        /**
         *these are the instance variables
         */
        private static final long serialVersionUID = 1L;

        private static MainUI instance;
        private String analysisType;
        private resultModel currentModel = new resultModel();
        private validChecker validChecker = new validChecker();
        private ArrayList<countryObj> countryList;
        private Set<String> viewers = new HashSet<String>();
        private JPanel west;
        private graphHandler graphInstance = new graphHandler();

        /*
         * constructor of the class
         */
        private MainUI() {
        	
            // Set window title
            super("Country Statistics");
        	currentModel.attatch(this);


            // Set top bar
            JLabel chooseCountryLabel = new JLabel("Choose a country: ");
            Vector<String> countriesNames = new Vector<String>();
            dataHandler handler = new dataHandler();
            countryList = handler.fetchCountries();
            countryList.forEach((x) -> countriesNames.add(x.getCountryName()));
            countriesNames.sort(null);
            JComboBox<String> countriesList = new JComboBox<String>(countriesNames);

            JLabel from = new JLabel("From");
            JLabel to = new JLabel("To");
            Vector<String> toYears = new Vector<String>();
            Vector<String> fromYears = new Vector<String>();

            for (int i = 2020; i >= 1962; i--) {
            	toYears.add("" + i);
            	fromYears.insertElementAt(""+i, 0);
            }


            JComboBox<String> fromList = new JComboBox<String>(fromYears);
            JComboBox<String> toList = new JComboBox<String>(toYears);
          
            fromList.addActionListener(e -> {
                String startYear = fromList.getSelectedItem().toString();
                String endYear = toList.getSelectedItem().toString();
                countryObj country= countryList.get(countriesList.getSelectedIndex());
            	if (validChecker.checkYears(Integer.parseInt(startYear),Integer.parseInt(endYear) , country)) {
            		fromList.setForeground(Color.red);
            		toList.setForeground(Color.red);
            	} else {
             		fromList.setForeground(Color.black);
            		toList.setForeground(Color.black);
            	}
            });
            
            toList.addActionListener(e -> {
                String startYear = fromList.getSelectedItem().toString();
                String endYear = toList.getSelectedItem().toString();
                countryObj country= countryList.get(countriesList.getSelectedIndex());
            	if (validChecker.checkYears(Integer.parseInt(startYear),Integer.parseInt(endYear) , country)) {
            		fromList.setForeground(Color.red);
            		toList.setForeground(Color.red);
            	} else {
             		fromList.setForeground(Color.black);
            		toList.setForeground(Color.black);
            	}
            });
            
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
            
            viewsList.addActionListener(e -> {
            	
            	
            	if (currentModel.getCurrentAnalysis() != null && !validChecker.checkValidGraphs(currentModel.getCurrentAnalysis(), viewsList.getSelectedItem().toString())) {
            		viewsList.setForeground(Color.red);
            	
            	} else {
            		viewsList.setForeground(Color.black);
            	}
            	
            });
            
            methodsList.addActionListener(e -> {
                countryObj country= countryList.get(countriesList.getSelectedIndex());
           	 	int currentMethod = methodsList.getSelectedIndex();
           	 	analysisType = codes[currentMethod];
   
            	if (!validChecker.checkCountryAnalysis(analysisType, country)) {
            		methodsList.setForeground(Color.red);
            		countriesList.setForeground(Color.red);
            	} else {
            		methodsList.setForeground(Color.black);
            		countriesList.setForeground(Color.black);

            	}
            });

            countriesList.addActionListener(e -> {
                countryObj country= countryList.get(countriesList.getSelectedIndex());
            	if (!validChecker.checkCountryAnalysis(analysisType, country)) {
            		countriesList.setForeground(Color.red);
            		methodsList.setForeground(Color.red);

            	} else {
            		countriesList.setForeground(Color.black);
            		methodsList.setForeground(Color.black);
            	}
            });
            
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
            west = new JPanel();
            west.setLayout(new GridLayout(2, 0));
           // createCharts(west,null,null);

            getContentPane().add(north, BorderLayout.NORTH);
            getContentPane().add(east, BorderLayout.EAST);
            getContentPane().add(south, BorderLayout.SOUTH);
            getContentPane().add(west, BorderLayout.WEST);

            //Add a view
            addView.addActionListener(e -> {
            	  if (viewers.contains(viewsList.getSelectedItem().toString())){
                      JOptionPane.showMessageDialog(getInstance(), "Viewer is already being shown!");
                  } else if (!validChecker.checkValidGraphs(currentModel.getCurrentAnalysis(), viewsList.getSelectedItem().toString())) {
                	  JOptionPane.showMessageDialog(getInstance(), "Viewer is not valid for current analysis!");
                  } else {
                    viewers.add(viewsList.getSelectedItem().toString());
                    createCharts(west,currentModel.getCurrentAnalysis());
                    instance.invalidate();
                    instance.validate();
                    instance.repaint();
                }
              
            });
            //Remove a view

            removeView.addActionListener(e -> {
                if (viewers.contains(viewsList.getSelectedItem().toString())){
                    viewers.remove(viewsList.getSelectedItem().toString());
                    createCharts(west,currentModel.getCurrentAnalysis());
                    System.out.println("Removing");
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
            	 int currentMethod = methodsList.getSelectedIndex();
                 analysisType = codes[currentMethod];
                 countryObj country= countryList.get(countriesList.getSelectedIndex());
                 String startYear = fromList.getSelectedItem().toString();
                 String endYear = toList.getSelectedItem().toString();

            	if (!validChecker.checkCountryAnalysis(analysisType, country)) {
                    JOptionPane.showMessageDialog(getInstance(), "Chosen Analysis not valid for "+country.getCountryName()+"!");
            	} else if (validChecker.checkYears(Integer.parseInt(startYear),Integer.parseInt(endYear) , country)) {
            		JOptionPane.showMessageDialog(getInstance(), "Please enter valid years between "+startYear+" to "+ endYear +"!");
            	} else {
               
                analysisFacade analysisInstance = new analysisFacade();
                String yearRange=String.format("%s:%s",startYear,endYear);
                analysisInstance.getData(country, analysisType, yearRange,currentModel);
            	}
            });
        }

        /*
         * getter method that returns instance
         * @return instance 
         */
        public static MainUI getInstance() {
            if (instance == null)
                instance = new MainUI();
            	

            return instance;
        }

        /*
         * main method sets the frame
         * @param String[] args
         */
        public static void main(String[] args) {

            JFrame frame = MainUI.getInstance();
            frame.setSize(1100, 1000);
            frame.setVisible(true);
       
            
        }

        /*
         * this method creates the charts
         * @param west is the panel the graph is on
         * @param analysis This is the second parameter of the method, the analysis object contains the property of each analysis
         */
        private void createCharts(JPanel west,Analysis analysis) {
            west.removeAll();
            
            for (String viewer: viewers) {
            	System.out.println(viewer);
                if (viewer.equals("Line Chart")) {
                	graphInstance.createLine(west,analysis);
                }
                if (viewer.equals("Bar Chart")) {
                	graphInstance.createBar(west,analysis);
                }
                if (viewer.equals("Pie Chart")) {
                	graphInstance.createPie(west,analysis);
                }
                if (viewer.equals("Scatter Chart")) {
                	graphInstance.createScatter(west,analysis);
                }
                if (viewer.equals("Report")) {
                	graphInstance.createReport(west,analysis);
                }
            	viewers.add(viewer);

            }
        }
        

        
        
        /*
    	 * this method updates a graph
    	 */
		@Override
		public void updateGraphs() {
            graphInstance.updateCharts(west, currentModel.getCurrentAnalysis(),viewers);
		}

		/*
		 * this method creates a new graph from scratch
		 */
		@Override
		public void createGraphs() {
			// TODO Auto-generated method stub
            if (!currentModel.checkSame()) {
            	
                viewers =  new HashSet<>(Arrays.asList(currentModel.getCurrentAnalysis().getGraphs()));

            
            if (validChecker.checkData(currentModel.getCurrentAnalysis().getResults())) {
                createCharts(west,currentModel.getCurrentAnalysis());
                instance.invalidate();
                instance.validate();
                instance.repaint();
            } else {
        		JOptionPane.showMessageDialog(getInstance(), "No data to display for the chosen years!");

            }

        	}
			
		}







}

