package clases_a_utilizar_de_datos;

public class TipoBasico extends Individuo{
    public TipoBasico(int id, int generacion, int vidas, int reproduccion, int clonacion) {
        super(id, generacion, vidas, reproduccion, clonacion);
    }
    public TipoBasico() {
        super();
    }
    @Override
    public void movimiento(Individuo individuo) {

    }
}
