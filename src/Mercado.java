public class Mercado extends Mercearia {
    private String tipo;
    private float areaCorredores, valMedFaturacaoAnualMetro2;

    public Mercado(){}

    public Mercado(String nome, String distrito, GPS localizacao, float custoAnualLimpezaEstabelecimento, String tipo, float areaCorredores, float valMedFaturacaoAnualMetro2) {
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

    public float getAreaCorredores() {
        return areaCorredores;
    }

    public void setAreaCorredores(float areaCorredores) {
        this.areaCorredores = areaCorredores;
    }

    @Override
    public float defReceitaAnual() {
        return areaCorredores * valMedFaturacaoAnualMetro2;
    }

    @Override
    public boolean lucro() {
        return (defReceitaAnual() - defDespesaAnual()) > 0;
    }

    @Override
    public String toString() {
        return  super.toString() +
                "\t•Tipo = " + tipo + '\n' +
                "\t•Area de corredores = " + areaCorredores + '\n' +
                "\t•Valor medio de faturacao anual por metro quadrado = " + valMedFaturacaoAnualMetro2 + "€\n";
    }

    @Override
    public String toStringFicheiro() {
        return '6' + super.toStringFicheiro() + tipo + ',' + areaCorredores + ',' + valMedFaturacaoAnualMetro2;
    }
}
