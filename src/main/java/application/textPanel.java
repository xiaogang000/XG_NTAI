package application;

import javax.swing.*;
import java.awt.*;


public class textPanel {
    JPanel textJPanel;

    public textPanel() {
    }

    public JPanel textinit(){

        textJPanel =new JPanel();
        textJPanel.setLayout(new BoxLayout(textJPanel,1));
        String text = "微信公众号：XG小刚\r\n" +
                "项目地址：https://github.com/xiaogang000/XG_NTAI\r\n\r\n"+
                "(20230905):\r\n" +
                "XG_NTAI_V1.0(测试版)\r\n" +
                "PHP模板：demo1、demo2、demo3\r\n" +
                "JSP模板：暂无\r\n" +
                "######################################\r\n\r\n" +
                "(20230915):\r\n" +
                "XG_NTAI_V1.1\r\n" +
                "PHP模板：新增demo4、demo5、demo6\r\n" +
                "JSP模板：暂无\r\n" +
                "新增更新记录功能\r\n" +
                "######################################\r\n\r\n"+
                "(20231027):\r\n" +
                "XG_NTAI_V1.2\r\n" +
                "JSP模板：新增jsp_demo1\r\n" +
                "优化GUI使用\r\n"+
                "######################################\r\n\r\n"+
                "(20231108):\r\n" +
                "XG_NTAI_V1.3\r\n" +
                "JSP模板：新增jsp_demo2\r\n" +
                "新增模拟页面功能\r\n"+
                "模拟页面：AliyunWAF、T-mshenWAF、T-secWAF、AnyuWAF、SafeLineWAF、SafedogWAF、WangsuWAF、custom自定义页面\r\n"+
                "######################################\r\n\r\n";
        JTextArea textJTextArea = new JTextArea(text);
        textJPanel.add(textJTextArea);
        return textJPanel;
    }
}
