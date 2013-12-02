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
 * �ĵ���:GuessGameApp.java ����ʱ��:2010-6-2
 * ������Ŀ:Chap03�¼۸���Ϸ
 * ����:֣��
 * copyright 2010 ��������ְҵ����ѧԺ��Ȩ����
 */

/**
 * @author ֣��
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
		label.setText("�����¼۸�:");

		priceText = new Text(container, SWT.BORDER);
		priceText.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));

		button = new Button(container, SWT.NONE);
		button.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(final SelectionEvent e) {
			
				//TODO: 01 ���һ����䣬����һ�����ڱ���²�۸�����ͱ���guessPrice������ʼ��Ϊ0


				try {
					//TODO:02���һ�д��룬�����ı����ֵ��ת�����������ͣ������浽guessPrice��
				} catch (NumberFormatException nfe) {
					MessageDialog.openConfirm(getShell(), "��ʽ����", "��������ָ�ʽ����ȷ��������");
					return;
				}
				//TODO:03���һ�δ��룬�ȶԼ۸������Ӧ��Ϣ
			
				//TODO:04���һ�д��룬��list�б���������ʷ��Ϣ
				
				
				count ++;
				//TODO: 05��������߼��ж�����
				if (true/*�²�������*/) {
					getStatusLineManager().setMessage("��Ϸʧ��");
					enableInput(false);
				}
			}
		});
		button.setText("ȷ��");

		final Label label_1 = new Label(container, SWT.NONE);
		label_1.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, false, false, 3, 1));
		label_1.setText("�²�۸���ʷ��¼:");

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

		newGameAction = new Action("����Ϸ") {
			

			public void run() {
				
				//TODO:06���һ����䣬��Math.random��������۸񣬱��浽randomPrice��
				//lowPrice�б��������öԻ����е���ͼ۸�highPrice�б��������öԻ����е���߼۸�


				
				getStatusLineManager().setMessage(randomPrice+"");
				//�����ı���Ͱ�ť
				enableInput(true);
				//����б����ı���
				list.removeAll();
				priceText.setText("");
				//����count
				count = 0;
			}
		};
		newGameAction.setAccelerator(SWT.CTRL | 'N');
		newGameAction.setToolTipText("����һ������Ϸ");
		newGameAction.setImageDescriptor(ResourceManager.getImageDescriptor(GuessGameApp.class, "/etool16/newjworkingSet_wiz.gif"));

		settingAction = new Action("��Ϸ����") {
			public void run() {
				new ConfigDialog(getShell()).open();
			}
		};
		settingAction.setAccelerator(SWT.CTRL | SWT.SHIFT | 'C');
		settingAction.setToolTipText("������Ϸ��������");
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

		final MenuManager menuManager_1 = new MenuManager("����");
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
		newShell.setText("�¼۸���Ϸ");
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
