import application.JspPanel;
import application.PhpPanel;
import application.textPanel;
import config.Demos;

import javax.swing.*;
import java.io.FileInputStream;
import java.util.Properties;

public  class Run {

    public static void main(String[] args) throws Exception{

        new Run().init();
        new Run().loadini();
    }

    public void init(){

        JFrame jFrame = new JFrame("XG拟态_V1.6 请勿用于非法用途");
        jFrame.setLayout(new BoxLayout(jFrame, BoxLayout.Y_AXIS));

        JTabbedPane jTabbedPane = new JTabbedPane(1);

        JPanel phpPanel = new PhpPanel().Phpinit();
        JPanel javaPanel = new JspPanel().Jspinit();
        JPanel textPanel = new textPanel().textinit();
        jTabbedPane.addTab("PHP",phpPanel);
        jTabbedPane.addTab("JSP",javaPanel);
        jTabbedPane.addTab("更新记录",textPanel);

        jFrame.setContentPane(jTabbedPane);

        jFrame.setSize(1200,800);
        jFrame.setVisible(true);
        jFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    public void loadini() throws Exception{
        Properties p = new Properties();
        FileInputStream inifile = new FileInputStream("./XG_NTAI.properties");
        p.load(inifile);
        Demos.test = p.getProperty("test");
        Demos.jspdemo3 = p.getProperty("jspdemo3");
        Demos.jspdemo4 = p.getProperty("jspdemo4");
        Demos.jspdemo5 = p.getProperty("jspdemo5");
        Demos.jspdemo6 = p.getProperty("jspdemo6");
        Demos.jspdemo7 = p.getProperty("jspdemo7");

        Demos.phpdemo7 = p.getProperty("phpdemo7");
    }

}
