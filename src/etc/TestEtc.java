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
	       // System.out.println("* ������ �ζ� ��ȣ *");
	       // System.out.println("-------------------------------------------------------");
	        for(i=0;i<6;i++){   // ������ 6�� ����
	            x=(int)((Math.random()*45)+1);  // �����Լ� ȣ�� (���� 1-45)
	            arr[i]=x;
	            for (j=0;j<i;j++){
	                if(arr[i] == arr[j]){  // ������ ���� ������ ����� ���� ��
	                    x=(int)((Math.random()*45)+1);
	                    arr[i] = x;    // �ٽ� ���� ����
	                    i = i - 1;    // �ٽ� ÷���� ���� ���ڰ� �ִ°� ��
	                    break;
	                }
	            }
	        }
	        //* ������������ ���� */
	        for(i=0; i<6; i++){        // ���� ����
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
	    	   //* ���� ��� */
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
