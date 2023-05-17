
package principal;

import java.awt.Color;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.StringReader;
import java_cup.runtime.Symbol;
import javax.swing.JFileChooser;
import javax.swing.JPanel;
import javax.swing.filechooser.FileNameExtensionFilter;

public class Principal extends javax.swing.JFrame {
    private JPanel contentPane;
    public Principal() {
        initComponents();
        this.setLocationRelativeTo(null);
    }
    
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenu4 = new javax.swing.JMenu();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        btnGenerar = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtArchivo = new javax.swing.JTextArea();
        jScrollPane1 = new javax.swing.JScrollPane();
        Sintactico = new javax.swing.JTextArea();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        txtResultado1 = new javax.swing.JTextArea();
        AnalizarSin = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();

        jMenu4.setBackground(new java.awt.Color(0, 0, 0));
        jMenu4.setText("jMenu4");

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane3.setViewportView(jTextArea1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 0));
        setMinimumSize(new java.awt.Dimension(800, 600));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnGenerar.setFont(new java.awt.Font("Century Gothic", 1, 24)); // NOI18N
        btnGenerar.setText("ANALIZAR");
        btnGenerar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGenerarActionPerformed(evt);
            }
        });
        getContentPane().add(btnGenerar, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 110, 350, -1));

        txtArchivo.setColumns(20);
        txtArchivo.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        txtArchivo.setRows(5);
        jScrollPane2.setViewportView(txtArchivo);

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 170, 350, 310));

        Sintactico.setColumns(20);
        Sintactico.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        Sintactico.setRows(5);
        jScrollPane1.setViewportView(Sintactico);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 170, 350, 310));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/principal/G2.jpg"))); // NOI18N
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, -1, -1));
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 30, -1, -1));

        txtResultado1.setColumns(20);
        txtResultado1.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        txtResultado1.setRows(5);
        jScrollPane4.setViewportView(txtResultado1);

        getContentPane().add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 170, 350, 310));

        AnalizarSin.setText("ANALIZAR SIN");
        AnalizarSin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AnalizarSinActionPerformed(evt);
            }
        });
        getContentPane().add(AnalizarSin, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 110, 350, 50));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/principal/111449.jpg"))); // NOI18N
        jLabel1.setText("jLabel1");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1160, 530));

        jMenuBar1.setBackground(new java.awt.Color(204, 204, 204));

        jMenu1.setText("Archivo");

        jMenuItem1.setText("Abrir");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

     public void analizadorLexico() throws IOException{
        int cont = 1;
        
        String expr = (String) txtArchivo.getText();
        Lexer lexer = new Lexer(new StringReader(expr));
        String resultado = "LINEA " + cont + "\t\tSIMBOLO\n";
        while (true) {
            Tokens token = lexer.yylex();
            if (token == null) {
                txtResultado1.setText(resultado);
                return;
            }
            switch (token) {
                case Linea:
                    cont++;
                    resultado += "LINEA " + cont + "\n";
                    break;
                case Comillas:
                    resultado += "  <Comillas>\t\t" + lexer.lexeme + "\n";
                    break;
                case Cadena:
                    resultado += "  <Cadena>\t" + lexer.lexeme + "\n";
                    break;
                case T_dato:
                    resultado += "  <Tipo de dato>\t" + lexer.lexeme + "\n";
                    break;
                case If:
                    resultado += "  <Reservada if>\t" + lexer.lexeme + "\n";
                    break;
                case Else:
                    resultado += "  <Reservada else>\t" + lexer.lexeme + "\n";
                    break;
                case Do:
                    resultado += "  <Reservada do>\t" + lexer.lexeme + "\n";
                    break;
                case While:
                    resultado += "  <Reservada while>\t" + lexer.lexeme + "\n";
                    break;
                case For:
                    resultado += "  <Reservada while>\t" + lexer.lexeme + "\n";
                    break;
                case Igual:
                    resultado += "  <Operador igual>\t" + lexer.lexeme + "\n";
                    break;
                case Suma:
                    resultado += "  <Operador suma>\t" + lexer.lexeme + "\n";
                    break;
                case Resta:
                    resultado += "  <Operador resta>\t" + lexer.lexeme + "\n";
                    break;
                case Multiplicacion:
                    resultado += "  <Operador multiplicacion>\t" + lexer.lexeme + "\n";
                    break;
                case Division:
                    resultado += "  <Operador division>\t" + lexer.lexeme + "\n";
                    break;
                case Op_logico:
                    resultado += "  <Operador logico>\t" + lexer.lexeme + "\n";
                    break;
                case Op_incremento:
                    resultado += "  <Operador incremento>\t" + lexer.lexeme + "\n";
                    break;
                case Op_relacional:
                    resultado += "  <Operador relacional>\t" + lexer.lexeme + "\n";
                    break;
                case Op_atribucion:
                    resultado += "  <Operador atribucion>\t" + lexer.lexeme + "\n";
                    break;
                case Op_booleano:
                    resultado += "  <Operador booleano>\t" + lexer.lexeme + "\n";
                    break;
                case Parentesis_a:
                    resultado += "  <Parentesis de apertura>\t" + lexer.lexeme + "\n";
                    break;
                case Parentesis_c:
                    resultado += "  <Parentesis de cierre>\t" + lexer.lexeme + "\n";
                    break;
                case Llave_a:
                    resultado += "  <Llave de apertura>\t" + lexer.lexeme + "\n";
                    break;
                case Llave_c:
                    resultado += "  <Llave de cierre>\t" + lexer.lexeme + "\n";
                    break;
                case Main:
                    resultado += "  <Reservada main>\t" + lexer.lexeme + "\n";
                    break;
                case P_coma:
                    resultado += "  <Punto y coma>\t" + lexer.lexeme + "\n";
                    break;
                case Identificador:
                    resultado += "  <Identificador>\t\t" + lexer.lexeme + "\n";
                    break;
                case Numero:
                    resultado += "  <Numero>\t\t" + lexer.lexeme + "\n";
                    break;
                case NumeroD:
                    resultado += "  <NumeroD>\t\t" + lexer.lexeme + "\n";
                    break;
                case ERROR:
                    resultado += "  <Simbolo no definido>\n";
                    break;
                case DosPuntos:
                    resultado += "  <Dos Puntos>\t\t" + lexer.lexeme + "\n";
                    break;
                case Break:
                    resultado += "  <Break>\t\t" + lexer.lexeme + "\n";
                    break;
                case Default:
                    resultado += "  <Default>\t\t" + lexer.lexeme + "\n";
                    break;
                case CerrarSwitch:
                    resultado += "  <CerrarSwitch>\t\t" + lexer.lexeme + "\n";
                    break;
                case CuerpoSwitch:
                    resultado += "  <CuerpoSwitch>\t\t" + lexer.lexeme + "\n";
                    break;
                case Switch:
                    resultado += "  <Switch>\t\t" + lexer.lexeme + "\n";
                    break;  
                case Case:
                    resultado+= "<Case>\t\t" + lexer.lexeme + "\n";
                    break;  
                default:
                    resultado += "  < " + lexer.lexeme + " >\n";
                    break;
            }
        }       
     }
    
     
    private void btnGenerarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGenerarActionPerformed
        try {
            analizadorLexico();
            
        } catch (Exception e) {
            
        }
            
    }//GEN-LAST:event_btnGenerarActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        JFileChooser fc=new JFileChooser();

        FileNameExtensionFilter filtro = new FileNameExtensionFilter("*.TXT", "txt");
 
fc.setFileFilter(filtro);

int seleccion=fc.showOpenDialog(contentPane);
 
if(seleccion==JFileChooser.APPROVE_OPTION){
 
    File fichero=fc.getSelectedFile();
 
    txtArchivo.setText(fichero.getAbsolutePath());
 
    try(FileReader fr=new FileReader(fichero)){
        String cadena="";
        int valor=fr.read();
        while(valor!=-1){
            cadena=cadena+(char)valor;
            valor=fr.read();
        }
        txtArchivo.setText(cadena);
    } catch (IOException e1) {
        e1.printStackTrace();
    }
}
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void AnalizarSinActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AnalizarSinActionPerformed
       String ST = txtArchivo.getText();
        Sintax s = new Sintax(new principal.LexerCup(new StringReader(ST)));
        
        try {
            s.parse();
            Sintactico.setText("Analisis Correcto");
            Sintactico.setForeground(new Color(25, 111, 61));
        } catch (Exception ex) {
            Symbol sym = s.getS();
            Sintactico.setText("Error Linea: " + (sym.right + 1) + " Columna: " + (sym.left + 1) + ", Texto: \"" + sym.value + "\"");
            Sintactico.setForeground(Color.red);
    }//GEN-LAST:event_AnalizarSinActionPerformed
    }
    public static void main(String args[]) {
      
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Principal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AnalizarSin;
    private javax.swing.JTextArea Sintactico;
    private javax.swing.JButton btnGenerar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextArea txtArchivo;
    private javax.swing.JTextArea txtResultado1;
    // End of variables declaration//GEN-END:variables
}
