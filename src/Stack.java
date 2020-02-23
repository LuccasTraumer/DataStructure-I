public class Stack {
    private int[] elements;
    private int[] aux;
    private int top;

    public Stack() throws Exception{
        this(10);
    }
    public Stack(int size) throws Exception{
        if(size > 0){
            this.elements = new int[size];
            this.top = -1;
        }
        else{
            throw new Exception("Invalid Size");
        }
    }
    public int stackVetSize(){ return this.elements.length;}

    public boolean isEmpty(){ return this.top == -1;}

    public boolean isFull(){ return (this.top +1) == this.elements.length;}

    public void push(int element) throws Exception{
        if(!isFull()){
            this.top++;
            this.elements[this.top] = element;
        }
        else {
            throw new Exception("Stack is full!");
        }
    }
    public int remove() throws Exception{
        int value;
        if(!isEmpty()){
            value = this.elements[this.top];
            this.top--;
        }
        else{
            throw new Exception("Stack is Empty!");
        }
        return value;
    }
    public int getLast() throws Exception{
        if(!isEmpty())
            return this.elements[this.top];
        else
            throw new Exception("Dont exist elements on stack");
    }
    public String toString() {
        String ret = "";
        if(!isEmpty()){
            for(int i =0; i <= this.top; i++)
                ret += this.elements[i] + " ";
        }else{
            ret = "Stack is Empty!";
        }
        return ret;
    }
    public String sort() throws Exception{
        if(this.top == -1)
            throw new Exception("Stack dont has elements");
        else{
            this.aux = cloneVet();
            quickSort(0,this.top);
        }
        String ret = "";
        for (int i=0; i <= this.top;i++)
            ret += aux[i] + ", ";
        return ret;
    }
    private void quickSort(int begin, int end) {
        int pivo;
        if (begin >= end){
            return;
        }
        else {
            pivo = part(begin,end);
            quickSort(begin,pivo-1);
            quickSort(pivo+1,end);
        }
    }
    private int part(int begin,int end){
        int up,down,ref,temp;
        ref = aux[begin];
        down = begin;
        up = end;
        while (down < up){
            while(aux[down] <= ref && down < up){
                down++;
            }
            while(aux[up] > ref){
                up--;
            }
            if(down < up){
                temp = aux[down];
                aux[down] = aux[up];
                aux[up] = temp;
            }
        }
        aux[begin] = aux[up];
        aux[up] = ref;
        return up;
    }

    private int[] cloneVet() throws Exception{
        if(top == -1)
            throw new Exception("Stack is Empty");
        else{
            int[] aux = new int[this.elements.length];
            for(int i =0; i <= this.top; i++){
                aux[i] = this.elements[i];
            }
            return aux;
        }
    }

    public int getSmaller() throws Exception{
        if( this.top == -1)
            throw new Exception("Stack is Empty!");
        else{
            int value = this.elements[0];
            for(int i = 1; i <= this.top; i++) {
                if(value > this.elements[i])
                    value = this.elements[i];
            }
            return value;
        }
    }
    public int getIndex(){
        return this.top;
    }
    public Stack(Stack obj) throws Exception{
        if(obj == null)
            throw new Exception("Object is Null!");
        this.top = obj.top;

        this.elements = new int[obj.elements.length];
        if(!obj.isEmpty()){
            for (int i=0;i <= obj.getIndex();i++)
                this.elements[i] = obj.elements[i];
        }else
            throw new Exception("Stack is Empty");
    }
    public Object clone(){
        Stack ret = null;
        try{
            ret = new Stack(this);
        }
        catch(Exception err){

        }
        return ret;
    }


}
