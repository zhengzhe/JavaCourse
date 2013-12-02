package cn.nbcc.chap03.tasks;
import java.text.DecimalFormat;


/**
 * ʱ����
 * @author ֣��
 *
 */
public class Time {
	/**Сʱ*/
	private int hour;
	/**����*/
	private int minute;
	/**��*/
	private int second;

	
	public Time() {
		setTime(0, 0, 0);
	}
	public Time(int h){
		setTime(h,0,0);
	}
	public Time(int h,int m){
		setTime(h, m, 0);
	}
	public Time(int h,int m,int s){
		setTime(h, m, s);
	}
	
	/**
	 * 
	 * �趨Сʱ
	 * @param h �趨��Сʱ��
	 */
	public void setHour(int h) {
		if (h >= 0 && h < 24) {
			hour = h;
		}
	}

	public void setMinute(int m) {
		if (m >= 0 && m < 60) {
			minute = m;
		}
	}

	public void setSecond(int s) {
		if (s >= 0 && s < 60) {
			second = s;
		}
	}

	void tick() {
		second = (second+1)%60;
		if (second == 0) {
			minute = (minute+1)%60;
			if (minute==0) {
				hour = (hour+1)%24;
			}
		}
	}

	String toMiliString() {
		
		int h = (hour==0||hour==12)?12:hour%12;
		
		String subfix = hour>=12?"PM":"AM";
		
		DecimalFormat twoDigits = new DecimalFormat("00");
		
		
		return twoDigits.format(h)+":"+twoDigits.format(minute)+":"+twoDigits.format(second)+" "+subfix;
	}

	String toStdString() {
		DecimalFormat twoDigits = new DecimalFormat("00");

		return twoDigits.format(hour) + ":" + twoDigits.format(minute) + ":"
				+ twoDigits.format(second);
	}

	/**
	 * <b>��������:</b>����û��ṩ�ģ�ʱ���֣��룩����ʱ��
	 * @param h �趨��ʱ��
	 * @param m �趨�ķ���
	 * @param s �趨������
	 * @return û�з���ֵ
	 * @see #setHour(int)
	 * @see #setMinute(int)
	 * @see #setSecond(int)
	 * @author ֣��
	 */
	public void setTime(int h, int m, int s) {
		setHour(h);
		setMinute(m);
		setSecond(s);
	}
}
