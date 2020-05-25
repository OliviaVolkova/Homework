public class Complex {
    public static void main(String[] args) {
        Complex c1 = new Complex(4,1);
        Complex c2 = new Complex(2,5);
        System.out.println(c1.divide(c2));
    }
    private double imaginary;
    private double real;
    public double getImaginary(){
        return imaginary;
    }

    double getReal(){
        return real;
    }

    Complex(double real,double imaginary){
        this.imaginary=imaginary;
        this.real=real;
    }

    Complex(Complex num){
        this.imaginary=num.getImaginary();
        this.real=num.getReal();
    }
    public String toString(){
        String s=" + ";
        int i=1;
        if(imaginary<0){
            s=" - ";
            i*=-1;
        }
        return(""+real+s+"("+imaginary*i+")i");
    }

    public Complex add(Complex num){
        return(new Complex(real+num.getReal(),imaginary+num.getImaginary()));
    }

    public Complex subtract(Complex num){
        return(new Complex(real-num.getReal(),imaginary-num.getImaginary()));
    }

    public Complex multiply(Complex num){
        return(new Complex(real*num.getReal()-imaginary*num.getImaginary(),real*num.getImaginary()+imaginary*num.getReal()));
    }

    public Complex divide(Complex num){
        if(num.getReal()==0 && num.getImaginary()==0){
            System.out.println("Ошибка деления на ноль");
            return null;
        }
        return(new Complex((real*num.getReal()+imaginary*num.getImaginary())/(num.getReal()*num.getReal()+num.getImaginary()*num.getImaginary()),(num.getReal()*imaginary-num.getImaginary()*real)/(num.getReal()*num.getReal()+num.getImaginary()*num.getImaginary())));
    }
    public boolean equals(Complex num){
        if(real==num.getReal()&&imaginary==num.getImaginary())return true;
        return false;
    }

}