public class Message { 
    private String id; 
    private int n; 
    private String s; 

    public Message(String id) { 
        this.id = id; 
    } 

    public String getId() { 
        return this.id; 
    } 

    public void setId(String id) { 
        this.id = id; 
    } 

    public int getN() { 
        return this.n; 
    } 

    public void setN(int n) { 
        this.n = n; 
    } 

    public String getS() { 
        return this.s; 
    } 

    public void setS(String s) { 
        this.s = s; 
    } 

    public String toString() { 
        return this.id; 
    } 
}
