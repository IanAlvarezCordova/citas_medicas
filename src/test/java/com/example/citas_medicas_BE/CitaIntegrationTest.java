package com.example.citas_medicas_BE;

import com.example.citas_medicas_BE.modelos.Cita;
import com.example.citas_medicas_BE.modelos.Consultorio;
import com.example.citas_medicas_BE.modelos.Medico;
import com.example.citas_medicas_BE.modelos.Paciente;
import com.example.citas_medicas_BE.servicios.CitaServicio;
import com.example.citas_medicas_BE.servicios.ConsultorioServicio;
import com.example.citas_medicas_BE.servicios.MedicoServicio;
import com.example.citas_medicas_BE.servicios.PacienteServicio;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.time.LocalTime;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class CitaIntegrationTest {

	@Autowired
	private CitaServicio citaServicio;

	@Autowired
	private PacienteServicio pacienteServicio;

	@Autowired
	private MedicoServicio medicoServicio;

	@Autowired
	private ConsultorioServicio consultorioServicio;

	@Test
	public void testCrearCitaConRelaciones() {
		// Crear datos de prueba
		Paciente paciente = new Paciente("Test", "Paciente", LocalDate.of(1990, 1, 1), "test@example.com");
		Paciente pacienteGuardado = pacienteServicio.guardar(paciente);

		Medico medico = new Medico("Test", "Medico", "Cardiología");
		Medico medicoGuardado = medicoServicio.guardar(medico);

		Consultorio consultorio = new Consultorio("A1", 1);
		Consultorio consultorioGuardado = consultorioServicio.guardar(consultorio);

		// Crear cita
		Cita cita = new Cita(pacienteGuardado, medicoGuardado, consultorioGuardado, LocalDate.now(), LocalTime.of(14, 0));
		Cita citaGuardada = citaServicio.guardar(cita);

		// Verificar
		assertNotNull(citaGuardada);
		assertEquals(pacienteGuardado.getId(), citaGuardada.getPaciente().getId());
		assertEquals(medicoGuardado.getId(), citaGuardada.getMedico().getId());
		assertEquals(consultorioGuardado.getId(), citaGuardada.getConsultorio().getId());
	}

	@Test
	public void testObtenerCitaPorId() {
		// Crear datos de prueba
		Paciente paciente = new Paciente("Test2", "Paciente2", LocalDate.of(1995, 2, 2), "test2@example.com");
		Paciente pacienteGuardado = pacienteServicio.guardar(paciente);

		Medico medico = new Medico("Test2", "Medico2", "Neurología");
		Medico medicoGuardado = medicoServicio.guardar(medico);

		Consultorio consultorio = new Consultorio("B2", 2);
		Consultorio consultorioGuardado = consultorioServicio.guardar(consultorio);

		Cita cita = new Cita(pacienteGuardado, medicoGuardado, consultorioGuardado, LocalDate.now(), LocalTime.of(15, 0));
		Cita citaGuardada = citaServicio.guardar(cita);

		// Obtener y verificar
		Cita citaObtenida = citaServicio.obtenerPorId(citaGuardada.getId());
		assertNotNull(citaObtenida);
		assertEquals(citaGuardada.getId(), citaObtenida.getId());
	}
}
