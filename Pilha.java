import java.lang.RuntimeException;

public class Pilha{
    private int topo;
    private Documento[] dados;
    public Pilha(){
        this(3);
    }

    public Pilha(int capacidade){
        topo = 0;
        dados = new Documento[capacidade];
    }

    public boolean pilhaVazia(){
        return topo == 0;
    }

    public boolean pilhaCheia(){
        return topo == dados.length;
    }

    public boolean push(Documento elemento){
        if (pilhaCheia()) return false;
        dados[topo++] = elemento;
        return true;
    }

    public Documento pop(){
        if (pilhaVazia()) return null;
        return dados[--topo];
    }

    public Documento mostraElemento(){
        if (pilhaVazia()) return null;
        return dados[topo-1];
    }

    public int mostrarPosicao(String documento){
        if (pilhaVazia()){
            throw new RuntimeException("pilha vazia");
        }
        for (int i = topo; i >= 0; i--) {
            if (dados[i] != null && dados[i].getNomeArquivo().equals(documento)) {
                return topo - i;
        }
    }
    return -1;
    }

    @Override
    public String toString(){
        if(pilhaVazia()) return "pilha vazia";
        String s = " ";
        for(int i = topo -1; i>=0; i--)
        {
            s += dados[i] + "";
        }
        return s;
    }
}