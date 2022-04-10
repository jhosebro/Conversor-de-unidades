package Pregunta2;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputMethodEvent;
import java.awt.event.InputMethodListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.Choice;
import java.awt.Color;
import java.awt.Font;
import javax.swing.SwingConstants;

public class interfaz extends JFrame implements ItemListener {
	
	Choice choice;
	Choice choice_1;
	JLabel lblNewLabel_2;
	JTextArea textArea;
	JButton btnNewButton;
	double v1, v2; 
	double resultado;
	String conversion;

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					interfaz frame = new interfaz();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public interfaz() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Conversor de unidades");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel.setBounds(117, 13, 203, 27);
		contentPane.add(lblNewLabel);
		
		JLabel lblA = new JLabel("a");
		lblA.setHorizontalAlignment(SwingConstants.CENTER);
		lblA.setBounds(206, 82, 20, 27);
		contentPane.add(lblA);
		
		textArea = new JTextArea();
		textArea.setBounds(152, 51, 131, 20);
		contentPane.add(textArea);
		
		lblNewLabel_2 = new JLabel("La conversion da: %Numero + terminologia");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setBounds(56, 143, 332, 27);
		lblNewLabel_2.setVisible(false);
		contentPane.add(lblNewLabel_2);
		
		choice = new Choice();
		choice.addItem("Seleccionar");
		choice.addItem("kilos");
		choice.addItem("libras");
		choice.addItem("gramos");
		choice.addItem("metros");
		choice.addItem("centimetros");
		choice.setBounds(10, 84, 135, 20);
		contentPane.add(choice);
		
		choice_1 = new Choice();
		choice_1.addItem("Seleccionar");
		choice_1.addItem("kilos");
		choice_1.addItem("libras");
		choice_1.addItem("gramos");
		choice_1.addItem("metros");
		choice_1.addItem("centimetros");
		choice_1.setBackground(Color.WHITE);
		choice_1.setBounds(289, 84, 135, 20);
		contentPane.add(choice_1);
		
		btnNewButton = new JButton("Limpiar campos");
		btnNewButton.setVisible(false);
		btnNewButton.setBounds(152, 187, 131, 23);
		contentPane.add(btnNewButton);
		
		btnNewButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				textArea.setText("");
				lblNewLabel_2.setText("Ingrese un valor en el campo de texto");
				btnNewButton.setVisible(false);
				choice.select(0);
				choice_1.select(0);
			}
		});
		
		textArea.addKeyListener(new KeyListener() {
			
			@Override
			public void keyTyped(KeyEvent e) {
				lblNewLabel_2.setVisible(false);
			}
			
			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		choice.addItemListener(this);
		choice_1.addItemListener(this);
		
		if(textArea.getText().equals("")) {
			lblNewLabel_2.setText("Debe ingresar un valor en el campo de texto");
			lblNewLabel_2.setVisible(true);
		}
	}

	@Override
	public void itemStateChanged(ItemEvent e) {
		if(textArea.getText().equals("")) {
			lblNewLabel_2.setText("Debe ingresar un valor en el campo de texto");
			lblNewLabel_2.setVisible(true);
		}
		if(choice.getSelectedItem() == choice_1.getSelectedItem()) 
		{
			lblNewLabel_2.setText("Debe de seleccionar unidades validas");
			lblNewLabel_2.setVisible(true);
		}
		
		
		//Kilos
		if(choice.getSelectedItem().equals("kilos") && choice_1.getSelectedItem().equals("libras")) 
		{
			v1 = Integer.parseInt(textArea.getText());
			resultado = v1 * 2.20462;
			conversion = choice_1.getSelectedItem();
			lblNewLabel_2.setText("El resultado de la conversion es: " + String.format("%.4f", resultado) + " " + conversion);
			lblNewLabel_2.setVisible(true);
			btnNewButton.setVisible(true);
			
		}
		if(choice.getSelectedItem().equals("kilos") && choice_1.getSelectedItem().equals("gramos")) 
		{
			v1 = Integer.parseInt(textArea.getText());
			resultado = v1 * 1000;
			conversion = choice_1.getSelectedItem();
			lblNewLabel_2.setText("El resultado de la conversion es: " + String.format("%.4f", resultado) + " " + conversion);
			lblNewLabel_2.setVisible(true);
			btnNewButton.setVisible(true);
			
		}
		
		if((choice.getSelectedItem().equals("kilos") && choice_1.getSelectedItem().equals("metros")) || (choice.getSelectedItem().equals("kilos") && choice_1.getSelectedItem().equals("centimetros"))) 
		{
			lblNewLabel_2.setText("No puede hacer este tipo de conversion");
			lblNewLabel_2.setVisible(true);
			
		}
		
		//Libras
		if(choice.getSelectedItem().equals("libras") && choice_1.getSelectedItem().equals("kilos")) 
		{
			v1 = Integer.parseInt(textArea.getText());
			resultado = v1 / 2.20462;
			conversion = choice_1.getSelectedItem();
			lblNewLabel_2.setText("El resultado de la conversion es: " + String.format("%.4f", resultado) + " " + conversion);
			lblNewLabel_2.setVisible(true);
			btnNewButton.setVisible(true);
			
		}
		if(choice.getSelectedItem().equals("libras") && choice_1.getSelectedItem().equals("gramos")) 
		{
			v1 = Integer.parseInt(textArea.getText());
			resultado = v1 * 453.592;
			conversion = choice_1.getSelectedItem();
			lblNewLabel_2.setText("El resultado de la conversion es: " + String.format("%.4f", resultado) + " " + conversion);
			lblNewLabel_2.setVisible(true);
			btnNewButton.setVisible(true);
			
		}
		
		if((choice.getSelectedItem().equals("libras") && choice_1.getSelectedItem().equals("metros")) || (choice.getSelectedItem().equals("libras") && choice_1.getSelectedItem().equals("centimetros"))) 
		{
			lblNewLabel_2.setText("No puede hacer este tipo de conversion");
			lblNewLabel_2.setVisible(true);
			
		}
		
		//Gramos
		if(choice.getSelectedItem().equals("gramos") && choice_1.getSelectedItem().equals("kilos")) 
		{
			v1 = Integer.parseInt(textArea.getText());
			resultado = v1 * 0.001;
			conversion = choice_1.getSelectedItem();
			lblNewLabel_2.setText("El resultado de la conversion es: " + String.format("%.4f", resultado) + " " + conversion);
			lblNewLabel_2.setVisible(true);
			btnNewButton.setVisible(true);
			
		}
		if(choice.getSelectedItem().equals("gramos") && choice_1.getSelectedItem().equals("libras")) 
		{
			v1 = Integer.parseInt(textArea.getText());
			resultado = v1 * 0.00220462;
			conversion = choice_1.getSelectedItem();
			lblNewLabel_2.setText("El resultado de la conversion es: " + String.format("%.4f", resultado) + " " + conversion);
			lblNewLabel_2.setVisible(true);
			btnNewButton.setVisible(true);
			
		}
		
		if((choice.getSelectedItem().equals("gramos") && choice_1.getSelectedItem().equals("metros")) || (choice.getSelectedItem().equals("gramos") && choice_1.getSelectedItem().equals("centimetros"))) 
		{
			lblNewLabel_2.setText("No puede hacer este tipo de conversion");
			lblNewLabel_2.setVisible(true);
			
		}
		
		
		//Metros
		
		if(choice.getSelectedItem().equals("metros") && choice_1.getSelectedItem().equals("centimetros")) 
		{
			v1 = Integer.parseInt(textArea.getText());
			resultado = v1 * 100;
			conversion = choice_1.getSelectedItem();
			lblNewLabel_2.setText("El resultado de la conversion es: " + String.format("%.0f", resultado) + " " + conversion);
			lblNewLabel_2.setVisible(true);
			btnNewButton.setVisible(true);
			
		}
		
		if((choice.getSelectedItem().equals("metros") && choice_1.getSelectedItem().equals("kilos")) || (choice.getSelectedItem().equals("metros") && choice_1.getSelectedItem().equals("libras") || (choice.getSelectedItem().equals("metros") && choice_1.getSelectedItem().equals("gramos")))) 
		{
			lblNewLabel_2.setText("No puede hacer este tipo de conversion");
			lblNewLabel_2.setVisible(true);
			
		}
		
		//Centimetros
		if(choice.getSelectedItem().equals("centimetros") && choice_1.getSelectedItem().equals("metros")) 
		{
			v1 = Integer.parseInt(textArea.getText());
			resultado = v1 * 0.01;
			conversion = choice_1.getSelectedItem();
			lblNewLabel_2.setText("El resultado de la conversion es: " + String.format("%.2f", resultado) + " " + conversion);
			lblNewLabel_2.setVisible(true);
			btnNewButton.setVisible(true);
			
		}
		
		if((choice.getSelectedItem().equals("centimetros") && choice_1.getSelectedItem().equals("kilos")) || (choice.getSelectedItem().equals("centimetros") && choice_1.getSelectedItem().equals("libras") || (choice.getSelectedItem().equals("centimetros") && choice_1.getSelectedItem().equals("gramos")))) 
		{
			lblNewLabel_2.setText("No puede hacer este tipo de conversion");
			lblNewLabel_2.setVisible(true);
			
		}
	}
}
