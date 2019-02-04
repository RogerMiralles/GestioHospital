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
        return "<html><h3>Datos Medico</h3> \n___________________ "
                + "\nNIF: " + this.getNif() 
                + "\nNombre: " + this.getNom() 
                + "\nApellidos: " + this.getCognom1() + " "+ this.getCognom2() 
                + "\nTelefono: " + this.getTelefon()
                + "\nNumero Seguridad Social: " + this.getNumSegSocial()
                + "\nDirección: " + this.getAdreca().toString()
                + "\nNumero empleado: " + this.numEmpleat 
                + "\nSueldo mensual: " + this.salariMensual
                + "\nCodigo cuenta corriente: " + this.codiCompteCorrent+"</html";
    }
    
    
    public String FormatCSVMetge(){
       return this.getNom()+","+this.getCognom1()+","+this.getCognom2() +","
               +this.getNumSegSocial()+","+this.getNif()+","+this.getTelefon()+
               ","+this.getAdreca().FormCSVAdreca()+","+numEmpleat+","+salariMensual+
               ","+codiCompteCorrent;
    }
}
