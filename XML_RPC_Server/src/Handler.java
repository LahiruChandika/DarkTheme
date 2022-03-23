public class Handler {
    public String execute(Integer hour, Integer min, Integer sec){
        System.out.println("Got inputs: "+hour+", "+min+", "+sec);
        return "<test - server connected>";
    }
    
    public String onTime(long hour, long min , long sec) {
    	System.out.println("On Time : " + hour+ " , " + min+" , "+sec);
		return "done";
    }
    
    public String portNum(String portN) {
		System.out.println("Port number : "+portN);
		return "Port number : "+portN;
//		return "<test - server connected>";
	}
    
}