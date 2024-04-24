package clases_a_utilizar_de_datos;

public class Tesoro extends Entorno{
    public Tesoro(int tiempo_aparicion, int v) {
        super(tiempo_aparicion, v);
    }
    private void probabilidad() {
        setV(10);
    }
    @Override
    public void modificarIndividuo(Individuo individuo) {
        int reproduccion = individuo.getReproduccion();
        //individuo.setReproduccion(reproduccion + );
    }
}
