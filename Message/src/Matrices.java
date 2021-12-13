import Jama.Matrix;
public class Matrices {
    static double[][] codedArray = new double[Main.rows][Main.rows];
    static double[][] keyArray = new double[Main.rows][Main.rows];
    static double[][] messageArray = new double[Main.rows][Main.rows];
    static double[][] plaintextArray = new double[Main.rows][Main.rows];
    static private Matrix keyMatrix;
    static private Matrix cryptMatrix;
    static private Matrix plaintextMatrix;
    static private Matrix codedMatrix;
    static private Matrix messageMatrix;
    public static void setKeyMatrix() {
            keyMatrix = new Matrix(keyArray);
        }
    public static void printKeyMatrix() {
            keyMatrix.print(0, 1);
        }
    public static void setCodedMatrix() {
            codedMatrix = new Matrix(codedArray);
        }
    public static void printCodedMatrix() {
        codedMatrix.print(0, 1);
    }
    public static void setMessageMatrix() {
        messageMatrix = keyMatrix.inverse().times(codedMatrix);
    }
    public static double[][] printMessageMatrix() {
        messageArray = messageMatrix.getArrayCopy();
        return messageArray;
    }
    public static void setPlaintextMatrix() {
        plaintextMatrix = new Matrix(plaintextArray);
    }
    public static void setCryptMatrix() {
        cryptMatrix = plaintextMatrix.times(keyMatrix);
    }
    public static void printCryptMatrix() {
        cryptMatrix.print(0, 1);
    }
}

