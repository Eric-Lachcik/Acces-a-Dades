public class Llibre {
    private String titol;
    private String autor;
    private Integer any;
    private String resum;

    public Llibre(String titol, String autor, Integer any, String resum) {
        this.titol = titol;
        this.autor = autor;
        this.any = any;
        this.resum = resum;
    }

    @Override
    public String toString() {
        return "Títol: " + titol + ", Autor: " + autor + ", Any: " + any + ", Resum: " + resum;
    }

    public String getTitol() {
        return titol;
    }

    public String getAutor() {
        return autor;
    }

    public Integer getany() {
        return any;
    }

    public String getResum() {
        return resum;
    }
}

