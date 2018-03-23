import javax.swing.*;
import java.awt.*;

public class FramePrincipal extends JFrame {
    private PanelTexto panelTexto;
    private PanelUsuario panelUsuario;

    public FramePrincipal() {
        super("TAP Examen 1");

        setLayout(new BorderLayout());

        panelTexto = new PanelTexto();
        panelUsuario = new PanelUsuario();


        panelUsuario.setFormListener(new FormListener() {
            public void formEventOcurred(EventoForm e) {
                String velocidad = e.getVelocidad();
                String distancia = e.getDistancia();
                String tiempo = e.getTiempo();

                float vel = Integer.parseInt(velocidad);
                float dis = Integer.parseInt(distancia);
                float tie = Integer.parseInt(tiempo);
                int check = Float.compare(vel, dis);

                if (vel == 0){
                    vel = dis / tie;

                    panelTexto.appendText("La Velocidad es: " + vel + "\n");
                }

                else if (dis == 0){
                    dis = vel * tie;

                    panelTexto.appendText("La Distancia es: " + dis + "\n");
                }

                else if (tie == 0){
                    tie = dis * vel;

                    panelTexto.appendText("El Tiempo es: " + tie + "\n");
                }

                else if (check == 0 ){
                    panelTexto.appendText("Datos incorrectos: " + "\n");
                }

                //panelTexto.appendText("\n" + "Velocidad: " + vel + ", Distancia: " + dis + ", Tiempo: " + tie + "\n");
            }
        });

        add(panelTexto, BorderLayout.CENTER);
        add(panelUsuario, BorderLayout.WEST);

        setSize(600, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
}
