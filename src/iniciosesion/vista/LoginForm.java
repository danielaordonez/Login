
package iniciosesion.vista;

import iniciosesion.controlador.Conectar;
import iniciosesion.vista.MenuPrincipalForm;
import com.sun.glass.events.KeyEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.InputMap;
import javax.swing.JOptionPane;
import javax.swing.KeyStroke;

public class LoginForm extends javax.swing.JFrame {

    int intIntentos = 0;
    //instanciamos la clase conectar para crear una nueva conexion a la db
    Connection conn = new Conectar().getConnection();
    /**
     * Creates new form LoginForm
     */
    public LoginForm() {
        initComponents();
        this.setLocationRelativeTo(null);
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        txtUsuario = new javax.swing.JTextField();
        txtClave = new javax.swing.JPasswordField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        btnIngresar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("DKasaMuebles - Inicio de Sesión");

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));

        txtUsuario.setToolTipText("Ingrese su nombre de usuario");
        txtUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtUsuarioActionPerformed(evt);
            }
        });
        txtUsuario.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtUsuarioKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtUsuarioKeyTyped(evt);
            }
        });

        txtClave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtClaveActionPerformed(evt);
            }
        });
        txtClave.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtClaveKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtClaveKeyTyped(evt);
            }
        });

        jLabel2.setText("Usuario");

        jLabel3.setText("Clave");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3))
                .addGap(32, 32, 32)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtClave, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(36, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(41, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(43, 43, 43)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtClave, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(39, 39, 39))
        );

        btnIngresar.setText("Ingresar");
        btnIngresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIngresarActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel1.setText("Inicio de Sesión");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(74, 74, 74)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnIngresar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(174, 174, 174)
                        .addComponent(jLabel1)))
                .addContainerGap(78, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnIngresar)
                .addContainerGap(28, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnIngresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIngresarActionPerformed
    String sql = "select * from usuarios where nombreusuario=? and claveusuario=?";
      
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            
            ps.setString(1, txtUsuario.getText());
            ps.setString(2,txtClave.getText());
            ResultSet rs = ps.executeQuery();
            
             if(rs.next()){
                 this.dispose();
                 MenuPrincipalForm MP = new MenuPrincipalForm();
                 MP.setVisible(true);
                 
                 //el siguiente codigo nos sirve para guardar el nombredeusuario desde el rs del login
                 LoginForm.usuario = rs.getString("nombreusuario");
               
             }
             else if(intIntentos==3){
                 JOptionPane.showMessageDialog(null,"Error de autenticación. Aboquese al administrador");
                 System.exit(0);
                 // aqui se debe cambiar el estado a bloqueado.
             }
            else if(txtUsuario.getText().equals("") || txtClave.getText().equals("") ){
                JOptionPane.showMessageDialog(null,"Error, no dejar campos vacios " );
                txtUsuario.requestFocus();
            }
            else if(txtClave.getText().length()<=intLimiteCaracteresMin) {
            JOptionPane.showMessageDialog(null,"La clave no puede ser menos de 8 caracteres");
            txtClave.requestFocus();
            txtClave.setText("");
            }
             else{
                 JOptionPane.showMessageDialog(null, "Error Usuario o Clave Incorrectos ");
                 txtUsuario.requestFocus();
                 txtUsuario.setText("");
                 txtClave.setText("");
                 intIntentos+=1;
                 
                 
                 
             }
        } catch (Exception e) {
               System.out.println("Error de Login");  
               System.out.println(e.getMessage());
        }
        
        
    }//GEN-LAST:event_btnIngresarActionPerformed

    private void txtUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtUsuarioActionPerformed
            
    }//GEN-LAST:event_txtUsuarioActionPerformed
    private void txtUsuarioKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtUsuarioKeyTyped
    
   char validar=evt.getKeyChar();
     
       if(!Character.isLetter(validar)){
           evt.consume();
           
           //JOptionPane.showMessageDialog(rootPane, "Error, ingresar solo letras");
       }
       
       if(txtUsuario.getText().length()>=intLimiteCaracteresMax){
           evt.consume();
          // JOptionPane.showMessageDialog(rootPane,"Error, limite de 15 caracteres");
       }
     
       
       
      if(Character.isUpperCase(validar)){
           String cadena=(""+validar).toLowerCase();
           validar=cadena.charAt(0);
           evt.setKeyChar(validar);
       }
     
    }//GEN-LAST:event_txtUsuarioKeyTyped

    private void txtClaveKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtClaveKeyTyped
        
        //Validacion para que pueda dar en ingresar con el boton enter
        char charTeclaPresionada =evt.getKeyChar();
        if(charTeclaPresionada==KeyEvent.VK_ENTER){
            btnIngresar.doClick();
        }
    }//GEN-LAST:event_txtClaveKeyTyped

    // validacion para que no permita pegar texto en los textfield
    private void txtUsuarioKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtUsuarioKeyPressed
        int codigoBoton = evt.getKeyCode();
        if (evt.isControlDown() && codigoBoton == KeyEvent.VK_V) {
                    JOptionPane.showMessageDialog(null,"Ingrese manualmente sus credenciales");
                    evt.consume();
                    txtUsuario.setText("");   
                }
       
    }//GEN-LAST:event_txtUsuarioKeyPressed
    
    // validacion para que no permita pegar texto en los textfield
    private void txtClaveKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtClaveKeyPressed
        int codigoBoton = evt.getKeyCode();
        if (evt.isControlDown() && codigoBoton == KeyEvent.VK_V) {
                    JOptionPane.showMessageDialog(null,"Ingrese manualmente sus credenciales");
                    evt.consume();
                    txtUsuario.setText("");   
                }
        
        //validacion para que tenga limite en el ingreso de caracteres
        if(txtClave.getText().length()>=intLimiteCaracteresMax){
           evt.consume();
        } 
    }//GEN-LAST:event_txtClaveKeyPressed

    private void txtClaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtClaveActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtClaveActionPerformed

    
    //creamos una variable global para guardar desde el metodo
    public static String usuario;
    int intLimiteCaracteresMax =16;
    int intLimiteCaracteresMin =7;
    
    public static void main(String args[]) {
        
      
          
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LoginForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnIngresar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPasswordField txtClave;
    private javax.swing.JTextField txtUsuario;
    // End of variables declaration//GEN-END:variables

    private void validarPegadoDeTexto() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
