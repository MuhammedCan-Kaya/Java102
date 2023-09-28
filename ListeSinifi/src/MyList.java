public class MyList<T> {

    private int capacity;
    private T[] arr;
    private int numberOfElements = 0;

    public MyList() {
        this.capacity = 10;
        arr = (T[]) new Object[capacity];
    }

    public MyList(int capacity) {
        this.capacity = capacity;
        arr = (T[]) new Object[capacity];
    }

    public int size() {
        int counter = 0;
        for (Object x : arr) {
            if (x != null) {
                counter++;
            }
        }
        this.numberOfElements = counter;
        return this.numberOfElements;
    }

    public int getCapacity() {
        return capacity;
    }

    public void add(T data) {
        if (numberOfElements == this.capacity - 1) {
            this.capacity *= 2;
            T[] tempArr = (T[]) new Object[capacity];
            for (int i = 0; i < size(); i++) {
                tempArr[i] = arr[i];
            }
            arr = tempArr;
        }
        arr[numberOfElements] = data;
        numberOfElements++;
    }

    public Integer get(int index) { // parametre bölümüne yazılan indeksteki değeri döndüdür.
        if (index >= numberOfElements || index < 0) {
            return null;
        }
        return (Integer) arr[index];
    }

    public void remove(int index) { //
        if (index >= numberOfElements || index < 0) {
            System.out.println("null");
        }
        for (int i = index; i < numberOfElements - 1; i++) {
            arr[i] = arr[i + 1];
        }
        arr[numberOfElements - 1] = null;
        numberOfElements--;
    }

    public Object set(int index, T data) {
        if (index >= numberOfElements || index < 0) {
            return null;
        }
        arr[index] = data;
        System.out.println("Belirtilen indeksteki veri" + ", " + data + " ile değiştirildi.");
        return arr[index];
    }

    public void toSttring() {
        System.out.print("[");
        boolean ilkEleman = true;
        for (Object i : arr) {
            if (i != null) {
                if (!ilkEleman) {
                    System.out.print(", ");
                }
                System.out.print(i);
                ilkEleman = false;
            }
        }
        System.out.println("]");
    }

    public int indexOf(T data) {
        int index = -1;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == data) {
                index = i;
                break;
            }
        }
        return index;
    }

    public int lastIndexOf(T data) {
        int index = -1;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == data) {
                index = i;
            }
        }
        return index;
    }

    public boolean isEmpty() {
        int counter = 0;
        for (Object i : arr){
            if(i == null){
                counter ++;
            }
            if(counter == arr.length){
                return true;
            }
        }
        return false;
    }

    public T[] toArray(){
        Object[] transfer = new Object[arr.length];
        transfer = arr;
        return (T[]) transfer;
    }

    public void clear(){
        for (int i = 0; i < arr.length; i++) {
            arr[i] = null;
        }
    }

    public void subList(int start, int finish){
        boolean ilkEleman = true;
        Object[] transfer = new Object[finish - start + 1];
        int a = 0;
        for(int i = start; i <= finish; i++, a++){
            transfer[a] = arr[i];
        }
        System.out.print("[");
        for(Object i : transfer){
            if(!ilkEleman){
                System.out.print(", ");
            }
            System.out.print(i);
            ilkEleman = false;
        }
        System.out.println("]");
    }

    public boolean contains(T data){
        for (Object i : arr){
            if(i == data){
                return true;
            }
        }
        return false;
    }
}