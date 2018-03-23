import javax.swing.*;
import java.awt.*;

public class PanelTexto extends JPanel {

    private JTextArea textArea;

    public PanelTexto() {
        textArea = new JTextArea();

        setLayout(new BorderLayout());

        add(new JScrollPane(textArea), BorderLayout.CENTER);
    }

    public void appendText(String text) {
        textArea.append(text);
    }
}
