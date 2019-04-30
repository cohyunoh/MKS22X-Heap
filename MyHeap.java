import java.util.Arrays;
public class MyHeap{

  private static void pushDown(int[]data,int size,int index){
    //will keep performing this code block until we find a position where the child or children are all less than the value
    //at index. Or it will go until is has no children
    while(((2*index + 1) < size && data[(2*index + 1)] > data[index]) || ((2*index + 2) < size && data[(2*index + 2)] > data[index])){
      //these will store the value of the greatest child and its index
      int child = 0;
      int childIndex = 0;
      //checks if both children exist
      if((2*index + 1) < size && (2*index + 2) < size){
        //then checks if the first one is greater
        if(data[(2*index + 1)] > data[(2*index + 2)]){
          //then it assigns the correct values to child and childIndex
          //from the first child
          child = data[(2*index + 1)];
          childIndex = (2*index + 1);
        }else{
          //if the second child is greater then assign its values
          child = data[(2*index + 2)];
          childIndex = (2*index + 2);
        }
      //if child one only exists then clearly it is the only child
      }else if((2*index + 1) < size && (2*index + 2) >= size){
        child = data[(2*index + 1)];
        childIndex = (2*index + 1);
      }
      //if there is no first child then there can't be a second since it will just shift over
      //swap with child since it must be greater at this point
      data[childIndex] = data[index];
      data[index] = child;
      index = childIndex;
    }
  }

  private static void pushUp(int[]data, int index){
    //while parent is less keep pushing up and swapping with parent
    while(((index - 1) / 2) >= 0 && data[((index - 1) / 2)] < data[index]){
      int parentIndex = ((index - 1) / 2);
      int temp = data[parentIndex];
      data[parentIndex] = data[index];
      data[index] = temp;
      index = parentIndex;
    }
  }

  public static void heapify(int[] data){
    //go bnackwards and pushdown all values
    for(int i = data.length - 1; i > -1; i--){
      //System.out.println(data[i]);
      pushDown(data, data.length, i);
    }
  }

  public static void heapsort(int[] data){
    //heapify the array
    heapify(data);
    //keep track of size
    int size = data.length;
    //do it until size is zero
    while(size > 0){
      //swap first and last value
      //System.out.println(Arrays.toString(data));
      int temp = data[size - 1];
      data[size - 1] = data[0];
      data[0] = temp;
      //System.out.println(Arrays.toString(data));
      //decrease the size since the value at the end is now in place
      size -= 1;
      //pushdown the first value to reheapify
      pushDown(data, size, 0);
      //System.out.println(Arrays.toString(data));
    }
  }

  public static void main(String[] args) {
    int[] data = {25, 40, 45, 20, 30, 0, 0, 0};
    System.out.println(Arrays.toString(data));
    pushDown(data, 5, 0);
    System.out.println(Arrays.toString(data));
    int[] data1 = {25, 15, 45, 20, 30, 0, 0, 0};
    System.out.println(Arrays.toString(data1));
    pushUp(data, 4);
    System.out.println(Arrays.toString(data));
    int[] data2 = {25, 15, 45, 20, 30, 4, 50, 2, 56, 64, 47, 102, 5};
    System.out.println(Arrays.toString(data2));
    heapify(data2);
    System.out.println(Arrays.toString(data2));
    pushDown(data2, 8, 1);
    int[] data3 = {25, 15, 45, 20, 30, 4, 50, 2, 56, 64, 47, 102, 5};
    System.out.println(Arrays.toString(data3));
    heapsort(data3);
    System.out.println(Arrays.toString(data3));
  }
}
