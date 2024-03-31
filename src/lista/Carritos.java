package lista;
 
public class Carritos 
{
    private String codigo;
    private String tipo;

    /*------------------------------------------------------------------------------*/
    /*                                  INICIO DE SETTERS                           */
    /*------------------------------------------------------------------------------*/
    public void setCodigo(String codigo)
    {
        this.codigo = codigo;
    }

    public void setTipo(String tipo)
    {
        this.tipo = tipo;
    }

    /*------------------------------------------------------------------------------*/
    /*                                  INICIO DE GETTERS                           */
    /*------------------------------------------------------------------------------*/
    public String getCodigo()
    {
        return codigo;
    }

    public String getTipo()
    {
        return tipo;
    }
}
