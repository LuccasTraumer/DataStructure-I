import java.lang.reflect.Method;

public class StackGeneric <X> {

    private Object[] elements;
    private int index;

    public StackGeneric(int size) throws Exception{
        if(size < 0)
            throw new Exception("Invalid Size");
        else{
            this.elements = new Object[size];
            this.index = -1;
        }
    }

    public boolean isEmpty(){ return this.index == -1;}
    public boolean isFull(){ return (this.index +1) == this.elements.length;}

    public void push(X x) throws Exception{
        if(x == null)
            throw new Exception("Object is null");
        if((this.index+1) == this.elements.length)
            throw new Exception("Stack is Full!");
        if(x instanceof  Cloneable){
            this.index++;
            this.elements[this.index] = myCloneOfX(x);
        }
        else {
            this.index++;
            this.elements[index] = x;
        }
    }
    public X getLast() throws Exception{
        if(this.index == -1)
            throw new Exception("Stack is Empty!");
        else
            return (X)this.elements[this.index];
    }
    public void removeItem() throws Exception{
        if(this.index != -1){
            this.elements[index] = null;
            index--;
        }else
            throw new Exception("Stack is Empty!");
    }

    public X myCloneOfX(X x){
        X ret = null;
        try{
            Class<?> classe = x.getClass();
            Class<?>[] tipoParms = null;
            Method metodo =  classe.getMethod("clone",tipoParms);
            Object[] params = null;
            ret = (X)metodo.invoke(x,params);
        }catch(Exception err){}
        return ret;
    }

    public String toString(){
        String ret = "";
        if(this.index == -1)
            ret = "Stack is Empty!";
        else{
            for(int i=0; i <= this.index;i++)
                ret += this.elements[i] + " ";
        }
        return ret;
    }
    public boolean equals(StackGeneric<X> x){
        if(x == null)
            return false;
        if(x == this)
            return true;
        if(this.getClass() != x.getClass())
            return false;
        StackGeneric<X> obj = (StackGeneric<X>) x;
        if(obj.index != this.index)
            return false;
        if(this.elements.length != obj.elements.length)
            return false;
        for(int i=0; i <= this.index; i++) {
            if (this.elements[i] != obj.elements[i])
                return false;
        }
        return true;
    }
    public StackGeneric(StackGeneric<X> obj) throws Exception{
        if(obj == null)
            throw new Exception("Invalid Object!");

        this.index = obj.index;
        this.elements = new Object[obj.elements.length];

        for(int i = 0; i <= obj.index;i++)
            this.elements[i] = obj.elements[i];

    }

    public Object clone(){
        StackGeneric<X> obj = null;
        try{
            obj = new StackGeneric<X>(this);
        }catch (Exception err){}
        return obj;
    }
    public int hashCode(){
        int ret = 1;
        ret = ret * 7 + new Integer(this.index).hashCode();
        if(this.index >= -1){
            for(int i = 0; i<= this.index; i++)
                ret = ret * 7 + this.elements[i].hashCode();
        }
        if(ret < 0)
            ret -= ret;

        return ret;
    }
}
