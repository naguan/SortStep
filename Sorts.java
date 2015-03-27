import java.util.*;

public class Sorts
{
  public void bubbleSort(int[] list)
  {
    for (int outer = 0; outer < list.length - 1; outer++)
    {
      for (int inner = 0; inner < list.length-outer-1; inner++)
      {
        if (list[inner] > list[inner + 1])
        {
          int temp = list[inner];
          list[inner] = list[inner + 1];
          list[inner + 1] = temp;
        }
      }
    }
  }


  public void selectionSort(int[] list)
  {
    int flag, temp;
    for ( int outer = 0; outer < list.length -1; outer++)
    {
      flag = outer;
      for ( int inner = outer + 1; inner < list.length; inner++)
      {
        if (list[inner] < list[flag])
        {
          flag = inner;
        }
      }
      temp = list[outer];
      list[outer] = list[flag];
      list[flag] = temp;
    }
  }

  public void insertionSort(int[] list)
  {
    for (int outer = 1; outer<list.length; outer++)
    {
      int position = outer;
      int key = list[position];
      while (position > 0 && list[position-1]>key)
      {
        list[position] = list[position-1];
        position--;
      }
      key = list[position];
    }
  }

  private void merge(int[] a, int first, int mid, int last)
  {
    int[] temp = new int[a.length];
    int ai = first;
    int bi = mid+1;
    for (int i = first; i <= last ; i++)
    {
      if ( ai > mid )
      {
        temp[i] = a[bi];
        bi++;
      } else if ( bi > last ) 
      {
        temp[i] = a[ai];
        ai++;
      } else if ( a[ai] > a[bi] )
      {
        temp[i] = a[bi];
        bi++;
      } else
      {
        temp[i] = a[ai];
        ai++;
      }
    }
    for (int j = 0; j<temp.length; j++)
    {
      a[j] = temp[j];
    }
  }

  public void mergeSort(int[] a, int first, int last)
  {
    int mid = (first + last)/2;
    if (first != last)
    {
      mergeSort(a, first, mid);
      mergeSort(a, mid + 1, last);
    }
    merge(a, first, mid, last);
  }
}
