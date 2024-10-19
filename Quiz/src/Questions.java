/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Admin
 */
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Questions extends javax.swing.JFrame {

    /**
     * Creates new form Questions
     */
    private String[] questions = {
            "What is the capital of France?",
            "What is 2 + 2?",
            "Who wrote 'Hamlet'?"};
    int i =0,score = 0;
    JLabel q;
    JButton next,ans1,ans2,ans3,ans4;
    
    String[][] answers = {
            {"1) Paris", "2) Ahemedabad", "3) Kolkatta", "4) TVM"}, // Options for Question 1
            {"1) 2", "2) 4", "3) 6", "4) 10"},                       // Options for Question 2
            {"1) Akash", "2) Akash", "3) Adithya P", "4) Aadarsh"}  // Options for Question 3
        };
    
    private String[] correct_ans = {"1) Paris", "2) 4", "4) Aadarsh"};
    public Questions() {
        //=============================================Questions============================================
        initComponents();
        q = new JLabel(questions[i]);
        q.setBounds(100, 100, 1000, 50);
        q.setFont(new Font("Arial", Font.BOLD, 40));
        jPanel3.add(q);
        //================================================================================================
        //==============================================NEXT BUTTON=======================================
        next = new JButton("Next - >");
        next.setBounds(900,500,120,50);
        next.setBackground(new Color(51, 0, 153)); // Custom light blue color
        next.setForeground(new Color(255, 255, 255));
        next.setFont(new Font("Arial", Font.BOLD, 18));
        jPanel3.add(next);
        //=================================================================================================
       //================================================ANSWER BUTTONS======================================
        ans1 = new JButton(answers[i][0]);
        ans1.setBounds(100,200,350,75);
        ans1.setBackground(new Color(51, 0, 153)); // Custom light blue color
        ans1.setForeground(new Color(255, 255, 255));
        ans1.setFont(new Font("Arial", Font.BOLD, 40));
        jPanel3.add(ans1);
        
        ans2 = new JButton(answers[i][1]);
        ans2.setBounds(650,200,350,75);
        ans2.setBackground(new Color(51, 0, 153)); // Custom light blue color
        ans2.setForeground(new Color(255, 255, 255));
        ans2.setFont(new Font("Arial", Font.BOLD, 40));
        jPanel3.add(ans2);
        
        
        ans3 = new JButton(answers[i][2]);
        ans3.setBounds(100,375,350,75);
        ans3.setBackground(new Color(51, 0, 153)); // Custom light blue color
        ans3.setForeground(new Color(255, 255, 255));
        ans3.setFont(new Font("Arial", Font.BOLD, 40));
        jPanel3.add(ans3);
        
        
        ans4 = new JButton(answers[i][3]);
        ans4.setBounds(650,375,350,75);
        ans4.setBackground(new Color(51, 0, 153)); // Custom light blue color
        ans4.setForeground(new Color(255, 255, 255));
        ans4.setFont(new Font("Arial", Font.BOLD, 40));
        jPanel3.add(ans4);
        
        
        
        
        ans1.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                if(i < questions.length)
                {
                    if(ans1.getText().equals(correct_ans[i])){
                        score++;
                       
                    }
                    
                }
            }
        });
        
        
        ans2.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                if(i < questions.length)
                {
                    if(ans2.getText().equals(correct_ans[i])){
                        score++;
                        
                    }
                    
                }
            }
        });
        
        
        ans3.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                if(i < questions.length)
                {
                    if(ans3.getText().equals(correct_ans[i])){
                        score++;
                       
                    }
                    
                }
            }
        });
        
        
        ans4.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                if(i < questions.length)
                {
                    if(ans4.getText().equals(correct_ans[i])){
                        score++;
                    }
                    
                }
            }
        });
        
        
        
        
        
        
        
        next.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                if(i < questions.length - 1)
                {
                    i++;
                    q.setText(questions[i]);
                    
                    
                    ans1.setText(answers[i][0]);
                    ans2.setText(answers[i][1]);
                    ans3.setText(answers[i][2]);
                    ans4.setText(answers[i][3]);
                    
                    
                }
                else{
                    JOptionPane.showMessageDialog(null, "Score: "+ score);
                }
            }
        });
        
       
        
        
     
         setVisible(true);
        //Ques.setText("Hello");
    }
    public void actionPerformed(ActionEvent e)
    {};

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(51, 0, 153));

        jPanel1.setBackground(new java.awt.Color(51, 0, 153));
        jPanel1.setForeground(new java.awt.Color(240, 240, 240));
        jPanel1.setToolTipText("");
        jPanel1.setPreferredSize(new java.awt.Dimension(1206, 720));

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1119, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 638, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(25, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(46, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 1166, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 730, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>                        

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
            java.util.logging.Logger.getLogger(Questions.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Questions.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Questions.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Questions.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Questions().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify                     
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    // End of variables declaration                   
}
