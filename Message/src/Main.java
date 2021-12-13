import java.util.HashMap;
import java.util.Scanner;
public class Main {
    static HashMap<String, Integer> dict = new HashMap<String, Integer>();
    static String[] alpha = {"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", 
                                "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z", " ", "?", "%", "$"};
    static double[][] matrixInput;
    static Integer rows = 0;

    public static void main(String[] args) {
        Main.makeDict();
        Scanner scan = new Scanner(System.in);
        System.out.println("Select Mode:           (h - for help)");
      while (true) {
            String input = scan.nextLine();
            if (input.equals("h")) {
                System.out.println("S - send a message\nD - decode a message\nK - change key\nE - exit");
            }
            if (input.equals("e")) {
                scan.close();
                break;
            }
            if (input.equals("k")) {
                System.out.print("Enter rows: (e to exit)");
                Boolean flag = true;
                while (flag) {
                String rowsInput = scan.nextLine().toLowerCase();
                    if (rowsInput.contains("e")) { 
                        flag = false;
                        break;
                    }
                try {
                    rows = Integer.parseInt(rowsInput);
                    matrixInput = new double[rows][rows];
                    for (int i = 0; i < rows; i++)  {
                        System.out.printf("Row #%d\n", i);
                        for (int j = 0; j < rows; j++) {
                            System.out.printf("row %d col %d: ", j, i);
                            matrixInput[i][j] = scan.nextDouble();
                            }   
                        }
                        Matrices.keyArray = matrixInput;
                        Matrices.setKeyMatrix();
                        break;
                    }
                catch (Exception e) {
                            System.out.println("Enter int!");
                            break;
                        }
                }
            }
            if (input.equals("d")) {
                System.out.println("Rows: (e to exit)");
                Boolean flag = true;
                while (flag) {    
                    String rowsInput = scan.nextLine().toLowerCase();
                    if (rowsInput.contains("e")) {
                        flag = false;
                        break;
                    }
                    try {
                    rows = Integer.parseInt(rowsInput);
                    matrixInput = new double[rows][rows];
                    for (int i = 0; i < rows; i++)  {
                        System.out.printf("Row #%d\n", i);
                        for (int j = 0; j < rows; j++) {
                            System.out.printf("row %d col %d: ", j, i);
                            matrixInput[i][j] = scan.nextDouble();
                            }   
                        }
                        Matrices.codedArray = matrixInput;
                        Matrices.setCodedMatrix();
                        Matrices.setMessageMatrix();
                        double[][] messageDouble = Matrices.printMessageMatrix();
                        int messageInt[][] = new int[rows][rows];
                        for (int i = 0; i < rows; i++) {
                            for (int j = 0; j < rows; j++) {
                                messageInt[i][j] = (int) Math.round(messageDouble[i][j]);
                                System.out.printf("%s ", alpha[messageInt[i][j] - 1]);
                            }
                        }
                        break;
                    } catch (Exception e){
                        System.out.println("Enter int!");
                    }
                }
            }
            if (input.equals("s")) {
                System.out.println("Rows: (e to exit)");
                Boolean flag = true;
                while (flag) {
                    String rowsInput = scan.nextLine().toLowerCase();
                    if (rowsInput.contains("e")) {
                        flag = false;
                        break;
                    }
                    try {
                        rows = Integer.parseInt(rowsInput);
                        Integer[][] plaintextInt = new Integer[rows][rows];
                        double[][] plaintextDouble = new double[rows][rows];
                        System.out.printf("Enter a message with %d letters: ", rows * rows);
                        for (int i = 0; i < rows; i++) {
                                for (int j = 0; j < rows; j++) {
                                    System.out.printf("row %d col %d: ", j, i);
                                    String inputString = scan.nextLine();
                                    plaintextInt[i][j] = dict.get("" + inputString.charAt(0));
                                    plaintextDouble[i][j] = plaintextInt[i][j].doubleValue();
                                }
                        }
                        Matrices.plaintextArray = plaintextDouble;
                        Matrices.setPlaintextMatrix();
                        Matrices.setCryptMatrix();
                        Matrices.printCryptMatrix();
                        break;
                    }
                    catch (Exception e) {
                        System.out.println("Enter int!");
                    }
                }
                
            }
        }
    }


       //DEPRECATED
        // // decode array
        // double[][] code = {{2., 3., -1., 1.}, {1., -2., 0., 4.},
        //                      {-1., 3., 1., -3.}, {-2., 1., -3., 1.}};
        
        // // double[][] coded = {{45., 84., 33., 111.}, {79., 86., 73., 66.},
        // //                     {-46., -44., -42., -11.}, {-17., 2., -59., -45.}};

        // double[][] coded = {{45., 54., 87., 43.}, {4., 23., 50., 13.},
        //                      {13., 31., 1., 42.}, {-23., -28., -73., -47.}};

        // // double[][] coded = {{-28., 81., -47., -9.}, {21., 110., -16., 2.},
        // //                      {21., 101., -17., 7.}, {-51., 85., -49., -25.}};
        
        
        // //make a coded array
        // System.out.printf("\n\n\nEnter message with 16 letters: ");
        // String plainText = scan.nextLine();
        // scan.close();
        // int plainArray[];
        // plainArray = new int[16];

        // for (int i = 0; i < 16; i++) {
        //     plainArray[i] = dict.get("" + (plainText.charAt(i)));
        // }
        
        // //bad design but im lazy
        // int toDouble1[] = Arrays.copyOfRange(plainArray, 0, 4); 
        // int toDouble2[] = Arrays.copyOfRange(plainArray, 4, 8);
        // int toDouble3[] = Arrays.copyOfRange(plainArray, 8, 12);
        // int toDouble4[] = Arrays.copyOfRange(plainArray, 12, 16);
        
        // //even worse but im even lazier
        // coded[0] =  Arrays.stream(toDouble1).asDoubleStream().toArray();
        // coded[1] =  Arrays.stream(toDouble2).asDoubleStream().toArray();
        // coded[2] =  Arrays.stream(toDouble3).asDoubleStream().toArray();
        // coded[3] =  Arrays.stream(toDouble4).asDoubleStream().toArray();


        
        // Matrix newCodedMatrix =  new Matrix(coded);

        // Matrix newMessageMatrix = codeMatrix.times(newCodedMatrix);

        // newMessageMatrix.print(1, 1);

    private static void makeDict() { 
        for (int i = 0; i < 29; i++) {
            if (i == 0) {
                dict.put(null, i);
            }
            else {
                dict.put(alpha[i - 1], i);
            }
        }
    }
}
