package cn.nbcc.chap03.snippets;

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

public class TimeUIApp02 {

	protected Shell shell;
	private Text hourText;
	private Text minuteText;
	private Text secondText;
	private Text stdText;
	private Text miliText;

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
		
		//TODO:01添加�?��语句创建调用名为createTime的私有方�?
		shell.open();
		shell.layout();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	private void createTime() {

		//TODO:02添加�?��语句，根据自定义Time类创建一个时间对象，并制定时间为23:59:50，保存到引用变量t�?
		//TODO:03创建�?��Timer计时器对象，保存到引用变量timer�?
		
		GregorianCalendar calendar = new GregorianCalendar();
		final Time t1 = new Time(calendar.get(Calendar.HOUR_OF_DAY),
				calendar.get(Calendar.MINUTE), calendar.get(Calendar.SECOND));

		TimerTask task = new TimerTask() {

			@Override
			public void run() {
				//TODO:04调用时间对象的tick，以便每秒周期�?执行它�?
				Display.getDefault().asyncExec(new Runnable() {
					@Override
					public void run() {
						//TODO:05写两条语句，将时间对象的信息以标准格式和军用格式分别显示到相应的对话框中
					}
				});

			}
		};
		
		//TODO:06写一条语句，让定时器每隔1秒执行task任务
	}

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
