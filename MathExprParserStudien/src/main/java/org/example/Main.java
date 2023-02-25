package org.example;
import org.nd4j.linalg.api.ndarray.INDArray;
import org.nd4j.linalg.factory.Nd4j;


public class Main {
    public static void main(String[] args) {
        double arr_2d[][]={{1.0,2.0,3.0},{4.0,5.0,6.0},{7.0,8.0,9.0}};
        INDArray x_2d = Nd4j.createFromArray(arr_2d);
        System.out.println(x_2d);
        System.out.println(x_2d.rank());
    }
}