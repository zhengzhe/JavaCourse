package cn.nbcc.chap02.tasks;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.dialogs.TitleAreaDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.VerifyEvent;
import org.eclipse.swt.events.VerifyListener;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.jdom.Document;
import org.jdom.Element;
import org.jdom.JDOMException;
import org.jdom.input.SAXBuilder;
import org.jdom.output.Format;
import org.jdom.output.XMLOutputter;

import com.swtdesigner.SWTResourceManager;

/**
 * 文档名:ConfigDialog.java 开发时间:2010-6-7
 * 所属项目:Chap03猜价格游戏
 * 作者:郑哲
 * copyright 2010 宁波城市职业技术学院版权所有
 */

/**
 * @author 郑哲
 *
 */
public class ConfigDialog extends TitleAreaDialog implements VerifyListener,ModifyListener {

	private Text limitCountText;
	private Text highPriceText;
	private Text lowPriceText;
	/**
	 * Create the dialog
	 * @param parentShell
	 */
	public ConfigDialog(Shell parentShell) {
		super(parentShell);
		
	}

	/**
	 * 
	 */

	/**
	 * Create contents of the dialog
	 * @param parent
	 */
	@Override
	protected Control createDialogArea(Composite parent) {
		Composite area = (Composite) super.createDialogArea(parent);
		Composite container = new Composite(area, SWT.NONE);
		final GridLayout gridLayout_1 = new GridLayout();
		gridLayout_1.numColumns = 2;
		container.setLayout(gridLayout_1);
		container.setLayoutData(new GridData(GridData.FILL_BOTH));

		final Group group = new Group(container, SWT.NONE);
		group.setText("价格范围设定");
		group.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 2, 1));
		final GridLayout gridLayout = new GridLayout();
		gridLayout.numColumns = 2;
		group.setLayout(gridLayout);

		final Label lowPriceLabel = new Label(group, SWT.NONE);
		lowPriceLabel.setText("最低价格:");

		lowPriceText = new Text(group, SWT.BORDER);
		lowPriceText.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));

		final Label highPriceLabel = new Label(group, SWT.NONE);
		highPriceLabel.setText("最高价格:");

		highPriceText = new Text(group, SWT.BORDER);
		highPriceText.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));

		final Label limitLabel = new Label(container, SWT.NONE);
		limitLabel.setText("次数限制:");

		limitCountText = new Text(container, SWT.BORDER);
		limitCountText.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));
		setTitle("猜价格游戏配置");
		setMessage("对猜价格游戏进行基本配置");
		setTitleImage(SWTResourceManager.getImage(ConfigDialog.class, "/wizban/fixdepr_wiz.png"));
		
		init();
		
		lowPriceText.addVerifyListener(this);
		lowPriceText.addModifyListener(this);
		highPriceText.addVerifyListener(this);
		highPriceText.addModifyListener(this);
		limitCountText.addVerifyListener(this);
		limitCountText.addModifyListener(this);
		//
		return area;
	}

	/**
	 * 初始化对话框中的参数信息
	 */
	private void init() {
//		lowPriceText.setText(GuessGameApp.lowPrice+"");
//		highPriceText.setText(String.valueOf(GuessGameApp.highPrice));
//		limitCountText.setText(String.valueOf(GuessGameApp.limitCount));
		readFromXML();
	}

	/**
	 * 
	 */
	private void readFromXML() {
		SAXBuilder sb = new SAXBuilder();
		Document doc = null;
		File file = new File("./config.xml");
		try {
			doc = sb.build(file);
			if (doc!=null) {
				Element root = doc.getRootElement();
				String hPrice = root.getChild("HighPrice").getText();
				String lPrice = root.getChildText("LowPrice");
				String lCount = root.getChildText("LimitCount");
				lowPriceText.setText(lPrice);
				highPriceText.setText(hPrice);
				limitCountText.setText(lCount);
			}
		} catch (JDOMException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

	/**
	 * Create contents of the button bar
	 * @param parent
	 */
	@Override
	protected void createButtonsForButtonBar(Composite parent) {
		createButton(parent, IDialogConstants.OK_ID, IDialogConstants.OK_LABEL,
				true);
		createButton(parent, IDialogConstants.CANCEL_ID,
				IDialogConstants.CANCEL_LABEL, false);
	}

	/**
	 * Return the initial size of the dialog
	 */
	@Override
	protected Point getInitialSize() {
		return new Point(335, 280);
	}
	protected void configureShell(Shell newShell) {
		super.configureShell(newShell);
		newShell.setImage(SWTResourceManager.getImage(ConfigDialog.class, "etool16/newjworkingSet_wiz.gif"));
	}
	protected void buttonPressed(int buttonId) {
		if (buttonId == IDialogConstants.OK_ID) {
			GuessGameApp.highPrice = Integer.parseInt(highPriceText.getText());
			GuessGameApp.lowPrice = Integer.parseInt(lowPriceText.getText());
			GuessGameApp.limitCount = Integer.parseInt(limitCountText.getText());
			saveToXML();
			saveToTXT();
		}
		super.buttonPressed(buttonId);
	}

	/**
	 * 
	 */
	private void saveToTXT() {
		File file = new File("./config.txt");
		if (!file.exists()) 
		{
			try {
				file.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
			else{
				
				FileWriter writer = null;
				try {
					writer = new FileWriter(file);
				} catch (IOException e) {
					e.printStackTrace();
				}
				BufferedWriter w = new BufferedWriter(writer);
				StringBuilder builder = new StringBuilder();
				builder.append("highPrice="+GuessGameApp.highPrice+"\n");
				builder.append("lowPrice="+GuessGameApp.lowPrice+"\n");
				builder.append("limitCount="+GuessGameApp.limitCount+"\n");
				String bString = builder.toString();
				try {
					w.write(bString);
					w.flush();
				} catch (IOException e) {
					e.printStackTrace();
				}
		}
	}

	/**
	 * 
	 */
	private void saveToXML() {
		Element root = new Element("Game");
		Document document = new Document(root);
		root.addContent(new Element("LowPrice").addContent(GuessGameApp.lowPrice+""));
		root.addContent(new Element("HighPrice").addContent(GuessGameApp.highPrice+""));
		root.addContent(new Element("LimitCount").addContent(GuessGameApp.limitCount+""));
		XMLOutputter output = new XMLOutputter(Format.getPrettyFormat());
		try {
			File file = new File("./config.xml");
			if (!file.exists()) {
				file.createNewFile();
			}
			FileWriter writer = new FileWriter(file);
			output.output(document,writer);
			MessageDialog.openInformation(getShell(), "消息", "配置信息保存成功");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void enableOKButton(boolean enable) {
		getButton(IDialogConstants.OK_ID).setEnabled(enable);
	}

	/* (non-Javadoc)
	 * @see org.eclipse.swt.events.VerifyListener#verifyText(org.eclipse.swt.events.VerifyEvent)
	 */
	@Override
	public void verifyText(VerifyEvent e) {
		//只接受数字和回退
		if ("0123456789".indexOf(e.text)>=0||e.text=="") {
			e.doit=true;
		}else
			e.doit=false;
	}

	@Override
	public void modifyText(ModifyEvent e) {
		String message = null;
		if(limitCountText.getText().length()==0)
			message = "次数限制不能为空";
		else if (lowPriceText.getText().length() == 0||highPriceText.getText().length()==0) {
			message = "价格不能为空";
		} else {
			int lowPrice = Integer.parseInt(lowPriceText.getText());
			int highPrice = Integer.parseInt(highPriceText.getText());
			if (lowPrice > highPrice || lowPrice < 0) {
				message = "无效的参数信息,最高/低价格必须是正整数,且最高价格比最高价格高";
			}
		}
		if(message!=null)
			enableOKButton(false);
		else
			enableOKButton(true);
		setErrorMessage(message);
	}
}
