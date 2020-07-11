class FindSecondLargest{
    
    //return -1 if not valid
    public int findSecondBiggest(int[] input){
    	if(input == null || input.length == 0)
    	{
    		return -1;
    	}
    	if(input.length == 1)
    	{
    		return input[0];
    	}
    	int firstMaxIndex = -1;
    	int secondMaxIndex = -1;
    	for( int i=0;i<input.length; i++){
             if(firstMaxIndex == -1 || input[i]>=input[firstMaxIndex]){
             	secondMaxIndex = firstMaxIndex;
    		 	firstMaxIndex = i;
    		 }
    		 else if(secondMaxIndex == -1 || input[i]>=input[secondMaxIndex]){
    		 	 secondMaxIndex = i;
    		 }
    		 //besides, just do nothing here

    	}
    	if( secondMaxIndex != -1 )
    	{
    		//double check in case
            return input[secondMaxIndex];
    	}
    	return -1;

    }

    public void test(){
       System.out.println("begin to test");
       int[] test1={3,2,1,5,6,9,10,12};
       int[] test2={7,33,5,3,2,6,7};
       System.out.println(findSecondBiggest(test1));
       System.out.println(findSecondBiggest(test2));
    }

	public static void main(String[] args){
          
          FindSecondLargest solution = new FindSecondLargest();
          solution.test();

	}
    	
}