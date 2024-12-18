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
        "1.In Java, which of these keywords is used to inherit a class?",
        "2.What is the default access modifier for class members in Java?",
        "3.In Java, which method is used to compare two strings for equality?",
        "4.Which method is used to start a thread in Java?",
        "5.What is the default value of a boolean variable in Java?"
    };
    int i = 0, s, n = 0;
    public static int score = 0;
    // public static int Globalscore = score;
    JLabel q;
    JButton next, ans1, ans2, ans3, ans4;

    int[] topScore = new int[3];
    String[][] answers = {
        {"1) inherit", "2) implements", "3) extends", "4) override"},  
        {"1) public", "2) protected", "3) default", "4) private"},                     
        {"1) ==", "2) equals()", "3) compareTo()", "4) equal()"},
        {"1) run()", "2) begin()", "3) start()", "4) execute()"},
        {"1) true", "2) false", "3) 0", "4) null"}
    };
    
    private String[] correct_ans = {"3) extends", "3) default", "2) equals()", "3) start()", "2) false"};
    JButton lastSelectedButton = null;  
    String ans; 
    
    public Questions() {
    initComponents(); // Ensure components are initialized first
    
    // Now add the rest of the constructor code
    q = new JLabel(questions[i]);
    q.setBounds(100, 100, 1000, 50);
    q.setFont(new Font("Arial", Font.BOLD, 30));
    jPanel3.add(q);

    next = new JButton("Next ->");
    next.setBounds(900, 500, 120, 50);
    next.setBackground(new Color(51, 0, 153));
    next.setForeground(new Color(255, 255, 255));
    next.setFont(new Font("Arial", Font.BOLD, 18));
    jPanel3.add(next);

    ans1 = new JButton(answers[i][0]);
    ans2 = new JButton(answers[i][1]);
    ans3 = new JButton(answers[i][2]);
    ans4 = new JButton(answers[i][3]);

    setupAnswerButton(ans1, 100, 200);
    setupAnswerButton(ans2, 650, 200);
    setupAnswerButton(ans3, 100, 375);
    setupAnswerButton(ans4, 650, 375);
    
    // Next button functionality to load the next question
    next.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (i < questions.length - 1) {
                if (ans != null && ans.equals(correct_ans[i])) {
                    score += 10;
                }
                i++;
                q.setText(questions[i]);

                ans1.setText(answers[i][0]);
                ans2.setText(answers[i][1]);
                ans3.setText(answers[i][2]);
                ans4.setText(answers[i][3]);

                if (lastSelectedButton != null) {
                    lastSelectedButton.setBackground(new Color(51, 0, 153));
                }
            } else {
                if (ans != null && ans.equals(correct_ans[i])) {
                    score += 10;
                }
                // Database connection and Leader frame logic
                try {
                    String url = "jdbc:mysql://localhost:3306/quiz";
                    String user = "root";
                    String password = "";

                    Connection conn = DriverManager.getConnection(url, user, password);

                    String sql2 = "SELECT score FROM welcome WHERE email = ?";
                    PreparedStatement pstmt2 = conn.prepareStatement(sql2);
                    pstmt2.setString(1, email);

                    ResultSet rs2 = pstmt2.executeQuery();
                    if (rs2.next()) {
                        s = rs2.getInt("score");
                    }

                    if (score > s) {
                        String sql = "UPDATE welcome SET score = ? WHERE email = ?";
                        PreparedStatement pstmt = conn.prepareStatement(sql);
                        pstmt.setInt(1, score);
                        pstmt.setString(2, email);
                        pstmt.executeUpdate();
                    }

                    Leader obj = new Leader();
                    obj.setVisible(true);
                    dispose();
                    conn.close();
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        }
    });
}
    
    
    
    private void setupAnswerButton(final JButton button, int x, int y) {
        button.setBounds(x, y, 300, 65);
        button.setBackground(new Color(51, 0, 153));
        button.setForeground(Color.WHITE);
        button.setFont(new Font("Arial", Font.BOLD, 30));
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ans = button.getText();

                if (lastSelectedButton != null) {
                    lastSelectedButton.setBackground(new Color(51, 0, 153));
                }
                button.setBackground(Color.BLUE);
                lastSelectedButton = button;
            }
        });
        addHoverEffect(button, new Color(51, 0, 153), Color.BLUE);
        jPanel3.add(button);
    }

    private void addHoverEffect(final JButton button, final Color defaultColor, final Color hoverColor) {
        button.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                button.setBackground(hoverColor);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                if (button != lastSelectedButton) {
                    button.setBackground(defaultColor);
                }
            }
        });
    }

    public void actionPerformed(ActionEvent e) {}

    @SuppressWarnings("unchecked")
    private void initComponents() {
        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
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
    java.awt.EventQueue.invokeLater(new Runnable() {
        public void run() {
            new Questions().setVisible(true);
        }
    });
}


    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
}

