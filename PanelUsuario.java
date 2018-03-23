import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PanelUsuario extends JPanel {
    private JLabel instLabel;
    private JLabel velocidaLabel;
    private JLabel distanciaLabel;
    private JLabel tiempoLabel;
    private JTextField velocidadField;
    private JTextField distanciaField;
    private JTextField tiempoField;
    private JButton okBtn;
    private FormListener formListener;

    public PanelUsuario() {
        Dimension dim = getPreferredSize();
        dim.width = 350;
        setPreferredSize(dim);

        Border innerBorder = BorderFactory.createTitledBorder("Ingresar datos");
        Border outerBorder = BorderFactory.createEmptyBorder(5,5,5,5);
        setBorder(BorderFactory.createCompoundBorder(outerBorder, innerBorder));

        instLabel = new JLabel("Escriba un '0' en el campo a calcular");
        velocidaLabel = new JLabel("Velocidad: ");
        distanciaLabel = new JLabel("Distancia: ");
        tiempoLabel = new JLabel("Tiempo: ");
        velocidadField = new JTextField(10);
        distanciaField = new JTextField(10);
        tiempoField = new JTextField(10);

        okBtn = new JButton("OK");
        okBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String velocidad = velocidadField.getText();
                String distancia = distanciaField.getText();
                String tiempo = tiempoField.getText();

                EventoForm ev = new EventoForm(this, velocidad, distancia, tiempo);
                if (formListener != null) {
                    formListener.formEventOcurred(ev);
                }
            }
        });

        setLayout(new GridBagLayout());

        GridBagConstraints gc = new GridBagConstraints();

        // Linea 1
        gc.gridx = 0;
        gc.gridy = 0;
        gc.weightx = 1;
        gc.weighty = 0.1;
        gc.fill = GridBagConstraints.NONE;

        gc.insets = new Insets(0,0,0,10);
        gc.anchor = GridBagConstraints.LINE_END;
        add(velocidaLabel, gc);

        gc.gridx = 1;
        gc.insets = new Insets(0,0,0,0);
        gc.anchor = GridBagConstraints.LINE_START;
        add(velocidadField, gc);

        // Linea 2
        gc.weightx = 1;
        gc.weighty = 0.1;
        gc.gridx = 0;
        gc.gridy = 1;
        gc.insets = new Insets(0,0,0,10);
        gc.anchor = GridBagConstraints.LINE_END;
        add(distanciaLabel, gc);

        gc.gridx = 1;
        gc.insets = new Insets(0,0,0,0);
        gc.anchor = GridBagConstraints.LINE_START;
        add(distanciaField, gc);

        // Linea 3
        gc.weightx = 1;
        gc.weighty = 0.1;
        gc.gridx = 0;
        gc.gridy = 2;
        gc.insets = new Insets(0,0,0,10);
        gc.anchor = GridBagConstraints.LINE_END;
        add(tiempoLabel, gc);

        gc.gridx = 1;
        gc.insets = new Insets(0,0,0,0);
        gc.anchor = GridBagConstraints.LINE_START;
        add(tiempoField, gc);

        // Linea 4
        gc.weightx = 1;
        gc.weighty = 2;
        gc.gridy = 3;
        gc.insets = new Insets(0,0,0,0);
        gc.anchor = GridBagConstraints.FIRST_LINE_START;
        add(okBtn, gc);

        gc.gridy = 4;
        gc.gridx = 0;
        gc.insets = new Insets(0,0,0,0);
        gc.anchor = GridBagConstraints.LINE_START;
        add(instLabel, gc);
    }

    public void setFormListener(FormListener listener) {
        this.formListener = listener;
    }
}
