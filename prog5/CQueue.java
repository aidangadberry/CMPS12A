class CQueue{

    //variable declaration
    float buffer[];
    int size;

    CQueue(int capacity){
        size = capacity;
        buffer = new float[capacity];

        for(int i=0; i<size; i++){
            buffer[i] = 0;
        }
    }

    //method that returns the size of the array
    public int size(){
        return size;
    }

    //method that shifts all of the elements of the array to the left by 1, moving the first element to the last spot
    public void shift(){
        float temp = buffer[0];
        int i;

        for(i=0; i<size-1; i++){
            buffer[i] = buffer[i+1];
        }
        buffer[i] = temp;
    }

    //prints all of the elements of the array in a fancy list
    public void print(){
        for(int i=0; i<size; i++){
            System.out.format("Element" + "%5d:%6.2f\n", i, buffer[i]);
        }
    }
}