import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.*;

public class MakeQuizSwing {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new MakeQuizSwing().criarInterface());
    }

    private void criarInterface() {
        JFrame frame = new JFrame(" Qual maquiagem combina com você?");
        frame.setSize(650, 550);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null); 
        frame.setLayout(new BorderLayout());

        JPanel painelPrincipal = new JPanel();
        painelPrincipal.setLayout(new BoxLayout(painelPrincipal, BoxLayout.Y_AXIS));
        painelPrincipal.setBackground(new Color(255, 240, 245)); 

        JLabel titulo = new JLabel(" Descubra sua make perfeita ");
        titulo.setFont(new Font("Georgia", Font.BOLD, 24));
        titulo.setAlignmentX(Component.CENTER_ALIGNMENT);
        titulo.setForeground(new Color(199, 21, 133)); 
        titulo.setBorder(new EmptyBorder(20, 10, 20, 10));
        painelPrincipal.add(titulo);

        JPanel q2Panel = new JPanel();
        q2Panel.setBackground(new Color(255, 240, 245));
        q2Panel.setBorder(BorderFactory.createTitledBorder(
            BorderFactory.createLineBorder(new Color(255, 105, 180), 2, true),
            "  Qual sua vibe hoje? ",
            TitledBorder.CENTER,
            TitledBorder.TOP,
            new Font("SansSerif", Font.BOLD, 16),
            new Color(255, 105, 180)
        ));

        ButtonGroup grupoQ2 = new ButtonGroup();
        JRadioButton q2A = criarBotao("Y2K");
        JRadioButton q2B = criarBotao("Brilhos");
        JRadioButton q2C = criarBotao("Perolas");
        JRadioButton q2D = criarBotao("Rosa");

        grupoQ2.add(q2A); grupoQ2.add(q2B); grupoQ2.add(q2C); grupoQ2.add(q2D);
        q2Panel.add(q2A); q2Panel.add(q2B); q2Panel.add(q2C); q2Panel.add(q2D);
        painelPrincipal.add(q2Panel);

        JLabel resultadoTexto = new JLabel(" ");
        resultadoTexto.setFont(new Font("Comic Sans MS", Font.BOLD, 16));
        resultadoTexto.setForeground(new Color(219, 112, 147));
        resultadoTexto.setAlignmentX(Component.CENTER_ALIGNMENT);
        resultadoTexto.setBorder(new EmptyBorder(10, 0, 10, 0));

        JLabel imagemResultado = new JLabel();
        imagemResultado.setHorizontalAlignment(SwingConstants.CENTER);
        imagemResultado.setBorder(new EmptyBorder(10, 0, 10, 0));

        JButton botao = new JButton("Ver minha make ");
        botao.setFont(new Font("Verdana", Font.BOLD, 14));
        botao.setBackground(new Color(255, 182, 193));
        botao.setForeground(Color.WHITE);
        botao.setFocusPainted(false);
        botao.setAlignmentX(Component.CENTER_ALIGNMENT);
        botao.setCursor(new Cursor(Cursor.HAND_CURSOR));
        botao.setBorder(new LineBorder(new Color(255, 105, 180), 2, true));

        botao.addActionListener(e -> {
            if (!q2A.isSelected() && !q2B.isSelected() && !q2C.isSelected() && !q2D.isSelected()) {
                JOptionPane.showMessageDialog(frame, "Responda todas as perguntas!");
                return;
            }

            String mensagem = "";
            String caminhoImagem = "";

            if (q2A.isSelected()) {
                mensagem = " Seu estilo e moderno Y2K!";
                caminhoImagem = "download (2).jfif";
            } else if (q2B.isSelected()) {
                mensagem = " Seu estilo e artistico com brilhos!";
                caminhoImagem= "download (3).jfif";
            } else if (q2C.isSelected()) {
                mensagem = " Seu estilo e ousado com perolas!";
                caminhoImagem = "perolas.jfif";
            } else if (q2D.isSelected()) {
                mensagem = " Seu estilo e fofo e brilhante!";
                caminhoImagem = "download.jfif";
            }

            resultadoTexto.setText(mensagem);
            try {
                ImageIcon imagem = new ImageIcon(caminhoImagem);
                Image imgRedimensionada = imagem.getImage().getScaledInstance(250, 300, Image.SCALE_SMOOTH);
                imagemResultado.setIcon(new ImageIcon(imgRedimensionada));
            } catch (Exception ex) {
                imagemResultado.setText("Imagem não encontrada.");
                imagemResultado.setIcon(null);
            }
        });

        painelPrincipal.add(botao);
        painelPrincipal.add(resultadoTexto);
        painelPrincipal.add(imagemResultado);

        frame.add(painelPrincipal, BorderLayout.CENTER);
        frame.setVisible(true);
    }

    private JRadioButton criarBotao(String texto) {
        JRadioButton botao = new JRadioButton(texto);
        botao.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        botao.setBackground(new Color(255, 240, 245));
        botao.setForeground(new Color(199, 21, 133));
        botao.setFocusPainted(false);
        return botao;
    }
}
