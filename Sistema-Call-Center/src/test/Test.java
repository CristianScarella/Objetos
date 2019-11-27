package test;

import java.time.LocalDate;

import modelo.*;
import modelo.SistemaCallCenter;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		SistemaCallCenter sistema=new SistemaCallCenter();
		sistema.agregarCliente("Luis", "Perez", 111111111, true);
		sistema.agregarCliente("Lucas", "Pereyra", 222222222, false);
		sistema.agregarEmpleado("Pedro", "Lopez", 333333333, 10000);
		sistema.agregarEmpleado("Pablo", "Gomes", 444444444, 9000);
		System.out.println(sistema.getLstPersonas());
		
		System.out.println(sistema.traerPersona(111111111));

		System.out.println(sistema.traerPersona(333333333));

		System.out.println(sistema.agregarCliente("Marcos", "Rios", 222222222, true));
		
		System.out.println(sistema.agregarEmpleado("Miguel", "Martinez", 444444444, 9500));
		
		sistema.agregarLlamada(LocalDate.of(2018, 2, 19),(Cliente)sistema.traerPersona(111111111),(Empleado)sistema.traerPersona(333333333),5);
		sistema.agregarLlamada(LocalDate.of(2018, 2, 19),(Cliente)sistema.traerPersona(111111111),(Empleado)sistema.traerPersona(333333333),5);
		sistema.agregarLlamada(LocalDate.of(2018, 2, 19),(Cliente)sistema.traerPersona(111111111),(Empleado)sistema.traerPersona(333333333),5);
		sistema.agregarLlamada(LocalDate.of(2018, 2, 19),(Cliente)sistema.traerPersona(111111111),(Empleado)sistema.traerPersona(333333333),5);
		sistema.agregarLlamada(LocalDate.of(2018, 2, 19),(Cliente)sistema.traerPersona(111111111),(Empleado)sistema.traerPersona(444444444),5);
		sistema.agregarLlamada(LocalDate.of(2018, 2, 19),(Cliente)sistema.traerPersona(222222222),(Empleado)sistema.traerPersona(333333333),5);
		sistema.agregarLlamada(LocalDate.of(2018, 2, 20),(Cliente)sistema.traerPersona(111111111),(Empleado)sistema.traerPersona(333333333),4);
		sistema.agregarLlamada(LocalDate.of(2018, 2, 20),(Cliente)sistema.traerPersona(111111111),(Empleado)sistema.traerPersona(333333333),4);
		sistema.agregarLlamada(LocalDate.of(2018, 2, 20),(Cliente)sistema.traerPersona(111111111),(Empleado)sistema.traerPersona(333333333),3);
		sistema.agregarLlamada(LocalDate.of(2018, 2, 20),(Cliente)sistema.traerPersona(111111111),(Empleado)sistema.traerPersona(333333333),3);
		sistema.agregarLlamada(LocalDate.of(2018, 2, 20),(Cliente)sistema.traerPersona(111111111),(Empleado)sistema.traerPersona(333333333),2);
		sistema.agregarLlamada(LocalDate.of(2018, 2, 21),(Cliente)sistema.traerPersona(111111111),(Empleado)sistema.traerPersona(333333333),5);
		
		System.out.println(sistema.traerClientes());
		
		System.out.println(sistema.traerEmpleados());
		
		System.out.println(sistema.traerLlamada(LocalDate.of(2018, 2, 19), LocalDate.of(2018, 2, 21)));
		
		System.out.println(sistema.calcularPorcentajeNivelDeSatisfaccion(LocalDate.of(2018, 2, 19), LocalDate.of(2018, 2, 21),5));
		
		System.out.println(sistema.calcularPorcentajeNivelDeSatisfaccion(LocalDate.of(2018, 2, 19), LocalDate.of(2018, 2, 21),4));
		
		System.out.println(sistema.calcularPorcentajeNivelDeSatisfaccion(LocalDate.of(2018, 2, 19), LocalDate.of(2018, 2, 21),3));

		System.out.println(sistema.calcularPorcentajeNivelDeSatisfaccion(LocalDate.of(2018, 2, 19), LocalDate.of(2018, 2, 21),2));
		
		System.out.println(sistema.calcularPorcentajeNivelDeSatisfaccion(LocalDate.of(2018, 2, 19), LocalDate.of(2018, 2, 21),1));

		System.out.println(sistema.traerLlamada(LocalDate.of(2018, 2, 19), LocalDate.of(2018, 2, 21),(Empleado)sistema.traerPersona(333333333)));

		System.out.println(sistema.traerLlamada(LocalDate.of(2018, 2, 19), LocalDate.of(2018, 2, 21),(Empleado)sistema.traerPersona(333333333),5));

		System.out.println(sistema.calcularPorcentajeNivelDeSatisfaccionLlamada(LocalDate.of(2018, 2, 19), LocalDate.of(2018, 2, 21), (Empleado)sistema.traerPersona(333333333), 5));
	}

}
