import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Text;
import org.eclipse.wb.swt.SWTResourceManager;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

public class calculadora_xmorera_22 {

	/////////////// variables /////////////
	protected Shell shell;
	private Text pantalla;
	private String operand1="",operand2="";
	private String operacio="";
	private boolean continuar = false; //variable per controlar si volem encadenar operacions
	private boolean dot=false; //variable per controlar l'entrada de la coma per nombres reals

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			calculadora_xmorera_22 window = new calculadora_xmorera_22();
			window.open();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Open the window.
	 */
	public void open() {
		Display display = Display.getDefault();
		createContents();
		shell.open();
		shell.layout();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		shell = new Shell();
		shell.setSize(450, 300);
		shell.setText("Calculadora ACME");

		pantalla = new Text(shell, SWT.BORDER | SWT.RIGHT);
		pantalla.setBounds(56, 72, 170, 21);


		///////////////botons corresponents als números///////////

		Button btn1 = new Button(shell, SWT.NONE);
		btn1.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				introNum("1");
			}
		});
		btn1.setBounds(56, 176, 38, 25);
		btn1.setText("1");

		Button btn2 = new Button(shell, SWT.NONE);
		btn2.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				introNum("2");
			}
		});
		btn2.setText("2");
		btn2.setBounds(100, 176, 38, 25);

		Button btn3 = new Button(shell, SWT.NONE);
		btn3.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				introNum("3");
			}
		});
		btn3.setText("3");
		btn3.setBounds(144, 176, 38, 25);

		Button btn4 = new Button(shell, SWT.NONE);
		btn4.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				introNum("4");
			}
		});
		btn4.setText("4");
		btn4.setBounds(56, 137, 38, 25);

		Button btn5 = new Button(shell, SWT.NONE);
		btn5.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				introNum("5");
			}
		});
		btn5.setText("5");
		btn5.setBounds(100, 137, 38, 25);

		Button btn6 = new Button(shell, SWT.NONE);
		btn6.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				introNum("6");
			}
		});
		btn6.setText("6");
		btn6.setBounds(144, 137, 38, 25);

		Button btn7 = new Button(shell, SWT.NONE);
		btn7.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				introNum("7");
			}
		});
		btn7.setText("7");
		btn7.setBounds(56, 99, 38, 25);

		Button btn8 = new Button(shell, SWT.NONE);
		btn8.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				introNum("8");
			}	
		});
		btn8.setText("8");
		btn8.setBounds(100, 99, 38, 25);

		Button btn9 = new Button(shell, SWT.NONE);
		btn9.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				introNum("9");
			}
		});
		btn9.setText("9");
		btn9.setBounds(144, 99, 38, 25);

		Button btn0 = new Button(shell, SWT.NONE);
		btn0.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				introNum("0");
			}

		});
		btn0.setText("0");
		btn0.setBounds(56, 212, 38, 25);

		Button btn_dot = new Button(shell, SWT.NONE);
		btn_dot.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				introNum(".");
			}
		});
		btn_dot.setText(".");
		btn_dot.setBounds(100, 212, 38, 25);

		//////////////// botons corresponents a les operacions////////

		Button btn_plus = new Button(shell, SWT.NONE);
		btn_plus.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				introOp("+");
			}
		});
		btn_plus.setText("+");
		btn_plus.setBounds(188, 212, 38, 25);

		Button btn_minus = new Button(shell, SWT.NONE);
		btn_minus.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				introOp("-");
			}
		});
		btn_minus.setText("-");
		btn_minus.setBounds(188, 176, 38, 25);

		Button btn_divide = new Button(shell, SWT.NONE);
		btn_divide.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				introOp("/");
			}
		});
		btn_divide.setText("/");
		btn_divide.setBounds(188, 137, 38, 25);

		Button btn_multiply = new Button(shell, SWT.NONE);
		btn_multiply.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				introOp("x");
			}
		});
		btn_multiply.setText("x");
		btn_multiply.setBounds(188, 99, 38, 25);


		/////////////////// botó de resultat //////////////////
		Button btn_equal = new Button(shell, SWT.NONE);
		btn_equal.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				float num1;
				float num2;
				float resultat=0;
				boolean error=false;

				if(operand1=="" || operand2 =="" || operacio=="") {

				}else {
					dot=false;
					num1= Float.parseFloat(operand1);
					num2= Float.parseFloat(operand2);
					resultat=0;
					switch (operacio) {
					case "+" : resultat=num1+num2;
					break;
					case "-" : resultat= num1-num2;
					break;
					case "x" : resultat= num1*num2;
					break;
					case "/" : 
						if(operand2.equals("0")) {
							error=true;
						}else {
							resultat= num1/num2;		
						}
						break;
					}
					if(error==true) {
						operand2="";
						pantalla.setText("ERROR!:divisió x 0");
						continuar=false;
					} else {
						operand1=String.valueOf(resultat);
						continuar = true;
						operand2="";
						operacio="";
						pantalla.setText(String.valueOf(resultat));

					}
				}
			}
		});
		btn_equal.setText("=");
		btn_equal.setBounds(144, 212, 38, 25);

		Button btn_c = new Button(shell, SWT.NONE);
		btn_c.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {

			}
		});
		btn_c.setText("c");
		btn_c.setBounds(236, 99, 38, 25);


	}

	/////////////////////////////////////////////////////////	
	////////////////// mètodes //////////////////////////////
	/////////////////////////////////////////////////////////

	//mètode per entrar els números a la pantalla i poder operar amb ells
	private void introNum(String num) {

		if (operacio=="") {
			if(continuar) {  //afegim aquesta funció per si volem escriure un número nou enlloc de continuar els càlculs en base a l'últim resultat obtingut
				operand1="";
				continuar=false;
			}
			//ara anem a controlar que un número no tingui zeros a l'esquerra
			if (operand1.equals("0")) {
				operand1=num;
				if(num.equals(".")) {
					operand1="0.";
					dot=true;
				}
			} else {
				if(operand1=="" && num.equals(".")) {
					operand1="0.";
					dot=true;
				}else {
					if(dot) {
						if (num.equals(".")) {

						} else {
							operand1=operand1+num;
						}
					}
					else {
						operand1=operand1+num;
						if(num.equals(".")) {
							dot=true;
						}
					}
				}
			}
			pantalla.setText(operand1);
		} else {
			if (operand2.equals("0")) {
				operand2=num;
				if(num.equals(".")) {
					operand2="0.";
					dot=true;
				}
			} else {
				if(operand2=="" && num.equals(".")) {
					operand2="0.";
					dot=true;
				}else {
					if(dot) {
						if (num.equals(".")) {

						} else {
							operand2=operand2+num;
						}
					}
					else {
						operand2=operand2+num;
						if(num.equals(".")) {
							dot=true;
						}
					}
				}
			}


			pantalla.setText(operand1+operacio+operand2);
		}
	}
	//mètode per introduir l'operació 
	private void introOp(String op) {
		if(operand1 =="") {				//si no hi ha un número a l'operand1 no faig res

		}else {
			operacio=op;
			pantalla.setText(operand1+operacio);
			dot=false;
		}
	}
}
