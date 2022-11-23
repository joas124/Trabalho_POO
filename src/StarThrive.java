import java.io.*;
import java.util.ArrayList;

public class StarThrive implements Serializable{
    private ArrayList<Empresa> empresas;

    public StarThrive() {
        this.empresas = new ArrayList<>();
    }

    public static void main(String[] args) {
        StarThrive st = new StarThrive();
        st.escreverFicheiro();
        st.lerFicheiro();
        for(Empresa e: st.empresas) System.out.println(e);
    }

    public void lerFicheiro(){
        File f = new File("StarThrive.obj");
        if(f.isFile() && f.exists()) try{
            FileInputStream fIS = new FileInputStream(f);
            ObjectInputStream oIS = new ObjectInputStream(fIS);

            empresas = (ArrayList<Empresa>) oIS.readObject();

            oIS.close();
        }catch (FileNotFoundException ex){
            System.out.println("Ficheiro inexistente!");
        }catch (IOException ex){
            System.out.println("Erro ao ler o ficheiro.");
        }catch (ClassNotFoundException ex){
            System.out.println("Erro ao converter o objeto.");
        }
        else{
            f = new File("StarThrive.txt");
            if(f.exists() && f.isFile()) try {
                FileReader fr = new FileReader(f);
                BufferedReader br = new BufferedReader(fr);
                String line;
                while ((line = br.readLine()) != null) {
                    String[] l = line.split(",");
                    switch (Integer.parseInt(l[0])) {
                        case 1 -> empresas.add(new Cafe(l[1], l[2], new GPS(Double.parseDouble(l[3]), Double.parseDouble(l[4])), Integer.parseInt(l[5]), Float.parseFloat(l[6]), Float.parseFloat(l[7]), Float.parseFloat(l[8]), Float.parseFloat(l[9]), Float.parseFloat(l[10])));
                        case 2 -> empresas.add(new Pastelaria(l[1], l[2], new GPS(Double.parseDouble(l[3]), Double.parseDouble(l[4])), Integer.parseInt(l[5]), Float.parseFloat(l[6]), Float.parseFloat(l[7]), Float.parseFloat(l[8]), Float.parseFloat(l[9]), Float.parseFloat(l[10])));
                        case 3 -> empresas.add(new RestauranteLocal(l[0], l[1], new GPS(Double.parseDouble(l[3]), Double.parseDouble(l[4])), Integer.parseInt(l[5]), Float.parseFloat(l[6]), Float.parseFloat(l[7]), Float.parseFloat(l[8]), Float.parseFloat(l[9]), Integer.parseInt(l[10]), Integer.parseInt(l[11]), Integer.parseInt(l[12]), Float.parseFloat(l[13])));
                        case 4 -> empresas.add(new RestauranteFastFood(l[0], l[1], new GPS(Double.parseDouble(l[3]), Double.parseDouble(l[4])), Integer.parseInt(l[5]), Float.parseFloat(l[6]), Float.parseFloat(l[7]), Float.parseFloat(l[8]), Float.parseFloat(l[9]), Integer.parseInt(l[10]), Integer.parseInt(l[11]), Float.parseFloat(l[12]), Float.parseFloat(l[13])));
                        case 5 -> empresas.add(new Frutaria(l[0], l[1], new GPS(Double.parseDouble(l[3]), Double.parseDouble(l[4])), Float.parseFloat(l[5]), Integer.parseInt(l[6]), Float.parseFloat(l[7])));
                        case 6 -> empresas.add(new Mercado(l[1], l[2], new GPS(Double.parseDouble(l[3]), Double.parseDouble(l[4])), Float.parseFloat(l[5]), l[6], Float.parseFloat(l[7]), Float.parseFloat(l[8])));
                    }
                }
            }catch (FileNotFoundException ex) {
                System.out.println("Ficheiro inexistente \"StarThrive.txt\"");
            }catch (IOException ex){
                System.out.println("Erro ao ler o ficheiro!");
            }
        }
    }
    public void escreverFicheiro(){
        File ficheiro = new File("StarThrive.obj");
        try {
            FileOutputStream fOS = new FileOutputStream(ficheiro);
            ObjectOutputStream oOS = new ObjectOutputStream(fOS);
            empresas.add(new Mercado("Portinhas do Sol", "Santarem", new GPS(39.2344731739881, -8.67621008394912), 8000000, "Mini", 180, 20));
            empresas.add(new Pastelaria("Bijou", "Santarem", new GPS(39.237065264686166, -8.68385466682642), 3, 4.3, 11201, 238984, 38424, 238));
            oOS.writeObject(empresas);
        }
        catch (FileNotFoundException ex){
            System.out.println("Erro a criar o ficheiro.");
        }
        catch (IOException ex) {
            System.out.println("Erro a escrever para o ficheiro.");
        }
    }
}
