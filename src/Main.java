public class Main {
    public static void main(String[] args) throws  Exception{
        Stack st1 = new Stack();
        st1.push(4);
        st1.push(7);
        st1.push(20);
        st1.push(10);
        st1.push(9);

        /*
        StackGeneric<Integer> stG1 = new StackGeneric<Integer>(10);
        stG1.push(10);
        stG1.push(20);
        //System.out.println(stG1.isFull());
        stG1.removeItem();

        */
        System.out.println(st1.sort());
    }

    /*
    public static int[] sortStack(){

    }*/
    public static int getSmaller(Stack obj) throws Exception{
        int value = 0;

        if(obj == null)
            throw new Exception("Object is null");

        if(obj.isEmpty())
            throw new Exception("Stack is Empty");

        else{
            Stack aux = new Stack(obj.stackVetSize());
            Stack objClone = (Stack) obj.clone();

            for(int i = 0; i <= obj.getIndex();i++){
                aux.push(objClone.remove());

                if(aux.getLast() > objClone.getLast())
                    value = objClone.getLast();
                else
                    value = aux.getLast();
            }
        }
        return value;
    }

}
