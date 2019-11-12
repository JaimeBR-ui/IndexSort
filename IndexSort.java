// Jaime Bohorquez

// This is a sorting algorithm I came up with.
// After programming it, I researched a bit and found that
// there seems to exist something similar/better that is called
// Index Sort, hence the name of this program.

// This sort is very fast for low ranges in data.
// Ex: array that has numbers from 1 - 10,000.
// The length of the array is not the major contrubutor to runtime,
// instead, it is the range of the data set.

public class IndexSort
{
     public static void main(String[] args)
     {
          long startTime, endTime;
          int [] arr = new int[100000000]; // Array of length 10 million.

          // Fill the array.
          for (int i = 0; i < arr.length; i++)
               arr[i] = (int)(Math.random()*10000); // Range from 0 - 9999.

          // Print the array.
          for (int i = 0; i < arr.length; i++)
                System.out.print(arr[i] + " ");

          // Index sort.
          System.out.println("Sorting stating");
          startTime = System.nanoTime();
          IndexSort(arr);
          endTime = System.nanoTime();
          System.out.println("Index Sort Took: "+
                         (endTime - startTime) / (Math.pow(10,9))
                         + " s");
          // These values come from a dataset of range 0 - 9999.
          // Takes approx 0.065 seconds to sort 10 million elements.
          // Takes approx 0.455 seconds to sort 100 million elements.

          // Print the sorted array.
          for (int i = 0; i < arr.length; i++)
                System.out.print(arr[i] + " ");

     }

     public static void IndexSort(int [] array)
     {
          // TODO: Sort integers! For now, it works for non negative integers

          MiniNode [] retArray = new MiniNode[maxValue(array) + 1];

          for(int i = 0; i < array.length; i++)
          {
               if (retArray[array[i]] == null)
                    retArray[array[i]] = new MiniNode(array[i]);
               else
                    retArray[array[i]].counter++;
          }

          int index = 0;

          // Loop that fills back the array.
          for (MiniNode e : retArray)
               if (e != null)
                    for (int i = 0; i < e.counter; i++, index++)
                         array[index] = e.data;
     }

     public static int maxValue(int [] array)
     {
          // Return the maximum value in the array.
          // Should use Integer wrapper class.
          if (array == null || array.length == 0)
               return -1;

          int max = array[0];

          for (int i = 1; i < array.length; i++)
               if (array[i] > max)
                    max = array[i];
          
          return max;
     }
}

class MiniNode
{
     int data = -1;
     int counter = 1;

     MiniNode(int data)
     {
          this.data = data;
     }
}
