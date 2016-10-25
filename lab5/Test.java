public class Test{

    public static void main(String[] args) {

        CQueue  my_favorites = new CQueue( 11 );
        int     i;

    for( i=0; i < my_favorites.size(); i++ )
        my_favorites.buffer[i] = (float) 1.1 * (i+1);

        System.out.println( "My favorites" );
        my_favorites.print();
        my_favorites.shift();
        System.out.println( "My new favorites" );
        my_favorites.print();
    }
}

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

    public int size(){
        return size;
    }

    public void shift(){
        float temp = buffer[0];
        int i;

        for(i=0; i<size-1; i++){
            buffer[i] = buffer[i+1];
        }
        buffer[i] = temp;
    }

    public void print(){
        for(int i=0; i<size; i++){
            System.out.format("Element" + "%5d:%6.2f\n", i, buffer[i]);
        }
    }
}