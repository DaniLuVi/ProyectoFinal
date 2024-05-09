package clases_a_utilizar_de_datos;

public class Biblioteca extends Entorno{
    public Biblioteca(int tiempo_aparicion, int v) {
        super(tiempo_aparicion, v);
    }
    public Biblioteca() {}
    private void probabilidad() {
        setV(10);
    }
    @Override
    public void modificarIndividuo(Individuo individuo) {
        int clonacion = individuo.getClonacion();
        individuo.setClonacion(clonacion + 10);
    }
}
