package MainFrame;
//Dimensiune ecran : 1350,690

import java.awt.HeadlessException;
import java.awt.Toolkit;
import java.awt.event.WindowEvent;
import java.sql.*;
import javax.swing.JOptionPane;

public class MeniuPrincipal extends javax.swing.JFrame {
    
    private Connection con=null;
    private Statement st;
    private ResultSet rs;
    public int de_test;
        public MeniuPrincipal() {
        initComponents();
        setIcon();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        MainPicture = new javax.swing.JLabel();
        LabelName = new javax.swing.JLabel();
        Username = new javax.swing.JTextField();
        User = new javax.swing.JLabel();
        Pass = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        Password = new javax.swing.JPasswordField();
        Submit = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("LibraryManagement2k17");
        setBackground(new java.awt.Color(255, 255, 255));

        MainPicture.setIcon(new javax.swing.ImageIcon(getClass().getResource("/MainFrame/icon.png"))); // NOI18N

        LabelName.setFont(new java.awt.Font("Vivaldi", 1, 48)); // NOI18N
        LabelName.setForeground(new java.awt.Color(0, 0, 153));
        LabelName.setText("Library  \nManagement  \n2k17");

        User.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        User.setText("Username");

        Pass.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        Pass.setText("Password");

        jLabel1.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jLabel1.setText("Autentificare");

        Password.setMinimumSize(new java.awt.Dimension(14, 24));
        Password.setPreferredSize(new java.awt.Dimension(14, 24));

        Submit.setText("Submit");
        Submit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SubmitActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(LabelName, javax.swing.GroupLayout.PREFERRED_SIZE, 571, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(760, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(58, 58, 58)
                .addComponent(MainPicture, javax.swing.GroupLayout.PREFERRED_SIZE, 528, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(User, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(Pass, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(49, 49, 49)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(Username, javax.swing.GroupLayout.DEFAULT_SIZE, 167, Short.MAX_VALUE)
                    .addComponent(jLabel1)
                    .addComponent(Password, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Submit, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(154, 154, 154))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(69, 69, 69)
                .addComponent(LabelName, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(46, 46, 46)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(MainPicture, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(48, 48, 48)
                        .addComponent(jLabel1)
                        .addGap(48, 48, 48)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Username, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(User))
                        .addGap(28, 28, 28)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(Pass)
                            .addComponent(Password, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(52, 52, 52)
                        .addComponent(Submit)))
                .addContainerGap(77, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void SubmitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SubmitActionPerformed
        try{
            String url = "jdbc:mysql://sql11.freemysqlhosting.net:3306/";
            String dbName = "sql11202944";
            String userName = "sql11202944"; 
            String password = "zivMlcGKq1";
            con = DriverManager.getConnection(url+dbName,userName,password);
            st=con.createStatement();
            
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Eroare Conecsiune DataBase\n"+e , "DataBaseError" ,JOptionPane.ERROR_MESSAGE);
        }
        
        String username = Username.getText();
        String password = Password.getText();
        if(password.equals(userPass(username))){
            Username.setText("");
            Password.setText("");
            JOptionPane.showMessageDialog(null, "Valid user");
            closeMainWindow();
            New frame = new New();
            frame.setVisible(true);
        }else{
            Username.setText("");
            Password.setText("");
            JOptionPane.showMessageDialog(null, "Invalid user" , "Wrong Username or Password" ,JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_SubmitActionPerformed

    
    public String userPass(String username){
        String pass=null;
        try{
            try{
                String query="select Password from Users where Username = '"+username+"'";
                rs=st.executeQuery(query);
            }catch(SQLException e){
                JOptionPane.showMessageDialog(null, "Eroare Conecsiune DataBase\n"+e , "DataBaseError" ,JOptionPane.ERROR_MESSAGE);
            }
            while(rs.next())
                pass=rs.getString("Password");
            return pass;
            
        }catch(HeadlessException|SQLException e){
            JOptionPane.showMessageDialog(null, "Eroare Conecsiune DataBase\n"+e , "DataBaseError" ,JOptionPane.ERROR_MESSAGE);
            return null;
        }
    }
    
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
            java.util.logging.Logger.getLogger(MeniuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MeniuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MeniuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MeniuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MeniuPrincipal().setVisible(true);
            }
        });
    }

    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel LabelName;
    private javax.swing.JLabel MainPicture;
    private javax.swing.JLabel Pass;
    private javax.swing.JPasswordField Password;
    private javax.swing.JButton Submit;
    private javax.swing.JLabel User;
    private javax.swing.JTextField Username;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables

    
    private void setIcon() {
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("icon.png")));
    }
    private void closeMainWindow() {
        WindowEvent winClosing = new WindowEvent(this,WindowEvent.WINDOW_CLOSING);
        Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(winClosing);
    }
}
