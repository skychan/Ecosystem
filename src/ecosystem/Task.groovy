/**
 * 
 * This file was automatically generated by the Repast Simphony Agent Editor.
 * Please see http://repast.sourceforge.net/ for details.
 * 
 */

/**
 *
 * Set the package name.
 *
 */
package ecosystem

/**
 *
 * Import the needed packages.
 *
 */
import java.io.*
import java.math.*
import java.util.*
import javax.measure.unit.*
import org.jscience.mathematics.number.*
import org.jscience.mathematics.vector.*
import org.jscience.physics.amount.*
import repast.simphony.adaptation.neural.*
import repast.simphony.adaptation.regression.*
import repast.simphony.context.*
import repast.simphony.context.space.continuous.*
import repast.simphony.context.space.gis.*
import repast.simphony.context.space.graph.*
import repast.simphony.context.space.grid.*
import repast.simphony.engine.environment.*
import repast.simphony.engine.schedule.*
import repast.simphony.engine.watcher.*
import repast.simphony.groovy.math.*
import repast.simphony.integration.*
import repast.simphony.matlab.link.*
import repast.simphony.query.*
import repast.simphony.query.space.continuous.*
import repast.simphony.query.space.gis.*
import repast.simphony.query.space.graph.*
import repast.simphony.query.space.grid.*
import repast.simphony.query.space.projection.*
import repast.simphony.parameter.*
import repast.simphony.random.*
import repast.simphony.space.continuous.*
import repast.simphony.space.gis.*
import repast.simphony.space.graph.*
import repast.simphony.space.grid.*
import repast.simphony.space.projection.*
import repast.simphony.ui.probe.*
import repast.simphony.util.*
import simphony.util.messages.*
import static java.lang.Math.*
import static repast.simphony.essentials.RepastEssentials.*

/**
 *
 * This is an agent.
 *
 */
public class Task  {

    /**
     *
     * This is an agent property.
     * @field type
     *
     */
    @Parameter (displayName = "Type", usageName = "type")
    public def getType() {
        return type
    }
    public void setType(def newValue) {
        type = newValue
    }
    public def type = -1

    /**
     *
     * This is an agent property.
     * @field needResourceCapacity
     *
     */
    @Parameter (displayName = "NeedResourceCapacity", usageName = "needResourceCapacity")
    public def getNeedResourceCapacity() {
        return needResourceCapacity
    }
    public void setNeedResourceCapacity(def newValue) {
        needResourceCapacity = newValue
    }
    public def needResourceCapacity = [:]

    /**
     *
     * This is an agent property.
     * @field processingTime
     *
     */
    @Parameter (displayName = "ProcessingTime", usageName = "processingTime")
    public int getProcessingTime() {
        return processingTime
    }
    public void setProcessingTime(int newValue) {
        processingTime = newValue
    }
    public int processingTime = 0

    /**
     *
     * This is an agent property.
     * @field allocatedResource
     *
     */
    @Parameter (displayName = "Allocated Resource", usageName = "allocatedResource")
    public def getAllocatedResource() {
        return allocatedResource
    }
    public void setAllocatedResource(def newValue) {
        allocatedResource = newValue
    }
    public def allocatedResource = [:]

    /**
     *
     * This is an agent property.
     * @field remainingTime
     *
     */
    @Parameter (displayName = "RemainingTime", usageName = "remainingTime")
    public int getRemainingTime() {
        return remainingTime
    }
    public void setRemainingTime(int newValue) {
        remainingTime = newValue
    }
    public int remainingTime = -1

    /**
     *
     * Record the owners of the task
     * @field owner
     *
     */
    @Parameter (displayName = "Owners", usageName = "owner")
    public def getOwner() {
        return owner
    }
    public void setOwner(def newValue) {
        owner = newValue
    }
    public def owner = []

    /**
     *
     * the mark of the task stage
     * @field finish
     *
     */
    @Parameter (displayName = "Finish", usageName = "finish")
    public boolean getFinish() {
        return finish
    }
    public void setFinish(boolean newValue) {
        finish = newValue
    }
    public boolean finish = false

    /**
     *
     * Record the master of the task
     * @field master
     *
     */
    @Parameter (displayName = "Master", usageName = "master")
    public def getMaster() {
        return master
    }
    public void setMaster(def newValue) {
        master = newValue
    }
    public def master = []

    /**
     *
     * Record the candidates
     * @field candidates
     *
     */
    @Parameter (displayName = "Candidates", usageName = "candidates")
    public def getCandidates() {
        return candidates
    }
    public void setCandidates(def newValue) {
        candidates = newValue
    }
    public def candidates = [:]

    /**
     *
     * Record the prepare status for selected ones
     * @field prepareStatus
     *
     */
    @Parameter (displayName = "Prepare Status", usageName = "prepareStatus")
    public def getPrepareStatus() {
        return prepareStatus
    }
    public void setPrepareStatus(def newValue) {
        prepareStatus = newValue
    }
    public def prepareStatus = [:]

    /**
     *
     * Mark after the compete
     * @field inNeed
     *
     */
    @Parameter (displayName = "Need mark", usageName = "inNeed")
    public boolean getInNeed() {
        return inNeed
    }
    public void setInNeed(boolean newValue) {
        inNeed = newValue
    }
    public boolean inNeed = false

    /**
     *
     * To mark if the task is allocated or not
     * @field allocated
     *
     */
    @Parameter (displayName = "Allocated", usageName = "allocated")
    public boolean getAllocated() {
        return allocated
    }
    public void setAllocated(boolean newValue) {
        allocated = newValue
    }
    public boolean allocated = false

    /**
     *
     * This is an agent property.
     * @field startTime
     *
     */
    @Parameter (displayName = "Start time", usageName = "startTime")
    public double getStartTime() {
        return startTime
    }
    public void setStartTime(double newValue) {
        startTime = newValue
    }
    public double startTime = 0

    /**
     *
     * This is an agent property.
     * @field span
     *
     */
    @Parameter (displayName = "Span", usageName = "span")
    public int getSpan() {
        return span
    }
    public void setSpan(int newValue) {
        span = newValue
    }
    public int span = 0

    /**
     *
     * This is an agent property.
     * @field chosenTime
     *
     */
    @Parameter (displayName = "Chosen time", usageName = "chosenTime")
    public double getChosenTime() {
        return chosenTime
    }
    public void setChosenTime(double newValue) {
        chosenTime = newValue
    }
    public double chosenTime = 0

    /**
     *
     * This is an agent property.
     * @field responseTime
     *
     */
    @Parameter (displayName = "Response Time", usageName = "responseTime")
    public def getResponseTime() {
        return responseTime
    }
    public void setResponseTime(def newValue) {
        responseTime = newValue
    }
    public def responseTime = [:]

    /**
     *
     * This is an agent property.
     * @field productQuality
     *
     */
    @Parameter (displayName = "Product Quality", usageName = "productQuality")
    public double getProductQuality() {
        return productQuality
    }
    public void setProductQuality(double newValue) {
        productQuality = newValue
    }
    public double productQuality = Math.exp(200)

    /**
     *
     * This is an agent property.
     * @field hardness
     *
     */
    @Parameter (displayName = "Hardness", usageName = "hardness")
    public double getHardness() {
        return hardness
    }
    public void setHardness(double newValue) {
        hardness = newValue
    }
    public double hardness = 0

    /**
     *
     * This is an agent property.
     * @field inBufferTime
     *
     */
    @Parameter (displayName = "InBuff time", usageName = "inBufferTime")
    public def getInBufferTime() {
        return inBufferTime
    }
    public void setInBufferTime(def newValue) {
        inBufferTime = newValue
    }
    public def inBufferTime = [:]

    /**
     *
     * This is an agent property.
     * @field reviews
     *
     */
    @Parameter (displayName = "Review Result", usageName = "reviews")
    public def getReviews() {
        return reviews
    }
    public void setReviews(def newValue) {
        reviews = newValue
    }
    public def reviews = []

    /**
     *
     * This is an agent property.
     * @field finishTime
     *
     */
    @Parameter (displayName = "Finish Time", usageName = "finishTime")
    public double getFinishTime() {
        return finishTime
    }
    public void setFinishTime(double newValue) {
        finishTime = newValue
    }
    public double finishTime = 0

    /**
     *
     * This is an agent property.
     * @field readyTime
     *
     */
    @Parameter (displayName = "Ready Time", usageName = "readyTime")
    public double getReadyTime() {
        return readyTime
    }
    public void setReadyTime(double newValue) {
        readyTime = newValue
    }
    public double readyTime = 0

    /**
     *
     * This value is used to automatically generate agent identifiers.
     * @field serialVersionUID
     *
     */
    private static final long serialVersionUID = 1L

    /**
     *
     * This value is used to automatically generate agent identifiers.
     * @field agentIDCounter
     *
     */
    protected static long agentIDCounter = 1

    /**
     *
     * This value is the agent's identifier.
     * @field agentID
     *
     */
    protected String agentID = "Task " + (agentIDCounter++)

    /**
     *
     * This is the step behavior.
     * @method setParameters
     *
     */
    public void setParameters(tdata) {

        // Note the simulation time.
        def time = GetTickCountInTimeUnits()


        // This is a loop.
        for (data in tdata.value) {


            // This is an agent decision.
            if (data.key == "p") {

                // This is a task.
                this.setProcessingTime(data.value)

            } else  {

                // This is a task.
                this.needResourceCapacity << data
                this.prepareStatus[data.key] = false
                this.candidates[data.key] = []

            }

        }

        // This is a task.
        println "task para setted"
        this.setStartTime(RunEnvironment.getInstance().getCurrentSchedule().getTickCount())
        this.setType(tdata.key)
        println "start at " + this.getStartTime()
    }

    /**
     *
     * Set the owner is add to the owner list
     * @method addOwner
     *
     */
    public void addOwner(ownerID) {

        // Note the simulation time.
        def time = GetTickCountInTimeUnits()

        // add owner to the list
        this.owner << ownerID
    }

    /**
     *
     * Set the owner is add to the owner list
     * @method addMaster
     *
     */
    public void addMaster(masterID) {

        // Note the simulation time.
        def time = GetTickCountInTimeUnits()

        // add master to the list
        this.master << masterID
    }

    /**
     *
     * Select provider
     * @method Select
     *
     */
    public def Select() {


        // This is a loop.
        for (candidateResource in this.getCandidates()) {

            // This is a task.
            def theType = candidateResource.key
            def theList = candidateResource.value
            Evaluation(theList)
            // This is a task.
            this.allocatedResource[theType] = theList[0]
            theList[0].Chosen(this)

            // This is a loop.
            for (res in candidateResource.value) {

                // This is a task.
                res.compete.remove(this)

            }


        }

        // This is a task.
        this.candidates.clear()
        //println "after the selection and clear"
        this.setChosenTime(RunEnvironment.getInstance().getCurrentSchedule().getTickCount())
    }

    /**
     *
     * Supplier Evaluation
     * @method Evaluation
     *
     */
    public def Evaluation(resourceList) {

        // Define the return value variable.
        def returnValue

        // Note the simulation time.
        def time = GetTickCountInTimeUnits()

        // This is a task.
        resourceList.sort{[-it.getAvailable(),it.jobList.size()]}
        // Return the results.
        return returnValue

    }

    /**
     *
     * This is the step behavior.
     * @method addCandidates
     *
     */
    public def addCandidates(competitor) {

        // Define the return value variable.
        def returnValue

        // Note the simulation time.
        def time = GetTickCountInTimeUnits()

        // This is a task.
        this.candidates[competitor.getType()]<<competitor
        // Return the results.
        return returnValue

    }

    /**
     *
     * Check if a resource in the request
     * @method Exist
     *
     */
    public boolean Exist(tester) {

        // Define the return value variable.
        def returnValue

        // Note the simulation time.
        def time = GetTickCountInTimeUnits()

        // This is a task.
        returnValue = (tester in this.needResourceCapacity.keySet())
        // Return the results.
        return returnValue

    }

    /**
     *
     * Check the lackness of resources
     * @method CheckLackness
     *
     */
    @Watch(
        watcheeClassName = 'ecosystem.Task',
        watcheeFieldNames = 'inNeed',
        triggerCondition = '$watcher.toString() == $watchee.toString() && $watchee.inNeed',
        whenToTrigger = WatcherTriggerSchedule.LATER,
        scheduleTriggerDelta = 0.2d
    )
    public def CheckLackness(ecosystem.Task watchedAgent) {

        // Define the return value variable.
        def returnValue

        // Note the simulation time.
        def time = GetTickCountInTimeUnits()


        // This is an agent decision.
        if ([] in this.candidates.values()) {


            // This is a loop.
            for (candidateList in this.candidates.values()) {

                // This is a task.
                candidateList.each{ it.compete.remove(this)}

            }

            // This is a task.
            this.candidates.each{ it.value=[]}
            //println this.toString() + " lack of resource"

        } else  {

            // This is a task.
            //println this.candidates
            this.Select()
            this.setAllocated(true)
            // println this.toString() + " selected resources"

        }
        // Return the results.
        return returnValue

    }

    /**
     *
     * Ready to process means to reset the task status in case
     * @method Reset
     *
     */
    public def Reset() {

        // Define the return value variable.
        def returnValue

        // Note the simulation time.
        def time = GetTickCountInTimeUnits()

        // This is a task.
        this.setPrepareStatus([:])
        this.setInNeed(false)
        // Return the results.
        return returnValue

    }

    /**
     *
     * Process the task
     * @method process
     *
     */
    @Watch(
        watcheeClassName = 'ecosystem.Task',
        watcheeFieldNames = 'remainingTime',
        triggerCondition = '$watchee.equals($watcher)',
        whenToTrigger = WatcherTriggerSchedule.LATER,
        scheduleTriggerDelta = 1d
    )
    public def process(ecosystem.Task watchedAgent) {

        // Define the return value variable.
        def returnValue

        // Note the simulation time.
        def time = GetTickCountInTimeUnits()


        // This is an agent decision.
        if (this.getRemainingTime() > 0) {

            // This is a task.
            this.setRemainingTime(this.getRemainingTime()-1)

            // This is an agent decision.
            if (this.getRemainingTime() == 0) {


                // This is a loop.
                for (theRes in this.getAllocatedResource().values()) {

                    // The finish step
                    theRes.readyTask.remove(this)
                    theRes.Release(this.needResourceCapacity[theRes.getType()])
                    theRes.Next()
                    // This is a task.
                    RandomHelper.createNormal(theRes.getQuality(),1)
                    double tempQuality = RandomHelper.getNormal().nextDouble()

                    // This is an agent decision.
                    if (tempQuality < this.getProductQuality()) {

                        // This is a task.
                        this.setProductQuality(tempQuality)

                    } else  {


                    }

                }


                // This is a loop.
                for (theRes in this.getAllocatedResource().values()) {

                    // This is a task.
                    theRes.Review(this)
                    this.Review(theRes)

                }

                // This is a task.
                println this.toString() + " is finished"
                this.setFinish(true)
                this.finishTime = RunEnvironment.getInstance().getCurrentSchedule().getTickCount()
                this.span = this.finishTime - this.getStartTime()

            } else  {


            }

        } else  {


        }
        // Return the results.
        return returnValue

    }

    /**
     *
     * Repeat
     * @method Need
     *
     */
    @ScheduledMethod(
        start = 0d,
        interval = 1d,
        shuffle = true
    )
    public def Need() {

        // Define the return value variable.
        def returnValue

        // Note the simulation time.
        def time = GetTickCountInTimeUnits()


        // This is an agent decision.
        if (this.getAllocated() == false) {

            // This is a task.
            this.setInNeed(true)
            //println this.toString() + " lack response so publish need again"

        } else  {


        }
        // Return the results.
        return returnValue

    }

    /**
     *
     * Review and comment after the task is finished
     * @method Review
     *
     */
    public def Review(theRes) {

        // Define the return value variable.
        def returnValue

        // Note the simulation time.
        def time = GetTickCountInTimeUnits()

        // This is a task.
        int t = this.getReayTime() - this.inBufferTime[theRes]
        int t2 = this.getFinishTime() - this.inBufferTime[theRes]
        int q = this.needResourceCapacity[theRes.getType()] * t2
        this.reviews << Math.exp(t)*q*theRes.getRank()
        // Return the results.
        return returnValue

    }

    /**
     *
     * Check if all the candidates are ready
     * @method CheckStatus
     *
     */
    @ScheduledMethod(
        start = 0.3d,
        interval = 1d,
        shuffle = true
    )
    public def CheckStatus() {

        // Define the return value variable.
        def returnValue

        // Note the simulation time.
        def time = GetTickCountInTimeUnits()


        // This is an agent decision.
        if (!(false in this.getPrepareStatus().values() || this.getPrepareStatus().isEmpty())) {


            // This is a loop.
            for (theRes in this.allocatedResource.values()) {

                // This is a task.
                theRes.readyTask << this
                theRes.buffer.remove(this)
                // what's that

            }

            // This is a task.
            this.Reset()
            this.setRemainingTime(this.getProcessingTime())
            this.readyTime = RunEnvironment.getInstance().getCurrentSchedule().getTickCount()

        } else  {


        }
        // Return the results.
        return returnValue

    }

    /**
     *
     * This method provides a human-readable name for the agent.
     * @method toString
     *
     */
    @ProbeID()
    public String toString() {

        // Define the return value variable.
        def returnValue

        // Note the simulation time.
        def time = GetTickCountInTimeUnits()

        // Set the default agent identifier.
        returnValue = this.agentID
        // Return the results.
        return returnValue

    }


}

