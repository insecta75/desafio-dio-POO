package br.com.dio.projeto.dominio;
import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;

public class Dev {
    private String nome;
    private Set<Conteudo> conteudosInscritos = new LinkedHashSet<>();//Polimorfismo;
    private Set<Conteudo> conteudosConcluidos = new LinkedHashSet<>();

    public void inscreverBootcamp (Bootcamp bootcamp) {
        this.conteudosInscritos.addAll(bootcamp.getConteudos());//Adiciona os conteudos do Bootcamp para o Dev fazer;
        bootcamp.getDevsInscritos().add(this);//Adiciona o Dev no Bootcamp;
    }
    /*Optional: objetivo de simplificar os códigos, ajudando evitar os erros NullPointerException
    e tirando a necessidade da verificacao (if x != null);
     */
    public void progredir() {
        Optional<Conteudo> conteudo = this.conteudosInscritos.stream().findFirst();
        if(conteudo.isPresent()) {
            this.conteudosConcluidos.add(conteudo.get());
            this.conteudosInscritos.remove(conteudo.get());
        } else {
            System.err.println("Voce nao esta matriculado em nenhum conteudo!");
        }
    }
    public double calcularTotalXp() {
        return this.conteudosConcluidos
                .stream()
                //.mapToDouble(conteudo -> conteudo.calcularXp())//Calcula o XP de cada conteudo;
                .mapToDouble(Conteudo::calcularXp)
                .sum();//Faz a soma do XP total;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public Set<Conteudo> getConteudosInscritos() {
        return conteudosInscritos;
    }
    public void setConteudosInscritos(Set<Conteudo> conteudosInscritos) {
        this.conteudosInscritos = conteudosInscritos;
    }
    public Set<Conteudo> getConteudosConcluidos() {
        return conteudosConcluidos;
    }
    public void setConteudosConcluidos(Set<Conteudo> conteudosConcluidos) {
        this.conteudosConcluidos = conteudosConcluidos;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Dev dev = (Dev) o;
        return Objects.equals(nome, dev.nome) && Objects.equals(conteudosInscritos, dev.conteudosInscritos) && Objects.equals(conteudosConcluidos, dev.conteudosConcluidos);
    }
    @Override
    public int hashCode() {
        return Objects.hash(nome, conteudosInscritos, conteudosConcluidos);
    }
}