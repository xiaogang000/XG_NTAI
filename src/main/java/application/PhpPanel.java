package application;

import encode.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class PhpPanel {

    JPanel phpJPanel;
    JPanel selectJpanel;
    JComboBox status;
    JTextField jTextField;
    JTextArea sourcecodeArea;
    JTextArea encodeArea;
    JTextArea txtArea;

    public PhpPanel() {
    }

    public JPanel Phpinit(){

        phpJPanel =new JPanel();
        phpJPanel.setLayout(new BoxLayout(phpJPanel,1));

        selectJpanel =new JPanel(new GridLayout(1,3,10,10));
        JPanel JPanel1 = new JPanel();
        status = new JComboBox();
        status.addItem("未选择");
        status.addItem("php_demo1");
        status.addItem("php_demo2");
        status.addItem("php_demo3");
        status.addItem("php_demo4");
        status.addItem("php_demo5");
        status.addItem("php_demo6");
        JPanel1.add(new JLabel("选择免杀模板"));
        JPanel1.add(status);

        JPanel JPanel2 =new JPanel();
        jTextField = new JTextField("默认随机",10);
        JPanel2.add(new JLabel("加密密钥"));
        JPanel2.add(jTextField);

        JPanel JPanel3 =new JPanel();
        Button button = new Button("免杀");
        button.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                switch ((String)status.getSelectedItem()) {
                    case "php_demo1":
                        String[] phpdemo1= new PhpEncodeDemo1((String) status.getSelectedItem(), jTextField.getText(), sourcecodeArea.getText()).Run();
                        encodeArea.setText(phpdemo1[0]);
                        txtArea.setText(phpdemo1[1]);
                        break;
                    case "php_demo2":
                        String[] phpdemo2= new PhpEncodeDemo2((String) status.getSelectedItem(), jTextField.getText(), sourcecodeArea.getText()).Run();
                        encodeArea.setText(phpdemo2[0]);
                        txtArea.setText(phpdemo2[1]);
                        break;
                    case "php_demo3":
                        String[] phpdemo3= new PhpEncodeDemo3((String) status.getSelectedItem(), jTextField.getText(), sourcecodeArea.getText()).Run();
                        encodeArea.setText(phpdemo3[0]);
                        txtArea.setText(phpdemo3[1]);
                        break;
                    case "php_demo4":
                        String[] phpdemo4= new PhpEncodeDemo4((String) status.getSelectedItem(), jTextField.getText(), sourcecodeArea.getText()).Run();
                        encodeArea.setText(phpdemo4[0]);
                        txtArea.setText(phpdemo4[1]);
                        break;
                    case "php_demo5":
                        String[] phpdemo5= new PhpEncodeDemo5((String) status.getSelectedItem(), jTextField.getText(), sourcecodeArea.getText()).Run();
                        encodeArea.setText(phpdemo5[0]);
                        txtArea.setText(phpdemo5[1]);
                        break;
                    case "php_demo6":
                        String[] phpdemo6= new PhpEncodeDemo6((String) status.getSelectedItem(), jTextField.getText(), sourcecodeArea.getText()).Run();
                        encodeArea.setText(phpdemo6[0]);
                        txtArea.setText(phpdemo6[1]);
                        break;
                    default:
                        encodeArea.setText("请选择php免杀模板");
                }

            }
        });
        JPanel3.add(button);
        selectJpanel.add(JPanel1);
        selectJpanel.add(JPanel2);
        selectJpanel.add(JPanel3);

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
