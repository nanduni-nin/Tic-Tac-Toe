/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoe;

import controller.ScoreController;
import java.awt.Component;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumnModel;

/**
 *
 * @author Nands
 */
public class ScoresList extends javax.swing.JFrame {

    String[] title = {"Player", "Best Score"};
    DefaultTableModel dtm = new DefaultTableModel(title, 0) {
        @Override
        public boolean isCellEditable(int row, int column) {
            return false;
        }
    };

    public ScoresList() throws ClassNotFoundException, FileNotFoundException, IOException, SQLException {
        initComponents();
        File imgfile = new File("..\\TicTacToe\\src\\images\\flower.png");
        FileInputStream imgStream = new FileInputStream(imgfile);
        BufferedImage bi = ImageIO.read(imgStream);
        ImageIcon myImg = new ImageIcon(bi);
        this.setIconImage(myImg.getImage());
        setVisible(true);
        setSize(350,550);
        fillTable();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        scoreTable = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        playerLbl = new javax.swing.JLabel();
        scoreLbl = new javax.swing.JLabel();

        setTitle("Score Board");
        getContentPane().setLayout(null);

        jLabel2.setFont(new java.awt.Font("Monotype Corsiva", 1, 36)); // NOI18N
        jLabel2.setText("Score Board");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(70, 40, 180, 30);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/images (3).jpg"))); // NOI18N
        jLabel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        getContentPane().add(jLabel1);
        jLabel1.setBounds(20, 20, 300, 80);

        scoreTable.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(153, 255, 153), 2, true));
        scoreTable.setModel(dtm);
        jScrollPane1.setViewportView(scoreTable);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(20, 120, 300, 230);

        jPanel1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(153, 153, 0), 3, true));
        jPanel1.setLayout(null);

        jPanel2.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(153, 255, 153), 2, true));

        jLabel3.setFont(new java.awt.Font("Rockwell Extra Bold", 3, 15)); // NOI18N
        jLabel3.setText("Best Score :  ");
        jPanel2.add(jLabel3);

        playerLbl.setFont(new java.awt.Font("Times New Roman", 3, 14)); // NOI18N
        playerLbl.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        jPanel2.add(playerLbl);

        scoreLbl.setFont(new java.awt.Font("Times New Roman", 3, 14)); // NOI18N
        scoreLbl.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        jPanel2.add(scoreLbl);

        jPanel1.add(jPanel2);
        jPanel2.setBounds(20, 450, 300, 50);

        getContentPane().add(jPanel1);
        jPanel1.setBounds(0, 0, 340, 520);

        setSize(new java.awt.Dimension(361, 559));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(ScoresList.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ScoresList.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ScoresList.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ScoresList.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new ScoresList().setVisible(true);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(ScoresList.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IOException ex) {
                    Logger.getLogger(ScoresList.class.getName()).log(Level.SEVERE, null, ex);
                } catch (SQLException ex) {
                    Logger.getLogger(ScoresList.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel playerLbl;
    private javax.swing.JLabel scoreLbl;
    private javax.swing.JTable scoreTable;
    // End of variables declaration//GEN-END:variables

    private void fillTable() throws ClassNotFoundException, SQLException {
        try {
            ResultSet rst = null;
            rst = ScoreController.getScoreInfo();

            scoreTable.setModel(dtm);

            while (rst.next()) {

                String player = rst.getString("userName");
                String marks = rst.getString("score");

                String[] selectedRow = {player, marks};
                dtm.addRow(selectedRow);

                resizeColumnWidth(scoreTable);
                scoreTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Data Error");
        }
        
        playerLbl.setText(ScoreController.getWinner());
        scoreLbl.setText(Integer.toString(ScoreController.getMaximumScore()));
        
    }

    public void resizeColumnWidth(JTable table) {
        final TableColumnModel columnModel = table.getColumnModel();
        for (int column = 0; column < table.getColumnCount(); column++) {
            int width = 50;
            for (int row = 0; row < table.getRowCount(); row++) {
                TableCellRenderer renderer = table.getCellRenderer(row, column);
                Component comp = table.prepareRenderer(renderer, row, column);
                width = Math.max(comp.getPreferredSize().width, width);
            }
            columnModel.getColumn(column).setPreferredWidth(width);
        }
    }
}
