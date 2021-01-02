package com.svm;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class svmMain {
    static List<String> predict = new ArrayList<>();

    static List<String> test = new ArrayList<>();

    public static String getcar(List<String> arg) throws IOException {
        init();

        String[] por = arg.toArray(new String[14]);
        por[12] = "train/12.txt";
        por[13] = "train/model_12.txt";
        //System.out.println(Arrays.toString(por));
        svm_train t12 = new svm_train();
        t12.main(por);


        por[12] = "train/13.txt";
        por[13] = "train/model_13.txt";
        svm_train t13 = new svm_train();
        t13.main(por);


        por[12] = "train/23.txt";
        por[13] = "train/model_23.txt";
        svm_train t23 = new svm_train();
        t23.main(por);

        String[] parg12 = {"train/winetx.txt", // 这个是存放测试数据
                "train/model_12.txt", // 调用的是训练以后的模型
                "train/out_12.txt"}; // 生成的结果的文件的路径
        svm_predict p12 = new svm_predict();
        p12.main(parg12); // 调用

        String[] parg13 = {"train/winetx.txt", // 这个是存放测试数据
                "train/model_13.txt", // 调用的是训练以后的模型
                "train/out_13.txt"}; // 生成的结果的文件的路径
        svm_predict p13 = new svm_predict();
        p13.main(parg13); // 调用

        String[] parg23 = {"train/winetx.txt", // 这个是存放测试数据
                "train/model_23.txt", // 调用的是训练以后的模型
                "train/out_23.txt"}; // 生成的结果的文件的路径
        svm_predict p23 = new svm_predict();
        p23.main(parg23); // 调用


        fina();

        int num = 0;
        for (int i = 0; i < predict.size(); i++) {
            if (predict.get(i).equals(test.get(i)))
                num++;
        }

        String fp= ((double) num * 100) / predict.size() + "%";

        predict.clear();
        test.clear();

        return fp;
    }

    static void init() throws IOException {
        FileReader fileReader = new FileReader("train/wine.txt");
        BufferedReader bufferedReader = new BufferedReader(fileReader);

        FileWriter fileWriter12 = new FileWriter("train/12.txt");
        BufferedWriter bw12 = new BufferedWriter(fileWriter12);

        FileWriter fileWriter13 = new FileWriter("train/13.txt");
        BufferedWriter bw13 = new BufferedWriter(fileWriter13);

        FileWriter fileWriter23 = new FileWriter("train/23.txt");
        BufferedWriter bw23 = new BufferedWriter(fileWriter23);

        String str;
        while ((str = bufferedReader.readLine()) != null) {
            String fp = str.split(" ")[0];
            if (fp.equals("1")) {
                bw12.write(str);
                bw12.newLine();
                bw12.flush();

                bw13.write(str);
                bw13.newLine();
                bw13.flush();
            } else if (fp.equals("2")) {
                bw12.write(str);
                bw12.newLine();
                bw12.flush();

                bw23.write(str);
                bw23.newLine();
                bw23.flush();
            } else {
                bw23.write(str);
                bw23.newLine();
                bw23.flush();

                bw13.write(str);
                bw13.newLine();
                bw13.flush();
            }

        }


        bufferedReader.close();
        bw12.close();
        bw13.close();
        bw23.close();


        FileReader testfile = new FileReader("train/winetx.txt");
        BufferedReader tbf = new BufferedReader(testfile);

        while ((str = tbf.readLine()) != null) {
            String fp = str.split(" ")[0];
            test.add(fp);
        }

    }


    static void fina() throws IOException {
        FileReader fileReader12 = new FileReader("train/out_12.txt");
        BufferedReader b12 = new BufferedReader(fileReader12);

        FileReader fileReader13 = new FileReader("train/out_13.txt");
        BufferedReader b13 = new BufferedReader(fileReader13);

        FileReader fileReader23 = new FileReader("train/out_23.txt");
        BufferedReader b23 = new BufferedReader(fileReader23);

        String str12;
        while ((str12 = b12.readLine()) != null) {

            String str13 = b13.readLine();
            String str23 = b23.readLine();

            double d12 = Double.parseDouble(str12);
            double d13 = Double.parseDouble(str13);
            double d23 = Double.parseDouble(str23);

            int i12 = Math.abs(d12 - 1) > Math.abs(2 - d12) ? 2 : 1;
            int i13 = Math.abs(d13 - 1) > Math.abs(3 - d13) ? 3 : 1;
            int i23 = Math.abs(d23 - 2) > Math.abs(3 - d23) ? 3 : 2;

            if(i12==i13 || i12==i23){
                predict.add(String.valueOf(i12));
            }else if(i13== i23){
                predict.add(String.valueOf(i23));
            }else {
                predict.add(String.valueOf(i12));
            }
        }
    }

    public static void main(String[] args) throws IOException {
        FileReader fileReader = new FileReader("train/wine.txt");
        BufferedReader bufferedReader = new BufferedReader(fileReader);

        System.out.println(bufferedReader.readLine());
    }
}
