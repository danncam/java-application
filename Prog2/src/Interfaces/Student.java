package Interfaces;

public class Student implements Comparable {

    private String nome;
    private float nota;

    public Student(String nome, float nota) {
        this.nome = nome;
        this.nota = nota;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setNota(float nota) {
        this.nota = nota;
    }

    public String getNome() {
        return nome;
    }

    public float getNota() {
        return nota;
    }

    @Override
    public int compareTo(Comparable c) {
        Student a = (Student) c;

        if (((int) a.nota == this.nota) /*&& (this.nome.compareTo(a.nome)) == 0*/) {
            return 0;
        } else if (a.nota > this.nota) {
            return -1;
        } else {
            return 1;

        }
    }

    @Override
    public void print() {
        System.out.println("Nome: "+getNome() + "\nNota: "+getNota());
    }

    @Override
    public boolean isEqual(Comparable c) {
        Student a = (Student) c;
        return (((int) a.nota == this.nota) && (this.nome.compareTo(a.nome)) == 0);
    }
}
