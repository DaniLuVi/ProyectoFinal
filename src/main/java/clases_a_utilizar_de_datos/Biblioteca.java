package clases_a_utilizar_de_datos;

public class Biblioteca extends Entorno{
    public Biblioteca(int tiempo_aparicion, int probabilidad, String tipo) {
        super(tiempo_aparicion, probabilidad, tipo);
    }
    public Biblioteca() {}
    @Override
    public void modificarIndividuo(Individuo individuo) {
        int clonacion = individuo.getClonacion();
        individuo.setClonacion(clonacion + 10);
    }
}
