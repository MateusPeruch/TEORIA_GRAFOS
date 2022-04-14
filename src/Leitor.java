import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Leitor {
    private static final String SEPARATOR = ": ";

    public static void main(String[] args) {

        BufferedReader br = null;
        try {
            InputStream is = new FileInputStream(new File("C:\\Users\\user\\Desktop\\configs.txt"));
            InputStreamReader isr = new InputStreamReader(is);
            br = new BufferedReader(isr);
            int cont = 0;
            boolean erro = false;
            String linha = "";
            String edificio = linha = br.readLine().substring(8, 39);
            List number = new ArrayList();
            int contNegative = 0;
            List linhaNegative = new ArrayList();
            int contRepeted = 0;
            List linhaRepeted = new ArrayList();
            Grafo g = new Grafo();

            while((linha = br.readLine()) != null) {
                cont += 1 ;
                final String partes[] = linha.split(SEPARATOR);

                if(partes[1].startsWith("E")){
                    continue;
                }else if(partes[1].startsWith("-")){
                    contNegative++;
                    linhaNegative.add(linha);
                }else if(number.contains(partes[1])){
                    contRepeted++;
                    linhaRepeted.add(linha);
                }else if(partes[1].contains("TRAILER")){
                    final String contTrailer[] = partes[1].split("TRAILER");
                    if(Integer.parseInt(contTrailer[1]) != cont - 1){
                        erro = true;
                    }
                }else{
                    number.add(partes[1]);
                }

            }
            if(erro == true) {
                System.out.println("Arquivo .txt inválido!");
            }else {
                int tam = number.size();
                final String numberArray [] = new String[tam];

                for (int i = 0; i < number.size(); i++) {
                    numberArray[i] = (String) number.get(i);
                    g.addVertice((String) number.get(i));
                }

                for (int i = 0; i < g.Vertice().size(); i++) {
                    if(!(g.Vertice().get(i).nome.startsWith("7") || g.Vertice().get(i).nome.startsWith("1"))){
                        if(g.Vertice().get(i).nome.endsWith("1")){
                            g.addAresta(g.Vertice().get(i), g.Vertice().get(i - 4));
                            g.addAresta(g.Vertice().get(i), g.Vertice().get(i - 3));
                            g.addAresta(g.Vertice().get(i), g.Vertice().get(i + 1));
                            g.addAresta(g.Vertice().get(i), g.Vertice().get(i + 4));
                        }else if(g.Vertice().get(i).nome.endsWith("2") || g.Vertice().get(i).nome.endsWith("3")){
                            g.addAresta(g.Vertice().get(i), g.Vertice().get(i - 4));
                            g.addAresta(g.Vertice().get(i), g.Vertice().get(i - 3));
                            g.addAresta(g.Vertice().get(i), g.Vertice().get(i - 1));
                            g.addAresta(g.Vertice().get(i), g.Vertice().get(i + 1));
                            g.addAresta(g.Vertice().get(i), g.Vertice().get(i + 3));
                            g.addAresta(g.Vertice().get(i), g.Vertice().get(i + 4));
                        }else if(g.Vertice().get(i).nome.endsWith("4")){
                            g.addAresta(g.Vertice().get(i), g.Vertice().get(i - 4));
                            g.addAresta(g.Vertice().get(i), g.Vertice().get(i - 1));
                            g.addAresta(g.Vertice().get(i), g.Vertice().get(i + 3));
                            g.addAresta(g.Vertice().get(i), g.Vertice().get(i + 4));
                        }
                    }else if(g.Vertice().get(i).nome.startsWith("7")) {
                        if(g.Vertice().get(i).nome.endsWith("1")){
                            g.addAresta(g.Vertice().get(i), g.Vertice().get(i - 4));
                            g.addAresta(g.Vertice().get(i), g.Vertice().get(i - 3));
                            g.addAresta(g.Vertice().get(i), g.Vertice().get(i + 1));
                        }else if(g.Vertice().get(i).nome.endsWith("2") || g.Vertice().get(i).nome.endsWith("3")){
                            g.addAresta(g.Vertice().get(i), g.Vertice().get(i - 4));
                            g.addAresta(g.Vertice().get(i), g.Vertice().get(i - 3));
                            g.addAresta(g.Vertice().get(i), g.Vertice().get(i - 1));
                            g.addAresta(g.Vertice().get(i), g.Vertice().get(i + 1));
                        }else if(g.Vertice().get(i).nome.endsWith("4")){
                            g.addAresta(g.Vertice().get(i), g.Vertice().get(i - 4));
                            g.addAresta(g.Vertice().get(i), g.Vertice().get(i - 1));
                        }
                    }
                    else if(g.Vertice().get(i).nome.startsWith("1")) {
                        if(g.Vertice().get(i).nome.endsWith("1")){
                            g.addAresta(g.Vertice().get(i), g.Vertice().get(i + 1));
                            g.addAresta(g.Vertice().get(i), g.Vertice().get(i + 4));
                        }else if(g.Vertice().get(i).nome.endsWith("2") || g.Vertice().get(i).nome.endsWith("3")){
                            g.addAresta(g.Vertice().get(i), g.Vertice().get(i - 1));
                            g.addAresta(g.Vertice().get(i), g.Vertice().get(i + 1));
                            g.addAresta(g.Vertice().get(i), g.Vertice().get(i + 3));
                            g.addAresta(g.Vertice().get(i), g.Vertice().get(i + 4));
                        }else if(g.Vertice().get(i).nome.endsWith("4")){
                            g.addAresta(g.Vertice().get(i), g.Vertice().get(i - 1));
                            g.addAresta(g.Vertice().get(i), g.Vertice().get(i + 3));
                            g.addAresta(g.Vertice().get(i), g.Vertice().get(i + 4));
                        }
                    }
                }

                System.out.println(edificio);
                System.out.println(g);
                System.out.println("\n----------------------------------------------------------\n");
                System.out.println("Quantidade de Nós negativos: " + contNegative);
                System.out.println("Linhas que ocorrem os Nós negativos: " + linhaNegative);
                System.out.println("\n----------------------------------------------------------\n");
                System.out.println("Quantidade de Nós duplicados: " + contRepeted);
                System.out.println("Linhas que ocorrem os Nós duplicados: " + linhaRepeted);
                System.out.println("\n----------------------------------------------------------\n");
                System.out.println("Processo concluído!");

                PrintStream ps = new PrintStream("Grafo-Edificio-Planalto.txt");
                ps.println(edificio);
                ps.println(g);
                ps.println("Quantidade de Nós negativos: " + contNegative);
                ps.println("Linhas que ocorrem os Nós negativos: " + linhaNegative);
                ps.println();
                ps.println("Quantidade de Nós duplicados: " + contRepeted);
                ps.println("Linhas que ocorrem os Nós duplicados: " + linhaRepeted);
                ps.println();
                ps.println("Processo conluído!");
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}