import application.JspPanel;
import application.PhpPanel;
import application.textPanel;

import javax.swing.*;

public class Run {
    public static void main(String[] args) {

        new Run().init();
    }

    public void init(){

        JFrame jFrame = new JFrame("XG拟态_V1.2  by:XG小刚");
        jFrame.setLayout(new BoxLayout(jFrame, BoxLayout.Y_AXIS));

        JTabbedPane jTabbedPane = new JTabbedPane(1);

        JPanel phpPanel = new PhpPanel().Phpinit();
        JPanel javaPanel = new JspPanel().Jspinit();
        JPanel textPanel = new textPanel().textinit();
        jTabbedPane.addTab("PHP",phpPanel);
        jTabbedPane.addTab("JSP",javaPanel);
        jTabbedPane.addTab("更新记录",textPanel);

        jFrame.setContentPane(jTabbedPane);

        jFrame.setSize(1000,800);
        jFrame.setVisible(true);
        jFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

}
