package application;

import encode.*;
import pretend.HtmlPretend;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class JspPanel {
    JPanel JspJPanel;
    JPanel selectJPanel;
    JComboBox status;
    JComboBox pretend;
    public static JTextField pretendJTextField;
    JTextField jTextField;
    JTextArea sourcecodeArea;
    JTextArea encodeArea;
    JTextArea txtArea;

    public JspPanel() {
    }

    public JPanel Jspinit(){
        JspJPanel = new JPanel();
        JspJPanel.setLayout(new BoxLayout(JspJPanel,1));
        selectJPanel = new JPanel(new GridLayout(1,3,10,10));

        JPanel jPanel1 = new JPanel();
        status = new JComboBox();
        status.addItem("未选择");
        status.addItem("jsp_demo1");
        status.addItem("jsp_demo2");

        status.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                switch ((String)status.getSelectedItem()) {
                    case "jsp_demo1":
                        txtArea.setText(JspEncodeDemo1.GetDemotxt());
                        break;
                    case "jsp_demo2":
                        txtArea.setText(JspEncodeDemo2.GetDemotxt());
                        break;
                    default:
                        encodeArea.setText("请选择jsp免杀模板");
                }
            }
        });
        jPanel1.add(new JLabel("免杀模板"));
        jPanel1.add(status);

        JPanel jPanel2 = new JPanel();
        jTextField = new JTextField("默认随机",10);
        jPanel2.add(new JLabel("加密密钥"));
        jPanel2.add(jTextField);

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

        //JPanel jPanel3 = new JPanel();
        Button button = new Button("免杀");
        button.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String[] jspdemo =null;
                switch ((String)status.getSelectedItem()) {
                    case "jsp_demo1":
                        try {
                            jspdemo = new JspEncodeDemo1((String) status.getSelectedItem(), jTextField.getText(), sourcecodeArea.getText()).Run();
                        } catch (Exception ex) {
                            ex.printStackTrace();
                        }
                        jspdemo[0] += new HtmlPretend().GetJsp7((String) pretend.getSelectedItem());
                        break;
                    case "jsp_demo2":
                        try {
                            jspdemo = new JspEncodeDemo2((String) status.getSelectedItem(), jTextField.getText(), sourcecodeArea.getText()).Run();
                        } catch (Exception ex) {
                            ex.printStackTrace();
                        }
                        jspdemo[0] += new HtmlPretend().GetJsp9((String) pretend.getSelectedItem());
                        break;
                    default:
                        jspdemo = new String[]{"请选择jsp免杀模板",""};
                }

                encodeArea.setText(jspdemo[0]);
                if(pretend.getSelectedItem().equals("custom")&&pretendJTextField.getText().equals("Base64")){
                    encodeArea.setText("请输入自定义页面Base64编码");
                }
            }
        });
        //jPanel3.add(button);

        selectJPanel.add(jPanel1);
        selectJPanel.add(jPanel2);
        selectJPanel.add(pretendJPanel);
        selectJPanel.add(button);

        JPanel sourcecodeJpanel = new JPanel(new BorderLayout());
        sourcecodeArea = new JTextArea();
        sourcecodeArea.setText("<% out.println(\"hello world\");%>\n" +
                "//jsp源码：一句话、蚁剑、冰蝎、哥斯拉或其他webshell源码");
        JScrollPane scrollPane1 = new JScrollPane(sourcecodeArea);
        sourcecodeJpanel.add(scrollPane1);

        JPanel encodeJpanel = new JPanel(new BorderLayout());
        encodeArea = new JTextArea();
        encodeArea.setText("jsp免杀后webshell");
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


        JspJPanel.add(selectJPanel);
        JspJPanel.add(splitJpanel);

        return JspJPanel;
    }
}
