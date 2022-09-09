package employees;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.opencsv.exceptions.CsvException;
 
public class JFileChooserExam1 {
 
    private JFrame mainFrame;
    private JLabel headerLabel;
    private JLabel statusLabel;
    private JPanel controlPanel;
    private JPanel controlPanelTwo;
    
    OpenCsvExample openCsvExample;
 
    public JFileChooserExam1() {
        prepareGUI();
    }
 
    public static void main(String[] args) {
        JFileChooserExam1 demo = new JFileChooserExam1();
        demo.showFileChooserCsv();
    }
 
    private void prepareGUI() {
        mainFrame = new JFrame("Create an UI");
        mainFrame.setSize(500, 200);
        mainFrame.setLayout(new GridLayout(4, 1));
        mainFrame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent windowEvent) {
                System.exit(0);
            }
        });
        headerLabel = new JLabel("", JLabel.CENTER);
        statusLabel = new JLabel("", JLabel.CENTER);
        statusLabel.setSize(250, 100);
        controlPanel = new JPanel();
        controlPanel.setLayout(new FlowLayout());
        
        controlPanelTwo = new JPanel();
        controlPanelTwo.setLayout(new GridLayout(5, 1));
        mainFrame.add(headerLabel);
        mainFrame.add(controlPanel);
        mainFrame.add(statusLabel);
        
        mainFrame.add(controlPanelTwo);
        mainFrame.setVisible(true);
    }
 
    private void showFileChooserCsv() {
        headerLabel.setText("Select CSV file: JFileChooser");
        final JFileChooser fileDialog = new JFileChooser();
        JButton showFileDialogButton = new JButton("Open File");
        showFileDialogButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int returnVal = fileDialog.showOpenDialog(mainFrame);
                if (returnVal == JFileChooser.APPROVE_OPTION) {
                    java.io.File file = fileDialog.getSelectedFile();
                    
                    try {
                    	showHeaderLabel();
                    	List<DataGrid> dgl = openCsvExample.gridview(file.getAbsolutePath());
                    	
                    	for(int i= 0; i< dgl.size(); i++) {
                    		showLabelGridView(dgl.get(i));
                    	}
					} catch (IOException e0) {
						e0.printStackTrace();
					} catch (CsvException e1) {
						e1.printStackTrace();
					}
                } else {
                    statusLabel.setText("Open command cancelled by user.");
                }
            }
        });
        controlPanel.add(showFileDialogButton);
        mainFrame.setVisible(true);
    }
    
    private void showLabelGridView(DataGrid dg) {
        JLabel label1 = new JLabel("", JLabel.CENTER);
        label1.setText(String.valueOf(dg.getEmpIdOne()));
        label1.setOpaque(true);
        label1.setBackground(Color.GRAY);
        label1.setForeground(Color.WHITE);
        controlPanelTwo.add(label1);
        
        JLabel label2 = new JLabel("", JLabel.CENTER);
        label2.setText(String.valueOf(dg.getEmpIdTwo()));
        label2.setOpaque(true);
        label2.setBackground(Color.GRAY);
        label2.setForeground(Color.WHITE);
        controlPanelTwo.add(label2);
        
        JLabel label3 = new JLabel("", JLabel.CENTER);
        label3.setText(String.valueOf(dg.getProjectId()));
        label3.setOpaque(true);
        label3.setBackground(Color.GRAY);
        label3.setForeground(Color.WHITE);
        controlPanelTwo.add(label3);
        
        JLabel label4 = new JLabel("", JLabel.CENTER);
        label4.setText(String.valueOf(dg.getDaysWorked()));
        label4.setOpaque(true);
        label4.setBackground(Color.GRAY);
        label4.setForeground(Color.WHITE);
        controlPanelTwo.add(label4);
        mainFrame.setVisible(true);
    }
    
    private void showHeaderLabel() {
    	JLabel label1 = new JLabel("", JLabel.CENTER);
        label1.setText("Employee ID #1");
        label1.setOpaque(true);
        label1.setBackground(Color.GRAY);
        label1.setForeground(Color.WHITE);
        controlPanelTwo.add(label1);
        
        JLabel label2 = new JLabel("", JLabel.CENTER);
        label2.setText("Employee ID #2");
        label2.setOpaque(true);
        label2.setBackground(Color.GRAY);
        label2.setForeground(Color.WHITE);
        controlPanelTwo.add(label2);
        
        JLabel label3 = new JLabel("", JLabel.CENTER);
        label3.setText("Project ID");
        label3.setOpaque(true);
        label3.setBackground(Color.GRAY);
        label3.setForeground(Color.WHITE);
        controlPanelTwo.add(label3);
        
        JLabel label4 = new JLabel("", JLabel.CENTER);
        label4.setText("Days worked");
        label4.setOpaque(true);
        label4.setBackground(Color.GRAY);
        label4.setForeground(Color.WHITE);
        controlPanelTwo.add(label4);
        mainFrame.setVisible(true);
    }
}