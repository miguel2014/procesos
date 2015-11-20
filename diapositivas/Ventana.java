package diapositivas;

import javax.swing.JFrame;
import javax.swing.JPanel;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import javax.swing.JTextField;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;

public class Ventana extends JFrame{
	 JPanel panel;
	    public Ventana(){
	        setTitle("Como Hacer Graficos con Java");
	        setSize(800,600);
	        setLocationRelativeTo(null);
	        setDefaultCloseOperation(EXIT_ON_CLOSE);
	        setVisible(true);
	        init();
	    }
	 
	    private void init() {
	        panel = new JPanel();
	        getContentPane().add(panel);
	        // Fuente de Datos
	        
	        
	        DefaultCategoryDataset line_chart_dataset = new DefaultCategoryDataset();
 
	        for (int i = 0; i < 10; i++) {
	        	line_chart_dataset.addValue(10, "ping","a" );
			}
	        
	        line_chart_dataset.addValue(600, "ping", "2");
	        line_chart_dataset.addValue(1200, "ping", "3");
	        line_chart_dataset.addValue(2400, "ping", "4");
	        // Creando el Grafico
	        JFreeChart chart=ChartFactory.createLineChart("Trafico en el Blog",
	                "Mes","Visitas",line_chart_dataset,PlotOrientation.VERTICAL,
	                true,true,false);  
	        
	        // Mostrar Grafico
	        ChartPanel chartPanel = new ChartPanel(chart);
	        panel.add(chartPanel);
	    }
	    
	    public static void main(String args[]){
	        new Ventana().setVisible(true);
	    }
	}

