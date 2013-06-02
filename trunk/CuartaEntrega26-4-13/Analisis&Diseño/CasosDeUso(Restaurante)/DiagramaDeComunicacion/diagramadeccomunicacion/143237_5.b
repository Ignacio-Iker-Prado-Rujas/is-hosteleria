class Mesa
!!!161413.java!!!	Mesa(in num : int)
		this.setNumeroMesa(num);
!!!161541.java!!!	addPedido(inout comanda : Comanda) : void
		pedidos.add(comanda);
		//pedidos.
!!!161669.java!!!	getNumeroMesa() : int
		return numeroMesa;
!!!161797.java!!!	setNumeroMesa(in numeroMesa : int) : void
		this.numeroMesa = numeroMesa;
!!!161925.java!!!	generarFactura() : String
		String factura = "";
		for (Comanda c : pedidos){
			factura += c.toString() + LINE_SEPARATOR;
		}
		//return pedidos.toString();
		return factura;
!!!162053.java!!!	getListaComandas() : ComandaInfo
		return (ComandaInfo[]) this.pedidos.toArray();
!!!150021.java!!!	GenerarFactura(inout rest : GUIController)
		this.controlador = rest;
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(3,1));
		panel.add( new JLabel("Introduzca el numero de mesa"));
		numMesa = new JTextField();
		panel.add(numMesa);
		panel.add(new JButton("Generar Factura"){
			{
				this.addActionListener(new ActionListener(){

					@Override
					public void actionPerformed(ActionEvent e) {
						numMesa.getText();
					//TODO duda del mvc, aqui hay que llamar al modelo y que te devuelva la mesa?
						
						mesa = controlador.getMesa(numMesa.getText());
						marco = new JFrame();
						//JPanel panel = new JPanel();
						JTextArea factura = new JTextArea(mesa.generarFactura());
						marco.add(factura);
						marco.setVisible(true);
						marco.pack();
						marco.add(new JButton("Aceptar"){
							{
								this.addActionListener(new ActionListener(){

									@Override
									public void actionPerformed(ActionEvent e) {
										marco.setVisible(false);
										
									}
									
								});
							}
						});
					}
					
				});
			}
		});
		JFrame marco = new JFrame();
		marco.add(panel);
		marco.setSize(200,200);
		marco.setVisible(true);
	
