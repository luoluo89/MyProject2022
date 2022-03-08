package com.luoluo89.hutubill.panel;

import com.luoluo89.hutubill.listener.RecoverListener;
import com.luoluo89.hutubill.util.ColorUtil;
import com.luoluo89.hutubill.util.GUIUtil;

import javax.swing.*;

public class RecoverPanel extends JPanel {
    static{
        GUIUtil.useLNF();
    }
    public static RecoverPanel instance = new RecoverPanel();
 
    JButton bRecover =new JButton("恢复");
 
    public RecoverPanel() {
 
        GUIUtil.setColor(ColorUtil.blueColor, bRecover);
        this.add(bRecover);
        bRecover.addActionListener(new RecoverListener());
         
    }
 
    public static void main(String[] args) {
        GUIUtil.showPanel(RecoverPanel.instance);
    }
 
}
