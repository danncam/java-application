/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package list;

import java.util.Scanner;

/**
 *
 * @author Dan
 */
public class Test {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        IndexedList<Integer> list = new IndexedList<>();
        list.add(0, 0);
        list.add(1, 1);
        list.add(2, 2);
        list.add(2, 3);
        int r = list.remove(2);
        int s = list.search(r);
        System.out.println(list.toString());
        int v;
        while(true)
        {
            v = in.nextInt();
            int elem, index;
            
            switch(v){
                case 1:
                    System.out.println("Adding element to list:");
                    System.out.println("Element: ");
                    elem = in.nextInt();
                    System.out.println("Index: ");
                    index = in.nextInt();
                    list.add(elem, index);
                    break;
                case 2:
                    System.out.println("Removing element from list:");
                    System.out.println("Index: ");
                    index = in.nextInt();
                    list.remove(index);
                    break;
                case 3:
                    System.out.println("Getting element from list");
                    System.out.println("index: ");
                    index = in.nextInt();
                    list.get(index);
                    break;
                case 4:
                    System.out.println("Setting element from list");
                    System.out.println("Element: ");
                    elem = in.nextInt();
                    System.out.println("Index: ");
                    index = in.nextInt();
                    list.set(elem, index);
                    break;
                case 5:
                    System.out.println("Searching on list");
                    System.out.println("Element");
                    elem = in.nextInt();
                    index = list.search(elem);
                    break;
            }
        }
        
//        int [] a = {0, 1, 0, 0, 0, 0, 0, 0};
//      //int [] b = {0, 1, 2, 3, 5, 6, 7}  
//        int [] b = resize(a, -5);
//        for (int i : b) {
//            System.out.print(i + " ");
//        }
//        System.out.println("\n"+b.length);
    }
    public static int[] realocate(int[] array, int index, int offset)
    {
        if(offset > 0)
        {
            int[] newarray = new int[array.length + offset];
            System.arraycopy(array, 0, newarray, 0, index);
            System.arraycopy(array, index, newarray, index + 1, array.length - index);
            return newarray;
        } else {
            int[] newarray = new int[array.length + offset];
            System.out.println("index - offset: " + (index - offset));
            System.arraycopy(array, 0, newarray, 0, index);
            System.arraycopy(array, index - offset, newarray, index - offset - 1, array.length - index - 1);
            return newarray;
        }
    }
    public static int[] resize(int[] array, int offset)
    {   
            System.out.println(offset);
            int[] newarray = new int[array.length + offset];
            System.arraycopy(array, 0, newarray, 0, newarray.length);
            return newarray;
    }
}
