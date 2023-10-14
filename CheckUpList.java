package hms;
class CNode{
 CNode next,prev;
 CheckUp cu;

    public CNode(CheckUp cu) {
        this.cu = cu;
        next=prev=null;
    }
}
public class CheckUpList {
    CNode head,tail;

    public CheckUpList() {
        head=null;
        tail=null;
    }
    public void Enqueue(CheckUp cu){
        CNode node=new CNode(cu);
        if(head==null||tail==null){
            head=node;
            tail=node;
        }
        else if(head.cu.getPriority()<cu.getPriority()){
            tail.prev=node;
            node.next=tail;
            tail=node;
        }
        else if(tail.cu.getPriority()>=cu.getPriority()){
            tail.prev=node;
            node.next=tail;
            tail=node;
        }
        else{
            CNode temp=tail;
            while(temp!=null){
                if(temp.cu.getPriority()>=cu.getPriority()){
                    break;
                }
                temp=temp.next;
            }
        }
    }
    public CheckUp dequeue(){
        if(head==null)
            return null;
        CNode checkup=head;
        head=head.next;
        return checkup.cu;
    }
    public void Print(){
        CNode temp=head;
        while(temp!=null){
            System.out.println(temp.cu.getPriority()+"  "+temp.cu.getRecommendation());
            temp=temp.prev;
        }
    }
    public Patient getPatient(int index){
        CNode temp=head;
        int i=0;
        while(temp!=null){
            if(index==i)
                break;
            i++;
            temp=temp.prev;
          }
        return temp.cu.getPatient();
    }
    public void addRecomendation(int index,String rec){
        CNode temp=head;
        int i=0;
        while(temp!=null){
            if(index==i){
                temp.cu.setRecommendation(rec);
                break;
            }
            i++;
        }
        temp=temp.prev;
    }
     public int size(){
        CNode temp=head;
        int count=0;
        while(temp!=null){
            count++;
            temp=temp.prev;
        }
        return count;
    }
    
}
