/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package decodeprimesnumbers;
import java.util.*;

/**
 *
 * @author levchuk
 */
public class DecodePrimesNumbers {

    public static int NumberPrimesNumbers=0;
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int k=0;
        int[] ArrayNumbersPrimes;
        Scanner scanner = new Scanner(System.in);
        final Random random = new Random();
        boolean BoolRandomEntry=true;
        int RandomEntry;
        boolean NeedChooce=true;
        System.out.println("Select the type of input values.");
        System.out.println("Enter 0 if you want to enter the values ​​yourself.");
        System.out.println("Enter 1 if you want to random values.");
        while(NeedChooce){
            RandomEntry = scanner.nextInt();
            switch(RandomEntry){
                case 0: {BoolRandomEntry=false;NeedChooce=false;};break;
                case 1: {BoolRandomEntry=true;NeedChooce=false;};break;
                default: System.out.println("Please select the type of input values.");
            }
        }
        boolean FirstTry = true;
        while(k<1){
            if((FirstTry)&&(!BoolRandomEntry)){
                System.out.println("Enter the number of index primes numbers.");
                FirstTry = false;
            }else{
                if(!BoolRandomEntry){
                    System.out.println("Error! Please enter value from 1 to 2147483647.");
                }
            }
            try{
                if(!BoolRandomEntry){
                    k = scanner.nextInt();
                }else{
                    //Для простоты эксперемента число до 5
                    k = random.nextInt(5);
                    if(k>0){
                        System.out.println("Количество элементов:" + k);
                    }
                }       
                //n=6;
            } catch(Exception e){
                scanner.nextLine();
            }
        }  
        ArrayNumbersPrimes = new int[15000];
        GetArrayPrimesValues(ArrayNumbersPrimes);
        int[] CopyArray = ArrayNumbersPrimes.clone();
        ArrayNumbersPrimes = new int[NumberPrimesNumbers];
        int i;
        for(i=0;i<NumberPrimesNumbers;i++){
            ArrayNumbersPrimes[i] = CopyArray[i];
        }
        int[] ArrayForDecryption = new int[k];
        if(!BoolRandomEntry){System.out.print("Введите индексы простых чисел от 1 до "
                +NumberPrimesNumbers+" :\n");}
        for(i=0;i<ArrayForDecryption.length;i++){
            if(BoolRandomEntry){
                ArrayForDecryption[i] = random.nextInt(NumberPrimesNumbers);
            }else{
                ArrayForDecryption[i]=scanner.nextInt();
                scanner.nextLine();
            }
        }
        System.out.print("Индексы простых чисел:\n");
        for(i=0;i<ArrayForDecryption.length;i++){
            System.out.print(ArrayForDecryption[i]+" ");
        }
        System.out.print("\n");
        System.out.print("Простые числа по индексам:\n");
        for(i=0;i<ArrayForDecryption.length;i++){
            System.out.print(ArrayNumbersPrimes[ArrayForDecryption[i]-1]+" ");
        }
        System.out.println("Then end!");
        
    }
    
    public static void GetArrayPrimesValues(int[] ArrayPrimesValues){
        int g=1;
        for(int i =1;i<=ArrayPrimesValues.length;i++){
            g=1;
            for(int j=2;j<=i;j++){
                if((i%j)==0){
                    g++;
                }
            }
            if(g==2){
                ArrayPrimesValues[NumberPrimesNumbers]=i;
                NumberPrimesNumbers++;
            }
        }
        
    }
}
