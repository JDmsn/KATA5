package kata5;

import com.sun.xml.internal.ws.api.streaming.XMLStreamReaderFactory.Default;
import java.awt.Container;
import java.awt.Dimension;
import javax.swing.JFrame;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.ui.ApplicationFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;

public class HistogramDisplay extends ApplicationFrame {  
    private final Histogram<String> hm;
    
    public HistogramDisplay(Histogram<String> hm) {
        super("Histogram");
        this.hm = hm;
        setContentPane(createPanel());
        pack();
    }
    
    private ChartPanel createPanel() {
        ChartPanel chartPanel = new ChartPanel(createChart(createDataset()));
        chartPanel.setPreferredSize(new Dimension(600, 400));
        return chartPanel;
        
    }
    
    private DefaultCategoryDataset createDataset() {
        DefaultCategoryDataset dt = new DefaultCategoryDataset();
                
        for(String key : hm.keySet()) {
            dt.addValue(hm.get(key), "", key); 
        }      
        return dt;
    }
    
    private JFreeChart createChart(DefaultCategoryDataset dt) {
        JFreeChart chart = ChartFactory.createBarChart(null, "Dominios", "Nº de emails", dt, PlotOrientation.VERTICAL, false, false, false);
        return chart;
              
    }
       
    public void execute() {
        setVisible(true);
        setLocationRelativeTo(null);
    }
}
