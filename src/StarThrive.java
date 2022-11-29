import java.io.*;
import java.util.ArrayList;

public class StarThrive implements Serializable{
    private ArrayList<Empresa> empresas;

    public StarThrive() {
        this.empresas = new ArrayList<>();
    }

    public static void main(String[] args) {
        StarThrive st = new StarThrive();
        st.lerFicheiro();
        new GUI(st);
        st.escreverFicheiro();
        /*for(Empresa e: st.empresas)
            System.out.println(e);
        st.receitaDespesaLucro();
        System.out.println();
        st.maiorCapacidadeClientes();*/
    }

    public ArrayList<Empresa> getEmpresas() {
        return empresas;
    }

    public void lerFicheiro(){
        File f = new File("starthrive.obj");
        if(f.isFile() && f.exists()) {
            try{
                FileInputStream fIS = new FileInputStream(f);
                ObjectInputStream oIS = new ObjectInputStream(fIS);

                empresas = (ArrayList<Empresa>) oIS.readObject();

                fIS.close();
                oIS.close();
            } catch (FileNotFoundException ex){
                System.out.println("Ficheiro inexistente!");
            } catch (IOException ex){
                System.out.println("Erro ao ler o ficheiro.");
            } catch (ClassNotFoundException ex){
                System.out.println("Erro ao converter o objeto.");
            }
        } else{
            f = new File("starthrive.txt");
            if(f.exists() && f.isFile()) {
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
                    System.out.println("Ficheiro inexistente \"StarThrive.txt\"");
                } catch (IOException ex) {
                    System.out.println("Erro ao ler o ficheiro!");
                }
            }
        }
    }

    public Empresa getEmpresa(int index){
        return empresas.get(index);
    }

    public void escreverFicheiro(){
        File ficheiro = new File("starthrive.obj");
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

    public void receitaDespesaLucro(){
        String[] categorias = {"Café", "Pastelaria", "Restaurante Local", "Restaurante Fast-food", "Frutaria", "Mercado"};
        for(String c: categorias){
            double maiorReceita = 0, menorDespesa = Double.MAX_VALUE, maiorLucro = -menorDespesa;
            String nomeEmpresaReceita = null, nomeEmpresaDespesa = null, nomeEmpresaLucro = null;
            for(Empresa e: empresas){
                if(c.equals(e.categoria) && e.defReceitaAnual()>maiorReceita){
                    maiorReceita = e.defReceitaAnual();
                    nomeEmpresaReceita = e.nome;
                }if (c.equals(e.categoria) && e.defDespesaAnual()<menorDespesa){
                    menorDespesa = e.defDespesaAnual();
                    nomeEmpresaDespesa = e.nome;
                }if (c.equals(e.categoria) && e.defReceitaAnual()-e.defDespesaAnual() > maiorLucro){
                    maiorLucro = e.defReceitaAnual()-e.defDespesaAnual();
                    nomeEmpresaLucro = e.nome;
                }
            }
            if (nomeEmpresaReceita != null && nomeEmpresaDespesa != null && nomeEmpresaLucro != null) {
                System.out.println("Empresa da categoria " + c);
                System.out.println("\tCom maior receita: " + nomeEmpresaReceita + ", " + maiorReceita + "€");
                System.out.println("\tCom menor despesa: " + nomeEmpresaDespesa + ", " + menorDespesa + "€");
                System.out.println("\tCom maior lucro: " + nomeEmpresaLucro + ", " + maiorLucro + "€\n");
            }
        }
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

    public void maiorCapacidadeClientes(){
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
        for (Empresa e: maiores) System.out.println(e);
    }
}
