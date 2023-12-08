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
                "本工具仅用于授权测试，请勿用于非法用途\r\n"+
                "项目地址：https://github.com/xiaogang000/XG_NTAI\r\n\r\n"+
                "(20230905): XG_NTAI_V1.0(测试版)\r\n" +
                "PHP模板: demo1、demo2、demo3\r\n" +
                "JSP模板: 暂无\r\n" +
                "######################################\r\n\r\n" +
                "(20230915): XG_NTAI_V1.1\r\n" +
                "PHP模板: 新增demo4、demo5、demo6\r\n" +
                "JSP模板: 暂无\r\n" +
                "新增更新记录功能\r\n" +
                "######################################\r\n\r\n"+
                "(20231027): XG_NTAI_V1.2\r\n" +
                "JSP模板: 新增jsp_demo1\r\n" +
                "优化GUI使用\r\n"+
                "######################################\r\n\r\n"+
                "(20231108): XG_NTAI_V1.3\r\n" +
                "JSP模板: 新增jsp_demo2\r\n" +
                "新增模拟页面功能\r\n"+
                "模拟页面: AliyunWAF、T-mshenWAF、T-secWAF、AnyuWAF、SafeLineWAF、SafedogWAF、WangsuWAF、custom自定义页面\r\n"+
                "######################################\r\n\r\n"+
                "(20231124): XG_NTAI_V1.4\r\n" +
                "新增配置文件: 将XG_NTAI.properties放在同目录下运行\r\n"+
                "JSP模板: 修改jsp_demo1, 针对阿里云新增jsp_demo3、jsp_demo4(需配置文件)\r\n" +
                "######################################\r\n\r\n"+
                "(20231201): XG_NTAI_V1.5\r\n" +
                "优化php的waf页面中文乱码\r\n"+
                "JSP模板: 新增jsp_demo5(需配置文件)、jsp_demo6(需配置文件)、jsp_demo7\r\n" +
                "######################################\r\n\r\n"+
                "(20231210): XG_NTAI_V1.6\r\n" +
                "PHP模板: 新增phpdemo7(需配置文件)\r\n" +
                "######################################\r\n\r\n";
        JTextArea textJTextArea = new JTextArea(text);
        textJPanel.add(textJTextArea);
        return textJPanel;
    }
}
