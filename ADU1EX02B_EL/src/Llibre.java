public class Llibre {
    private String titol;
    private String autor;
    private double preu;
    private String resum;

    public Llibre(String titol, String autor, double preu, String resum) {
        this.titol = titol;
        this.autor = autor;
        this.preu = preu;
        this.resum = resum;
    }

    @Override
    public String toString() {
        return "Títol: " + titol + ", Autor: " + autor + ", Preu: " + preu + ", Resum: " + resum;
    }

    public String getTitol() {
        return titol;
    }
    public void setTitol(String titol) {
        this.titol = titol;
    }
    public String getAutor() {
        return autor;
    }
    public void setAutor(String autor) {
        this.autor = autor;
    }
    public double getPreu() {
        return preu;
    }
    public void setPreu(double preu) {
        this.preu = preu;
    }
    public String getResum() {
        return resum;
    }
    public void setResum(String resum) {
        this.resum = resum;
    }
}
