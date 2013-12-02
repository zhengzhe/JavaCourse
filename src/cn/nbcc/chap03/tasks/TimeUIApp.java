package cn.nbcc.chap03.tasks;

import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Timer;
import java.util.TimerTask;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Group;

import com.ibm.icu.util.Calendar;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

public class TimeUIApp {

	protected Shell shell;
	private Text hourText;
	private Text minuteText;
	private Text secondText;
	private Text stdText;
	private Text miliText;
	private Time t;

	/**
	 * Launch the application.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			TimeUIApp window = new TimeUIApp();
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
		createTime();
		shell.open();
		shell.layout();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	private void createTime() {
		t = new Time(22, 30, 23);		
		Timer timer = new Timer();
		TimerTask task = new TimerTask() {
			@Override
			public void run() {
				t.tick();
				Display.getDefault().asyncExec(new Runnable() {
					@Override
					public void run() {
						miliText.setText(t.toMiliString());
						stdText.setText(t.toStdString());
					}
				});
			}
		};
		timer.schedule(task, 0, 1000);
	}

//	GregorianCalendar calendar = new GregorianCalendar();
//	final Time t1 = new Time(calendar.get(Calendar.HOUR_OF_DAY),
//			calendar.get(Calendar.MINUTE), calendar.get(Calendar.SECOND));
	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		
		
		shell = new Shell();
		shell.setSize(450, 225);
		shell.setText("时钟应用程序");
		GridLayout gl_shell = new GridLayout(3, false);
		shell.setLayout(gl_shell);

		Label hourLabel = new Label(shell, SWT.NONE);
		hourLabel.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false,
				1, 1));
		hourLabel.setText("小时:");

		hourText = new Text(shell, SWT.BORDER);
		hourText.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));

		Button btn1 = new Button(shell, SWT.NONE);
		btn1.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				t.setHour(Integer.parseInt(hourText.getText()));
			}
		});	
		btn1.setText("设定");

		Label minuteLabel = new Label(shell, SWT.NONE);
		minuteLabel.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false,
				1, 1));
		minuteLabel.setText("分钟:");

		minuteText = new Text(shell, SWT.BORDER);
		minuteText.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1,
				1));

		Button btn2 = new Button(shell, SWT.NONE);
		btn2.setText("设定");

		Label secondLabel = new Label(shell, SWT.NONE);
		secondLabel.setText("秒钟:");

		secondText = new Text(shell, SWT.BORDER);
		secondText.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1,
				1));

		Button btn3 = new Button(shell, SWT.NONE);
		btn3.setText("设定");

		Group group = new Group(shell, SWT.NONE);
		group.setText("数字显示区域");
		group.setLayout(new GridLayout(2, false));
		group.setLayoutData(new GridData(SWT.FILL, SWT.FILL, false, true, 3, 1));

		Label stdLabel = new Label(group, SWT.NONE);
		stdLabel.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false,
				1, 1));
		stdLabel.setText("标准时间:");

		stdText = new Text(group, SWT.BORDER);
		stdText.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false,
				1, 1));

		Label miliLabel = new Label(group, SWT.NONE);
		miliLabel.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false,
				1, 1));
		miliLabel.setText("军用时间:");

		miliText = new Text(group, SWT.BORDER);
		miliText.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false,
				1, 1));

	}

}
