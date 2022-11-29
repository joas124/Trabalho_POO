import javax.swing.*;
import java.awt.*;
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
        setSize(1920, 1080);
        setLayout(new GridLayout(2,1));
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        painelPrincipal = new JPanel();
        add(painelPrincipal);

        valoresLista = new DefaultListModel<>();
        for (Empresa e: st.getEmpresas())
            valoresLista.addElement(e.nome);
        lista = new JList<>(valoresLista);
        DefaultListCellRenderer renderer = (DefaultListCellRenderer) lista.getCellRenderer();
        renderer.setHorizontalAlignment(SwingConstants.CENTER);
        lista.setFixedCellHeight(48);
        lista.setFixedCellWidth(1000);
        listScroller = new JScrollPane(lista);
        listScroller.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

        painelPrincipal.add(listScroller);

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
                            JOptionPane.showMessageDialog(null, st.getEmpresa(lista.getSelectedIndex()));
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