class CardLayoutDemo
!!!168965.java!!!	addComponentToPane(inout pane : Container) : void
        //Put the JComboBox in a JPanel to get a nicer look.
        JPanel comboBoxPane = new JPanel(); //use FlowLayout
        String comboBoxItems[] = { BUTTONPANEL, TEXTPANEL };
        JComboBox cb = new JComboBox(comboBoxItems);
        cb.setEditable(false);
        cb.addItemListener(this);
        comboBoxPane.add(cb);
         
        //Create the "cards".
        JPanel card1 = new JPanel();
        card1.add(new JButton("Button 1"));
        card1.add(new JButton("Button 2"));
        card1.add(new JButton("Button 3"));
         
        JPanel card2 = new JPanel();
        card2.add(new JTextField("TextField", 20));
         
        //Create the panel that contains the "cards".
        cards = new JPanel(new CardLayout());
        cards.add(card1, BUTTONPANEL);
        cards.add(card2, TEXTPANEL);
         
        pane.add(comboBoxPane, BorderLayout.PAGE_START);
        pane.add(cards, BorderLayout.CENTER);
!!!169093.java!!!	itemStateChanged(inout evt : ItemEvent) : void
        CardLayout cl = (CardLayout)(cards.getLayout());
        cl.show(cards, (String)evt.getItem());
!!!169221.java!!!	createAndShowGUI() : void
        //Create and set up the window.
        JFrame frame = new JFrame("CardLayoutDemo");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         
        //Create and set up the content pane.
        CardLayoutDemo demo = new CardLayoutDemo();
        demo.addComponentToPane(frame.getContentPane());
         
        //Display the window.
        frame.pack();
        frame.setVisible(true);
!!!169349.java!!!	main(inout args : String) : void
        /* Use an appropriate Look and Feel */
        try {
            //UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
            UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");
        } catch (UnsupportedLookAndFeelException ex) {
            ex.printStackTrace();
        } catch (IllegalAccessException ex) {
            ex.printStackTrace();
        } catch (InstantiationException ex) {
            ex.printStackTrace();
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        }
        /* Turn off metal's use of bold fonts */
        UIManager.put("swing.boldMetal", Boolean.FALSE);
         
        //Schedule a job for the event dispatch thread:
        //creating and showing this application's GUI.
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
!!!173317.java!!!	Plato()
		
!!!173445.java!!!	Plato(in nombre : String, in precio : float, inout disp : boolean, in descripcion : String)
		this.descripcion = descripcion;
		this.nombre = nombre;
		this.precio = precio;
		this.disponible = disp;
!!!173573.java!!!	getDescripcion() : String
		return this.descripcion;
!!!173701.java!!!	getPrecio() : float
		return precio;
!!!173829.java!!!	setPrecio(in precio : float) : void
		this.precio = precio;
!!!173957.java!!!	isDisponible() : boolean
		return disponible;
!!!174085.java!!!	setDisponible(inout disponible : boolean) : void
		this.disponible = disponible;
!!!174213.java!!!	getNombre() : String
		return this.nombre;
!!!174341.java!!!	toString() : String
		String str = "";
		str += "\"" + nombre + "\" \"" + descripcion + "\" " + precio + " ";
		if (disponible)
			str += "Disponible";
		else
			str += "NoDisponible";
		str += LINE_SEPARATOR;
		return str;
