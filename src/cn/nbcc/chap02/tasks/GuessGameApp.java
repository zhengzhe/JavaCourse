package cn.nbcc.chap02.tasks;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.MenuManager;
import org.eclipse.jface.action.StatusLineManager;
import org.eclipse.jface.action.ToolBarManager;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.window.ApplicationWindow;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.List;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import com.swtdesigner.ResourceManager;
import com.swtdesigner.SWTResourceManager;

/**
 * 文档名:GuessGameApp.java 开发时间:2010-6-2
 * 所属项目:Chap03猜价格游戏
 * 作者:郑哲
 * copyright 2010 宁波城市职业技术学院版权所有
 */

/**
 * @author 郑哲
 *
 */
public class GuessGameApp extends ApplicationWindow {

	private List list;
	private Text priceText;
	private Action settingAction;
	private Action newGameAction;
	private int randomPrice;
	private int count;
	private Button button;
	public static int highPrice=100;
	public static int lowPrice=50;
	public static int limitCount=3;
	/**
	 * Create the application window
	 */
	public GuessGameApp() {
		super(null);
		createActions();
		addToolBar(SWT.FLAT | SWT.WRAP);
		addMenuBar();
		addStatusLine();
	}

	/**
	 * Create contents of the application window
	 * @param parent
	 */
	@Override
	protected Control createContents(Composite parent) {
		Composite container = new Composite(parent, SWT.NONE);
		final GridLayout gridLayout = new GridLayout();
		gridLayout.numColumns = 3;
		container.setLayout(gridLayout);

		final Label label = new Label(container, SWT.NONE);
		label.setText("输入新价格:");

		priceText = new Text(container, SWT.BORDER);
		priceText.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));

		button = new Button(container, SWT.NONE);
		button.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(final SelectionEvent e) {
			
				//TODO: 01 添加一行语句，定义一个用于保存猜测价格的整型变量guessPrice，并初始化为0


				try {
					//TODO:02添加一行代码，读入文本框的值，转换成整数类型，并保存到guessPrice中
				} catch (NumberFormatException nfe) {
					MessageDialog.openConfirm(getShell(), "格式错误", "输入的数字格式不正确，请重试");
					return;
				}
				//TODO:03添加一段代码，比对价格，输出相应信息
			
				//TODO:04添加一行代码，向list列表框中添加历史信息
				
				
				count ++;
				//TODO: 05添加下列逻辑判断条件
				if (true/*猜测次数检查*/) {
					getStatusLineManager().setMessage("游戏失败");
					enableInput(false);
				}
			}
		});
		button.setText("确定");

		final Label label_1 = new Label(container, SWT.NONE);
		label_1.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, false, false, 3, 1));
		label_1.setText("猜测价格历史记录:");

		list = new List(container, SWT.BORDER);
		list.setLayoutData(new GridData(SWT.FILL, SWT.FILL, false, true, 3, 1));
		enableInput(false);
		
		//
		return container;
	}

	/**
	 * Create the actions
	 */
	private void createActions() {

		newGameAction = new Action("新游戏") {
			

			public void run() {
				
				//TODO:06添加一行语句，用Math.random生成随机价格，保存到randomPrice中
				//lowPrice中保存了配置对话框中得最低价格，highPrice中保存了配置对话框中得最高价格


				
				getStatusLineManager().setMessage(randomPrice+"");
				//开启文本框和按钮
				enableInput(true);
				//清除列表框和文本框
				list.removeAll();
				priceText.setText("");
				//重置count
				count = 0;
			}
		};
		newGameAction.setAccelerator(SWT.CTRL | 'N');
		newGameAction.setToolTipText("创建一个新游戏");
		newGameAction.setImageDescriptor(ResourceManager.getImageDescriptor(GuessGameApp.class, "/etool16/newjworkingSet_wiz.gif"));

		settingAction = new Action("游戏配置") {
			public void run() {
				new ConfigDialog(getShell()).open();
			}
		};
		settingAction.setAccelerator(SWT.CTRL | SWT.SHIFT | 'C');
		settingAction.setToolTipText("进行游戏参数配置");
		settingAction.setImageDescriptor(ResourceManager.getImageDescriptor(GuessGameApp.class, "/etool16/segment_edit.gif"));
		// Create the actions
	}

	/**
	 * Create the menu manager
	 * @return the menu manager
	 */
	@Override
	protected MenuManager createMenuManager() {
		MenuManager menuManager = new MenuManager("menu");

		final MenuManager menuManager_1 = new MenuManager("操作");
		menuManager.add(menuManager_1);

		menuManager_1.add(newGameAction);

		menuManager_1.add(settingAction);
		return menuManager;
	}

	/**
	 * Create the toolbar manager
	 * @return the toolbar manager
	 */
	@Override
	protected ToolBarManager createToolBarManager(int style) {
		ToolBarManager toolBarManager = new ToolBarManager(style);

		toolBarManager.add(newGameAction);

		toolBarManager.add(settingAction);
		return toolBarManager;
	}

	/**
	 * Create the status line manager
	 * @return the status line manager
	 */
	@Override
	protected StatusLineManager createStatusLineManager() {
		StatusLineManager statusLineManager = new StatusLineManager();
		statusLineManager.setMessage(null, "");
		return statusLineManager;
	}

	/**
	 * Launch the application
	 * @param args
	 */
	public static void main(String args[]) {
		try {
			GuessGameApp window = new GuessGameApp();
			window.setBlockOnOpen(true);
			window.open();
			Display.getCurrent().dispose();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Configure the shell
	 * @param newShell
	 */
	@Override
	protected void configureShell(Shell newShell) {
		super.configureShell(newShell);
		newShell.setText("猜价格游戏");
		newShell.setImage(SWTResourceManager.getImage(GuessGameApp.class, "/etool16/segment_edit.gif"));
		newShell.setSize(215,327);
	}

	/**
	 * Return the initial size of the window
	 */
	@Override
	protected Point getInitialSize() {
		return new Point(215, 327);
	}


	private void enableInput(boolean enable) {
		priceText.setEnabled(enable);
		button.setEnabled(enable);
	}

}
