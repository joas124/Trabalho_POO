public class Mercado extends Mercearia {
    private String tipo;
    private double areaCorredores, valMedFaturacaoAnualMetro2;

    public Mercado(){}

    public Mercado(String nome, String distrito, GPS localizacao, double custoAnualLimpezaEstabelecimento, String tipo, double areaCorredores, double valMedFaturacaoAnualMetro2) {
        super("Mercado", nome, distrito, localizacao, custoAnualLimpezaEstabelecimento);
        this.tipo = tipo;
        this.areaCorredores = areaCorredores;
        this.valMedFaturacaoAnualMetro2 = valMedFaturacaoAnualMetro2;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public double getAreaCorredores() {
        return areaCorredores;
    }

    public void setAreaCorredores(double areaCorredores) {
        this.areaCorredores = areaCorredores;
    }

    @Override
    public double defReceitaAnual() {
        return areaCorredores * valMedFaturacaoAnualMetro2;
    }

    @Override
    public boolean lucro() {
        return (defReceitaAnual() - defDespesaAnual()) > 0;
    }

    @Override
    public String toString() {
        return  super.toString() +
                "\t•Tipo = '" + tipo + "'\n" +
                "\t•Area de corredores = " + areaCorredores + "m²\n" +
                "\t•Valor medio de faturacao anual por metro quadrado = " + valMedFaturacaoAnualMetro2 + "€\n";
    }

}
