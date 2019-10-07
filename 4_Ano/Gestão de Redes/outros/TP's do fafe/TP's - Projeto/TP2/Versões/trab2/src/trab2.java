
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.Scanner;
import java.util.TimerTask;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import org.knowm.xchart.QuickChart;
import org.knowm.xchart.SwingWrapper;
import org.knowm.xchart.XYChart;
import org.knowm.xchart.XYChartBuilder;
import org.knowm.xchart.XYSeries;
import org.knowm.xchart.XYSeries.XYSeriesRenderStyle;
import org.knowm.xchart.demo.charts.ExampleChart;
import org.knowm.xchart.style.Styler;
import org.knowm.xchart.style.Styler.LegendPosition;
import org.knowm.xchart.style.markers.SeriesMarkers;
import org.snmp4j.Snmp;
import org.snmp4j.*;
import org.snmp4j.event.ResponseEvent;
import org.snmp4j.mp.SnmpConstants;
import org.snmp4j.smi.Address;
import org.snmp4j.smi.GenericAddress;
import org.snmp4j.smi.OID;
import org.snmp4j.smi.OctetString;
import org.snmp4j.smi.VariableBinding;
import org.snmp4j.transport.DefaultUdpTransportMapping;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author root
 */
public class trab2 extends javax.swing.JFrame implements ExampleChart<XYChart> {

    /**
     * Creates new form trab2
     */
    
        Snmp snmp = null;
    String address = null;
    private JFrame frame; //for the frame
    java.util.Timer timer = new java.util.Timer();

    
    public trab2() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jFrame1 = new javax.swing.JFrame();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        IPAddress = new javax.swing.JTextField();
        okButton = new javax.swing.JButton();
        stopButton = new javax.swing.JButton();

        javax.swing.GroupLayout jFrame1Layout = new javax.swing.GroupLayout(jFrame1.getContentPane());
        jFrame1.getContentPane().setLayout(jFrame1Layout);
        jFrame1Layout.setHorizontalGroup(
            jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jFrame1Layout.setVerticalGroup(
            jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Introduza o endereço IP:");

        IPAddress.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jIPAddress(evt);
            }
        });
        jScrollPane1.setViewportView(IPAddress);

        okButton.setText("OK");
        okButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                okButtonActionPerformed(evt);
            }
        });

        stopButton.setText("Stop");
        stopButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                stopButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(162, 162, 162)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(okButton, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(234, 234, 234)
                        .addComponent(stopButton)))
                .addContainerGap(239, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(okButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 46, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(stopButton)
                .addContainerGap(19, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jIPAddress(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jIPAddress
        // TODO add your handling code here:
    }//GEN-LAST:event_jIPAddress

    private void okButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_okButtonActionPerformed
        // TODO add your handling code here:
        
        String ip = IPAddress.getText();
        IPAddress.setEnabled(false);
        okButton.setEnabled(false);
        System.out.println(ip);
        
        /*ExampleChart<XYChart> exampleChart = new trab2();
        XYChart chart = exampleChart.getChart();
        new SwingWrapper<XYChart>(chart).displayChart();*/
        double[] xAges = new double[] {0};
        double[] yper=new double[]{0};
        
        double[]initdata = new double[50];
        double[]initdata2 = new double[50];
        double[]xOutOctets = new double[50];
        double[]yOutOctets = new double[50];
        initdata[0]=0;
        initdata2[0]=0;
        xOutOctets[0]=0;
        yOutOctets[0]=0;
        
        
        
        String[]octets = new String[2];
        octets[0]= "ifInOctects";
        octets[1]="ifOutOctects";

        
        
        
        final XYChart chart = QuickChart.getChart("IP Monitoring", "Time(ms)", "Bytes", "ifInOctects",initdata, initdata2);
        //chart.getStyler().setXAxisTicksVisible(false);
        
        chart.addSeries("ifOutOctects", xAges, yper);
        // Show it
        final SwingWrapper<XYChart> sw = new SwingWrapper<XYChart>(chart);
        
        sw.displayChart();

        
        
        final String ipInReceives = ".1.3.6.1.2.1.2.2.1.10.1";
                final String ipOutRequests = ".1.3.6.1.2.1.2.2.1.16.1";
                final String ipForwDatagrams = ".1.3.6.1.2.1.4.6.0";
                int i=1;
                address = "udp:" + ip;
                double duration=0;

                int delay = 1000;
                int interval = 1000;
                long start = System.currentTimeMillis();
                

                timer.scheduleAtFixedRate(new TimerTask() {
                    @Override
                    public void run() {

                        try {
                            int i=0;
                            
                            start();
                            String sIn = getAsString(new OID(ipInReceives));
                            String sOut = getAsString(new OID(ipOutRequests));
                            String sForw = getAsString(new OID(ipForwDatagrams));
                            int in, out, forw;
                            if (!sIn.equals("noSuchInstance") && !sForw.equals("noSuchInstance") && !sOut.equals("noSuchInstance")) {
                                in = Integer.parseInt(sIn);
                                forw = Integer.parseInt(sForw);
                                out = Integer.parseInt(sOut);
                                int total = forw + out;
                                String sTotal = "" + total;
                                System.out.println("| ipInReceives: " + in + "\t| ipOutRequests: " + out + "\t| ipForwDatagrams: " + forw + "\t| total: " + total + " |");
                                
                                long duration = System.currentTimeMillis() - start;
                                 
                                initdata[i]=(double)in;
                                
                                initdata2[i]=(double)duration;
                                yOutOctets[i]=(double)out;
                                xOutOctets[i]=(double)duration;
                                
                                chart.updateXYSeries("ifInOctects", initdata2, initdata, null);
                                chart.updateXYSeries("ifOutOctects",xOutOctets, yOutOctets, null);
                                sw.repaintChart();
                                i++;

                            } else
                                System.out.print("noSuchInstance");


                        } catch (IOException ex) {
                            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                }, delay, interval);

               /* Scanner scanner = new Scanner(System.in);
                while (true) {
                    if (scanner.hasNext())
                        if (scanner.next().equals("s"))
                            timer.cancel();
                    break;
                }*/
                
                
        
        
        
        
    }//GEN-LAST:event_okButtonActionPerformed

    private void stopButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_stopButtonActionPerformed
        // TODO add your handling code here:
        timer.cancel();
        
    }//GEN-LAST:event_stopButtonActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(trab2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(trab2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(trab2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(trab2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new trab2().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField IPAddress;
    private javax.swing.JFrame jFrame1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton okButton;
    private javax.swing.JButton stopButton;
    // End of variables declaration//GEN-END:variables

// Inicia a sessão snmp.
            private void start() throws IOException {
                TransportMapping transport = new DefaultUdpTransportMapping();
                snmp = new Snmp(transport);
                transport.listen();
            }
            //Recebe um OID e retorna a resposta do agente como uma String
            public String getAsString(OID oid) throws IOException {
                PDU pdu = new PDU();
                pdu.add(new VariableBinding(oid));
                pdu.setType(PDU.GET);
                ResponseEvent event = snmp.send(pdu, getTarget(), null);
                if (event != null) {
                    return event.getResponse().get(0).getVariable().toString();
                }
                throw new RuntimeException("Got null");
               
            }
            

            //This method returns a Target, which contains information about  where the data should be fetched and how.
            private Target getTarget() {
                Address targetAddress = GenericAddress.parse(address);
                CommunityTarget target = new CommunityTarget();
                target.setCommunity(new OctetString("public"));
                target.setAddress(targetAddress);
                target.setRetries(2);
                target.setTimeout(1500);
                target.setVersion(SnmpConstants.version2c);
                return target;
            }
            
            @Override
  public XYChart getChart() {
 
    // Create Chart
    XYChart chart = new XYChartBuilder().width(800).height(600).title(getClass().getSimpleName()).xAxisTitle("Age").yAxisTitle("Amount").build();
 
    // Customize Chart
    chart.getStyler().setLegendPosition(LegendPosition.InsideNW);
    chart.getStyler().setDefaultSeriesRenderStyle(XYSeriesRenderStyle.Line);
    chart.getStyler().setYAxisLabelAlignment(Styler.TextAlignment.Right);
    chart.getStyler().setYAxisDecimalPattern("$ #,###.##");
    chart.getStyler().setPlotMargin(0);
    chart.getStyler().setPlotContentSize(.95);
    
 
    // Series
    // @formatter:off
    double[] xAges = new double[] { 60, 61, 62, 63, 64, 65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87,
        88, 89, 90, 91, 92, 93, 94, 95, 96, 97, 98, 99, 100 };
 
    double[] yLiability = new double[] { 672234, 691729, 711789, 732431, 753671, 775528, 798018, 821160, 844974, 869478, 907735, 887139, 865486,
        843023, 819621, 795398, 770426, 744749, 719011, 693176, 667342, 641609, 616078, 590846, 565385, 540002, 514620, 489380, 465149, 441817,
        419513, 398465, 377991, 358784, 340920, 323724, 308114, 293097, 279356, 267008, 254873 };
 
    double[] yPercentile75th = new double[] { 800000, 878736, 945583, 1004209, 1083964, 1156332, 1248041, 1340801, 1440138, 1550005, 1647728,
        1705046, 1705032, 1710672, 1700847, 1683418, 1686522, 1674901, 1680456, 1679164, 1668514, 1672860, 1673988, 1646597, 1641842, 1653758,
        1636317, 1620725, 1589985, 1586451, 1559507, 1544234, 1529700, 1507496, 1474907, 1422169, 1415079, 1346929, 1311689, 1256114, 1221034 };
 
    double[] yPercentile50th = new double[] { 800000, 835286, 873456, 927048, 969305, 1030749, 1101102, 1171396, 1246486, 1329076, 1424666, 1424173,
        1421853, 1397093, 1381882, 1364562, 1360050, 1336885, 1340431, 1312217, 1288274, 1271615, 1262682, 1237287, 1211335, 1191953, 1159689,
        1117412, 1078875, 1021020, 974933, 910189, 869154, 798476, 744934, 674501, 609237, 524516, 442234, 343960, 257025 };
 
    // @formatter:on
 
    XYSeries seriesLiability = chart.addSeries("Liability", xAges, yLiability);
    seriesLiability.setMarker(SeriesMarkers.NONE);
 
    chart.addSeries("75th Percentile", xAges, yPercentile75th);
    chart.addSeries("50th Percentile", xAges, yPercentile50th);
 
    return chart;
  }


}
