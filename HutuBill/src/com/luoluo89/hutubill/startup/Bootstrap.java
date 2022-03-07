package com.luoluo89.hutubill.startup;

import com.luoluo89.hutubill.panel.MainFrame;
import com.luoluo89.hutubill.panel.MainPanel;
import com.luoluo89.hutubill.panel.SpendPanel;
import com.luoluo89.hutubill.util.GUIUtil;

import javax.swing.*;

public class Bootstrap {
    public static void main(String[] args) throws Exception{
        GUIUtil.useLNF();
 
        SwingUtilities.invokeAndWait(new Runnable() {
            @Override
            public void run() {
                MainFrame.instance.setVisible(true);
                MainPanel.instance.workingPanel.show(SpendPanel.instance);
            }
        });
    }
}