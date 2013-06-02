class List
!!!145797.java!!!	List()
		list = new Object[MIN_VALUE];
		size = 0;
!!!145925.java!!!	size() : int
		return this.size;
!!!146053.java!!!	get(inout object : Tipo) : Tipo
		if (object != null) {
			int pos = binary(object, 0, size - 1);
			if (object.compareTo((Tipo) list[pos]) == 0)
				return (Tipo) list[pos];
		}
		return null;
!!!146181.java!!!	get(in i : int) : Tipo
		if (i >= this.size())
			return null;
		else return (Tipo) list[i];
!!!146309.java!!!	add(inout object : Tipo) : boolean
		if (object == null)
			return false;
		int pos = binary(object, 0, size - 1);
		if (object.compareTo((Tipo) list[pos]) == 0)
			return false;
		else {
			if (size == list.length)
				biggerList();
			for (int i = size; i > pos; i--)
				list[i] = list[i - 1];
			list[pos] = object;
			size++;
			return true;
		}
!!!146437.java!!!	erase(inout object : Tipo) : boolean
		if (object != null) {
			int pos = binary(object, 0, size - 1);
			if (object.compareTo((Tipo) list[pos]) == 0) {
				list[pos] = null;
				size--;
				for (int i = pos; i < size; i++)
					list[i] = list[i + 1];
				return true;
			}
		}
		return false;
!!!146565.java!!!	biggerList() : void
		Object[] object = new Object[2 * size];
		for (int i = 0; i < size; i++)
			object[i] = list[i];
		list = object;
!!!146693.java!!!	binary(inout object : Tipo, in first : int, in last : int) : int
		if (first > last)
			return first;
		int pos = (first + last) / 2;
		if (object.compareTo((Tipo) list[pos]) < 0)
			return binary(object, first, pos - 1);
		if (object.compareTo((Tipo) list[pos]) > 0)
			return binary(object, pos + 1, last);
		return pos;
!!!147333.java!!!	Main()
		
!!!147461.java!!!	main(inout args : String) : void
		// TODO Auto-generated method stub
		Restaurante rest = new Restaurante();
		GUIController controlador = new GUIController (rest);
		UserWindow window = new UserWindow(controlador);
		window.setVisible(true);
