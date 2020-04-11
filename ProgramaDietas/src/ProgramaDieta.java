
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Enumeration;

import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.SwingConstants;
import javax.swing.JRadioButton;
import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;

public class ProgramaDieta extends JFrame implements ActionListener{
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtFAltura;
	private JTextField txtfPeso;
	private JButton btnCalcularImc;
	private JLabel lblResulImc;
	private JLabel lblEqImc;
	private JRadioButton rdbtnMujer;
	private JRadioButton rdbtnHombre;
	private final ButtonGroup buttonGroupSexo = new ButtonGroup();
	private JTextField txtEdad;
	private JRadioButton rdbtnPoco;
	private JRadioButton rdbtnLigero;
	private final ButtonGroup buttonGroupActividad = new ButtonGroup();
	private JRadioButton rdbtnFuerte;
	private JRadioButton rdbtnMuyFuerte;
	private JRadioButton rdbtnModerado;
	private JLabel lblKcal;
	private JButton btnReiniciar;
	private JButton btnLimpiar;
	private JButton btnCalcularKcal;
	private String textRbtnSelecc;	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ProgramaDieta frame = new ProgramaDieta();
					frame.setVisible(true);
					frame.setTitle("Cálculo Dietético-Calórico");
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public ProgramaDieta() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);		
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		setPreferredSize(new Dimension(532, 461));		
		Dimension pantalla = Toolkit.getDefaultToolkit().getScreenSize();		
		Dimension ventana = this.getPreferredSize();	//Tomamos las dimensiones de la pantalla para centrar la ventana	
		setLocation((pantalla.width - ventana.width) / 2, (pantalla.height - ventana.height) / 2);		
		pack();
		
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblAltura = new JLabel("Altura (metros):");
		lblAltura.setForeground(new Color(0, 102, 102));
		lblAltura.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblAltura.setBounds(20, 22, 117, 26);
		contentPane.add(lblAltura);
		
		txtFAltura = new JTextField();
		txtFAltura.setHorizontalAlignment(SwingConstants.CENTER);
		txtFAltura.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtFAltura.setBounds(125, 23, 66, 24);
		contentPane.add(txtFAltura);
		txtFAltura.setColumns(10);
		
		JLabel labelPeso = new JLabel("Peso (kg):");
		labelPeso.setForeground(new Color(153, 0, 0));
		labelPeso.setFont(new Font("Tahoma", Font.PLAIN, 14));
		labelPeso.setBounds(213, 22, 74, 26);
		contentPane.add(labelPeso);
		
		txtfPeso = new JTextField();
		txtfPeso.setHorizontalAlignment(SwingConstants.CENTER);
		txtfPeso.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtfPeso.setColumns(10);
		txtfPeso.setBounds(285, 24, 66, 24);
		contentPane.add(txtfPeso);
		
		btnCalcularImc = new JButton("Calcular IMC");
		btnCalcularImc.setBackground(new Color(153, 255, 255));
		btnCalcularImc.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnCalcularImc.setBounds(371, 23, 124, 24);
		contentPane.add(btnCalcularImc);
		btnCalcularImc.addActionListener(this);
		
		JLabel lblImc = new JLabel("IMC:");
		lblImc.setForeground(new Color(0, 51, 204));
		lblImc.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblImc.setBounds(27, 77, 46, 26);
		contentPane.add(lblImc);
		
		lblResulImc = new JLabel("");
		lblResulImc.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblResulImc.setBounds(66, 77, 58, 26);
		contentPane.add(lblResulImc);
		
		JLabel lblKgm = new JLabel("Kg/m2");
		lblKgm.setHorizontalAlignment(SwingConstants.LEFT);
		lblKgm.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblKgm.setBounds(125, 79, 52, 24);
		contentPane.add(lblKgm);
		
		lblEqImc = new JLabel("");
		lblEqImc.setHorizontalAlignment(SwingConstants.CENTER);
		lblEqImc.setFont(new Font("Verdana", Font.PLAIN, 14));
		lblEqImc.setBounds(171, 77, 204, 26);
		contentPane.add(lblEqImc);
		
		JLabel lblSexo = new JLabel("Sexo:");
		lblSexo.setForeground(new Color(102, 0, 204));
		lblSexo.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblSexo.setBounds(38, 132, 66, 26);
		contentPane.add(lblSexo);
		
		rdbtnHombre = new JRadioButton("Hombre");
		rdbtnHombre.setBackground(Color.WHITE);
		buttonGroupSexo.add(rdbtnHombre);
		rdbtnHombre.setForeground(new Color(0, 51, 255));
		rdbtnHombre.setFont(new Font("Tahoma", Font.PLAIN, 14));
		rdbtnHombre.setBounds(102, 134, 89, 23);
		contentPane.add(rdbtnHombre);
		
		rdbtnMujer = new JRadioButton("Mujer");
		rdbtnMujer.setBackground(Color.WHITE);
		buttonGroupSexo.add(rdbtnMujer);
		rdbtnMujer.setForeground(new Color(255, 0, 255));
		rdbtnMujer.setFont(new Font("Tahoma", Font.PLAIN, 14));
		rdbtnMujer.setBounds(187, 134, 74, 23);
		contentPane.add(rdbtnMujer);
		
		JLabel lblEdad = new JLabel("Edad:");
		lblEdad.setForeground(new Color(102, 51, 51));
		lblEdad.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblEdad.setBounds(280, 132, 46, 26);
		contentPane.add(lblEdad);
		
		txtEdad = new JTextField();
		txtEdad.setHorizontalAlignment(SwingConstants.CENTER);
		txtEdad.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtEdad.setColumns(10);
		txtEdad.setBounds(325, 134, 74, 24);
		contentPane.add(txtEdad);
		
		JLabel lblFactorDeActividad = new JLabel("Factor de Actividad:");
		lblFactorDeActividad.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblFactorDeActividad.setBounds(38, 220, 139, 26);
		contentPane.add(lblFactorDeActividad);
		
		rdbtnPoco = new JRadioButton("Poco o ningún ejercicio");
		rdbtnPoco.setBackground(Color.WHITE);
		buttonGroupActividad.add(rdbtnPoco);
		rdbtnPoco.setFont(new Font("Tahoma", Font.PLAIN, 13));
		rdbtnPoco.setBounds(187, 184, 177, 23);
		contentPane.add(rdbtnPoco);
		
		rdbtnLigero = new JRadioButton("Ejercicio ligero (1-3 días/semana)");
		rdbtnLigero.setBackground(Color.WHITE);
		buttonGroupActividad.add(rdbtnLigero);
		rdbtnLigero.setFont(new Font("Tahoma", Font.PLAIN, 13));
		rdbtnLigero.setBounds(187, 210, 246, 23);
		contentPane.add(rdbtnLigero);
		
		rdbtnModerado = new JRadioButton("Ejercicio moderado (3-5 días/semana)");
		rdbtnModerado.setBackground(Color.WHITE);
		buttonGroupActividad.add(rdbtnModerado);
		rdbtnModerado.setFont(new Font("Tahoma", Font.PLAIN, 13));
		rdbtnModerado.setBounds(187, 236, 268, 23);
		contentPane.add(rdbtnModerado);
		
		rdbtnFuerte = new JRadioButton("Ejercicio fuerte (6-7 días/semana)");
		rdbtnFuerte.setBackground(Color.WHITE);
		buttonGroupActividad.add(rdbtnFuerte);
		rdbtnFuerte.setFont(new Font("Tahoma", Font.PLAIN, 13));
		rdbtnFuerte.setBounds(187, 262, 268, 23);
		contentPane.add(rdbtnFuerte);
		
		rdbtnMuyFuerte = new JRadioButton("Ejercicio muy fuerte (2/día, entrenamiento intenso)");
		rdbtnMuyFuerte.setBackground(Color.WHITE);
		buttonGroupActividad.add(rdbtnMuyFuerte);
		rdbtnMuyFuerte.setFont(new Font("Tahoma", Font.PLAIN, 13));
		rdbtnMuyFuerte.setBounds(187, 288, 331, 23);
		contentPane.add(rdbtnMuyFuerte);
		
		JLabel lblTMB = new JLabel("<HTML><U>Tasa Metabólica Basal + Factor de Actividad:</U></HTML>");
		lblTMB.setForeground(new Color(255, 102, 0));
		lblTMB.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblTMB.setBounds(29, 354, 310, 26);
		contentPane.add(lblTMB);
		
		btnLimpiar = new JButton("Limpiar");
		btnLimpiar.setBackground(new Color(255, 255, 204));
		btnLimpiar.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnLimpiar.setBounds(403, 77, 89, 26);
		contentPane.add(btnLimpiar);
		btnLimpiar.addActionListener(this);
		
		lblKcal = new JLabel("");
		lblKcal.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblKcal.setBounds(337, 354, 74, 26);
		contentPane.add(lblKcal);
		
		JLabel lblKcalDia = new JLabel("Kcal/día");
		lblKcalDia.setHorizontalAlignment(SwingConstants.LEFT);
		lblKcalDia.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblKcalDia.setBounds(401, 355, 74, 26);
		contentPane.add(lblKcalDia);
		
		btnReiniciar = new JButton("Reiniciar");
		btnReiniciar.setBackground(new Color(255, 255, 153));
		btnReiniciar.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnReiniciar.setBounds(223, 388, 89, 23);
		contentPane.add(btnReiniciar);
		btnReiniciar.addActionListener(this);
		
		btnCalcularKcal = new JButton("Calcular Kcal");
		btnCalcularKcal.setBackground(new Color(153, 255, 153));
		btnCalcularKcal.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnCalcularKcal.setBounds(20, 317, 147, 26);
		contentPane.add(btnCalcularKcal);
		
		JLabel lblEcuacinDeHarrisbenedict = new JLabel("Ecuación de Harris-Benedict");
		lblEcuacinDeHarrisbenedict.setForeground(new Color(204, 102, 0));
		lblEcuacinDeHarrisbenedict.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblEcuacinDeHarrisbenedict.setBounds(213, 318, 177, 25);
		contentPane.add(lblEcuacinDeHarrisbenedict);
		btnCalcularKcal.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if (e.getSource() == btnCalcularImc) {			
			if (comprobarDatosImc()) {				
				double altPeso [] = comprobarConvertir();
				if (altPeso != null) {
					double IMC = (altPeso[1] / Math.pow(altPeso[0], 2)); //Posición 0 es la altura en metros y 0 es el peso
					
					IMC = Math.round(IMC * 100.0) / 100.0; //Redondeamos a 2 decimales
					lblResulImc.setText(String.valueOf(IMC));
					mostrarEquivalencia(IMC);				
				}
			} else {
				JOptionPane.showMessageDialog(this, "Se deben rellenar los campos", "Error", JOptionPane.WARNING_MESSAGE);
			}			
		} else if (e.getSource() == btnCalcularKcal) {
			if (comprobarDatosKcal()) {
				double altPeso [] = comprobarConvertir();
				if (altPeso != null) {
					
					String sexo = textRbtnSelecc; //Es el último rdBtngroup que se analizó
					int edad = Integer.parseInt(txtEdad.getText().trim());
					
					double factorActividad = comprobarFactorAct();
					double Tmb = 0;
					
					if (sexo.equals("Hombre")) Tmb = (10 * altPeso[1]) + (6.25 * (altPeso[0] * 100)) - (5 * edad) + 5;
					else Tmb = (10 * altPeso[1]) + (6.25 * (altPeso[0] * 100)) - (5 * edad) - 161;
					
					double tmbxActiv = Tmb * factorActividad;
					tmbxActiv = Math.round(tmbxActiv * 100.0) / 100.0;
					lblKcal.setText(String.valueOf(tmbxActiv));
				}
				
				
			} else {
				JOptionPane.showMessageDialog(this, "Se deben rellenar todos los campos", "Error", JOptionPane.WARNING_MESSAGE);
			}
			
		} else if (e.getSource() == btnLimpiar) {
			limpiarCampos(false); //limpiamos sólo los campos relativos al IMC
		} else if (e.getSource() == btnReiniciar) {
			limpiarCampos(true); //limpiamos todos los campos
		}		
	}	

	private double comprobarFactorAct() {
		getSelectBtnTxt(buttonGroupActividad);
		String gradoAct = textRbtnSelecc;
		double factorActividad = 0;
		
		switch (gradoAct) {
		case "Poco o ningún ejercicio":
			factorActividad = 1.2;
			break;
		case "Ejercicio ligero (1-3 días/semana)":
			factorActividad = 1.375;
			break;
		case "Ejercicio moderado (3-5 días/semana)":
			factorActividad = 1.55;
			break;
		case "Ejercicio fuerte (6-7 días/semana)":
			factorActividad = 1.725;
			break;
		case "Ejercicio muy fuerte (2/día, entrenamiento intenso)":
			factorActividad = 1.9;
			break;
		}		
		return factorActividad;
	}

	private boolean comprobarDatosKcal() {
		boolean datosOk = false;		
		
		if (!txtEdad.getText().trim().isEmpty() & !txtFAltura.getText().trim().isEmpty() & !txtfPeso.getText().trim()
				.isEmpty() & getSelectBtnTxt(buttonGroupActividad) & getSelectBtnTxt(buttonGroupSexo)) {
			datosOk = true;
		}
		
		if (datosOk & comprobarDatosImc()) return true;
		else return false;			
	}

	private void limpiarCampos(boolean b) {	
		txtFAltura.setText("");
		txtfPeso.setText("");
		lblResulImc.setText("");
		lblEqImc.setText("");
		if (b) {
			buttonGroupSexo.clearSelection();
			txtEdad.setText("");
			buttonGroupActividad.clearSelection();
			lblKcal.setText("");
		}		
	}

	private double[] comprobarConvertir() { //Refactorizamos las conversiones necesarias de los strings a double
		double alturaPeso [] = null;
		try {
			String altura = txtFAltura.getText().trim();
			if (altura.contains(",")) altura = altura.replace(',', '.');		
			double alt = Double.parseDouble(altura);
			
			String peso = txtfPeso.getText().trim();
			if (peso.contains(",")) peso = peso.replace(',', '.');		
			double pes = Double.parseDouble(peso);
			
			alturaPeso = new double []{alt, pes};		
		} catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(this, "Los datos deben ser numéricos", "Error", JOptionPane.ERROR_MESSAGE);
		}		
		return alturaPeso;
	}

	private boolean comprobarDatosImc() {
		if (txtFAltura.getText().trim().isEmpty() | txtfPeso.getText().trim().isEmpty()) {			
			return false;
		} else {			
			return true;
		}		
	}
	private boolean getSelectBtnTxt(ButtonGroup btnGroup) { //Comprobamos si en ese radiobtngroup hay alguno seleccionado
		boolean btnSelect = false;
        for (Enumeration<AbstractButton> botones = btnGroup.getElements(); botones.hasMoreElements();) {
            AbstractButton radiobutton = botones.nextElement();
            if (radiobutton.isSelected()) {
            	btnSelect = true;
            	textRbtnSelecc = radiobutton.getText();                
            }
        }       
        return btnSelect;        
    }
	
	private void mostrarEquivalencia(double IMC) { //Según el IMC mostramos la equivalencia del color correspondiente
		String textoImc = "";
		Color color = null;
		if (IMC > 10 & IMC < 17) {
			textoImc = "Delgadez Extrema";
			color = new Color(153, 0, 102);
		} else if (IMC >= 17 & IMC <= 18.5) {
			textoImc = "Delgadez";
			color = new Color(51, 204, 51);
		} else if (IMC > 18.5 & IMC <= 24.99) {
			textoImc = "Normalidad";
			color = new Color(51, 255, 0);
		}else if (IMC >= 25 & IMC <= 29.99) {
			textoImc = "Sobrepeso";
			color = new Color(255, 102, 51);
		}else if (IMC >= 30 & IMC <= 34.99) {
			textoImc = "Obesidad tipo I";
			color = new Color(255, 153, 0);
		} else if (IMC >= 35 & IMC <= 39.99) {
			textoImc = "Obesidad tipo II";
			color = new Color(255, 51, 0);
		} else if (IMC >= 40 & IMC < 100) {
			textoImc = "Obesidad tipo III (mórbida)";
			color = new Color(255, 0, 0);
		} 
		
		lblEqImc.setForeground(color);
		lblEqImc.setText(textoImc);		
	}
}
