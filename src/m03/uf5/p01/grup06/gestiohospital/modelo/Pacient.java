package m03.uf5.p01.grup06.gestiohospital.modelo;

public class Pacient extends Persona {

    private final Historial historial;

    public Pacient(String nom, String cognom1, String cognom2, String numSegSocial, 
            String nif, String telefon, Adreca adreca) {
        super(nom, cognom1, cognom2, numSegSocial, nif, telefon, adreca);
        historial = new Historial(this);
    }

    @Override
    public String toString() {
        return "<html><h3>Datos Paciente: </h3>"
                + "<ul>" 
                + "<li>Nombre: " + this.getNom()+"</li>" 
                + "<li>Apellidos: " + this.getCognom1() + " " + this.getCognom2()+"</li>" 
                + "<li>Numero de SS: " + this.getNumSegSocial()+"</li>" 
                + "<li>DNI: " + this.getNif()+"</li>" 
                + "<li>Telefono: " + this.getTelefon()+"</li>" 
                + "<li>Dirección: " + this.getAdreca().toString() + "</li>"
                + "</ul></html>";
    }
    
    public Historial getHistorial() {
        return this.historial;
    }
}
