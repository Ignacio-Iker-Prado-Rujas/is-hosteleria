class VerReserva
!!!158853.java!!!	VerReserva(inout rest : GUIController)
		this.controlador = rest;
		/*JPanel panel = new JPanel();
		JLabel nombre = new JLabel("Introduzca su nombre");
		nombreReserva = new JTextField();
		panel.setLayout(new GridLayout (3,1));
		panel.add(nombre);
		panel.add(nombreReserva);

		
		panel.add(new JButton("Buscar"){
			{
				this.addActionListener(new ActionListener(){

					@Override
					public void actionPerformed(ActionEvent e) {
						List<Integer> listaReservas = controlador.reservasDeUnCliente(nombreReserva.getText());
						for (Integer r : listaReservas) r.crearPanel(); 
						
						// TODO AYUDA!! haciendo eso te cargas el mvc pero si no lo hacer tienes que crear mil getters y setters						
					}
					
				});
			}
		}); */
		
		JTabbedPane tabbedPane = new JTabbedPane();
		
		JPanel panelTodas = new JPanel();
		tabbedPane.addTab("Todas", null, panelTodas, "Muestra todas las reservas");
		
		for ( ReservaInfo r : controlador.getReservas(-1)){
			JTextArea jt = new JTextArea(r.toString());			
			panelTodas.add(jt);
		}
		
		JPanel panelHoy = new JPanel();
		tabbedPane.addTab("Hoy", null, panelHoy, "Muestra las reservas de hoy");
		for ( ReservaInfo r : controlador.getReservas(0)){
			JTextArea jt = new JTextArea(r.toString());			
			panelHoy.add(jt);
		}
		
		JPanel panelSemana = new JPanel();
		tabbedPane.addTab("Esta semana",null, panelSemana,
		                  "Muestra las reservas de esta semana");
		for ( ReservaInfo r : controlador.getReservas(1)){
			JTextArea jt = new JTextArea(r.toString());			
			panelSemana.add(jt);
		}
		
		JPanel panelMes = new JPanel();
		panelMes.setPreferredSize(new Dimension(410, 50));
		tabbedPane.addTab("Este mes", null, panelMes,
		                      "Muestra las reservas de este mes");
		for ( ReservaInfo r : controlador.getReservas(2)){
			JTextArea jt = new JTextArea(r.toString());			
			panelMes.add(jt);
		}
		JFrame marco = new JFrame();
		
		marco.add(tabbedPane);
		marco.setVisible(true);
		marco.setSize(150, 150);
!!!158981.java!!!	cambioOcurrido() : void
		// TODO Auto-generated method stub
		
