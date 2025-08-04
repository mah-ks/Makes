import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MakeUpMood {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> criarInterface());
    }

    private static void criarInterface() {
        JFrame frame = new JFrame("MakeUp Mood");
        frame.setSize(500, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        JPanel painelPrincipal = new JPanel(new BorderLayout());
        painelPrincipal.setBackground(new Color(255, 228, 240));

        JLabel titulo = new JLabel("Qual maquiagem combina com seu mood hoje?", SwingConstants.CENTER);
        titulo.setFont(new Font("Segoe Script", Font.BOLD, 18));
        titulo.setForeground(new Color(180, 30, 100));
        titulo.setBorder(BorderFactory.createEmptyBorder(20, 10, 10, 10));
        painelPrincipal.add(titulo, BorderLayout.NORTH);

        JPanel botoes = new JPanel(new GridLayout(2, 2, 12, 12));
        botoes.setBackground(new Color(255, 228, 240));
        botoes.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        JButton glow = criarBotao("Glow Natural", new Color(255, 200, 200));
        glow.addActionListener(e -> mostrarDica("Aposte em iluminador, tons amarronzados e brilho suave!", "natural.jfif"));

        JButton dark = criarBotao("Dark", new Color(255, 170, 200));
        dark.addActionListener(e -> mostrarDica("Gloss vinho, sombra escura e lapis de olho marcado!", "dark.jfif"));

        JButton criativa = criarBotao("Criativa", new Color(210, 170, 255));
        criativa.addActionListener(e -> mostrarDica("Use sombra colorida, glitter e delineado grafico!", "criativa.jfif"));

        JButton skincare = criarBotao("Skincare Leve", new Color(180, 220, 255));
        skincare.addActionListener(e -> mostrarDica("Hidratante, lip balm e protetor solar!", "Skincare Leve.jfif"));

        botoes.add(glow);
        botoes.add(dark);
        botoes.add(criativa);
        botoes.add(skincare);

        painelPrincipal.add(botoes, BorderLayout.CENTER);
        frame.add(painelPrincipal);
        frame.setLocationRelativeTo(null); 
        frame.setVisible(true);
    }

    private static JButton criarBotao(String texto, Color corFundo) {
        JButton botao = new JButton(texto);
        botao.setFont(new Font("Segoe UI", Font.BOLD, 14));
        botao.setBackground(corFundo);
        botao.setFocusPainted(false);
        botao.setForeground(new Color(80, 0, 60));
        botao.setBorder(BorderFactory.createLineBorder(new Color(255, 180, 220), 2));
        return botao;
    }

    private static void mostrarDica(String dica, String imagemArquivo) {
        ImageIcon imagem = null;
            imagem = new ImageIcon(imagemArquivo);
            Image img = imagem.getImage().getScaledInstance(120, 120, Image.SCALE_SMOOTH);
            imagem = new ImageIcon(img);
       

        JOptionPane.showMessageDialog(null, dica, "Dica de Beleza", JOptionPane.INFORMATION_MESSAGE, imagem);
    }
}
