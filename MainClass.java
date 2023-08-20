import java.util.Scanner;
public class MainClass{ 
  public static void main(String args[]){
       Scanner _key = new Scanner(System.in);
int  a;
double  b;
double  c;
String  t1;
a= _key.nextInt();
b= _key.nextDouble();
c = 10.5;
b = 1+2*3/c;
System.out.println(b);
if (b>c) {
System.out.println(b);}else {
System.out.println(c);}


while (a>b) {
a= _key.nextInt();}

do {
a= _key.nextInt();} while (a>b);

  }}