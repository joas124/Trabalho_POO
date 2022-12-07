import java.io.Serializable;

/**
 * Classe para guardar as coordenadas GPS
 * @author Joás Sila e Diogo Silva
 * @version 3.14
 */
public class GPS implements Serializable {
    /**
     * Coordenadas GPS (Latitude e Longitude)
     */
    private double latitude, longitude;

    /**
     * Construtor default para a classe GPS
     */
    public GPS(){}

    /**
     * Construtor para a classe GPS
     * @param latitude Double com a latitude da localizacao da empresa
     * @param longitude Double com a longitude da localizacao da empresa
     */
    public GPS(double latitude, double longitude) {
        this.latitude = latitude;
        this.longitude = longitude;
    }

    /**
     * Metodo para obter a latitude da localizacao da empresa
     * @return double com a latitude da localizacao da empresa
     */
    public double getLatitude() {
        return latitude;
    }

    /**
     * Metodo para definir a latitude da localizacao da empresa
     * @param latitude double com a latitude da localizacao da empresa
     */
    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    /**
     * Metodo para obter a longitude da localizacao da empresa
     * @return double com a longitude da localizacao da empresa
     */
    public double getLongitude() {
        return longitude;
    }

    /**
     * Metodo para definir a longitude da localizacao da empresa
     * @param longitude double com a longitude da localizacao da empresa
     */
    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    /**
     * Metodo para converter a classe GPS em String
     * @return String com as coordenadas GPS da Empresa
     */
    @Override
    public String toString() {
        return  latitude + "," + longitude;
    }
}
