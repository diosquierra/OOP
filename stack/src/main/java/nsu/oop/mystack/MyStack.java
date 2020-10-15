package nsu.oop.mystack;

public class MyStack {

    /**
     * All classes are the same except datatype.
     *
     *  So it has a private integer variable index which is pointing on the last free space,
     * Array link: *type_name*stack,
     * Constructor which gets array,
     * Public method push which gets element and push it,
     * Public method pop which returns the last element in array,
     * Public method count which returns variable index.
     */

    public static class CrtByte{
        private int index = 0;

        public byte[] bytestack;

        public CrtByte(byte[] array){
            bytestack = array;
        }

        public void push(byte elem){
            bytestack[index] = elem;
            index++;
        }

        public byte pop(){
            index--;
            return bytestack[index];
        }

        public int count(){
            return index;
        }
    }

    public static class CrtShort{
        private int index = 0;

        public short[] shortstack;

        public CrtShort(short[] array){
            shortstack = array;
        }

        public void push(short elem){
            shortstack[index] = elem;
            index++;
        }

        public short pop(){
            index--;
            return shortstack[index];
        }

        public int count(){
            return index;
        }
    }

    public static class CrtInt{
        private int index = 0;

        public int[] intstack;

        public CrtInt(int[] array){
            intstack = array;
        }

        public void push(int elem){
            intstack[index] = elem;
            index++;
        }

        public int pop(){
            index--;
            return intstack[index];
        }

        public int count(){
            return index;
        }
    }

    public static class CrtLong{
        private int index = 0;

        public long[] longstack;

        public CrtLong(long[] array){
            longstack = array;
        }

        public void push(long elem){
            longstack[index] = elem;
            index++;
        }

        public long pop(){
            index--;
            return longstack[index];
        }

        public int count(){
            return index;
        }
    }

    public static class CrtFloat{
        private int index = 0;

        public float[] floatstack;

        public CrtFloat(float[] array){
            floatstack = array;
        }

        public void push(float elem){
            floatstack[index] = elem;
            index++;
        }

        public float pop(){
            index--;
            return floatstack[index];
        }

        public int count(){
            return index;
        }
    }

    public static class CrtDouble{
        private int index = 0;

        public double[] doublestack;

        public CrtDouble(double[] array){
            doublestack = array;
        }

        public void push(double elem){
            doublestack[index] = elem;
            index++;
        }

        public double pop(){
            index--;
            return doublestack[index];
        }

        public int count(){
            return index;
        }
    }

    public static class CrtBoolean{
        private int index = 0;

        public boolean[] booleanstack;

        public CrtBoolean(boolean[] array){
            booleanstack = array;
        }

        public void push(boolean elem){
            booleanstack[index] = elem;
            index++;
        }

        public boolean pop(){
            index--;
            return booleanstack[index];
        }

        public int count(){
            return index;
        }
    }

    public static class CrtChar{
        private int index = 0;

        public char[] charstack;

        public CrtChar(char[] array){
            charstack = array;
        }

        public void push(char elem){
            charstack[index] = elem;
            index++;
        }

        public char pop(){
            index--;
            return charstack[index];
        }

        public int count(){
            return index;
        }
    }

    public static class CrtString{
        private int index = 0;

        public String[] stringstack;

        public CrtString(String[] array){
            stringstack = array;
        }

        public void push(String elem){
            stringstack[index] = elem;
            index++;
        }

        public String pop(){
            index--;
            return stringstack[index];
        }

        public int count(){
            return index;
        }
    }

}
