package views;

import java.util.ArrayList;

import javax.swing.Box;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Modelo.cliente;
import Modelo.cuenta;
import Modelo.ejecutivo;
import Modelo.juridico;
import Modelo.natural;
import ModeloDao.ClienteDao;
import ModeloDao.CuentaDao;
import ModeloDao.EjecutivoDao;
import ModeloDao.JuridicoDao;
import ModeloDao.NaturalDao;

public class Main {
	public static void main(String[] args) {
		String perRut,ruteje,perNombre,perApePaterno,cliCategoria, perNacionalidad,perFecNacimiento,CueSobreGiro,cueEstado,ejeFecContrato;
		Integer id,saldo;
		JTextField dia = new JTextField(2);
		JTextField mes = new JTextField(2);
		JTextField year = new JTextField(4);
		JPanel myPanel = new JPanel();
		myPanel.add(new JLabel("Dia:"));
	    myPanel.add(dia);
	    myPanel.add(Box.createVerticalStrut(10));
	    myPanel.add(new JLabel("Mes:"));
	    myPanel.add(mes);
	    myPanel.add(Box.createVerticalStrut(10));
	    myPanel.add(new JLabel("Año:"));
	    myPanel.add(year);
		char nomChar;
		int nomInt;
		Integer t;
		String o;
		int band = 0;
		natural n;
		juridico j;
		ejecutivo e;
		cliente cli;
		cuenta cu;
		ArrayList<cliente> clientes;
		ArrayList<natural> naturales;
		ArrayList<juridico> juridicos;
		ArrayList<ejecutivo> ejecutivos;
		ArrayList<cuenta> cuentas;
		ClienteDao clidao;
		NaturalDao natDao;
		JuridicoDao jurdao;
		EjecutivoDao ejedao;
		CuentaDao cuedao;
		Object [] cat = new Object[]  {"normal", "VIP", "riesgo"};
		Object [] opciones=new Object[] {"1.- Ingresar Cliente", 
				"2.- Registrar Cuenta", 
				"3.- Ejecutivos", 
				"4.- Listado de Clientes", 
				"5.- Gestionar Clientes", 
				"6.- Gestionar Cuentas",
				"7.- Realizar Giro",
				"8.- Realizar Deposito",
				"9.- Salir Programa"};
		Object [] caso1 = new Object[] {"1.- Cliente Natural", 
		"2.- Cliente Juridico"};
		Object [] caso2 = new Object[] {"1.- Registrar Ejecutivo",
				"2.- Actualizar Ejecutivo",
				"3.- Listar Ejecutivos"};
		Object [] caso3 = new Object[] {"1.- Listar Todos los Clientes",
				"2.- Listar Clientes Naturales",
				"3.- Listar Clientes Juridicos"};
		Object [] caso4 = new Object[] {"1.- Actualizar Cliente Natural", 
		"2.- Actualizar Cliente Juridico"};
		Object [] caso5 = new Object[] {"1.- Actualizar Cuenta", 
		"2.- Buscar Cuenta",
		"3.- Listar Todas las Cuentas",
		"4.- Listar Cuentas Naturales",
		"5.- Listar Cuentas Juridicos",
		"6.- Bloquear Cuenta",
		"7.- Eliminar Cuenta"};
		Object [] est = new Object[] {"vigente","bloqueado","inactivo"};
		while (true) {
			Object seleccion = JOptionPane.showInputDialog(
					   null, "Seleccione una opcion", "Sistema Banco Inter",
					   JOptionPane.QUESTION_MESSAGE, null,opciones,"1.- Ingresar Cliente");
			dia.setText("");
			mes.setText("");
			year.setText("");
			perNacionalidad="";
			perRut="";
			ruteje="";
			perNombre = "";
			cliCategoria = "";
			t = null;
			o = "";
			switch (String.valueOf(seleccion).charAt(0)) {
				case'1':
					Object eleccion1 = JOptionPane.showInputDialog(
							   null, "Seleccione el Tipo de Cliente a Ingresar", "Sistema Banco Inter",
							   JOptionPane.QUESTION_MESSAGE, null,caso1,"1.- Cliente Natural");
					n = new natural();
					j = new juridico();
					while (perRut.equals("")) {
						perRut = JOptionPane.showInputDialog("Ingrese el Rut del Cliente");
					}
					switch(String.valueOf(eleccion1).charAt(0)) {
					case'1':
						n.setPerRut(perRut);
						break;
					case'2':
						j.setPerRut(perRut);
						break;
					}
					
					while (perNombre .equals("")) {
						perNombre = JOptionPane.showInputDialog("Ingrese el Nombre del Cliente");
				    	  for (int i = 0; i < perNombre.length(); i++) {
				    		  nomChar = String.valueOf(perNombre).charAt(i);
				    		  nomInt = (int)nomChar;
				    		  if(nomInt<65 || nomInt>122) {
				    			  perNombre="";
				    			  break;
				    		  }
				    	  }
				      }
					switch(String.valueOf(eleccion1).charAt(0)) {
					case'1':
						n.setPerNombre(perNombre);
						break;
					case'2':
						j.setPerNombre(perNombre);
						break;
					}
					switch(String.valueOf(eleccion1).charAt(0)) {
					case'1':
						while (n.getPerApePaterno() == null || n.getPerApePaterno().equals("")) {
							perApePaterno = JOptionPane.showInputDialog("Indique los Apellidos del cliente");
							n.setPerApePaterno(perApePaterno);
						}
						break;
					case'2':
						while (j.getPerApePaterno() == null || j.getPerApePaterno().equals("")) {
							perApePaterno = JOptionPane.showInputDialog("Indique los Apellidos del Cliente");
							j.setPerApePaterno(perApePaterno);
						}
						break;
					}	
					cliCategoria = (String) JOptionPane.showInputDialog(
							   null, "Seleccione Categoria", "Sistema Banco Inter",
							   JOptionPane.QUESTION_MESSAGE, null,cat,"normal");
					switch(String.valueOf(eleccion1).charAt(0)) {
					case'1':
						n.setCliCategoria(cliCategoria);;
						break;
					case'2':
						j.setCliCategoria(cliCategoria);;
						break;
					}
				    switch(String.valueOf(eleccion1).charAt(0)) {
				      
				      case'1':
				      	t = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el Patrimonio del Cliente"));
				      	
				      	n.setNatPatrimonio(t);
				    	  	NaturalDao natdao = new NaturalDao();
				    	  	natdao.ingresar(n);
				    	  	break;
				      case'2':
				      	o = JOptionPane.showInputDialog("Señale la razon social del Cliente");
				      	j.setJurRazSocial(o);
				      	JuridicoDao jur = new JuridicoDao();
				      	jur.ingresar(j);
				      	break;
				    }
					
					break;

				case'2':
					ejedao = new EjecutivoDao();
					e = new ejecutivo();
					Object seleccion3 = JOptionPane.showInputDialog(
							   null, "Seleccione una opcion", "Sistema Banco Inter",
							   JOptionPane.QUESTION_MESSAGE, null,caso3,"1.- Registrar Ejecutivo");
					switch(String.valueOf(seleccion3).charAt(0)) {
					case'1':
						
						while (e.getPerRut() == null || e.getPerRut().equals("")) {
							perRut = JOptionPane.showInputDialog("Ingrese el RUT del Ejecutivo");
							e.setPerRut(perRut);
						}
						while (e.getPerNombre() == null || e.getPerNombre().equals("")) {
							perNombre = JOptionPane.showInputDialog("Indique el Nombre Del Ejecutivo");
							e.setPerNombre(perNombre);
						}
						while (e.getPerApePaterno() == null || e.getPerApePaterno().equals("")) {
							perApePaterno = JOptionPane.showInputDialog("Ingrese los Apellidos del Ejecutivo");
							e.setPerApePaterno(perApePaterno);
						}
					    JOptionPane.showConfirmDialog(null, myPanel, 
							    "Ingrese Fecha De Contratacion del Ejecutivo", JOptionPane.OK_CANCEL_OPTION);
					    e.setEjeFecContrato(year.getText()+"-"+mes.getText()+"-"+dia.getText());
					    
					    ejedao.ingresar(e);
					    break;
					case'2':
						
						while (e.getPerRut() == null || e.getPerRut().equals("")) {
							perRut = JOptionPane.showInputDialog("Ingrese el RUT del Ejecutivo");
							e.setPerRut(perRut);
						}
						while (e.getPerNombre() == null || e.getPerNombre().equals("")) {
							perNombre = JOptionPane.showInputDialog("Indique el Nombre Del Ejecutivo");
							e.setPerNombre(perNombre);
						}
						while (e.getPerApePaterno() == null || e.getPerApePaterno().equals("")) {
							perApePaterno = JOptionPane.showInputDialog("Ingrese los Apellidos del Ejecutivo");
							e.setPerApePaterno(perApePaterno);
						}
						while (e.getPerNacionalidad() == null || e.getPerNacionalidad().equals("")) {
							perNacionalidad = JOptionPane.showInputDialog("Ingrese la Nacionalidad del Ejecutivo");
					    	e.setPerNacionalidad(perNacionalidad);
					      }
					    JOptionPane.showConfirmDialog(null, myPanel, 
							    "Ingrese Fecha De Nacimiento del Ejecutivo", JOptionPane.OK_CANCEL_OPTION);
						perFecNacimiento = year.getText()+"-"+mes.getText()+"-"+dia.getText();
						dia.setText("");
						mes.setText("");
						year.setText("");
						JOptionPane.showConfirmDialog(null, myPanel, 
							    "Ingrese Fecha De Contratacion del Ejecutivo", JOptionPane.OK_CANCEL_OPTION);
						ejeFecContrato = year.getText()+"-"+mes.getText()+"-"+dia.getText();
					    e.setPerFecNacimiento(perFecNacimiento);
					    e.setEjeFecContrato(ejeFecContrato);
					    ejedao.actualizar(e);
					    
						break;
					case'3':
						ejecutivos = new ArrayList<>();
						ejedao = new EjecutivoDao();
						ejecutivo ejecutivo1 = new ejecutivo();
						ejecutivos = ejedao.listar();
						for (ejecutivo e1 : ejecutivos) {
							System.out.println(e1.toString());
						}
							break;
						}
						break;
		
				case'3':
					Object eleccion4 = JOptionPane.showInputDialog(
							   null, "Seleccione Opcion de Listado", "Sistema Banco Inter",
							   JOptionPane.QUESTION_MESSAGE, null,caso4,"1.- Listar Todos los Clientes");
					switch(String.valueOf(eleccion4).charAt(0)) {
					case'1':
						clientes = new ArrayList<>();
						clidao = new ClienteDao();
						cliente cliente1 = new cliente();
						clientes = clidao.listar();
						for (cliente c1 : clientes) {
							System.out.println(c1.toString());
						}
						break;
					case'2':
						naturales= new ArrayList<>();
						natDao = new NaturalDao();
						natural natural1 = new natural();
						naturales = natDao.listar();
						for (natural n1 : naturales) {
							System.out.println(n1.toString());
						}
						break;
					case'3':
						juridicos = new ArrayList<>();
						jurdao = new JuridicoDao();
						juridico juridico1 = new juridico();
						juridicos = jurdao.listar();
						for (juridico j1 : juridicos) {
							System.out.println(j1.toString());
						}
						break;
					}
					break;
				case'4':
					Object eleccion5 = JOptionPane.showInputDialog(
							   null, "Seleccione el Tipo de Cliente a Actualizar", "Sistema Banco Inter",
							   JOptionPane.QUESTION_MESSAGE, null,caso5,"1.- Actualizar Cliente Natural");
					e = new ejecutivo();
					n = new natural();
					j = new juridico();
					while (perRut.equals("")) {
						perRut = JOptionPane.showInputDialog("Ingrese el Rut del Cliente");
					}
					switch(String.valueOf(eleccion5).charAt(0)) {
					case'1':
						n.setPerRut(perRut);
						break;
					case'2':
						j.setPerRut(perRut);
						break;
					}
					
					while (perNombre .equals("")) {
						perNombre = JOptionPane.showInputDialog("Ingrese el Nombre del Cliente");
				    	  for (int i = 0; i < perNombre.length(); i++) {
				    		  nomChar = String.valueOf(perNombre).charAt(i);
				    		  nomInt = (int)nomChar;
				    		  if(nomInt<65 || nomInt>122) {
				    			  perNombre="";
				    			  break;
				    		  }
				    	  }
				      }
					switch(String.valueOf(eleccion5).charAt(0)) {
					case'1':
						n.setPerNombre(perNombre);
						break;
					case'2':
						j.setPerNombre(perNombre);
						break;
					}
					switch(String.valueOf(eleccion5).charAt(0)) {
					case'1':
						while (n.getPerApePaterno() == null || n.getPerApePaterno().equals("")) {
							perApePaterno = JOptionPane.showInputDialog("Indique los Apellidos del cliente");
							n.setPerApePaterno(perApePaterno);
						}
						break;
					case'2':
						while (j.getPerApePaterno() == null || j.getPerApePaterno().equals("")) {
							perApePaterno = JOptionPane.showInputDialog("Indique los Apellidos del Cliente");
							j.setPerApePaterno(perApePaterno);
						}
					}
					
					cliCategoria = (String) JOptionPane.showInputDialog(
							   null, "Seleccione Categoria", "Sistema Banco Inter",
							   JOptionPane.QUESTION_MESSAGE, null,cat,"normal");
					switch(String.valueOf(eleccion5).charAt(0)) {
					case'1':
						n.setCliCategoria(cliCategoria);
						break;
					case'2':
						j.setCliCategoria(cliCategoria);
						break;
					}
				    JOptionPane.showConfirmDialog(null, myPanel, 
						    "Ingrese Fecha de Nacimiento", JOptionPane.OK_CANCEL_OPTION);
				    switch(String.valueOf(eleccion5).charAt(0)) {
					case'1':
						n.setPerFecNacimiento(year.getText()+"-"+mes.getText()+"-"+dia.getText());
						break;
					case'2':
						j.setPerFecNacimiento(year.getText()+"-"+mes.getText()+"-"+dia.getText());
						break;
					}
				    switch(String.valueOf(eleccion5).charAt(0)) {
					case'1':
						while (n.getPerNacionalidad() == null || n.getPerNacionalidad().equals("")) {
							perNacionalidad = JOptionPane.showInputDialog("Indique la Nacionalidad del cliente");
							n.setPerNacionalidad(perNacionalidad);
						}
						break;
					case'2':
						while (j.getPerNacionalidad() == null || j.getPerNacionalidad().equals("")) {
							perNacionalidad = JOptionPane.showInputDialog("Indique la Nacionalidad del cliente");
							j.setPerNacionalidad(perNacionalidad);
						}
						break;
					}
				    
				    while (ruteje.equals("")) {
				    	ruteje = JOptionPane.showInputDialog("Ingrese el RUT del Ejecutivo Encargado");
				      }
				    e.setPerRut(ruteje);
				    switch(String.valueOf(eleccion5).charAt(0)) {
					case'1':
						n.setEje(e);
						break;
					case'2':
						j.setEje(e);
						break;
					}
				    
				    switch(String.valueOf(eleccion5).charAt(0)) {
				      
				      case'1':
				      	t = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el Patrimonio del Cliente"));
				      	
				      	n.setNatPatrimonio(t);
				    	  	NaturalDao natdao = new NaturalDao();
				    	  	natdao.actualizar(n);
				    	  	break;
				      case'2':
				      	o = JOptionPane.showInputDialog("Señale la razon social del Cliente");
				      	j.setJurRazSocial(o);
				      	JuridicoDao jur = new JuridicoDao();
				      	jur.actualizar(j);
				      	break;
				    }
					
					break;
				case'5':
					Object eleccion6 = JOptionPane.showInputDialog(
							   null, "Seleccione la Opcion de Cuentas", "Sistema Banco Inter",
							   JOptionPane.QUESTION_MESSAGE, null,caso5,"1.- Actualizar Cuenta");
					switch(String.valueOf(eleccion6).charAt(0)) {
					case '1':
						id = Integer.parseInt(JOptionPane.showInputDialog("Indique la ID de la cuenta"));
						saldo = Integer.parseInt(JOptionPane.showInputDialog("Indique el Saldo de la Cuenta"));
						Object sg = JOptionPane.showInputDialog(
								   null, "Indique Opcion de SobreGiro", "Sistema Banco Inter",
								   JOptionPane.QUESTION_MESSAGE, null,caso2,"0.- Sin SobreGiro");
						
						CueSobreGiro =String.valueOf(String.valueOf(sg).charAt(0));
						cueEstado = (String) JOptionPane.showInputDialog(
								   null, "Seleccione Estado de la Cuenta", "Sistema Banco Inter",
								   JOptionPane.QUESTION_MESSAGE, null,est,"vigente");
						cli = new cliente();
						cu = new cuenta(id,saldo,null,cueEstado,Integer.parseInt(CueSobreGiro),cli);
						cuedao = new CuentaDao();
						cuedao.actualizarSaldo(cu);
						break;
					case'2':
						perRut="";
						while (perRut.equals("")) {
							perRut = JOptionPane.showInputDialog("Ingrese el Rut del Cliente");
						}
						cli = new cliente();
						cli.setPerRut(perRut);
						cuentas = new ArrayList<>();
						cuedao = new CuentaDao();
						cu = new cuenta();
						cuedao.buscar_cuentas(cu);
						for (cuenta cue1 : cuentas) {
							System.out.println(cue1.toString());
						}
						break;
					
					case'3':
						cuentas = new ArrayList<>();
						cuedao = new CuentaDao();
						cuedao.listar();
						for (cuenta cue1 : cuentas) {
							System.out.println(cue1.toString());
						}
						break;
					case'4':
						cuentas = new ArrayList<>();
						cuedao = new CuentaDao();
						cuedao.listarnaturales();
						for (cuenta cue1 : cuentas) {
							System.out.println(cue1.toString());
						}
						break;
					case'5':
						cuentas = new ArrayList<>();
						cuedao = new CuentaDao();
						cuedao.listarjuridicos();
						for (cuenta cue1 : cuentas) {
							System.out.println(cue1.toString());
						}
						break;
					case'6':
						id = Integer.parseInt(JOptionPane.showInputDialog("Indique el Id de Cuenta a Bloquear"));
						cli = new cliente();
						cu = new cuenta();
						cu.setCueId(id);
						cuedao = new CuentaDao();
						cuedao.bloquear(cu);
						break;
					case'7':
						id = Integer.parseInt(JOptionPane.showInputDialog("Indique el Id de Cuenta a Eliminar"));
						cli = new cliente();
						cu = new cuenta();
						cu.setCueId(id);
						cuedao = new CuentaDao();
						cuedao.eliminar(cu);
						break;
						}
					
				case'6':
					id = Integer.parseInt(JOptionPane.showInputDialog("Indique el Id de la Cuenta"));
					cli = new cliente();
					cu = new cuenta();
					cu.setCueId(id);
					cuedao = new CuentaDao();
					cuedao.buscar(cu);
					if(cu.getCueEstado().toLowerCase().equals("vigente")) {
						if (cu.getCueSobreGiro()==1) {
							saldo = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la Cantidad a Girar"));
							cu.setCueSaldo(cu.getCueSaldo()-saldo);
							cuedao.transaccion(cu);
						}else {
							band = 0;
							while(band == 0) {
								saldo = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la Cantidad a Girar, Usted no Puede Sobregirar"));
								if(cu.getCueSaldo()-saldo>=0) {
									cu.setCueSaldo(cu.getCueSaldo()-saldo);
									cuedao.transaccion(cu);
									band=1;
								}else {
									JOptionPane.showMessageDialog(null, "No Puede girar mas de su Saldo, Intentelo con otra cantidad");
									band=0;
								}
							}
						}
					}else {
						JOptionPane.showMessageDialog(null, "Cuenta Bloqueada o Inactiva, Favor de Reabrir su cuenta");
					}
					break;	
					
				case'7':
					id = Integer.parseInt(JOptionPane.showInputDialog("Indique el Id de la Cuenta"));
					cli = new cliente();
					cu = new cuenta();
					cu.setCueId(id);
					cuedao = new CuentaDao();
					cuedao.buscar(cu);
					if(cu.getCueEstado().toLowerCase().equals("vigente")) {
						saldo = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la Cantidad a Girar"));
						cu.setCueSaldo(cu.getCueSaldo()+saldo);
						cuedao.transaccion(cu);
					}else {
						JOptionPane.showMessageDialog(null, "Cuenta Bloqueada o Inactiva, Favor de Reabrir su cuenta");
					}
					break;
				case'9':
					System.exit(0);
					break;

			}}}}