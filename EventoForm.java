import java.util.EventObject;

public class EventoForm extends EventObject {

    private String velocidad;
    private String distancia;
    private String tiempo;
    /**
     * Constructs a prototypical Event.
     *
     * @param source The object on which the Event initially occurred.
     * @throws IllegalArgumentException if source is null.
     */
    public EventoForm(Object source) {
        super(source);
    }

    public EventoForm(Object source, String velocidad, String distancia, String tiempo) {
        super(source);

        this.distancia = distancia;
        this.velocidad = velocidad;
        this.tiempo = tiempo;
    }

    public String getVelocidad() {
        return velocidad;
    }

    public void setVelocidad(String velocidad) {
        this.velocidad = velocidad;
    }

    public String getDistancia() {
        return distancia;
    }

    public void setDistancia(String distancia) {
        this.distancia = distancia;
    }

    public String getTiempo() {
        return tiempo;
    }

    public void setTiempo(String tiempo) {
        this.tiempo = tiempo;
    }
}
