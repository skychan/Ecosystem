package ecosystem;

interface SelectBehavior {
    def Evaluation(def t,def candidates)
        
    def Select(Object job,def candidates)
    
    Map Allocate(def theOnes)
    
    void Assign(def allocation,def job)
}
