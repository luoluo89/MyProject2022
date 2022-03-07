package com.luoluo89.myswing;

import javax.swing.*;
import javax.swing.filechooser.FileFilter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class TestGUI7 {

    public static void main(String[] args) {

        JFrame jFrame = new JFrame("LoL");
        jFrame.setSize(600, 600);
        jFrame.setLocation(200, 200);
        //jFrame.setLayout(null);
        jFrame.setLayout(new FlowLayout());
        //jLabel1是一个文字显示框
        JLabel jLabel1 = new JLabel("LOL文字");
        jLabel1.setForeground(Color.red);
        jLabel1.setBounds(0, 0, 280, 30);
        jFrame.add(jLabel1);
        ImageIcon imageIcon = new ImageIcon("D:\\02.code\\idea_workspace_03\\MyProject2022\\Module02\\resource\\QQ.jpg");

        //------------------------------------------------------------------
        //jLabel2是一个图片显示框
        JLabel jLabel2 = new JLabel("图片");
        jLabel2.setIcon(imageIcon);
        jLabel2.setBounds(0, 20, imageIcon.getIconWidth(), imageIcon.getIconHeight());
        jFrame.add(jLabel2);
        //------------------------------------------------------------------
        //jButton是按钮
        JButton jButton = new JButton("打开QQ");
        jButton.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //弹出对话框
                int option = JOptionPane.showConfirmDialog(jFrame, "是否 使用外挂 ？");
                if (JOptionPane.OK_OPTION == option) {
                    String answer = JOptionPane.showInputDialog(jFrame, "请输入yes，表明使用外挂后果自负");
                    if ("yes".equals(answer))
                        JOptionPane.showMessageDialog(jFrame, "你使用外挂被抓住！ 罚拣肥皂3次！");
                }
            }
        });
        jButton.setBounds(150, 0, 180, 30);
        jFrame.add(jButton);
        //------------------------------------------------------------------
        //bCheckBox是复选框
        JCheckBox bCheckBox1 = new JCheckBox("物理英雄");
        //设置为默认被选中
        bCheckBox1.setBounds(0, 80, 130, 30);
        JCheckBox bCheckBox2 = new JCheckBox("魔法英雄");
        bCheckBox2.setBounds(0, 110, 130, 30);
        jFrame.add(bCheckBox1);
        jFrame.add(bCheckBox2);
        //------------------------------------------------------------------
        //jRadioButton是单选框
        JRadioButton jRadioButton1 = new JRadioButton("物理英雄");
        jRadioButton1.setBounds(0, 140, 130, 30);
        JRadioButton jRadioButton2 = new JRadioButton("魔法英雄");
        jRadioButton2.setBounds(0, 170, 130, 30);
        //判断是否被选中，这是人工判断的方法
        jRadioButton1.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(jRadioButton2.isSelected()){
                    jRadioButton2.setSelected(false);
                }
                jRadioButton1.setSelected(true);
            }
        });
        jRadioButton2.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(jRadioButton1.isSelected()){
                    jRadioButton1.setSelected(false);
                }
                jRadioButton2.setSelected(true);
            }
        });
        //------------------------------------------------------------------
        //正常应该使用ButtonGroup，将两个按钮放到同一个组里
        ButtonGroup bg = new ButtonGroup();
        // 把b1，b2放在同一个按钮分组对象里 ，这样同一时间，只有一个按钮会被选中
        bg.add(jRadioButton1);
        bg.add(jRadioButton2);
        jFrame.add(jRadioButton1);
        jFrame.add(jRadioButton2);
        //------------------------------------------------------------------
        //JComboBox下拉框
        String[] heros = new String[] { "烟绯", "香菱" };
        JComboBox cb = new JComboBox(heros);
        cb.setBounds(0, 200, 80, 30);
        jFrame.add(cb);
        //------------------------------------------------------------------
        //JTextField 输入框
        JLabel lName = new JLabel("账号：");
        lName.setBounds(150, 40, 80, 30);
        // 输入框
        JTextField tfName = new JTextField("");
        tfName.setText("请输入账号");
        tfName.setPreferredSize(new Dimension(80, 30));
        JLabel lPassword = new JLabel("密码：");
        lPassword.setBounds(150, 70, 80, 30);
        // 密码框
        JPasswordField pf = new JPasswordField("");
        pf.setText("&48kdh4@#");
        pf.setPreferredSize(new Dimension(80, 30));
        // 与文本框不同，获取密码框里的内容，推荐使用getPassword，该方法会返回一个字符数组，而非字符串
        jFrame.add(lName);
        jFrame.add(tfName);
        jFrame.add(lPassword);
        jFrame.add(pf);
        //------------------------------------------------------------------
        //JTextArea 文本区域
        JLabel jLabeltxt = new JLabel("文本域：");
        jLabeltxt.setBounds(150, 80, 200, 150);

        JTextArea ta = new JTextArea();
        ta.setPreferredSize(new Dimension(200, 150));
        //\n换行符
        ta.setText("抢人头！\n抢你妹啊抢！\n");
        //追加数据
        ta.append("我去送了了了了了了了了了了了了了了了了了了了了了了了了");
        //设置自动换行
        ta.setLineWrap(true);
        jFrame.add(jLabeltxt);
        jFrame.add(ta);
        //------------------------------------------------------------------
        //JProgressBar 进度条
        JProgressBar pb = new JProgressBar();
        pb.setBounds(150, 230, 200, 40);
        pb.setMaximum(100);
        pb.setValue(50);
        //显示当前进度
        pb.setStringPainted(true);
        jFrame.add(pb);
        //------------------------------------------------------------------
        //文件选择器
        JFileChooser fc = new JFileChooser();
        fc.setFileFilter(new FileFilter() {
            @Override
            public boolean accept(File pathname) {
                return jFrame.getName().toLowerCase().endsWith(".txt");
            }

            @Override
            public String getDescription() {
                return ".txt";
            }
        });
        JButton bOpen = new JButton("打开文件");
        JButton bSave = new JButton("保存文件");
        jFrame.add(bOpen);
        jFrame.add(bSave);
//        jFrame.setLocationRelativeTo(null);
        bOpen.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int returnVal =  fc.showOpenDialog(jFrame);
                File file = fc.getSelectedFile();
                if (returnVal == JFileChooser.APPROVE_OPTION) {
                    JOptionPane.showMessageDialog(jFrame, "计划打开文件:" + file.getAbsolutePath());
                }

            }
        });
        bSave.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int returnVal =  fc.showSaveDialog(jFrame);
                File file = fc.getSelectedFile();
                if (returnVal == JFileChooser.APPROVE_OPTION) {
                    JOptionPane.showMessageDialog(jFrame, "计划保存到文件:" + file.getAbsolutePath());
                }
            }
        });
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.setVisible(true);
    }
}
