import br.com.dio.projeto.dominio.*;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        Curso cursoUm = new Curso();//Abstracao;
        Curso cursoDois = new Curso();
        Conteudo cursoTres = new Curso();//Polimorfismo;
        Mentoria mentoriaUm = new Mentoria();

        cursoUm.setTitulo("Java");
        cursoUm.setDescricao("Curso OO em Java");
        cursoUm.setCargaHoraria(8);
        cursoDois.setTitulo("Python");
        cursoDois.setDescricao("Curso de Machine Learning");
        cursoDois.setCargaHoraria(16);

        mentoriaUm.setTitulo("Mentoria em JS");
        mentoriaUm.setDescricao("Mentoria de nivel basico em JS");
        mentoriaUm.setData(LocalDate.now());
        /*
        System.out.println(cursoUm);
        System.out.println(cursoDois);
        System.out.println(mentoriaUm);*/
        Bootcamp bootcamp = new Bootcamp();
        bootcamp.setNome("Bootcamp Java Developer");
        bootcamp.setDescricao("Descricao Bootcamp Java Developer");
        bootcamp.getConteudos().add(cursoUm);
        bootcamp.getConteudos().add(cursoDois);
        bootcamp.getConteudos().add(mentoriaUm);

        Dev devWanessa = new Dev();
        devWanessa.setNome("Wanessa");
        devWanessa.inscreverBootcamp(bootcamp);
        System.out.println("Conteudos Inscritos de Wanessa: "+devWanessa.getConteudosInscritos());
        devWanessa.progredir();
        devWanessa.progredir();
        System.out.println("###");
        System.out.println("Conteudos Inscritos de Wanessa: "+devWanessa.getConteudosInscritos());
        System.out.println("Conteudos Concluidos de Wanessa: "+devWanessa.getConteudosConcluidos());
        System.out.println("XP: "+devWanessa.calcularTotalXp());

        System.out.println("##########");

        Dev devAdriana = new Dev();
        devAdriana.setNome("Adriana");
        devAdriana.inscreverBootcamp(bootcamp);
        System.out.println("Conteudos Inscritos de Adriana: "+devAdriana.getConteudosInscritos());
        devAdriana.progredir();
        devAdriana.progredir();
        devAdriana.progredir();
        System.out.println("###");
        System.out.println("Conteudos Inscritos de Adriana: "+devAdriana.getConteudosInscritos());
        System.out.println("Conteudos Concluidos de Adriana: "+devAdriana.getConteudosConcluidos());
        System.out.println("XP: "+devAdriana.calcularTotalXp());
    }
}