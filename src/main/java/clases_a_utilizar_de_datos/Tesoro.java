package clases_a_utilizar_de_datos;

public class Tesoro extends Entorno{
    public Tesoro(int tiempo_aparicion, int probabilidad) {
        super(tiempo_aparicion, probabilidad);
    }
    public Tesoro() {}
    @Override
    public void modificarIndividuo(Individuo individuo) {
        int reproduccion = individuo.getReproduccion();
        individuo.setReproduccion(reproduccion + 15);
    }
}
