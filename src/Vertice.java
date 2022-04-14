import java.util.ArrayList;

public class Vertice {

    public String nome;
    ArrayList<Aresta> adj;

    public Vertice(final String nome) {
        this.nome = nome;
        this.adj = new ArrayList<Aresta>();
    }
    public void addAdj(Aresta e) {
        this.adj.add(e);
    }
}
