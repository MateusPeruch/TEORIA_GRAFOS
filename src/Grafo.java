import java.util.ArrayList;

public class Grafo {

    private ArrayList<Vertice> vertices;
    private ArrayList<Aresta> arestas;
    public String numberVetor[];

    public Grafo() {
        this.vertices = new ArrayList<Vertice>();
        this.arestas = new ArrayList<Aresta>();
    }

    public Vertice addVertice(final String nome) {
        Vertice v = new Vertice(nome);
        vertices.add(v);
        return v;
    }
    public ArrayList<Vertice> Vertice(){
        return vertices;
    }

    public Aresta addAresta(Vertice origem, Vertice destino) {
        Aresta a = new Aresta(origem, destino);
        origem.addAdj(a);
        arestas.add(a);
        return a;
    }
    @Override
    public String toString() {
        String r = "";
        for (Vertice u : vertices) {
            r += u.nome + " -> ";
            for (Aresta e : u.adj) {
                Vertice v = e.destino;
                r += v.nome + ", ";
            }
            r += "\n";
        }
        return r;
    }

    public static void main(String[] args) {
        Grafo g = new Grafo();


        Vertice A = g.addVertice("101");
        Vertice B = g.addVertice("102");
        Vertice C = g.addVertice("103");
        Vertice D = g.addVertice("104");
        Vertice E = g.addVertice("201");
        Vertice F = g.addVertice("202");
        Vertice G = g.addVertice("203");
        Vertice H = g.addVertice("204");

        Aresta AB = g.addAresta(A, B);
        Aresta BC = g.addAresta(B, C);
        Aresta BA = g.addAresta(B, A);
        Aresta BE = g.addAresta(B, E);
        Aresta BF = g.addAresta(B, F);
        Aresta CB = g.addAresta(C, B);
        Aresta CD = g.addAresta(C, D);
        Aresta CF = g.addAresta(C, F);
        Aresta CG = g.addAresta(C, G);
        Aresta CH = g.addAresta(C, H);
        Aresta DC = g.addAresta(D, C);
        Aresta DG = g.addAresta(D, G);
        Aresta DH = g.addAresta(D, H);
        Aresta EB = g.addAresta(E, B);
        Aresta EF = g.addAresta(E, F);
        Aresta FE = g.addAresta(F, E);
        Aresta FG = g.addAresta(F, G);
        Aresta FB = g.addAresta(F, B);
        Aresta FC = g.addAresta(F, C);
        Aresta GC = g.addAresta(G, C);
        Aresta GD = g.addAresta(G, D);
        Aresta GF = g.addAresta(G, F);
        Aresta GH = g.addAresta(G, H);
        Aresta HG = g.addAresta(H, G);
        Aresta HC = g.addAresta(H, C);
        Aresta HD = g.addAresta(H, D);


        System.out.println(g);
    }
}



