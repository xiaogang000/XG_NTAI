package application;

import encode.*;
import pretend.HtmlPretend;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class PhpPanel {
    JPanel phpJPanel;
    JPanel selectJpanel;
    JComboBox status;
    JComboBox pretend;
    public static JTextField pretendJTextField;
    JTextField jTextField;
    JTextArea sourcecodeArea;
    JTextArea encodeArea;
    JTextArea txtArea;

    public PhpPanel() {
    }

    public JPanel Phpinit(){

        phpJPanel =new JPanel();
        phpJPanel.setLayout(new BoxLayout(phpJPanel,1));

        selectJpanel =new JPanel(new GridLayout(1,4,5,5));
        JPanel JPanel1 = new JPanel();
        status = new JComboBox();
        status.addItem("未选择");
        status.addItem("php_demo1");
        status.addItem("php_demo2");
        status.addItem("php_demo3");
        status.addItem("php_demo4");
        status.addItem("php_demo5");
        status.addItem("php_demo6");
        status.addItem("php_demo7");

        status.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                switch ((String)status.getSelectedItem()) {
                    case "php_demo1":
                        txtArea.setText(PhpEncodeDemo1.GetDescribe());
                        break;
                    case "php_demo2":
                        txtArea.setText(PhpEncodeDemo2.GetDescribe());
                        break;
                    case "php_demo3":
                        txtArea.setText(PhpEncodeDemo3.GetDescribe());
                        break;
                    case "php_demo4":
                        txtArea.setText(PhpEncodeDemo4.GetDescribe());
                        break;
                    case "php_demo5":
                        txtArea.setText(PhpEncodeDemo5.GetDescribe());
                        break;
                    case "php_demo6":
                        txtArea.setText(PhpEncodeDemo6.GetDescribe());
                        break;
                    case "php_demo7":
                        txtArea.setText(PhpEncodeDemo7.GetDescribe());
                        break;
                    default:
                        encodeArea.setText("请选择php免杀模板");
                }
            }
        });
        JPanel1.add(new JLabel("免杀模板"));
        JPanel1.add(status);

        JPanel JPanel2 =new JPanel();
        jTextField = new JTextField("默认随机",10);
        JPanel2.add(new JLabel("加密密钥"));
        JPanel2.add(jTextField);

        JPanel pretendJPanel = new JPanel();
        pretend = new JComboBox();
        pretend.addItem("未选择");
        pretend.addItem("AliyunWAF");
        pretend.addItem("T-mshenWAF");
        pretend.addItem("T-secWAF");
        pretend.addItem("AnyuWAF");
        pretend.addItem("SafeLineWAF");
        pretend.addItem("SafedogWAF");
        pretend.addItem("WangsuWAF");
        pretend.addItem("custom");
        pretendJTextField = new JTextField("Base64",5);
        pretendJPanel.add(new JLabel("模拟页面"));
        pretendJPanel.add(pretend);
        pretendJPanel.add(pretendJTextField);

        //JPanel JPanel3 =new JPanel();
        Button button = new Button("免杀");
        button.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String[] phpdemo =null;

                switch ((String)status.getSelectedItem()) {
                    case "php_demo1":
                        phpdemo = new PhpEncodeDemo1((String) status.getSelectedItem(), sourcecodeArea.getText(), jTextField.getText()).Run();
                        phpdemo[0] += new HtmlPretend().GetPhp((String) pretend.getSelectedItem());
                        break;
                    case "php_demo2":
                        phpdemo = new PhpEncodeDemo2((String) status.getSelectedItem(), sourcecodeArea.getText(), jTextField.getText()).Run();
                        phpdemo[0] += new HtmlPretend().GetPhp((String) pretend.getSelectedItem());
                        break;
                    case "php_demo3":
                        phpdemo= new PhpEncodeDemo3((String) status.getSelectedItem(), sourcecodeArea.getText(), jTextField.getText()).Run();
                        phpdemo[0] += new HtmlPretend().GetPhp((String) pretend.getSelectedItem());
                        txtArea.setText(phpdemo[1]);
                        break;
                    case "php_demo4":
                        phpdemo= new PhpEncodeDemo4((String) status.getSelectedItem(), sourcecodeArea.getText(), jTextField.getText()).Run();
                        phpdemo[0] += new HtmlPretend().GetPhp((String) pretend.getSelectedItem());
                        break;
                    case "php_demo5":
                        phpdemo= new PhpEncodeDemo5((String) status.getSelectedItem(), sourcecodeArea.getText(), jTextField.getText()).Run();
                        phpdemo[0] += new HtmlPretend().GetPhp((String) pretend.getSelectedItem());
                        break;
                    case "php_demo6":
                        phpdemo= new PhpEncodeDemo6((String) status.getSelectedItem(), sourcecodeArea.getText(), jTextField.getText()).Run();
                        phpdemo[0] += new HtmlPretend().GetPhp((String) pretend.getSelectedItem());
                        break;
                    case "php_demo7":
                        phpdemo= new PhpEncodeDemo7((String) status.getSelectedItem(), sourcecodeArea.getText(), jTextField.getText()).Run();
                        phpdemo[0] += new HtmlPretend().GetPhp((String) pretend.getSelectedItem());
                        txtArea.setText(phpdemo[1]);
                        break;
                    default:
                        phpdemo = new String[]{"请选择php免杀模板",""};
                }
                encodeArea.setText(phpdemo[0]);
                if(pretend.getSelectedItem().equals("custom")&&pretendJTextField.getText().equals("Base64")){
                    encodeArea.setText("请输入自定义页面Base64编码");
                }
            }
        });
        //JPanel3.add(button);

        selectJpanel.add(JPanel1);
        selectJpanel.add(JPanel2);
        selectJpanel.add(pretendJPanel);
        selectJpanel.add(button);

        JPanel sourcecodeJpanel = new JPanel(new BorderLayout());
        sourcecodeArea = new JTextArea();
        sourcecodeArea.setText("<?php echo 'testdemo';?>\n//php源码：一句话、蚁剑、冰蝎、哥斯拉或其他webshell源码");
        JScrollPane scrollPane1 = new JScrollPane(sourcecodeArea);
        sourcecodeJpanel.add(scrollPane1);

        JPanel encodeJpanel = new JPanel(new BorderLayout());
        encodeArea = new JTextArea();
        encodeArea.setText("php免杀后webshell");
        JScrollPane scrollPane2 = new JScrollPane(encodeArea);
        encodeJpanel.add(scrollPane2);

        JPanel txtJpanel = new JPanel(new BorderLayout());
        txtArea = new JTextArea();
        txtArea.setText("免杀webshell注意事项");
        JScrollPane scrollPane3 = new JScrollPane(txtArea);
        txtJpanel.add(scrollPane3);

        JPanel splitJpanel = new JPanel(new BorderLayout());
        JSplitPane splitPane1=new JSplitPane(JSplitPane.VERTICAL_SPLIT,sourcecodeJpanel,encodeJpanel);
        splitPane1.setDividerSize(5);
        splitPane1.setContinuousLayout(true);
        splitPane1.setDividerLocation(250);
        splitPane1.setEnabled(true);

        JSplitPane splitPane2=new JSplitPane(JSplitPane.VERTICAL_SPLIT,splitPane1,txtJpanel);
        splitPane2.setDividerSize(5);
        splitPane2.setContinuousLayout(true);
        splitPane2.setDividerLocation(500);
        splitPane2.setEnabled(true);
        splitJpanel.add(splitPane2);


        phpJPanel.add(selectJpanel);
        phpJPanel.add(splitJpanel);
        return phpJPanel;
    }
}
