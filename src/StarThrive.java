import javax.swing.*;
import java.io.*;
import java.util.ArrayList;

/**
 * Classe para gerir as empresas da StarThrive
 * @author Joás Silva e Diogo Silva
 * @version 3.14
 */
public class StarThrive implements Serializable{
    /**
     * ArrayList com as empresas a serem geridas
     */
    private ArrayList<Empresa> empresas;

    /**
     * Construtor default para a classe StarThrive
     * que aloca memoria para o ArrayList
     */
    public StarThrive() {
        this.empresas = new ArrayList<>();
    }

    /**
     * Método para o <i>Main</i>, onde o codigo é executado
     * @param args Argumentos da linha de comando
     */
    public static void main(String[] args) {
        StarThrive st = new StarThrive();
        st.lerFicheiro();
        new GUI(st);
        st.escreverFicheiro();
        //st.escreverFicheiroTexto(); -> Deu jeito para escrever o .txt
    }

    /**
     * Método para obter o ArrayList de empresas
     * @return ArrayList com todas as empresas da StarThrive
     */
    public ArrayList<Empresa> getEmpresas() {
        return empresas;
    }

    /**
     * Método para ler as empresas do ficheiro
     * Caso exista o ficheiro "starthrive.dat", le-se as empresas do ficheiro de objetos
     * Caso contrario, le do ficheiro "starthrive.txt", e caso este nao exista (ou esteja mal formatado)
     * inicializa o programa com a lista de empresas vazia.
     */
    public void lerFicheiro(){
        File f = new File("starthrive.dat");
        if(f.isFile() && f.exists()) {
            try{
                FileInputStream fIS = new FileInputStream(f);
                ObjectInputStream oIS = new ObjectInputStream(fIS);

                empresas = (ArrayList<Empresa>) oIS.readObject();

                fIS.close();
                oIS.close();
            } catch (FileNotFoundException ex){
                JOptionPane.showMessageDialog(null, "Ficheiro inexistente!", "Erro", JOptionPane.ERROR_MESSAGE);
            } catch (IOException ex){
                JOptionPane.showMessageDialog(null, "Erro ao ler o ficheiro.", "Erro", JOptionPane.ERROR_MESSAGE);
            } catch (ClassNotFoundException ex){
                JOptionPane.showMessageDialog(null, "Erro ao converter o objeto.", "Erro", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            f = new File("starthrive.txt");
            if (f.exists() && f.isFile()) {
                try {
                    FileReader fr = new FileReader(f);
                    BufferedReader br = new BufferedReader(fr);
                    String line;
                    while ((line = br.readLine()) != null) {
                        String[] l = line.split(",");
                        switch (Integer.parseInt(l[0])) {
                            case 1 -> empresas.add(new Cafe(l[1], l[2], new GPS(Double.parseDouble(l[3]), Double.parseDouble(l[4])), Integer.parseInt(l[5]), Double.parseDouble(l[6]), Double.parseDouble(l[7]), Double.parseDouble(l[8]), Double.parseDouble(l[9]), Double.parseDouble(l[10])));
                            case 2 -> empresas.add(new Pastelaria(l[1], l[2], new GPS(Double.parseDouble(l[3]), Double.parseDouble(l[4])), Integer.parseInt(l[5]), Double.parseDouble(l[6]), Double.parseDouble(l[7]), Double.parseDouble(l[8]), Double.parseDouble(l[9]), Double.parseDouble(l[10])));
                            case 3 -> empresas.add(new RestauranteLocal(l[1], l[2], new GPS(Double.parseDouble(l[3]), Double.parseDouble(l[4])), Integer.parseInt(l[5]), Double.parseDouble(l[6]), Double.parseDouble(l[7]), Double.parseDouble(l[8]), Double.parseDouble(l[9]), Integer.parseInt(l[10]), Integer.parseInt(l[11]), Integer.parseInt(l[12]), Double.parseDouble(l[13])));
                            case 4 -> empresas.add(new RestauranteFastFood(l[1], l[2], new GPS(Double.parseDouble(l[3]), Double.parseDouble(l[4])), Integer.parseInt(l[5]), Double.parseDouble(l[6]), Double.parseDouble(l[7]), Double.parseDouble(l[8]), Double.parseDouble(l[9]), Integer.parseInt(l[10]), Integer.parseInt(l[11]), Double.parseDouble(l[12]), Double.parseDouble(l[13])));
                            case 5 -> empresas.add(new Frutaria(l[1], l[2], new GPS(Double.parseDouble(l[3]), Double.parseDouble(l[4])), Double.parseDouble(l[5]), Integer.parseInt(l[6]), Double.parseDouble(l[7])));
                            case 6 -> empresas.add(new Mercado(l[1], l[2], new GPS(Double.parseDouble(l[3]), Double.parseDouble(l[4])), Double.parseDouble(l[5]), l[6], Double.parseDouble(l[7]), Double.parseDouble(l[8])));
                        }
                    }
                    fr.close();
                    br.close();
                } catch (FileNotFoundException ex) {
                    JOptionPane.showMessageDialog(null, "Ficheiro inexistente \"starthrive.txt\"", "Erro", JOptionPane.ERROR_MESSAGE);
                } catch (IOException ex) {
                    JOptionPane.showMessageDialog(null, "Erro ao ler o ficheiro!", "Erro", JOptionPane.ERROR_MESSAGE);
                } catch (NumberFormatException | ArrayIndexOutOfBoundsException ex) {
                    System.out.println(ex);
                    JOptionPane.showMessageDialog(null, "Ficheiro \"starthrive.txt\" mal formatado!", "Erro", JOptionPane.ERROR_MESSAGE);
                    empresas = new ArrayList<>();
                }
            }
        }
    }

    /**
     * Metodo para obter uma empresa pelo seu indice no ArrayList
     * @param index Indice da empresa no ArrayList
     * @return Objeto da Empresa
     */
    public Empresa getEmpresa(int index){
        return empresas.get(index);
    }

    /**
     * Metodo para adicionar uma empresa na lista de empresas
     * @param empresa Objeto da empresa a ser adicionada a lista
     */
    public void adicionarEmpresa(Empresa empresa){
        empresas.add(empresa);
    }

    /**
     * Metodo para remover uma empresa na lista de empresas
     * @param empresa Objeto da empresa a ser removida da lista
     */
    public void removerEmpresa(Empresa empresa){
        empresas.remove(empresa);
    }

    /**
     * Metodo para substituir uma empresa da lista de empresas
     * @param empresa Empresa a substituir a empresa da lista
     * @param index Indice da lista onde a empresa vai ser substituida
     */
    public void editarEmpresa(Empresa empresa, int index){
        empresas.set(index, empresa);
    }

    /**
     * Metodo para escrever a lista de empresas em um ficheiro de objetos
     * "starthrive.dat".
     */
    public void escreverFicheiro(){
        File ficheiro = new File("starthrive.dat");
        try {
            FileOutputStream fOS = new FileOutputStream(ficheiro);
            ObjectOutputStream oOS = new ObjectOutputStream(fOS);

            oOS.writeObject(empresas);
            
            fOS.close();
            oOS.close();
        } catch (FileNotFoundException ex){
            System.out.println("Erro a criar o ficheiro.");
        } catch (IOException ex) {
            System.out.println("Erro a escrever para o ficheiro.");
        }
    }

    /**
     * Metodo para escrever a lista de empresas em um ficheiro de objetos
     * "starthrive.dat".
     * (Este metodo nao e utilizado no programa, mas foi feito para poder ajudar
     * a criar as 5 empresas de cada categoria).
     */
    public void escreverFicheiroTexto(){
        File ficheiro = new File("starthrive.txt");
        try {
            FileWriter fw = new FileWriter(ficheiro);
            BufferedWriter bw = new BufferedWriter(fw);

            for (Empresa e: empresas){
                fw.write(e.toStringFicheiro());
            }

            fw.close();
            bw.close();
        } catch (FileNotFoundException ex){
            System.out.println("Erro a criar o ficheiro.");
        } catch (IOException ex) {
            System.out.println("Erro a escrever para o ficheiro.");
        }
    }

    /**
     * Metodo pedido no ponto 2 para apresentar para cada tipo de empresa, a empresa com maior receita anual (nome e
     * valor), a empresa com menor despesa anual (nome e valor) e a empresa com maior
     * lucro anual (nome e valor do lucro).
     * @return String com as empresas de maior receita anual, menor despesa anual e com maior lucro anual
     * de cada categoria.
     */
    public String receitaDespesaLucro(){
        String[] categorias = {"Café", "Pastelaria", "Restaurante Local", "Restaurante Fast-food", "Frutaria", "Mercado"};
        String resultado = "";
        for(String c: categorias){
            double maiorReceita = 0, menorDespesa = Double.MAX_VALUE, maiorLucro = -menorDespesa;
            String nomeEmpresaReceita = null, nomeEmpresaDespesa = null, nomeEmpresaLucro = null;
            for(Empresa e: empresas){
                if(c.equals(e.categoria)){
                    if(e.defReceitaAnual()>maiorReceita){
                        maiorReceita = e.defReceitaAnual();
                        nomeEmpresaReceita = e.nome;
                    }if(e.defDespesaAnual()<menorDespesa){
                        menorDespesa = e.defDespesaAnual();
                        nomeEmpresaDespesa = e.nome;
                    }if(e.defReceitaAnual()-e.defDespesaAnual() > maiorLucro){
                        maiorLucro = e.defReceitaAnual()-e.defDespesaAnual();
                        nomeEmpresaLucro = e.nome;
                    }
                }
            }
            if (nomeEmpresaReceita != null && nomeEmpresaDespesa != null && nomeEmpresaLucro != null) {
                String categoria = "Empresa da categoria: " + c + "\n\n\t•Com maior receita: " + nomeEmpresaReceita + ", " + maiorReceita + "€\n"
                 + "\t•Com menor despesa: " + nomeEmpresaDespesa + ", " + menorDespesa + "€\n" + "\t•Com maior lucro: " + nomeEmpresaLucro + ", " + maiorLucro + "€\n\n";
                resultado = resultado + categoria;
            }
        }
        return resultado;
        /*-------------------------------------------------OUTRA MANEIRA-------------------------------------------------*/
        /*String[] categorias = {"Café", "Pastelaria", "Restaurante Local", "Restaurante Fast-food", "Frutaria", "Mercado"};
        for(String c: categorias){
            double maiorReceita = 0, menorDespesa = Double.MAX_VALUE, maiorLucro = 0;
            String nomeEmpresaReceita = null, nomeEmpresaDespesa = null, nomeEmpresaLucro = "NENHUMA";
            for(Empresa e: empresas){
                if(c.equals(e.categoria) && e.defReceitaAnual()>maiorReceita){
                    maiorReceita = e.defReceitaAnual();
                    nomeEmpresaReceita = e.nome;
                }if (c.equals(e.categoria) && e.defDespesaAnual()<menorDespesa){
                    menorDespesa = e.defDespesaAnual();
                    nomeEmpresaDespesa = e.nome;
                }if (c.equals(e.categoria) && e.lucro() && e.defReceitaAnual()-e.defDespesaAnual() > maiorLucro){
                    maiorLucro = e.defReceitaAnual()-e.defDespesaAnual();
                    nomeEmpresaLucro = e.nome;
                }
            }
            if (nomeEmpresaReceita != null && nomeEmpresaDespesa != null) {
                System.out.println("Empresa da categoria " + c);
                System.out.println("\tCom maior receita: " + nomeEmpresaReceita + ", " + maiorReceita + "€");
                System.out.println("\tCom menor despesa: " + nomeEmpresaDespesa + ", " + menorDespesa + "€");
                System.out.println("\tCom maior lucro: " + nomeEmpresaLucro + ", " + maiorLucro + "€");
            }
        }*/
    }

    /**
     * Metodo pedido no ponto 3 que obtem as 2 empresas do tipo restauracao
     * com maior capacidade de clientes por dia.
     * @return Array com as 2 empresas do tipo restauracao com maior capacidade
     * de clientes por dia (primeiro elemento tem a maior capacidade, segundo tem a segunda menor
     * capacidade), e caso a lista de empresas nao possua no minimo 2 empresas da area da restauracao
     * retorna <i>null</i>.
     */
    public Empresa[] maiorCapacidadeClientes(){
        //O Array comeca com 2 empresas do tipo Cafe vazias, mas poderia ser qualquer tipo de empresa
        //vazia para ao correr o codigo da linha 254 nao dar erro de aceder a um objeto null.
        Empresa[] maiores = {new Cafe(), new Cafe()};
        for (Empresa e: empresas){
            if (e.capacidadeRestauracao() > 0){
                if(e.capacidadeRestauracao() > maiores[0].capacidadeRestauracao()){
                    maiores[1] = maiores[0];
                    maiores[0] = e;
                } else if (e.capacidadeRestauracao() > maiores[1].capacidadeRestauracao()) {
                    maiores[1] = e;
                }
            }
        }
        //Caso a capacidade de restauracao de um deles esteja a zero, significa que e um dos
        //cafes que foi criado ao inicializar o Array, o que significa que nao existem no minimo 2
        //empresas da area da restauracao (pois uma empresa da restauracao nao pode nunca ter a sua
        //capacidade diaria a zero).
        if (maiores[0].capacidadeRestauracao() != 0 && maiores[1].capacidadeRestauracao() != 0) {
            return maiores;
        }else {
            return null;
        }
    }
}
