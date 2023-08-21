import java.util.Scanner;
public class MainClass{ 
  public static void main(String args[]){
       Scanner _key = new Scanner(System.in);
int  a;
double  b;
double  c;
double  d;
double  e;
double  f;
String  t1;
a = 2;
e = 1.0;
d = 1.0;
c = 1.0;
b = c/d;
if (e<b) {
System.out.println(b);}else {
System.out.println(e);}

d = 1.0;

while (d>b) {
b= _key.nextDouble();}

do {
b= _key.nextDouble();} while (e>b);

  }}