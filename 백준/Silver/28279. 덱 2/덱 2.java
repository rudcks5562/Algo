



import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

class node{
    
    node next;
    node before;
    int val;
    
    public node(node next,node before,int val){
        this.next = next;
        this.before = before;
        this.val = val;
        
        
    }
    
    
    
}


class customDq{
    
	static int size=0;
    static node first= null;
    static node last= null;
    
    
    public customDq(int size ,node first, node last){
        
    	this.size = size;
        this.first = first;
        this.last = last;
        
        
    }
    
    
    
    
    
    public static void cmd(int cmd_nums,node x, StringBuilder sb){
        
        switch(cmd_nums){
            
            case 1: // add first  V
                if(first == null && last == null){
                    
               
                    first = x;
                    last = x;
                    
                    
                    size++;
                    
                }
                else if(first!=null){
                    
                    first.before = x;
                    x.next = first;
                    
                    first = x;
                    
                    size++;
                    
                    
                }
                
                
            break;
            
            
            
            case 2:// add last  V
                if(first == null && last == null){
                    

                    first = x;
                    last = x;
                    size++;
                }
                else if(last!=null){
                    
                    last.next = x;
                    x.before = last;
                    
                    last = x;
                    
                    size++;
                    
                    
                }
                
                
            break;
            
            
            case 3: // poll first
            
            if(size==0){
                
               // System.out.println("-1");
                sb.append("-1\n");
                
            }
            else{
                
                node output = first;
                int vals = output.val;
                
                first = first.next;
                if(first !=null) {
                	first.before= null;
                }
                else if(first==null){
                	last =null;
                }
                
                
                sb.append(vals+"\n");
                
                size--;
                
               
                
            }
            
            
            
                
                
            break;
            case 4:// poll last
                
            if(size==0){
                
              //  System.out.println("-1");
                sb.append("-1\n");
                
            }
            else{
                
                node output = last;
                
                last = last.before;
                if(last!=null) {
                	  last.next= null;
                }
                else if(last==null) {
                	first = null;
                }

                
                
               // System.out.println(output.val);
                sb.append(output.val+"\n");
                size--;
                
               
                
            }
                
            break;
            case 5:// return size V
                
                //System.out.println(deque.size());
                sb.append(size+"\n");
                
                
            break;           
            
            case 6: // empty check V
                if(size==0){
                    //System.out.println("1");
                    sb.append("1\n");
                }
                else{
                   // System.out.println("0"); 
                    sb.append("0\n");
                }

                
                
            break;
            
            case 7:// peek first V
                
                if(size!=0){
                    
                  //  System.out.println(first.val);
                    sb.append(first.val+"\n");
                }
                else{
                    
                    //System.out.println("-1");
                    sb.append("-1\n");
                }
                
                
            break;
            
            case 8:// peek last V
                if(size!=0){
                    
                    //System.out.println(last.val);
                    sb.append(last.val+"\n");
                }
                else{
                    
                    //System.out.println("-1");
                    sb.append("-1\n");
                }
                
            break;
            
            
            
            
            
        }// switch end 
        
        
        
        
        
        
        
    }
    
    
}



public class Main {
    
	
	
	
    public static int N;
    public static customDq customDq;
    public static StringBuilder sb = new StringBuilder();
    
    public static void main(String args[]) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String input = br.readLine();
    
    N= Integer.parseInt(input);
    
    customDq = new customDq(0,null,null);
    
    for(int c=0;c<N;c++){
        
        input = br.readLine();
        StringTokenizer st = new StringTokenizer(input);
        
        int cmd_num = Integer.parseInt(st.nextToken());
        if(cmd_num==1|| cmd_num==2){
            
            int XX = Integer.parseInt(st.nextToken());
            
            node n= new node(null,null,XX);
            
            customDq.cmd(cmd_num,n,sb);
            
        }
        else{
            
            customDq.cmd(cmd_num,null,sb);
            
            
        }
        
        
    }
    
    System.out.println(sb);


    }
}