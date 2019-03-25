package m03.uf5.p01.grup06.gestiohospital.modelo;

public class Metge extends Persona {

    private final int numEmpleat;
    private final int salariMensual;
    private final String codiCompteCorrent;

    public Metge(String nom, String cognom1, String cognom2, String numSegSocial,
            String nif, String telefon, Adreca Adreca, int numEmpleat, int salariMensual, String codiCompteCorrent) {
        super(nom, cognom1, cognom2, numSegSocial, nif, telefon, Adreca);
        this.numEmpleat = numEmpleat;
        this.salariMensual = salariMensual;
        this.codiCompteCorrent = codiCompteCorrent;
    }

    @Override
    public String toString() {
        return "<html><h2>Datos Medico</h2>"
                + "<ul>"
                + "<li>NIF: " + this.getNif()+"</li>" 
                + "<li>Nombre: " + this.getNom()+"</li>"  
                + "<li>Apellidos: " + this.getCognom1() + " "+ this.getCognom2()+"</li>"  
                + "<li>Telefono: " + this.getTelefon()+"</li>" 
                + "<li>Numero Seguridad Social: " + this.getNumSegSocial()+"</li>" 
                + "<li>Dirección: " + this.getAdreca().toString()+"</li>" 
                + "<li>Numero empleado: " + this.numEmpleat+"</li>"  
                + "<li>Sueldo mensual: " + this.salariMensual+"</li>" 
                + "<li>Codigo cuenta corriente: " + this.codiCompteCorrent+"</li>"
                + "</ul></html>";
    }
    
    
    public String FormatCSVMetge(){
       return this.getNom()+","+this.getCognom1()+","+this.getCognom2() +","
               +this.getNumSegSocial()+","+this.getNif()+","+this.getTelefon()+
               ","+this.getAdreca().FormCSVAdreca()+","+numEmpleat+","+salariMensual+
               ","+codiCompteCorrent;
    }

    public int getNumEmpleat() {
        return numEmpleat;
    }

    public int getSalariMensual() {
        return salariMensual;
    }

    public String getCodiCompteCorrent() {
        return codiCompteCorrent;
    }
}
