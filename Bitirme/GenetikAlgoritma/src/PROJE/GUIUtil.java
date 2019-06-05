package PROJE;

/**
 * ����һ��gui�Ĺ����࣬��Ҫ������ͼ�δ���������Ļ������
 */
import java.awt.Component;
import java.awt.GraphicsEnvironment;
import java.awt.Rectangle;

public class GUIUtil {

	public static void toCenter(Component comp) {
		GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
		Rectangle rec = ge.getDefaultScreenDevice().getDefaultConfiguration().getBounds();
		comp.setLocation(((int) rec.getWidth() - comp.getWidth()) / 2, ((int) rec.getHeight() - comp.getHeight()) / 2);
	}

}
