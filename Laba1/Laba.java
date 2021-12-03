public class Laba
{


    public static void Calculation(long[] first, double[] second) {


	double u1, u2, u3, u4, u5, u6, u7;
       
 	double x;
     
   	double[][] a = new double[10][11];
   
     
   for (int i = 0; i < a.length; i++)
	   
 	{
	        
	    for (int j = 0; j < a[i].length; j++)
	        
	    {
		       
 	 	x = second[j];
		        
		if (first[i] == 9)
		        
		{
		            
		    u1 = Math.pow(x, 3);
		            
		    u2 = 4 / u1;
		            
		    u3 = Math.pow(u2, 2);
		            
		    u4 = Math.pow(u3, 3);
		            
		    a[i][j] = u4;
	            
		}
		        
		else if (first[i] == 6 || first[i] == 8 || (first[i] >= 11 && first[i] <=13))
		        
		{
	                
		    u1 = Math.cos(x);
	                
		    u2 = Math.exp(u1);
	                
		    u3 = 4 + u2;
	                
		    u4 = 2 / 3 * u3;

	                
	                
		    u5 = Math.exp(x);
	                
		    u6 = Math.tan(u5);
	       
		    u7 = Math.pow(u4, u6);
	                
		    a[i][j] = u7;
		        
		}
	    	    
		else
	    	    
		{
		            
		    u1 = Math.cos(x);
		            
		    u2 = 3 + (Math.atan(u1));
		            
		    u3 = 0.25 / u2;
		            
		    u4 = Math.pow(u3, 2);
		            
		    u5 = Math.cos(u4);
		            
		    a[i][j] = u5;
	    	    
		}
	    	    
		System.out.printf("%.2e", a[i][j]);
	    	    
		System.out.print("\t");
	        
	    }
	        
	    System.out.println();
	   
 	}
   
    }

  
    
    ////////////////////////////////////////////////////////////////////////////
    
  
  
    public static void Fill() {
 
       
        
	long[] a = new long[10];
	    
	double[] x = new double[11];
	    
	    
	for (int i = 0; i < a.length; i++)
	    
	{
	        
	    a[i] = 15 - i;
	    
	}
		
	    
	for (int i = 0; i < x.length; i++)
	   
 	{
	        
	    x[i] = ((double)(Math.random() * 22) - 13);
	    
	}

	    
	    
	Calculation(a, x);
    
    }
    
   
 
    ////////////////////////////////////////////////////////////////////////////
 


    public static void main(String[] arg) {


	Fill();
	
    }

}
