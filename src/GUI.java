import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.TimerTask;

public class GUI extends JFrame {
    private JPanel painelPrincipal;
    private JScrollPane listScroller;
    private DefaultListModel<String> valoresLista;
    private JList<String> lista;

    public GUI(StarThrive st){
        setTitle("StarThrive");
        setSize(1200, 700);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        painelPrincipal = new JPanel();
        painelPrincipal.setSize(800, 800);
        add(painelPrincipal);

        valoresLista = new DefaultListModel<>();
        for (Empresa e: st.getEmpresas())
            valoresLista.addElement(e.nome);
        //for (int i = 0; i<100; ++i) valoresLista.addElement(String.valueOf(i));
        lista = new JList<>(valoresLista);
        listScroller = new JScrollPane(lista);
        listScroller.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        painelPrincipal.add(listScroller);



        //JButton jButton = new JButton("Click Me!");
        //jButton.addMouseListener(new MouseAdapter() {
        lista.addMouseListener(new MouseAdapter() {
        private int eventCounter = 0;
        java.util.Timer timer = new java.util.Timer("doubleClickTimer", false);

        @Override
        public void mouseClicked(final MouseEvent e) {
            eventCounter = e.getClickCount();
            if ( e.getClickCount() == 1 ) {
                timer.schedule(new TimerTask() {
                    @Override
                    public void run() {
                        if ( eventCounter > 1 ) {
                            JOptionPane.showMessageDialog(null, st.getEmpresa());
                        }
                        eventCounter = 0;
                    }
                }, 400);
            }
        }
        });
        show();
    }
}
