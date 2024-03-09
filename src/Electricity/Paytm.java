package Electricity;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.awt.desktop.AboutEvent;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Paytm extends JFrame implements ActionListener{
    String meter;
    JButton b1;
    Paytm(String meter) throws IOException{
        this.meter = meter;
        JEditorPane j = new JEditorPane();
        j.setEditable(false);   
        
        b1 = new JButton("Back");
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        b1.setBounds(500, 20, 120, 25);
        b1.addActionListener(this);
        j.add(b1);

        try {
            j.setPage("https://paytm.com/electricity-bill-payment");
        }catch (Exception e) {
            j.setContentType("text/html");
            j.setText("<html>Could not load</html>");
        } 
 Desktop d = Desktop.getDesktop();
        try {
            d.browse(new URI("https://paytm.com/electricity-bill-payment"));
        } catch (URISyntaxException ex) {
            Logger.getLogger(Paytm.class.getName()).log(Level.SEVERE, null, ex);
        }
        JScrollPane scrollPane = new JScrollPane(j);     
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().add(scrollPane);
        setPreferredSize(new Dimension(800,600));
        setSize(800,800);
        setLocation(250,120);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        this.setVisible(false);
        new PayBill(meter).setVisible(true);
    }
    public static void main(String[] args) throws IOException{
        new Paytm("").setVisible(true);
       
    }
}
