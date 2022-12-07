/**
 * Classe para a gestao de um mercado
 * @author Joás Silva e Diogo Silva
 * @version 3.14
 */
public class Mercado extends Mercearia {
    /**
     * Tipo (Mini, Super, Hiper)
     */
    private String tipo;
    /**
     * Area dos corredores
     */
    private double areaCorredores;
    /**
     * Valor medio de faturacao anual por metro quadrado
     */
    private double valMedFaturacaoAnualMetro2;

    /**
     * Construtor default para a classe Mercado
     */
    public Mercado(){}

    /**
     * Construtor para a classe Mercado
     * @param nome String com o nome do mercado
     * @param distrito String com o distrito onde o mercado esta localizado
     * @param localizacao Objeto GPS com as coordenadas da localizacao do mercado
     * @param custoAnualLimpezaEstabelecimento custo anual da limpeza do estabelecimento
     * @param tipo String com o tipo do mercado (Mini, Super, Hiper)
     * @param areaCorredores area dos corredores
     * @param valMedFaturacaoAnualMetro2 valor medio de faturacao anual por metro quadrado
     */
    public Mercado(String nome, String distrito, GPS localizacao, double custoAnualLimpezaEstabelecimento, String tipo, double areaCorredores, double valMedFaturacaoAnualMetro2) {
        super("Mercado", nome, distrito, localizacao, custoAnualLimpezaEstabelecimento);
        this.tipo = tipo;
        this.areaCorredores = areaCorredores;
        this.valMedFaturacaoAnualMetro2 = valMedFaturacaoAnualMetro2;
    }

    /**
     * Metodo para obter o tipo do mercado
     * @return String com o tipo do mercado (Mini, Super, Hiper)
     */
    public String getTipo() {
        return tipo;
    }

    /**
     * Metodo para definir o tipo do mercado
     * @param tipo String com o tipo do mercado (Mini, Super, Hiper)
     */
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    /**
     * Metodo para obter o valor médio de faturacao anual por metro quadrado
     * @return double com o valor médio de faturacao anual por metro quadrado
     */
    public double getValMedFaturacaoAnualMetro2() {
        return valMedFaturacaoAnualMetro2;
    }

    /**
     * Metodo para definir o valor médio de faturacao anual por metro quadrado
     * @param valMedFaturacaoAnualMetro2 double com o valor médio de faturacao anual por metro quadrado
     */
    public void setValMedFaturacaoAnualMetro2(double valMedFaturacaoAnualMetro2) {
        this.valMedFaturacaoAnualMetro2 = valMedFaturacaoAnualMetro2;
    }

    /**
     * Metodo para obter a area dos corredores
     * @return double com a area dos corredores
     */
    public double getAreaCorredores() {
        return areaCorredores;
    }

    /**
     * Metodo para definir a area dos corredores
     * @param areaCorredores double com a area dos corredores
     */
    public void setAreaCorredores(double areaCorredores) {
        this.areaCorredores = areaCorredores;
    }

    /**
     * Metodo que efetua o calculo da receita anual do mercado
     * @return double com o valor da receita anual
     */
    @Override
    public double defReceitaAnual() {
        return areaCorredores * valMedFaturacaoAnualMetro2;
    }

    /**
     * Metodo que efetua o calculo do lucro do mercado
     * @return <i>True</i> caso o mercado obtenha lucro no final do ano, <i>False</i> caso obtenha prejuizo
     */
    @Override
    public boolean lucro() {
        return (defReceitaAnual() - defDespesaAnual()) > 0;
    }

    /**
     * Metodo para converter a classe Mercado em String
     * @return String com o tipo, area de corredores e valor medio
     * de faturacao anual por metro quadrado de um mercado
     */
    @Override
    public String toString() {
        return  super.toString() +
                "\t•Tipo = '" + tipo + "'\n" +
                "\t•Area de corredores = " + areaCorredores + "m²\n" +
                "\t•Valor medio de faturacao anual por metro quadrado = " + valMedFaturacaoAnualMetro2 + "€\n";
    }
    /**
     * Metodo apenas utilizado para escrever as empresas no ficheiro de texto (Que
     * nao e pedido no enunciado, mas deu jeito para criar as empresas de cada tipo)
     * @return String com as caracteristicas da empresa para o ficheiro txt
     */
    @Override
    public String toStringFicheiro() {
        return "6," + super.toStringFicheiro() + tipo + ',' + areaCorredores + ',' + valMedFaturacaoAnualMetro2 + '\n';
    }
}
