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
    private JTextField textField;
    public Ventana(){
        setTitle("Grafica de ping");
        setSize(800,600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        init();
    }
 
    private void init() {
       // panel = new JPanel();
        GridBagConstraints layout;
        //getContentPane().add(panel);
        // Fuente de Datos
        DefaultCategoryDataset line_chart_dataset = new DefaultCategoryDataset();
        line_chart_dataset.addValue(80, "ping", "1");
        line_chart_dataset.addValue(300, "ping", "2");
        line_chart_dataset.addValue(60.50, "ping", "3");
        line_chart_dataset.addValue(1200, "ping", "4");
        line_chart_dataset.addValue(2400, "ping", "5");  
 
        // Creando el Grafico
        JFreeChart chart=ChartFactory.createLineChart("Grafico de ping",
                "Paquetes","Tiempo",line_chart_dataset,PlotOrientation.VERTICAL,true,true,false);  
        
        // Mostrar Grafico
        ChartPanel chartPanel = new ChartPanel(chart);
        panel.add(chartPanel);
        GridBagLayout gbl_chartPanel = new GridBagLayout();
        gbl_chartPanel.columnWidths = new int[]{283, 114, 0};
        gbl_chartPanel.rowHeights = new int[]{19, 0};
        gbl_chartPanel.columnWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
        gbl_chartPanel.rowWeights = new double[]{0.0, Double.MIN_VALUE};
        chartPanel.setLayout(gbl_chartPanel);
        
        textField = new JTextField();
        layout = new GridBagConstraints();
        layout.anchor = GridBagConstraints.NORTHWEST;
        layout.gridx = 1;
        layout.gridy = 0;
        chartPanel.add(textField, layout);
        textField.setColumns(10);
    }
    
    public static void main(String args[]){
        new Ventana().setVisible(true);
    }
}

