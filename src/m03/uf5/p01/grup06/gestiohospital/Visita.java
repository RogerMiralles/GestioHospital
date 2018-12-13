/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package m03.uf5.p01.grup06.gestiohospital;

import java.time.LocalDateTime;

/**
 *
 * @author Aleix
 */
public class Visita {

    private final LocalDateTime data;
    private final Malaltia malaltia;
    private final Metge metge;

    public Visita(LocalDateTime data, Malaltia malaltia, Metge metge) {

        this.data = data;
        this.malaltia = malaltia;
        this.metge = metge;

    }

    public LocalDateTime getData() {
        return data;
    }

    public Malaltia getMalaltia() {
        return malaltia;
    }

    public Metge getMetge() {
        return metge;
    }
}
