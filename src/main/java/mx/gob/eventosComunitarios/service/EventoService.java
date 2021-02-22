package mx.gob.eventosComunitarios.service;

import java.text.SimpleDateFormat;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import mx.gob.eventosComunitarios.dao.EventoInterface;
import mx.gob.eventosComunitarios.entity.Evento;

public class EventoService implements EventoInterface{

	private JdbcTemplate jdbcTemplate;
	String sql;

	public EventoService(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}


	public boolean save(Evento event) {
		boolean vuelta = false;
		
		try {

			if (event.getNombreCliente().length() > 3 && event.getApellidoCliente().length() > 3
					&& event.getTitulo().length() > 3 && event.getDescripcion().length() > 3
					&& event.getEmailCliente().length() > 3 && event.getTelefono().length() > 3
					&& event.getFechaInicio().length() > 3 && event.getFechaFin().length() > 3F) {

				char anio1 = event.getFechaInicio().charAt(0);
				char anio2 = event.getFechaInicio().charAt(1);
				char anio3 = event.getFechaInicio().charAt(2);
				char anio4 = event.getFechaInicio().charAt(3);

				char mes1 = event.getFechaInicio().charAt(5);
				char mes2 = event.getFechaInicio().charAt(6);

				char dia1 = event.getFechaInicio().charAt(8);
				char dia2 = event.getFechaInicio().charAt(9);

				String diainicio = dia1 + "" + dia2;
				String mesinicio = mes1 + "" + mes2;
				String anioinicio = anio1 + "" + anio2 + "" + anio3 + "" + anio4;

				int dia = Integer.parseInt(diainicio);
				int mes = Integer.parseInt(mesinicio);
				int anio = Integer.parseInt(anioinicio);

				char anioF1 = event.getFechaFin().charAt(0);
				char anioF2 = event.getFechaFin().charAt(1);
				char anioF3 = event.getFechaFin().charAt(2);
				char anioF4 = event.getFechaFin().charAt(3);

				char mesF1 = event.getFechaFin().charAt(5);
				char mesF2 = event.getFechaFin().charAt(6);

				char diaF1 = event.getFechaFin().charAt(8);
				char diaF2 = event.getFechaFin().charAt(9);

				String diaFin = diaF1 + "" + diaF2;
				String mesFin = mesF1 + "" + mesF2;
				String anioFin = anioF1 + "" + anioF2 + "" + anioF3 + "" + anioF4;

				int diaF = Integer.parseInt(diaFin);
				int mesF = Integer.parseInt(mesFin);
				int anioF = Integer.parseInt(anioFin);

				if (anio == anioF) {

					if (mes <= mesF) {
						if (dia < diaF) {

							event.setFechaInicio(anio + "/" + mes + "/" + dia);
							event.setFechaFin(anioF + "/" + mesF + "/" + diaF);
							sql = "INSERT INTO evento(titulo, descripcion, nombreCliente, apellidoCliente, emailCliente, telefono, fechaInicio, fechaFin, lugar) values(?, ?, ?, ?, ?, ?, ?, ?, ?)";
							jdbcTemplate.update(sql, event.getTitulo(), event.getDescripcion(),
									event.getNombreCliente(), event.getApellidoCliente(), event.getEmailCliente(),
									event.getTelefono(), event.getFechaInicio(), event.getFechaFin(), event.getLugar());

							vuelta = true;
						}
					}

				} else if (anio < anioF) {
					if (mes > mesF) {

						event.setFechaInicio(anio + "/" + mes + "/" + dia);
						event.setFechaFin(anioF + "/" + mesF + "/" + diaF);
						sql = "INSERT INTO evento(titulo, descripcion, nombreCliente, apellidoCliente, emailCliente, telefono, fechaInicio, fechaFin, lugar) values(?, ?, ?, ?, ?, ?, ?, ?, ?)";
						jdbcTemplate.update(sql, event.getTitulo(), event.getDescripcion(), event.getNombreCliente(),
								event.getApellidoCliente(), event.getEmailCliente(), event.getTelefono(),
								event.getFechaInicio(), event.getFechaFin(), event.getLugar());

						vuelta = true;
					}
				}

			} else {

			}

		} catch (Exception e) {
			System.out.println("error fechas " + e);
		}

		// TODO Auto-generated method stub
		return vuelta;
	}


	public boolean update(Evento event) {
		boolean vuelta = false;

		try {

			if (event.getNombreCliente().length() > 3 && event.getApellidoCliente().length() > 3
					&& event.getTitulo().length() > 3 && event.getDescripcion().length() > 3
					&& event.getEmailCliente().length() > 3 && event.getTelefono().length() > 3
					&& event.getFechaInicio().length() > 3 && event.getFechaFin().length() > 3F) {

				char anio1 = event.getFechaInicio().charAt(0);
				char anio2 = event.getFechaInicio().charAt(1);
				char anio3 = event.getFechaInicio().charAt(2);
				char anio4 = event.getFechaInicio().charAt(3);

				char mes1 = event.getFechaInicio().charAt(5);
				char mes2 = event.getFechaInicio().charAt(6);

				char dia1 = event.getFechaInicio().charAt(8);
				char dia2 = event.getFechaInicio().charAt(9);

				String diainicio = dia1 + "" + dia2;
				String mesinicio = mes1 + "" + mes2;
				String anioinicio = anio1 + "" + anio2 + "" + anio3 + "" + anio4;

				int dia = Integer.parseInt(diainicio);
				int mes = Integer.parseInt(mesinicio);
				int anio = Integer.parseInt(anioinicio);

				char anioF1 = event.getFechaFin().charAt(0);
				char anioF2 = event.getFechaFin().charAt(1);
				char anioF3 = event.getFechaFin().charAt(2);
				char anioF4 = event.getFechaFin().charAt(3);

				char mesF1 = event.getFechaFin().charAt(5);
				char mesF2 = event.getFechaFin().charAt(6);

				char diaF1 = event.getFechaFin().charAt(8);
				char diaF2 = event.getFechaFin().charAt(9);

				String diaFin = diaF1 + "" + diaF2;
				String mesFin = mesF1 + "" + mesF2;
				String anioFin = anioF1 + "" + anioF2 + "" + anioF3 + "" + anioF4;

				int diaF = Integer.parseInt(diaFin);
				int mesF = Integer.parseInt(mesFin);
				int anioF = Integer.parseInt(anioFin);

				if (anio == anioF) {

					if (mes <= mesF) {
						if (dia < diaF) {

							event.setFechaInicio(anio + "/" + mes + "/" + dia);
							event.setFechaFin(anioF + "/" + mesF + "/" + diaF);
							sql = "UPDATE evento SET titulo = ?, descripcion = ?, nombreCliente = ?, apellidoCliente = ?, emailCliente = ?, telefono = ?, fechaInicio = ?, fechaFin = ?, lugar = ? WHERE idEvento = ?";
							jdbcTemplate.update(sql, event.getTitulo(), event.getDescripcion(),
									event.getNombreCliente(), event.getApellidoCliente(), event.getEmailCliente(),
									event.getTelefono(), event.getFechaInicio(), event.getFechaFin(), event.getLugar(),
									event.getIdEvento());

							vuelta = true;
						}
					}

				} else if (anio < anioF) {
					if (mes > mesF) {

						event.setFechaInicio(anio + "/" + mes + "/" + dia);
						event.setFechaFin(anioF + "/" + mesF + "/" + diaF);
						sql = "UPDATE evento SET titulo = ?, descripcion = ?, nombreCliente = ?, apellidoCliente = ?, emailCliente = ?, telefono = ?, fechaInicio = ?, fechaFin = ?, lugar = ? WHERE idEvento = ?";
						jdbcTemplate.update(sql, event.getTitulo(), event.getDescripcion(), event.getNombreCliente(),
								event.getApellidoCliente(), event.getEmailCliente(), event.getTelefono(),
								event.getFechaInicio(), event.getFechaFin(), event.getLugar(), event.getIdEvento());

						vuelta = true;
					}
				}

			} else {

			}

		} catch (Exception e) {
			System.out.println("error fechas " + e);
		}

		return vuelta;
	}


	public void delete(long id) {
		// TODO Auto-generated method stub
		sql = "DELETE FROM evento WHERE idEvento = ?";
		jdbcTemplate.update(sql, id);
	}


	public List<Evento> findAll() {
		// TODO Auto-generated method stub
		sql = "SELECT * FROM evento";
		return this.jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(Evento.class));
	}


	public Evento findOne(long id) {
		// TODO Auto-generated method stub
		sql = "SELECT * FROM evento WHERE idEvento = ?";
		return this.jdbcTemplate.queryForObject(sql, new Object[] { id },
				BeanPropertyRowMapper.newInstance(Evento.class));
	}

}
