/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package code;


import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author OMy
 */
public class feedframe extends javax.swing.JFrame {

    /**
     * Creates new form twitterfeed
     */

    public feedframe() {
        initComponents();
        this.setMinimumSize(new Dimension(800, 600));

      
        Tweet.addFocusListener(new java.awt.event.FocusAdapter() {
            @Override
            public void focusGained(java.awt.event.FocusEvent evt) {
                if (Tweet.getText().equals("Que esta pasando?")) {
                }
            }

            @Override
            public void focusLost(java.awt.event.FocusEvent evt) {
                if (Tweet.getText().isEmpty()) {
                   
                    
                }
            }
        });

         user usuario = user.getLoggedUser();

      

   if (usuario != null) {
    tweet[] tweetsOrdenados = tweet.obtenerTweets(usuario);
    results.removeAll();
    for (tweet orden : tweetsOrdenados) {
        user autor = usuario.searchuser(orden.getAuthor()); 
        if (autor != null) {
            usersearch2 newTweetPanel = new usersearch2(autor);
            newTweetPanel.setTweetText(orden.getText());
            String formattedDate = date.getCurrentDate(); 
            newTweetPanel.setFecha(formattedDate); 
            results.add(newTweetPanel, -1);  
        }
    }
    results.revalidate();
    results.repaint();
}
        Tweet.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                String tweetText = Tweet.getText();
       if (tweetText.length() >= 140) {
            Tweet.setText(tweetText.substring(0, 140));
            JOptionPane.showMessageDialog(null, "Has alcanzado el limite de 140 caracteres", "Limite de caracteres", JOptionPane.WARNING_MESSAGE);
            Twittear.setEnabled(false);
        } else {
            Twittear.setEnabled(true);
                }
            }
        });
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jSlider1 = new javax.swing.JSlider();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        Tweet = new javax.swing.JTextField();
        Twittear = new javax.swing.JButton();
        cososcroll = new javax.swing.JScrollPane();
        results = new javax.swing.JPanel();
        text = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        Cuentas = new javax.swing.JButton();
        Menciones = new javax.swing.JButton();
        logout = new javax.swing.JButton();
        hashtags = new javax.swing.JButton();

        jLabel2.setText("jLabel2");

        jLabel3.setText("jLabel3");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(25, 25, 25));

        jPanel3.setBackground(new java.awt.Color(0, 0, 0));

        Tweet.setBackground(new java.awt.Color(0, 0, 0));
        Tweet.setDisabledTextColor(new java.awt.Color(255, 255, 255));
        Tweet.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TweetActionPerformed(evt);
            }
        });

        Twittear.setBackground(new java.awt.Color(29, 161, 242));
        Twittear.setText("Twetear");
        Twittear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TwittearActionPerformed(evt);
            }
        });

        cososcroll.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        cososcroll.setHorizontalScrollBar(null);

        results.setBackground(new java.awt.Color(0, 0, 0));
        results.setLayout(new javax.swing.BoxLayout(results, javax.swing.BoxLayout.PAGE_AXIS));
        cososcroll.setViewportView(results);

        text.setForeground(new java.awt.Color(255, 51, 51));

        jLabel4.setFont(new java.awt.Font("Eras Bold ITC", 0, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Cuentanos que esta pasando");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(text, javax.swing.GroupLayout.PREFERRED_SIZE, 409, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(Twittear)
                .addContainerGap())
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(Tweet)
                        .addComponent(cososcroll, javax.swing.GroupLayout.DEFAULT_SIZE, 540, Short.MAX_VALUE))))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Tweet, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Twittear)
                    .addComponent(text))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cososcroll))
        );

        jPanel5.setBackground(new java.awt.Color(0, 0, 0));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/pajarito.png"))); // NOI18N

        jButton2.setBackground(new java.awt.Color(0, 0, 0));
        jButton2.setFont(new java.awt.Font("Eras Bold ITC", 0, 24)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/home.png"))); // NOI18N
        jButton2.setText("  Time Line");
        jButton2.setBorder(null);
        jButton2.setContentAreaFilled(false);
        jButton2.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton4.setBackground(new java.awt.Color(0, 0, 0));
        jButton4.setFont(new java.awt.Font("Eras Bold ITC", 0, 24)); // NOI18N
        jButton4.setForeground(new java.awt.Color(255, 255, 255));
        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/lup.png"))); // NOI18N
        jButton4.setText("  Buscar Gente");
        jButton4.setBorder(null);
        jButton4.setContentAreaFilled(false);
        jButton4.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton3.setBackground(new java.awt.Color(0, 0, 0));
        jButton3.setFont(new java.awt.Font("Eras Bold ITC", 0, 24)); // NOI18N
        jButton3.setForeground(new java.awt.Color(255, 255, 255));
        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/settings.png"))); // NOI18N
        jButton3.setText("  Configuracion");
        jButton3.setBorder(null);
        jButton3.setContentAreaFilled(false);
        jButton3.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        Cuentas.setBackground(new java.awt.Color(0, 0, 0));
        Cuentas.setFont(new java.awt.Font("Eras Bold ITC", 0, 24)); // NOI18N
        Cuentas.setForeground(new java.awt.Color(255, 255, 255));
        Cuentas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/user.png"))); // NOI18N
        Cuentas.setText("Mi Cuenta");
        Cuentas.setBorder(null);
        Cuentas.setContentAreaFilled(false);
        Cuentas.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        Cuentas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CuentasActionPerformed(evt);
            }
        });

        Menciones.setBackground(new java.awt.Color(0, 0, 0));
        Menciones.setFont(new java.awt.Font("Eras Bold ITC", 0, 24)); // NOI18N
        Menciones.setForeground(new java.awt.Color(255, 255, 255));
        Menciones.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/mail.png"))); // NOI18N
        Menciones.setText("  Menciones");
        Menciones.setBorder(null);
        Menciones.setContentAreaFilled(false);
        Menciones.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        Menciones.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MencionesActionPerformed(evt);
            }
        });

        logout.setBackground(new java.awt.Color(0, 0, 0));
        logout.setFont(new java.awt.Font("Eras Bold ITC", 0, 24)); // NOI18N
        logout.setForeground(new java.awt.Color(255, 255, 255));
        logout.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/logout.png"))); // NOI18N
        logout.setText(" Cerrar Sesion");
        logout.setBorder(null);
        logout.setContentAreaFilled(false);
        logout.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        logout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logoutActionPerformed(evt);
            }
        });

        hashtags.setBackground(new java.awt.Color(0, 0, 0));
        hashtags.setFont(new java.awt.Font("Eras Bold ITC", 0, 24)); // NOI18N
        hashtags.setForeground(new java.awt.Color(255, 255, 255));
        hashtags.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/hashtag.png"))); // NOI18N
        hashtags.setText("Hashtags");
        hashtags.setBorder(null);
        hashtags.setContentAreaFilled(false);
        hashtags.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        hashtags.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                hashtagsActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jButton2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addGap(0, 0, Short.MAX_VALUE))
            .addComponent(jButton4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(Cuentas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(Menciones, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(logout, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(hashtags, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(Cuentas)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(Menciones)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 10, Short.MAX_VALUE)
                .addComponent(hashtags)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(logout)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        settingframe frame = new settingframe();
        frame.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        searchusersframe frame = new searchusersframe();
        frame.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void CuentasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CuentasActionPerformed
        // TODO add your handling code here:
        //cambiar
        user u=new user();
        user acc=u.loggedacc(u.getLoggedinuser());
        u.selectacc(acc);
        accountframe frame = new accountframe(acc);
        frame.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_CuentasActionPerformed

    private void TweetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TweetActionPerformed
        TwittearActionPerformed(evt);
    }//GEN-LAST:event_TweetActionPerformed

    private void TwittearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TwittearActionPerformed
        String tweetText = Tweet.getText().trim();
        if (tweetText.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Debes ingresar texto antes de twittear");
        } else if (tweetText.length() > 140) { 
        
        JOptionPane.showMessageDialog(this, "El tweet no puede tener mas de 140 caracteres", "Limite de caracteres", JOptionPane.WARNING_MESSAGE);
        Twittear.setEnabled(false);

        } else {
            user usuario = user.getLoggedUser();
            if (usuario != null) {
                usuario.addTweet(tweetText);
                String currentDate = date.getCurrentDate();
                tweet[] userTweets = usuario.getUserTweets();
                tweet latestTweet = userTweets[usuario.getTweetCount() - 1];
                usersearch2 newTweetPanel = new usersearch2(usuario);
                newTweetPanel.setTweetText(latestTweet.getText());
                newTweetPanel.setFecha(currentDate);
                results.add(newTweetPanel, 0);
                results.revalidate();
                results.repaint();
                Tweet.setText("");
                Tweet.setForeground(Color.GRAY);

            }
        }
    }//GEN-LAST:event_TwittearActionPerformed

    private void MencionesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MencionesActionPerformed
        interactionsframe frame = new interactionsframe();
        frame.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_MencionesActionPerformed

    private void logoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logoutActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_logoutActionPerformed

    private void hashtagsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_hashtagsActionPerformed
        // TODO add your handling code here:
        searchhashframe frame = new searchhashframe();
        frame.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_hashtagsActionPerformed

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
            java.util.logging.Logger.getLogger(feedframe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(feedframe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(feedframe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(feedframe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new feedframe().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Cuentas;
    private javax.swing.JButton Menciones;
    private javax.swing.JTextField Tweet;
    private javax.swing.JButton Twittear;
    private javax.swing.JScrollPane cososcroll;
    private javax.swing.JButton hashtags;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JSlider jSlider1;
    private javax.swing.JButton logout;
    private javax.swing.JPanel results;
    private javax.swing.JLabel text;
    // End of variables declaration//GEN-END:variables
}
