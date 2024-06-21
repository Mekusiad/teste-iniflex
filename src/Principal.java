import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.*;
import java.util.stream.Collectors;

// 3-
public class Principal {
    public static void main(String[] args) {
        // 3.1 Inserir todos os funcionarios
        List<Funcionario> funcionarios = new ArrayList<>();
        funcionarios.add(new Funcionario("Maria", LocalDate.of(2000, 10, 18), new BigDecimal(2009.44),"Operador"));
        funcionarios.add(new Funcionario("Joao", LocalDate.of(1990, 05, 12), new BigDecimal(2284.38),"Operador"));
        funcionarios.add(new Funcionario("Caio", LocalDate.of(1961, 05, 5), new BigDecimal(9836.14),"Coordenador"));
        funcionarios.add(new Funcionario("Miguel", LocalDate.of(1988, 10, 14), new BigDecimal(19119.88),"Diretor"));
        funcionarios.add(new Funcionario("Alice", LocalDate.of(1995, 01, 5), new BigDecimal(2234.68),"Recepcionista"));
        funcionarios.add(new Funcionario("Heitor", LocalDate.of(1999, 11, 19), new BigDecimal(1582.72),"Operador"));
        funcionarios.add(new Funcionario("Arthur", LocalDate.of(1993, 03, 31), new BigDecimal(4071.84),"Contador"));
        funcionarios.add(new Funcionario("Laura", LocalDate.of(1994, 07, 8), new BigDecimal(3017.45),"Gerente"));
        funcionarios.add(new Funcionario("Heloisa", LocalDate.of(2003, 05, 24), new BigDecimal(1606.85),"Eletricista"));
        funcionarios.add(new Funcionario("Helena", LocalDate.of(1996, 9, 2), new BigDecimal(2799.93),"Gerente"));
            
                
                // 3.2  Remover o funcionario “Joao” da lista.
                    funcionarios.removeIf(funcionario -> funcionario.getNome().equals("Joao"));
                
                
                // 3.3 - Imprimir todos os funcionarios com suas informacões formatadas
                    System.out.println("3.1 e 3.3- Funcionarios: \n");
        
                    funcionarios.forEach(funcionario -> {
                        System.out.printf("Nome: %s | Data de nascimento: %s | Salario: %s | Funcao: %s%n",
                        funcionario.getNome(),
                        funcionario.getDataNascimentoFormatada(),
                        funcionario.getSalarioFormatado(),
                        funcionario.getFuncao());
                    });
        
                // 3.4 - Os funcionarios receberam 10% de aumento de salario, atualizar a lista de funcionarios com novo valor.
                    funcionarios.forEach(funcionario-> funcionario.aumentarSalario(new BigDecimal(10)));
        
                // 3.5 - Agrupar os funcionarios por funcao em um MAP, sendo a chave a “funcao” e o valor a “lista de funcionarios”.
                    Map<String, List<Funcionario>> funcionariosPorFuncao = funcionarios.stream()
                    .collect(Collectors.groupingBy(Funcionario::getFuncao));
        
                // 3.6 – Imprimir os funcionarios, agrupados por funcao.
                     System.out.println("\n3.5 e 3.6- Funcionarios agrupagos por funcao:");
                     funcionariosPorFuncao.forEach((funcao,lista) -> {
                        System.out.printf("%n%s:%n%n", funcao);
                        lista.forEach(funcionario -> {
                            System.out.printf("Nome: %s | Data de nascimento: %s | Salario: %s%n",
                            funcionario.getNome(),
                            funcionario.getDataNascimentoFormatada(),
                            funcionario.getSalarioFormatado());
                        });
                     });
        
                //3.8 – Imprimir os funcionarios que fazem aniversario no mes 10 e 12.
                System.out.println("\n3.8- Funcionarios que fazem aniversario  no mes 10 e 12: \n");
                funcionarios.stream()
                .filter(funcionario ->{
                    int mesAniversario = funcionario.getDataNascimento().getMonthValue();
        
                    return mesAniversario == 10 || mesAniversario == 12;
                })
                .forEach(funcionario ->{
                    System.out.printf("Nome: %s | Data de nascimento: %s%n",
                    funcionario.getNome(),
                    funcionario.getDataNascimentoFormatada());
                });
        
                //3.9 – Imprimir o funcionario com a maior idade, exibir os atributos: nome e idade.
                Funcionario funcionarioMaisVelho = funcionarios.stream()
                .min(Comparator.comparing(Funcionario::getDataNascimento))
                .orElse(null);
                
                long idade = ChronoUnit.YEARS.between(funcionarioMaisVelho.getDataNascimento(), LocalDate.now());
        
                System.out.printf("%n %n3.9- O funcionario %s tem a maior idade, no momento possui %s anos\n", funcionarioMaisVelho.getNome(),idade);
            
                //3.10 – Imprimir a lista de funcionarios por ordem alfabetica.
                System.out.println("\n3.10- Lista de funcionarios em ordem alfabetica: \n");
        
                funcionarios.stream()
                .sorted(Comparator.comparing(Pessoa::getNome))
                .forEach(System.out::println);
        
                //3.11 – Imprimir o total dos salarios dos funcionarios.
                BigDecimal totalSalarios = funcionarios.stream()
                .map(Funcionario::getSalario)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
        
                System.out.println("\n3.11- A soma total dos salarios dos funcionarios e: " + totalSalarios.setScale(2,RoundingMode.HALF_UP).toString().replace(".", ","));
        
                
                 //3.12 – Imprimir quantos salarios minimos ganha cada funcionario, considerando que o salario minimo e R.00.
                 BigDecimal salarioMinimo = new BigDecimal("1212.00");
                 System.out.println("\n3.12- Quantidade de salarios minimo por funcionario: ");
                 funcionarios.forEach(funcionario->{
                    BigDecimal quatidadeSalarioMinimo = funcionario.getSalario().divide(salarioMinimo,2,RoundingMode.HALF_UP);
                    System.out.println( funcionario.getNome() + " recebe "+ quatidadeSalarioMinimo  +" Salarios minimos.");
         });
    }



   
}



