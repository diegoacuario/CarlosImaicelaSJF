
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Ing. Diego Romero
 */
public class Principal extends JFrame {

    private JButton jbAgregar, jbEjcutar, jbEjecutarOtro;
    private JComboBox jcTiemRag;
    private JLabel ljTiemRaf, jlNomPro, jlOrden, jlTiemPro, jlTieTot, jlMenCons;
    private JPanel jPanel2;
    private JScrollPane jScrollPane1, jScrollPane2, jScrollPane3;
    private JTable jtbDatos;
    private JTextArea jTextArea1;
    private JTextField jtNomPro, jtPro, jtTot;
    private ArrayList<Proceso> procesos = new ArrayList<>(), procesosOrdenados = new ArrayList<>();

    private final PlanSJF pSJF = new PlanSJF();

    @SuppressWarnings("empty-statement")
    public Principal() {
        initComponents();
        setSize(800, 600);
        jtbDatos.setModel(new DefaultTableModel(null, new String[]{"Nombre", "Tiempo"}));
    }

    private void initComponents() {

        ljTiemRaf = new JLabel();
        jcTiemRag = new JComboBox();
        jlNomPro = new JLabel();
        jtNomPro = new JTextField();
        jbAgregar = new JButton();
        jScrollPane1 = new JScrollPane();
        jtbDatos = new JTable();
        jbEjcutar = new JButton();
        jlOrden = new JLabel();
        jScrollPane3 = new JScrollPane();
        jPanel2 = new JPanel();
        jlTieTot = new JLabel();
        jtPro = new JTextField();
        jlTiemPro = new JLabel();
        jtTot = new JTextField();
        jbEjecutarOtro = new JButton();
        jScrollPane2 = new JScrollPane();
        jTextArea1 = new JTextArea();
        jlMenCons = new JLabel();

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setTitle("Simulación del algoritmo de planificación SJF");
        setPreferredSize(new Dimension(800, 600));
        setResizable(false);
        getContentPane().setLayout(null);

        ljTiemRaf.setFont(new Font("Calibri", 1, 14));
        ljTiemRaf.setText("Ráfaga de CPU");
        getContentPane().add(ljTiemRaf);
        ljTiemRaf.setBounds(41, 11, 84, 17);

        jcTiemRag.setFont(new Font("Calibri", 0, 14));
        jcTiemRag.setModel(new DefaultComboBoxModel(new String[]{"0 Segundos", "1 Segundos", "2 Segundos", "3 Segundos", "4 Segundos", "5 Segundos", "6 Segundos", "7 Segundos", "8 Segundos", "9 Segundos", "10 Segundos"}));
        jcTiemRag.setToolTipText("Seleccione el tiempo de ráfaga de CPU en segundos");
        getContentPane().add(jcTiemRag);
        jcTiemRag.setBounds(41, 34, 95, 23);

        jlNomPro.setFont(new Font("Calibri", 1, 14));
        jlNomPro.setText("Nombre del proceso a agregar");
        getContentPane().add(jlNomPro);
        jlNomPro.setBounds(171, 11, 178, 17);

        jtNomPro.setFont(new Font("Calibri", 0, 14));
        jtNomPro.setText("Proceso1");
        jtNomPro.setToolTipText("Escriba el nombre del proceso");
        getContentPane().add(jtNomPro);
        jtNomPro.setBounds(171, 34, 148, 23);

        jbAgregar.setFont(new Font("Calibri", 1, 14));
        jbAgregar.setText("Agregar proceso");
        jbAgregar.setToolTipText("Agregar proceso a la tabla");
        jbAgregar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                accionBotonAgregar(evt);
            }
        });
        getContentPane().add(jbAgregar);
        jbAgregar.setBounds(389, 11, 200, 25);
        jtbDatos.setFont(new Font("Calibri", 0, 14));
        jScrollPane1.setViewportView(jtbDatos);
        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(41, 110, 412, 170);
        jbEjcutar.setFont(new Font("Calibri", 1, 14));
        jbEjcutar.setText("Ejecutar SJF");
        jbEjcutar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                accionBotonEjecutar(evt);
            }
        });
        getContentPane().add(jbEjcutar);
        jbEjcutar.setBounds(390, 40, 200, 25);
        jlOrden.setFont(new Font("Calibri", 1, 14));
        jlOrden.setText("Orden en como se ejecutaran los procesos en la CPU");
        getContentPane().add(jlOrden);
        jlOrden.setBounds(41, 75, 308, 17);
        jPanel2.setBorder(BorderFactory.createTitledBorder("Diagrama de gantt e el orden como se ejecutaran los procesos"));
        GroupLayout jPanel2Layout = new GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGap(0, 696, Short.MAX_VALUE));
        jPanel2Layout.setVerticalGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGap(0, 105, Short.MAX_VALUE));
        jScrollPane3.setViewportView(jPanel2);
        getContentPane().add(jScrollPane3);
        jScrollPane3.setBounds(40, 420, 710, 130);
        jlTieTot.setFont(new Font("Calibri", 1, 14));
        jlTieTot.setText("Tiempo total de ejecución");
        getContentPane().add(jlTieTot);
        jlTieTot.setBounds(529, 193, 153, 17);
        jtPro.setEditable(false);
        jtPro.setFont(new Font("Calibri", 0, 14));
        getContentPane().add(jtPro);
        jtPro.setBounds(625, 164, 57, 23);
        jlTiemPro.setFont(new Font("Calibri", 1, 14));
        jlTiemPro.setText("Promedio de tiempo de procesos ");
        getContentPane().add(jlTiemPro);
        jlTiemPro.setBounds(484, 141, 198, 17);
        jtTot.setEditable(false);
        jtTot.setFont(new Font("Calibri", 0, 14));
        getContentPane().add(jtTot);
        jtTot.setBounds(627, 216, 55, 23);
        jbEjecutarOtro.setFont(new Font("Calibri", 1, 14));
        jbEjecutarOtro.setText("Ejecutar con otro datos");
        jbEjecutarOtro.setToolTipText("Ejecuta nuevamente el programa");
        jbEjecutarOtro.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                accionEjecutaOtro(evt);
            }
        });
        getContentPane().add(jbEjecutarOtro);
        jbEjecutarOtro.setBounds(482, 110, 200, 25);
        jTextArea1.setColumns(20);
        jTextArea1.setFont(new Font("Calibri", 0, 14));
        jTextArea1.setRows(5);
        jScrollPane2.setViewportView(jTextArea1);
        getContentPane().add(jScrollPane2);
        jScrollPane2.setBounds(40, 310, 710, 100);
        jlMenCons.setFont(new Font("Calibri", 1, 14));
        jlMenCons.setText("Mensajes de consola");
        getContentPane().add(jlMenCons);
        jlMenCons.setBounds(40, 290, 178, 20);
        setSize(new Dimension(816, 639));
        setLocationRelativeTo(null);
    }

    private void accionBotonAgregar(ActionEvent evt) {
        String nombre = jtNomPro.getText();
        int tiempo = jcTiemRag.getSelectedIndex();
        Proceso p = new Proceso(nombre, tiempo);
        if (!pSJF.encuentraProceso(p, procesos)) {
            procesos.add(p);
            procesosOrdenados = pSJF.ordenarPorTiempoRafaga(procesos);
            pSJF.agregarADiagramaGant(jPanel2, procesosOrdenados);
            if (procesos.size() % 2 == 0) {
                setSize(800, 600);
            } else {
                setSize(800, 601);
            }
            jtbDatos.setModel(new DefaultTableModel(pSJF.convertirAMatriz(procesosOrdenados), new String[]{"Nombre", "Tiempo"}));
            jtNomPro.setText("Proceso" + (procesosOrdenados.size() + 1));
            jtPro.setText(pSJF.tiempoPromedio(procesosOrdenados) + " seg.");
            jtTot.setText(pSJF.tiempoTotal(procesosOrdenados) + " seg.");
        } else {
            JOptionPane.showMessageDialog(this, "Proceso " + p.getStrNombre()
                    + " ya fue agregado");
        }
    }

    private void accionBotonEjecutar(ActionEvent evt) {
        jTextArea1.setText("");
        int tmpEspera = 0;
        if (procesosOrdenados.size() <= 0) {
            JOptionPane.showMessageDialog(rootPane, "No hay procesos en la cola");
        } else {
            for (Proceso pOr : procesosOrdenados) {
                jTextArea1.setText(jTextArea1.getText() + "Ingresa " + pOr.getStrNombre() + " procesando... ");
                System.out.print("Ingresa " + pOr.getStrNombre() + " procesando... ");
                try {
                    Thread.sleep(1000 * pOr.getTiempo());
                } catch (InterruptedException ex) {
                    System.out.println(ex);
                }
                tmpEspera += pOr.getTiempo();
                jTextArea1.setText(jTextArea1.getText() + "Proceso terminado en " + tmpEspera + " segundos\n");
                System.out.print("Proceso terminado en " + tmpEspera + " segundos\n");
            }
            jlMenCons.setText("Mensajes");
            JOptionPane.showMessageDialog(rootPane, "Termino la ejecucución del algoritmo");
        }
    }

    private void accionEjecutaOtro(ActionEvent evt) {
        dispose();
        new Principal().setVisible(true);
    }

    public static void main(String args[]) {
        new Principal().setVisible(true);
    }

}
