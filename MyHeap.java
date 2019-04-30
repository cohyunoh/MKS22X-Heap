import java.util.Arrays;
public class MyHeap{

  private static void pushDown(int[]data,int size,int index){
    while((2*index + 1) < data.length && (2*index + 2) < data.length && (data[(2*index + 1)] > data[index] || data[(2*index + 2)] > data[index])){
      if((2*index + 1) < data.length && data[(2*index + 1)] > data[index]){
        int temp = data[(2*index + 1)];
        data[(2*index + 1)] = data[index];
        data[index] = temp;
        index = 2*index + 1;
      }else if((2*index + 2) < data.length && data[(2*index + 2)] > data[index]){
        int temp = data[(2*index + 2)];
        data[(2*index + 2)] = data[index];
        data[index] = temp;
        index = 2*index + 2;
      }
    }
  }

  private static void pushUp(int[]data, int index){
    while(((index - 1) / 2) >= 0 && data[((index - 1) / 2)] < data[index]){
      int parentIndex = ((index - 1) / 2);
      int temp = data[parentIndex];
      data[parentIndex] = data[index];
      data[index] = temp;
      index = parentIndex;
    }
  }

  public static void heapify(int[] data){
    for(int i = data.length - 1; i > -1; i--){
      //System.out.println(data[i]);
      pushDown(data, data.length, i);
      pushUp(data, i);
    }
  }

  public static void heapsort(int[] data){
    heapify(data);
    int size = data.length;
    while(size > 0){
      int temp = data[size - 1];
      data[size - 1] = data[0];
      data[0] = temp;
      size --;
      pushDown(data, size, 0);
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
