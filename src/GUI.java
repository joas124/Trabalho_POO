import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.TimerTask;

public class GUI extends JFrame {
    private StarThrive st;
    private JPanel painelEmpresas, painelBotoes;
    private JPanel[][] panelHolder;
    private JFrame frameAdicionar;
    private JScrollPane listScroller;
    private JComboBox<String> comboBoxTipo;
    private JButton adicionar, remover, editar, pontoDois, pontoTres, adicionarFinal, cancelar;
    private JTextField nome, distrito, latitude, longitude;
    private JTextField numEmpregadosMesa, numMedClientesDiario, custoEmpregadosMesa, custoSalarioMedioAnual, numMedCafesVendidosDia, numMedBolosVendidosDia, valMedFaturacaoAnualBoloVendidoDia, valMedFaturacaoAnualCafeVendidoDia;
    private JTextField valMedioFaturacaoMesaDia, numDiasFuncionamentoAno, numMesasInteriores, numMesasEsplanada, custoLicencaAnualMesaEsplanada, numMedioDiarioClientesDriveThru, valMedioFaturacaoClienteDriveThru;
    private JTextField custoAnualLimpezaEstabelecimento, numProdutos, valMedFaturacaoAnualProduto, tipo, areaCorredores, valMedFaturacaoAnualMetro2;
    private ButtonListener buttonListener;
    private DefaultListModel<String> valoresLista;
    private JList<String> lista;

    public GUI(StarThrive st) {
        this.st = st;
        setTitle("StarThrive");
        setSize(1920, 1080);
        setLayout(new GridLayout(2, 1));
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        painelEmpresas = new JPanel();
        valoresLista = new DefaultListModel<>();
        for (Empresa e : st.getEmpresas())
            valoresLista.addElement(e.nome);
        lista = new JList<>(valoresLista);
        DefaultListCellRenderer renderer = (DefaultListCellRenderer) lista.getCellRenderer();
        renderer.setHorizontalAlignment(SwingConstants.CENTER);
        lista.setFixedCellHeight(48);
        lista.setFixedCellWidth(1000);
        listScroller = new JScrollPane(lista);
        listScroller.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        painelEmpresas.add(listScroller);

        painelBotoes = new JPanel();
        painelBotoes.setLayout(new GridLayout(1, 5, 20, 60));
        buttonListener = new ButtonListener();
        adicionar = new JButton("Adicionar Empresa");
        adicionar.addActionListener(buttonListener);
        remover = new JButton("Remover Empresa");
        remover.addActionListener(buttonListener);
        editar = new JButton("Editar Empresa");
        editar.addActionListener(buttonListener);
        pontoDois = new JButton("Ponto Dois");
        pontoDois.addActionListener(buttonListener);
        pontoTres = new JButton("Ponto Três");
        pontoTres.addActionListener(buttonListener);
        painelBotoes.add(adicionar);
        painelBotoes.add(remover);
        painelBotoes.add(editar);
        painelBotoes.add(pontoDois);
        painelBotoes.add(pontoTres);

        frameAdicionar = new JFrame();
        frameAdicionar.setTitle("Adicionar Empresa");
        frameAdicionar.setSize(1250, 800);
        frameAdicionar.setLayout(new GridLayout(6, 6, 0, 0));
        frameAdicionar.setLocationRelativeTo(this);
        frameAdicionar.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        frameAdicionar.setUndecorated(true);
        frameAdicionar.setAlwaysOnTop(true);
        panelHolder = new JPanel[6][6];
        for (int i = 0; i < 6; ++i) {
            for (int j = 0; j < 6; ++j) {
                panelHolder[i][j] = new JPanel();
                frameAdicionar.add(panelHolder[i][j]);
            }
        }
        panelHolder[0][0].add(new JLabel("Adicionar Empresa"));
        String[] tipos = {"-Selecione um Tipo-", "Café", "Pastelaria", "Restaurante Local", "Restaurante Fast-food", "Frutaria", "Mercado"};
        comboBoxTipo = new JComboBox<>(tipos);
        comboBoxTipo.setFont((new Font("Arial", Font.BOLD, 10)));
        comboBoxTipo.addActionListener(new ComboBoxActionListener());
        panelHolder[0][1].add(new JLabel("Tipo:"));
        panelHolder[0][2].add(comboBoxTipo);
        adicionarFinal = new JButton("Adicionar");
        adicionarFinal.addActionListener(buttonListener);
        cancelar = new JButton("Cancelar");
        cancelar.addActionListener(buttonListener);
        nome = new JTextField(15);
        distrito = new JTextField(15);
        latitude = new JTextField(15);
        longitude = new JTextField(15);

        panelHolder[1][0].add(new JLabel("Nome:"));
        panelHolder[1][1].add(nome);
        panelHolder[1][2].add(new JLabel("Distrito:"));
        panelHolder[1][3].add(distrito);
        panelHolder[1][4].add(new JLabel("Latitude (GPS):"));
        panelHolder[1][5].add(latitude);
        panelHolder[2][0].add(new JLabel("Longitude (GPS):"));
        panelHolder[2][1].add(longitude);

        panelHolder[5][4].add(adicionarFinal);
        panelHolder[5][5].add(cancelar);

        add(painelEmpresas);
        add(painelBotoes);
        lista.addMouseListener(new MouseAdapter() {
            private int eventCounter = 0;
            java.util.Timer timer = new java.util.Timer("doubleClickTimer", false);


            @Override
            public void mouseClicked(final MouseEvent e) {
                eventCounter = e.getClickCount();
                if (e.getClickCount() == 1) {
                    timer.schedule(new TimerTask() {
                        @Override
                        public void run() {
                            if (eventCounter > 1 && !lista.isSelectionEmpty()) {
                                JOptionPane.showMessageDialog(null, st.getEmpresa(lista.getSelectedIndex()), "Informações da Empresa", JOptionPane.PLAIN_MESSAGE);
                            }
                            eventCounter = 0;
                        }
                    }, 400);
                }
            }
        });
        show();
    }

    private class ButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == adicionar) {
                frameAdicionar.show();
                comboBoxTipo.setSelectedIndex(0);
                nome.setText("");
                distrito.setText("");
                latitude.setText("");
                longitude.setText("");
                enable(false);

            } else if (e.getSource() == remover) {
                if (valoresLista.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Não existem empresas para remover!", "Erro", JOptionPane.ERROR_MESSAGE);
                } else if (lista.isSelectionEmpty()) {
                    JOptionPane.showMessageDialog(null, "Nenhuma empresa selecionada!", "Erro", JOptionPane.ERROR_MESSAGE);
                } else {
                    if (JOptionPane.showConfirmDialog(null, "Tem a certeza que pretende remover a empresa \"%s\"?".formatted(st.getEmpresa(lista.getSelectedIndex()).getNome()), "Remover", JOptionPane.YES_NO_OPTION) == 0) {
                        st.removerEmpresa(st.getEmpresa(lista.getSelectedIndex()));
                        st.escreverFicheiro();
                        valoresLista.remove(lista.getSelectedIndex());
                    }
                }
            } else if (e.getSource() == pontoDois) {
                if (valoresLista.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Não existem empresas para mostrar!", "Erro", JOptionPane.ERROR_MESSAGE);
                } else {
                    for (String s : st.receitaDespesaLucro()) {
                        JOptionPane.showMessageDialog(null, s, "Ponto Dois", JOptionPane.PLAIN_MESSAGE);
                    }
                }

            } else if (e.getSource() == pontoTres) {
                if (valoresLista.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Não existem empresas para mostrar!", "Erro", JOptionPane.ERROR_MESSAGE);
                } else if (st.maiorCapacidadeClientes() == null) {
                    JOptionPane.showMessageDialog(null, "Não existem no mínimo 2 empresas da área da restauração para mostrar!", "Erro", JOptionPane.ERROR_MESSAGE);
                } else {
                    for (Empresa empresa : st.maiorCapacidadeClientes()) {
                        JOptionPane.showMessageDialog(null, empresa, "Ponto Três", JOptionPane.PLAIN_MESSAGE);
                    }
                }
            } else if (e.getSource() == adicionarFinal) {
                try {
                    switch (comboBoxTipo.getSelectedIndex()) {
                        case 1 -> {
                            if (Integer.parseInt(numEmpregadosMesa.getText()) > 0 && Double.parseDouble(numMedClientesDiario.getText()) >= 0 && Double.parseDouble(custoEmpregadosMesa.getText()) >= 0 && Double.parseDouble(custoSalarioMedioAnual.getText()) >= 0 && Double.parseDouble(numMedCafesVendidosDia.getText()) >= 0 && Double.parseDouble(valMedFaturacaoAnualCafeVendidoDia.getText()) >= 0){
                                Cafe cafe = new Cafe(nome.getText(), distrito.getText(), new GPS(Double.parseDouble(latitude.getText()), Double.parseDouble(longitude.getText())), Integer.parseInt(numEmpregadosMesa.getText()), Double.parseDouble(numMedClientesDiario.getText()), Double.parseDouble(custoEmpregadosMesa.getText()), Double.parseDouble(custoSalarioMedioAnual.getText()), Double.parseDouble(numMedCafesVendidosDia.getText()), Double.parseDouble(valMedFaturacaoAnualCafeVendidoDia.getText()));
                                st.adicionarEmpresa(cafe);
                                valoresLista.addElement(cafe.getNome());
                            } else throw new NumberFormatException();
                        }
                        case 2 -> {
                            if (Integer.parseInt(numEmpregadosMesa.getText()) > 0 && Double.parseDouble(numMedClientesDiario.getText()) >= 0 && Double.parseDouble(custoEmpregadosMesa.getText()) >= 0 && Double.parseDouble(custoSalarioMedioAnual.getText()) >= 0 && Double.parseDouble(numMedBolosVendidosDia.getText()) >= 0 && Double.parseDouble(valMedFaturacaoAnualBoloVendidoDia.getText()) >= 0){
                                Pastelaria pastelaria = new Pastelaria(nome.getText(), distrito.getText(), new GPS(Double.parseDouble(latitude.getText()), Double.parseDouble(longitude.getText())), Integer.parseInt(numEmpregadosMesa.getText()), Double.parseDouble(numMedClientesDiario.getText()), Double.parseDouble(custoEmpregadosMesa.getText()), Double.parseDouble(custoSalarioMedioAnual.getText()), Double.parseDouble(numMedBolosVendidosDia.getText()), Double.parseDouble(valMedFaturacaoAnualBoloVendidoDia.getText()));
                                st.adicionarEmpresa(pastelaria);
                                valoresLista.addElement(pastelaria.getNome());
                            }else throw new NumberFormatException();
                        }
                        case 3 -> {
                            if(Integer.parseInt(numEmpregadosMesa.getText()) > 0 && Double.parseDouble(numMedClientesDiario.getText()) >= 0 && Double.parseDouble(custoEmpregadosMesa.getText()) >= 0 && Double.parseDouble(custoSalarioMedioAnual.getText()) >= 0 && Double.parseDouble(valMedioFaturacaoMesaDia.getText()) >= 0 && Integer.parseInt(numDiasFuncionamentoAno.getText()) >= 0 && Integer.parseInt(numMesasInteriores.getText()) >= 0 && Integer.parseInt(numMesasEsplanada.getText()) >= 0 && Double.parseDouble(custoLicencaAnualMesaEsplanada.getText()) >= 0){
                                RestauranteLocal restauranteLocal = new RestauranteLocal(nome.getText(), distrito.getText(), new GPS(Double.parseDouble(latitude.getText()), Double.parseDouble(longitude.getText())), Integer.parseInt(numEmpregadosMesa.getText()), Double.parseDouble(numMedClientesDiario.getText()), Double.parseDouble(custoEmpregadosMesa.getText()), Double.parseDouble(custoSalarioMedioAnual.getText()), Double.parseDouble(valMedioFaturacaoMesaDia.getText()), Integer.parseInt(numDiasFuncionamentoAno.getText()), Integer.parseInt(numMesasInteriores.getText()), Integer.parseInt(numMesasEsplanada.getText()), Double.parseDouble(custoLicencaAnualMesaEsplanada.getText()));
                                st.adicionarEmpresa(restauranteLocal);
                                valoresLista.addElement(restauranteLocal.getNome());
                            }else throw new NumberFormatException();
                        }
                        case 4 -> {
                            if(Integer.parseInt(numEmpregadosMesa.getText()) > 0 && Double.parseDouble(numMedClientesDiario.getText()) >= 0 && Double.parseDouble(custoEmpregadosMesa.getText()) >= 0 && Double.parseDouble(custoSalarioMedioAnual.getText()) >= 0 && Double.parseDouble(valMedioFaturacaoMesaDia.getText()) >= 0 && Integer.parseInt(numDiasFuncionamentoAno.getText()) >= 0 && Integer.parseInt(numMesasInteriores.getText()) >= 0 && Integer.parseInt(numMedioDiarioClientesDriveThru.getText()) >= 0 && Double.parseDouble(valMedioFaturacaoClienteDriveThru.getText()) >= 0){
                                RestauranteFastFood restauranteFastFood = new RestauranteFastFood(nome.getText(), distrito.getText(), new GPS(Double.parseDouble(latitude.getText()), Double.parseDouble(longitude.getText())), Integer.parseInt(numEmpregadosMesa.getText()), Double.parseDouble(numMedClientesDiario.getText()), Double.parseDouble(custoEmpregadosMesa.getText()), Double.parseDouble(custoSalarioMedioAnual.getText()), Double.parseDouble(valMedioFaturacaoMesaDia.getText()), Integer.parseInt(numDiasFuncionamentoAno.getText()), Integer.parseInt(numMesasInteriores.getText()), Double.parseDouble(numMedioDiarioClientesDriveThru.getText()), Double.parseDouble(valMedioFaturacaoClienteDriveThru.getText()));
                                st.adicionarEmpresa(restauranteFastFood);
                                valoresLista.addElement(restauranteFastFood.getNome());
                            }else throw new NumberFormatException();
                        }
                        case 5 -> {
                            if(Double.parseDouble(custoAnualLimpezaEstabelecimento.getText()) >= 0 && Integer.parseInt(numProdutos.getText()) >= 0 && Double.parseDouble(valMedFaturacaoAnualProduto.getText()) >= 0){
                                Frutaria frutaria = new Frutaria(nome.getText(), distrito.getText(), new GPS(Double.parseDouble(latitude.getText()), Double.parseDouble(longitude.getText())), Double.parseDouble(custoAnualLimpezaEstabelecimento.getText()), Integer.parseInt(numProdutos.getText()), Double.parseDouble(valMedFaturacaoAnualProduto.getText()));
                                st.adicionarEmpresa(frutaria);
                                valoresLista.addElement(frutaria.getNome());
                            }else throw new NumberFormatException();
                        }
                        case 6 -> {
                            if(Double.parseDouble(custoAnualLimpezaEstabelecimento.getText()) >= 0 && Double.parseDouble(areaCorredores.getText()) >= 0 && Double.parseDouble(valMedFaturacaoAnualMetro2.getText()) >= 0){
                                Mercado mercado = new Mercado(nome.getText(), distrito.getText(), new GPS(Double.parseDouble(latitude.getText()), Double.parseDouble(longitude.getText())), Double.parseDouble(custoAnualLimpezaEstabelecimento.getText()), tipo.getText(), Double.parseDouble(areaCorredores.getText()), Double.parseDouble(valMedFaturacaoAnualMetro2.getText()));
                                st.adicionarEmpresa(mercado);
                                valoresLista.addElement(mercado.getNome());
                            }else throw new NumberFormatException();
                        }
                    }
                }catch (NumberFormatException ex) {
                    frameAdicionar.dispose();
                    enable(true);
                    show();
                    JOptionPane.showMessageDialog(null, "Algum dos parâmetros da empresa não foi inserido corretamente!", "Erro", JOptionPane.ERROR_MESSAGE);
                }
                st.escreverFicheiro();
                frameAdicionar.dispose();
                enable(true);
                show();
            } else if (e.getSource() == cancelar) {
                frameAdicionar.dispose();
                enable(true);
                show();
            }
        }
    }

    private class ComboBoxActionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            switch (comboBoxTipo.getSelectedIndex()) {
                case 0 -> {
                    adicionarFinal.setEnabled(false);
                    removerElementos();
                }
                case 1 -> {
                    restauracao();
                    //panelHolder[3][4].add(new JLabel("<html>Número médio de cafés vendidos<br>por dia:</html>")); -> era mais feio desta maneira lol
                    panelHolder[3][4].add(new JLabel("Número médio de cafés vendidos"));
                    panelHolder[3][4].add(new JLabel("por dia:"));
                    numMedCafesVendidosDia = new JTextField(15);
                    panelHolder[3][5].add(numMedCafesVendidosDia);
                    panelHolder[4][0].add(new JLabel("Valor médio de faturação anual"));
                    panelHolder[4][0].add(new JLabel("por café vendido por dia:"));
                    valMedFaturacaoAnualCafeVendidoDia = new JTextField(15);
                    panelHolder[4][1].add(valMedFaturacaoAnualCafeVendidoDia);
                }
                case 2 -> {
                    restauracao();
                    panelHolder[3][4].add(new JLabel("Número médio de bolos vendidos"));
                    panelHolder[3][4].add(new JLabel("por dia:"));
                    numMedBolosVendidosDia = new JTextField(15);
                    panelHolder[3][5].add(numMedBolosVendidosDia);
                    panelHolder[4][0].add(new JLabel("Valor médio de faturação anual"));
                    panelHolder[4][0].add(new JLabel("por bolo vendido por dia:"));
                    valMedFaturacaoAnualBoloVendidoDia = new JTextField(15);
                    panelHolder[4][1].add(valMedFaturacaoAnualBoloVendidoDia);
                }
                case 3 -> {
                    restauracao();
                    restaurante();
                    panelHolder[4][4].add(new JLabel("Número de mesas de esplanada:"));
                    numMesasEsplanada = new JTextField(15);
                    panelHolder[4][5].add(numMesasEsplanada);
                    panelHolder[5][0].add(new JLabel("Custo de licença anual"));
                    panelHolder[5][0].add(new JLabel("por mesa de esplanada:"));
                    custoLicencaAnualMesaEsplanada = new JTextField(15);
                    panelHolder[5][1].add(custoLicencaAnualMesaEsplanada);
                }
                case 4 -> {
                    restauracao();
                    restaurante();
                    panelHolder[4][4].add(new JLabel("Número médio diário de clientes"));
                    panelHolder[4][4].add(new JLabel("drive-thru:"));
                    numMedioDiarioClientesDriveThru = new JTextField(15);
                    panelHolder[4][5].add(numMedioDiarioClientesDriveThru);
                    panelHolder[5][0].add(new JLabel("Valor médio diário de faturação"));
                    panelHolder[5][0].add(new JLabel("por cada cliente drive-thru:"));
                    valMedioFaturacaoClienteDriveThru = new JTextField(15);
                    panelHolder[5][1].add(valMedioFaturacaoClienteDriveThru);
                }
                case 5 -> {
                    mercearia();
                    panelHolder[2][4].add(new JLabel("Número de produtos:"));
                    numProdutos = new JTextField(15);
                    panelHolder[2][5].add(numProdutos);
                    panelHolder[3][0].add(new JLabel("Valor médio de faturação anual"));
                    panelHolder[3][0].add(new JLabel("por produto:"));
                    valMedFaturacaoAnualProduto = new JTextField(15);
                    panelHolder[3][1].add(valMedFaturacaoAnualProduto);
                }
                case 6 -> {
                    mercearia();
                    panelHolder[2][4].add(new JLabel("Tipo:"));
                    tipo = new JTextField(15);
                    panelHolder[2][5].add(tipo);
                    panelHolder[3][0].add(new JLabel("Área dos corredores:"));
                    areaCorredores = new JTextField(15);
                    panelHolder[3][1].add(areaCorredores);
                    panelHolder[3][2].add(new JLabel("Valor médio de faturação anual"));
                    panelHolder[3][2].add(new JLabel("por metro quadrado:"));
                    valMedFaturacaoAnualMetro2 = new JTextField(15);
                    panelHolder[3][3].add(valMedFaturacaoAnualMetro2);
                }
            }
        }
    }

    private void removerElementos() {
        for (int i = 2; i < 6; ++i) {
            panelHolder[2][i].removeAll(); // Remove a 3 linha toda (menos a longitude)
            panelHolder[2][i].revalidate();
            panelHolder[2][i].repaint();
        }
        for (int i = 3; i < 5; ++i) {
            for (int j = 0; j < 6; ++j) {
                panelHolder[i][j].removeAll(); // Remove a 4a e a 5a linha
                panelHolder[i][j].revalidate();
                panelHolder[i][j].repaint();
            }
        }
        panelHolder[5][0].removeAll();
        panelHolder[5][0].revalidate();
        panelHolder[5][0].repaint();
        panelHolder[5][1].removeAll();
        panelHolder[5][1].revalidate();
        panelHolder[5][1].repaint();
    }

    private void restauracao() {
        adicionarFinal.setEnabled(true);
        removerElementos();
        panelHolder[2][2].add(new JLabel("Numero de empregados de Mesa:"));
        numEmpregadosMesa = new JTextField(15);
        panelHolder[2][3].add(numEmpregadosMesa);
        panelHolder[2][4].add(new JLabel("Numero médio de clientes diário:"));
        numMedClientesDiario = new JTextField(15);
        panelHolder[2][5].add(numMedClientesDiario);
        panelHolder[3][0].add(new JLabel("Custo dos empregados de mesa:"));
        custoEmpregadosMesa = new JTextField(15);
        panelHolder[3][1].add(custoEmpregadosMesa);
        panelHolder[3][2].add(new JLabel("Custo do salário médio anual:"));
        custoSalarioMedioAnual = new JTextField(15);
        panelHolder[3][3].add(custoSalarioMedioAnual);
    }

    private void restaurante() {
        panelHolder[3][4].add(new JLabel("Valor médio de faturação"));
        panelHolder[3][4].add(new JLabel("de cada mesa por dia:"));
        valMedioFaturacaoMesaDia = new JTextField(15);
        panelHolder[3][5].add(valMedioFaturacaoMesaDia);
        panelHolder[4][0].add(new JLabel("Número de dias de funcionamento"));
        panelHolder[4][0].add(new JLabel("por ano:"));
        numDiasFuncionamentoAno = new JTextField(15);
        panelHolder[4][1].add(numDiasFuncionamentoAno);
        panelHolder[4][2].add(new JLabel("Número de mesas interiores:"));
        numMesasInteriores = new JTextField(15);
        panelHolder[4][3].add(numMesasInteriores);
    }

    private void mercearia() {
        adicionarFinal.setEnabled(true);
        removerElementos();
        panelHolder[2][2].add(new JLabel("Custo anual de limpeza"));
        panelHolder[2][2].add(new JLabel("do estabelecimento:"));
        custoAnualLimpezaEstabelecimento = new JTextField(15);
        panelHolder[2][3].add(custoAnualLimpezaEstabelecimento);
    }
}