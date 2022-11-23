import javax.swing.*;
import java.awt.*;

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
        add(painelPrincipal);

        valoresLista = new DefaultListModel<>();
        /*for (Empresa e: st.getEmpresas())
            valoresLista.addElement(e.nome);*/
        for (int i = 0; i<100; ++i) valoresLista.addElement(String.valueOf(i));
        lista = new JList<>(valoresLista);
        listScroller = new JScrollPane(lista);
        painelPrincipal.add(lista);

        show();
    }
}
