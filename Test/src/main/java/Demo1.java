import javax.swing.tree.TreeNode;
import java.util.*;

/**
 * @Author William
 * @Date 2022/2/18 16:26
 * @Version 1.0
 */
public class Demo1 {
    public static void main(String[] args) {

        char a='a';
        System.out.println();
        List<Integer>


    }


    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result=new ArrayList<>();
        List<Integer> current=new ArrayList<>();
        int classSum=1;
        int len=nums.length;
        while(len>0){
            classSum*=len;
            len--;
        }
        generate(result,current,nums,classSum);
        return result;
    }

    public static  void generate(List<List<Integer>> result,List<Integer> current,int[] nums,int classSum){
        if(result.size()<classSum){
            for(int i=0;i<nums.length;i++){
                if(!current.contains(nums[i])){
                    current.add(nums[i]);
                    if(current.size()==nums.length){
                        System.out.println(current.size());
                        for(int j=0;j<current.size();j++){
                            System.out.print(current.get(j) +"  ");
                        }
                        result.add(current);
                    }
                    generate(result,current,nums,classSum);
                    current.remove(current.size()-1);
                }
            }
        }
    }

    public static void quickSort(int[] arr,int L,int R){
        if(L<R){
            swap(arr,L+(int)(Math.random()*(R-L+1)),R);
            int[] p =partition(arr,L,R);
            quickSort(arr,L,p[0]-1);
            quickSort(arr,p[1]+1,R);
        }
    }

    public static int[] partition(int[] arr,int L,int R){
        int less=L-1;
        int more=R;
        while(L<more){
            if(arr[L]<arr[R]){
                swap(arr,++less,L++);
            }else if(arr[L]>arr[R]){
                swap(arr,--more,L);
            }else{
                L++;
            }
        }
        swap(arr,more,R);
        return new int[]{less+1,more};
    }

    public static void swap(int[] arr,int L,int R){
        int temp=arr[L];
        arr[L]=arr[R];
        arr[R]=temp;
    }


    public void heapSort(int[] arr){
        if(arr==null || arr.length<2){
            return ;
        }
        for(int i=0;i<arr.length;i++){
            heapInsert(arr,i);
        }
        int heapSize=arr.length;
        swap(arr,0,--heapSize);
        while (heapSize>0){
            heapify(arr,0,heapSize);
            swap(arr,0,--heapSize);
        }
    }

    public void heapify(int[] arr,int index,int heapSize){
        int left=index*2+1;
        while(left<heapSize){
            int largest=left+1<heapSize&&arr[left+1]>arr[left] ? left+1:left;
            largest=arr[largest]>arr[index]?largest:index;
            if(largest==index){
                break;
            }
            swap(arr,largest,index);
            left=index*2+1;
        }
    }

    public void heapInsert(int[] arr,int index){
        while(arr[index/2]>arr[(index-1)/2]){
            swap(arr,index,(index-1)/2);
            index=(index-1)/2;
        }
    }


}
