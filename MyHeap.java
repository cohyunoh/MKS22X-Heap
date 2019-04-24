import java.util.Arrays;
public class MyHeap{
  private static void pushDown(int[]data,int size,int index){
    if((2*index + 1) > size - 1 && (2*index + 2) > size - 1){
      return ;
    }else if(data[(2*index + 1)] <= data[index] && data[(2*index + 2)] <= data[index]){
      return ;
    }else if(data[(2*index + 1)] > data[index]){
      int temp = data[(2*index + 1)];
      data[(2*index + 1)] = data[index];
      data[index] = temp;
      index = 2*index + 1;
      pushDown(data, size, index);
    }else if(data[(2*index + 2)] > data[index]){
      int temp = data[(2*index + 2)];
      data[(2*index + 2)] = data[index];
      data[index] = temp;
      index = 2*index + 2;
      pushDown(data, size, index);
    }
  }

  private static void pushUp(int[]data,int index){
    int parentIndex = ((index - 1) / 2);
    if(parentIndex < 0){
      return ;
    }else if(data[parentIndex] >= data[index]){
      return ;
    }else if(data[parentIndex] < data[index]){
      int temp = data[parentIndex];
      data[parentIndex] = data[index];
      data[index] = temp;
      index = parentIndex;
      pushUp(data, index);
    }
  }

}
