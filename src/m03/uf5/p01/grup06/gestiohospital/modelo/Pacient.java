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
        return "<html><h3>Datos Paciente: </h3> \n___________________" 
                + "\nNombre: " + this.getNom() 
                + "\nApellidos: " + this.getCognom1() + " " + this.getCognom2()
                + "\nNumero de SS: " + this.getNumSegSocial()
                + "\nDNI: " + this.getNif()
                + "\nTelefono: " + this.getTelefon()
                + "\nDirección: " + this.getAdreca().toString() + "</html>";
    }
    
    public Historial getHistorial() {
        return this.historial;
    }
}
