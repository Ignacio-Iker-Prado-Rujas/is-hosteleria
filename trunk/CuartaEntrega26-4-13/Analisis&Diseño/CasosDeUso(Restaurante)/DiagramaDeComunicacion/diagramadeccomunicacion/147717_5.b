class CardLayoutExample
!!!169477.java!!!	main(inout args : String) : void
   
       //Use the event dispatch thread for Swing components
       EventQueue.invokeLater(new Runnable()
       {
           
          @Override
           public void run()
           {
               
               new CardLayoutExample();         
           }
       });
            
!!!169605.java!!!	CardLayoutExample()
 
      guiFrame = new JFrame();
      
      //make sure the program exits when the frame closes
      guiFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      guiFrame.setTitle("CardLayout Example");
      guiFrame.setSize(400,300);
    
      //This will center the JFrame in the middle of the screen
      guiFrame.setLocationRelativeTo(null);
      guiFrame.setLayout(new BorderLayout());
      
      //creating a border to highlight the JPanel areas
      Border outline = BorderFactory.createLineBorder(Color.black);
      
      JPanel tabsPanel = new JPanel();
      tabsPanel.setBorder(outline);
      JButton switchCards = new JButton("Switch Card");
      switchCards.setActionCommand("Switch Card");
      switchCards.addActionListener(new ActionListener()
      {
          @Override
          public void actionPerformed(ActionEvent event)
          {
              cards.next(cardPanel);
          }
      });
      tabsPanel.add(switchCards);
      
      guiFrame.add(tabsPanel,BorderLayout.NORTH);
      
      
      cards = new CardLayout();
      cardPanel = new JPanel();
      cardPanel.setLayout(cards);
      cards.show(cardPanel, "Fruits");
      
      JPanel firstCard = new JPanel();
      firstCard.setBackground(Color.GREEN);
      addButton(firstCard, "APPLES");
      addButton(firstCard, "ORANGES");
      addButton(firstCard, "BANANAS");
      
      JPanel secondCard = new JPanel();
      secondCard.setBackground(Color.BLUE);
      addButton(secondCard, "LEEKS");
      addButton(secondCard, "TOMATOES");
      addButton(secondCard, "PEAS");
      
      cardPanel.add(firstCard, "Fruits");
      cardPanel.add(secondCard, "Veggies");
      
      guiFrame.add(tabsPanel,BorderLayout.NORTH);
      guiFrame.add(cardPanel,BorderLayout.CENTER);
      guiFrame.setVisible(true);
!!!169733.java!!!	addButton(inout parent : Container, in name : String) : void
      JButton but = new JButton(name);
      but.setActionCommand(name);
      parent.add(but);
!!!175237.java!!!	forceString(in str : String) : void
		if (!(tokenizer.nextToken() == StreamTokenizer.TT_WORD && tokenizer.sval
				.equals(str))) {
			System.err.println("Fichero dañado");
			System.exit(1);
		}
!!!175365.java!!!	forceString(in str1 : String, in str2 : String) : Boolean
		if (tokenizer.nextToken() == StreamTokenizer.TT_WORD)
			if (tokenizer.sval.equals(str1))
				return true;
			else if (tokenizer.sval.equals(str2))
				return false;
			else {
				System.err.println("Fichero dañado");
				System.exit(1);
			}
		else {
			System.err.println("Fichero dañado");
			System.exit(1);
		}
		return null;
!!!175493.java!!!	forceFloat() : float
		if (tokenizer.nextToken() != StreamTokenizer.TT_NUMBER) {
			System.err.println("Fichero dañado");
			System.exit(1);
		}
		return (float) tokenizer.nval;
!!!175621.java!!!	peek() : String
		if (tokenizer.nextToken() == StreamTokenizer.TT_WORD)
			return tokenizer.sval;
		return "";
!!!175749.java!!!	forceConsumicion(in tipo : String) : Consumicion
		ArrayList<Consumicion> platos = new ArrayList<Consumicion>();
		while (!peek().equals(tipo)) {
			tokenizer.pushBack();
			tokenizer.nextToken();
			String name = tokenizer.sval;
			tokenizer.nextToken();
			String descripcion = tokenizer.sval;
			float precio = forceFloat();
			boolean disponible = forceString("Disponible", "NoDisponible");
			Plato plato = new Plato(name, precio, disponible, descripcion);
			platos.add(plato);
		}
		return platos;
!!!175877.java!!!	loadMenu(in fileName : String) : Menu
		FileInputStream file;
		try {
			file = new FileInputStream(fileName);
			tokenizer = new StreamTokenizer(new InputStreamReader(file));
			tokenizer.wordChars('\u0021', '\u007E');
			tokenizer.quoteChar('"');
			forceString("BeginMenu");
			forceString("BeginPrimeros");
			ArrayList<Consumicion> listaPrimeros = forceConsumicion("EndPrimeros");
			forceString("BeginSegundos");
			ArrayList<Consumicion> listaSegundos = forceConsumicion("EndSegundos");
			forceString("BeginBebidas");
			ArrayList<Consumicion> listaBebidas = forceConsumicion("EndBebidas");
			forceString("BeginPostres");
			ArrayList<Consumicion> listaPostres = forceConsumicion("EndPostres");
			forceString("EndMenu");
			return new Menu(listaPrimeros, listaSegundos, listaBebidas,
					listaPostres);
		} catch (FileNotFoundException e) {
			System.err.println("El fichero no existe");
			return null;
		}
