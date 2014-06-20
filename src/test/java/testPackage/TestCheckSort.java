package testPackage;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.util.Arrays;




public class TestCheckSort {
	
	
	
	@Parameters({"a1", "a2","a3","a4","a5"})
	@Test
	public void sort(int a1, int a2, int a3, int a4,int  a5){
	int arr[]={a1, a2, a3, a4, a5};
      int[] arr2={a1, a2, a3, a4, a5};
		
		
		
		for(int i=0;i<arr.length-1;i++){
			 for(int j=i+1;j<arr.length;j++){
			  if(arr[i]>arr[j]){
			       int tmp=arr[i];
			       arr[i]=arr[j];
			       arr[j]=tmp;
			  }
			 }
			}
//		System.out.println("Massiv ");
//		for(int i=0;i<=arr.length-1;i++){
//		System.out.print(arr[i]);
//		}
		
		System.out.println();
		Arrays.sort(arr2);
		for(int i=0;i<=arr.length-1;i++){
			System.out.print(arr2[i]);
			}
		System.out.println();
		Assert.assertEquals(arr,arr2);
	}
	
}