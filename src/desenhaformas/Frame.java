package desenhaformas;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

public class Frame extends JFrame{
    JPanel painelDesenho = new JPanel();  
    Color corAtual = Color.YELLOW;
    String formaAtual = "Círculo";
    
    ActionListener listenerSelecionaCor = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            JButton bt = (JButton) e.getSource();
            
            corAtual = bt.getBackground();
        }
    };
    
    ActionListener listenerSelecionaForma = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            JButton bt = (JButton) e.getSource();
            
            formaAtual = bt.getText();
        }
    };
    
    MouseAdapter ma = new MouseAdapter() {
        @Override
        public void mouseClicked(MouseEvent e) {
            System.out.println(e.getX() + " " + e.getY());
            Graphics2D g = (Graphics2D) painelDesenho.getGraphics();
            
            g.setColor(corAtual);
            
            if(formaAtual.equals("Quadrado")){
                g.fillRect(e.getX()-20, e.getY()-20, 40, 40);
            }
            else if(formaAtual.equals("Retângulo")){
                g.fillRect(e.getX()-35, e.getY()-20, 70, 40);
            }
            else if(formaAtual.equals("Círculo")){
                g.fillOval(e.getX()-20, e.getY()-20, 40, 40);
            }
            else if(formaAtual.equals("Triângulo")){
                g.fillPolygon(new int[] {e.getX(), e.getX()-30, e.getX()+30}, new int[] {e.getY()-30, e.getY()+30, e.getY()+30}, 3);
            } 
        }
    };
    
    public void configurar(){
        setSize(800, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setTitle("Desenha Formas 3.0");
        setResizable(false);
    }
    
    public void adicionarElementos(){
        
        // PAINEL DE CORES
        JPanel painelCores = new JPanel(new FlowLayout(FlowLayout.LEFT));
        painelCores.setLayout(new BoxLayout(painelCores, BoxLayout.Y_AXIS));
        
        JButton btVermelho = new JButton("...");
        btVermelho.setBackground(Color.RED);
        JButton btAzul = new JButton("...");
        btAzul.setBackground(Color.BLUE);
        JButton btVerde = new JButton("...");
        btVerde.setBackground(Color.GREEN);
        JButton btAmarelo = new JButton("...");
        btAmarelo.setBackground(Color.YELLOW);
        
        painelCores.add(btVermelho);
        painelCores.add(btAzul);
        painelCores.add(btVerde);
        painelCores.add(btAmarelo);
        
        btVermelho.addActionListener(listenerSelecionaCor);
        btAzul.addActionListener(listenerSelecionaCor);
        btVerde.addActionListener(listenerSelecionaCor);
        btAmarelo.addActionListener(listenerSelecionaCor);
        
        // PAINEL DE FORMAS
        JPanel painelFormas = new JPanel(new FlowLayout(FlowLayout.LEFT));
        
        JButton btQuadrado = new JButton("Quadrado");
        JButton btRetangulo = new JButton("Retângulo");
        JButton btCirculo = new JButton("Círculo");
        JButton btTriangulo = new JButton("Triângulo");
        
        painelFormas.add(btQuadrado);
        painelFormas.add(btRetangulo);
        painelFormas.add(btCirculo);
        painelFormas.add(btTriangulo);
        
        btQuadrado.addActionListener(listenerSelecionaForma);
        btRetangulo.addActionListener(listenerSelecionaForma);
        btCirculo.addActionListener(listenerSelecionaForma);
        btTriangulo.addActionListener(listenerSelecionaForma);
        
        // PAINEL DE DESENHO
        painelDesenho.setBackground(Color.WHITE);
        painelDesenho.addMouseListener(ma);
        
        getContentPane().add(painelCores, BorderLayout.WEST);
        getContentPane().add(painelFormas, BorderLayout.SOUTH);
        getContentPane().add(painelDesenho, BorderLayout.CENTER);
    }
}
