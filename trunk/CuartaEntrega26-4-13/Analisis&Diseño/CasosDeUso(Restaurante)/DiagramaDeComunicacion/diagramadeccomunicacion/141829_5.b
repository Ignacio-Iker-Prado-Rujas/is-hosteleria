class Usuario
!!!147077.java!!!	Usuario(in nombre : String, in contrasena : String)
		this.id = nombre;
		this.password = contrasena.toCharArray();
!!!147205.java!!!	main(inout args : String) : void
		// TODO Auto-generated method stub
		UserWindow p = new UserWindow(null);
		p.setVisible(true);
!!!147333.java!!!	getId() : String
		return id;
!!!147461.java!!!	setId(in id : String) : void
		this.id = id;
!!!147589.java!!!	getPassword() : char
		return password;
!!!147717.java!!!	setPassword(inout password : char) : void
		this.password = password;
!!!148357.java!!!	CantidadExistencias(inout controller : GUIController)
		this.controlador = controller;
		JPanel panel = new JPanel();
		menu = controlador.getMenu();
		//menu.
