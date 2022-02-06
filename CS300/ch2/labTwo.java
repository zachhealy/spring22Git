package CS300.ch2;

class labTwo {
    public static void main(String[] args) {

        MyArray<Integer> F = new MyArray(Integer.class);
        for(int i = 0; i < MyArray.CAPACITY; i++)
            F.Insert((int)(Math.random() * (999 - 0)), i);

        System.out.println("\n Double End Sort");        

        for(int i = 0; i < MyArray.CAPACITY; i++)
            System.out.print(F.get(i) + ", ");

        System.out.println();       

        F.dSelSort();
        
        for(int i = 0; i < MyArray.CAPACITY; i++)
            System.out.print(F.get(i) + ", ");

        System.out.println(); 

    }
}