class Postre
!!!174469.java!!!	Postre(in name : String, in price : float, inout disp : boolean, in desc : String)
		this.descripción = desc;
		this.precio = price;
		this.nombre = name;
		this.disponible = disp;
!!!174597.java!!!	getPrecio() : float
		return this.precio;
!!!174725.java!!!	getNombre() : String
		return this.nombre;
!!!174853.java!!!	getDescripcion() : String
		return this.descripción;
!!!174981.java!!!	isDisponible() : boolean
		return this.disponible;
!!!175109.java!!!	toString() : String
		String str = "";
		str += "\"" + nombre + "\" \"" + descripcion + "\" " + precio + " ";
		if (disponible)
			str += "Disponible";
		else
			str += "NoDisponible";
		str += LINE_SEPARATOR;
		return str;
