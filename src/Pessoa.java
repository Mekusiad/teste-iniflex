import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

// 1 -
public class Pessoa {
    protected String nome;
    protected LocalDate dataNascimento;

    public  Pessoa(String nome, LocalDate dataNascimento){
        this.nome = nome;
        this.dataNascimento = dataNascimento;
    }

    public String getNome(){
        return nome;
    }

    public LocalDate getDataNascimento (){
        return dataNascimento;
    }

    public String getDataNascimentoFormatada(){
        return dataNascimento.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
    }
}
