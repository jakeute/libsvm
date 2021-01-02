package com.man;

import com.svm.svmMain;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;

public class TGUI {


    public static void main(String[] args) {
        /*
         * 对窗口的操作，包括创建，设置标题，设置大小以及位置
         */
        JFrame frame = new JFrame();// 创建一个窗口
        frame.setTitle("机器学习");// 设置窗口标题
        frame.setBounds(250, 100, 825, 800);// 设置窗口位置和大小
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        /*
         * 这是对整个窗口布局的格式化，已达到可以任意放面板，标签，文本框，按钮等东西
         */
        // FlowLayout fl = new FlowLayout(FlowLayout.CENTER, 10, 10);//
        // 实例化FlowLayout流式布局类的对象
        frame.setLayout(null);// 布局为空

        /*
         * 创建面板，以达到良好的布局
         */
        JPanel panel = new JPanel();// JPanel：面板组件，非顶层容器
        JPanel panel1 = new JPanel();
        JPanel panel2 = new JPanel();
        JPanel panel3 = new JPanel();
        JPanel panel4 = new JPanel();
        JPanel panel5 = new JPanel();
        JPanel panel6 = new JPanel();
        JPanel panel7 = new JPanel();
        JPanel panel8 = new JPanel();
        JPanel panel9 = new JPanel();
        /*
         * 设置一个大标题，即图书管理系统，放到面板panel1里面
         */
        JLabel labTitle = new JLabel("参数设置");//设置窗口标题
        Font font1 = new Font("宋体", Font.BOLD, 50);//设置字形，字体和字号
        labTitle.setFont(font1);
        panel1.add(labTitle);
        panel1.setBounds(260, 20, 300, 80);//设置窗口位置和大小
        frame.add(panel1);

        /*
         * 核函数
         */
        Font font = new Font("宋体", Font.BOLD, 16);
        JLabel labCard = new JLabel("核函数  ");// 用标签来表示文本或图片
        labCard.setFont(font);// 设置标签字体的大小
        panel.add(labCard);// 将lable标签添加到面板上

        /*
         * 设置下拉框
         */
        JComboBox<String> jcb = new JComboBox<String>();
        Dimension dim = new Dimension(200, 30);//设置组件的宽和高
        jcb.setPreferredSize(dim);

        jcb.addItem("线性核");
        jcb.addItem("多项式核");
        jcb.addItem("RBF核");
        jcb.addItem("sigmoid核");

        jcb.setFont(font);
        panel.add(jcb);
        panel.setBounds(250, 100, 300, 50);
        frame.add(panel);

        /*
         * /* degree
         */
        JLabel jdegree = new JLabel("degree  ");// 用标签来表示文本或图片
        jdegree.setFont(font);// 设置标签字体的大小
        panel2.add(jdegree);// 将lable标签添加到面板上

        JTextField degree = new JTextField();
        degree.setPreferredSize(dim);

        panel2.add(degree);
        panel2.setBounds(250, 150, 300, 50);// 设置面板的位置和大小
        frame.add(panel2);// 添加面板到窗口中


        /*
         * weight
         */
        JLabel jweight = new JLabel("shrinking ");
        jweight.setFont(font);
        panel3.add(jweight);

        JTextField shrinking = new JTextField();
        shrinking.setPreferredSize(dim);
        panel3.add(shrinking);
        panel3.setBounds(250, 200, 300, 50);
        frame.add(panel3);

        /**
        *  coef
         */
        JLabel jcoef = new JLabel("coef    ");
        jcoef.setFont(font);
        panel4.add(jcoef);

        JTextField coef = new JTextField();
        coef.setPreferredSize(dim);
        panel4.add(coef);
        panel4.setBounds(250, 250, 300, 50);
        frame.add(panel4);

        /**
         * svm
         */
        JLabel je = new JLabel("svm     ");
        je.setFont(font);
        panel5.add(je);

        JComboBox<String> te = new JComboBox<String>();
        Dimension dims = new Dimension(200, 30);//设置组件的宽和高
        te.setPreferredSize(dims);

        te.addItem("C-SVC");
        te.addItem("V-SVC");
        te.addItem("one-class-SVM");
        te.addItem("ε-SVR");
        te.addItem("n - SVR");

        te.setFont(font);
        panel5.add(te);
        panel5.setBounds(250, 300, 300, 50);
        frame.add(panel5);



        /**
         * cost
         */

        JLabel jcost = new JLabel("cost    ");
        jcost.setFont(font);
        panel6.add(jcost);

        JTextField cost = new JTextField();
        cost.setPreferredSize(dim);
        panel6.add(cost);
        panel6.setBounds(250, 350, 300, 50);
        frame.add(panel6);


        /*
         * 设置一个按钮
         */
        Dimension dim1 = new Dimension(80, 30);
        JButton jb1 = new JButton("提交");
        JButton jb2 = new JButton("重置");
        jb1.setFont(font);
        jb2.setFont(font);
        jb1.setPreferredSize(dim1);
        jb2.setPreferredSize(dim1);
        panel7.add(jb1);
        panel8.add(jb2);
        panel7.setBounds(325, 400, 80, 50);
        panel8.setBounds(445, 400, 80, 50);
        frame.add(panel7);
        frame.add(panel8);

        frame.setVisible(true);// 显示窗口


        /**
         * 准确率
         */
        JLabel jcar = new JLabel("准确率 ");
        jcar.setFont(font);
        panel9.add(jcar);

        JTextField car = new JTextField();
        car.setPreferredSize(dim);
        panel9.add(car);
        panel9.setBounds(250, 600, 300, 50);
        frame.add(panel9);

        jb2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                car.setText("");
                degree.setText("3");
                coef.setText("0");
                cost.setText("1");
                shrinking.setText("1");
                //System.out.println(jcb.getSelectedIndex());
            }
        });

        jb1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ArrayList<String> list = new ArrayList<>();
                list.add("-h");list.add(shrinking.getText());
                list.add("-d");list.add(degree.getText());
                list.add("-r");list.add(coef.getText());
                list.add("-c");list.add(cost.getText());
                list.add("-s");list.add(String.valueOf(te.getSelectedIndex()));

                list.add("-t");list.add(String.valueOf(jcb.getSelectedIndex()));
                System.out.println(list);
                try {
                    String scar = svmMain.getcar(list);
                    car.setText(scar);
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                    throw new RuntimeException(ioException);
                }


            }
        });
    }
}
