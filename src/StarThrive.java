import java.io.*;
import java.util.ArrayList;

public class StarThrive {
    private ArrayList<Empresa> empresas;

    public StarThrive() {
        this.empresas = new ArrayList<>();
    }

    public static void main(String[] args) {
        StarThrive st = new StarThrive();
        st.lerFicheiro();
        for(Empresa e: st.empresas) System.out.println(e);
    }

    public void lerFicheiro(){
        try{
            File f = new File("StarThrive.txt");
            FileReader fr = new FileReader(f);
            BufferedReader br = new BufferedReader(fr);
            String[] l = br.readLine().split(",");
            switch (Integer.parseInt(l[0])){
                case 1:
                    break;
                case 6:
                    empresas.add(new Mercado(l[1], l[2], new GPS(Double.parseDouble(l[3]),Double.parseDouble(l[4])), Float.parseFloat(l[5]), l[6], Float.parseFloat(l[7]), Float.parseFloat(l[8])));
                    break;
            }
        } catch (FileNotFoundException e) {
            System.out.println("Ficheiro inexistente StarThrive.txt");
        }catch (IOException e){

        }
    }
    public void escreverFicheiro(){

    }
}
