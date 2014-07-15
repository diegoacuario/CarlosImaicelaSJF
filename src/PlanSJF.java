
import java.awt.Color;
import java.util.ArrayList;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

/**
 *
 * @author Ing. Diego Romero
 */
public class PlanSJF {

    public ArrayList<Proceso> ordenarPorTiempoRafaga(ArrayList<Proceso> proc) {
        for (int i = 0; i < proc.size() - 1; i++) {
            for (int j = i + 1; j < proc.size(); j++) {
                if (proc.get(i).getTiempo() > proc.get(j).getTiempo()) {
                    Proceso aux = proc.get(i);
                    proc.set(i, proc.get(j));
                    proc.set(j, aux);
                }
            }
        }
        return proc;
    }

    public double tiempoPromedio(ArrayList<Proceso> procesos) {
        double tPro = tiempoTotal(procesos);
        tPro /= procesos.size();
        return tPro;
    }

    public int tiempoTotal(ArrayList<Proceso> procesos) {
        int tTo = 0;
        for (Proceso proceso : procesos) {
            tTo += proceso.getTiempo();
        }
        return tTo;
    }

    public boolean encuentraProceso(Proceso p, ArrayList<Proceso> procesos) {
        for (Proceso proceso : procesos) {
            if (proceso.getStrNombre().equals(p.getStrNombre())) {
                System.out.println(proceso.getStrNombre());
                return true;
            }
        }
        return false;
    }

    public void agregarADiagramaGant(JPanel jP, ArrayList<Proceso> procOrd) {
        jP.removeAll();
        jP.setLayout(new java.awt.GridLayout(1, procOrd.size(), 5, 5));
        for (Proceso p : procOrd) {
            JLabel jb = new JLabel("<html>" + p.getStrNombre() + "<br>" + p.getTiempo() + "seg</html>");
            jb.setBorder(new LineBorder(Color.blue));
            jP.add(jb);

        }
    }

    public String[][] convertirAMatriz(ArrayList<Proceso> proc) {
        String procesos[][] = new String[proc.size()][2];
        for (int i = 0; i < proc.size(); i++) {
            procesos[i][0] = proc.get(i).getStrNombre();
            procesos[i][1] = proc.get(i).getTiempo() + "";
        }
        return procesos;
    }
}
