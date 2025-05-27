import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Documento {
    private String nomeArquivo;
    private String nome;
    private LocalDateTime tempo;

    
    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("HH:mm");

    public Documento(String nomeArquivo, String nome) {
        this.nomeArquivo = nomeArquivo;
        this.nome = nome;
        this.tempo = LocalDateTime.now(); 
    }

    public String getNomeArquivo() {
        return nomeArquivo;
    }

    public String getNome() {
        return nome;
    }

    public String getTempoFormatado() {
        return tempo.format(FORMATTER); 
    }

    @Override
    public String toString() {
        return "Documento [Arquivo = " + nomeArquivo + ", nome = " + nome + ", solicitação às " + getTempoFormatado() + "]";
    }
}
