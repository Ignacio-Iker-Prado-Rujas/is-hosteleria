package is.gui;

import is.restaurante.ComandaInfo;
import is.restaurante.MesaInfo;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.TitledBorder;

@SuppressWarnings("serial")
/**
 * TODO por alguna extraña razón al cambiar de mesa no se ponen los botones de editar y esas cosas
 * @author JaimeDan
 *
 */
public class VistaMesas extends JFrame {

	public VistaMesas(final GUIController controller) {
		this.restController = controller;
		this.mesas = this.restController.requestMesas();
		this.setLayout(new BorderLayout());
		this.add(botonesMesa(mesas), BorderLayout.NORTH);
		this.add(comandasPanel());
		this.add(botonesComanda(), BorderLayout.SOUTH);
		this.setSize(300, 300);
		this.setVisible(true);
	}

	private JPanel botonesMesa(MesaInfo[] mesasRestaurante) {
		int superior, inferior;
		if (mesasRestaurante.length % 2 == 0) {
			superior = mesasRestaurante.length / 2;
			inferior = mesasRestaurante.length / 2;
		} else {
			superior = mesasRestaurante.length / 2 + 1;
			inferior = mesasRestaurante.length / 2;
		}
		JPanel botones = new JPanel(new GridLayout(2, 1));
		JPanel panelSuperior = new JPanel(new FlowLayout());
		JPanel panelInferior = new JPanel(new FlowLayout());
		for (int i = 0; i < superior; i++) {
			final int numMesa = i + 1;
			panelSuperior.add(mesaButton(numMesa,
					mesasRestaurante[i].getListaComandas()));
		}
		for (int i = 0; i < inferior; i++) {
			final int numMesa = i + superior + 1;
			panelInferior.add(mesaButton(numMesa,
					mesasRestaurante[i].getListaComandas()));
		}
		botones.add(panelSuperior);
		botones.add(panelInferior);
		return botones;
	}

	private JButton mesaButton(final int numMesa, final ComandaInfo[] comanda) {
		JButton boton = new JButton("Mesa " + numMesa);
		boton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setComanda(comanda, numMesa);
				selectedTable = numMesa;
			}
		});
		return boton;
	}

	public JScrollPane comandasPanel() {
		textoComanda = new JTextArea();
		textoComanda.setEditable(false);
		JScrollPane scrollPane = new JScrollPane(textoComanda);
		return scrollPane;
	}

	private void setComanda(ComandaInfo[] comanda, int mesa) {
		if (comanda != null)
			for (int i = 0; i < comanda.length; i++)
				textoComanda.setText(comanda[i].toString());
		textoComanda.setBorder(new TitledBorder("Mesa " + mesa));
	}

	private JPanel botonesComanda() {
		JPanel panel = new JPanel(new FlowLayout());
		panel.add(addButton());
		panel.add(editButton());
		panel.add(removeButton());
		return panel;
	}

	private JButton addButton() {
		JButton add = new JButton("Añadir");
		add.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (selectedTable != -1) {
					
				}
			}
		});
		return add;
	}

	private JButton editButton() {
		JButton edit = new JButton("Editar");
		edit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

			}
		});
		return edit;
	}

	private JButton removeButton() {
		JButton remove = new JButton("Borrar");
		remove.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

			}
		});
		return remove;
	}

	private int selectedTable = -1;
	private GUIController restController;
	private MesaInfo[] mesas;
	private JTextArea textoComanda;
}
