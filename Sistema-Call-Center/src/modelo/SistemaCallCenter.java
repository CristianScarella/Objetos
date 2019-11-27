package modelo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class SistemaCallCenter {

	private List<Llamada> lstLlamadas;
	private List<Persona> lstPersonas;
	public SistemaCallCenter() {
		super();
		this.lstLlamadas = new ArrayList<Llamada>();
		this.lstPersonas = new ArrayList<Persona>();
	}
	public List<Llamada> getLstLlamadas() {
		return lstLlamadas;
	}
	public void setLstLlamadas(List<Llamada> lstLlamadas) {
		this.lstLlamadas = lstLlamadas;
	}
	public List<Persona> getLstPersonas() {
		return lstPersonas;
	}
	public void setLstPersonas(List<Persona> lstPersonas) {
		this.lstPersonas = lstPersonas;
	}
	
	public Persona traerPersona(long dni) {
		Iterator<Persona>it=lstPersonas.iterator();
		Persona persona=null;
		Persona personaDev=null;
		int valor=0;
		while(it.hasNext()&&valor==0) {
			persona=it.next();
			if(persona.getDni()==dni) {
				personaDev=persona;
				valor=1;
			}
		}
		return personaDev;
	}
	
	public boolean agregarCliente(String nombre,String apellido,long dni,boolean activo) {
		Persona persona=this.traerPersona(dni);
		boolean resultado=true;
		int idPersona=1;
		
		if(persona!=null) {
			resultado=false;
		}else {
			if(!lstPersonas.isEmpty()) {
				idPersona=lstPersonas.get(lstPersonas.size()-1).getIdPersona()+1;
			}
			lstPersonas.add(new Cliente(idPersona, nombre, apellido, dni, activo));
		}
		return resultado;
	}
	
	public boolean agregarEmpleado(String nombre, String apellido,long dni,int sueldoBase) {
		Persona persona=this.traerPersona(dni);
		boolean resultado=true;
		int idPersona=1;
		
		if(persona!=null) {
			resultado=false;
		}else {
			if(!lstPersonas.isEmpty()) {
				idPersona=lstPersonas.get(lstPersonas.size()-1).getIdPersona()+1;
			}
			lstPersonas.add(new Empleado(idPersona, nombre, apellido, dni, sueldoBase));
		}
		return resultado;
	}
	
	public boolean agregarLlamada(LocalDate fecha,Cliente cliente,Empleado empleado,int nivelDeSatisfaccion) {
		int idLlamada=1;
		if(!lstLlamadas.isEmpty()) {
			idLlamada=lstLlamadas.get(lstLlamadas.size()-1).getIdLlamada()+1;
		}
		return lstLlamadas.add(new Llamada(idLlamada, cliente, empleado, fecha, nivelDeSatisfaccion));
	}
	
	public List<Persona> traerPersonas() {
		return getLstPersonas();
	}
	
	public List<Cliente> traerClientes(){
		List<Persona>lista=null;
		List<Cliente> lstClientes=new ArrayList<Cliente>();
		lista=this.traerPersonas();
		Iterator<Persona>it=lista.iterator();
		while(it.hasNext()) {
			Persona persona=it.next();
			if(persona instanceof Cliente) {
				Cliente cliente=(Cliente)persona;
				lstClientes.add(cliente);
			}
		}
		return lstClientes;
	}
	
	public List<Empleado> traerEmpleados(){
		List<Persona>lista=null;
		List<Empleado> lstEmpleados=new ArrayList<Empleado>();
		lista=this.traerPersonas();
		Iterator<Persona>it=lista.iterator();
		while(it.hasNext()) {
			Persona persona=it.next();
			if(persona instanceof Empleado) {
				
				Empleado empleado=(Empleado)persona;
				lstEmpleados.add(empleado);
			}
		}
		return lstEmpleados;
	}
	
	public List<Llamada> traerLlamada(LocalDate desde,LocalDate hasta) {
		List<Llamada>lista=new ArrayList<Llamada>();
		Iterator<Llamada>it=lstLlamadas.iterator();
		
		while(it.hasNext()) {
			Llamada llamada=it.next();
			//pregunto si 20/2 es despues que cada fecha y si 19/2 es antes que cada fecha 
			if((llamada.getFecha().isAfter(desde)||llamada.getFecha().isEqual(desde))&&(llamada.getFecha().isBefore(hasta)||llamada.getFecha().isEqual(hasta))) {
				
				lista.add(llamada);
				
			}
		}
		return lista;
	}
	
	public List<Llamada> traerLlamada(LocalDate desde,LocalDate hasta,int nivelDeSatisfaccion) {
		List<Llamada>lista=this.traerLlamada(desde, hasta);
		List<Llamada>listaDev=new ArrayList<Llamada>();
		Iterator<Llamada>it=lista.iterator();
		while(it.hasNext()) {
			Llamada llamada=it.next();
			if(llamada.getNivelDeSatisfaccion()==nivelDeSatisfaccion) {
				listaDev.add(llamada);
			}
		}
		return listaDev;
	}
	
	public double calcularPorcentajeNivelDeSatisfaccion(LocalDate desde,LocalDate hasta,int nivelDeSatisfaccion) {
		List<Llamada>lista=this.traerLlamada(desde, hasta, nivelDeSatisfaccion);
		int cantidad=0;
		int cantidadTotal=this.getLstLlamadas().size();
		cantidad=lista.size();
		float resultado=0;
		resultado=cantidad*100/cantidadTotal;
		
		return resultado;
		
	}
	
	public List<Llamada> traerLlamada(LocalDate desde,LocalDate hasta,Empleado empleado){
		List<Llamada>lista=this.traerLlamada(desde, hasta);
		List<Llamada>devolver=new ArrayList<Llamada>();
		Persona persona=this.traerPersona(empleado.getDni());
		Empleado empleados=(Empleado)persona;
		Iterator<Llamada>it=lista.iterator();
		
		while(it.hasNext()) {
			Llamada llamada=it.next();
			if(llamada.getEmpleado().equals(empleados)) {
				devolver.add(llamada);
			}
		}
		return devolver;
	}
	
	public List<Llamada> traerLlamada(LocalDate desde,LocalDate hasta,Empleado empleado,int nivelDeSatisfaccion){
		List<Llamada>lista=this.traerLlamada(desde, hasta, empleado);
		Iterator<Llamada>it=lista.iterator();
		List<Llamada>devolver=new ArrayList<Llamada>();
		while(it.hasNext()) {
			Llamada llamada=it.next();
			if(llamada.getNivelDeSatisfaccion()==nivelDeSatisfaccion) {
				devolver.add(llamada);
			}
		}
		return devolver;
	}
	
	public double calcularPorcentajeNivelDeSatisfaccionLlamada(LocalDate desde,LocalDate hasta,Empleado empleado,int nivelDeSatisfaccion) {
		List<Llamada>lista=this.traerLlamada(desde, hasta, empleado, nivelDeSatisfaccion);
		int cantidad=0;
		int cantidadTotal=this.traerLlamada(desde, hasta, empleado).size();
		cantidad=lista.size();
		float resultado=0;
		resultado=cantidad*100/cantidadTotal;
		
		return resultado;
	}
	
}
