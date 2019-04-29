import java.util.Arrays;
public class MyHeap{

  private static void pushDown(int[]data,int size,int index){
    while((2*index + 1) < data.length && (2*index + 2) < data.length && (data[(2*index + 1)] > data[index] || data[(2*index + 2)] > data[index])){
      if(data[(2*index + 1)] > data[index]){
        int temp = data[(2*index + 1)];
        data[(2*index + 1)] = data[index];
        data[index] = temp;
        index = 2*index + 1;
      }else if(data[(2*index + 2)] > data[index]){
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

  public static void main(String[] args) {
    int[] data = {25, 40, 45, 20, 30, 0, 0, 0};
    System.out.println(Arrays.toString(data));
    pushDown(data, 5, 0);
    System.out.println(Arrays.toString(data));
    int[] data1 = {25, 15, 45, 20, 30, 0, 0, 0};
    System.out.println(Arrays.toString(data1));
    pushUp(data, 4);
    System.out.println(Arrays.toString(data));
  }
}
