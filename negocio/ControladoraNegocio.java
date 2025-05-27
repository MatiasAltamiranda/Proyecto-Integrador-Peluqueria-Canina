package com.mycompany.agendapeluqueriacanina.negocio;

import com.mycompany.agendapeluqueriacanina.persistencia.ControladoraPersistencia;
import java.util.HashSet;
import java.util.List;

public class ControladoraNegocio {

    ControladoraPersistencia controlPersis = new ControladoraPersistencia();

    public void guardar(String nombreMasco, String raza, String color, String observaciones, String alergico, String atEsp, String nombreDuenio, String celDuenio) {

        Duenio duenio = new Duenio();
        duenio.setNombre(nombreDuenio);
        duenio.setCelDuenio(celDuenio);

        Mascota mascota = new Mascota();
        mascota.setNombre(nombreMasco);
        mascota.setColor(color);
        mascota.setRaza(raza);
        mascota.setAlergico(alergico);
        mascota.setAtencion_especial(atEsp);
        mascota.setObservaciones(observaciones);
        mascota.setUnDuenio(duenio);

        controlPersis.guardar(duenio, mascota);

    }

    public List<Mascota> traerMascotas() {

        return controlPersis.traerMascotas();

    }

    public void borrarMascota(int num_cliente) {
        controlPersis.borrarMascota(num_cliente);
    }

    public Mascota traerMascota(int num_cliente) {
        return controlPersis.traerMascota(num_cliente);

    }

    public void editarMascota(Mascota masco, String nombreMasco, String raza, String color, String observaciones, String alergico, String atEsp, String nombreDuenio, String celDuenio) {
        masco.setNombre(nombreMasco);
        masco.setRaza(raza);
        masco.setColor(color);
        masco.setObservaciones(observaciones);
        masco.setAtencion_especial(atEsp);
        masco.setAlergico(alergico);

        controlPersis.editarMascota(masco);

        Duenio due = this.buscarDuenio(masco.getUnDuenio().getId_duenio());
        due.setCelDuenio(celDuenio);
        due.setNombre(nombreDuenio);

        this.editarDuenio(due);

    }

    private Duenio buscarDuenio(int id_duenio) {
        return controlPersis.buscarDuenio(id_duenio);
    }

    private void editarDuenio(Duenio due) {
        controlPersis.editarDuenio(due);
    }

}
