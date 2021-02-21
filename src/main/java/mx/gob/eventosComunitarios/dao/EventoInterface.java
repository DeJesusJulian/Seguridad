package mx.gob.eventosComunitarios.dao;

import java.util.List;

import mx.gob.eventosComunitarios.entity.Evento;

public interface EventoInterface {
	public boolean save(Evento event);
	
	public boolean update(Evento event);
	
	public void delete(long id);
	
	public List<Evento> findAll();
	
	public Evento findOne(long id);
}
