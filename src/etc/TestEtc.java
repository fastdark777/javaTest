package etc;

public class TestEtc {

	public static void main(String[] args) {
        int arr[]= new int[6];
        int tarArr[] = {1, 12, 23, 34, 39, 42};
        int i,j,k;
        int x;
        boolean success=false;
        int cnt=0;
        int successCnt=0;
        
        while(true){
        	cnt++;   
        	successCnt=0;
	       // System.out.println("* 금주의 로또 번호 *");
	       // System.out.println("-------------------------------------------------------");
	        for(i=0;i<6;i++){   // 랜덤수 6개 생성
	            x=(int)((Math.random()*45)+1);  // 랜덤함수 호출 (범위 1-45)
	            arr[i]=x;
	            for (j=0;j<i;j++){
	                if(arr[i] == arr[j]){  // 생성된 수와 이전에 저장된 수를 비교
	                    x=(int)((Math.random()*45)+1);
	                    arr[i] = x;    // 다시 수를 생성
	                    i = i - 1;    // 다시 첨부터 같은 숫자가 있는가 비교
	                    break;
	                }
	            }
	        }
	        //* 오름차순으로 정렬 */
	        for(i=0; i<6; i++){        // 정렬 조건
	            for(j=0; j<=i; j++){
	                if(arr[i]<=arr[j]){
	                    k=arr[i];
	                    arr[i]=arr[j];
	                    arr[j]=k;
	                }
	            }
	        }
	       
	        
	        for(i=0; i<6; i++){
	            for(j=0; j<6; j++){
	            	if(arr[i]==tarArr[j]){
	            		successCnt++;
	            	}
	            }
	        	
	        } 
	       if(successCnt>=2){
	    	   //* 최종 출력 */
		        for(i=0; i<6; i++){
		            System.out.print("\t"+arr[i]+"\t");
		        }        
		        System.out.println("\n--------------------------------------------------------");
		        
	    	   System.out.println(cnt);
	    	   break;
	       }
	        
        }
    }

}
