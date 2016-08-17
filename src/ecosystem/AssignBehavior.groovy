package ecosystem;

public interface AssignBehavior {
    boolean BufferEnterance(Task t,Machine m)
    
    void Queue(Job j, Machine m)
    
    void Buffer(Task t, Machine m)
}
