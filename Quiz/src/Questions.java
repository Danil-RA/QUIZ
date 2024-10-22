import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.PreparedStatement;


public class Questions extends javax.swing.JFrame {
public static String email; 
    private String[] questions = {
        "What is the capital of France?",
        "What is 2 + 2?",
        "Who wrote 'Hamlet'?"
    };
    int i = 0, score = 0;
    JLabel q;
    JButton next, ans1, ans2, ans3, ans4;
    
    String[][] answers = {
        {"1) Paris", "2) Ahmedabad", "3) Kolkata", "4) TVM"},  // Options for Question 1
        {"1) 2", "2) 4", "3) 6", "4) 10"},                     // Options for Question 2
        {"1) Akash", "2) Akash", "3) Adithya P", "4) Aadarsh"}  // Options for Question 3
    };
    
    private String[] correct_ans = {"1) Paris", "2) 4", "4) Aadarsh"};
    boolean scoreUpdated = false;  // Flag to ensure score is only incremented once per question
    
    public Questions() {
        // Initialize components
        initComponents();
        
        q = new JLabel(questions[i]);
        q.setBounds(100, 100, 1000, 50);
        q.setFont(new Font("Arial", Font.BOLD, 40));
        jPanel3.add(q);

        next = new JButton("Next ->");
        next.setBounds(900, 500, 120, 50);
        next.setBackground(new Color(51, 0, 153));
        next.setForeground(new Color(255, 255, 255));
        next.setFont(new Font("Arial", Font.BOLD, 18));
        jPanel3.add(next);

        ans1 = new JButton(answers[i][0]);
        ans1.setBounds(100, 200, 350, 75);
        ans1.setBackground(new Color(51, 0, 153));
        ans1.setForeground(new Color(255, 255, 255));
        ans1.setFont(new Font("Arial", Font.BOLD, 40));
        jPanel3.add(ans1);

        ans2 = new JButton(answers[i][1]);
        ans2.setBounds(650, 200, 350, 75);
        ans2.setBackground(new Color(51, 0, 153));
        ans2.setForeground(new Color(255, 255, 255));
        ans2.setFont(new Font("Arial", Font.BOLD, 40));
        jPanel3.add(ans2);

        ans3 = new JButton(answers[i][2]);
        ans3.setBounds(100, 375, 350, 75);
        ans3.setBackground(new Color(51, 0, 153));
        ans3.setForeground(new Color(255, 255, 255));
        ans3.setFont(new Font("Arial", Font.BOLD, 40));
        jPanel3.add(ans3);

        ans4 = new JButton(answers[i][3]);
        ans4.setBounds(650, 375, 350, 75);
        ans4.setBackground(new Color(51, 0, 153));
        ans4.setForeground(new Color(255, 255, 255));
        ans4.setFont(new Font("Arial", Font.BOLD, 40));
        jPanel3.add(ans4);
        
        addHoverEffect(ans1, new Color(51, 0, 153), Color.GREEN);
        addHoverEffect(ans2, new Color(51, 0, 153), Color.GREEN);
        addHoverEffect(ans3, new Color(51, 0, 153), Color.GREEN);
        addHoverEffect(ans4, new Color(51, 0, 153), Color.GREEN);

        // Answer Button Listeners
        ans1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!scoreUpdated && ans1.getText().equals(correct_ans[i])) {
                    score++;
                    scoreUpdated = true;  // Mark that score has been updated
                }
            }
        });

        ans2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!scoreUpdated && ans2.getText().equals(correct_ans[i])) {
                    score++;
                    scoreUpdated = true;
                }
            }
        });

        ans3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!scoreUpdated && ans3.getText().equals(correct_ans[i])) {
                    score++;
                    scoreUpdated = true;
                }
            }
        });

        ans4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!scoreUpdated && ans4.getText().equals(correct_ans[i])) {
                    score++;
                    scoreUpdated = true;
                }
            }
        });

        // Next button functionality to load the next question
        next.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (i < questions.length - 1) {
                    i++;
                    q.setText(questions[i]);

                    ans1.setText(answers[i][0]);
                    ans2.setText(answers[i][1]);
                    ans3.setText(answers[i][2]);
                    ans4.setText(answers[i][3]);
                    
                    scoreUpdated = false;  // Reset the scoreUpdated flag for the next question
                } else {
                    
                    JOptionPane.showMessageDialog(null, "Score: " + score);
                   // String sql = "SELECT * FROM welcome WHERE email = ?";
                    
                    
                    
                    try {
                // Database connection details
                String url = "jdbc:mysql://localhost:3306/quiz"; // Replace with your database URL
                String user = "root"; // Replace with your database username
                String password = ""; // Replace with your database password

                // Establish connection to the database
                Connection conn = DriverManager.getConnection(url, user, password);

                // Prepare the SQL query to update the score for the given email
                String sql = "UPDATE welcome SET score = ? WHERE email = ?";
                PreparedStatement pstmt = conn.prepareStatement(sql);
                
                // Set the values for the query (score and email)
                pstmt.setInt(1, score);
                pstmt.setString(2, email);

                // Execute the update query
                int rowsUpdated = pstmt.executeUpdate();

                if (rowsUpdated > 0) {
                    System.out.println("Score updated successfully for email: " + email);
                } else {
                    System.out.println("Failed to update the score. Email not found.");
                }

                // Close the connection
                conn.close();
            }
                    catch (Exception ex) {
                ex.printStackTrace();
            }
                    
                }
            }
        });

        setVisible(true);
    }
    private void addHoverEffect(final JButton button, final Color defaultColor, final Color hoverColor) {
    button.addMouseListener(new java.awt.event.MouseAdapter() {
        public void mouseEntered(java.awt.event.MouseEvent evt) {
            button.setBackground(hoverColor);
        }
        public void mouseExited(java.awt.event.MouseEvent evt) {
            button.setBackground(defaultColor);
        }
    });
}


    public void actionPerformed(ActionEvent e) {}

    @SuppressWarnings("unchecked")
    private void initComponents() {
        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(51, 0, 153));

        jPanel1.setBackground(new java.awt.Color(51, 0, 153));
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
    }

    public static void main(String args[]) {
        System.out.print(email);
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
