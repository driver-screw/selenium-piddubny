package core;

/**
 * Created with IntelliJ IDEA.
 * User: admin
 * Date: 16.06.14
 * Time: 19:37
 * To change this template use File | Settings | File Templates.
 */

import java.util.Scanner;
public class Kvadratnoe_UR {

    public double Discr(int a, int b, int c){
        double D= Math.pow(b,2)-4*a*c;
        return D;
    }

    public double Korni_x1 (int a, int b, int c, double D){

        double x1;
        x1=(- b- Math.sqrt(D)/2/a);
        return x1;
    }
    public double Korni_x2 (int a, int b, int c, double D){

        double x2;
        x2=(- b + Math.sqrt(D)/2/a);
        return x2;
    }

    public static void main(String[] Str) {
        int a, b, c;
        System.out.println("Введите коэффициенты квадратного уравнения a b c");
        Scanner scan = new Scanner(System.in);
        a = scan.nextInt();
        b = scan.nextInt();
        c = scan.nextInt();
        Kvadratnoe_UR ur = new Kvadratnoe_UR();

        if (ur.Discr(a,b,c)<0)  System.out.println( "Дискриминант Д= "+ ur.Discr(a,b,c)+ " <0. Решений нет.")  ;
                else {
            System.out.println( "Корни квадратного уравнения: x1= "+ ur.Korni_x1(a,b,c,ur.Discr(a,b,c))+ "  x2 = "+ur.Korni_x2(a,b,c,ur.Discr(a,b,c)));

        }
        //System.out.println( ur.Discr(a,b,c));
    }

}
