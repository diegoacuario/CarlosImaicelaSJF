/**
 *
 * @author Ing. Diego Romero
 */
public final class Proceso {

    private String strNombre;
    private int tiempo;

    public Proceso(String nombre, int tiempo) {
        setStrNombre(nombre);
        setTiempo(tiempo);
    }

    public String getStrNombre() {
        return strNombre;
    }

    public void setStrNombre(String strNombre) {
        this.strNombre = strNombre;
    }

    public int getTiempo() {
        return tiempo;
    }

    public void setTiempo(int tiempo) {
        this.tiempo = tiempo;
    }

}
