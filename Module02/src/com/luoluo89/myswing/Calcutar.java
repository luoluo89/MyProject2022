package com.luoluo89.myswing;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Calcutar {
    private JPanel topPanel;
    private JButton button1;
    private JButton button2;
    private JButton a1Button;
    private JButton a4Button;
    private JButton CEButton;
    private JButton a7Button;
    private JButton a1XButton;
    private JButton button8;
    private JButton button9;
    private JButton button10;
    private JButton button11;
    private JButton button12;
    private JButton a0Button;
    private JButton button14;
    private JButton button15;
    private JButton a2Button;
    private JButton a5Button;
    private JButton a8Button;
    private JButton cButton;
    private JButton xButton;
    private JButton a3Button;
    private JButton a6Button;
    private JButton a9Button;
    private JButton button24;
    private JTextPane textPane1;
    private JPanel jPanel1;
    private StringBuffer stringBuffer;
    private Double currentDouble;
    private Boolean isEnd;

    private String myToString(Double d)
    {
        String str = d.toString();
        if (str.endsWith(".0")){
            return str.substring(0, str.length() -2);
        }
        else{
            return str.toString();
        }
    }

    private void myequal(){
        String[] strs = stringBuffer.toString().split(",");

        if (strs.length != 3)
        {
            return;
        }
        switch (strs[1]){
            case "+":
                currentDouble = Double.valueOf(strs[0]) + Double.valueOf(strs[2]);
                textPane1.setText(myToString(currentDouble));
                break;
            case "-":
                currentDouble = Double.valueOf(strs[0]) - Double.valueOf(strs[2]);
                textPane1.setText(myToString(currentDouble));
                break;
            case "×":
                currentDouble = Double.valueOf(strs[0]) * Double.valueOf(strs[2]);
                textPane1.setText(myToString(currentDouble));
                break;
            case "÷":
                currentDouble = Double.valueOf(strs[0]) / Double.valueOf(strs[2]);
                textPane1.setText(myToString(currentDouble));
                break;
            default:
                return;
        }
        stringBuffer.delete(0, stringBuffer.length());
        stringBuffer.append(currentDouble);
    }

    public Calcutar() {
        textPane1.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
        isEnd = false;
        stringBuffer = new StringBuffer();
        currentDouble = Double.valueOf(0);
        stringBuffer.append(myToString(currentDouble));
        textPane1.setText(myToString(currentDouble));

        // %
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                currentDouble = currentDouble/100;
                if(stringBuffer.toString().contains(",")){
                    String strs[] = stringBuffer.toString().split(",");
                    stringBuffer = new StringBuffer();
                    for(int i = 0; i < strs.length -1 ; i++){
                        stringBuffer.append(strs[i]);
                        stringBuffer.append(",");
                    }
                }

                stringBuffer.append(currentDouble);
                textPane1.setText(myToString(currentDouble));
            }
        });

        // √  对当前数字开根号
        button15.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(currentDouble >= 0d){
                    currentDouble = Math.sqrt(currentDouble);
                    if(stringBuffer.toString().contains(",")){
                        String strs[] = stringBuffer.toString().split(",");
                        stringBuffer = new StringBuffer();
                        for(int i = 0; i < strs.length -1 ; i++){
                            stringBuffer.append(strs[i]);
                            stringBuffer.append(",");
                        }
                    }
                    stringBuffer.append(currentDouble);
                    textPane1.setText(myToString(currentDouble));
                }
                else
                {
                    textPane1.setText("负数不能开根号");
                }
            }
        });

        //C
        cButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                stringBuffer.delete(0, stringBuffer.length());
                currentDouble = Double.valueOf(0);
                stringBuffer.append(currentDouble);
                textPane1.setText(myToString(currentDouble));
            }
        });

        // X²
        xButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                currentDouble *= currentDouble;
                if(stringBuffer.toString().contains(",")){
                    String strs[] = stringBuffer.toString().split(",");
                    stringBuffer = new StringBuffer();
                    for(int i = 0; i < strs.length -1 ; i++){
                        stringBuffer.append(strs[i]);
                        stringBuffer.append(",");
                    }
                }

                stringBuffer.append(currentDouble);
                textPane1.setText(myToString(currentDouble));
            }
        });

        // 1/X
        a1XButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                currentDouble = 1/currentDouble;
                if(stringBuffer.toString().contains(",")){
                    String strs[] = stringBuffer.toString().split(",");
                    stringBuffer = new StringBuffer();
                    for(int i = 0; i < strs.length -1 ; i++){
                        stringBuffer.append(strs[i]);
                        stringBuffer.append(",");
                    }
                }
                stringBuffer.append(currentDouble);
                textPane1.setText(myToString(currentDouble));
            }
        });

        //CE
        CEButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                stringBuffer = new StringBuffer();
                currentDouble = Double.valueOf(0);
                stringBuffer.append(currentDouble);
                textPane1.setText(stringBuffer.toString());
            }
        });

        // 退格
        button24.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (currentDouble == 0)
                {
                    return;
                }
                String str = textPane1.getText();
                if (str.length() == 1){
                    currentDouble = 0d;
                }
                else{
                    str = str.substring(0, str.length() - 1);
                    currentDouble = Double.valueOf(str);
                }
                textPane1.setText(myToString(currentDouble));
            }
        });

        // +
        button9.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(stringBuffer.toString().contains(",") && !stringBuffer.toString().contains("+"))
                {
                    //如果不包含加号，则之前点了其他运算符，要替换成加号
                    stringBuffer.delete(stringBuffer.length() - 3, stringBuffer.length());
                    textPane1.setText("+");
                }
                //如果是连续加
                if (stringBuffer.toString().contains(",")){
                    myequal();
                    stringBuffer.delete(0, stringBuffer.length());
                    stringBuffer.append(myToString(currentDouble));
                }
                else
                {
                    textPane1.setText("+");
                }
                stringBuffer.append(",");
                stringBuffer.append("+");
                stringBuffer.append(",");
                currentDouble = 0d;
                isEnd = false;
            }
        });

        // -
        button10.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(stringBuffer.toString().contains(",") && !stringBuffer.toString().contains("-"))
                {
                    //如果不包含减号，则之前点了其他运算符，要替换成减号
                    stringBuffer.delete(stringBuffer.length() - 3, stringBuffer.length());
                    textPane1.setText("-");
                }
                //如果是连续-
                if (stringBuffer.toString().contains(",")){
                    myequal();
                    stringBuffer.delete(0, stringBuffer.length());
                    stringBuffer.append(myToString(currentDouble));
                }
                else
                {
                    textPane1.setText("-");
                }
                stringBuffer.append(",");
                stringBuffer.append("-");
                stringBuffer.append(",");
                currentDouble = 0d;
                isEnd = false;
            }
        });

        // ×
        button11.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(stringBuffer.toString().contains(",") && !stringBuffer.toString().contains("×"))
                {
                    //如果不包含加号，则之前点了其他运算符，要替换成加号
                    stringBuffer.delete(stringBuffer.length() - 3, stringBuffer.length());
                    textPane1.setText("×");
                }
                //如果是连续乘
                if (stringBuffer.toString().contains(",")){
                    myequal();
                    stringBuffer.delete(0, stringBuffer.length());
                    stringBuffer.append(myToString(currentDouble));
                }
                else
                {
                    textPane1.setText("×");
                }
                stringBuffer.append(",");
                stringBuffer.append("×");
                stringBuffer.append(",");
                currentDouble = 0d;
                isEnd = false;
            }
        });

        // ÷
        button12.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(stringBuffer.toString().contains(",") && !stringBuffer.toString().contains("÷"))
                {
                    //如果不包含加号，则之前点了其他运算符，要替换成加号
                    stringBuffer.delete(stringBuffer.length() - 3, stringBuffer.length());
                    textPane1.setText("÷");
                }
                //如果是连续除
                if (stringBuffer.toString().contains(",")){
                    myequal();
                    stringBuffer.delete(0, stringBuffer.length());
                    stringBuffer.append(myToString(currentDouble));
                }
                else
                {
                    textPane1.setText("÷");
                }
                stringBuffer.append(",");
                stringBuffer.append("÷");
                stringBuffer.append(",");
                currentDouble = 0d;
                isEnd = false;
            }
        });

        // 0
        a0Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(isEnd){
                    isEnd = false;
                    stringBuffer = new StringBuffer();
                    currentDouble = Double.valueOf(0);
                }
                String str = textPane1.getText();
                if(str.contains(".")){
                    //是小数
                    StringBuffer strb = new StringBuffer();
                    strb.append(str);
                    strb.append("0");
                    currentDouble = Double.valueOf(strb.toString());
                }
                else {
                    //不是小数
                    currentDouble = currentDouble * 10;
                }
                if(!stringBuffer.toString().contains(",") && stringBuffer.toString().startsWith("0")){
                    stringBuffer.delete(0, stringBuffer.length());
                }
                stringBuffer.append("0");
                textPane1.setText(myToString(currentDouble));
            }
        });

        // 1
        a1Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(isEnd){
                    isEnd = false;
                    stringBuffer = new StringBuffer();
                    currentDouble = Double.valueOf(0);
                }
                String str = textPane1.getText();
                if(str.contains(".")){
                    //是小数
                    StringBuffer strb = new StringBuffer();
                    strb.append(str);
                    strb.append("1");
                    currentDouble = Double.valueOf(strb.toString());
                }
                else {
                    //不是小数
                    currentDouble = currentDouble * 10 + 1d;
                }
                if(!stringBuffer.toString().contains(",") && stringBuffer.toString().startsWith("0")){
                    stringBuffer.delete(0, stringBuffer.length());
                }
                stringBuffer.append("1");
                textPane1.setText(myToString(currentDouble));
            }
        });
        // 2
        a2Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(isEnd){
                    isEnd = false;
                    stringBuffer = new StringBuffer();
                    currentDouble = Double.valueOf(0);
                }
                String str = textPane1.getText();
                if(str.contains(".")){
                    //是小数
                    StringBuffer strb = new StringBuffer();
                    strb.append(str);
                    strb.append("2");
                    currentDouble = Double.valueOf(strb.toString());
                }
                else {
                    //不是小数
                    currentDouble = currentDouble * 10 + 2d;
                }
                if(!stringBuffer.toString().contains(",") && stringBuffer.toString().startsWith("0")){
                    stringBuffer.delete(0, stringBuffer.length());
                }
                stringBuffer.append("2");
                textPane1.setText(myToString(currentDouble));
            }
        });
        // 3
        a3Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(isEnd){
                    isEnd = false;
                    stringBuffer = new StringBuffer();
                    currentDouble = Double.valueOf(0);
                }
                String str = textPane1.getText();
                if(str.contains(".")){
                    //是小数
                    StringBuffer strb = new StringBuffer();
                    strb.append(str);
                    strb.append("3");
                    currentDouble = Double.valueOf(strb.toString());
                }
                else {
                    //不是小数
                    currentDouble = currentDouble * 10 + 3d;
                }
                if(!stringBuffer.toString().contains(",") && stringBuffer.toString().startsWith("0")){
                    stringBuffer.delete(0, stringBuffer.length());
                }
                stringBuffer.append("3");
                textPane1.setText(myToString(currentDouble));
            }
        });
        // 4
        a4Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(isEnd){
                    isEnd = false;
                    stringBuffer = new StringBuffer();
                    currentDouble = Double.valueOf(0);
                }
                String str = textPane1.getText();
                if(str.contains(".")){
                    //是小数
                    StringBuffer strb = new StringBuffer();
                    strb.append(str);
                    strb.append("4");
                    currentDouble = Double.valueOf(strb.toString());
                }
                else {
                    //不是小数
                    currentDouble = currentDouble * 10 + 4d;
                }
                if(!stringBuffer.toString().contains(",") && stringBuffer.toString().startsWith("0")){
                    stringBuffer.delete(0, stringBuffer.length());
                }
                stringBuffer.append("4");
                textPane1.setText(myToString(currentDouble));
            }
        });
        // 5
        a5Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(isEnd){
                    isEnd = false;
                    stringBuffer = new StringBuffer();
                    currentDouble = Double.valueOf(0);
                }
                String str = textPane1.getText();
                if(str.contains(".")){
                    //是小数
                    StringBuffer strb = new StringBuffer();
                    strb.append(str);
                    strb.append("5");
                    currentDouble = Double.valueOf(strb.toString());
                }
                else {
                    //不是小数
                    currentDouble = currentDouble * 10 + 5d;
                }
                if(!stringBuffer.toString().contains(",") && stringBuffer.toString().startsWith("0")){
                    stringBuffer.delete(0, stringBuffer.length());
                }
                stringBuffer.append("5");
                textPane1.setText(myToString(currentDouble));
            }
        });
        // 6
        a6Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(isEnd){
                    isEnd = false;
                    stringBuffer = new StringBuffer();
                    currentDouble = Double.valueOf(0);
                }
                String str = textPane1.getText();
                if(str.contains(".")){
                    //是小数
                    StringBuffer strb = new StringBuffer();
                    strb.append(str);
                    strb.append("6");
                    currentDouble = Double.valueOf(strb.toString());
                }
                else {
                    //不是小数
                    currentDouble = currentDouble * 10 + 6d;
                }
                if(!stringBuffer.toString().contains(",") && stringBuffer.toString().startsWith("0")){
                    stringBuffer.delete(0, stringBuffer.length());
                }
                stringBuffer.append("6");
                textPane1.setText(myToString(currentDouble));
            }
        });
        // 7
        a7Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(isEnd){
                    isEnd = false;
                    stringBuffer = new StringBuffer();
                    currentDouble = Double.valueOf(0);
                }
                String str = textPane1.getText();
                if(str.contains(".")){
                    //是小数
                    StringBuffer strb = new StringBuffer();
                    strb.append(str);
                    strb.append("7");
                    currentDouble = Double.valueOf(strb.toString());
                }
                else {
                    //不是小数
                    currentDouble = currentDouble * 10 + 7d;
                }
                if(!stringBuffer.toString().contains(",") && stringBuffer.toString().startsWith("0")){
                    stringBuffer.delete(0, stringBuffer.length());
                }
                stringBuffer.append("7");
                textPane1.setText(myToString(currentDouble));
            }
        });

        //8
        a8Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(isEnd){
                    isEnd = false;
                    stringBuffer = new StringBuffer();
                    currentDouble = Double.valueOf(0);
                }
                String str = textPane1.getText();
                if(str.contains(".")){
                    //是小数
                    StringBuffer strb = new StringBuffer();
                    strb.append(str);
                    strb.append("8");
                    currentDouble = Double.valueOf(strb.toString());
                }
                else {
                    //不是小数
                    currentDouble = currentDouble * 10 + 8d;
                }
                if(!stringBuffer.toString().contains(",") && stringBuffer.toString().startsWith("0")){
                    stringBuffer.delete(0, stringBuffer.length());
                }
                stringBuffer.append("8");
                textPane1.setText(myToString(currentDouble));
            }
        });

        //9
        a9Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(isEnd){
                    isEnd = false;
                    stringBuffer = new StringBuffer();
                    currentDouble = Double.valueOf(0);
                }
                String str = textPane1.getText();
                if(str.contains(".")){
                    //是小数
                    StringBuffer strb = new StringBuffer();
                    strb.append(str);
                    strb.append("9");
                    currentDouble = Double.valueOf(strb.toString());
                }
                else {
                    //不是小数
                    currentDouble = currentDouble * 10 + 9d;
                }
                if(!stringBuffer.toString().contains(",") && stringBuffer.toString().startsWith("0")){
                    stringBuffer.delete(0, stringBuffer.length());
                }
                stringBuffer.append("9");
                textPane1.setText(myToString(currentDouble));
            }
        });

        //=
        button8.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                isEnd = true;
                myequal();
            }
        });

        //±
        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String str = textPane1.getText();
                if (str.contains("-")){
                    str = str.substring(1, str.length());
                }
                else{
                    str = "-" + str;
                }
                textPane1.setText(str);
            }
        });

        //.
        button14.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String str = currentDouble.toString();
                if (str.endsWith(".0"))
                {
                    textPane1.setText(myToString(currentDouble) + ".");
                    stringBuffer.append(".");
                }
                else{
                    return;
                }
            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Calcutar");
        frame.setContentPane(new Calcutar().topPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

}
