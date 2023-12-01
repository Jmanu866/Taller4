package Modules.Cofres;


public class Cofre {


    /**
     * ID
     */

    private String ID;

    /**
     *  Fecha final del Cofre
     */
    private long fechaFinal;

    /**
     * Tipo de Cofre
     */

    private String Tipo;

    /**
     * Constructor del Cofre
     */
    public Cofre(String ID, long fechaFinal, String tipo) {
        this.ID = ID;
        this.fechaFinal = fechaFinal;
        this.Tipo = tipo;
    }


    /**
     * Get ID
     * @return
     */
    public String getID() {
        return ID;
    }

    /**
     * Get Fecha Final del cofre
     * @return
     */

    public long getFechaFinal() {
        return fechaFinal;
    }

    /**
     * Get Tipo de cofre
     * @return
     */
    public String getTipo() {
        return Tipo;
    }








}
