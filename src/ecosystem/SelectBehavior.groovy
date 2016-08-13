package ecosystem;

interface SelectBehavior {
    def Evaluation(def candidates)
        
    def Select(Object job,def candidates)
    
    Map Allocate(def theOnes)
    
    void Assign(def allocation,def job)
}
