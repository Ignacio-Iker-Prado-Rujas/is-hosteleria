class Main
!!!146821.java!!!	Main()
		
!!!146949.java!!!	main(inout args : String) : void
		// TODO Auto-generated method stub
		Restaurante rest = new Restaurante();
		GUIController controlador = new GUIController (rest);
		UserWindow window = new UserWindow(controlador);
		window.setVisible(true);
!!!147589.java!!!	Usuario(in nombre : String, in contrasena : String)
		this.id = nombre;
		this.password = contrasena.toCharArray();
!!!147717.java!!!	main(inout args : String) : void
		// TODO Auto-generated method stub
		UserWindow p = new UserWindow(null);
		p.setVisible(true);
!!!147845.java!!!	getId() : String
		return id;
!!!147973.java!!!	setId(in id : String) : void
		this.id = id;
!!!148101.java!!!	getPassword() : char
		return password;
!!!148229.java!!!	setPassword(inout password : char) : void
		this.password = password;
