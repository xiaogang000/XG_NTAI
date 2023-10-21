package application;

import encode.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class JspPanel {
    JPanel JspJPanel;
    JPanel selectJPanel;
    JComboBox status;
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
        jPanel1.add(new JLabel("选择免杀模板"));
        jPanel1.add(status);

        JPanel jPanel2 = new JPanel();
        jTextField = new JTextField("默认随机",10);
        jPanel2.add(new JLabel("加密密钥"));
        jPanel2.add(jTextField);

        JPanel jPanel3 = new JPanel();
        Button button = new Button("免杀");
        button.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                switch ((String)status.getSelectedItem()) {
                    case "jsp_demo1":
                        String[] jspdemo1= new String[0];
                        try {
                            jspdemo1 = new JspEncodeDemo1((String) status.getSelectedItem(), jTextField.getText(), sourcecodeArea.getText()).Run();
                        } catch (Exception ex) {
                            ex.printStackTrace();
                        }
                        encodeArea.setText(jspdemo1[0]);
                        txtArea.setText(jspdemo1[1]);
                        break;
                    default:
                        encodeArea.setText("请选择免杀模板");
                }
            }
        });
        jPanel3.add(button);
        selectJPanel.add(jPanel1);
        selectJPanel.add(jPanel2);
        selectJPanel.add(jPanel3);

        JPanel sourcecodeJpanel = new JPanel(new BorderLayout());
        sourcecodeArea = new JTextArea();
        sourcecodeArea.setText("jsp源码：冰蝎、哥斯拉、其他webshell代码或任意可执行jsp代码");
        JScrollPane scrollPane1 = new JScrollPane(sourcecodeArea);
        sourcecodeJpanel.add(scrollPane1);

        JPanel encodeJpanel = new JPanel(new BorderLayout());
        encodeArea = new JTextArea();
        encodeArea.setText("jsp免杀后webshell");
        JScrollPane scrollPane2 = new JScrollPane(encodeArea);
        encodeJpanel.add(scrollPane2);

        JPanel txtJpanel = new JPanel(new BorderLayout());
        txtArea = new JTextArea();
        txtArea.setText("免杀webshell使用方法");
        JScrollPane scrollPane3 = new JScrollPane(txtArea);
        txtJpanel.add(scrollPane3);

        JspJPanel.add(selectJPanel);
        JspJPanel.add(sourcecodeJpanel);
        JspJPanel.add(encodeJpanel);
        JspJPanel.add(txtJpanel);

        return JspJPanel;
    }
}
